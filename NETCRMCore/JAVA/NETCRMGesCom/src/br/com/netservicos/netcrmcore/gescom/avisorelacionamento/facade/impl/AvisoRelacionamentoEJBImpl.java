/*
 * Created on 20/04/2011
 * Project : NETCRMGesCom
 * Copyright © 2011 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.netcrmcore.gescom.avisorelacionamento.facade.impl;

import static java.sql.Types.VARCHAR;
import static java.lang.Boolean.FALSE;
import static java.lang.String.format;

import static br.com.netservicos.netcrmcore.gescom.constants.GescomSQLConstants.QRY_LAYOUT_AVISO;
import static br.com.netservicos.netcrmcore.gescom.constants.GescomSQLConstants.ATR_NM_ARQUIVO;
import static br.com.netservicos.netcrmcore.gescom.constants.GescomSQLConstants.ATR_ID_LAYOUT;
import static br.com.netservicos.netcrmcore.gescom.constants.GescomSQLConstants.QRY_MOTIVO_REENVIO_POR_DESCRICAO;
import static br.com.netservicos.netcrmcore.gescom.resources.NETCRMGesComResources.RESOURCE_ERROR_ID_AVISO_INVALIDO;
import static br.com.netservicos.netcrmcore.gescom.resources.NETCRMGesComResources.RESOURCE_ERROR_MOTIVO_INVALIDO;
import static br.com.netservicos.netcrmcore.gescom.constants.AvisoConstants.ID_STATUS_PENDENTE;
import static br.com.netservicos.netcrmcore.gescom.constants.AvisoConstants.DH_GERACAO;
import static br.com.netservicos.netcrmcore.gescom.constants.AvisoConstants.MOTIVO;
import static br.com.netservicos.netcrmcore.gescom.constants.AvisoConstants.USUARIO;
import static br.com.netservicos.netcrmcore.gescom.constants.AvisoConstants.IDENTIFICADOR_AVISO;
import static br.com.netservicos.netcrmcore.gescom.constants.AvisoConstants.SIM;
import static br.com.netservicos.netcrmcore.gescom.constants.AvisoConstants.NAO;
import static br.com.netservicos.netcrmcore.gescom.constants.AvisoConstants.PARAM_POSSUI_COMBO_MULTI;
import static br.com.netservicos.netcrmcore.gescom.constants.AvisoConstants.PARAM_BASE_LOGADA;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import br.com.netservicos.gescom.util.UtilXML;
import br.com.netservicos.gescom.xml.types.aviso.AvisoType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.netservicos.framework.core.dao.BatchParameter;
import br.com.netservicos.core.bean.av.AvAvisoRelacionamentoBean;
import br.com.netservicos.core.bean.av.AvMotivoReenvioBean;
import br.com.netservicos.core.bean.av.AvReenvioAvisoBean;
import br.com.netservicos.core.bean.av.AvStatusAvisoRelacionamentoBean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.exception.system.ResourceException;
import br.com.netservicos.gescom.carta.ContentXMLReader;
import br.com.netservicos.gescom.carta.renderer.ContentRenderer;
import br.com.netservicos.gescom.carta.renderer.RendererFactory;
import br.com.netservicos.gescom.util.LogMessage;
import br.com.netservicos.gescom.util.UtilIO;
import br.com.netservicos.netcrmcore.gescom.avisorelacionamento.carta.pdf.CartaAcordoComercialBase;
import br.com.netservicos.netcrmcore.gescom.avisorelacionamento.carta.pdf.CartaAcordoComercialProspect;
import br.com.netservicos.netcrmcore.gescom.avisorelacionamento.facade.AvisoRelacionamentoService;
import br.com.netservicos.netcrmcore.gescom.core.facade.impl.AbstractNETCRMGesComEJBImpl;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe responsavel por efetuar operaçoes do Aviso Relacionamento
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 20/04/2011
 * @version 1.0
 *
 * @ejb.bean name="AvisoRelacionamentoEJB" type="Stateless" display-name="AvisoRelacionamentoEJB"
 *           description="AvisoRelacionamentoEJB Session EJB Stateless" view-type="both"
 *           jndi-name="netcrmcore/gescom/ejb/AvisoRelacionamentoEJB"
 *           local-jndi-name="netcrmcore/gescom/ejb/local/AvisoRelacionamentoEJB"
 *           transaction-type="Container"
 *
 * @ejb.interface local-extends="javax.ejb.EJBLocalObject"
 *                extends="javax.ejb.EJBObject"
 *
 * @ejb.home local-extends="javax.ejb.EJBLocalHome" extends="javax.ejb.EJBHome"
 */
public class AvisoRelacionamentoEJBImpl extends AbstractNETCRMGesComEJBImpl implements AvisoRelacionamentoService{

    /**
	 * Long.
	 */
	private static final long serialVersionUID = 458489156198189316L;

    /**
	 * Log.
	 */
	private static final Log LOG = LogFactory.getLog(AvisoRelacionamentoEJBImpl.class);

    private static final BatchParameter[] PARAM_OUT_FUNCTION = new BatchParameter[] {new BatchParameter(VARCHAR, true)};
    private static final String FUNCAO_BASE_ESCOPO = "{? = call PROD_JD.pgsms_modulo_multicidades.fcsms_base_escopo}";

    //Registra os renderizadores da carta de relacionamento
	static{
		RendererFactory.registerRenderer(CartaAcordoComercialBase.class); //PDF
		RendererFactory.registerRenderer(CartaAcordoComercialProspect.class); //PDF
	}

	/**
     * <p>
     * <b>Description:</b><br/>
     * Metodo responsavel por consultar dados do Aviso Relacionamento.
     * <p>
     *
     * @since 20/04/2011
     * @author Alessandro Mariano
     * @param dadosAviso
	 * @throws Exception
     *
     * @ejb.interface-method view-type = "both"
     * @ejb.transaction type = "Required"
     * @ejb.permission role-name = "CONSULTAR_AVISO_RELACIONAMENTO"
     */
	public Object consultarAvisoRelacionamento(final DynamicBean dadosAviso) throws Exception{

		LOG.info("Consultando Aviso de Relacionamento...");

		Object arquivoXML = "";
		final Long identificadorAviso = (Long) dadosAviso.get(IDENTIFICADOR_AVISO);

		final AvAvisoRelacionamentoBean avisoRelacionamento = this.obterAvisoRelacionamento(identificadorAviso);

		if (avisoRelacionamento != null){

			arquivoXML = avisoRelacionamento.getXtLayoutAviso();

			return arquivoXML;

		}else{

			final String mensagem = this.getMessage(RESOURCE_ERROR_ID_AVISO_INVALIDO,
					new Object[] {identificadorAviso.toString() });
			final ResourceException ex = new ResourceException(RESOURCE_ERROR_ID_AVISO_INVALIDO,
					mensagem, this.getClass().getName());
			throw ex;
		}
	}

	/**
     * <p>
     * <b>Description:</b><br/>
     * Metodo responsavel por gerar PDF dos dados do Aviso Relacionamento.
     * <p>
     *
     * @since 20/04/2011
     * @author Alessandro Mariano
     * @param dadosPDF
     *
     * @ejb.interface-method view-type = "both"
     * @ejb.transaction type = "Required"
     * @ejb.permission role-name = "GERAR_PDF_AVISO_RELACIONAMENTO"
     */
	public byte[] gerarPDFAvisoRelacionamento(final DynamicBean dadosPDF) throws Exception{

		LOG.info("Gerando PDF de Aviso de Relacionamento...");
		
		byte[] arquivoPDF;
		final Long identificadorAviso = (Long) dadosPDF.get(IDENTIFICADOR_AVISO);
		final AvAvisoRelacionamentoBean aviso = this.obterAvisoRelacionamento(identificadorAviso);
		final ContentXMLReader reader = new ContentXMLReader(aviso.getXtLayoutAviso());
		final DynamicBean parameters = new DynamicBean();
		
				
		try{
			AvisoType avisoType = UtilXML.unmarshall(aviso.getXtDetalheAviso(), AvisoType.class);

			parameters.putAll(reader.getParameters());
			reader.getParameters().put(PARAM_BASE_LOGADA, getBaseLogada());
			reader.getParameters().put(PARAM_POSSUI_COMBO_MULTI, SIM.equalsIgnoreCase(avisoType.getPossuiComboMulti()) ? SIM : NAO);

			final String nomeArquivo = this.obterLayoutCarta(parameters, aviso.getDhGeracao());
			final ContentRenderer carta = RendererFactory.getInstance().runReport(nomeArquivo, reader);
			
			arquivoPDF = UtilIO.toByteArray(carta.getContent());
		}catch(Exception e){
			throw new Exception("Erro: " + " \n " + e.getMessage() +" \n " +  aviso.getXtLayoutAviso() + "\n ");
		}

		return arquivoPDF;
	}


	/**
     * <p>
     * <b>Description:</b><br/>
     * Metodo responsavel por gerarXML dos dados do Aviso Relacionamento.
     * <p>
     *
     * @since 20/04/2011
     * @author Alessandro Mariano
     * @param dadosPDF
     *
     * @ejb.interface-method view-type = "both"
     * @ejb.transaction type = "Required"
     * @ejb.permission role-name = "GERAR_PDF_AVISO_RELACIONAMENTO"
     */
	public Object gerarXMLAvisoRelacionamento(final DynamicBean dadosPDF) {

		LOG.info("Gerando XML de Aviso de Relacionamento...");

		final Long identificadorAviso = (Long) dadosPDF.get(IDENTIFICADOR_AVISO);
		final AvAvisoRelacionamentoBean avisoRelacionamento = this.obterAvisoRelacionamento(identificadorAviso);

		if (avisoRelacionamento != null){
            return avisoRelacionamento.getXtLayoutAviso();
		}else{
			final String mensagem = this.getMessage(RESOURCE_ERROR_ID_AVISO_INVALIDO,
					new Object[] {identificadorAviso.toString()});
            throw new ResourceException(RESOURCE_ERROR_ID_AVISO_INVALIDO,
					mensagem, this.getClass().getName());
		}
	}

	/**
     * <p>
     * <b>Description:</b><br/>
     * Metodo responsavel por gerarXML dos dados do Aviso Relacionamento.
     * <p>
     *
     * @since 20/04/2011
     * @author Alessandro Mariano
     * @param dadosReenvio
     * @return Long
     * @ejb.interface-method view-type = "both"
     * @ejb.transaction type = "Required"
     * @ejb.permission role-name = "SOLICITAR_REENVIO_AVISO_RELACIONAMENTO"
     */
	public Long reenviarAvisoRelacionamento(final DynamicBean dadosReenvio) {

		LOG.info("Reenviando Aviso de Relacionamento...");

		final Long identificadorAviso = (Long) dadosReenvio.get(IDENTIFICADOR_AVISO);
		final String motivo = (String) dadosReenvio.get(MOTIVO);
		final String usuario = (String) dadosReenvio.get(USUARIO);

		final AvAvisoRelacionamentoBean avisoRelacionamento = obterAvisoRelacionamento(identificadorAviso);

		if (avisoRelacionamento != null){

			final List<AvMotivoReenvioBean> motivoReenvioList = obterMotivoReenvio(motivo);

			if ((motivoReenvioList != null) && !motivoReenvioList.isEmpty()){

				avisoRelacionamento.setStatusAviso(obterStatusAvisoRelacionamento(ID_STATUS_PENDENTE));
				this.getCurrentDAO().update(avisoRelacionamento);


				final AvReenvioAvisoBean reenvioAviso = new AvReenvioAvisoBean();
				reenvioAviso.setAvisoRelacionamento(avisoRelacionamento);
				reenvioAviso.setMotivoReenvio(motivoReenvioList.get(0));
				reenvioAviso.setDhSolicitacaoReenvio(new Date());
				reenvioAviso.setCdUsuario(usuario);

				this.getCurrentDAO().insert(reenvioAviso);

                return reenvioAviso.getIdReenvioAviso();

			}else{
				final String mensagem = this.getMessage(RESOURCE_ERROR_MOTIVO_INVALIDO,
						new Object[] {motivo});
				final ResourceException ex = new ResourceException(RESOURCE_ERROR_MOTIVO_INVALIDO,
						mensagem, this.getClass().getName());
				throw ex;
			}
		}else{

			final String mensagem = this.getMessage(RESOURCE_ERROR_ID_AVISO_INVALIDO,
					new Object[] {identificadorAviso.toString()});
			final ResourceException ex = new ResourceException(RESOURCE_ERROR_ID_AVISO_INVALIDO,
					mensagem, this.getClass().getName());
			throw ex;
		}
	}

	/**
     * <p>
     * <b>Description:</b><br/>
     * Metodo responsavel por obter o status do aviso de relacionamento.
     * <p>
     *
     * @since 20/04/2011
     * @author Alessandro Mariano
     * @param idStatusAviso ID Status Aviso.
     * @return {@link AvStatusAvisoRelacionamentoBean}
     */
	private AvStatusAvisoRelacionamentoBean obterStatusAvisoRelacionamento(final Long idStatusAviso) {

		LOG.info("Obtendo status do aviso de relacionamento...");

		final AvStatusAvisoRelacionamentoBean statusAvisoRelacionamento = new AvStatusAvisoRelacionamentoBean();
		statusAvisoRelacionamento.setIdStatusAvisoRel(idStatusAviso);

		return (AvStatusAvisoRelacionamentoBean) super.findByPrimaryKey(statusAvisoRelacionamento);
	}

	/**
     * <p>
     * <b>Description:</b><br/>
     * Metodo responsavel por obter motivo de reenvio do aviso de relacionamento.
     * <p>
     *
     * @since 20/04/2011
     * @author Alessandro Mariano
     * @param motivo Motivo do Aviso.
     * @return List<AvMotivoReenvioBean>
     */
	@SuppressWarnings("unchecked")
	private List<AvMotivoReenvioBean> obterMotivoReenvio(final String motivo) {

		LOG.info("Obtendo motivo de reenvio do aviso de relacionamento...");

		final DynamicBean dadosMotivo = new DynamicBean();
		dadosMotivo.put(MOTIVO, motivo);

		LOG.debug(LogMessage.queryBefore(QRY_MOTIVO_REENVIO_POR_DESCRICAO));
		final List<AvMotivoReenvioBean> list = super.search(QRY_MOTIVO_REENVIO_POR_DESCRICAO, dadosMotivo);
		LOG.debug(LogMessage.queryAfter(QRY_MOTIVO_REENVIO_POR_DESCRICAO, list));

		return list;
	}


	/**
	 * <p>
	 * <b>Description:</b><br/>
	 * Obtem o aviso de relacionamento.
	 * <p>
	 *
	 * @param idAviso ID do Aviso.
	 * @since 22/03/2011
	 * @return {@link AvAvisoRelacionamentoBean}
	 */
	private AvAvisoRelacionamentoBean obterAvisoRelacionamento(final Long idAviso){
		LOG.info(format("Obtendo o aviso de relacionamento. ID: %d", idAviso));
		return (AvAvisoRelacionamentoBean)
			this.getCurrentDAO().findByPrimaryKey(AvAvisoRelacionamentoBean.class, idAviso);
	}
	
	/**
	 * Método responsável por retornar a base logada.
     * (Alteração para executar a função de banco diretamente ao invés de executar uma query) - CRMP_148777_NI_001.
	 * @return A base logada CLARO ou NET.
	 * @since 20/05/2018
	 * @author diogo.vsantos
	 */
	private String getBaseLogada() {
        try{
            LOG.info("Verificando a base logada");
            final List result = getCurrentDAO().executeBatch(FUNCAO_BASE_ESCOPO, PARAM_OUT_FUNCTION);
            return (String) result.get(0);
        }catch(Exception e){
            LOG.info("Erro ao verificar a base logada: \n" + e.getMessage());
            return null;
        }
	}

	/**
	 * <p>
	 * <b>Description:</b><br/>
	 *  Obtem qual o layout de acordo comercial vigente no mesmo periodo.
	 * <p>
	 *
	 * @param parameters Parametros.
	 * @param pDhGeracao Data e Hora da geração.
	 */
	private String obterLayoutCarta(final DynamicBean parameters, final Date pDhGeracao){
		parameters.put(DH_GERACAO, pDhGeracao);
		LOG.debug(LogMessage.queryBefore(QRY_LAYOUT_AVISO));
		final List<DynamicBean> list = this.searchSqlNamedQuery(QRY_LAYOUT_AVISO, parameters,
				FALSE, ATR_ID_LAYOUT, ATR_NM_ARQUIVO);
		LOG.debug(LogMessage.queryAfter(QRY_LAYOUT_AVISO, list));
		if(!list.isEmpty()){
			return (String) list.get(0).get(ATR_NM_ARQUIVO);
		}
		return null;
	}

}
