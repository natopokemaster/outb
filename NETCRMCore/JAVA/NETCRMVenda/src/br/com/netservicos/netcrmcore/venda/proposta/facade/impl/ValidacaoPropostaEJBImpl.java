package br.com.netservicos.netcrmcore.venda.proposta.facade.impl;

import java.util.Iterator;
import java.util.List;

import br.com.netservicos.core.bean.cp.CpCobrancaBean;
import br.com.netservicos.core.bean.cp.CpPontoBean;
import br.com.netservicos.core.bean.cp.CpPropostaBean;
import br.com.netservicos.core.bean.cp.CpProspectBean;
import br.com.netservicos.core.bean.cp.CpRelPendenciaPropostaBean;
import br.com.netservicos.core.bean.sn.SnCaracteristicaPerfilBean;
import br.com.netservicos.core.bean.sn.SnTipoCobrFatEmailBean;
import br.com.netservicos.core.bean.sn.SnTipoPessoaBean;
import br.com.netservicos.core.bean.sn.SnTipoSegmentoBean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.netcrmcore.endereco.core.facade.EnderecoService;
import br.com.netservicos.netcrmcore.geral.constants.GeralConstants;
import br.com.netservicos.netcrmcore.venda.constants.PropostaConstants;
import br.com.netservicos.netcrmcore.venda.core.facade.impl.AbstractNETCRMVendaEJBImpl;
import br.com.netservicos.netcrmcore.venda.proposta.facade.ValidacaoPropostaService;
import br.com.netservicos.netcrmcore.venda.proposta.pendencia.facade.PendenciaService;

/** 
 * EJB responsável pela validação / alteração dos dados cadastrais do cliente.
 * 
 * @author gmello@artit.com.br
 * 
 * @ejb.bean name="ValidacaoPropostaEJB" type="Stateless" display-name="ValidacaoPropostaEJB"
 *           description="ValidacaoPropostaEJB Session EJB Stateless" view-type="both"
 *           jndi-name="netcrmcore/venda/ejb/ValidacaoPropostaEJB"
 *           local-jndi-name="netcrmcore/venda/ejb/local/ValidacaoPropostaEJB"
 *           transaction-type="Container"
 * 
 * @ejb.interface local-extends="javax.ejb.EJBLocalObject"
 *                extends="javax.ejb.EJBObject"
 * 
 * @ejb.home local-extends="javax.ejb.EJBLocalHome" extends="javax.ejb.EJBHome"
 * 
 */
public class ValidacaoPropostaEJBImpl extends AbstractNETCRMVendaEJBImpl implements
		ValidacaoPropostaService {

	private static final long serialVersionUID = 1713492184667436066L;
	
	
    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>  
     * @param proposta
     * @return
     * @since 22/09/2010
     *
     *   
     * @ejb.interface-method view-type = "both"
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="CRM_MANTER_PROPOSTA"
     *  
     */
     
    public Boolean validarDadosProposta(Long idProposta) {
        
        CpPropostaBean proposta = obterProposta(idProposta);
        CpProspectBean prospect = proposta.getProspect();    
        EnderecoService enderecoServico = getService(EnderecoService.class);
        
        validatePerfilCliente(proposta);
        validateReservasTelefoneVoIP(proposta);
        validarEndereco(idProposta, proposta, enderecoServico);
        updateSegmentacaoProposta(proposta);        
        Boolean validation = Boolean.TRUE;          
        validation = validateDadosPessoais(prospect);
        if(validation){
            validation = validateDadosAdesao(proposta);
        }
        if(validation){
            validation = validateDadosCobranca(proposta);
        }
        return validation;
        
    }

    /**
     * @param idProposta
     * @param proposta
     * @param enderecoServico
     */
    private void validarEndereco(Long idProposta, CpPropostaBean proposta, EnderecoService enderecoServico) {
        Boolean retorno = enderecoServico.validateEnderecoInadimplente(idProposta);
        if(retorno.equals(Boolean.FALSE)){
          PendenciaService pendenciaService = getService(PendenciaService.class); 
          pendenciaService.inserirPendenciaProposta(proposta.getIdProposta(), 
          GeralConstants.HP_INADIMPLENTE, GeralConstants.ENDERECO_INADINPLENTE, null, null);            
        }
        
        Boolean retornoInconsistente = enderecoServico.validateEnderecoInconsistente(idProposta);
        if(retornoInconsistente.equals(Boolean.FALSE )){
             final PendenciaService pendenciaService = getService(PendenciaService.class);
             pendenciaService.inserirPendenciaProposta(proposta.getIdProposta(),
             GeralConstants.HP_OUTROS, Long.valueOf(1) , null,
             "Endereço inconsistente: Cep Nulo.");
        }
        
    }
    
	/**
     * Valida o perfil do cliente chamando da tela de resumo
     * @param proposta
     */
    private void validatePerfilCliente(CpPropostaBean proposta) { 
        final List result = super.search(CpRelPendenciaPropostaBean.
        LST_EXISTS_CP_REL_PENDENCIA_PROPOSTA_PERFIL_CLIENTE_VOIP_BY_PROPOSTA, proposta);
        if (result.isEmpty()) {          
            SnCaracteristicaPerfilBean caracteristica = new SnCaracteristicaPerfilBean(); 
            Integer perfil = proposta.getIdPerfilCliente();
            caracteristica.setIdPerfilCliente(perfil);
            final List caracteristicas = super.search("lstCaracteristicaByPerfil", caracteristica);
            final List pontos = proposta.getPontos();
            boolean ret = true;
            if(pontos != null){
                final Iterator it1 = caracteristicas.iterator();
                Iterator it2 = pontos.iterator();
                while(it1.hasNext()){
                    Long idCarac = (Long) it1.next();
                    if(idCarac.equals(Long.valueOf(PropostaConstants.TECNOLOGIA_ANALOGICO_SMS))||idCarac.
                        equals(Long.valueOf(PropostaConstants.TECNOLOGIA_DIGITALIZADO_SMS))||
                        idCarac.equals(Long.valueOf(PropostaConstants.TECNOLOGIA_DIGITAL_SMS)))
                        idCarac = new Long(PropostaConstants.TECNOLOGIA_PADRAO);
                    while(it2.hasNext()){
                        CpPontoBean ponto = (CpPontoBean)it2.next();
                        if(idCarac !=null && ponto.getCaracteristica() !=null ){
                            Long idCaracPonto = ponto.getCaracteristica().getIdCaracteristica();
                            if(idCaracPonto.equals(Long.valueOf(PropostaConstants.TECNOLOGIA_ANALOGICO_SMS))||
                               idCaracPonto.equals(Long.valueOf(PropostaConstants.TECNOLOGIA_DIGITALIZADO_SMS))||
                               idCaracPonto.equals(Long.valueOf(PropostaConstants.TECNOLOGIA_DIGITAL_SMS)))
                                idCaracPonto = Long.valueOf(PropostaConstants.TECNOLOGIA_PADRAO);
                            if(idCaracPonto.equals(idCarac)){
                                ret = true;
                                break;
                            }
                            else{
                                ret = false;
                            }
                        }
                        else
                            ret = false;
                    }
                    if(!ret){
                        break;
                    }
                    it2 = pontos.iterator();
                }
            }
            else
                ret = true;
            if(!ret){
               PendenciaService pendenciaService = getService(PendenciaService.class);
               pendenciaService.insertPendenciaPerfil(proposta.getIdProposta());
            }

        }
    }
    
    
    /**
     *
     * @param proposta
     */
    private void validateReservasTelefoneVoIP(CpPropostaBean proposta) {        
        final List pontos = proposta.getPontos();
        final Iterator itPontos = pontos.iterator();
        
        boolean insertPendenciaVoIP = false;
        boolean existVoIP = false;
        while (itPontos.hasNext()) {
        
            CpPontoBean ponto = (CpPontoBean) itPontos.next();
            if (PropostaConstants.VOIP == ponto.getCaracteristica().getIdCaracteristica().longValue()) {
                existVoIP = true;               
                List reservasVoIP = ponto.getReservasVoip();               
                if (reservasVoIP.isEmpty()) {
                    insertPendenciaVoIP = true;
                    break;
                }
            }
        }
        final PendenciaService pendService = getService(PendenciaService.class);      
        if (insertPendenciaVoIP) {          
            pendService.insertPendenciaReservaTelefoneVoIP(proposta.getIdProposta(),0);       
        }else if(existVoIP && !insertPendenciaVoIP) {
            pendService.releasePendenciaReservaTelefoneVoIP(proposta.getIdProposta(),0);         
        }             
        pendService.releasePendenciaReservaTelefoneVoIP(proposta.getIdProposta(),0);       
        pendService.insertPendenciaReservaTelefoneVoIP(proposta.getIdProposta(),0);        
    }
      
    /**
     * 
     * @param proposta
     */
    public void updateSegmentacaoProposta(CpPropostaBean proposta) {
        proposta = (CpPropostaBean) super.findByPrimaryKey(proposta);                   
        proposta.setTipoSegmento(new SnTipoSegmentoBean(PropostaConstants.TIPO_SEGMENTACAO_SEM_SEGMENTO));        
        getCurrentDAO().flush();
    }
    
       
    
    /**
     * 
     *  
     *
     * @param prospect
     * @return
     */
    private Boolean validateDadosPessoais(CpProspectBean prospect) {
        if (prospect.getIdTipoPessoa() == null) return Boolean.FALSE;
        if (prospect.getIdTipoPessoa().intValue() == SnTipoPessoaBean.TP_FISICA) {
            if (prospect.getCpf() == null) return Boolean.FALSE;          
            if (prospect.getRg() == null) return Boolean.FALSE;
            if (prospect.getIdOrgaoExpedidor() == null) return Boolean.FALSE;                    
            if (prospect.getIdProfissao() == null) return Boolean.FALSE;
            if (prospect.getIdEstadoCivil() == null) return Boolean.FALSE;
            if (prospect.getSexo() == null) return Boolean.FALSE;
            if (prospect.getDataNascimento() == null) return Boolean.FALSE;
        } else if (prospect.getIdTipoPessoa().intValue() == SnTipoPessoaBean.TP_JURIDICA) {
            if (prospect.getCnpj() == null) return Boolean.FALSE;
            if (prospect.getIe() == null) return Boolean.FALSE;
        }
        final CpCobrancaBean cpCobranca = new CpCobrancaBean();
        cpCobranca.setIdProposta(prospect.getProposta().getIdProposta());        
        final CpCobrancaBean cobranca = (CpCobrancaBean) this.getCurrentDAO().findByPrimaryKey(cpCobranca);
        
        if(cobranca != null){
            if(cobranca.getIdFormaEnvFat() != null && cobranca.getIdFormaEnvFat().
                                                equals(PropostaConstants.FORMA_ENVIO_EMAIL)){ 
                if(prospect.getEmail()==null)
                    return Boolean.FALSE;
            }
        }else{
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
    
    /**
     *
     * 
     * @param proposta
     * @return
     */
    private Boolean validateDadosAdesao(CpPropostaBean proposta) {       
        if (proposta.getIdTipoVenda() == null) return Boolean.FALSE;
        if (proposta.getIdCampanha() == null) return Boolean.FALSE;
        return Boolean.TRUE;
    }
  
    
    /**
     *
     * 
     * @param cobranca
     * @return
     */
    private Boolean validateDadosCobranca(CpPropostaBean proposta) {
        CpProspectBean prospect = proposta.getProspect();
        
        final CpCobrancaBean cpCobranca = new CpCobrancaBean();
        cpCobranca.setIdProposta(proposta.getIdProposta());        
        final CpCobrancaBean cobranca = (CpCobrancaBean) this.getCurrentDAO().findByPrimaryKey(cpCobranca);        
        
        if (cobranca == null) return Boolean.FALSE;
        if (cobranca.getDiaVencimento() == null) return Boolean.FALSE;
        if (cobranca.getTipoCobranca() == null) return Boolean.FALSE;
        if (cobranca.getTipoCobranca().getIdTipoCobranca().intValue() == PropostaConstants.DEBITO_EM_CONTA) {
            if (prospect.getContaCorrente() == null) return Boolean.FALSE;
            if (prospect.getContaCorrente().getIdBanco() == null) return Boolean.FALSE;
            if (prospect.getContaCorrente().getAgencia() == null) return Boolean.FALSE;
            if (prospect.getContaCorrente().getConta() == null) return Boolean.FALSE;
            if (prospect.getContaCorrente().getDigitoConta() == null) return Boolean.FALSE;
        } else if (cobranca.getTipoCobranca().getIdTipoCobranca().intValue() == PropostaConstants.CARTAO_DE_CREDITO) {
            if (prospect.getCartaoCredito() == null) return Boolean.FALSE;
            if (prospect.getCartaoCredito().getOperadora() == null) return Boolean.FALSE;
            if (prospect.getCartaoCredito().getNumero() == null) return Boolean.FALSE;
            if (prospect.getCartaoCredito().getValidade() == null) return Boolean.FALSE;
        }
        
        final DynamicBean bean = new DynamicBean();
        bean.put("cidContrato", prospect.getCidadeOperadora().getIdCidade());
        bean.put("idTipoCobranca", String.valueOf(cobranca.getTipoCobranca().getIdTipoCobranca()));      
        
        Boolean validation = verificaDisponibilidadeFaturaEmail(bean);
        if(validation){
            if(cobranca.getIdFormaEnvFat() == null )
                return Boolean.FALSE;
            else{
                if(cobranca.getIdFormaEnvFat() != null && cobranca.getIdFormaEnvFat().
                getIdFormaEnvioFatura().equals(new Long(1)))
                    return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
    
    /**
     * Método responsável por devolver a FLAG para que habilite ou não o envio de faturas por e-mail.
     * A condição para isto será primeiro verificar na sn_parametro se
     * o atributo "ENVIA_FATURA_EMAIL" está com o valor 1 para a 
     * cidade selecionada. Após verificar
     * na tabela SN_TIPO_COBR_FAT_EMAIL o tipo de cobrança selecionada passando o cidContrato. 
     * As duas situações devem verdadeiras.....
     *   
     */
    private Boolean verificaDisponibilidadeFaturaEmail(DynamicBean bean) {
        Boolean retorno = false;
        
        String idTipoCobranca = (String)bean.get("idTipoCobranca");
        
        if(!"".equals(idTipoCobranca)){
            List result = getCurrentDAO().select(SnTipoCobrFatEmailBean.
                                                    LST_TIPO_COBR_FAT_EMAIL_BY_PARAMS, bean, false); 
            
            if(result != null && result.size() >= 1)
                retorno = true;
        }
        return retorno;
    }
    
    private CpPropostaBean obterProposta(Long idProposta){
        CpPropostaBean proposta = new CpPropostaBean();
        proposta.setIdProposta(idProposta);
        proposta = (CpPropostaBean) super.findByPrimaryKey(proposta);
        return proposta;  
    }
	
}