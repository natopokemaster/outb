
package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Bean que representa a tabela SN_CARACTERISTICA.
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
 *
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "SN_REL_PERFIL_CLT_CARACT"
 *                   dynamic-insert = "true"
 *                   dynamic-update = "true"
 * 					 proxy = "br.com.netservicos.core.bean.sn.SnCaracteristicaPerfilBean"
 *					 lazy="true"
 *
 */
 
public class SnCaracteristicaPerfilBean extends DomainBean {

	public static final long serialVersionUID = 54123465742L;

	private Long idCaracteristica;
	private Integer idPerfilCliente;
	private Integer fnPontoPrincipal;

	public static final String ATRIBUTO_ID_CARACTERISTICA = "idCaracteristica";

	/**
	 *  
	 */
	public SnCaracteristicaPerfilBean() {
		super(ATRIBUTO_ID_CARACTERISTICA);
	}

	/**
	 * @return Returns the idCaracteristica.
	 * 
	 * @hibernate.id 
	 * generator-class="assigned"
	 * column="id_caracteristica"
	 * type = "long"
	 *
	 * 
	 */
	public Long getIdCaracteristica() {
		return idCaracteristica;
	}

	/**
	 * @param idCaracteristica The idCaracteristica to set.
	 * 
	 */
	public void setIdCaracteristica(Long idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
	}

	/**
	 * @return Returns the serialVersionUID.
	 * 
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * @return Returns the idCaracteristica.
	 * 
	 * @hibernate.id 
	 * generator-class="assigned"
	 * column="fn_ponto_principal"
	 * type = "int"
	 *
	 * 
	 */
	public Integer getFnPontoPrincipal() {
		return fnPontoPrincipal;
	}

	public void setFnPontoPrincipal(Integer fnPontoPrincipal) {
		this.fnPontoPrincipal = fnPontoPrincipal;
	}

	/**
	 * @return Returns the idCaracteristica.
	 * 
	 * @hibernate.id 
	 * generator-class="assigned"
	 * column="id_perfil_cliente"
	 * type = "int"
	 *
	 * 
	 */
	public Integer getIdPerfilCliente() {
		return idPerfilCliente;
	}

	public void setIdPerfilCliente(Integer idPerfilCliente) {
		this.idPerfilCliente = idPerfilCliente;
	}
}
