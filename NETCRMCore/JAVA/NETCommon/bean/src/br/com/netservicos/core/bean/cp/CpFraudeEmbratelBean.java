package br.com.netservicos.core.bean.cp;

import java.sql.Date;

import br.com.netservicos.framework.core.bean.DomainBean;

/**  
 	 * @hibernate.class table="cp_fraude_embratel"
	 *                  dynamic-insert="true"
	 *                  dynamic-update="true"
	 *                  lazy="true" 
	 *					batch-size="10"
	 *                  
	 * 
	 *                  
	 * @hibernate.query name  = "lstPendenciaFraudeEmbratelCpf" 
	 *                  query = "SELECT COUNT(1)
	 *            
	 *                  		 FROM 
	 *                  				br.com.netservicos.core.bean.cp.CpFraudeEmbratelBean fraudeEmbratel
	 *                  		 where
	 *                  				fraudeEmbratel.nrDocumento = to_char(:cpf) AND 
	 *                  				fraudeEmbratel.fcNegativado = 'S'"    
	 *   
	 * @hibernate.query name  = "lstPendenciaFraudeEmbratelCnpj" 
	 *                  query = "SELECT COUNT(1)
	 *            
	 *                  		 FROM 
	 *                  				br.com.netservicos.core.bean.cp.CpFraudeEmbratelBean fraudeEmbratel
	 *                  		 where
	 *                  				fraudeEmbratel.nrDocumento = to_char(:cnpj) AND 
	 *                  				fraudeEmbratel.fcNegativado = 'S'"    
	 *                                                  
	 *                           
*/


public class CpFraudeEmbratelBean extends DomainBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3526694676231039215L;

	/**
	 * 
	 * construtor padrão
	 */
    public CpFraudeEmbratelBean() {
		super("idTipoFraude");
	}
    
    
	
    private String nrDocumento;
    private Long idTipoFraude;
    private CpTipoFraudeEmbratelBean tipoFraudeEmbratel;
    private Date dtFraude;
    private String fcNegativado;
    
    /**
	 * @hibernate.property
	 * 			column="dt_fraude"
	 * @return
	 */
	public Date getDtFraude() {
		return dtFraude;
	}
	
	public void setDtFraude(Date dtFraude) {
		this.dtFraude = dtFraude;
	}
	
	/**
	 * @hibernate.property
	 * 			column="fc_negativado"
	 * @return
	 */
	public String getFcNegativado() {
		return fcNegativado;
	}
	
	public void setFcNegativado(String fcNegativado) {
		this.fcNegativado = fcNegativado;
	}
	
	   /**
     * @hibernate.many-to-one  
     * 		column="id_tipo_fraude"
     * 		cascade="none"
     * 		update="false"
     * 		insert="false"
     * 
     * @return
     */
	public CpTipoFraudeEmbratelBean getTipoFraudeEmbratel() {
		return tipoFraudeEmbratel;
	}

	public void setTipoFraudeEmbratel(CpTipoFraudeEmbratelBean tipoFraudeEmbratel) {
		this.tipoFraudeEmbratel = tipoFraudeEmbratel;
	}

	/**
	 * @hibernate.property
	 * 			column="nr_documento"
	 * @return
	 */
	public String getNrDocumento() {
		return nrDocumento;
	}
	
	public void setNrDocumento(String nrDocumento) {
		this.nrDocumento = nrDocumento;
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
