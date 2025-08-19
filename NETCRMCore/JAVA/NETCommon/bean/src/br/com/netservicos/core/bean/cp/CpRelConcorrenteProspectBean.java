package br.com.netservicos.core.bean.cp;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
* <P><B>
* Description :
* </B>
* <BR>
*   Classe Bean que representa a tabela Cp_Rel_Concorrente_Prospect.
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
* 02/05/2006 Ramon Oliveira  N/A      Entidades      Created.
* ==============================================================================
*  </PRE>
* 
* @hibernate.class table="cp_rel_concorrente_prospect" dynamic-insert="true"
*                  dynamic-update="true" dynamic-delete="true" lazy="false" batch-size="10"
* 
* 
* @hibernate.query name = "lstCpRelConcorrenteProspect" query = "select relConcorrente FROM
*                  br.com.netservicos.core.bean.cp.CpRelConcorrenteProspectBean relConcorrente
*                  where relConcorrente.prospect.idProspect = :idProspect"
*
*/

public class CpRelConcorrenteProspectBean extends DomainBean {	
	

	private static final long serialVersionUID = 1L;

	private Long idRelConcorrenteProspect;

	private CpConcorrenteBean concorrente;
	
	private CpProspectBean prospect; 

	private String dsPacoteConcorrente;

	private Long qtPontosConcorrente;

	private Double vlConcorrente;

	public static final String ID_REL_CONCORRENTE_PROSPECT = "idRelConcorrenteProspect";

	public CpRelConcorrenteProspectBean() {
		super(ID_REL_CONCORRENTE_PROSPECT);
	}
	
	/**
	 * @return Returns the idRelConcorrenteProspect
	 * @hibernate.id column="id_rel_concorrente_prospect" generator-class="sequence"
	 * @hibernate.generator-param name="sequence" value="sqcp_rel_concorrente_prospect"
	 */
	public Long getIdRelConcorrenteProspect() {
		return idRelConcorrenteProspect;
	}

	public void setIdRelConcorrenteProspect(Long idRelConcorrenteProspect) {
		this.idRelConcorrenteProspect = idRelConcorrenteProspect;
	}

	/**
	 * @hibernate.many-to-one
	 *      column="id_concorrente"
	 *      cascade="none"
	 *      insert="true"
     *      update="true"
     *      not-null="true"
     * @return
     */
	public CpConcorrenteBean getConcorrente() {
		return concorrente;
	}

	public void setConcorrente(CpConcorrenteBean concorrente) {
		this.concorrente = concorrente;
	}

	 /**
	 * @hibernate.many-to-one
	 * 		cascade="none"
	 *      column="id_prospect"
	 *      insert="true"
     *      update="true"
     *      not-null="true"
     *       
     * @return
     */
    public CpProspectBean getProspect() {
        return prospect;
    }
	
	public void setProspect(CpProspectBean prospect) {
		this.prospect = prospect;
	}

	/**
	 * @hibernate.property
	 *      column="ds_pacote_concorrente"
	 */
	public String getDsPacoteConcorrente() {
		return dsPacoteConcorrente;
	}

	public void setDsPacoteConcorrente(String dsPacoteConcorrente) {
		this.dsPacoteConcorrente = dsPacoteConcorrente;
	}

	/**
	 * @hibernate.property
	 *      column="qt_pontos_concorrente"
	 */
	public Long getQtPontosConcorrente() {
		return qtPontosConcorrente;
	}

	public void setQtPontosConcorrente(Long qtPontosConcorrente) {
		this.qtPontosConcorrente = qtPontosConcorrente;
	}

	/**
	 * @hibernate.property
	 *      column="vl_concorrente"
	 */
	public Double getVlConcorrente() {
		return vlConcorrente;
	}

	public void setVlConcorrente(Double vlConcorrente) {
		this.vlConcorrente = vlConcorrente;
	}
	
	public boolean equals(Object obj) {
		CpRelConcorrenteProspectBean relConcorrenteProspect = (CpRelConcorrenteProspectBean) obj;
		if (relConcorrenteProspect != null && relConcorrenteProspect.getIdRelConcorrenteProspect() != null && idRelConcorrenteProspect != null)
			if (relConcorrenteProspect.getIdRelConcorrenteProspect().longValue() == idRelConcorrenteProspect.longValue())
				return true;
		return super.equals(obj);
	}

}
