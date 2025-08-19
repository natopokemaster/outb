package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>Description :</B><BR>
 * Classe Bean que representa a tabela sn_forma_envio_fatura
 * </P>
 * <P>
 * <B> Issues : <BR>
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- ------------------------
 * 
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                           Prior
 * Date       By             Version  Project/CSR    	Description
 * ---------- -------------- -------- --------------    -------------------------
 * ==============================================================================
 * </PRE>
 *
 * 
 * @hibernate.class 
 * 		table="sn_forma_envio_fatura"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true" 
 *		batch-size="10"
 *		schema="prod_jd"
 *
 *
 */
public class SnFormaEnvioFaturaBean extends DomainBean {

	private static final long serialVersionUID = -1240024445085926736L;
	private static final String ID_FORMA_ENVIO_FATURA = "idFormaEnvioFatura";
	
	public SnFormaEnvioFaturaBean(){
		super(ID_FORMA_ENVIO_FATURA);
	}
	
	private Long idFormaEnvioFatura;	
	private String dsFormaEnvioFatura;

    /**
	 * @return Returns the idFormaEnvioFatura.
	 *
	 * @hibernate.id 
	 * 		generator-class="assigned"
	 * 		unsaved-value="null"
	 * 		column="id_forma_envio_fatura"
	 */ 
	public Long getIdFormaEnvioFatura() {
		return idFormaEnvioFatura;
	}
	public void setIdFormaEnvioFatura(Long idFormaEnvioFatura) {
		this.idFormaEnvioFatura = idFormaEnvioFatura;
	}
	
	/**
     * @return Returns the dsFormaEnvioFatura.
     * 
     * @hibernate.property
     * 		column = "ds_forma_envio_fatura"
     */
	public String getDsFormaEnvioFatura() {
		return dsFormaEnvioFatura;
	}
	public void setDsFormaEnvioFatura(String dsFormaEnvioFatura) {
		this.dsFormaEnvioFatura = dsFormaEnvioFatura;
	}
	
	
	
}
