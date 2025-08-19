package br.com.netservicos.netcrmcore.prospect.core.facade.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import br.com.netservicos.core.bean.cp.CpChamadoBean;
import br.com.netservicos.core.bean.cp.CpCidadeOperadoraBean;
import br.com.netservicos.core.bean.cp.CpEnderecoProspectBean;
import br.com.netservicos.core.bean.cp.CpPropostaBean;
import br.com.netservicos.core.bean.cp.CpProspectBean;
import br.com.netservicos.core.bean.cp.CpTipoEnderecoBean;
import br.com.netservicos.core.bean.geo.GeoCidadesBean;
import br.com.netservicos.core.bean.sn.SnMidiaBean;
import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.core.dao.BatchParameter;
import br.com.netservicos.framework.exception.business.ValidationMessage;
import br.com.netservicos.framework.exception.system.ResourceException;
import br.com.netservicos.framework.util.exception.BaseBusinessException;
import br.com.netservicos.framework.util.exception.BaseFailureException;
import br.com.netservicos.netcrmcore.endereco.core.facade.EnderecoService;
import br.com.netservicos.netcrmcore.geral.constants.GeralConstants;
import br.com.netservicos.netcrmcore.geral.util.DateUtils;
import br.com.netservicos.netcrmcore.geral.util.GeralUtil;
import br.com.netservicos.netcrmcore.prospect.constants.ProspectConstants;
import br.com.netservicos.netcrmcore.prospect.core.facade.ProspectService;
import br.com.netservicos.netcrmcore.prospect.resources.NETCRMProspectResources;
import br.com.netservicos.netcrmcore.venda.agendamento.facade.AgendamentoService;
import br.com.netservicos.netcrmcore.venda.proposta.facade.PropostaService;
import br.com.netservicos.netcrmcore.venda.proposta.pendencia.facade.PendenciaService;
/**
 * EJB responsável pela validação / alteração dos dados cadastrais do cliente.
 * 
 * @author gmello@artit.com.br
 * 
 * @ejb.bean name="ProspectEJB" type="Stateless" display-name="ProspectEJB"
 *           description="ProspectEJB Session EJB Stateless" view-type="both"
 *           jndi-name="netcrmcore/prospect/ejb/ProspectEJB"
 *           local-jndi-name="netcrmcore/prospect/ejb/local/ProspectEJB"
 *           transaction-type="Container"
 * 
 * @ejb.interface local-extends="javax.ejb.EJBLocalObject"
 *                extends="javax.ejb.EJBObject"
 * 
 * @ejb.home local-extends="javax.ejb.EJBLocalHome" extends="javax.ejb.EJBHome"
 * 
 */
public class ProspectEJBImpl extends AbstractNETCRMProspectEJBImpl implements 
		ProspectService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1713492184667436066L; 

	private static final String ID_PROSPECT = "idProspect";    
    private static final String ENDERECO = "endereco";  
    private static final String NUMERO = "numero";
    private static final String COMPLEMENTO = "complemento";
    private static final String BAIRRO = "bairro";
    private static final String CIDADE = "cidade";
    private static final String ESTADO = "estado";
    private static final String CEP = "cep";
    private static final String REFERENCIA = "referencia";
    
	/**
	 * <p>
     * <b>Description: Método responsavel por criar o prospect,proposta e associar o endereço de 
     *     instalaçao com o HP</b><br/>
     * <p>
     * 
     * @see br.com.netservicos.netcrmcore.prospect.core.facade #criarProposta()
     * @return Bean
     * 
     *@ejb.interface-method view-type = "both"
     *@ejb.transaction   type = "Required"
     *@ejb.permission role-name="CRM_MANTER_PROSPECT,CRM_MANTER_DADOS_ENDERECO_PROPOSTA"
     */
	public Bean criarProposta(final Bean dadosProsposta) {      
						
		final PropostaService propostaService = getService(PropostaService.class);
		final EnderecoService enderecoService = getService(EnderecoService.class);
		final List<ValidationMessage> erros =  validarDadosProspota(dadosProsposta);
		if(erros.isEmpty()) {
    		inserirProspect(dadosProsposta);
    		propostaService.inserirProposta(dadosProsposta);    		
    		inserirEndereco(dadosProsposta, enderecoService);
		}else{
		    this.lancarErrosValidacao(erros); 
		}
		
		return dadosProsposta;
	}



    /**
     * @param dadosProsposta
     * @param enderecoService
     */
    private void inserirEndereco(Bean dadosProsposta, EnderecoService enderecoService) {
        
        Long idProposta = GeralUtil.toLong(dadosProsposta.getBeanProperty(GeralConstants.ID_PROPOSTA));
        DynamicBean dynaStatusPayTv = enderecoService.alterarEnderecoProspect(dadosProsposta);
        String statusComercialPayTv = (String) dynaStatusPayTv.get(GeralConstants.PROC_STATUS_COMERCIAL);
        String statusTecnicoPayTv = (String) dynaStatusPayTv.get(GeralConstants.PROC_STATUS_TECNICO);
                 
      //  PendenciaService pendencia = getService(PendenciaService.class);
      //  pendencia.inserirPendenciaEnderecoProposta(idProposta, statusComercialPayTv, statusTecnicoPayTv);
                
        liberarAgendamento(idProposta);
    }



    /**
     * @param idProposta
     */
    private void liberarAgendamento(Long idProposta) {
        AgendamentoService agendaService = getService(AgendamentoService.class);
        agendaService.liberaData(idProposta);
    }
    
    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * 
     * @param idProposta
     * @return
     * @since 22/09/2010
     */
    private CpPropostaBean obterProposta(Long idProposta){
        CpPropostaBean proposta = new CpPropostaBean();
        proposta.setLazyProperties(new String[]{GeralConstants.PONTOS});
        proposta.setIdProposta(idProposta);
        proposta = (CpPropostaBean) super.findByPrimaryKey(proposta);
        return proposta;  
    }
	
	
    
	/**
	 * <p>
     * <b>Description:</b><br/>
     * <p> 	
	 * @param dadosProsposta
	 * @return
	 * @since 22/09/2010
	 */
    private List<ValidationMessage> validarDadosProspota(final Bean dadosProsposta) {
        
        final List<ValidationMessage> errorList = new ArrayList<ValidationMessage>();
        final Integer codHp = GeralUtil.toInteger(dadosProsposta.getBeanProperty(ProspectConstants.PROPERTY_COD_HP)); 
        final String cidContrato = GeralUtil.toString(dadosProsposta.getBeanProperty(ProspectConstants.CID_CONTRATO));
        final String nome = GeralUtil.toString(dadosProsposta.getBeanProperty(ProspectConstants.NOME));        
        final Integer idTipoVenda = GeralUtil.toInteger(dadosProsposta.getBeanProperty(ProspectConstants.ID_TIPO_VENA));
        final Integer idCampanha = GeralUtil.toInteger(dadosProsposta.getBeanProperty(ProspectConstants.ID_CAMPANHA));
        final Integer idTipoContrato = GeralUtil.toInteger(dadosProsposta.
                                                getBeanProperty(ProspectConstants.ID_TIPO_CONTRATO));
        final Integer idTipoAssinante = GeralUtil.toInteger(dadosProsposta.
                                                getBeanProperty(ProspectConstants.ID_TIPO_ASSINANTE));
        final Integer idMidia = GeralUtil.toInteger(dadosProsposta.getBeanProperty(ProspectConstants.MIDIA));
        
        if (StringUtils.isBlank(nome)) {
            errorList.add(getValidationMessage(ProspectConstants.DADOS_PROPOSTA_NOME_INFORMADO,
                                                    new Object[]{ProspectConstants.NOME}));
        }
        if (StringUtils.isBlank(cidContrato)) {
            errorList.add(getValidationMessage(ProspectConstants.DADOS_PROPOSTA_CID_CONTRATO_INFORMADO,
                                                    new Object[]{ProspectConstants.CID_CONTRATO}));
        }       
        if (GeralUtil.isNull(codHp)) {
            errorList.add(getValidationMessage(ProspectConstants.DADOS_PROPOSTA_COD_HP_INFORMADO,
                                                    new Object[]{ProspectConstants.PROPERTY_COD_HP}));
        }
        if (GeralUtil.isNull(idMidia)) {
            errorList.add(getValidationMessage(ProspectConstants.DADOS_PROPOSTA_MIDIA_INFORMADO,
                                                    new Object[]{ProspectConstants.MIDIA}));
        }
        if (GeralUtil.isNull(idTipoVenda)) {
            errorList.add(getValidationMessage(ProspectConstants.DADOS_PROPOSTA_TIPO_VENDA_INFORMADO,
                                                    new Object[]{ProspectConstants.ID_TIPO_VENA}));
        }
        if (GeralUtil.isNull(idCampanha)) {
            errorList.add(getValidationMessage(ProspectConstants.DADOS_PROPOSTA_CAMPANHA_INFORMADO,
                                                    new Object[]{ProspectConstants.ID_CAMPANHA}));
        }
        if (GeralUtil.isNull(idTipoContrato)) {
            errorList.add(getValidationMessage(ProspectConstants.DADOS_PROPOSTA_TIPO_CONTRATO_INFORMADO,
                                                    new Object[]{ProspectConstants.ID_TIPO_CONTRATO}));
        }
        if (GeralUtil.isNull(idTipoAssinante)) {
            errorList.add(getValidationMessage(ProspectConstants.DADOS_PROPOSTA_TIPO_ASSINANTE_INFORMADO,
                                                    new Object[]{ProspectConstants.ID_TIPO_ASSINANTE}));
        }
        
        return errorList;
    }

   
	
	/**
	 * <p>
     * <b>Description:</b><br/>
     * <p>
	 * @param dadosProsposta
	 * @return CpProspectBean
	 * @since 22/09/2010
	 */
	private void inserirProspect(final Bean dadosProsposta) {

		CpProspectBean prospectToInsert = new CpProspectBean();
		prospectToInsert.setNome(dadosProsposta.getBeanProperty(ProspectConstants.NOME));
		
		final String cidContrato = dadosProsposta.getBeanProperty(ProspectConstants.CID_CONTRATO);
		final Integer idMidia = GeralUtil.toInteger(dadosProsposta.getBeanProperty(ProspectConstants.MIDIA));
				
		CpCidadeOperadoraBean cidade = new CpCidadeOperadoraBean();
		cidade.setIdCidade(cidContrato);
		cidade = (CpCidadeOperadoraBean) super.findByPrimaryKey(cidade);
		prospectToInsert.setCidadeOperadora(cidade);		
		prospectToInsert.setDddTelPrincipal(GeralUtil
				.formataDDD(dadosProsposta.getBeanProperty(ProspectConstants.DDD)));
		prospectToInsert.setTelPrincipal(GeralUtil.getString(dadosProsposta
				.getBeanProperty(ProspectConstants.TELEFONE)));
		final SnMidiaBean midia = getMidia(idMidia);
		if(!GeralUtil.isNull(midia)){
		    prospectToInsert.setIdMidia(midia.getIdMidia());
		}
		prospectToInsert = (CpProspectBean) super.insert(prospectToInsert,
				getUserSession().getCurrentDbService());
		final CpChamadoBean chamado = new CpChamadoBean();
		chamado.setProspect((CpProspectBean) prospectToInsert);
		chamado.setUser(getUserSession().getUserId());
		chamado.setDtChamado(new Date());
		chamado.setUsuLogon(getUserSession().getUserId());
		super.insert(chamado, getUserSession().getCurrentDbService());
		dadosProsposta.addBeanProperty(ProspectConstants.ID_PROSPECT, 
		                                        GeralUtil.toString(prospectToInsert.getIdProspect()));		
	}
	
	/**
	 * <p>
     * <b>Description:</b><br/>
     * <p>
	 * @param cidade
	 * @param midia
	 * @return Integer
	 * @since 22/09/2010
	 */   
    private SnMidiaBean getMidia(final Integer idMidia) {	
		SnMidiaBean midia = new SnMidiaBean();
		midia.setIdMidia(idMidia);
		midia = (SnMidiaBean) findByPrimaryKey(midia);
		return midia;
	}

    
    
    
	/**
	 * Método responsável por alterar os dados do prospect
	 * 
	 * @param complemento
	 * @param email
	 * @param dataNascimento
	 * @param cpf
	 * @param rg
	 * @param telCelular
	 * @param telComerical
	 * @param telResidencial
	 * 
	 * @ejb.interface-method view-type = "both"
	 * @ejb.transaction type="Required"
	 * @ejb.permission role-name="CRM_ALTERAR_DADOS_PESSOAIS"  
	 * 
	 */
	public void alterarDadosPessoais(final Bean bean) {

		final DynamicBean dynaBean = (DynamicBean) bean;
		
		hasErrors(dynaBean);
		
		final String idTipoPessoa = ((String)dynaBean.get(ProspectConstants.ID_TIPO_PESSOA));
		final String sexo = ((String) dynaBean.get(ProspectConstants.SEXO));
		final String dsCpf = ((String) dynaBean.get(ProspectConstants.DS_CPF));
		final String dsCnpj = ((String) dynaBean.get(ProspectConstants.DS_CNPJ));	

		CpProspectBean prospectBean = new CpProspectBean();
		prospectBean.setIdProspect( Long.valueOf((String) dynaBean.get(ProspectConstants.ID_PROSPECT)));
		prospectBean = (CpProspectBean) super.findByPrimaryKey(prospectBean);

	      
        if(prospectBean == null){
            final String mensagem = this.getMessage(NETCRMProspectResources.RESOURCE_PROSPECT_INEXISTENTE);
            final ResourceException exception = new ResourceException(NETCRMProspectResources.
                                                    RESOURCE_PROSPECT_INEXISTENTE, mensagem, this.getClass().getName());
            throw exception;
        }
        
        prospectBean.setNome(((String) dynaBean.get(ProspectConstants.DS_NOME)).toUpperCase());
        if(!"".equals(sexo)){
            prospectBean.setSexo(Integer.valueOf(sexo));
        }
        
        if("".equals((String)dynaBean.get(ProspectConstants.ORGAO_EXPEDIDOR))){ 
            prospectBean.setIdOrgaoExpedidor(Integer.valueOf("0"));
        }else{
            prospectBean.setIdOrgaoExpedidor(Integer.valueOf((String)dynaBean.get(ProspectConstants.ORGAO_EXPEDIDOR)));
        }
        
        if("".equals((String)dynaBean.get(ProspectConstants.ESTADO_CIVIL))){
            prospectBean.setIdEstadoCivil(Integer.valueOf("5"));
        }else{
            prospectBean.setIdEstadoCivil(Integer.valueOf((String)dynaBean.get(ProspectConstants.ESTADO_CIVIL)));
        }
        
        if("".equals((String)dynaBean.get(ProspectConstants.PROFISSAO))){
            prospectBean.setIdProfissao(Integer.valueOf("51"));
        }else{
            prospectBean.setIdProfissao(Integer.valueOf((String)dynaBean.get(ProspectConstants.PROFISSAO)));
        }
		prospectBean.setEmail((String) dynaBean.get(ProspectConstants.DS_EMAIL));
		prospectBean.setDataNascimento(DateUtils.converteStringToDate((String) 
		                                        dynaBean.get(ProspectConstants.DT_NASCIMENTO)));
		
		if(!"".equals(idTipoPessoa)){
			if(Integer.valueOf(idTipoPessoa).equals(1)){
				if(!"".equals(dsCpf)){
					prospectBean.setCpf( Long.valueOf(dsCpf));
				}
			}else{
				if(!"".equals(dsCnpj)){
					prospectBean.setCnpj( Long.valueOf(dsCnpj));
				}
			}
		}
			
		if(!"".equals(idTipoPessoa)){
		    prospectBean.setIdTipoPessoa(Integer.valueOf(idTipoPessoa));
		}
		String dddTelCom = GeralUtil.formataDDD(dynaBean.getBeanProperty(ProspectConstants.DDD_TEL_COM));
		String telCom =dynaBean.getBeanProperty(ProspectConstants.TEL_COMERCIAL);
		
		String dddTelTelRes = GeralUtil.formataDDD(dynaBean.getBeanProperty(ProspectConstants.DDD_TEL_RES));
        String telTelRes = dynaBean.getBeanProperty(ProspectConstants.TEL_RESIDENCIAL);
        
        String dddTelCel = GeralUtil.formataDDD(dynaBean.getBeanProperty(ProspectConstants.DDD_CELULAR));
		
		prospectBean.setRg((String) dynaBean.get(ProspectConstants.DS_RG));
		prospectBean.setIe((String) dynaBean.get(ProspectConstants.DS_IE));
		
		if(!GeralUtil.isEmpty(dddTelCom) && !GeralUtil.isEmpty(telCom)){
		    prospectBean.setDddTelCom((dddTelCom));
		    prospectBean.setTelCom(telCom);
		}	    
		
		if(!GeralUtil.isEmpty(dddTelTelRes) && !GeralUtil.isEmpty(telTelRes)){
		    prospectBean.setDddTelRes(dddTelTelRes);
		    prospectBean.setTelRes(telTelRes);		
		    prospectBean.setDddTelPrincipal(dddTelTelRes);
		    prospectBean.setTelPrincipal(telTelRes);
		}	    		
		prospectBean.setCcTelCel(dddTelCel + (String) dynaBean.get(ProspectConstants.TEL_CELULAR));
		super.update(prospectBean, super.getUserSession().getCurrentDbService());
	}

	
	/**
	 * <p>
     * <b>Description: Verifica de existencia de dados inconsistente para o Prospect.</b><br/>
     * <b>Alteração para adequar o nono digito de telefone celular.</b><br/>
     * <p>
     * 
	 * @param Bean Prospect
	 * @since 22/09/2010
	 */
	private void hasErrors(final Bean bean) {
		
		final DynamicBean dynaBean = (DynamicBean) bean;
		
		final String idTipoPessoa = (String)dynaBean.get(ProspectConstants.ID_TIPO_PESSOA);	
		final String dddTelRes = (String) dynaBean.get(ProspectConstants.DDD_TEL_RES);
		final String telRes = (String) dynaBean.get(ProspectConstants.TEL_RESIDENCIAL);
		final String dddTelCom = (String) dynaBean.get(ProspectConstants.DDD_TEL_COM);
		final String telCom = (String) dynaBean.get(ProspectConstants.TEL_COMERCIAL);
		final String dddTelCel = (String) dynaBean.get(ProspectConstants.DDD_CELULAR);
        final String telCel = (String) dynaBean.get(ProspectConstants.TEL_CELULAR);
				
		String mensagem  = null;
		// Pessoa fisica
		if("1".equals(idTipoPessoa)){
		    
		    if(dddTelRes == null || dddTelRes.equals("")){
                mensagem = this.getMessage(NETCRMProspectResources.DDD_RES_OBRIGATORIO);
                final ResourceException exception = new ResourceException(NETCRMProspectResources.DDD_RES_OBRIGATORIO,
                                                        mensagem, this.getClass().getName());
                throw exception;
            }else{
                
               if((dddTelCom == null || dddTelCom.equals("")) && (dddTelCel == null || dddTelCel.equals(""))){
                   mensagem = this.getMessage(NETCRMProspectResources.DDD_COM_CEL_OBRIGATORIO);
                   final ResourceException exception = new ResourceException(NETCRMProspectResources.
                                                           DDD_COM_CEL_OBRIGATORIO,
                                                           mensagem, this.getClass().getName());
                   throw exception;
               }
               
               if((dddTelCom == null || dddTelCom.equals("")) && !telCom.equals("") ) {
                   
                   mensagem = this.getMessage(NETCRMProspectResources.DDD_COM_OBRIGATORIO);
                   final ResourceException exception = new ResourceException(NETCRMProspectResources.
                                                           DDD_COM_OBRIGATORIO,
                                                           mensagem, this.getClass().getName());
                   throw exception;
                   
               }
               if((dddTelCel == null || dddTelCel.equals("")) && !telCel.equals("") ) {
                   
                   mensagem = this.getMessage(NETCRMProspectResources.DDD_CEL_OBRIGATORIO);
                   final ResourceException exception = new ResourceException(NETCRMProspectResources.
                                                           DDD_CEL_OBRIGATORIO,
                                                           mensagem, this.getClass().getName());
                   throw exception;
                   
               }
            }
		    
		    if(telRes == null  || telRes.equals("")){
                mensagem = this.getMessage(NETCRMProspectResources.TEL_RES_OBRIGATORIO);
                final ResourceException exception = new ResourceException(NETCRMProspectResources.
                                                        TEL_RES_OBRIGATORIO, 
                                                        mensagem, this.getClass().getName());
                throw exception;
            }else{
                
                if((telCom == null || telCom.equals("")) && (telCel == null || telCel.equals(""))){
                    mensagem = this.getMessage(NETCRMProspectResources.TEL_COM_CEL_OBRIGATORIO);
                    final ResourceException exception = new ResourceException(NETCRMProspectResources.
                                                            TEL_COM_CEL_OBRIGATORIO,
                                                            mensagem, this.getClass().getName());
                    throw exception;
                }
                if((telCom == null || telCom.equals("")) && !dddTelCom.equals("") ) {
                    
                    mensagem = this.getMessage(NETCRMProspectResources.TEL_COM_OBRIGATORIO);
                    final ResourceException exception = new ResourceException(NETCRMProspectResources.
                                                            TEL_COM_OBRIGATORIO,
                                                            mensagem, this.getClass().getName());
                    throw exception;
                    
                }
                if((telCel == null || telCel.equals("")) && !dddTelCel.equals("") ) {
                    
                    mensagem = this.getMessage(NETCRMProspectResources.TEL_CEL_OBRIGATORIO);
                    final ResourceException exception = new ResourceException(NETCRMProspectResources.
                                                            TEL_CEL_OBRIGATORIO,
                                                            mensagem, this.getClass().getName());
                    throw exception;
                    
                }
            }
			
			if(dddTelRes != null && ! dddTelRes.equals("") && dddTelRes.trim().length() != Integer.valueOf("2")){
				mensagem = this.getMessage(NETCRMProspectResources.DDD_RES_INVALIDO, new Object[] { dddTelRes });
				final ResourceException exception = new ResourceException(NETCRMProspectResources.DDD_RES_INVALIDO, 
				                                        mensagem, this.getClass().getName());
				throw exception;
			}
			
			if(telRes != null && ! telRes.equals("") && (telRes.trim().length() < Integer.valueOf("8") 
					|| telRes.trim().length() > Integer.valueOf("9"))){
				mensagem = this.getMessage(NETCRMProspectResources.TEL_RES_INVALIDO, new Object[] { telRes });
				final ResourceException exception = new ResourceException(NETCRMProspectResources.TEL_RES_INVALIDO, 
				                                        mensagem, this.getClass().getName());
				throw exception;
			}
			
			if(dddTelCom != null && ! dddTelCom.equals("") && dddTelCom.trim().length() != Integer.valueOf("2")){
				mensagem = this.getMessage(NETCRMProspectResources.DDD_COM_INVALIDO, new Object[] { dddTelCom });
				final ResourceException exception = new ResourceException(NETCRMProspectResources.DDD_COM_INVALIDO,
				                                        mensagem, this.getClass().getName());
				throw exception;
			}
			
			if(telCom != null && ! telCom.equals("") && (telCom.trim().length() < Integer.valueOf("8") 
					|| telCom.trim().length() > Integer.valueOf("9"))){
				mensagem = this.getMessage(NETCRMProspectResources.TEL_COM_INVALIDO, new Object[] { telCom });
				final ResourceException exception = new ResourceException(NETCRMProspectResources.TEL_COM_INVALIDO, 
				                                        mensagem, this.getClass().getName());
				throw exception;
			}
			
			//nono digito
			if(dddTelCel != null && ! dddTelCel.equals("") && dddTelCel.trim().length() != Integer.valueOf("2")){
				mensagem = this.getMessage(NETCRMProspectResources.DDD_CEL_INVALIDO, new Object[] { dddTelCel });
				final ResourceException exception = new ResourceException(NETCRMProspectResources.DDD_CEL_INVALIDO,
				                                        mensagem, this.getClass().getName());
				throw exception;
			}
			
			if(telCel != null && ! telCel.equals("") && (telCel.trim().length() < Integer.valueOf("8") 
					|| telCel.trim().length() > Integer.valueOf("9"))){
				mensagem = this.getMessage(NETCRMProspectResources.TEL_CEL_INVALIDO, new Object[] { telCel });
				final ResourceException exception = new ResourceException(NETCRMProspectResources.TEL_CEL_INVALIDO, 
				                                        mensagem, this.getClass().getName());
				throw exception;
			}
		}
		
		// Pessoa jurídica
		if("2".equals(idTipoPessoa)){
			
			if(dddTelCom != null && ! dddTelCom.equals("") && dddTelCom.trim().length() != Integer.valueOf("2")){
				mensagem = this.getMessage(NETCRMProspectResources.DDD_COM_INVALIDO, new Object[] { dddTelCom });
				final ResourceException exception = new ResourceException(NETCRMProspectResources.DDD_COM_INVALIDO, 
				                                        mensagem, this.getClass().getName());
				throw exception;
			}
			
			if(telCom != null && ! telCom.equals("") && (telCom.trim().length() < Integer.valueOf("8") || 
					telCom.trim().length() > Integer.valueOf("9"))){
				mensagem = this.getMessage(NETCRMProspectResources.TEL_COM_INVALIDO, new Object[] { telCom });
				final ResourceException exception = new ResourceException(NETCRMProspectResources.TEL_COM_INVALIDO, 
				                                        mensagem, this.getClass().getName());
				throw exception;
			}
			// nono digito
			if(dddTelCel != null && ! dddTelCel.equals("") && dddTelCel.trim().length() != Integer.valueOf("2")){
				mensagem = this.getMessage(NETCRMProspectResources.DDD_CEL_INVALIDO, new Object[] { dddTelCel });
				final ResourceException exception = new ResourceException(NETCRMProspectResources.DDD_CEL_INVALIDO, 
				                                        mensagem, this.getClass().getName());
				throw exception;
			}
			
			if(telCel != null && ! telCel.equals("") && (telCel.trim().length() < Integer.valueOf("8") || 
					telCel.trim().length() > Integer.valueOf("9"))){
				mensagem = this.getMessage(NETCRMProspectResources.TEL_CEL_INVALIDO, new Object[] { telCel });
				final ResourceException exception = new ResourceException(NETCRMProspectResources.TEL_CEL_INVALIDO, 
				                                        mensagem, this.getClass().getName());
				throw exception;
			}
		}
	}
	
	/**
     * <p>
     * <b>Description:</b><br/>
     * Metodo responsavel por manter os dados de endereço de cobrança de um prospect.
     * <p>
     * 
     * @since 22/09/2010
     * @author Alessandro Mariano
     * @param Bean
     *
     * @ejb.interface-method view-type = "both"
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="CRM_MANTER_DADOS_ENDERECO_COBRANCA"
     * 
     */
    public void manterDadosEnderecoCobranca(final Bean enderecoCobranca) {
        
        final Long idProspect = Long.valueOf((String)enderecoCobranca.getBeanProperty(ID_PROSPECT));
        final Integer idTipoEndereco = Integer.valueOf(2) ;
        final String endereco = enderecoCobranca.getBeanProperty(ENDERECO);
        final String numero = enderecoCobranca.getBeanProperty(NUMERO);
        final String complemento =enderecoCobranca.getBeanProperty(COMPLEMENTO);
        final String bairro = enderecoCobranca.getBeanProperty(BAIRRO);
        final String cidade = enderecoCobranca.getBeanProperty(CIDADE);
        final String estado = enderecoCobranca.getBeanProperty(ESTADO);
        final String cep = enderecoCobranca.getBeanProperty(CEP);
        final String referencia = enderecoCobranca.getBeanProperty(REFERENCIA);
        
        final List<ValidationMessage> erros =  validarDadosEnderecoCobranca(enderecoCobranca);
		if(erros.isEmpty()) {
			CpEnderecoProspectBean enderecoProspect = searchEnderecoProspectByTipoEndereco(enderecoCobranca);
			
			if (enderecoProspect == null) {
				CpEnderecoProspectBean  enderecoPros = new CpEnderecoProspectBean();
		        enderecoPros.setTipoEndereco(obterTipoEndereco(idTipoEndereco));
		        enderecoPros.setProspect(obterProspect(idProspect));
		        enderecoPros.setDesclogradouro(endereco);
		        enderecoPros.setNumero(numero);
		        enderecoPros.setComplemento(complemento);
		        enderecoPros.setBairro(bairro);
		        enderecoPros.setCidade(cidade);
		        enderecoPros.setEstado(estado);
		        enderecoPros.setCep(cep);
		        enderecoPros.setReferencia(referencia);
		        enderecoPros = validateEnderecoCobranca(enderecoPros);
		        
				this.getCurrentDAO().insert(enderecoPros);
			} else {			
				enderecoProspect.setTipoEndereco(obterTipoEndereco(idTipoEndereco));
				enderecoProspect.setProspect(obterProspect(idProspect));
				enderecoProspect.setDesclogradouro(endereco);
				enderecoProspect.setNumero(numero);
				enderecoProspect.setComplemento(complemento);
				enderecoProspect.setBairro(bairro);
				enderecoProspect.setCidade(cidade);
				enderecoProspect.setEstado(estado);
				enderecoProspect.setCep(cep);
				enderecoProspect.setReferencia(referencia);
				enderecoProspect = validateEnderecoCobranca(enderecoProspect);
				this.getCurrentDAO().update(enderecoProspect);
			}
		}else{
		    this.lancarErrosValidacao(erros);
		}
    }

	/**
	 * <p>
     * <b>Description:</b><br/>
     * <p> 	
	 * @param dadosProsposta
	 * @return
	 * @since 22/09/2010
	 */
    private List<ValidationMessage> validarDadosEnderecoCobranca(final Bean enderecoCobranca) {
        
        final List<ValidationMessage> errorList = new ArrayList<ValidationMessage>();
        
        final Long idProspect = Long.valueOf((String)enderecoCobranca.getBeanProperty(ID_PROSPECT));

		final CpProspectBean cpProspect = new CpProspectBean();
	    cpProspect.setIdProspect(idProspect);
	    
	    final CpProspectBean localProspect = (CpProspectBean) this.getCurrentDAO().findByPrimaryKey(cpProspect);
	    
	    if (localProspect == null) {
	    	errorList.add(getValidationMessage(ProspectConstants.MSG_ID_PROSPECT_INVALIDO, new Object[]{ID_PROSPECT}));
	    }

        return errorList;
    }
    
    /**
     * @param enderecoCobranca
     * @return
     */
   @SuppressWarnings(GeralConstants.UNCHECKED)
   public CpEnderecoProspectBean validateEnderecoCobranca(CpEnderecoProspectBean enderecoCobranca) {

	   GeoCidadesBean geoCidade = new GeoCidadesBean(); 
       geoCidade.setCiNome(GeralUtil.replaceCaracteresSpeciais(enderecoCobranca.getCidade()));
       geoCidade.setCiEstado(GeralUtil.replaceCaracteresSpeciais(enderecoCobranca.getEstado()));
	   
	   ArrayList<String> lstIdCidade = new ArrayList<String>();
	   lstIdCidade = (ArrayList<String>) super.search(GeoCidadesBean.LST_ID_CIDADE_CORREIO_BY_ID_DESCRICAO_CIDADE, geoCidade);
	   
	   CpEnderecoProspectBean enderecoCobrancaRetorno = enderecoCobranca;
	   
	   if (lstIdCidade != null && !lstIdCidade.isEmpty()) {
		   for (String idCidade : lstIdCidade) {
			   //setar dados do retorno
			   enderecoCobrancaRetorno.setIdCidade(idCidade);
			   enderecoCobrancaRetorno.setEstado(enderecoCobranca.getEstado());
			   enderecoCobrancaRetorno.setDesclogradouro(enderecoCobranca.getDesclogradouro());
			   enderecoCobrancaRetorno.setBairro(enderecoCobranca.getBairro());
			   enderecoCobrancaRetorno.setCep(enderecoCobranca.getCep());
			   List lista = (List) listEnderecoLogradouro(enderecoCobrancaRetorno);
			   
			   if(lista != null && !lista.isEmpty()) {//verifica se retornou endereco dos correios
				   DynamicBean retorno = new DynamicBean();
				   List lstEndereco = (List) lista.get(5);
				   if (lstEndereco != null && !lstEndereco.isEmpty()) {
					   retorno = (DynamicBean) lstEndereco.get(0); //pega a posicao 5 da lista que é o endereço retornado e coloca os dados novos e corretos
		               if(retorno != null && !retorno.isEmpty()) {
	
		                   //enderecoCobrancaRetorno.
		                   enderecoCobrancaRetorno.setTipoEndereco(new CpTipoEnderecoBean());
		                   enderecoCobrancaRetorno.getTipoEndereco().setIdTipoEndereco(new Integer(CpTipoEnderecoBean.COBRANCA));
		                   enderecoCobrancaRetorno.setBairro((String)retorno.get("DS_BAIRRO_ABREV"));
		                   enderecoCobrancaRetorno.setDesclogradouro((String)retorno.get("LOGRADOURO_ABREV"));
		                   enderecoCobrancaRetorno.setEndcompleto((String)retorno.get("LOGRADOURO_ABREV"));
		                   enderecoCobrancaRetorno.setNumero(enderecoCobranca.getNumero());
		                   enderecoCobrancaRetorno.setCidade((String)retorno.get("DS_LOCALIDADE"));
		                   enderecoCobrancaRetorno.setCep(enderecoCobranca.getCep());
		                   enderecoCobrancaRetorno.setTipoPostagem("L");
		               }else{//se nao trouxe nada na lista é pq o cep nao existe nos correios, entao preenche com os dados iguais ao end. de instalacao
		                   CpEnderecoProspectBean enderecoInstalacao = obterEnderecoInstalacao(enderecoCobranca.getProspect().getIdProspect());                 
		                   copiaDadosEnderecodeInstalacao(enderecoCobrancaRetorno, enderecoInstalacao);
		               }
				   } else {
					   CpEnderecoProspectBean enderecoInstalacao = obterEnderecoInstalacao(enderecoCobranca.getProspect().getIdProspect());                 
	                   copiaDadosEnderecodeInstalacao(enderecoCobrancaRetorno, enderecoInstalacao);
				   }
	           }
		   }
	   } else {
		   CpEnderecoProspectBean enderecoInstalacao = obterEnderecoInstalacao(enderecoCobranca.getProspect().getIdProspect());                 
           copiaDadosEnderecodeInstalacao(enderecoCobrancaRetorno, enderecoInstalacao);
	   }
	   
	   return enderecoCobrancaRetorno;
   }



    /**
     * @param tpEnd
     * @param end
     * @param enderecoInstalacao
     */
    private void copiaDadosEnderecodeInstalacao(CpEnderecoProspectBean end,
                                            CpEnderecoProspectBean enderecoInstalacao) {
            
           CpTipoEnderecoBean tpEnd = new CpTipoEnderecoBean();
           tpEnd.setIdTipoEndereco(new Integer(CpTipoEnderecoBean.COBRANCA));
           end.setProspect(enderecoInstalacao.getProspect());
           end.setTipoEndereco(tpEnd);
           end.setBairro(enderecoInstalacao.getBairro());
           end.setDesclogradouro(enderecoInstalacao.getDesclogradouro());
           end.setEndcompleto(enderecoInstalacao.getDesclogradouro());
           end.setNumero(enderecoInstalacao.getNumero());
           end.setCidade(enderecoInstalacao.getCidade());
           end.setCep(enderecoInstalacao.getCep());
           end.setEstado(enderecoInstalacao.getEstado());
           end.setTipoPostagem("L");
    }
   
   /**
    * 
    * @param idProspect
    * @return
    */
   private CpEnderecoProspectBean obterEnderecoInstalacao(Long idProspect) {
       CpProspectBean prospect = new CpProspectBean();
       prospect.setIdProspect(idProspect);
       prospect = (CpProspectBean) super.findByPrimaryKey(prospect);
       
       CpEnderecoProspectBean enderecoInstalacao = null;
       if (prospect.getEnderecos() != null && !prospect.getEnderecos().isEmpty()) {
           for (Iterator iter = prospect.getEnderecos().iterator(); iter.hasNext();) {
               CpEnderecoProspectBean enderecoProspectBean = (CpEnderecoProspectBean) iter.next();
               if (GeralConstants.ID_TIPO_ENDERECO_INSTALACAO.equals(enderecoProspectBean.getTipoEndereco()
                                                       .getIdTipoEndereco())) {

                   enderecoInstalacao = enderecoProspectBean;
                   break;
               }
           }
       }
       return enderecoInstalacao;
   }
   
   private List listEnderecoLogradouro(Bean bean) {
       CpEnderecoProspectBean enderecoProspect = (CpEnderecoProspectBean) bean;
       try {
           BatchParameter[] parameters = new BatchParameter[6];
           parameters[0] = new BatchParameter(enderecoProspect.getEstado(), Types.VARCHAR);
           parameters[1] = new BatchParameter(new Integer(enderecoProspect.getIdCidade()), Types.NUMERIC);
           parameters[2] = new BatchParameter(enderecoProspect.getDesclogradouro().toUpperCase(), Types.VARCHAR);
           parameters[3] = new BatchParameter(enderecoProspect.getBairro().toUpperCase(), Types.VARCHAR);
           parameters[4] = new BatchParameter(enderecoProspect.getCep() != null && !"".equals(enderecoProspect.getCep()) ? new Integer(
                                           enderecoProspect.getCep()) : null, Types.NUMERIC);
           parameters[5] = new BatchParameter(BatchParameter.ORACLE_CURSOR, true);

           List lista = getCurrentDAO().executeBatch(ProspectConstants.PROC_PGGED_ENDERECO_PR_ECN_LOGRADOURO, parameters);
           return lista;
       }
       catch (Exception ex) {
           if (ex instanceof BaseBusinessException) {
               throw (BaseBusinessException) ex;
           }
           throw new BaseFailureException(ex);
       }
   }
   
    /**
     * Operação que realiza a busca do endereco de cobranca
     * 
     * @param bean
     * @return CpEnderecoProspectBean
     * 
     * @since 23/09/2010
     */
    @SuppressWarnings(GeralConstants.UNCHECKED)
    private CpEnderecoProspectBean searchEnderecoProspectByTipoEndereco (final Bean bean) {
        
        final String sql = "lstEnderecoCobrancaProspect"; 

        final List<CpEnderecoProspectBean> retorno = super.search(sql, bean, false);
        if (!retorno.isEmpty()) {
            return (CpEnderecoProspectBean) retorno.iterator().next();
        }
        
        return null;
    }

    /**
     * Obtém o prospect
     * 
     * @param idProspect
     * @return
     */
	private CpProspectBean obterProspect(final Long idProspect) {
    	final CpProspectBean prospect = new CpProspectBean();
    	prospect.setIdProspect(idProspect);
        return (CpProspectBean) super.findByPrimaryKey(prospect);
	}

	/**
	 * Obtém o tipoendereço
	 * 
	 * @param idTipoEndereco
	 * @return
	 */
    private CpTipoEnderecoBean obterTipoEndereco(final Integer idTipoEndereco) {
    	final CpTipoEnderecoBean tipoEndereco = new CpTipoEnderecoBean();
    	tipoEndereco.setIdTipoEndereco(idTipoEndereco);
        return (CpTipoEnderecoBean) super.findByPrimaryKey(tipoEndereco);
	}
}
