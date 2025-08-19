/*
 * Created on 20/01/2005
 *
 * Copyright © 2004 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.netcrmcore.cliente.core.facade.impl;

import java.math.BigDecimal;
import java.sql.Types;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import br.com.netservicos.core.bean.cp.CpCidadeOperadoraBean;
import br.com.netservicos.core.bean.cp.CpContratoDuplicidadeBean;
import br.com.netservicos.core.bean.cp.CpPendenciasBean;
import br.com.netservicos.core.bean.cp.CpPropostaBean;
import br.com.netservicos.core.bean.cp.CpProspectBean;
import br.com.netservicos.core.bean.cp.CpRelPendenciaPropostaBean;
import br.com.netservicos.core.bean.cp.CpRelPendenciasVariacoesBean;
import br.com.netservicos.core.bean.cp.CpScpcPropostaBean;
import br.com.netservicos.core.bean.cp.CpStatusPropostaBean;
import br.com.netservicos.core.bean.sn.SnCidadeBaseBean;
import br.com.netservicos.core.bean.sn.SnStatusContratoBean;
import br.com.netservicos.core.bean.sn.SnTipoPessoaBean;
import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.core.dao.BatchParameter;
import br.com.netservicos.framework.core.dao.DAO;
import br.com.netservicos.framework.service.webservice.WebServiceFactory;
import br.com.netservicos.framework.util.exception.BaseFailureException;
import br.com.netservicos.netcrmcore.cliente.constants.CreditoConstants;
import br.com.netservicos.netcrmcore.cliente.constants.ManutencaoDadosCobrancaContants;
import br.com.netservicos.netcrmcore.cliente.core.facade.CreditoService;
import br.com.netservicos.netcrmcore.geral.constants.GeralConstants;
import br.com.netservicos.netcrmcore.geral.util.GeralUtil;
import br.com.netservicos.netvenda.axis2.ws.types.consultaserasa.AnalisarCredito;
import br.com.netservicos.netvenda.axis2.ws.types.consultaserasa.AnalisarCreditoResponse;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>
 * =============================================================================
 * Description                             Date        By
 * --------------------------------------- ----------- -------------------------
 *
 * =============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * =============================================================================
 *                               Prior
 * Date       By                Version  Project/CSR    Description
 * ---------- ----------------- -------- -------------- ---------------------------
 * 15/09/2010 Wellington Maeda  N/A      NETComponentes Created.  
 * =============================================================================
 * </PRE>
 *
 * EJB responsável pela Checagem de Crédito
 * 
 * @author gmello@artit.com.br
 * 
 * @ejb.bean name="CreditoEJB" type="Stateless" display-name="CreditoEJB"
 *           description="CreditoEJB Session EJB Stateless" view-type="both"
 *           jndi-name="netcrmcore/cliente/ejb/CreditoEJB"
 *           local-jndi-name="netcrmcore/cliente/ejb/local/CreditoEJB"
 *           transaction-type="Container"
 * 
 * @ejb.interface local-extends="javax.ejb.EJBLocalObject"
 *                extends="javax.ejb.EJBObject"
 * 
 * @ejb.home local-extends="javax.ejb.EJBLocalHome" extends="javax.ejb.EJBHome"
 * 
 */
public class CreditoEJBImpl extends AbstractNETCRMClienteEJBImpl implements CreditoService {

    private static final long serialVersionUID = 3257565126759559221L;
    
    private static final String ATIVAR_CONWEB_SER = "0";
    
    private static final String PROC_STA_CRED_APR = "S";
    private static final String PROC_STA_CRED_REP = "N";
    private static final String PROC_STA_AGU_SCPC = "E";
    private static final String PROC_STA_ERRO_CON = "A";
    private static final Integer CONSTANT_8 = 8;
 

	/**
	 * Verifica Pendências de FRAUDE EMBRATEL e Pendências de duplicidade de CPF/CNPJ
     *
	 * @param dbProspect
	 * @return boolean
	 */
	private boolean verificaPendencias(final CpProspectBean dbProspect) {

		 boolean retorno = false;
		 final DynamicBean dynaBean = new DynamicBean();
		 dynaBean.set(CreditoConstants.ID_PROPOSTA, dbProspect.getProposta().getIdProposta());

		 //verifica se já existem pedênicas nas tabelas para não haver duplicidade
		 final List listDuplEmbratel = super.search(CreditoConstants.LST_PEND_EMBRATEL, dynaBean);

     	 // Using Map for better performance.
     	 final HashMap<Long, CpContratoDuplicidadeBean> mapContratos = 
     	     new HashMap<Long, CpContratoDuplicidadeBean>();
     	 for (Object objBean : super.search(CreditoConstants.LST_DUPL_PROPOSTA, dynaBean)) {
		     final CpContratoDuplicidadeBean bean = (CpContratoDuplicidadeBean) objBean;
		     mapContratos.put(bean.getNumContrato(), bean);
     	 }

		 if (!CollectionUtils.isEmpty(listDuplEmbratel)) {
			if (Integer.valueOf("1").equals(listDuplEmbratel.size())){
				 final CpRelPendenciaPropostaBean pendenciaProposta = new CpRelPendenciaPropostaBean();
				 final CpPendenciasBean cpPendencia = new CpPendenciasBean();
				 final Object[] obj = (Object[]) listDuplEmbratel.get(0);

				 pendenciaProposta.setIdRelPendenciaProposta((Long) obj[0]);
				 cpPendencia.setIdPendencia((Long) obj[1]);
				 pendenciaProposta.setPendencia(cpPendencia);
				 pendenciaProposta.setProposta(dbProspect.getProposta());

				 super.delete(pendenciaProposta, getUserSession().getCurrentDbService());

			} else {
				for(int i = 0; i < listDuplEmbratel.size(); i++) {
					 final CpRelPendenciaPropostaBean cpRelPendencia = new CpRelPendenciaPropostaBean();
					 final CpPendenciasBean cpPendencia = new CpPendenciasBean();
					 final Object[] obj = (Object[]) listDuplEmbratel.get(i);

					 cpRelPendencia.setIdRelPendenciaProposta((Long) obj[0]);
					 cpPendencia.setIdPendencia((Long) obj[1]);
					 cpRelPendencia.setPendencia(cpPendencia);
					 cpRelPendencia.setProposta(dbProspect.getProposta());

					 super.delete(cpRelPendencia, getUserSession().getCurrentDbService());
				}
			}
		 }

		 final GregorianCalendar date = new GregorianCalendar();
	     date.set(Calendar.HOUR_OF_DAY, 0);
	     date.set(Calendar.MINUTE, 0);
	     date.set(Calendar.SECOND, 0);
	     date.set(Calendar.MILLISECOND, 0);

	    final DynamicBean dynamicBean = new DynamicBean();
        //verifica Pendências de FRAUDE EMBRATEL
        List listPendencias;
        if (GeralUtil.isNull(dbProspect.getCpf()))
        	dbProspect.setCpf(Long.valueOf(0));

        if (Long.valueOf("0").equals(dbProspect.getCpf())) {
        	dynamicBean.set(CreditoConstants.CNPJ, String.format("%014d", dbProspect.getCnpj()));
            listPendencias = this.search(CreditoConstants.LST_PEND_FRAUDE_EMBR_CNPJ, dynamicBean);
        } else {
            dynamicBean.set(CreditoConstants.CPF, String.format("%011d", dbProspect.getCpf()));
            listPendencias = this.search(CreditoConstants.LST_PEND_FRAUDE_EMBR_CPF, dynamicBean);
        	
        }
      //Recupera de acordo com a cidade o parametro para verificar a black list.
        List lisBlackList = null;
        if(!GeralUtil.isNull(dbProspect) && !GeralUtil.isNull(dbProspect.getCidadeOperadora()) 
                                                && !GeralUtil.isNull(dbProspect.getCidadeOperadora().getSnCidade()))
        	lisBlackList = super.search(CreditoConstants.LST_PARAN_VERIFICA_BLACK_LIST,
        	                                        dbProspect.getCidadeOperadora().getSnCidade());
        String veriBlackList = "";
        if(!CollectionUtils.isEmpty(lisBlackList))
        	veriBlackList = String.valueOf((BigDecimal)lisBlackList.get(0)); 
        		
        if (!listPendencias.isEmpty() && veriBlackList.equals(CreditoConstants.PESQUISA_BLACK_LISTA_ATIVA)) {
        	final CpRelPendenciaPropostaBean pendProposta = new CpRelPendenciaPropostaBean();
        	final CpPendenciasBean cpPendencia = new CpPendenciasBean(CreditoConstants.PENDENTE_INSTALACAO);
            final CpRelPendenciasVariacoesBean pendVariacoes = new 
            		CpRelPendenciasVariacoesBean(CreditoConstants.PENDENCIA_VARIACAO_18);
            pendProposta.setUsuario(getUserSession().getUserId());
            pendProposta.setDtAbertura(date.getTime());
            pendProposta.setPendenciaVariacao(pendVariacoes);
            pendProposta.setPendencia(cpPendencia);
            pendProposta.setProposta(dbProspect.getProposta());

            // Adiciona a pendencia na proposta
            dbProspect.getProposta().getPendenciasProposta().add(pendProposta);
            dbProspect.getProposta().setStatusProposta(new CpStatusPropostaBean(CreditoConstants.STATUS_PENDENTE));

        	super.insert(pendProposta, getUserSession().getCurrentDbService());

        	retorno = true;
        }

        //verifica Pendências de duplicidade de CPF/CNPJ
        List listDuplicidade;
        
        if (!GeralUtil.isNull(dbProspect.getCpf()) && !Long.valueOf("0").equals(dbProspect.getCpf())) {
        	dynamicBean.set(CreditoConstants.CPF, String.format("%011d", dbProspect.getCpf()));
        	listDuplicidade = this.listDuplicidades(CreditoConstants.LST_DUPLICIDADE_CPF, dynamicBean);
        } else {
        	dynamicBean.set(CreditoConstants.CNPJ, String.format("%014d", dbProspect.getCnpj()));
        	listDuplicidade = this.listDuplicidades(CreditoConstants.LST_DUPLICIDADE_CNPJ, dynamicBean);
        }
        
        //Recupera de acordo com a cidade o parametro para verificar a black list.
        List listVerDuplCpf = null;
        if(!GeralUtil.isNull(dbProspect) && !GeralUtil.isNull(dbProspect.getCidadeOperadora()) && !GeralUtil.isNull(dbProspect.getCidadeOperadora().getSnCidade()))
        	listVerDuplCpf = super.search(CreditoConstants.LST_PARAN_VERIFICA_DUPLICIDADE_CPF, 
        	                                        dbProspect.getCidadeOperadora().getSnCidade());
        String duplicidadeCpf = "";
        if(!CollectionUtils.isEmpty(listVerDuplCpf)){
        	duplicidadeCpf = String.valueOf((BigDecimal)listVerDuplCpf.get(0)); 
        }
        
        if (duplicidadeCpf.equals(CreditoConstants.
                                                PESQUISA_DUPLIDADE_CPF_ATIVA) && !listDuplicidade.isEmpty()) {

        	final CpRelPendenciaPropostaBean pendencia = new CpRelPendenciaPropostaBean();
        	final CpPendenciasBean cpPendencia = new CpPendenciasBean(CreditoConstants.PENDENCIA_VARIACAO_19);
            final CpRelPendenciasVariacoesBean variacoes =
            		new CpRelPendenciasVariacoesBean(CreditoConstants.PENDENCIA_VARIACAO_29);
            pendencia.setUsuario(getUserSession().getUserId());
            pendencia.setDtAbertura(date.getTime());
            pendencia.setPendenciaVariacao(variacoes);
            pendencia.setPendencia(cpPendencia);
            pendencia.setProposta(dbProspect.getProposta());

            // Adiciona a pendencia na proposta
            dbProspect.getProposta().getPendenciasProposta().add(pendencia);
            dbProspect.getProposta().setStatusProposta(new CpStatusPropostaBean(CreditoConstants.STATUS_PENDENTE)); 

        	super.insert(pendencia, getUserSession().getCurrentDbService());

        	SnStatusContratoBean snStatusBean = null;
        	CpContratoDuplicidadeBean duplicidade = null;
        	for(int i = 0; i < listDuplicidade.size(); i++) {

        		final Object[] obj = (Object[]) listDuplicidade.get(i);
	        	snStatusBean = (SnStatusContratoBean) getCurrentDAO()
	        	.find(SnStatusContratoBean.class, (Integer)obj[CreditoConstants.CONSTANT_03]);

	        	final Long numContrato = (Long) obj[0];
	        	duplicidade = mapContratos.remove(numContrato);
	        	if (duplicidade == null) {
	        	    
	        	    duplicidade = new CpContratoDuplicidadeBean();
                    duplicidade.setNumContrato(numContrato);
                    duplicidade.setNmCidade((String)obj[1]);
                    duplicidade.setNmAssinante((String)obj[2]);
                    duplicidade.setDsStatus(snStatusBean.getDescricao());
                    duplicidade.setIdPendencia(Long.valueOf(CreditoConstants.PENDENCIA_VARIACAO_19));
                    duplicidade.setIdCidade(dbProspect.getProposta().getCidadeOperadora().getIdCidade());
                    duplicidade.setProposta(dbProspect.getProposta());
                    //
                    super.insert(duplicidade, getUserSession().getCurrentDbService());
	        	    
	        	} else {                
	                
	                final String dsStatus = duplicidade.getDsStatus();
                    // Update only if the Status is different
                    if (!GeralUtil.isNull(dsStatus) && !dsStatus.equals(snStatusBean.getDescricao())) {
                        duplicidade.setDsStatus(snStatusBean.getDescricao());
                        super.update(duplicidade, getUserSession().getCurrentDbService());
                    }
	        	}
        	}
        }
        // Deleting records that can be the other CPF or CNPJ
        for (CpContratoDuplicidadeBean cpContratoDuplicidade : mapContratos.values()) {
            super.delete(cpContratoDuplicidade, getUserSession().getCurrentDbService());
        }

        return retorno;
	}
    /**
     * Consulta o credito interno e externo do prospect informado.
     *
	 * @ejb.interface-method view-type = "both"
	 * @ejb.transaction type="Required"
	 * @ejb.permission role-name="CRM_CHECAR_CREDITO_INTERNO"
     *
	 *
     * @param dados
     * @return status do credito
     */
    public DynamicBean checarCreditoInterno(final DynamicBean dados) {
    	
        final DynamicBean retorno = new DynamicBean();
    	
    	CpProspectBean dbProspect = new CpProspectBean();
    	dbProspect.setIdProspect( (Long) dados.get(CreditoConstants.ID_PROSPECT));
    	dbProspect = (CpProspectBean) super.findByPrimaryKey(dbProspect);
    	
    	if(GeralUtil.isNull(dbProspect)){
    	    retorno.put("error", true);
    	    return retorno;
    	}
    	
    	dbProspect.setCpf((Long) dados.get(CreditoConstants.CPF));
    	dbProspect.setCnpj((Long) dados.get(CreditoConstants.CNPJ));
    	dbProspect.setIdTipoPessoa((Integer) dados.get(CreditoConstants.ID_TIPO_PESSOA));
                
        final Integer verifiCredito = validarCreditoInterno(dbProspect);
       
        retorno.put(CreditoConstants.RETORNO, verifiCredito);
        retorno.put(CreditoConstants.VERIFICACAO_CREDITO, setStatusCredito(verifiCredito));
        
        return retorno;
    }
    
    /**
     * Busca o prospect pelo idProspect e invoca o validador do crédito
     *
     * @ejb.interface-method view-type = "both"
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="CRM_CHECAR_CREDITO_EXTERNO"
     *
     *
     * @param dados
     * @return status do credito
     */
    public DynamicBean checarCreditoExterno(final DynamicBean dados){
        
        final DynamicBean retorno = new DynamicBean();
        
        CpProspectBean dbProspect = new CpProspectBean();
        dbProspect.setIdProspect( (Long) dados.get(CreditoConstants.ID_PROSPECT));
        dbProspect = (CpProspectBean) super.findByPrimaryKey(dbProspect);
        
        if(GeralUtil.isNull(dbProspect)){
            retorno.put("error", true);
            return retorno;
        }
        
        dbProspect.setCpf((Long) dados.get(CreditoConstants.CPF));
        dbProspect.setCnpj((Long) dados.get(CreditoConstants.CNPJ));
        dbProspect.setIdTipoPessoa((Integer) dados.get(CreditoConstants.ID_TIPO_PESSOA));
        
        // Consome o WebService do Serasa
        consomeWebServiceSerasa(dados);
                
        final Integer verifiCredito = validarCreditoExterno(dbProspect);
       
        retorno.put(CreditoConstants.RETORNO, verifiCredito);
        retorno.put(CreditoConstants.VERIFICACAO_CREDITO, setStatusCredito(verifiCredito));
        
        return retorno;
    }
    
    
    /**
     * Coloca a string que será exibida para usuário
     * 
     * @param status
     * @return String
     */
    private String setStatusCredito(final Integer status) {
        
    	String statusCredito = "";

    	if(status.equals(CreditoConstants.STATUS_APROVADO)){
    		statusCredito = CreditoConstants.CREDITO_APROVADO;
    	}else if(status.equals(CreditoConstants.STATUS_REPROVADO)){
    		statusCredito = CreditoConstants.CREDITO_REPROVADO;
    	}else if(status.equals(CreditoConstants.STATUS_ERRO_CONSULTA_SCPC)){
    		statusCredito = CreditoConstants.PROB_CONS_SCPC;
    	}else if(status.equals(CreditoConstants.STATUS_VALIDANDO)){
    	    statusCredito = CreditoConstants.VALIDANDO;
    	}
        return statusCredito;
    }

    /**
     * Consulta o credito interno do prospect informado
     * 
     * @param dbProspect
     * @return Integer
     */
    private Integer validarCreditoInterno(final CpProspectBean dbProspect) {
                        
        final CpPropostaBean dbProposta = dbProspect.getProposta();

        final int tpPessoa = dbProspect.getIdTipoPessoa().intValue();
        if (dbProspect.getEstrangeiro() == null) {
        	dbProspect.setEstrangeiro(Integer.valueOf("0"));
        }
        final int estrangeiro = dbProspect.getEstrangeiro().intValue();

        String statusExterno = null;
        int statusInterno = Integer.MIN_VALUE;

        if (tpPessoa == SnTipoPessoaBean.TP_FISICA) {
            // pessoa fisica

        	final int cpf = dbProspect.getCpf().intValue();
        	/**
        	 *  Se for estrangeiro e não possuir CPF
        	 */
        	if (estrangeiro == 1 && cpf == 0) {
                delPendencia(CreditoConstants.DOCUMENTO_PENDENTE, dbProposta);
                delPendencia(CreditoConstants.ERROR_SPC, dbProposta);
                geraPendencia(dbProposta, CreditoConstants.DOCUMENTO_PENDENTE, CreditoConstants.CONSTANT_23, "");
            }
        	/**
        	 * Se for estrageiro e possuir CPF
        	 */
        	else if (estrangeiro == 1 && cpf != 0) {
            	  delPendencia(CreditoConstants.DOCUMENTO_PENDENTE, dbProposta);
            }else if(estrangeiro == 0 && cpf == 0){
                delPendencia(CreditoConstants.DOCUMENTO_PENDENTE, dbProposta);
                 delPendencia(CreditoConstants.ERROR_SPC, dbProposta);
                geraPendencia(dbProposta, CreditoConstants.DOCUMENTO_PENDENTE, CreditoConstants.CONSTANT_23, "");
            } else if (estrangeiro == 0) {
                delPendencia(CreditoConstants.DOCUMENTO_PENDENTE, dbProposta);
            }

            statusInterno = updateStatusCreditoInterno(dbProspect);
        } else if (tpPessoa == SnTipoPessoaBean.TP_JURIDICA) {
            delPendencia(CreditoConstants.DADOS_INCONSISTENTES, dbProposta);
            delPendencia(CreditoConstants.DOCUMENTO_PENDENTE, dbProposta);
            delPendencia(CreditoConstants.ERROR_SPC, dbProposta);
            //NSLM_922415_CI_014 - inicio
            delPendencia(CreditoConstants.AGUARDANDO_SPC, dbProposta);
            delPendencia(CreditoConstants.BLACK_LIST_EBT, dbProposta);
            delPendencia(CreditoConstants.DUPLICIDADE , dbProposta);
            delPendencia(CreditoConstants.VERIFICACAO_CREDITO_EXTERNO, dbProposta);
            delPendencia(CreditoConstants.CREDITO_EXTERNO, dbProposta);
            delPendencia(CreditoConstants.VERIFICACAO_CREDITO_INTERNO, dbProposta);
            delPendencia(CreditoConstants.CREDITO_INTERNO, dbProposta);
            //NSLM_922415_CI_014 - fim
            // pessoa juridica
            if (!GeralUtil.isNull(dbProspect.getCnpj())) {
                statusInterno = updateStatusCreditoInterno(dbProspect);
            }
        }

        //verifica Pendências de FRAUDE EMBRATEL e Pendências de duplicidade de CPF/CNPJ
        int pendenciaEmbratel = 0;
        if (verificaPendencias(dbProspect)) {
        	pendenciaEmbratel = 1;
        }

        return verificaChecagemIntExt(statusExterno, statusInterno, pendenciaEmbratel);
    }
    
    /**
     * Consulta o credito externo do prospect informado
     *
     *
     * @param bean Prospect
     * @return Integer
     */
    private Integer validarCreditoExterno(final CpProspectBean dbProspect) {
                        
        final CpPropostaBean dbProposta = dbProspect.getProposta();

        final int tpPessoa = dbProspect.getIdTipoPessoa().intValue();
        if (dbProspect.getEstrangeiro() == null) {
            dbProspect.setEstrangeiro(Integer.valueOf("0"));
        }
        final int estrangeiro = dbProspect.getEstrangeiro().intValue();

        String statusExterno = null;
        final int statusInterno = Integer.valueOf("1");

        if (tpPessoa == SnTipoPessoaBean.TP_FISICA) {
            // pessoa fisica

            final int cpf = dbProspect.getCpf().intValue();
            /**
             *  Se for estrangeiro e não possuir CPF
             *   
             */
            if (estrangeiro == 1 && cpf == 0) {
                delPendencia(CreditoConstants.DOCUMENTO_PENDENTE, dbProposta);
                delPendencia(CreditoConstants.ERROR_SPC, dbProposta);
                geraPendencia(dbProposta, CreditoConstants.DOCUMENTO_PENDENTE, CreditoConstants.CONSTANT_23, "");
            }                       
            /**
             * Se for estrageiro e possuir CPF
             */
            else if (estrangeiro == 1 && cpf != 0) {
                  delPendencia(CreditoConstants.DOCUMENTO_PENDENTE, dbProposta);
                  statusExterno = checkCreditoExterno(dbProspect);
            }else if(estrangeiro == 0 && cpf == 0){
                delPendencia(CreditoConstants.DOCUMENTO_PENDENTE, dbProposta);
                 delPendencia(CreditoConstants.ERROR_SPC, dbProposta);
                geraPendencia(dbProposta, CreditoConstants.DOCUMENTO_PENDENTE, CreditoConstants.CONSTANT_23, "");
            } else if (estrangeiro == 0) {
                delPendencia(CreditoConstants.DOCUMENTO_PENDENTE, dbProposta);
                statusExterno = checkCreditoExterno(dbProspect);
            }
        } 

        //verifica Pendências de FRAUDE EMBRATEL e Pendências de duplicidade de CPF/CNPJ
        int pendenciaEmbratel = 0;
        if (verificaPendencias(dbProspect)) {
            pendenciaEmbratel = 1;
        }

        return verificaChecagemIntExt(statusExterno, statusInterno, pendenciaEmbratel);
    }
    
    
    
    /**
     *Consulta o credito interno e externo do prospect informado
     *
     *
     * @param bean Prospect
     * @return status do credito
     */
    private Integer validarCreditoInternoExterno(final CpProspectBean dbProspect) {
        
        final CpPropostaBean dbProposta = dbProspect.getProposta();

        final int tpPessoa = dbProspect.getIdTipoPessoa().intValue();
        if (GeralUtil.isNull(dbProspect.getEstrangeiro())) {
            dbProspect.setEstrangeiro(Integer.valueOf("0"));
        }
        final int estrangeiro = dbProspect.getEstrangeiro().intValue();

        String statusExterno = null;
        int statusInterno = Integer.MIN_VALUE;

        if (tpPessoa == SnTipoPessoaBean.TP_FISICA) {
            // pessoa fisica

            final int cpf = dbProspect.getCpf().intValue();
            /**
             *  Se for estrangeiro e não possuir CPF
             *   
             */
            if (estrangeiro == 1 && cpf == 0) {
                delPendencia(CreditoConstants.DOCUMENTO_PENDENTE, dbProposta);
                delPendencia(CreditoConstants.ERROR_SPC, dbProposta);
                geraPendencia(dbProposta, CreditoConstants.DOCUMENTO_PENDENTE, CreditoConstants.CONSTANT_23, "");
            }
            /**
             * Se for estrageiro e possuir CPF
             */
            else if (estrangeiro == 1 && cpf != 0) {
                  delPendencia(CreditoConstants.DOCUMENTO_PENDENTE, dbProposta);
                  statusExterno = checkCreditoExterno(dbProspect);
            }else if(estrangeiro == 0 && cpf == 0){
                delPendencia(CreditoConstants.DOCUMENTO_PENDENTE, dbProposta);
                 delPendencia(CreditoConstants.ERROR_SPC, dbProposta);
                geraPendencia(dbProposta, CreditoConstants.DOCUMENTO_PENDENTE, CreditoConstants.CONSTANT_23, "");
            } else if (estrangeiro == 0) {
                delPendencia(CreditoConstants.DOCUMENTO_PENDENTE, dbProposta);
                statusExterno = checkCreditoExterno(dbProspect);
            }

            statusInterno = updateStatusCreditoInterno(dbProspect);
        } else if (tpPessoa == SnTipoPessoaBean.TP_JURIDICA) {
            delPendencia(CreditoConstants.DADOS_INCONSISTENTES, dbProposta);
            delPendencia(CreditoConstants.DOCUMENTO_PENDENTE, dbProposta);
            delPendencia(CreditoConstants.ERROR_SPC, dbProposta);
            //NSLM_922415_CI_014 - inicio
            delPendencia(CreditoConstants.AGUARDANDO_SPC, dbProposta);
            delPendencia(CreditoConstants.BLACK_LIST_EBT, dbProposta);
            delPendencia(CreditoConstants.DUPLICIDADE , dbProposta);
            delPendencia(CreditoConstants.VERIFICACAO_CREDITO_EXTERNO, dbProposta);
            delPendencia(CreditoConstants.CREDITO_EXTERNO, dbProposta);
            delPendencia(CreditoConstants.VERIFICACAO_CREDITO_INTERNO, dbProposta);
            delPendencia(CreditoConstants.CREDITO_INTERNO, dbProposta);
            //NSLM_922415_CI_014 - fim
            // pessoa juridica
            if (!GeralUtil.isNull(dbProspect.getCnpj())) {
                statusInterno = updateStatusCreditoInterno(dbProspect);
            }
        }

        //verifica Pendências de FRAUDE EMBRATEL e Pendências de duplicidade de CPF/CNPJ
        int pendenciaEmbratel = 0;
        if (verificaPendencias(dbProspect)) {
            pendenciaEmbratel = 1;
        }        

        return verificaChecagemIntExt(statusExterno, statusInterno, pendenciaEmbratel);
    }


    /**
     * Retorna o status do credito em relacao aos retornos informados
     * de credito interno e externo. Checa tb duplicidades cpf/Cnpj e pendencias embratel.
     *
     * @param retEx status de credito externo
     * @param retIn status de credito interno
     * @return status
     */
    private Integer verificaChecagemIntExt(final String retEx, final  int retIn, final int pendenciaEmbratel) {
        int status = CpScpcPropostaBean.STATUS_REPROVADO;

        if (StringUtils.equals(retEx, PROC_STA_AGU_SCPC)) {
            status = CpScpcPropostaBean.STATUS_VALIDANDO;
        } else if ((StringUtils.equals(retEx, PROC_STA_CRED_APR) 
                                                || StringUtils.isBlank(retEx)) && retIn == 1) {
            status = CpScpcPropostaBean.STATUS_APROVADO;
        } else if (StringUtils.equals(retEx, PROC_STA_ERRO_CON)) {
            status = CpScpcPropostaBean.STATUS_ERRO_CONSULTA_SCPC;
        } else if (StringUtils.equals(retEx, PROC_STA_CRED_REP)) {
            if (retIn == 0) {
                status = CpScpcPropostaBean.STATUS_REPROVADO;
            }
        }

        if (pendenciaEmbratel == 1) {
            status = CpScpcPropostaBean.STATUS_REPROVADO;
        }

        return Integer.valueOf(status);
    }

    /**
     * Consulta o credito interno em todas as cidades.
     *
     * @param prospect
     * @return
     */
    private ArrayList obterCidadesReprovadasCreditoInterno(final CpProspectBean prospect) {
    	final String[] dbService = getUserSession().getSelectedDbServices();
        final String queryName = CreditoConstants.FIND_BASES;
        final List <String> listaBases = search(queryName, null);
        
    	final String dbServiceAtual = getUserSession().getCurrentDbService();
    	final ArrayList cidadesReprovadas = new ArrayList();
    	for(String db: dbService){
    	   for (String baseNetSms : listaBases) {
    	       if(db.contains(baseNetSms)){
    	           getUserSession().setCurrentDbService(db);
                   final List cidades = super.search(CreditoConstants.LST_ALL, null);
                   final Iterator itC = cidades.iterator();
                   while (itC.hasNext()) {
                       final  CpCidadeOperadoraBean cidade = (CpCidadeOperadoraBean) itC.next();
                       if (checkCreditoInterno(prospect, cidade, getDAO(db)) == 0) {
                           cidadesReprovadas.add(cidade);
                       }
                   }
    	       }
    	    }
    	}
    	getUserSession().setCurrentDbService(dbServiceAtual);
        return cidadesReprovadas;
        
    }

    /**
     * Verifica o credito interno do prospect na cidade informada.
     *
     * @param prospect
     * @param cidade
     * @param dao
     * @return
     */
    private int checkCreditoInterno(final CpProspectBean prospect,
            final CpCidadeOperadoraBean cidade, final DAO dao) {
        // Obtem o cpf ou cnpj informado
        String cpfCnpj = null;
        final int tpPessoa = prospect.getIdTipoPessoa().intValue();
        if (tpPessoa == SnTipoPessoaBean.TP_FISICA) {
        	if (!GeralUtil.isNull(prospect.getCpf())) {
	        	try {
	        	    final DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();
		        	format.applyLocalizedPattern("00000000000");
		        	cpfCnpj = format.format(prospect.getCpf().longValue());
	        	} catch (Exception ex) {
	        		throw new BaseFailureException(ex);
	        	}
        	}
        } else if (tpPessoa == SnTipoPessoaBean.TP_JURIDICA) {
            final DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();
        	format.applyLocalizedPattern("00000000000000");
        	cpfCnpj = format.format(prospect.getCnpj().longValue());
        }

        // Obtem a cidade informada
        final String idCidade = cidade.getIdCidade();

        // Cria a lista de parametros da procedure
        final List lParam = new ArrayList();
        lParam.add(new BatchParameter(Types.NUMERIC, true));
        lParam.add(new BatchParameter(cpfCnpj, Types.VARCHAR));
        lParam.add(new BatchParameter(idCidade, Types.VARCHAR));
        lParam.add(new BatchParameter(Types.VARCHAR, true));

        // Converte os parametros para array
        final BatchParameter[] params = convertListToBatchParameter(lParam);

        // Executa a procedure e armazena o resultado
        final List retorno = dao.executeBatch(CreditoConstants.PLSQL_CREDITO_INTERNO, params, true);

        final BigDecimal codRetorno = (BigDecimal) retorno.get(0);

        return codRetorno.intValue();
    }

    /**
     * Valida o credito do prospect atualizando o status da proposta.
     *
     * @param prospect
     * @param cidade
     * @return
     */
    private int updateStatusCreditoInterno(final CpProspectBean prospect) {
        // Separa o id do prospect
        final Long idProspect = prospect.getIdProspect();

        // Obtem o prospect jah cadastrado para fazer alteracoes
        CpProspectBean dbProspect = null;
        dbProspect = (CpProspectBean) getCurrentDAO().find(CpProspectBean.class, idProspect);

        // Obtem a proposta do prospect para atualizar status
        final CpPropostaBean dbProposta = dbProspect.getProposta();

        int statusCredInt = Integer.MIN_VALUE;

    	// Obtem as cidades reprovadas no credito interno
        final ArrayList cidadesReprovadas = obterCidadesReprovadasCreditoInterno(prospect);

        try {
            // Configura statusCreditoInterno
        	if (cidadesReprovadas.isEmpty()) {
        		statusCredInt = 1;
        	} else {
        		statusCredInt = 0;
        	}

            // Caso nao tenha registro ScpcProposta, cria um
            if (GeralUtil.isNull(dbProposta.getScpcProposta())) {
                final CpScpcPropostaBean scpc = new CpScpcPropostaBean();

                scpc.setProposta(dbProposta);

                scpc.setNome(prospect.getNome());
                scpc.setDataNascimento(prospect.getDataNascimento());
                scpc.setDataCriacaoLog(new Date(System.currentTimeMillis()));
                scpc.setUsuario(getUserSession().getUserId());

                // Salva o scpc na session para fazer bind automatico com proposta
                super.insert(scpc, getUserSession().getCurrentDbService());

                dbProposta.setScpcProposta(scpc);
            }

            // Atualiza o status do credito interno
            dbProposta.getScpcProposta().setCreditoNet(Integer.toString(statusCredInt));

            // Estrangeiro e Pessoa Juridica nao tem verificacao
            // de credito externo
            final int tpPessoa = prospect.getIdTipoPessoa().intValue();
            //boolean estrangeiro = prospect.getEstrangeiro().intValue() == 1;
            if (tpPessoa == SnTipoPessoaBean.TP_JURIDICA) {
                delPendencia(CreditoConstants.VERIFICACAO_CREDITO_EXTERNO,
                        dbProposta);
                delPendencia(CreditoConstants.CREDITO_EXTERNO, dbProposta);
            }

        } catch (Exception e) {
            throw new BaseFailureException(e);
        }

        delPendencia(CreditoConstants.VERIFICACAO_CREDITO_INTERNO, dbProposta);
        delPendencia(CreditoConstants.CREDITO_INTERNO, dbProposta);

        if (statusCredInt == 0) {
            
            // Monta a lista de cidades reprovadas no credito interno
        	String cidades = "";
        	for (final Iterator iter = cidadesReprovadas.iterator(); iter
					.hasNext();) {
        	    final CpCidadeOperadoraBean cidade = (CpCidadeOperadoraBean) iter.next();
				cidades += cidade.getNomeCidade() + ", ";
			}
        	cidades = cidades.substring(0, cidades.length() - 2);
        	if (cidades.length() > CreditoConstants.CONSTANT_40) {
        		cidades = cidades.substring(0, CreditoConstants.CONSTANT_40);
        	}

            geraPendencia(dbProposta, CreditoConstants.CREDITO_INTERNO, CreditoConstants.CONSTANT_07, cidades);

            atualizaStatusProposta(dbProposta);
        }

        return statusCredInt;
    }

    /**
     * Fecha a pendencia informada.
     *
     * @param proposta
     * @param idPendencia
     * @param obs
     * @param acao
     * @param backoffice
     */
    private void atualizaStatusProposta(final CpPropostaBean proposta) {
        //altera o status da proposta, e deixa com status em agendamento
        // caso ela estivesse com o status 2
        final CpStatusPropostaBean statusP = proposta.getStatusProposta();
        final int idStatus = statusP.getIdStatusProposta().intValue();
        if (Integer.valueOf("2").equals(idStatus)) {
            geraPendencia(proposta, GeralConstants.PENDENTE_AGENDAMENTO, CreditoConstants.CONSTANT_25, "");

            // Localiza o status de agendamento
            final Integer statusAgendamento = Integer.valueOf(CreditoConstants.CONSTANT_03);
            final CpStatusPropostaBean status = (CpStatusPropostaBean) getCurrentDAO().find(
                    CpStatusPropostaBean.class, statusAgendamento);

            // Atualiza o status
            proposta.setStatusProposta(status);
        }
    }

    /**
     *
     * @param retorno
     * @param prospect
     * @return
     */
    private int retrievePendVariacaoDadosInconsistentes(final List retorno, final CpProspectBean prospect) {
    	int codPendVariacao = 0;
    	if(!CollectionUtils.isEmpty(retorno) && retorno.size() > 1){
    		if (!GeralUtil.isNull(retorno.get(CreditoConstants.CONSTANT_13)) && (CreditoConstants.PROC_STATUS_CREDITO_APROVADO.
                                                equals(retorno.get(CreditoConstants.CONSTANT_12)) ||
        		CreditoConstants.PROC_STATUS_CREDITO_REPROVADO.equals(retorno.get(CreditoConstants.CONSTANT_12)))) {
	            // Dados do prospect informado
	            final String nome = prospect.getNome();
	
	            // Dados do prospect retornados do SPC
	            final String nomeSPC = (String) retorno.get(CreditoConstants.CONSTANT_03);
	            // Flag para dados inconsistentes. Se for maior que zero
	            // O SCPC deve ser atualizado e a pendencia com o valor
	            // informado nesta variavel, cadastrada na proposta.
	
	
	            //Caso apenas o nome seja diferente
	            if (!StringUtils.equalsIgnoreCase(nome, nomeSPC)) {
	
	                codPendVariacao = 1;
	            }
	        }
    	}
        return codPendVariacao;
    }

    /**
     * Checa o credito externo do prospect informado
     *
     * @param prospect
     * @return
     */
    private String checkCreditoExterno(final CpProspectBean dbProspect) {
       
        final CpPropostaBean dbProposta = dbProspect.getProposta();

        // Declara o retorno do resultado da operacao
        String result = null;

        // Remove todas as pendencias dos tipos informados no switch
        final ArrayList lPends = new ArrayList(dbProposta.getPendenciasProposta());
        final Iterator itPendencias = lPends.iterator();
        while (itPendencias.hasNext()) {
            final Object nextObj = itPendencias.next();
            CpRelPendenciaPropostaBean pendProp = null;
            pendProp = (CpRelPendenciaPropostaBean) nextObj;

            final Long idPendencia = pendProp.getPendencia().getIdPendencia();
            switch (idPendencia.intValue()) {
                case CreditoConstants.VERIFICACAO_CREDITO_EXTERNO:
                case CreditoConstants.CREDITO_EXTERNO:
                case CreditoConstants.AGUARDANDO_SPC:
                case CreditoConstants.ERROR_SPC:
                case CreditoConstants.DADOS_INCONSISTENTES:
                	dbProposta.getPendenciasProposta().remove(pendProp);
                	// Obtem o DAO.
                	final DAO dao = getCurrentDAO();
                    dao.delete(pendProp, false);
            }
        }

        try {
            final List retorno = consultarCreditoExterno(dbProspect);

            // Obtem o retorno da procedure
            final String statusRetorno = (String) retorno.get(CreditoConstants.CONSTANT_12);

            final int codPendVariacao = retrievePendVariacaoDadosInconsistentes(retorno, dbProspect);

            if (codPendVariacao > 0) {
            	CpScpcPropostaBean spcProposta = null;
            	if (dbProposta.getScpcProposta() == null) {
            		spcProposta = new CpScpcPropostaBean();
                    spcProposta.setProposta(dbProposta);
            	} else {
            	    spcProposta = dbProposta.getScpcProposta();
            		
            	}
                spcProposta.setNome((String) retorno.get(CreditoConstants.CONSTANT_03));
                spcProposta.setDataNascimento((Date) retorno.get(CreditoConstants.CONSTANT_04));
                spcProposta.setDataCriacaoLog(new Date(System.currentTimeMillis()));
                spcProposta.setUsuario(getUserSession().getUserId());

                if (dbProposta.getScpcProposta() == null) {
                	super.insert(spcProposta, getUserSession().getCurrentDbService());
                    // Seta o scpc proposta da proposta
                    dbProposta.setScpcProposta(spcProposta);
                } else {
                    // Salva (ou insere) o SCPC criado
                    super.update(spcProposta, getUserSession().getCurrentDbService());
                	
                }
    			geraPendencia(dbProposta, CreditoConstants.DADOS_INCONSISTENTES, codPendVariacao, "");
            }

            // Flag que guarda o cod da variacao de erro
            int codStatusPendVariacao = 0;

            // em caso de credito nao aprovado
            if (!CreditoConstants.PROC_STATUS_CREDITO_APROVADO.equals(statusRetorno)) {
                if (CreditoConstants.PROC_STATUS_CREDITO_REPROVADO.equals(statusRetorno)) { // credito reprovado
                    // fecha a pendencia de verificacao e cria uma pendencia de credito externo
                    codStatusPendVariacao = CreditoConstants.CONSTANT_04;
                    geraPendencia(dbProposta, CreditoConstants.CREDITO_EXTERNO, codStatusPendVariacao, "");

                    // Atualiza o status do credito externo no SCPC
                    final CpScpcPropostaBean spcProposta = dbProposta.getScpcProposta();
                    spcProposta.setCreditoScpc(statusRetorno);

                } else if (CreditoConstants.PROC_STATUS_AGUARDANDO_SCPC.equals(statusRetorno) ||
                		CreditoConstants.PROC_STATUS_ERRO_CONSULTA_SCPC.equals(statusRetorno)) {
                	
                    codStatusPendVariacao = CreditoConstants.CONSTANT_05;
                    geraPendencia(dbProposta, CreditoConstants.AGUARDANDO_SPC, codStatusPendVariacao, "");
                }
            }

            result = statusRetorno;
        } catch (Exception e) {
            delPendencia(CreditoConstants.VERIFICACAO_CREDITO_EXTERNO, dbProposta);
            delPendencia(CreditoConstants.AGUARDANDO_SPC, dbProposta);

            geraPendencia(dbProposta, CreditoConstants.ERROR_SPC, CreditoConstants.CONSTANT_06, "");

            result = CreditoConstants.PROC_STATUS_ERRO_CONSULTA_SCPC;
        }

        return result;

    }
    
    /**
     * Consulta o credito externo do prospect informado
     *
     * @param prospect
     * @return valores da procedure de credito externo
     */
    private List consultarCreditoExterno(final CpProspectBean prospect) {
        // Armazena o resultado
        List result = null;
        
        final String mesesTCheq = leVlrParametro(prospect.getCidadeOperadora().
                                                getIdCidade(), CreditoConstants.NUM_MESES_TELECHEQUE);
        final String mesesMin = leVlrParametro(prospect.getCidadeOperadora().
                                                getIdCidade(), CreditoConstants.MESES_MINIMO_SCPC);
        final String mesesMax = leVlrParametro(prospect.getCidadeOperadora().
                                                getIdCidade(), CreditoConstants.MESES_MAXIMO_SCPC);
        final String vlrMinSCPC = leVlrParametro(prospect.getCidadeOperadora().
                                                getIdCidade(), CreditoConstants.VALOR_MINIMO_SCPC);

        final List liParams = new ArrayList();

        final NumberFormat formatador = NumberFormat.getIntegerInstance();
        formatador.setMinimumIntegerDigits(CreditoConstants.CONSTANT_11);
        formatador.setGroupingUsed(false);
        final String value = formatador.format(prospect.getCpf());
        
        //Recupera de acordo com a cidade o parametro para verificar a black list.
        List paramValidaSerasa = null;
        if(!GeralUtil.isNull(prospect) && !GeralUtil.isNull(prospect.getCidadeOperadora()) && 
        		!GeralUtil.isNull(prospect.getCidadeOperadora().getSnCidade())){
            paramValidaSerasa = super.search(CreditoConstants.
                           LST_PARAN_VALIDAR_SERASA, prospect.getCidadeOperadora().getSnCidade());
        }
        String validaSerasa  = "";
        if(!CollectionUtils.isEmpty(paramValidaSerasa)){
            validaSerasa = ((BigDecimal)paramValidaSerasa.get(0)).toString(); 
        }
        // Param 0: CPF
        liParams.add(new BatchParameter(value, Types.VARCHAR));

        // Param 1: Data Criacao
        liParams.add(new BatchParameter(new Date(), Types.DATE));
        // Param 2: Cidade
        liParams.add(new BatchParameter(prospect.getCidadeOperadora().getIdCidade(), Types.VARCHAR));
        // Param 3: Nome SPC - SAIDA
        liParams.add(new BatchParameter(prospect.getNome(), Types.VARCHAR, true));
        // Param 4: Data Nascimento SPC - SAIDA
        liParams.add(new BatchParameter(prospect.getDataNascimento(), Types.DATE, true));
        // Param 5: Meses Tele-Cheque
        liParams.add(new BatchParameter(mesesTCheq, Types.VARCHAR));
        // Param 6: Meses Minimo SCPC
        liParams.add(new BatchParameter(mesesMin, Types.VARCHAR));
        // Param 7: Meses Maximo SCPC
        liParams.add(new BatchParameter(mesesMax, Types.VARCHAR));
        // Param 8: Valor Minimo SCPC
        liParams.add(new BatchParameter(vlrMinSCPC, Types.VARCHAR));
        if(!GeralUtil.isNull(prospect) && !GeralUtil.isNull(prospect.getCidadeOperadora()) 
        		&& !GeralUtil.isNull(prospect.getCidadeOperadora().getSnCidade()) 
        		&& this.getParamConsultaWebServiceSerasa(prospect).equals(ATIVAR_CONWEB_SER)){
            // Param 9: Parametro para validar credito externo do netsales
            liParams.add(new BatchParameter(validaSerasa, Types.VARCHAR));
        }
        // Param 10: SAIDA
        liParams.add(new BatchParameter(Types.VARCHAR, true));
        // Param 12: SAIDA
        liParams.add(new BatchParameter(Types.VARCHAR, true));
        // Param 12: SAIDA
        liParams.add(new BatchParameter(Types.VARCHAR, true));
        // Param 13: SAIDA
        liParams.add(new BatchParameter(Types.VARCHAR, true));

        // Converte a lista de parametros para um array
        final BatchParameter[] array = convertListToBatchParameter(liParams);
        
        // Executa a procedure e retorna a lista independente se obteve erro
        try {
            
            if(!GeralUtil.isNull(prospect) && !GeralUtil.isNull(prospect.getCidadeOperadora()) 
            		&& !GeralUtil.isNull(prospect.getCidadeOperadora().getSnCidade()) && 
                                                    this.getParamConsultaWebServiceSerasa(prospect).equals(
                                                                                            ATIVAR_CONWEB_SER)){
                result = this.executeBatch(CreditoConstants.PLSQL_CRED_EX_NETSALES, array, prospect);
            }else{
                final List resultBaseSPC = this.executeBatch(CreditoConstants.PLSQL_CREDITO_EXTERNO_SPC, 
                                                        array, prospect);
                result = new ArrayList();
                //Tem que ser adicionado uma iten a mais na lista porque a resposta
                //da base SPC contem apenas 12 itens e não 13 e logo apos é recuperado
                //um item da posição 13 e 12 para verificação da resposta, por isso 
                //foi adicionado este codigo abaixo.
                for (int i = 0; i < resultBaseSPC.size(); i++) {
                    if(i==CreditoConstants.CONSTANT_08){
                        result.add(null);
                    }
                    result.add(resultBaseSPC.get(i));                   
                }
            }            
            
        } catch (Exception e) {
            result = new ArrayList(1);
            result.add(PROC_STA_ERRO_CON);
        }
        return result;
    }

    
    /**
     * 
     * @ejb.interface-method view-type = "both"
	 * @ejb.transaction type="Required"
	 * @ejb.permission role-name="ACESSO"
     * Toda a regra de verifição da string de retorno do serviço seraza esta sendo executada neste método.
     * Consome o webservice do serasa.
     * @param prospect
     * @return
     * @throws Exception 
     */
    public void consomeWebServiceSerasa(final DynamicBean dados){
    	
    	CpProspectBean dbProspect = new CpProspectBean();
    	dbProspect.setIdProspect( (Long) dados.get(CreditoConstants.ID_PROSPECT));
    	dbProspect = (CpProspectBean) super.findByPrimaryKey(dbProspect);
    	
    	//Caso a condição seja false não será utilizados a consulta ao web service do serasa pelo NetSales.
    	if(!GeralUtil.isNull(dbProspect) && !GeralUtil.isNull(dbProspect.getCidadeOperadora()) 
    			&& !GeralUtil.isNull(dbProspect.getCidadeOperadora().getSnCidade()) && this.getParamConsultaWebServiceSerasa(dbProspect).
    			equals(CreditoConstants.ATIVAR_CONWEB_SERASA_ATIVA)){
	    	dbProspect.setIdTipoPessoa((Integer) dados.get(CreditoConstants.ID_TIPO_PESSOA));
	        dbProspect.setCpf((Long) dados.get(CreditoConstants.CPF));
	
	        final NumberFormat formatador = NumberFormat.getIntegerInstance();
	        formatador.setMinimumIntegerDigits(CreditoConstants.CONSTANT_11);
	        formatador.setGroupingUsed(false);
	        
	        dbProspect.setCnpj((Long) dados.get(CreditoConstants.CNPJ));
	        dbProspect.setIe((String) dados.get(CreditoConstants.IE));
	        
	        final String cnpj = dados.get(CreditoConstants.CNPJ) == null ? "" 
	        		: String.valueOf((Long)dados.get(CreditoConstants.CNPJ));
	        final String cpf = dados.get(CreditoConstants.CPF) == null ? "" 
	        		: formatador.format(dados.get(CreditoConstants.CPF));
	        final String statusWebService = getStatusConsultaWebServiceSerasa(dbProspect, "0", "0");
	        	        
	        //Verifica se o status do cpf encontrasse 
	        //V = não existe registro na base para o cpf ou 
	        //E = já esta inserido um registro sem resposta do serviço.
	        if(!"".equals(statusWebService)  && statusWebService.equals(
	        		CreditoConstants.PROC_STATUS_CONSULTA_NAO_EXECUTADA_SCPC) ||
	        		statusWebService.equals(CreditoConstants.PROC_STATUS_AGUARDANDO_SCPC)){    
	            final BeanRespostaSerasa respostaSerasa = new BeanRespostaSerasa();
	        	respostaSerasa.setInicioChamadaServico(new Date());
	        	AnalisarCreditoResponse retornoServico = null; 
	        	retornoServico = getWebServiceSerasa(cnpj, cpf, dados);
	        	respostaSerasa.setFimChamadaServico(new Date());
	        	respostaSerasa.setProspect(dbProspect);
        		this.filtraRespostaServico(respostaSerasa, retornoServico, cpf);
	        }
    	}
    }
    
	/**
	 * 
	 * @param respostaSerasa
	 * @param retornoServico
	 * @param cpf
	 */
    private void filtraRespostaServico(BeanRespostaSerasa respostaSerasa, 
                                            final AnalisarCreditoResponse retornoServico, final String cpf){
    	String erroRetornado = "";
    	String chave = "";
    	int posicao = 0;
    	String[] conteudo = new String[0];
    	try{
	    	if(!GeralUtil.isNull(retornoServico) && !GeralUtil.isNull(retornoServico.getAnalisarCreditoResult()) &&
	    			!retornoServico.getAnalisarCreditoResult().equals("")){
	        	conteudo = retornoServico.getAnalisarCreditoResult().split("\n");
	        	if(conteudo.length > 0 && !GeralUtil.isNull(respostaSerasa) && !GeralUtil.isNull(respostaSerasa.getProspect())){

	    	    	//Obter a chave retornada pelo serviço 
	    	    	//chave = 0 problemas na consulta 
	    	    	//chave = 1 consulta retornada com sucesso
	    			posicao  = conteudo[0].indexOf("=");
	        		if((posicao + 2) < conteudo[0].length()){
	        			chave = (conteudo[0].substring(posicao + 1, conteudo[0].length())).trim();
	        		}
	        		String status = "";
	        		if(chave.equals(CreditoConstants.CREDITO_EXTERNO_RETORNO_OK)){
	    	    		posicao  = conteudo[1].indexOf("=");
	    	    		if((posicao + 2) < conteudo[1].length()){
	    	    			status = (conteudo[1].substring(posicao + 1, conteudo[1].length())).trim();
	    	    			// 4 - NÃO APROVADO
	    	    			// 1 - APROVADO
	    	    			// 3 - DADOS INVALIDOS
	    	    			respostaSerasa.setStatusRetornado(status.equals
	    	    						(CreditoConstants.CREDITO_EXTERNO_NAO_APROVADO) ? 
	    	    						"4" : (status.equals(CreditoConstants.CREDITO_EXTERNO_APROVADO) ? "1" : "3"));
	    	    			if(respostaSerasa.getStatusRetornado().equals("1")){
	    	    				respostaSerasa.setDescricaoRetornoServico
	    	    						(CreditoConstants.CREDITO_EXTERNO_NADA_CONSTA + cpf);
	    	    				respostaSerasa.setCodigoResposta
	    	    						(CreditoConstants.CREDITO_EXTERNO_COD_RESPOSTA_NADA_CONSTA);
	    	    				respostaSerasa.setTipo("0");
	    	    			}else if(respostaSerasa.getStatusRetornado().equals("4")){
	    	    				respostaSerasa.setDescricaoRetornoServico
	    	    						(CreditoConstants.CREDITO_EXTERNO_REPROVADO + cpf);
	    	    				respostaSerasa.setCodigoResposta
	    	    						(CreditoConstants.CREDITO_EXTERNO_COD_RESPOSTA_NAO_APROVADO);
	    	    				respostaSerasa.setTipo("3");
	    	    			}else{
	    	    				respostaSerasa.setDescricaoRetornoServico
	    	    						(CreditoConstants.CREDITO_EXTERNO_DADOS_INVALIDOS + cpf);
	    	    				respostaSerasa.setCodigoResposta
	    	    						(CreditoConstants.CREDITO_EXTERNO_COD_RESPOSTA_DEMAIS_SIT);
	    	    				respostaSerasa.setTipo("9");
	    	    			}
	    	    		}else{
	    	    			if(conteudo[CreditoConstants.CONSTANT_06].contains("ERRO")){
	    	    				posicao  = conteudo[CreditoConstants.CONSTANT_06].indexOf("=");
	    	    				if((posicao + 2) < conteudo[CreditoConstants.CONSTANT_06].length()){
	    	    					erroRetornado = (conteudo[CreditoConstants.CONSTANT_06].substring(posicao + 1, 
	    	    					conteudo[CreditoConstants.CONSTANT_06].length())).trim();
	    	    				}
	    	    			}
	    	    			// 3 - DADOS INVALIDOS
	    	    			respostaSerasa.setStatusRetornado("3");
	    	    			if(!"".equals(erroRetornado)){
			    				if(erroRetornado.length() > CreditoConstants.CONSTANT_95){
			    					respostaSerasa.setDescricaoRetornoServico(
		                          erroRetornado.substring(0, CreditoConstants.CONSTANT_95));
			    				}else{
			    					respostaSerasa.setDescricaoRetornoServico(erroRetornado);
			    				}
			    			}else{
			    				respostaSerasa.setDescricaoRetornoServico
			    				(CreditoConstants.CREDITO_EXTERNO_DADOS_INVALIDOS + cpf);
							}
	    	    			respostaSerasa.setCodigoResposta(CreditoConstants.CREDITO_EXTERNO_COD_RESPOSTA_DEMAIS_SIT);
	    	    			respostaSerasa.setTipo("9");
	    	    		}        			
	        			
	        		}else{
	        			//PROBLEMAS NA CONSULTA
	        			respostaSerasa.setStatusRetornado("5");
	        			respostaSerasa.setDescricaoRetornoServico(CreditoConstants.
	        			                                        CREDITO_EXTERNO_FALHA_EXECUCAO + cpf);
	        			respostaSerasa.setCodigoResposta(CreditoConstants.
	        			                                        CREDITO_EXTERNO_COD_RESPOSTA_DEMAIS_SIT);
	        			respostaSerasa.setTipo("9");
	        		}
	    		}
	        	respostaSerasa = this.filtraDadosPolitica(respostaSerasa, conteudo);
	    	}else{
	    		//PROBLEMAS NA CONSULTA
	    		respostaSerasa.setStatusRetornado("5");
	    		respostaSerasa.setDescricaoRetornoServico(CreditoConstants.CREDITO_EXTERNO_FALHA_EXECUCAO + cpf);
	    		respostaSerasa.setCodigoResposta(CreditoConstants.CREDITO_EXTERNO_COD_RESPOSTA_DEMAIS_SIT);
	    		respostaSerasa.setTipo("9");
	    	}
	    	
	    	this.persistirAtualizar(respostaSerasa);
	    			
    	}catch (Exception e) {
    	    throw new BaseFailureException(e);
    	
		}    	
    }  
    
    /**
     * Recupera da resposta do serviço a string dados da politica e filtra dos dados necessário para inserir na tabela.
     * Regra de leitura baseada na resposta que o robo retornava.
     * @param respostaSerasa
     * @param conteudo
     * @param cpf
     * @return
     */
    private BeanRespostaSerasa filtraDadosPolitica(final BeanRespostaSerasa 
                                            respostaSerasa, final String[] conteudo){
    	int posicao = 0;
    	String[] arrayPolitica = new String[0];
    	//Obter da string de retorno DADOSPOLITICA
		for (String string : conteudo) {
			if(string.contains(CreditoConstants.DADOS_POLITICA)){
				arrayPolitica = string.split("\\|");
				break;
			}
		}

		posicao  = conteudo[CreditoConstants.CONSTANT_03].indexOf("=");
		String limite = "0";
		if((posicao + 2) < conteudo[CreditoConstants.CONSTANT_03].length()){
				limite = (conteudo[CreditoConstants.CONSTANT_03].substring(posicao + 1,
				          conteudo[CreditoConstants.CONSTANT_03].length())).trim();
				limite = limite.replace(".", " ").replace(",", "");
				if(limite.length() > 1 && !limite.substring(0, 1).equals("-")){
					limite = limite.substring(0, 1);
				}
		}
		Date dataAuxiliar = null;
		switch(Integer.valueOf(limite)){                                
			case 0:
				break;
			case 1:
				respostaSerasa.setCodigoResposta(CreditoConstants.CREDITO_EXTERNO_COD_RESPOSTA_NAO_APROVADO);
				for (String string : arrayPolitica) {
					if(string.contains(CreditoConstants.DATA_ULT_OCORR)){
						dataAuxiliar = recuperarData(string);
					}
					if(string.contains(CreditoConstants.VR_CHEQUES_SEM_FUNDOS)){
						posicao = string.indexOf(CreditoConstants.ARROBA);
						if(respostaSerasa.getValor().equals("0"))
							respostaSerasa.setValor(this.formatValor((string
							.substring(posicao + 1, string.length())).trim())); 
					}
				}
				if(respostaSerasa.getValor().equals("0")){
					respostaSerasa.setValor(this.filtraValorDivida(arrayPolitica));
				}
				break;
			case 2:
				respostaSerasa.setCodigoResposta(CreditoConstants.CREDITO_EXTERNO_COD_RESPOSTA_NAO_APROVADO);
				for (String string : arrayPolitica) {
					if(string.contains(CreditoConstants.DATA_ULTIMA_OCORR_PROTE)){
						dataAuxiliar = recuperarData(string);
					}
					if(string.contains(CreditoConstants.VR_PROTESTOS_ATE_DATA)){
						posicao = string.indexOf(CreditoConstants.ARROBA);
						if(respostaSerasa.getValor().equals("0"))
							respostaSerasa.setValor(this.formatValor((string
							          .substring(posicao + 1, string.length())).trim())); 
					}
				}
				if(respostaSerasa.getValor().equals("0")){
					respostaSerasa.setValor(this.filtraValorDivida(arrayPolitica));
				}
				break;
			case 3:	
				respostaSerasa.setCodigoResposta(CreditoConstants.CREDITO_EXTERNO_COD_RESPOSTA_NAO_APROVADO);
				Date dataRefin = null;
				Date dataPefin = null;
				Date dataVenci = null;
				Date data03 = null; 
				Date dataAcoesJudi = null;
				String acoesAteData = "";

				for (String string : arrayPolitica) {
					if(string.contains(CreditoConstants.DATA_ULTIMA_OCORR_ACOES)){
						dataAcoesJudi = recuperarData(string);
					}
					if(string.contains(CreditoConstants.DATA_ULTIMA_OCORR_REFIN)){
						dataRefin = recuperarData(string);
					}
					if(string.contains(CreditoConstants.DATA_ULTIMA_OCORR_PEFIN)){
						dataPefin = recuperarData(string);
					}
					if(string.contains(CreditoConstants.VENCTO)){
						dataVenci = recuperarData(string);
					}
					if(string.contains(CreditoConstants.DATA)){
						data03 = recuperarData(string);
					}
					
			    	if(string.contains(CreditoConstants.VR_ACOES_JUDICIAIS_ATE_DATA)){
						posicao = string.indexOf(CreditoConstants.ARROBA);
						acoesAteData = this.formatValor((string.substring(
						                                        posicao + 1, string.length())).trim()); 
					}
					
				}
				if(!GeralUtil.isNull(data03)){
					dataAuxiliar = data03;
				}
				if(!GeralUtil.isNull(dataAcoesJudi)){
					dataAuxiliar = dataAcoesJudi;
				}
				if(!GeralUtil.isNull(dataPefin)){
					dataAuxiliar = dataPefin;
				}
				if(!GeralUtil.isNull(dataRefin)){
					dataAuxiliar = dataRefin;
				}
				if(!GeralUtil.isNull(dataVenci)){
					dataAuxiliar = dataVenci;
				}
				if(!"0".equals(acoesAteData) && GeralUtil.isNull(dataPefin) && 
						!GeralUtil.isNull(dataRefin) && !GeralUtil.isNull(dataVenci)){
					respostaSerasa.setValor(acoesAteData); 
				}else{
					respostaSerasa.setValor(this.filtraValorDivida(arrayPolitica));
				}
				
				break;
		}
		//Caso a string de DADOSPOLITICA tenha valor busca dentro desta mesma string os valores abaixo.
		for (String string : arrayPolitica) {
			if(string.contains(CreditoConstants.GRAFIA_TITULAR)){
				posicao = string.indexOf(CreditoConstants.ARROBA);
				respostaSerasa.setNomeTitularRetornado((string.substring(posicao + 1, string.length())).trim()); 
			}
			if(string.contains(CreditoConstants.GRAFIA_MAE)){
				posicao = string.indexOf(CreditoConstants.ARROBA);
				respostaSerasa.setNomeMaeRetornado((string.substring(posicao + 1, string.length())).trim());
			}
			if(string.contains(CreditoConstants.DATA_DE_NASCIMENTO)){
				posicao = string.indexOf(CreditoConstants.ARROBA);
				try {
				    final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
					if( (string.length() - posicao) >= CreditoConstants.CONSTANT_08 
							&& !(string.substring(posicao + 1, string.length()).trim().equals("#")))
						respostaSerasa.setDataNascimentoRetornado(format.parse(
								(string.substring(posicao + 1, string.length())).trim()));
				} catch (Exception e) {
				    throw new BaseFailureException(e);					
				}
			}	    								
		}
		respostaSerasa.setDataRetornada(dataAuxiliar);
    	return respostaSerasa;
    }
    
    /**
     * Filtra a divida do CPF somando todos os valores retornados no string dados da Política.
     * @param dadosPolitica
     * @param dataOcorrenciaPefin
     * @param dataOcorrenciaRefin
     * @param dataVenci
     * @return
     */
    private String filtraValorDivida(final String[] dadosPolitica){
    	String valor = "0";
    	int posicao = 0;
		BigDecimal valorTotalPerfin = new BigDecimal("0");
		BigDecimal valorTotalRerfin = new BigDecimal("0");
		BigDecimal valorTotalFin = new BigDecimal("0");

		String valorPerfin = "";
		String valorPendenciaFin = "";
		String valorRerfin = "";
    	for (String string : dadosPolitica) {
					
			if(string.contains(CreditoConstants.VALR_PEFIN_ULT)){
				posicao = string.indexOf(CreditoConstants.ARROBA);
				valorPerfin = this.formatValor((string.substring(posicao + 1, string.length())).trim());
				if( !"0".equals(valorPerfin))
					valorTotalPerfin = valorTotalPerfin.add(new BigDecimal(valorPerfin));
			}
			if(string.contains(CreditoConstants.VALR_PENDENCIAS_FINAN)){
				posicao = string.indexOf(CreditoConstants.ARROBA);
				valorPendenciaFin = this.formatValor((string.substring(posicao + 1, string.length())).trim());
				if(!"0".equals(valorPendenciaFin))
					valorTotalFin = valorTotalFin.add(new BigDecimal(valorPendenciaFin));
			}
			if(string.contains("VALR REFIN ULT")){
				posicao = string.indexOf(CreditoConstants.ARROBA);
				valorRerfin = this.formatValor((string.substring(posicao + 1, string.length())).trim());
				if( !"0".equals(valorRerfin))
					valorTotalRerfin = valorTotalRerfin.add(new BigDecimal(valorRerfin));
			}
    	}
    	
    	if(valorTotalPerfin.intValue() != 0){
    		valor = String.valueOf(valorTotalPerfin); 
    	}
    	if(valorTotalFin.intValue() != 0){
    		valor = String.valueOf(valorTotalFin); 
    	}
    	if(valorTotalRerfin.intValue() != 0){
    		valor = String.valueOf(valorTotalRerfin); 
    	}
    	
    	return valor;
    }
    
    
    /**
     * Responsável por inserir e atualizar a resposta da consulta ao serviçoa serasa.
     * @param respostaSerasa
     */
    private void persistirAtualizar(final BeanRespostaSerasa respostaSerasa){
    	synchronized(this){
    		final String chamadaWebService = getStatusConsultaWebServiceSerasa(respostaSerasa.getProspect(), "0", "0");
    		String spcKey = "";
	    	if(chamadaWebService.equals(CreditoConstants.PROC_STATUS_AGUARDANDO_SCPC)){
		    	//Atualiza o retorno do serviço.
	    		spcKey = updateStatusConsulta(preparaParametros(respostaSerasa, 
	    				respostaSerasa.getStatusRetornado(), "0"));
	    		insertDetSpc(preparaInsertRetorno(spcKey, respostaSerasa.getDescricaoRetornoServico(), 
	    				respostaSerasa.getValor(), respostaSerasa.getDataRetornada(),
	    				respostaSerasa.getTipo(), respostaSerasa.getCodigoResposta()));
	    	}else{
	    		if(chamadaWebService.equals(CreditoConstants.PROC_STATUS_CONSULTA_NAO_EXECUTADA_SCPC)){
	    			//se não existe insere. 
	    			spcKey = insertStatusConsulta(preparaParametros(respostaSerasa, 
	    					respostaSerasa.getStatusRetornado(), "0"));
	    			insertDetSpc(preparaInsertRetorno(spcKey, respostaSerasa.getDescricaoRetornoServico(), 
	    					respostaSerasa.getValor(), respostaSerasa.getDataRetornada(), 
	    					respostaSerasa.getTipo(), respostaSerasa.getCodigoResposta()));
	    		}else{
	    			spcKey = updateStatusConsulta(preparaParametros(respostaSerasa, 
	    					respostaSerasa.getStatusRetornado(), "0"));
	    			insertDetSpc(preparaInsertRetorno(spcKey, respostaSerasa.getDescricaoRetornoServico(),
	    					respostaSerasa.getValor(), respostaSerasa.getDataRetornada(), 
	    					respostaSerasa.getTipo(), respostaSerasa.getCodigoResposta()));
	    		}
	    	}
	    	//Insere o retorno do serviço.
	    	spcKey = insertStatusConsulta(preparaParametros(respostaSerasa, 
	    			(this.getStatusRetornoSerasa(respostaSerasa.getStatusRetornado())), "1"));
	    	insertDetSpc(preparaInsertRetorno(spcKey, respostaSerasa.getDescricaoRetornoServico(),
	    			respostaSerasa.getValor(), respostaSerasa.getDataRetornada(),
	    			respostaSerasa.getTipo(), respostaSerasa.getCodigoResposta()));
    	}
    }
    
    /**
     * Status passado por parametro é o status da primeiro registro para cpf consultado, 
     * onde de acordo com o status passado por paramentro é feita uma verificação para inserir
     * o segundo registro para a mesmo cpf.
     * @param statusRetornado
     * @return
     */
    private String getStatusRetornoSerasa(final String statusRetornado){
		// 4 - NÃO APROVADO
		// 1, 2 - APROVADO
    	// 3 - DADOS INVALIDOS
    	// 5 - PROBLEMAS NA CONSULTA
    	return statusRetornado.equals("1") ? "2" : (statusRetornado.equals("5") ? "6" : 
    		(statusRetornado.equals("3") ? "3" : "4"));
    }
    
    /**
     * Transformar uma string em um valor válido.
     * @param valor
     * @return
     */
    private String formatValor(final String valor){
    	try{
    	    final BigDecimal valorDevedor = new BigDecimal(valor);
    		return valorDevedor.toString();
    	}catch (Exception e) {
			return "0";
		}
    }
    
    /**
     * Pega a string retornado pelo serviço e converte para uma data válida.
     * @param data
     * @return
     */
    private Date recuperarData(final String data){
        final int posicao = data.indexOf(CreditoConstants.ARROBA);
		try {
		    final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			if((data.length() - posicao) >= CreditoConstants.CONSTANT_08 && 
			                                        !(data.substring(posicao + 1, data.length()).trim().equals("#")))
				return format.parse((data.substring(posicao + 1, data.length())).trim());
		} catch (ParseException e) {
		    throw new BaseFailureException(e);		
		}
    	return null;
    }
    
    /**
     * Insere na spc.cons;
     * @param array
     */
	private String insertStatusConsulta(final BatchParameter[] array){
        final List lista = this.executeBatch(CreditoConstants.PR_INSERE_REQUISICAO, array);
    	if(lista != null && !lista.isEmpty() && lista.get(CreditoConstants.CONSTANT_11) instanceof String){
    		return (String)lista.get(CreditoConstants.CONSTANT_11);
    	}
    	return "";
    }
    
    //Insere na tabela DET_SPC
    private void insertDetSpc(final BatchParameter[] array){
    	this.executeBatch(CreditoConstants.PR_INSERE_RETORNO_SERASA, array);
    }
    
    /**
     * Atualiza na spc.cons; 
     * @param array
     */
	private String updateStatusConsulta(final BatchParameter[] array){
        final List lista = this.executeBatch(CreditoConstants.PR_ATUALIZA_REQUISICAO, array);
    	if(lista != null && !lista.isEmpty() && lista.get(CreditoConstants.CONSTANT_11) instanceof String){
    		return (String)lista.get(CreditoConstants.CONSTANT_11);
    	}
    	return "";
    }     
    
    /**
     * 
     * @param dbProspect
     * @param statusRetornado
     * @param toCons
     * @param nomeTitularRetornado
     * @param dataNascimentoRetornado
     * @param nomeMaeRetornado
     * @return
     */
    private BatchParameter[] preparaParametros(final BeanRespostaSerasa respostaSerasa, 
                                            final String statusRetornado, final String toCons){
        final List lParam = new ArrayList();
    	
    	//Cpf do titular.
    	lParam.add(new BatchParameter(respostaSerasa.getProspect().getCpf() != null ? 
    	String.valueOf(respostaSerasa.getProspect().getCpf()) : "", Types.VARCHAR));
    	//Nome do titular
    	lParam.add(new BatchParameter(respostaSerasa.getProspect().getNome() != null ? 
    	respostaSerasa.getProspect().getNome().toString() : "", Types.VARCHAR));
    	//Data de nascimento.
    	lParam.add(new BatchParameter(respostaSerasa.getProspect().getDataNascimento(), Types.DATE));
    	//Data Criação.
		lParam.add(new BatchParameter(respostaSerasa.getInicioChamadaServico(), Types.VARCHAR));
    	//Data Retorno.
		lParam.add(new BatchParameter(respostaSerasa.getFimChamadaServico(), Types.VARCHAR));
    	//Status retornado da consulta ao serasa. 
    	lParam.add(new BatchParameter(statusRetornado, Types.VARCHAR));
    	//tp_cons
    	lParam.add(new BatchParameter(toCons, Types.VARCHAR));
    	//Nome do titular retornado.
    	lParam.add(new BatchParameter(respostaSerasa.getNomeTitularRetornado(), Types.VARCHAR));    	
    	//Data de nascimento retornada.
    	lParam.add(new BatchParameter(respostaSerasa.getDataNascimentoRetornado(), Types.DATE));
    	//Titulo de eleitor não é retornado pelo serviço.
    	lParam.add(new BatchParameter("0", BatchParameter.VARCHAR));
    	//Nome da mãe retornada.
    	lParam.add(new BatchParameter(respostaSerasa.getNomeMaeRetornado(), Types.VARCHAR));
        // Param 12: SAIDA
        lParam.add(new BatchParameter(Types.VARCHAR, true));
    	
        // Converte a lista de parametros para um array
        final BatchParameter[] array = convertListToBatchParameter(lParam);
        return array;
    }
    
    /**
     * Identifica o parametro na SN_VLR_PARAMETRO
     *
     * @param idcidade
     * @param param
     * @return
     */
    private String leVlrParametro(final String idcidade, final String param) {
        final DynamicBean bean = new DynamicBean();
        bean.set(CreditoConstants.CID_CONTRATO, idcidade);
        bean.set(CreditoConstants.NOME_PARAMETRO, param);
        final List result = search(CreditoConstants.FIND_SN_VLR_PARAMETRO, bean);

        BigDecimal value = null;
        if (!result.isEmpty()) {
            value = ((BigDecimal) result.get(0));
        }

        return value.toString();
    }

    /**
     * Cria a pendencia de verificacao de credito para o prospect informado
     *
     * @param bean
     * @param tpPessoa
     * @param cpf
     */
    private void criaPendVerifCredito(final CpProspectBean bean, final Integer tpPessoa,
            final Long cpfCnpj) {

        final CpPropostaBean proposta = bean.getProposta();
        final CpScpcPropostaBean scpcProposta = proposta.getScpcProposta();

        if (tpPessoa.intValue() == SnTipoPessoaBean.TP_FISICA) {
            
             // verifica se é estrangeiro e só gera a pendencia de credito
             // interno caso nao tenha sido verificado
             
        	// Alteração CAT 44
        	if (ObjectUtils.equals(cpfCnpj, Long.valueOf(0l))) {
                if (scpcProposta == null
                        || StringUtils.isBlank(scpcProposta.getCreditoNet())) {
                    // Pendencias a serem removidas antes de gerar as novas
                    final int[] pendencias = {
                            CreditoConstants.VERIFICACAO_CREDITO_EXTERNO,
                            CreditoConstants.VERIFICACAO_CREDITO_INTERNO,
                            CreditoConstants.CREDITO_EXTERNO,
                            CreditoConstants.CREDITO_INTERNO };

                    // Execuda a delecao das pendencias
                    for (int i = 0; i < pendencias.length; i++)
                        delPendencia(pendencias[i], proposta);

                    geraPendencia(proposta,
                    		CreditoConstants.VERIFICACAO_CREDITO_INTERNO, CreditoConstants.CONSTANT_22, "");
                }
            } else {
                if (scpcProposta == null
                        || (StringUtils.isBlank(scpcProposta.getCreditoNet()) && StringUtils
                                .isBlank(scpcProposta.getCreditoScpc()))) {

                    if (!proposta.getPendenciasProposta().isEmpty()) {
                        // Pendencias a serem removidas antes de gerar as novas
                        final int[] pendencias = {
                        		CreditoConstants.VERIFICACAO_CREDITO_EXTERNO,
                        		CreditoConstants.VERIFICACAO_CREDITO_INTERNO,
                        		CreditoConstants.DADOS_INCONSISTENTES,
                        		CreditoConstants.ERROR_SPC,
                        		CreditoConstants.CREDITO_EXTERNO,
                        		CreditoConstants.CREDITO_INTERNO };

                        // Execuda a delecao das pendencias
                        for (int i = 0; i < pendencias.length; i++)
                            delPendencia(pendencias[i], proposta);
                    }

                    geraPendencia(proposta,
                    		CreditoConstants.VERIFICACAO_CREDITO_EXTERNO, CreditoConstants.CONSTANT_21, "");
                    geraPendencia(proposta,
                    		CreditoConstants.VERIFICACAO_CREDITO_INTERNO, CreditoConstants.CONSTANT_22, "");
                }
            }
        } else if (tpPessoa.intValue() == SnTipoPessoaBean.TP_JURIDICA && scpcProposta != null
                && StringUtils.isNotBlank(scpcProposta.getCreditoNet())) {
            delPendencia(CreditoConstants.VERIFICACAO_CREDITO_EXTERNO, proposta);
            delPendencia(CreditoConstants.VERIFICACAO_CREDITO_INTERNO, proposta);

            geraPendencia(proposta, CreditoConstants.VERIFICACAO_CREDITO_INTERNO, CreditoConstants.CONSTANT_21, "");
        }
    }

    /**
     * Metodo que deleta as pendencias do tipo informado
     *
     * @param idPendencia
     * @param proposta
     */
    private void delPendencia(final int idPendencia, final CpPropostaBean proposta) {
        if (proposta.getPendenciasProposta().isEmpty())
            return;

        final List pendProps = new ArrayList(proposta.getPendenciasProposta());
        final Iterator iterator = pendProps.iterator();

        while (iterator.hasNext()) {
            final Object nextObj = iterator.next();
            final CpRelPendenciaPropostaBean pendencia = (CpRelPendenciaPropostaBean) nextObj;

            final int idP = pendencia.getPendencia().getIdPendencia().intValue();
            if (idP == idPendencia) {
                proposta.getPendenciasProposta().remove(pendencia);
                getCurrentDAO().delete(pendencia, false);
            }
        }
    }

    /**
     * Metodo que gera uma pendencia para a proposta informada
     *
     * @param dbProposta
     * @param idPendencia
     * @param idPendVariacao
     * @param obs
     * 
     * @ejb.interface-method view-type="local"
     * 
     */
    public void geraPendencia(final CpPropostaBean dbProposta, final  Integer idPendencia,
                                            final Integer idPendVariacao, final String obs) {
        boolean existePendencia = false;
    	if(!dbProposta.getPendenciasProposta().isEmpty()){
    	    final List pendencias = dbProposta.getPendenciasProposta();
    	    final Iterator iterator = pendencias.iterator();
    		while (iterator.hasNext()){
    		    final Object nextObj = iterator.next();
    		    final CpRelPendenciaPropostaBean pendencia = (CpRelPendenciaPropostaBean) nextObj;

    		    final int idP = pendencia.getPendencia().getIdPendencia().intValue();
	            if (idP == idPendencia) {
	            	existePendencia = true;
	            }
    		}
    	}
        if(!existePendencia){    	
	        // Obtem o DAO.
            final DAO dao = getCurrentDAO();
	    	
	        // Localiza a pendencia informada
            final CpPendenciasBean pendencia = (CpPendenciasBean) dao.find(CpPendenciasBean.class, 
	                                                Long.valueOf(idPendencia));
	        // Localiza a pendenciaVariacao informada
            final CpRelPendenciasVariacoesBean pendVariacao = 
	        	getPendenciaVariacao(idPendencia.intValue(), idPendVariacao.intValue());
	
	        // Cria nova relacao entre pendencia/Variacao com proposta
            final CpRelPendenciaPropostaBean relPendProp = 
	            new CpRelPendenciaPropostaBean();
	        relPendProp.setProposta(dbProposta);
	    	relPendProp.setPendencia(pendencia);
	    	relPendProp.setPendenciaVariacao(pendVariacao);
	        relPendProp.setDtAbertura(new Date());
	        relPendProp.setDtFechamento(null);
	        relPendProp.setObs(obs);
	        relPendProp.setUsuario(getUserSession().getUserId());
	        // Atualiza o objeto
	        dao.update(relPendProp, false);
	        // Adiciona a pendencia na proposta
	        dbProposta.getPendenciasProposta().add(relPendProp);
	        dbProposta.setStatusProposta(new 
	                                        CpStatusPropostaBean(CreditoConstants.STATUS_PENDENTE));
        }
    }
       
    /**
     * Metodo que retorna a variação da pendencia
     *
     * @param pendencia
     * @param varPend
     *
     * @return CpRelPendenciasVariacoesBean
     */
    private CpRelPendenciasVariacoesBean getPendenciaVariacao(final int pendencia,
                                            final int varPend) {
        final DynamicBean bean = new DynamicBean();
        bean.set(CreditoConstants.ID_PENDENCIA, String.valueOf(pendencia));
        bean.set(CreditoConstants.ID_VARIACAO, String.valueOf(varPend));
        final String queryName = CreditoConstants.FIND_PEND_VARIACAO;
        final List result = search(queryName, bean);

        CpRelPendenciasVariacoesBean cpRelPendenciasVariacoes = new CpRelPendenciasVariacoesBean();
        if (!CollectionUtils.isEmpty(result)) {
            cpRelPendenciasVariacoes = (CpRelPendenciasVariacoesBean) result.get(0);
        }
		return cpRelPendenciasVariacoes;
    }

    /**
     * @param queryName
     * @param bean
     * @return List
     */
    public List search(final String queryName, final Bean bean) {
    	return (super.search(queryName, bean, false));
    }

	/**
	 *
	 * @param queryName
	 * @param bean
	 * @return
	 */
	public List listDuplicidades(final String queryName, final Bean bean) {

	    final List result = super.search(queryName, bean);

		return result;
	}
	
	/**
	 * Converte a lista de parametros para um array
	 * @return
	 */
	private BatchParameter[] convertListToBatchParameter(final List liParams){
	    // Converte a lista de parametros para um array
	    BatchParameter[] array = null;
	    final int size = liParams.size();
	    return array = (BatchParameter[]) liParams.toArray(new BatchParameter[size]);
	}
	
	/**
	 * Retorna o status da consulta do web service do serasa.
	 * De acordo com este status vai verificar se a consulta já voi realizada para o cliente. 
	 * @param conteudo
	 * @return
	 */
	private String getStatusConsultaWebServiceSerasa(final CpProspectBean 
	                                        dbProspect,final String tpCons, final String status){
        
		// Armazena o resultado
        List result = null;
        final List liParams = new ArrayList();

        // Param 0: retorno
        liParams.add(new BatchParameter(Types.VARCHAR, true));
        // Param 1: cnpf do cliente a ser consultado.
        liParams.add(new BatchParameter(dbProspect.getCpf() != null ? 
        String.valueOf(dbProspect.getCpf()) : "", Types.VARCHAR));
        // Param 2: Data de criação.
        liParams.add(new BatchParameter(new Date(), Types.DATE));
        // Param 3: tipo de consulta.
        liParams.add(new BatchParameter(tpCons, Types.VARCHAR));
        // Param 4: Nome
        liParams.add(new BatchParameter(dbProspect.getNome() != null ? 
        dbProspect.getNome().toString() : "", Types.VARCHAR));
        // Param 5: Data de nascimento.
        liParams.add(new BatchParameter(dbProspect.getDataNascimento(), Types.DATE));
        // Param 6: Titulo de eleitor
        liParams.add(new BatchParameter("0", Types.VARCHAR));
        // Param 7: Nome da mãe.
        liParams.add(new BatchParameter(dbProspect.getNomeMae() != null ? 
        dbProspect.getNomeMae().toString() : "", Types.VARCHAR));
        // Param 8: Status
        liParams.add(new BatchParameter(Types.VARCHAR, true));
        
        final BatchParameter[] array = convertListToBatchParameter(liParams);
        
        result = this.executeBatch(CreditoConstants.PR_PEGA_DADOS_SPC_CONS, array);
    	
		if(result != null && !result.isEmpty()){
			return (String)result.get(CONSTANT_8) != null ? (String)result.get(CONSTANT_8) : "";
		}
		return "";
	}
	
	/**
	 * Executa a criação da instancia da camada DAO e executa a chamada ao sql.
	 * @param sql
	 * @param array
	 * @return
	 */
	private List executeBatch(final String sql, final BatchParameter[] array, final CpProspectBean prospect){
		DAO dao = null;
		if(prospect != null && prospect.getCidadeOperadora() != null && 
		                                        prospect.getCidadeOperadora().getSnCidade() != null && 
		                                        this.getParamConsultaWebServiceSerasa(prospect).equals
		                                        (CreditoConstants.ATIVAR_CONWEB_SERASA_ATIVA)){
			dao = getDAO(getUserSession(), getUserSession().getCurrentDbService());
		}else{
			dao = daoFactory.getDAO(CreditoConstants.JDBC_DAO, CreditoConstants.DBSERVICE_NAME);
		}		
    	return dao.executeBatch(sql, array);
	}
	
	/**
	 * Executa a criação da instancia da camada DAO e executa a chamada ao sql.
	 * @param sql
	 * @param array
	 * @return
	 */
	private List executeBatch(final String sql, final BatchParameter[] array){
	    final DAO dao = getDAO(getUserSession(), getUserSession().getCurrentDbService());
    	return dao.executeBatch(sql, array);
	}
	
	/**
	 * Prepara o bean passado por parametro para o insert.
	 * @param detSpcBean
	 * @return
	 */
	private BatchParameter[] preparaInsertRetorno(final String spcKey, final String descricao, final String valor,
	                                        final Date dataRetorno, final String tipo, 
	                                        final String codigoResposta){
	    final List lParam = new ArrayList();
    	//Chave que identifica os registros da tabela spc_cons com a tabela det_spc.
    	lParam.add(new BatchParameter(spcKey, Types.VARCHAR));
    	//Descrição de status retornado pelo serviço.
    	lParam.add(new BatchParameter(descricao, Types.VARCHAR));
    	//Valor retornado pelo serviço.
    	lParam.add(new BatchParameter(valor, Types.VARCHAR));
    	//Data de retorno do serviço.
    	lParam.add(new BatchParameter(dataRetorno , Types.DATE));
    	//Tipo baseado nos status do serviço.
    	lParam.add(new BatchParameter(tipo, Types.VARCHAR));
    	//Codigo de resposta baseado nos status do serviço.
    	lParam.add(new BatchParameter(codigoResposta, Types.VARCHAR));
    	
        // Converte a lista de parametros para um array
    	final BatchParameter[] array = convertListToBatchParameter(lParam);
        return array;
	}
	
	/**
     * 
     * @param bean
     * @return
     */
    private String identifierUsuario(final String idCidade) {
        SnCidadeBaseBean cidadeBaseBean = new SnCidadeBaseBean();
        cidadeBaseBean.setCidContrato(idCidade);

        cidadeBaseBean = (SnCidadeBaseBean) super.findByPrimaryKey(cidadeBaseBean);

        return cidadeBaseBean.getNmAlias()
                             + "\\" + getUserSession().getUserId();
    }

	/**
	 * Recuperar o parametro ATIVAR_CONWEB_SERASA para verificar se
	 * vai executar a consulta ao web service do serasa pelo netSales.
	 * @param dbProspect
	 * @return
	 */
	private String getParamConsultaWebServiceSerasa(final CpProspectBean prospect) {
        List ativaWebService = null;
        if(prospect != null && prospect.getCidadeOperadora() != null
                                                && prospect.getCidadeOperadora().getSnCidade() != null)
        	ativaWebService = 
        	    super.search(CreditoConstants.LST_PARAN_HAB_CONS_WEB_SERVICE_SERASA, 
        	                                        prospect.getCidadeOperadora().getSnCidade(), false);
        String consWebService = "";
        if(ativaWebService != null && !ativaWebService.isEmpty()
                                                && (ativaWebService.get(0) 
                                                                                        instanceof BigDecimal))
        	consWebService = 
        	    String.valueOf((BigDecimal)ativaWebService.get(0)); 
		return consWebService;
	}
	
	/**
	 * Bean para armazenar as informações retornadas pelo web service serasa. 
	 * @author wabreu
	 *
	 */
	class BeanRespostaSerasa{
		
		private CpProspectBean prospect;
		private String statusRetornado;
		private String nomeTitularRetornado;
		private Date dataNascimentoRetornado;
		private String nomeMaeRetornado;
		private String descricaoRetornoServico;
		private String valor;
		private String tipo;
		private Date dataRetornada;
		private String codigoResposta;
		private Date inicioChamadaServico;
		private Date fimChamadaServico;
		
		public CpProspectBean getProspect() {
			return prospect;
		}
		public void setProspect(CpProspectBean prospect) {
			this.prospect = prospect;
		}
		public String getStatusRetornado() {
			return statusRetornado;
		}
		public void setStatusRetornado(String statusRetornado) {
			this.statusRetornado = statusRetornado;
		}
		public String getNomeTitularRetornado() {
			return nomeTitularRetornado;
		}
		public void setNomeTitularRetornado(String nomeTitularRetornado) {
			this.nomeTitularRetornado = nomeTitularRetornado;
		}
		public Date getDataNascimentoRetornado() {
			return dataNascimentoRetornado;
		}
		public void setDataNascimentoRetornado(Date dataNascimentoRetornado) {
			this.dataNascimentoRetornado = dataNascimentoRetornado;
		}
		public String getNomeMaeRetornado() {
			return nomeMaeRetornado;
		}
		public void setNomeMaeRetornado(String nomeMaeRetornado) {
			this.nomeMaeRetornado = nomeMaeRetornado;
		}
		public String getDescricaoRetornoServico() {
			return descricaoRetornoServico;
		}
		public void setDescricaoRetornoServico(String descricaoRetornoServico) {
			this.descricaoRetornoServico = descricaoRetornoServico;
		}
		public String getValor() {
			if(valor == null){
				valor = "0";
			}
			return valor;
		}
		public void setValor(String valor) {
			this.valor = valor;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public Date getDataRetornada() {
			if(dataRetornada == null){
			try{
		    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		    	//Data caso não seja encontrado nenhuma data na string de retorno do serviço serasa.
		    	dataRetornada = format.parse("30/12/1899");
		    	}catch (ParseException e) {
					throw new BaseFailureException(e);					    		
		    	}
			}		    	
			return dataRetornada;
		}
		public void setDataRetornada(Date dataRetornada) {
			this.dataRetornada = dataRetornada;
		}
		public String getCodigoResposta() {
			return codigoResposta;
		}
		public void setCodigoResposta(String codigoResposta) {
			this.codigoResposta = codigoResposta;
		}
		public String getInicioChamadaServico() {
			return this.getDate(inicioChamadaServico);
		}
		public void setInicioChamadaServico(Date inicioChamadaServico) {
			this.inicioChamadaServico = inicioChamadaServico;
		}
		public String getFimChamadaServico() {
			return this.getDate(fimChamadaServico);
		}
		public void setFimChamadaServico(Date fimChamadaServico) {
			this.fimChamadaServico = fimChamadaServico;
		}
		private String getDate(Date date){
			if(date != null){
				SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
				return fmt.format(date);
			}
			return "";
		}
	}
	
	
	/**
	 * Executa a chamada ao Web Service do serasa passando os parametros necessários;
	 * @param dbProspect
	 * @return
	 */
    private AnalisarCreditoResponse getWebServiceSerasa(String cnpj, String cpf, DynamicBean dados){
    	
    	AnalisarCreditoResponse retornoServico = new AnalisarCreditoResponse();
    	
    	try{
    		
    		final WsgestordecisaoSoapWebService service = WebServiceFactory.getService(
    				WsgestordecisaoSoapWebService.class,context.getCallerPrincipal()
	    			,ManutencaoDadosCobrancaContants.APPLICATION_CONTEXT_WEBSERVICE);
	    	
	    	final AnalisarCredito analisarCredito = new AnalisarCredito();
	    	analisarCredito.setSCNPJ(cnpj);
	    	analisarCredito.setSUsrGC((String)dados.get(CreditoConstants.USER_GC));
	    	analisarCredito.setSPassGC((String)dados.get(CreditoConstants.PASS_GC));
	    	analisarCredito.setSUsrSer((String)dados.get(CreditoConstants.USER_SERASA));
	    	analisarCredito.setSPassSer((String)dados.get(CreditoConstants.PASS_SERASA));
	    	analisarCredito.setSDoc(cpf);
	    	analisarCredito.setSScore("");
	    	analisarCredito.setVrCompra(0);
	    	analisarCredito.setBSerasa(true);
	    	analisarCredito.setBAtualizar(false);
	    	analisarCredito.setSOnLine("");
	    	retornoServico = service.analisarCredito(analisarCredito, null); 
    	}catch (Exception e){
    		throw new BaseFailureException(e);
    	}
    	return retornoServico;
    }
    
    
    /**
     * Método invoca os servoços de Checagem Interna e Externa
     * 
     *@ejb.interface-method view-type = "both"
     *@ejb.transaction type="Required"
     *@ejb.permission role-name="CRM_CHECAR_CREDITO_INTERNO,CRM_CHECAR_CREDITO_EXTERNO"
     * 
     * @param dados
     * @return DynamicBean
     */
    public DynamicBean checarCreditoInternoExterno(final DynamicBean dados) {
        
        final DynamicBean retorno = new DynamicBean();
        
        CpProspectBean dbProspect = new CpProspectBean();
        dbProspect.setIdProspect( (Long) dados.get(CreditoConstants.ID_PROSPECT));
        dbProspect = (CpProspectBean) super.findByPrimaryKey(dbProspect);
        
        if(dbProspect == null){
            retorno.put("error", true);
            return retorno;
        }
        
        dbProspect.setCpf((Long) dados.get(CreditoConstants.CPF));
        dbProspect.setCnpj((Long) dados.get(CreditoConstants.CNPJ));
        dbProspect.setIdTipoPessoa((Integer) dados.get(CreditoConstants.ID_TIPO_PESSOA));
                
        // Consome o WebService do Serasa
        consomeWebServiceSerasa(dados);
                
        final Integer verifCredito = validarCreditoInternoExterno(dbProspect);
        
        retorno.put(CreditoConstants.RETORNO, verifCredito);
        retorno.put(CreditoConstants.VERIFICACAO_CREDITO, setStatusCredito(verifCredito));
        
        return retorno;
    }
    
}