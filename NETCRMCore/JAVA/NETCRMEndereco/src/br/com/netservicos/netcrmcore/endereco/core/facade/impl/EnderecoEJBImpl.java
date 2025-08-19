package br.com.netservicos.netcrmcore.endereco.core.facade.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.util.CollectionUtils;

import br.com.netservicos.core.bean.cp.CpEnderecoProspectBean;
import br.com.netservicos.core.bean.cp.CpPendenciasBean;
import br.com.netservicos.core.bean.cp.CpPropostaBean;
import br.com.netservicos.core.bean.cp.CpProspectBean;
import br.com.netservicos.core.bean.cp.CpRelPendenciaPropostaBean;
import br.com.netservicos.core.bean.cp.CpTipoEnderecoBean;
import br.com.netservicos.core.bean.ged.GedEnderecoBean;
import br.com.netservicos.core.bean.ged.GedEnderecoKey;
import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.core.dao.BaseDAOException;
import br.com.netservicos.framework.core.dao.BatchParameter;
import br.com.netservicos.framework.util.exception.BaseBusinessException;
import br.com.netservicos.netcrmcore.endereco.core.facade.EnderecoService;
import br.com.netservicos.netcrmcore.endereco.core.helper.EnderecoHelper;
import br.com.netservicos.netcrmcore.geral.constants.GeralConstants;
import br.com.netservicos.netcrmcore.geral.util.GeralUtil;

/**
 * EJB responsável pela validação / alteração dos dados cadastrais do cliente.
 * 
 * @author gmello@artit.com.br
 * 
 * @ejb.bean name="EnderecoEJB" type="Stateless" display-name="EnderecoEJB"
 *           description="EnderecoEJB Session EJB Stateless" view-type="both"
 *           jndi-name="netcrmcore/endereco/ejb/EnderecoEJB"
 *           local-jndi-name="netcrmcore/endereco/ejb/local/EnderecoEJB"
 *           transaction-type="Container"
 * 
 * @ejb.interface local-extends="javax.ejb.EJBLocalObject"
 *                extends="javax.ejb.EJBObject"
 * 
 * @ejb.home local-extends="javax.ejb.EJBLocalHome" extends="javax.ejb.EJBHome"
 * 
 */
public class EnderecoEJBImpl extends AbstractEnderecoEJBImpl implements 
		EnderecoService { 

	private static final long serialVersionUID = 1713492184667436066L;
	


	
	/**
     * <p>
     * <b>Description: </b><br/>
     * <p>
     *  Metodo responsavel por validar e associar/alterar o endereco de um prospect com o cod HP passado
     *  
     * @see br.com.netservicos.netcrmcore.prospect.core.facade #alterarEnderecoProspect(Bean dadosProsposta)
     * @return Bean
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.permission role-name="CRM_MANTER_DADOS_ENDERECO_PROPOSTA"
     */
	@SuppressWarnings({ "rawtypes", "unchecked" })
    public DynamicBean alterarEnderecoProspect(Bean dadosProsposta) {
				
		DynamicBean dynaFilter = new DynamicBean();
		DynamicBean retornoBean = new DynamicBean(); 
		Long idProspect = GeralUtil.toLong(dadosProsposta.getBeanProperty(GeralConstants.ID_PROSPECT));
		Long idProposta = GeralUtil.toLong(dadosProsposta.getBeanProperty(GeralConstants.ID_PROPOSTA));
		
		Integer codHp = GeralUtil.toInteger(dadosProsposta.getBeanProperty(GeralConstants.PROPERTY_COD_HP));
		CpProspectBean prospect = obterProspect(idProspect);
		GedEnderecoBean endereco = new GedEnderecoBean();
		GedEnderecoKey enderecoKey = new GedEnderecoKey();
		enderecoKey.setCodCidade(Long.parseLong(prospect.getCidadeOperadora().getIdCidade()));
		endereco.setComposite(enderecoKey);
		dynaFilter.set(GeralConstants.PROPERTY_GED_ENDERECO, endereco);
		dynaFilter.set(GeralConstants.PROPERTY_COD_HP, codHp);
	
        List<Object[]> retorno = super.search(GedEnderecoBean.DADOS_ENDERECO, dynaFilter);
        
		if (!CollectionUtils.isEmpty(retorno)){ 			
			Object[] dados = (Object[]) retorno.get(0);			
			CpEnderecoProspectBean enderecoProspect = new CpEnderecoProspectBean();
			enderecoProspect.setIdEdificacao(codHp);

            DynamicBean item = obterListaEndereco(codHp);
            String complementos = EnderecoHelper.obterComplementoEndereco(item);
            
            final int idx_numero = 15;
            final int idx_cep = 1;
            final int idx_bairro = 2;
            final int idx_logradouro = 3;
            final int idx_edificacao = 19;
            final int idx_estado = 18;

			enderecoProspect.setComplemento(complementos);
            enderecoProspect.setNumero(GeralUtil.getString(dados[idx_numero]));
            enderecoProspect.setCep(GeralUtil.toString(dados[idx_cep]));
            enderecoProspect.setBairro((String) dados[idx_bairro]);
			String nomLogradouro = GeralUtil.getString(dados[idx_logradouro]);
			String enderecoCompleto = EnderecoHelper.obterEnderecoCompleto(enderecoProspect, nomLogradouro);

			enderecoProspect.setEndcompleto(enderecoCompleto);
			enderecoProspect.setDesclogradouro(nomLogradouro);

            String indTipoEdificacao = (String) dados[idx_edificacao];

            HashMap<String, String> tiposEdificacao = EnderecoHelper.getTiposEdificacoes();

			enderecoProspect.setTipoEdificacao((String) tiposEdificacao.get(indTipoEdificacao));
			enderecoProspect.setCidade((String) dados[0]);
            enderecoProspect.setEstado((String) dados[idx_estado]);
			CpTipoEnderecoBean cpTipoEnderecoBean = new CpTipoEnderecoBean();
			cpTipoEnderecoBean.setIdTipoEndereco(new Integer(1));
			enderecoProspect.setTipoEndereco(cpTipoEnderecoBean);			
			
			CpPropostaBean proposta = obterProposta(idProposta);			
						 
			if (!CollectionUtils.isEmpty(prospect.getEnderecos())) {				
				for (Iterator iter = prospect.getEnderecos().iterator(); iter.hasNext();) {
					CpEnderecoProspectBean enderecoProspectBean = (CpEnderecoProspectBean) iter.next();
                    if (GeralConstants.ID_TIPO_ENDERECO_INSTALACAO.equals(enderecoProspectBean
                                                            .getTipoEndereco().getIdTipoEndereco()) 
                               &&  (!enderecoProspectBean.getIdEnderecoProspect().equals( 
                                                                enderecoProspect.getIdEnderecoProspect()))) {
							super.delete(enderecoProspectBean, getUserSession().getCurrentDbService());
							break;
                    }
                }
			} else {			
				prospect.setEnderecos(new ArrayList());	 			
				prospect.getEnderecos().add(enderecoProspect); 
			}
			enderecoProspect.setProspect(prospect);			
            DynamicBean dynaStatus = obterStatusEdereco(prospect.getCidadeOperadora().getIdCidade(), codHp,
                                                    GeralConstants.TECNOLOGIA_VIRTUA, enderecoProspect);
			
			String statusTecnicoVirtua = (String) dynaStatus.get(GeralConstants.STATUS_TECNICO); 
			if ("0".equals(statusTecnicoVirtua)) {				
				enderecoProspect.setBidirecional(new Integer(1));
			}			
            super.insert(enderecoProspect, getUserSession().getCurrentDbService());
            retornoBean = processaStatusPayTVEndereco(proposta.getIdProposta(), enderecoProspect.getIdEnderecoProspect());    

		}else{	 
		    lancarErrosValidacao(getValidationMessage(GeralConstants.GERAR_CONTRATO_HP_INVALIDO,new Object[0]));        
		}
		return retornoBean;
		    
	}
		
    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * @param idProposta
     * @param codHp
     * @param enderecoProspect
     * @since 22/09/2010
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.permission role-name="CRM_MANTER_DADOS_ENDERECO_PROPOSTA"
     * 
     */
    public DynamicBean processaStatusPayTVEndereco(Long idProposta, Long idEnderecoProspect) {
        CpPropostaBean proposta = obterProposta(idProposta);
        CpEnderecoProspectBean enderecoProspect = new CpEnderecoProspectBean();
        enderecoProspect.setIdEnderecoProspect(idEnderecoProspect);
        enderecoProspect = (CpEnderecoProspectBean) findByPrimaryKey(enderecoProspect);
        DynamicBean dynaStatus = obterStatusEdereco(proposta.getProspect().getCidadeOperadora().getIdCidade(),
                                                enderecoProspect.getIdEdificacao(), GeralConstants.TECNOLOGIA_PTV,
                                                enderecoProspect);

        return dynaStatus;
    }

    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * @param idCidade
     * @param idEdificacao
     * @param servico
     * @return
     * @since 22/09/2010
     */
    @SuppressWarnings("rawtypes")
    public DynamicBean obterStatusEdereco(String idCidade, Integer idEdificacao, Integer servico,
                                            CpEnderecoProspectBean end) {
        try {
            DynamicBean dynaBean = new DynamicBean();
            List result = executaValidacaoTrechos(idCidade, idEdificacao, servico);

            String statusComercial = null;
            String statusTecnico = null;

            final int idx_status_cinco = 5;
            final int idx_status_quatro = 4;
            final int idx_status_tres = 3;

            if ("-10".equals(GeralUtil.toString(result.get(idx_status_cinco)))) {
                statusComercial = GeralConstants.STATUS_NAO_OK;
                statusTecnico = GeralConstants.STATUS_NAO_OK;
            } else {
                if (GeralConstants.TECNOLOGIA_PTV.equals(servico)) {
                    // Fazendo a verificação de status tecnico para tecnologia
                    // analogica
                    if ("0".equals(GeralUtil.toString(result.get(idx_status_quatro)))
                                                            || "3".equals(GeralUtil.toString(result.get(idx_status_quatro))))
                        statusTecnico = GeralConstants.STATUS_OK;
                    else
                        statusTecnico = GeralConstants.STATUS_NAO_OK;
                } else {
                    // Fazendo a verificação de status tecnico para as demais
                    // tecnologias
                    if ("0".equals(GeralUtil.toString(result.get(idx_status_quatro)))
                                                            || "5".equals(GeralUtil.toString(result.get(idx_status_quatro))))
                        statusTecnico = GeralConstants.STATUS_OK;
                    else
                        statusTecnico = GeralConstants.STATUS_NAO_OK;
                }
                // Fazendo a verificação de status comercial
                if ("0".equals(GeralUtil.toString(result.get(idx_status_tres))))
                    statusComercial = GeralConstants.STATUS_OK;
                else
                    statusComercial = GeralConstants.STATUS_NAO_OK;
            }

            if (GeralConstants.TECNOLOGIA_PTV.equals(servico)) {
                // Seta o valor do status endereco TECNOLOGIA_PTV
                dynaBean.set(GeralConstants.PROPERTY_STATUS_ENDERECO_PTV_COMERCIAL, statusComercial);
                dynaBean.set(GeralConstants.PROPERTY_STATUS_ENDERECO_PTV_TECNICO, statusTecnico);
            } else if (GeralConstants.TECNOLOGIA_VIRTUA.equals(servico)) {
                // Seta o valor do status endereco TECNOLOGIA_VIRTUA
                dynaBean.set(GeralConstants.PROPERTY_STATUS_ENDERECO_VIRTUA_COMERCIAL, statusComercial);
                dynaBean.set(GeralConstants.PROPERTY_STATUS_ENDERECO_VIRTUA_TECNICO, statusTecnico);
            } else if (GeralConstants.TECNOLOGIA_DIGITAL.equals(servico)) {
                // Seta o valor do status endereco TECNOLOGIA_DIGITAL
                dynaBean.set(GeralConstants.PROPERTY_STATUS_ENDERECO_DIGITAL_COMERCIAL, statusComercial);
                dynaBean.set(GeralConstants.PROPERTY_STATUS_ENDERECO_DIGITAL_TECNICO, statusTecnico);
            } else if (GeralConstants.TECNOLOGIA_VOIP.equals(servico)) {
                // Seta o valor do status endereco TECNOLOGIA_VOIP
                if (statusComercial == GeralConstants.STATUS_OK && statusTecnico == GeralConstants.STATUS_OK) {

                    List nodes = getCurrentDAO().select("lstNodeEndereco", end, true);

                    String node = (String) nodes.get(0);
                    BatchParameter[] parametersVOIP = EnderecoHelper.obterParametrosVoip(idCidade, node);
                    List resultVOIP = getCurrentDAO().executeBatch(GeralConstants.PROC_VALIDA_TECNOLOGIA_VOIP,
                                                            parametersVOIP);

                    if ("0".equals(GeralUtil.toString(resultVOIP.get(idx_status_quatro)))) {
                        statusComercial = GeralConstants.STATUS_OK;
                        statusTecnico = GeralConstants.STATUS_OK;
                    } else {
                        statusComercial = GeralConstants.STATUS_NAO_OK;
                        statusTecnico = GeralConstants.STATUS_NAO_OK;
                    }

                } else {
                    statusComercial = GeralConstants.STATUS_NAO_OK;
                    statusTecnico = GeralConstants.STATUS_NAO_OK;
                }
                dynaBean.set(GeralConstants.PROPERTY_STATUS_ENDERECO_VOIP_COMERCIAL, statusComercial);
                dynaBean.set(GeralConstants.PROPERTY_STATUS_ENDERECO_VOIP_TECNICO, statusTecnico);
            }

            // Setando os valores de status para o endereco retornados pela
            // PROCEDURE
            dynaBean.set(GeralConstants.PROC_STATUS_COMERCIAL, GeralUtil.toString(result.get(idx_status_tres)));
            dynaBean.set(GeralConstants.PROC_STATUS_TECNICO, GeralUtil.toString(result.get(idx_status_quatro)));

            // Setando os valores de status para o endereço
            dynaBean.set(GeralConstants.STATUS_COMERCIAL, statusComercial);
            dynaBean.set(GeralConstants.STATUS_TECNICO, statusTecnico);

            return dynaBean;
        } catch (BaseDAOException bdex) {
            throw bdex;
        } catch (Exception ex) {
            throw new BaseBusinessException();
        }
    }

    /**
     * 
     * @see br.com.netservicos.core.bean.cp.CpPropostaBean      
     *
     * @ejb.interface-method view-type = "both"
     * @ejb.permission role-name="CRM_MANTER_DADOS_ENDERECO_PROPOSTA" 
     */
    public Boolean validateEnderecoInadimplente(Long idProposta ) {
        
        CpPropostaBean proposta = obterProposta(idProposta);        
        List retorno = permiteVendaEndereco(idProposta);
        Boolean retornoEndereco = Boolean.TRUE;
        if (!CollectionUtils.isEmpty(retorno)) {
            DynamicBean filter = new DynamicBean();
            filter.put("idProposta", proposta.getIdProposta());
            filter.set("idPendVariacao", (Object) null, Long.class);
            filter.put("idPendencia", new Long(GeralConstants.PENDENTE_AGENDAMENTO)); 
            filter.put("idPendencia", new Long(GeralConstants.HP_INADIMPLENTE)); 

            List pendencias = super.search(
                    CpRelPendenciaPropostaBean.LST_CP_REL_PENDENCIA_PROPOSTA_BY_PROPOSTA_AND_PENDENCIA_AND_VARIACAO, filter);

            CpRelPendenciaPropostaBean pendenciaEndereco = null;
            if (!CollectionUtils.isEmpty(pendencias)){
                pendenciaEndereco = (CpRelPendenciaPropostaBean) pendencias.get(0);
            }

            if ("1".equals(retorno.get(0))) {
                if (!GeralUtil.isNull(pendenciaEndereco)) {
                    pendenciaEndereco.setDtFechamento(new Date());
                    pendenciaEndereco.setObs("Endereço liberado.");
                    super.update(pendenciaEndereco, getUserSession().getCurrentDbService());
                }
            } else if ("0".equals(retorno.get(0))) {
                if (GeralUtil.isNull(pendenciaEndereco)){
                    retornoEndereco = Boolean.FALSE; 
                }               
                  
            }   
        }
        return retornoEndereco;
    }
    
    /** 
     *
     * @ejb.interface-method view-type = "both"
     * @ejb.permission role-name="CRM_MANTER_DADOS_ENDERECO_PROPOSTA"
     *
     */
    
    public Boolean validateEnderecoInconsistente(Long idProposta) {
        
        CpPropostaBean proposta = obterProposta(idProposta);
        List retorno = permiteVendaEndereco(idProposta);
        Boolean retornoEndereco = Boolean.TRUE;
        if (!CollectionUtils.isEmpty(retorno)) {

            DynamicBean filter = new DynamicBean();
            filter.put("idProposta", proposta.getIdProposta());
            filter.set("idPendVariacao", (Object) null, Long.class);
            filter.put("idPendencia", new Long(GeralConstants.HP_OUTROS));

            List pendencias = super.search(CpRelPendenciaPropostaBean.LST_CP_REL_PENDENCIA_PROPOSTA_BY_PROPOSTA_AND_PENDENCIA_AND_VARIACAO,
                                                    filter);

            CpRelPendenciaPropostaBean pendenciaEndereco = null;

            if (!CollectionUtils.isEmpty(pendencias)){
                pendenciaEndereco = (CpRelPendenciaPropostaBean) pendencias.get(0);
            }

            // Verifica se há pendência de venda para o endereço
            if ("1".equals(retorno.get(0))) {

                boolean existePendenciaEndereco = false;

                // Verifica se já existe uma pendência do mesmo tipo criada
                for (int i = 0; i < pendencias.size(); i++) {

                    CpPendenciasBean pendencia = ((List<CpRelPendenciaPropostaBean>) pendencias).get(i)
                                                            .getPendencia();

                    if (!GeralUtil.isNull(pendencia)) {
                        if (pendencia.getIdPendencia() == GeralConstants.HP_OUTROS) {
                            existePendenciaEndereco = true;
                        }
                    }
                }

                // Caso existe a pendência, não cria uma nova.
                if (!existePendenciaEndereco) {

                    CpEnderecoProspectBean endereco = obterEnderecoInstalacao(proposta.getProspect()
                                                            .getIdProspect());

                    
                      if (!GeralUtil.isNull(endereco)) {                       
                        if (GeralUtil.isEmpty(endereco.getCep())) {
                            retornoEndereco = Boolean.FALSE;
                        }
                    }
                }
            }
        }
        return retornoEndereco;
    }
    /**
     * 
     * @param idProposta
     * @return
     */
    public List permiteVendaEndereco(Long idProposta) {
        CpPropostaBean proposta = obterProposta(idProposta);            
        CpEnderecoProspectBean endereco = obterEnderecoInstalacao(proposta.getProspect().getIdProspect());
        Integer idEdificacao = new Integer(0);
        if (!GeralUtil.isNull(endereco)){
            idEdificacao = endereco.getIdEdificacao();
        }
        BatchParameter[] parameters = new BatchParameter[3]; 
        parameters[0] = new BatchParameter(Types.VARCHAR, true);
        parameters[1] = new BatchParameter(idEdificacao, Types.NUMERIC);
        parameters[2] = new BatchParameter("", Types.VARCHAR);
        return getCurrentDAO().executeBatch(GeralConstants.FUNCTION_PERMITE_VENDA_ENDER, parameters);
    }
   
      /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * 
     * @param idCidade
     * @param idEdificacao
     * @param servico
     * @return
     * @since 22/09/2010
     */
    private List executaValidacaoTrechos(String idCidade, Integer idEdificacao, Integer servico) {
        BatchParameter[] parameters = EnderecoHelper.obterParametrosValidacaoTrechos(idCidade, idEdificacao, servico);
        
        List result = getCurrentDAO().executeBatch(
                                                GeralConstants.PROC_PGSN_TRECHOS_RESTRITOS_PR_VALIDA_TRECHO,
                                                parameters);
        return result;
    }
   
    /**
     * @param codHp
     * @return
     */
    @SuppressWarnings("unchecked")
    private DynamicBean obterListaEndereco(Integer codHp) {
        BatchParameter[] parameters = EnderecoHelper.obterParametrosListarEndereco(codHp);

        ArrayList<DynamicBean> dadosComplementos = (ArrayList<DynamicBean>) getCurrentDAO().executeBatch(
                                                GeralConstants.PROC_ENDER_LISTA_ENDERECOS, parameters).get( 
                                                0); 
         
        DynamicBean item = (DynamicBean) dadosComplementos.get(0);
        return item;
    }
     
	/**
	 * 
	 * @param idProspect
	 * @return
	 * @since 22/09/2010
	 */
	private CpProspectBean obterProspect(Long idProspect){
		CpProspectBean prospect = new CpProspectBean();
		prospect.setIdProspect(idProspect);
		prospect = (CpProspectBean) super.findByPrimaryKey(prospect);
		return prospect;  
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
     * 
     * @param prospect
     * @return
     * 
     * 
     */
    private CpEnderecoProspectBean obterEnderecoCobranca(Long idProspect) {
        CpProspectBean prospect = new CpProspectBean();
        prospect.setIdProspect(idProspect);
        prospect = (CpProspectBean) super.findByPrimaryKey(prospect);
        CpEnderecoProspectBean enderecoCobranca = null;
        if (!CollectionUtils.isEmpty(prospect.getEnderecos())) {            
            for (Iterator iter = prospect.getEnderecos().iterator(); iter.hasNext();) {
                CpEnderecoProspectBean enderecoProspectBean = (CpEnderecoProspectBean) iter.next();
                if (GeralConstants.ID_TIPO_ENDERECO_COBRANCA.equals(enderecoProspectBean.getTipoEndereco()
                                                        .getIdTipoEndereco())) {
                    enderecoCobranca = enderecoProspectBean;
                    break;
                }
            }
        }
        return enderecoCobranca;
    }

    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * 
     * @param prospect
     * @return
     * 
     * 
     */
    private CpEnderecoProspectBean obterEnderecoInstalacao(Long idProspect) {
        CpProspectBean prospect = new CpProspectBean();
        prospect.setIdProspect(idProspect);
        prospect = (CpProspectBean) super.findByPrimaryKey(prospect);
        CpEnderecoProspectBean enderecoInstalacao = null;        
         if (!CollectionUtils.isEmpty(prospect.getEnderecos())) {    
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
}
