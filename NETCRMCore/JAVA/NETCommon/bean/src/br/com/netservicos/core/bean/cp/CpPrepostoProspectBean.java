package br.com.netservicos.core.bean.cp;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * @hibernate.class
 *      table = "cp_preposto_prospect"
 *      batch-size = "10"
 *      dynamic-update = "true"
 *      lazy="false"
 * 
 * 
 * @author Leonardo Westphal
 * 
 * @hibernate.query name = "lstPrepostosByProspect"
 * 					query = "FROM br.com.netservicos.core.bean.cp.CpPrepostoProspectBean preposto
 *                          WHERE preposto.idProspect = :idProspect"
 * 
 * @hibernate.query name  = "lstPrepostoByIdProspect"
 *                 query = "SELECT preposto.idPrepostoProspect 
 *                          FROM br.com.netservicos.core.bean.cp.CpPrepostoProspectBean preposto
 *                          WHERE preposto.idProspect = :idProspect"  
 *              
 */
public class CpPrepostoProspectBean extends DomainBean {
    
	public static final String LST_PREPOSTOS_BY_PROSPECT = "lstPrepostosByProspect";
	
    private Integer idPreposto;
    private CpProspectBean prospect;
    private String dsRelacao;
    private String nmPreposto; 
    private Long idPrepostoProspect;
    private Long idProspect;
    
    public CpPrepostoProspectBean() {
        super("idPrepostoProspect");
    }

    public CpPrepostoProspectBean(Long idPrepostoProspect) {
        this();
        setIdPrepostoProspect(idPrepostoProspect);
    }         
    
    /**
     * @hibernate.property  
     * column = "nm_preposto"     
     * @return
     */
    public String getNmPreposto() {
        return nmPreposto;
    }

    /**
     * @hibernate.id
     *      column = "id_preposto_prospect"
     *      generator-class = "sequence"
     * @hibernate.generator-param 
     *      name = "sequence"
     *      value = "sq_cp_id_preposto_prospect"
     *      
     * @return
     */
    public Long getIdPrepostoProspect() {
        return idPrepostoProspect;
    }

    /**
     * @hibernate.property 
     *  column = "id_preposto"
     * @return
     */
    public Integer getIdPreposto() {
        return idPreposto;
    }
    
    public CpProspectBean getProspect() {
        return prospect;
    }

    /**
     * @hibernate.property 
     * column = "ds_relacao" 
     * @return
     */
    public String getDsRelacao() {
        return dsRelacao;
    }   
    
    /**
     * @hibernate.property
     * column = "id_prospect"
     * @return
     */
    public Long getIdProspect() {
    	return idProspect;
    }

    public void setIdPrepostoProspect(Long idPrepostoProspect) {
        this.idPrepostoProspect = idPrepostoProspect;
    }
    
    public void setIdPreposto(Integer idPreposto) {
        this.idPreposto = idPreposto;
    }

    public void setProspect(CpProspectBean prospect) {
        this.prospect = prospect;
    }

    public void setDsRelacao(String dsRelacao) {
        this.dsRelacao = dsRelacao;
    }
    
    public void setNmPreposto(String nmPreposto) {
        this.nmPreposto = nmPreposto;
    }
    
    public void setIdProspect(Long idProspect) {
    	this.idProspect = idProspect;
    }

}