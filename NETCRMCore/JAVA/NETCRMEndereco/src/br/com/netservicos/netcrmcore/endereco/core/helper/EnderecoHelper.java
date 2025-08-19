package br.com.netservicos.netcrmcore.endereco.core.helper;

import java.sql.Types;
import java.util.HashMap;

import br.com.netservicos.core.bean.cp.CpEnderecoProspectBean;
import br.com.netservicos.core.bean.cp.CpProspectBean;
import br.com.netservicos.core.bean.cp.CpTipoEnderecoBean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.core.dao.BatchParameter;
import br.com.netservicos.netcrmcore.geral.constants.GeralConstants;
import br.com.netservicos.netcrmcore.geral.util.GeralUtil;



public class EnderecoHelper {

    
    private EnderecoHelper() {
        //
    }
    
    /**
     * @param idCidade
     * @param idEdificacao
     * @param servico
     * @return
     */
    public static BatchParameter[] obterParametrosValidacaoTrechos(String idCidade, Integer idEdificacao, Integer servico) {
        BatchParameter[] parameters = {
                new BatchParameter(new Integer(idCidade), Types.NUMERIC, false),
                new BatchParameter(idEdificacao, Types.NUMERIC, false),
                new BatchParameter(servico, Types.NUMERIC, false),
                new BatchParameter(Types.NUMERIC, true),
                new BatchParameter(Types.NUMERIC, true),
                new BatchParameter(Types.NUMERIC, true) };
        return parameters;
    }
    
    
    /**
     * @param enderecoProspect
     * @param nomLogradouro
     * @return
     */
    public static String obterEnderecoCompleto(CpEnderecoProspectBean enderecoProspect, String nomLogradouro) {
        String enderecoCompleto = nomLogradouro + " " + GeralConstants.LABEL_NUMERO + " "
                + enderecoProspect.getNumero() + " " + GeralConstants.LABEL_BAIRRO + " "
                + enderecoProspect.getBairro() + " " + GeralConstants.LABEL_CEP + " "
                + enderecoProspect.getCep();
        return enderecoCompleto;
    }
    
    

    /**
     * @param item
     * @return
     */
    public static String obterComplementoEndereco(DynamicBean item) {
        String compl1 = GeralUtil.getString(item.get("DECODE(C.TXT_COMPL_NUM,NULL,C.COD_TIPO_COMPL1,/)"));
        String txtCompl1 = GeralUtil.getString(item.get("DECODE(C.TXT_COMPL_NUM,NULL,C.TXT_TIPO_COMPL1,C.TXT_COMPL_NUM)"));
        String compl2 = GeralUtil.getString(item.get("DECODE(C.TXT_COMPL_NUM,NULL,C.COD_TIPO_COMPL2,C.COD_TIPO_COMPL1)"));
        String txtCompl2 = GeralUtil.getString(item.get("DECODE(C.TXT_COMPL_NUM,NULL,C.TXT_TIPO_COMPL2,C.TXT_TIPO_COMPL1)"));
        String compl3 = GeralUtil.getString(item.get("DECODE(C.TXT_COMPL_NUM,NULL,C.COD_TIPO_COMPL3,C.COD_TIPO_COMPL2)"));
        String txtCompl3 = GeralUtil.getString(item.get("DECODE(C.TXT_COMPL_NUM,NULL,C.TXT_TIPO_COMPL3,C.TXT_TIPO_COMPL2)"));
        String compl4 = GeralUtil.getString(item.get("DECODE(C.TXT_COMPL_NUM,NULL,C.COD_TIPO_COMPL4,C.COD_TIPO_COMPL3)"));
        String txtCompl4 = GeralUtil.getString(item.get("DECODE(C.TXT_COMPL_NUM,NULL,C.TXT_TIPO_COMPL4,C.TXT_TIPO_COMPL3)"));
        String compl5 = GeralUtil.getString(item.get("COD_TIPO_COMPL1")); 
        String txtCompl5 = GeralUtil.getString(item.get("TXT_COMPL1"));
        String compl6 = GeralUtil.getString(item.get("COD_TIPO_COMPL2"));
        String txtCompl6 = GeralUtil.getString(item.get("TXT_COMPL2"));

        String complementos = compl1 + " " + txtCompl1 + " " + compl2 + " " + txtCompl2
                                                + " " + compl3 + " " + txtCompl3 + " "
                                                + compl4 + " " + txtCompl4 + " " + compl5
                                                + " " + txtCompl5 + " " + compl6 + " "
                                                + txtCompl6;
        return complementos;
    }
    
    
    /**
     * @param codHp
     * @return
     */
    public static BatchParameter[] obterParametrosListarEndereco(Integer codHp) {
        BatchParameter[] parameters = { new BatchParameter(BatchParameter.ORACLE_CURSOR, true),
                                                new BatchParameter(Types.NUMERIC, true),
                new BatchParameter(codHp, Types.NUMERIC), new BatchParameter(null, Types.VARCHAR), 
                new BatchParameter(null, Types.VARCHAR), new BatchParameter(null, Types.VARCHAR),
                new BatchParameter(null, Types.VARCHAR), new BatchParameter(null, Types.VARCHAR),
                new BatchParameter(null, Types.VARCHAR), new BatchParameter(null, Types.VARCHAR),
                new BatchParameter(null, Types.VARCHAR), new BatchParameter(null, Types.VARCHAR),
                new BatchParameter(null, Types.VARCHAR), new BatchParameter(null, Types.VARCHAR),
                new BatchParameter(null, Types.VARCHAR), new BatchParameter(null, Types.VARCHAR),
                new BatchParameter(null, Types.VARCHAR), new BatchParameter(null, Types.VARCHAR),
                new BatchParameter(null, Types.VARCHAR), new BatchParameter(null, Types.VARCHAR),
                new BatchParameter(null, Types.VARCHAR), new BatchParameter(null, Types.NUMERIC),
                new BatchParameter(null, Types.NUMERIC), new BatchParameter(null, Types.VARCHAR),
                new BatchParameter(null, Types.VARCHAR), new BatchParameter(null, Types.NUMERIC),
                new BatchParameter(null, Types.VARCHAR) };
        return parameters;
    }
    
    /**
     * @return
     */
    public static HashMap<String, String> getTiposEdificacoes() {
        HashMap<String, String> tiposEdificacao = new HashMap<String, String>();
        tiposEdificacao.put("1", GeralConstants.TIPO_EDIFICACAO_CASA);
        tiposEdificacao.put("2", GeralConstants.TIPO_EDIFICACAO_PREDIO);
        tiposEdificacao.put("3", GeralConstants.TIPO_EDIFICACAO_INDETERMINADO); 
        return tiposEdificacao;
    }
    
    /**
     * @param idCidade
     * @param node
     * @return
     */
    public static BatchParameter[] obterParametrosVoip(String idCidade, String node) {
        BatchParameter[] parametersVOIP = { new BatchParameter(idCidade, Types.VARCHAR, false),
                                                new BatchParameter(node, Types.VARCHAR, false),
                                                new BatchParameter(GeralConstants.PTECNOLOGIA,
                                                                                        Types.NUMERIC,
                                                                                        false),
                new BatchParameter(Types.VARCHAR, true), new BatchParameter(Types.NUMERIC, true) };
        return parametersVOIP;
    }
}
