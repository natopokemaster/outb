package br.com.netservicos.netcrmcore.prospect.core.helper;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import br.com.netservicos.core.bean.cp.CpCartaoCreditoBean;
import br.com.netservicos.core.bean.cp.CpCobrancaBean;
import br.com.netservicos.core.bean.cp.CpContaCorrenteBean;
import br.com.netservicos.core.bean.cp.CpEnderecoProspectBean;
import br.com.netservicos.core.bean.cp.CpPontoBean;
import br.com.netservicos.core.bean.cp.CpPrepostoProspectBean;
import br.com.netservicos.core.bean.cp.CpProdutosAgregadosBean;
import br.com.netservicos.core.bean.cp.CpPropostaBean;
import br.com.netservicos.core.bean.cp.CpProspectBean;
import br.com.netservicos.core.bean.cp.CpReservaTelefoneVoipBean;
import br.com.netservicos.core.bean.cp.CpTipoPontoBean;
import br.com.netservicos.core.bean.cp.CpVendedorBean;
import br.com.netservicos.core.bean.sn.SnTipoPessoaBean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.core.bean.UserInfo;
import br.com.netservicos.framework.core.dao.BatchParameter;
import br.com.netservicos.netcrmcore.prospect.constants.ProspectConstants;


public class GerarContratoHelper {

    
    private GerarContratoHelper() {
        //
    }
    
    
    /**
     * @param proposta
     * @param produtoAgregado
     * @param numContrato
     * @param username
     * @return
     */
    public static BatchParameter[] obterParametrosIncluirProdutoAgregado(CpPropostaBean proposta,
                                            CpProdutosAgregadosBean produtoAgregado, Long numContrato,
                                            List username) {
        BatchParameter[] parameters = {
                                                new BatchParameter(new Integer(numContrato.intValue()),
                                                                                        Types.NUMERIC),
                                                new BatchParameter(proposta.getCidadeOperadora().getIdCidade(),
                                                                                        Types.VARCHAR),
                                                new BatchParameter(null, Types.DATE),
                                                new BatchParameter(produtoAgregado.getQuantidade(), Types.NUMERIC),
                                                new BatchParameter(produtoAgregado.getProduto().getIdProduto(), Types.NUMERIC),
                                                new BatchParameter(username != null ? username.get(0) : "",
                                                                                        Types.VARCHAR),
                                                new BatchParameter(Types.VARCHAR, true),
                                                new BatchParameter(Types.NUMERIC, true) };
        return parameters;
    }
    
    /**
     * @param idProduto
     * @return
     */
    public static  BatchParameter[] obterParametrosCaracteristicaProduto(Long idProduto) {
        BatchParameter[] parameters = new BatchParameter[2];
        parameters[0] = new BatchParameter(idProduto, Types.NUMERIC);
        parameters[1] = new BatchParameter(Types.NUMERIC, true);
        return parameters;
    }
    
    /**
     * @param idCidade
     * @param idEdificacao
     * @param servico
     * @return
     */
    public static BatchParameter[] obterParametrosValidaEnderecoSiebel(String idCidade, Integer idEdificacao,
                                            Integer servico) {
        BatchParameter[] parameters = { new BatchParameter(new Integer(idCidade), Types.NUMERIC, false),
                                                new BatchParameter(idEdificacao, Types.NUMERIC, false),
                                                new BatchParameter(servico, Types.NUMERIC, false),
                                                new BatchParameter(Types.NUMERIC, true),
                                                new BatchParameter(Types.NUMERIC, true),
                                                new BatchParameter(Types.NUMERIC, true) };
        return parameters;
    }
    
    /**
     * 
     * @param pontos
     * @return
     */
    public static String obterDescricaoPontoPrincipal(List pontos) {
        String produtosPP = new String();      
        if (pontos != null){             
             Iterator pontosPrincipais = pontos.iterator();
            while (pontosPrincipais.hasNext()) {
                CpPontoBean ponto = (CpPontoBean) pontosPrincipais.next();
                produtosPP = "*" + ponto.getProduto().getIdProduto() + "*";              
                
            }
        }        
        return produtosPP;
    }
    
    /**
     * 
     * @param pontos
     * @return
     */
    public static String obterDescricaoPontoAdicionaisPP(List pontos) {
        String produtosAdicPP = new String();      
        if (pontos != null){             
             Iterator pontosPrincipais = pontos.iterator();
            while (pontosPrincipais.hasNext()) {
                CpPontoBean ponto = (CpPontoBean) pontosPrincipais.next();                
                List lstAgregados = ponto.getProdutosAgregados();
                Iterator agregados = lstAgregados.iterator();
                while (agregados.hasNext()) {
                    CpProdutosAgregadosBean prodAgregado = (CpProdutosAgregadosBean) agregados.next();
                    produtosAdicPP = "*" + prodAgregado.getProduto().getIdProduto() + "*";
                }
            }
        }
        return produtosAdicPP;
    }
    
    
    /**
     * 
     * @param pontos
     * @return
     */
    public static String obterDescricaoPontoAdicionais(List pontos) {
        String produtosPA = new String();      
        if (pontos != null){
            Iterator pontosAdicionais = pontos.iterator();
            while (pontosAdicionais.hasNext()) {
                CpPontoBean ponto = (CpPontoBean) pontosAdicionais.next();
                produtosPA += "*" + ponto.getProduto().getIdProduto() + "*";                
            }
        }
        return produtosPA;
    }
    
    /**
     * 
     * @param pontos
     * @return
     */
    public static String obterDescricaoPontoAdicionaisPA(List pontos) {
        String produtosAdicPA = new String();      
        if (pontos != null){
            Iterator pontosAdicionais = pontos.iterator();
            while (pontosAdicionais.hasNext()) {
                CpPontoBean ponto = (CpPontoBean) pontosAdicionais.next();               
                List lstAgregados = ponto.getProdutosAgregados();
                Iterator agregados = lstAgregados.iterator();
                while (agregados.hasNext()) {
                    CpProdutosAgregadosBean prodAgregado = (CpProdutosAgregadosBean) agregados.next();
                    produtosAdicPA += "*" + prodAgregado.getProduto().getIdProduto() + "*";
                }
            }
        }
        return produtosAdicPA;
    }
    
    /**
     * @param proposta
     * @param cobranca
     * @return
     */
    public static boolean validaCartaoInclusaoCredito(CpPropostaBean proposta, final CpCobrancaBean cobranca) {
        return cobranca.getTipoCobranca().getIdTipoCobranca().intValue() == ProspectConstants.COBRANCA_CARTAO_CREDITO
                                                && proposta.getProspect().getCartaoCredito() != null
                                                && proposta.getProspect().getCartaoCredito().getNumero() != null
                                                && !"".equals(proposta.getProspect().getCartaoCredito()
                                                                                        .getNumero());
    }
    
    /**
     * @param proposta
     * @param cobranca
     * @return
     */
    public static boolean validaInclusaoContaCorrente(CpPropostaBean proposta, final CpCobrancaBean cobranca) {
        return cobranca.getTipoCobranca().getIdTipoCobranca().intValue() == ProspectConstants.COBRANCA_DEBITO_CONTA
                                                && proposta.getProspect().getContaCorrente() != null
                                                && proposta.getProspect().getContaCorrente().getIdBanco() != null
                                                && proposta.getProspect().getContaCorrente().getIdBanco()
                                                                                        .intValue() != 0;
    }
    
    
    /**
     * @param ponto
     * @return
     */
    public static boolean verificaPontoDigitalizado(CpPontoBean ponto) {
        return ponto.getCaracteristica().getIdCaracteristica().longValue() == ProspectConstants.DIGITALIZADO
                                                && (ponto.getTipoPonto()
                                                                                        .getIdTipoPonto()
                                                                                        .equals(ProspectConstants.ID_PONTO_PRINCIPAL) || ponto
                                                                                        .getTipoPonto()
                                                                                        .getIdTipoPonto()
                                                                                        .equals(ProspectConstants.ID_PONTO_ADICIONAL));
    }


    /**
     * @param ponto
     * @return
     */
    public static boolean verificaPontoDigital(CpPontoBean ponto) {
        return ponto.getCaracteristica().getIdCaracteristica().longValue() == ProspectConstants.DIGITAL
                                                && (ponto.getTipoPonto()
                                                                                        .getIdTipoPonto()
                                                                                        .equals(ProspectConstants.ID_PONTO_PRINCIPAL) || ponto
                                                                                        .getTipoPonto()
                                                                                        .getIdTipoPonto()
                                                                                        .equals(ProspectConstants.ID_PONTO_ADICIONAL));
    }


    /**
     * @param ponto
     * @return
     */
    public static boolean validaInserirPonto(CpPontoBean ponto) {
        return ponto.getTipoPonto().getIdTipoPonto().intValue() != CpTipoPontoBean.PROVEDOR 
                                                && ponto.getTipoPonto().getIdTipoPonto().intValue() != CpTipoPontoBean.AQUISICAO
                                                && ponto.getTipoPonto().getIdTipoPonto().intValue() != CpTipoPontoBean.DEGUSTACAO
                                                && ponto.getTipoPonto().getIdTipoPonto().intValue() != CpTipoPontoBean.IP_EXTRA;
    }

    
    /**
     * @param proposta
     * @param numContrato
     * @param idEndereco
     * @param idAssinante
     * @param produtosPP
     * @param produtosAdicPP
     * @param produtosPA
     * @param produtosAdicPA
     * @param idPeriodo
     * @param plst_solic
     * @param plst_prod_de
     * @param plst_prod_para
     * @return
     */
    public static BatchParameter[] obterParametrosFinalizaContrato(CpPropostaBean proposta, Long numContrato,
                                            Long idEndereco, Long idAssinante, String produtosPP,
                                            String produtosAdicPP, String produtosPA, String produtosAdicPA,
                                            Integer idPeriodo, StringBuffer plst_solic, StringBuffer plst_prod_de,
                                            StringBuffer plst_prod_para,Integer idAgendamento,String areaDespacho ) {
        BatchParameter[] parameters = {
                new BatchParameter(proposta.getIdProposta().toString(), Types.VARCHAR),
                new BatchParameter(new Integer(numContrato.intValue()), Types.NUMERIC),
                new BatchParameter(proposta.getCidadeOperadora().getIdCidade(), Types.VARCHAR),
                new BatchParameter(new Integer(idEndereco.intValue()), Types.NUMERIC),
                new BatchParameter(new Integer(idAssinante.intValue()), Types.NUMERIC),
                new BatchParameter(areaDespacho, Types.VARCHAR),
                new BatchParameter(idAgendamento, Types.NUMERIC),
                new BatchParameter(new Integer(1), Types.NUMERIC),
                new BatchParameter(produtosPP, Types.VARCHAR),
                new BatchParameter(produtosAdicPP, Types.VARCHAR),
                new BatchParameter(produtosPA, Types.VARCHAR),
                new BatchParameter(produtosAdicPA, Types.VARCHAR),
                new BatchParameter(proposta.getIdTipoAssinante(), Types.NUMERIC),
                new BatchParameter(Types.VARCHAR, true),
                new BatchParameter(Types.NUMERIC, true),
                new BatchParameter(plst_solic.toString(), Types.VARCHAR),
                new BatchParameter(plst_prod_de.toString(), Types.VARCHAR),
                new BatchParameter(plst_prod_para.toString(), Types.VARCHAR),
                new BatchParameter(idPeriodo, Types.NUMERIC)};
        return parameters;
    }
    
    /**
     * @param numContrato
     * @param proposta
     * @param preposto
     * @return
     */
    public static BatchParameter[] obterParmetrosInserirPreposto(Long numContrato, CpPropostaBean proposta,
                                            CpPrepostoProspectBean preposto) {
        BatchParameter[] parameters = {                        
                new BatchParameter(proposta.getCidadeOperadora().getIdCidade(), Types.VARCHAR),
                new BatchParameter(numContrato, Types.NUMERIC), 
                new BatchParameter(preposto.getNmPreposto(), Types.VARCHAR),
                new BatchParameter(preposto.getDsRelacao(), Types.VARCHAR),
                new BatchParameter(Types.NUMERIC, true),
                new BatchParameter(Types.VARCHAR, true) };
        return parameters;
    }
    
    /**
     * @param proposta
     * @param numContrato
     * @param cartao
     * @return
     */
    public static BatchParameter[] obterParametrosInserirCartaoCredito(CpPropostaBean proposta, Long numContrato,
                                            CpCartaoCreditoBean cartao) {
        BatchParameter[] parameters = {
                new BatchParameter(new Integer(numContrato.intValue()), Types.NUMERIC),
                new BatchParameter(proposta.getCidadeOperadora().getIdCidade(), Types.VARCHAR),
                new BatchParameter(cartao.getNumero(), Types.VARCHAR),
                new BatchParameter(null, Types.VARCHAR),
                new BatchParameter(new Integer(cartao.getOperadora()), Types.NUMERIC),
                new BatchParameter(cartao.getTitular(), Types.VARCHAR),
                new BatchParameter(cartao.getValidade(), Types.VARCHAR),
                new BatchParameter(Types.VARCHAR, true),
                new BatchParameter(Types.NUMERIC, true) };
        return parameters;
    }
    
    /**
     * @param proposta
     * @param numContrato
     * @param contaCorrente
     * @return
     */
    public static  BatchParameter[] obterParametrosInserirContaCorrente(CpPropostaBean proposta, Long numContrato,
                                            CpContaCorrenteBean contaCorrente) {
        BatchParameter[] parameters = {
                new BatchParameter(contaCorrente.getIdBanco(),Types.NUMERIC),
                new BatchParameter(contaCorrente.getAgencia(),Types.VARCHAR),
                new BatchParameter(contaCorrente.getConta(),Types.VARCHAR),
                new BatchParameter(contaCorrente.getDigitoConta(),Types.VARCHAR),
                new BatchParameter(new Integer(numContrato.intValue()),Types.NUMERIC),
                new BatchParameter(proposta.getCidadeOperadora().getIdCidade(), Types.VARCHAR),
                new BatchParameter(new Integer(0), Types.NUMERIC),
                new BatchParameter(Types.NUMERIC, true),
                new BatchParameter(Types.VARCHAR, true),
                new BatchParameter(Types.NUMERIC, true) };
        return parameters;
    }
    
    /**
     * @param idPontoContrato
     * @return
     */
    public static  BatchParameter[] obterParametrosInserirExtensaoVoio(Long idPontoContrato) {
        BatchParameter[] parameters = new BatchParameter[4];
        
        parameters[0] = new BatchParameter(idPontoContrato, Types.NUMERIC);
        parameters[1] = new BatchParameter(0, Types.NUMERIC);
        parameters[2] = new BatchParameter(Types.NUMERIC, true);
        parameters[3] = new BatchParameter(Types.VARCHAR, true);
        return parameters;
    }
    
    /**
     * @param proposta
     * @param numContrato
     * @param idTipoSolicProd
     * @param parameters
     * @param obj
     */
    public static  BatchParameter[]  obterParametrosExtensaoNETFone(CpPropostaBean proposta, Long numContrato,
                                            Long idTipoSolicProd , Object[] obj) {
        
        BatchParameter[] parameters = new BatchParameter[8];
        parameters[0] = new BatchParameter(new Integer(numContrato.intValue()), Types.NUMERIC);
        parameters[1] = new BatchParameter(proposta.getCidadeOperadora().getIdCidade(), Types.VARCHAR);
        parameters[2] = new BatchParameter(new Integer(236), Types.NUMERIC);
        parameters[3] = new BatchParameter((Integer)obj[2], Types.NUMERIC);
        parameters[4] = new BatchParameter(new Long(idTipoSolicProd), Types.NUMERIC);
        parameters[5] = new BatchParameter(new Integer(0), Types.NUMERIC);
        parameters[6] = new BatchParameter(new Integer(0), Types.NUMERIC);
        parameters[7] = new BatchParameter(ProspectConstants.OBSERVACAO_EXTENSAO + " - " + String.valueOf(obj[3]), Types.VARCHAR);
        
        return parameters;
    }
    
    /**
     * @param proposta
     * @param idPonto
     * @param numContrato
     * @param tel
     * @return
     */
    public static  BatchParameter[] obterParametrosReservaTelefoneVoip(CpPropostaBean proposta, Long idPonto,
                                            Long numContrato, CpReservaTelefoneVoipBean tel) {
        BatchParameter[] parameters = {
                new BatchParameter(proposta.getCidadeOperadora().getIdCidade(), Types.VARCHAR),                        
                new BatchParameter(new Integer(numContrato.intValue()), Types.NUMERIC),
                new BatchParameter(proposta.getIdProposta(), Types.NUMERIC),                        
                new BatchParameter(new Integer(5), Types.NUMERIC),
                new BatchParameter(new Integer(idPonto.intValue()), Types.NUMERIC),                        
                new BatchParameter(tel.getDdd(), Types.VARCHAR),
                new BatchParameter(tel.getTelefone(), Types.VARCHAR),          
                new BatchParameter(new Integer(1), Types.NUMERIC),
                new BatchParameter(new Integer(222), Types.NUMERIC),
                new BatchParameter(new Integer(999), Types.NUMERIC),       
                new BatchParameter(new Integer(999), Types.NUMERIC),
                new BatchParameter(new Integer(0), Types.NUMERIC),
                new BatchParameter(new Integer(0), Types.NUMERIC),
                new BatchParameter(null, Types.VARCHAR, true),
                new BatchParameter(null, Types.NUMERIC, true),
                new BatchParameter(Types.NUMERIC, true),
                new BatchParameter(Types.VARCHAR, true) };
        return parameters;
    }
    
    /**
     * @param proposta
     * @param prodAgregado
     * @param idPonto
     * @param numContrato
     * @param idAssinante
     * @param idEndereco
     * @param adesao
     * @return
     */
    public static  BatchParameter[] obterParametroIncluiPontoProduto(CpPropostaBean proposta,
                                            CpProdutosAgregadosBean prodAgregado, Long idPonto,
                                            Long numContrato, Long idAssinante, Long idEndereco,
                                            Integer adesao) {
        BatchParameter[] parameters = {
                new BatchParameter(new Integer(idPonto.intValue()), Types.NUMERIC),
                new BatchParameter(new Integer(numContrato.intValue()), Types.NUMERIC),
                new BatchParameter(proposta.getCidadeOperadora().getIdCidade(), Types.VARCHAR),
                new BatchParameter(prodAgregado.getProduto().getIdProduto(),Types.NUMERIC),
                new BatchParameter(prodAgregado.getPromocao().getIdPromocao(),Types.NUMERIC),
                new BatchParameter(prodAgregado.getPlanoPgto().getIdPlanoPgto(),Types.NUMERIC),
                new BatchParameter(new Integer(1), Types.NUMERIC),
                new BatchParameter(new Integer(1), Types.NUMERIC),
                new BatchParameter(adesao, Types.NUMERIC),
                new BatchParameter(proposta.getDtVenda(), Types.DATE),
                new BatchParameter(proposta.getIdTipoVenda(), Types.NUMERIC),
                new BatchParameter(proposta.getVendedor().getPessoa().getIdPessoa(), Types.VARCHAR),
                new BatchParameter(proposta.getIdMidia(),Types.NUMERIC),
                new BatchParameter(proposta.getIdCampanha(),Types.NUMERIC),
                new BatchParameter(new Integer(idAssinante.intValue()), Types.NUMERIC),
                new BatchParameter(new Integer(idEndereco.intValue()),Types.NUMERIC),
                new BatchParameter(proposta.getObsos(), Types.VARCHAR),
                new BatchParameter(Types.VARCHAR, true),
                new BatchParameter(Types.NUMERIC, true),
                new BatchParameter(proposta.getIdAtendente(),Types.VARCHAR),                   
                new BatchParameter(proposta.getDsContato(), Types.VARCHAR),                    
                new BatchParameter( (proposta.getNrDddContato() != null ? proposta.getNrDddContato() : "") + 
                                    (proposta.getNrTelContato() != null ? proposta.getNrTelContato() : ""), Types.VARCHAR), 
                new BatchParameter(null, Types.NUMERIC)
                
        };
        return parameters;
    }
    
    /**
     * @param proposta
     * @param ponto
     * @param idPonto
     * @param numContrato
     * @param idAssinante
     * @param idEndereco
     * @param adesao
     * @param obsOs
     * @return
     */
    public static BatchParameter[] obterParametrosIssEnvioIncluirPonto(CpPropostaBean proposta, CpPontoBean ponto,
                                            Long idPonto, Long numContrato, Long idAssinante, Long idEndereco,
                                            Integer adesao, String obsOs) {
        BatchParameter[] parameters = {                
                new BatchParameter(idPonto, Types.NUMERIC),
                new BatchParameter(numContrato,  Types.NUMERIC),
                new BatchParameter(proposta.getCidadeOperadora().getIdCidade(),  Types.VARCHAR),
                new BatchParameter(ponto.getProduto().getIdProduto(), Types.NUMERIC),
                new BatchParameter(ponto.getPromocao().getIdPromocao(), Types.NUMERIC),
                new BatchParameter(ponto.getPlanoPgto().getIdPlanoPgto(), Types.NUMERIC),
                new BatchParameter(new Integer(1),  Types.NUMERIC),
                new BatchParameter(new Integer(1),  Types.NUMERIC),
                new BatchParameter(adesao,  Types.NUMERIC),
                new BatchParameter(proposta.getDtVenda(),  Types.DATE),
                new BatchParameter(proposta.getIdTipoVenda(),  Types.NUMERIC),
                new BatchParameter(proposta.getVendedor().getPessoa().getIdPessoa(),  Types.VARCHAR),
                new BatchParameter(proposta.getIdMidia(), Types.NUMERIC),
                new BatchParameter(proposta.getIdCampanha(), Types.NUMERIC),
                new BatchParameter(idAssinante,  Types.NUMERIC),
                new BatchParameter(idEndereco, Types.NUMERIC),                                       
                new BatchParameter(obsOs, Types.VARCHAR),                
                new BatchParameter(Types.VARCHAR, true),
                new BatchParameter(Types.NUMERIC, true), 
                new BatchParameter(proposta.getIdAtendente(), Types.VARCHAR),
                new BatchParameter(proposta.getDsContato(),  Types.VARCHAR),
                new BatchParameter((proposta.getNrDddContato() != null ? proposta.getNrDddContato() : "") + 
                                    (proposta.getNrTelContato() != null ? proposta.getNrTelContato() : ""),  Types.VARCHAR),
                new BatchParameter(null, Types.NUMERIC)
                
        };
        return parameters;
    }
    
    /**
     * @param proposta
     * @param ponto
     * @param idPonto
     * @return
     */
    public static BatchParameter[] obterParametroRetornoPonto(CpPropostaBean proposta, CpPontoBean ponto,
                                            Long idPonto) {
        BatchParameter[] parameters = new BatchParameter[4];
        parameters[0] = new BatchParameter(new Integer(idPonto.intValue()), Types.NUMERIC);
        parameters[1] = new BatchParameter(proposta.getIdAtendente(), Types.VARCHAR);
        if(ponto.getRetornoTelefonico() != null ){
            parameters[2] = new BatchParameter(ponto.getRetornoTelefonico(), Types.NUMERIC);
        }else{
            parameters[2] = new BatchParameter(0, Types.NUMERIC);
        }            
        parameters[3] = new BatchParameter(null, Types.NUMERIC);
        return parameters;
    }
    
    /**
     * @param proposta
     * @param numContrato
     * @param ponto
     * @param idEndereco
     * @return
     */
    public static BatchParameter[] obterParametrosEnvioIssInserirPonto(CpPropostaBean proposta, Long numContrato,
                                            CpPontoBean ponto, Long idEndereco) {
        BatchParameter[] parameters = {
                new BatchParameter(new Integer(numContrato.intValue()),Types.NUMERIC),
                new BatchParameter(proposta.getCidadeOperadora().getIdCidade(), Types.VARCHAR),
                new BatchParameter(new Integer(idEndereco.intValue()),Types.NUMERIC),
                new BatchParameter(ponto.getLocalizacao().getIdLocalizacao(),Types.NUMERIC),
                new BatchParameter("", Types.VARCHAR),
                new BatchParameter(Types.NUMERIC, true),
                new BatchParameter(Types.VARCHAR, true),
                new BatchParameter(Types.NUMERIC, true) };
        return parameters;
    }
    
    /**
     * @param proposta
     * @return
     */
    public static BatchParameter[] obterParametrosBuscaServicosProposta(CpPropostaBean proposta) {
        BatchParameter[] parametros = new BatchParameter[3];
        parametros[0] = new BatchParameter(BatchParameter.ORACLE_CURSOR, true);
        parametros[1] = new BatchParameter(proposta.getIdProposta(), Types.NUMERIC);
        parametros[2] = new BatchParameter(0, Types.NUMERIC);
        return parametros;
    }

    
    /**
     * @param proposta
     * @param numContrato
     * @param dynamicBean
     * @param idProduto
     * @param idPromocao
     * @param idPlanoPgto
     * @param idTipoVenda
     * @param idEquipeVenda
     * @param idMidia
     * @param idCampanha
     * @param vendedor
     * @return
     */
    public static BatchParameter[] obterParametrosEnvioIssServAvancados(CpPropostaBean proposta, Long numContrato,
                                            DynamicBean dynamicBean, BigDecimal idProduto, BigDecimal idPromocao,
                                            BigDecimal idPlanoPgto, BigDecimal idTipoVenda,
                                            BigDecimal idEquipeVenda, BigDecimal idMidia, BigDecimal idCampanha,
                                            CpVendedorBean vendedor) {
        BatchParameter[] parameters = new BatchParameter[21];
        parameters[0] = new BatchParameter(numContrato, Types.NUMERIC);
        parameters[1] = new BatchParameter(dynamicBean.get("ID_CIDADE"), Types.VARCHAR);
        parameters[2] = new BatchParameter(new Long(idProduto.toString()), Types.NUMERIC);
        parameters[3] = new BatchParameter(new Long(idPromocao.toString()), Types.NUMERIC);
        parameters[4] = new BatchParameter(new Long(idPlanoPgto.toString()), Types.NUMERIC);
        parameters[5] = new BatchParameter(new Date(), Types.DATE);
        parameters[6] = new BatchParameter(new Long(idTipoVenda.toString()), Types.NUMERIC);
        if(idEquipeVenda != null)
        	parameters[7] = new BatchParameter(new Long(idEquipeVenda.toString()), Types.NUMERIC);
        else
        	parameters[7] = new BatchParameter(null, Types.NUMERIC);
        parameters[8] = new BatchParameter(vendedor.getPessoa().getIdPessoa() != null ? vendedor
                                                .getPessoa().getIdPessoa() : null, Types.VARCHAR);
        parameters[9] = new BatchParameter(new Long(idMidia.toString()), Types.NUMERIC);
        parameters[10] = new BatchParameter(new Long(idCampanha.toString()), Types.NUMERIC);
        parameters[11] = new BatchParameter(dynamicBean.get("FC_GERACAO_OS"), Types.VARCHAR);
        parameters[12] = new BatchParameter(dynamicBean.get("OBS"), Types.VARCHAR);
        parameters[13] = new BatchParameter("N".equals(dynamicBean.get("IMEDIATA")) ? 0 : 1,
                                                Types.NUMERIC);

        parameters[14] = new BatchParameter("O MESMO", Types.VARCHAR);
        parameters[15] = new BatchParameter(
                                                (proposta.getNrDddContato() != null ? proposta
                                                                                        .getNrDddContato()
                                                                                        : "")
                                                                                        + (proposta.getNrTelContato() != null ? proposta
                                                                                                                                .getNrTelContato()
                                                                                                                                : ""),
                                                BatchParameter.VARCHAR);

        parameters[16] = new BatchParameter("917", BatchParameter.VARCHAR);

        parameters[17] = new BatchParameter(Types.NUMERIC, true);
        parameters[18] = new BatchParameter(Types.VARCHAR, true);
        parameters[19] = new BatchParameter(Types.NUMERIC, true);

        parameters[20] = new BatchParameter(null, Types.NUMERIC);
        return parameters;
    }
    
    /**
     * @param proposta
     * @return
     */
    public static BatchParameter[] obterParametrosSegmento(CpPropostaBean proposta) {
        BatchParameter[] parameters = {
                new BatchParameter(null,Types.NUMERIC),
                new BatchParameter(proposta.getNumContrato(), Types.NUMERIC),
                new BatchParameter(proposta.getCidadeOperadora().getIdCidade(), BatchParameter.VARCHAR),
                new BatchParameter(null,Types.NUMERIC),
                new BatchParameter(null,Types.NUMERIC),
                new BatchParameter(proposta.getTipoSegmento().getIdTipoSegmento(),Types.NUMERIC),
                new BatchParameter(null,Types.NUMERIC),
                new BatchParameter(new Date(), Types.DATE)};
        return parameters;
    }
    
    /**
     * @param proposta
     * @param numContrato
     * @param agregado
     * @return
     */
    public static BatchParameter[] obterParametrosEnvioIssProdAgregados(CpPropostaBean proposta, Long numContrato,
                                            Object[] agregado) {
        BatchParameter[] parameters = new BatchParameter[8];
        parameters[0] = new BatchParameter(numContrato, Types.NUMERIC);
        parameters[1] = new BatchParameter(proposta.getCidadeOperadora().getIdCidade(), Types.VARCHAR);
        parameters[2] = new BatchParameter(null, Types.DATE);
        parameters[3] = new BatchParameter(agregado[2], Types.NUMERIC);                        
        parameters[4] = new BatchParameter(agregado[0], Types.NUMERIC);
        parameters[5] = new BatchParameter(proposta.getIdAtendente(), Types.VARCHAR);
        parameters[6] = new BatchParameter(null, Types.VARCHAR);
        parameters[7] = new BatchParameter(null, Types.FLOAT);
        return parameters;
    }

    /**
     * @param idEdificacao
     * @return
     */
    public static  BatchParameter[] obterParametroIssEnvioEndereco(Integer idEdificacao) {
        BatchParameter[] parameters = {
                new BatchParameter(idEdificacao, Types.NUMERIC),
                new BatchParameter(Types.NUMERIC, true),
                new BatchParameter(Types.VARCHAR, true),
                new BatchParameter(Types.NUMERIC, true) };
        return parameters;
    }  
    
    /**
     * @param enderecoCobranca
     * @param idAssinante
     * @return
     */
    public static BatchParameter[] obterParametrosIssIncluirEnderecoExterno(CpEnderecoProspectBean enderecoCobranca,
                                            Long idAssinante , UserInfo user) {
        BatchParameter[] parameters = {
                new BatchParameter(idAssinante != null ? new Integer(idAssinante.intValue()) : null, 
                        Types.NUMERIC),
                new BatchParameter(enderecoCobranca.getEndcompleto(),Types.VARCHAR),
                new BatchParameter(enderecoCobranca.getNumero(),Types.VARCHAR),
                new BatchParameter(enderecoCobranca.getComplemento(),Types.VARCHAR),
                new BatchParameter("", Types.VARCHAR),
                new BatchParameter("", Types.VARCHAR),
                new BatchParameter(enderecoCobranca.getBairro(),Types.VARCHAR),
                new BatchParameter(enderecoCobranca.getCep(),Types.VARCHAR),
                new BatchParameter(enderecoCobranca.getCidade(),Types.VARCHAR),
                new BatchParameter(enderecoCobranca.getEstado(),Types.VARCHAR),
                new BatchParameter(new Integer(1), Types.NUMERIC),
                new BatchParameter(new Integer(0), Types.NUMERIC),
                new BatchParameter(null, Types.VARCHAR),
                new BatchParameter("0", Types.VARCHAR),
                new BatchParameter(enderecoCobranca.getIdLogradouroEcn(), Types.NUMERIC),
                new BatchParameter(enderecoCobranca.getIdBairroEcn(), Types.NUMERIC),
                new BatchParameter(enderecoCobranca.getCep() != null ? new Integer(enderecoCobranca.getCep()) : null,
                                                        Types.NUMERIC),
                new BatchParameter(enderecoCobranca.getIdUnidadeOperacionalEcn(), Types.NUMERIC),
                new BatchParameter(enderecoCobranca.getTipoPostagem(), Types.VARCHAR),
                new BatchParameter(user.getUserId(), Types.VARCHAR),
                new BatchParameter(Types.VARCHAR, true),
                new BatchParameter(Types.NUMERIC, true) };
        return parameters;
    }
    
    /**
     * @param proposta
     * @param idAssinante
     * @param cobranca
     * @param dtfatura
     * @param vencidoVincendo
     * @param numeroPontos
     * @return
     */
    public static BatchParameter[] obterParametrosEnvioIssContrato(CpPropostaBean proposta, Long idAssinante,
                                            final CpCobrancaBean cobranca, Date dtfatura, Integer vencidoVincendo,
                                            int numeroPontos) {
        BatchParameter[] parameters = {
                // id Assinante
                new BatchParameter(new Integer(idAssinante.intValue()), Types.NUMERIC),
                new BatchParameter(proposta.getCidadeOperadora().getIdCidade(), Types.VARCHAR),
                new BatchParameter(new Integer(1), Types.NUMERIC),
                new BatchParameter(new Integer(1), Types.NUMERIC),
                new BatchParameter(new Integer(1), Types.NUMERIC),
                new BatchParameter(new Integer(numeroPontos),Types.NUMERIC),
                new BatchParameter(new Integer(1), Types.NUMERIC),
                new BatchParameter(cobranca.getDiaVencimento(),Types.NUMERIC),
                new BatchParameter(cobranca.getTipoCobranca().getIdTipoCobranca().intValue() == 2 ? new Integer(1): cobranca.getTipoCobranca().getIdTipoCobranca(), Types.NUMERIC),
                new BatchParameter(new Integer(1), Types.NUMERIC),
                new BatchParameter(proposta.getIdAtendente(),Types.VARCHAR),
                new BatchParameter(vencidoVincendo, Types.NUMERIC),
                new BatchParameter(proposta.getIdAtendente(),Types.VARCHAR),
                new BatchParameter(proposta.getVendedor().getPessoa().getIdPessoa(),Types.VARCHAR), 
                new BatchParameter(proposta.getDtVenda(),Types.DATE),
                new BatchParameter(proposta.getIdTipoVenda(),Types.NUMERIC),
                new BatchParameter(new Integer(0), Types.NUMERIC),
                new BatchParameter(proposta.getObservacao(),Types.VARCHAR),
                new BatchParameter(proposta.getObsos(), Types.VARCHAR),
                new BatchParameter(proposta.getIdTipoAssinante(), Types.NUMERIC),
                new BatchParameter("", Types.VARCHAR),
                new BatchParameter(Types.NUMERIC, true),
                new BatchParameter(Types.VARCHAR, true),
                new BatchParameter(Types.NUMERIC, true),
                new BatchParameter(dtfatura,Types.DATE),
                new BatchParameter(proposta.getIdPerfilCliente(),Types.NUMERIC),
                new BatchParameter(proposta.getIdProposta(),Types.NUMERIC),
                new BatchParameter(cobranca.getIdFormaEnvFat().getIdFormaEnvioFatura(),Types.NUMERIC)};
        return parameters;
    }
    

    /**
     * @param idEnder
     * @param prospect
     * @param telResidencial
     * @param telComercial
     * @param telFax
     * @param telOutros
     * @param cpf
     * @param cnpj
     * @return
     */
    public static  BatchParameter[] obterParametrosEnvioIssAssinante(Long idEnder, CpProspectBean prospect,
                                            String telResidencial, String telComercial, String telFax,
                                            String telOutros, String cpf, String cnpj) {
        BatchParameter[] parameters = {
                new BatchParameter(new Integer(idEnder.intValue()),Types.NUMERIC),
                new BatchParameter(prospect.getIdTipoPessoa(),Types.NUMERIC),
                new BatchParameter(prospect.getSexo(),Types.NUMERIC),
                new BatchParameter(prospect.getNome(),Types.VARCHAR),
                new BatchParameter(prospect.getIdProfissao(),Types.NUMERIC),
                new BatchParameter(telResidencial, Types.VARCHAR),
                new BatchParameter(telComercial, Types.VARCHAR),
                new BatchParameter(prospect.getRamal(), Types.VARCHAR),
                new BatchParameter(telFax, Types.VARCHAR),
                new BatchParameter(prospect.getDataNascimento(), Types.DATE),
                new BatchParameter(prospect.getIdEstadoCivil(), Types.NUMERIC),
                new BatchParameter(prospect.getIdTipoPessoa().intValue() == SnTipoPessoaBean.TP_FISICA ? cpf : cnpj , Types.VARCHAR),
                new BatchParameter(prospect.getRg(), Types.VARCHAR),
                new BatchParameter(prospect.getIdOrgaoExpedidor(),Types.NUMERIC),
                new BatchParameter(null, Types.NUMERIC),
                new BatchParameter(prospect.getNomePai(), Types.VARCHAR),
                new BatchParameter(prospect.getNomeMae(), Types.VARCHAR),
                new BatchParameter(null, Types.NUMERIC),
                new BatchParameter(prospect.getIdEscolaridade(), Types.NUMERIC),
                new BatchParameter(telOutros, Types.VARCHAR),
                new BatchParameter(prospect.getEmail(), Types.VARCHAR),
                new BatchParameter("0", Types.VARCHAR),
                new BatchParameter(Types.NUMERIC, true),
                new BatchParameter(Types.VARCHAR, true),
                new BatchParameter(Types.NUMERIC, true),
                new BatchParameter(prospect.getCcTelCel(), Types.VARCHAR),
                new BatchParameter(prospect.getCodigoSuframa(), Types.VARCHAR)};
        return parameters;
    }
    
    public static  Date obterPrimeiroVencimento(CpPropostaBean proposta ,  List dtFaturaRateio){

        java.sql.Date data = null;

        try {            
            Timestamp dtFatura = (Timestamp) dtFaturaRateio.get(0);

            SimpleDateFormat in= new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

            String result = out.format(in.parse(dtFatura.toString()));
            data = new java.sql.Date(out.parse(result).getTime());
        } catch (Exception e) {
            data = null;
        }
        return data;
    }   

}
