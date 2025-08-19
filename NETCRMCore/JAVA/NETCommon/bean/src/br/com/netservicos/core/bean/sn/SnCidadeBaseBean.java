package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 *  Classe Bean que representa a tabela sn_cidade_base.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- -------------------------
 * 
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                           Prior
 * Date       By             Version  Project/CSR    Description
 * ---------- -------------- -------- -------------- ----------------------------
 * 28/06/2007 Julio Perez    N/A      Entidades      Created.
 * 09/07/2007 Luiz C. Cherri 1.0      Entidades      Development.
 * ==============================================================================
 * </PRE>
 * 
 * @hibernate.class table = "sn_cidade_base"
 *                  dynamic-insert = "true"
 *                  dynamic-update = "true"
 *                  proxy="br.com.netservicos.core.bean.sn.SnCidadeBaseBean"
 *                  lazy="true"
 * 
 * @hibernate.cache
 *      usage = "read-write"
 * 
 */
public class SnCidadeBaseBean extends DomainBean {

    /**
     * 
     */
    private static final long serialVersionUID = 4633917445618789190L;

    public static final String ATRIBUTO_CID_CONTRATO = "cidContrato";

    public static final String LST_CIDADE_BASE_PERFIL_SUPERVISOR = "lstSnCidadeBasePerfilSupervisor";

    public static final String LST_CIDADE_BASE_PERFIL_GERENTE = "lstSnCidadeBasePerfilGerente";
    
    public static String LST_ALL_CIDADE_BASE = "lstSnCidadeBase";
    
    public static String LST_CIDADE_BASE_PERFIL_PLAN_COMERCIAL = "lstSnCidadeBasePerfilPlanComercial";


    public SnCidadeBaseBean() {
        super(ATRIBUTO_CID_CONTRATO);
    }
    
    private String cidContrato;
    
    private String nmAlias;
    
    private String ciNome;
    
    private String ciEstado;
    
    private String codOperadora;

    /**
     * @return Returns the cidContrato.
     * 
     * @hibernate.id 
     * generator-class="assigned"
     * unsaved-value = "null"
     * column="cid_contrato"
     */
    public String getCidContrato() {
        return cidContrato;
    }

    /**
     * @param cidContrato the cidContrato to set
     */
    public void setCidContrato(String cidContrato) {
        this.cidContrato = cidContrato;
    }

    /**
     * @hibernate.property
     *      column="ci_estado"
     * @return
     */
    public String getCiEstado() {
        return ciEstado;
    }

    /**
     * @param ciEstado the ciEstado to set
     */
    public void setCiEstado(String ciEstado) {
        this.ciEstado = ciEstado;
    }

    /**
     * @hibernate.property
     *      column="ci_nome"
     * @return
     */
    public String getCiNome() {
        return ciNome;
    }

    /**
     * @param ciNome the ciNome to set
     */
    public void setCiNome(String ciNome) {
        this.ciNome = ciNome;
    }

    /**
     * @hibernate.property
     *      column="cod_operadora"
     * @return
     */
    public String getCodOperadora() {
        return codOperadora;
    }

    /**
     * @param codOperadora the codOpereadora to set
     */
    public void setCodOperadora(String codOperadora) {
        this.codOperadora = codOperadora;
    }

    /**
     * @hibernate.property
     *      column="nm_alias"
     * @return
     */
    public String getNmAlias() {
        return nmAlias;
    }

    /**
     * @param nmAlias the nmAlias to set
     */
    public void setNmAlias(String nmAlias) {
        this.nmAlias = nmAlias;
    }

    public int compareTo(Object o) {
       SnCidadeBaseBean snCidadeBase = (SnCidadeBaseBean) o;
       int comparison = this.getCiNome().compareTo(snCidadeBase.getCiNome());
       if (comparison != 0) {
           return comparison;
       }
       return 0;
    }
    
}
