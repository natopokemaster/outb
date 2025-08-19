package br.com.netservicos.core.bean.sn;

import java.util.Date;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela sn_rel_status_contrato_aux
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
 *                            Prior
 * Date       By              Version  Project/CSR    Description
 * ---------- --------------  -------- -------------- ----------------------------
 * 13/09/2010 Márcio Dantas		 N/A	NETCombo      Created.
 * ==============================================================================
 * </PRE>
 *
 *@hibernate.class table="sn_rel_status_contrato_aux"
 *                 schema="prod_jd"
 *                 dynamic-insert="true"
 *                 dynamic-update="true"
 *                 lazy="true"
 *                 batch-size="10"
 *
 */
public class SnRelStatusContratoAuxBean extends DomainBean {

	private static final long serialVersionUID = -4471849301152937332L;
	
	private SnRelStatusContratoAuxKey composite;
	
	private Date dtAlteracao;
	private String codOS;
	
	public static final String ATRIBUTO_ID_COMPOSITE = "composite";
	
	public static final String LST_STATUS_BY_EDIFICACAO = "lstDadosStatusContratoByEdificacao";

	/**
	 *  
	 */
	public SnRelStatusContratoAuxBean() {
		super(ATRIBUTO_ID_COMPOSITE);
	}

	/**
	 * 
	 * @return Composite
	 * 
	 * @hibernate.id
	 * type = "composite" 
	 */
	public SnRelStatusContratoAuxKey getComposite() {
		return composite;
	}
	
	/**
	 * 
	 * @param composite
	 */
	public void setComposite(SnRelStatusContratoAuxKey composite) {
		this.composite = composite;
	}

	/**
	 * @return the dtAlteracao
	 * @hibernate.property
	 * column = "dt_alteracao"
	 * type = "date"
	 */
	public Date getDtAlteracao() {
		return dtAlteracao;
	}

	/**
	 * @param dtAlteracao the dtAlteracao to set
	 */
	public void setDtAlteracao(Date dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}

	/**
	 * @return the codOS
	 * @hibernate.property
	 * column = "cod_os"
	 * type = "string"
	 */
	public String getCodOS() {
		return codOS;
	}

	/**
	 * @param codOS the codOS to set
	 */
	public void setCodOS(String codOS) {
		this.codOS = codOS;
	}

}