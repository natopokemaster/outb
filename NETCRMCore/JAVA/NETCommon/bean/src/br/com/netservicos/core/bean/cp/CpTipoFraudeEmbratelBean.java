package br.com.netservicos.core.bean.cp;

import br.com.netservicos.framework.core.bean.DomainBean;

/**  
	 * @hibernate.class table="cp_tipo_fraude_embratel"
 *                  dynamic-insert="true"
 *                  dynamic-update="true"
 *                  lazy="true" 
 *					batch-size="10"
 *  
 */ 

public class CpTipoFraudeEmbratelBean extends DomainBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5217474091941654971L;
	private Long idTipoFraude;
	private String dsFraude;
	
	public CpTipoFraudeEmbratelBean() {
		super("idTipoFraude");
	}
	
	  /**
	 * @hibernate.property
	 * 			column="ds_fraude"
	 * @return
	 */
	public String getDsFraude() {
		return dsFraude;
	}
	
	public void setDsFraude(String dsFraude) {
		this.dsFraude = dsFraude;
	}
	
    /**
     * @hibernate.id
     * 		column="id_tipo_fraude"	
     * 		generator-class="sequence"
     * @hibernate.generator-param
     *      name="sequence"
     *      value="scp_tipo_fraude"
     * @return
     */
	public Long getIdTipoFraude() {
		return idTipoFraude;
	}
	
	public void setIdTipoFraude(Long idTipoFraude) {
		this.idTipoFraude = idTipoFraude;
	}
}
