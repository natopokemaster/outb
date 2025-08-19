/*
 * Created on 17/08/2007
 * Project : NETCRMGesCom
 *
 * Copyright © 2007 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Net Serviços.
 *
 * $Id: ReciboRelacionamentoEJBImpl.java,v 1.9 2011/08/26 14:41:31 T0196500 Exp $
 */
package br.com.netservicos.netcrmcore.gescom.reciborelacionamento.facade.impl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.soap.SOAPElement;

import br.com.netservicos.core.bean.av.AvEventoReciboBean;
import br.com.netservicos.core.bean.av.AvEventoReciboKey;
import br.com.netservicos.core.bean.av.AvFormaEnvioBean;
import br.com.netservicos.core.bean.av.AvReciboRelacionamentoBean;
import br.com.netservicos.core.bean.av.AvTipoRelacionamentoBean;
import br.com.netservicos.core.bean.sn.SnChamadaBean;
import br.com.netservicos.core.bean.sn.SnCidadeOperadoraBean;
import br.com.netservicos.core.bean.sn.SnRelProdutoEnvioAvisoBean;
import br.com.netservicos.core.bean.sn.SnRelProdutoFormaEnvioBean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.exception.system.ResourceException;
import br.com.netservicos.gescom.util.UtilCollection;
import br.com.netservicos.gescom.util.UtilDate;
import br.com.netservicos.gescom.util.UtilObject;
import br.com.netservicos.gescom.util.UtilString;
import br.com.netservicos.gescom.util.UtilXML;
import br.com.netservicos.gescom.xml.types.recibo.EnvioType;
import br.com.netservicos.gescom.xml.types.recibo.EventoType;
import br.com.netservicos.gescom.xml.types.recibo.ProdutoServicoType;
import br.com.netservicos.gescom.xml.types.recibo.ReciboType;
import br.com.netservicos.netcrmcore.gescom.constants.GescomSQLConstants;
import br.com.netservicos.netcrmcore.gescom.constants.ReciboConstants;
import br.com.netservicos.netcrmcore.gescom.core.facade.impl.AbstractNETCRMGesComEJBImpl;
import br.com.netservicos.netcrmcore.gescom.reciborelacionamento.facade.ReciboRelacionamentoService;
import br.com.netservicos.netcrmcore.gescom.resources.NETCRMGesComResources;


/**
 * <P><B>
 * Description : Classe responsável pela geração do recibos de compra.
 * </B>
 * <BR>
 *  Componente criado apartir dos componentes: .
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>
 *                              Prior
 * Date       By                Version  Project/CSR     Description
 * ---------- --------------    -------- --------------  -----------------------
 * 06/04/2011 Leonardo Sugahara N/A      Aviso de Compra Created.
 * =============================================================================
 * </PRE>
 * @ejb.bean name="ReciboRelacionamentoEJB"
 * 		type="Stateless"
 * 		display-name="ReciboRelacionamentoEJB"
 *      description="ReciboRelacionamentoEJB Session EJB Stateless"
 *      view-type="both"
 *      jndi-name="netcrmcore/gescom/ejb/ReciboRelacionamentoEJB"
 * 		local-jndi-name="netcrmcore/gescom/ejb/local/ReciboRelacionamentoEJB"
 *		transaction-type="Container"
 *
 *
 * @ejb.interface local-extends="javax.ejb.EJBLocalObject"
 *                extends="javax.ejb.EJBObject"
 *
 * @ejb.home local-extends="javax.ejb.EJBLocalHome" extends="javax.ejb.EJBHome"
 *
 */
public class ReciboRelacionamentoEJBImpl extends AbstractNETCRMGesComEJBImpl implements ReciboRelacionamentoService{

	private static final long serialVersionUID = 5103985393029773086L;


	/**
	 * Método responsável por criar o recibo de compra.
	 * 
	 * @param bean
	 * @return
	 * @throws Exception
	 *
	 * @ejb.interface-method view-type = "both"
     * @ejb.transaction type = "Required"
     * @ejb.permission role-name = "CRIAR_RECIBO_RELACIONAMENTO"
     * 
	 */
	public Long criarReciboRelacionamento(final DynamicBean bean) throws Exception{

		final SOAPElement soapElement = (SOAPElement)bean.get(ReciboConstants.RECIBO_RELACIONAMENTO);

		String xml = UtilXML.toXMLString(soapElement.getFirstChild());
		xml = xml.trim().replaceFirst("^([\\W]+)<","<");
		final ReciboType reciboType = UtilXML.unmarshall(xml,ReciboType.class);

		bean.put(ReciboConstants.CODIGO_OPERADORA, reciboType.getCliente().getContrato().getCodigoOperadora());

		final AvTipoRelacionamentoBean tipoRelacionamentoBean = new AvTipoRelacionamentoBean();
		tipoRelacionamentoBean.setDsTipoRelacionamento(reciboType.getTipoRecibo());
		bean.put(ReciboConstants.TIPO_RELACIONAMENTO, tipoRelacionamentoBean);

		//Configura ReciboBean
		AvReciboRelacionamentoBean reciboBean = createReciboBean(reciboType, bean);

		//Lista de tipo de relacionamento
		final List<AvTipoRelacionamentoBean> tpRelList =
				super.search(GescomSQLConstants.QRY_TP_RELACIONAMENTO_POR_DESC, bean);
		reciboBean.setTipoRelacionamento(UtilCollection.getFirst(tpRelList));

		final List<ProdutoServicoType> produtoServicoList = reciboType.getItemRecibo().getVenda().getProdutoServicos();

		List<DynamicBean> formaEnvioList = null;
		final List<AvEventoReciboBean> lstEventoReciboBean = new ArrayList<AvEventoReciboBean>();
		List<SnRelProdutoFormaEnvioBean> listFormaEnvio;

		if(UtilString.isEqualsIgnoreCase(reciboType.getTipoRecibo(),ReciboConstants.TIPO_RECIBO_VENDA) &&
		   !UtilCollection.isEmpty(tpRelList)){

			List<EnvioType> listEnvioType = new ArrayList<EnvioType>();
			List<SnRelProdutoEnvioAvisoBean> listRelProdutoEnvio = null;

			for(final ProdutoServicoType produto : produtoServicoList){
				final List<EventoType> listEvento = produto.getEvento();
				bean.put(ReciboConstants.ID_PRODUTO, produto.getIdentificador());

				if(!UtilCollection.isEmpty(listEvento)){

					for(final EventoType evento: listEvento){

						// PPV
						if(evento.getTipo().equals(ReciboConstants.PPV)){
							formaEnvioList = this.getFormasEnvioPPV(bean, reciboBean, evento);
						}
						// PRODUTO
						else{
							listRelProdutoEnvio = this.search(GescomSQLConstants.QRY_ENVIOAVISO_CIDCONTR_PRODUTO, bean);
						}

						//Query PADRAO
						if (UtilCollection.isEmpty(formaEnvioList) && UtilCollection.isEmpty(listRelProdutoEnvio)){

							formaEnvioList = this.getFormasEnvioPPVPadrao(bean, reciboBean);
						}

						if(!UtilCollection.isEmpty(listRelProdutoEnvio)){
							for (final SnRelProdutoEnvioAvisoBean prodEnvio : listRelProdutoEnvio){
								listFormaEnvio = prodEnvio.getLstSnRelProdutoFormaEnvioBean();
								for (final SnRelProdutoFormaEnvioBean formaEnvio : listFormaEnvio){
									final EnvioType envioT = UtilObject.newInstance(EnvioType.class);
									envioT.setForma(formaEnvio.getCompositeKey().getFormaEnvioBean().getDsFormaEnvio());
									envioT.setOrdem(formaEnvio.getNrOrdem());
									listEnvioType.add(envioT);
								}
								produto.getEnvio().clear();
								produto.getEnvio().addAll(listEnvioType);
								listEnvioType = UtilObject.newInstance(ArrayList.class);
							}
						}else{

							if (!UtilCollection.isEmpty(formaEnvioList)){
								for(final DynamicBean dyn : formaEnvioList){
									AvFormaEnvioBean  formaEnvio = UtilObject.newInstance(AvFormaEnvioBean.class);
									formaEnvio.setIdFormaEnvio(Long.valueOf(
											dyn.get(ReciboConstants.ID_FORMA_ENVIO).toString()));
									formaEnvio = (AvFormaEnvioBean)this.findByPrimaryKey(formaEnvio);

									final EnvioType envioT = UtilObject.newInstance(EnvioType.class);
									envioT.setForma(formaEnvio.getDsFormaEnvio());
									envioT.setOrdem(Integer.valueOf(dyn.get(ReciboConstants.NR_ORDEM).toString()));

									listEnvioType.add(envioT);
								}
								produto.getEnvio().clear();
								produto.getEnvio().addAll(listEnvioType);
								listEnvioType = UtilObject.newInstance(ArrayList.class);
							}
						}
					}

					lstEventoReciboBean.addAll(this.getEventos(listEvento));
				}
			}
		}

		xml = UtilXML.marshall(reciboType);
		reciboBean.setXtDetalheRecibo(xml);
		
		List<AvEventoReciboBean> lstEventoReciboBeanNova = this.verificaSolicContemRecibos(bean, reciboBean, lstEventoReciboBean);
		//// CRMM_1410906_CI_001
		if(lstEventoReciboBeanNova.size() > 0) {
			reciboBean = (AvReciboRelacionamentoBean)getCurrentDAO().insert(reciboBean);
			this.insertEvento(reciboBean, lstEventoReciboBeanNova);

		}else {

			//Lista de tipo de relacionamento
			List tpIdRecibo = new ArrayList();
			DynamicBean paramBean = new DynamicBean();
			paramBean.put("tpEvento", lstEventoReciboBean.get(0).getCompositeKey().getTpEvento());
			paramBean.put("idEvento", lstEventoReciboBean.get(0).getCompositeKey().getIdEvento());
			paramBean.put("idTipoRelacionamento", reciboBean.getTipoRelacionamento().getIdTipoRelacionamento());
			tpIdRecibo = super.search(GescomSQLConstants.QRY_ID_RECIBO_EVENTO, paramBean);

			if (tpIdRecibo != null && tpIdRecibo.size() > 0) {
				return (Long) tpIdRecibo.get(0);
			}  
		}

		return reciboBean.getIdReciboRelacionamento();
	}

	//Verifica se a solicitação possui Recibos
	private List<AvEventoReciboBean> verificaSolicContemRecibos(final DynamicBean bean, final AvReciboRelacionamentoBean recibo, 
			final List<AvEventoReciboBean> lstEventoRecibo)throws Exception{
		
		List<AvEventoReciboBean> lstEventoReciboNova = new ArrayList<AvEventoReciboBean>();
		
		for(final AvEventoReciboBean evento : lstEventoRecibo){
			final AvEventoReciboKey eventoKey = evento.getCompositeKey();
			
			bean.put(ReciboConstants.TP_EVENTO, eventoKey.getTpEvento());
			bean.put(ReciboConstants.ID_EVENTO, eventoKey.getIdEvento());
			bean.put(ReciboConstants.ID_TIPO_RELACIONAMENTO, recibo.getTipoRelacionamento().getIdTipoRelacionamento());
			
			DynamicBean reciboBean = this.searchSqlNamedQuery(GescomSQLConstants.QRY_RECIBO_POR_EVENTO, bean, Boolean.FALSE, 
					ReciboConstants.ID_RECIBO_RELACIONAMENTO).get(ReciboConstants.ZERO);
			
			Long recibos = (Long) reciboBean.get(ReciboConstants.ID_RECIBO_RELACIONAMENTO);
			// CRMM_1410906_CI_001
			if(recibos == ReciboConstants.ZERO) {
				lstEventoReciboNova.add(evento);
			} 
		}		
		return lstEventoReciboNova;
	}
	

	// Retorna Id Recibo Relacionamento
	private List<DynamicBean> getIdReciboRelacionamento(final DynamicBean bean,
												final AvReciboRelacionamentoBean recibo,
												final EventoType evento){
		
		bean.put(ReciboConstants.TP_EVENTO, evento.getTipo());
		bean.put(ReciboConstants.ID_EVENTO, evento.getIdentificador());
		bean.put(ReciboConstants.ID_TIPO_RELACIONAMENTO, recibo.getTipoRelacionamento());

		return this.searchSqlNamedQuery(GescomSQLConstants.QRY_ID_RECIBO_EVENTO, bean, Boolean.FALSE, 
				ReciboConstants.ID_RECIBO_RELACIONAMENTO);
		
	}
	
	// Retorna formas de envio PPV
	private List<DynamicBean> getFormasEnvioPPV(final DynamicBean bean,
												final AvReciboRelacionamentoBean recibo,
												final EventoType evento){

		bean.put(ReciboConstants.CID_CONTRATO, recibo.getCidContrato());
		bean.put(ReciboConstants.TP_EVENTO, evento.getTipo());
		return this.searchSqlNamedQuery(GescomSQLConstants.QRY_FORMA_ENVIO_PPV_PADRAO, bean, Boolean.FALSE,
				ReciboConstants.ID_FORMA_ENVIO, ReciboConstants.NR_ORDEM);

	}

	// Retorna formas de envio PADRÃO
	private List<DynamicBean> getFormasEnvioPPVPadrao(final DynamicBean bean, final AvReciboRelacionamentoBean recibo){
		bean.put(ReciboConstants.CID_CONTRATO, recibo.getCidContrato());
		bean.put(ReciboConstants.TP_EVENTO, ReciboConstants.ENVIO_PADRAO);
		return this.searchSqlNamedQuery(GescomSQLConstants.QRY_FORMA_ENVIO_PPV_PADRAO, bean, Boolean.FALSE,
				ReciboConstants.ID_FORMA_ENVIO, ReciboConstants.NR_ORDEM);
	}

	//Retorna os eventos do produto
	private List<AvEventoReciboBean> getEventos(final List<EventoType> eventos){
		final List<AvEventoReciboBean> lstEventoReciboBean = new ArrayList<AvEventoReciboBean>();
		for(final EventoType eventoType : eventos){
			final AvEventoReciboBean eventoReciboBean = UtilObject.newInstance(AvEventoReciboBean.class);
			eventoReciboBean.setCompositeKey(UtilObject.newInstance(AvEventoReciboKey.class));
			eventoReciboBean.getCompositeKey().setIdEvento(Long.valueOf(eventoType.getIdentificador()));
			eventoReciboBean.getCompositeKey().setTpEvento(eventoType.getTipo());
			lstEventoReciboBean.add(eventoReciboBean);
		}
		return lstEventoReciboBean;
	}

	//Insere Evento
	private void insertEvento(final AvReciboRelacionamentoBean recibo,
							  final List<AvEventoReciboBean> lstEventoReciboBean){

		for(final AvEventoReciboBean evento : lstEventoReciboBean){
			final AvEventoReciboKey key = evento.getCompositeKey();
			key.setReciboRelacionamento(UtilObject.newInstance(AvReciboRelacionamentoBean.class));
			key.getReciboRelacionamento().setIdReciboRelacionamento(recibo.getIdReciboRelacionamento());
			this.insert(evento,super.getUserSession().getCurrentDbService());
		}

	}

	//Cria um recibo relacionamento
	private AvReciboRelacionamentoBean createReciboBean(final ReciboType reciboType, final DynamicBean bean){
		final AvReciboRelacionamentoBean reciboBean = UtilObject.newInstance(AvReciboRelacionamentoBean.class);
		final List<SnCidadeOperadoraBean> cidOperadoraList =
			super.search(GescomSQLConstants.QRY_CID_CONTR_POR_COD_OP, bean);
		final SnCidadeOperadoraBean snCidadeOperadoraBean = UtilCollection.getFirst(cidOperadoraList);
		if(cidOperadoraList != null){
			reciboBean.setCidContrato(snCidadeOperadoraBean.getCidContrato());
		}

		final SnChamadaBean chamada = UtilObject.newInstance(SnChamadaBean.class);
		chamada.setIdChamada(Long.valueOf(reciboType.getChamada()));

		reciboBean.setChamada(chamada);
		reciboBean.setNumContrato(Long.valueOf(reciboType.getCliente().getContrato().getNumeroContrato()));
		reciboBean.setDhRecibo(UtilDate.now());
		reciboBean.setStGeracaoAvisoRel(GescomSQLConstants.ATR_STATUS_GER_AVISO);

		bean.put(ReciboConstants.CID_CONTRATO, reciboBean.getCidContrato());

		final List<AvTipoRelacionamentoBean> tpRelList =
			super.search(GescomSQLConstants.QRY_TP_RELACIONAMENTO_POR_DESC, bean);
		reciboBean.setTipoRelacionamento(UtilCollection.getFirst(tpRelList));

		return reciboBean;
	}
}


