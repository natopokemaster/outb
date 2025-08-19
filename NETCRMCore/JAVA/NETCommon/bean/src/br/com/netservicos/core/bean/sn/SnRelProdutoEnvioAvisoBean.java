package br.com.netservicos.core.bean.sn;

import java.util.Date;
import java.util.List;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 *  Classe Key que representa a chave composta para a tabela sn_rel_produto_envio_envio.
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
 *                               Prior
 * Date       By                 Version  Project/CSR     Description
 * ---------- ------------------ -------- --------------  -----------------------
 * 02/04/2011 Leonardo Sugahara    N/A    Aviso de Compra Created.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class
 * 		table="sn_rel_produto_envio_aviso"
 * 		schema = "PROD_JD"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true" 
 *		batch-size="10"
 *   
 */
public class SnRelProdutoEnvioAvisoBean extends DomainBean {

	private static final String ID_PRODUTO_FORMA_ENVIO = "idProdutoFormaEnvio";


	private static final long serialVersionUID = -8593657670854144690L;

	
	/**
	 * ID_PRODUTO_FORMA_ENVIO NUMBER(10) N. Identificador da relacao produto x forma de envio.
	 */
	private Long idProdutoFormaEnvio;
	
	/**
	 * ID_PRODUTO NUMBER(10) N. Identificador do produto.
	 */
	private Long idProduto;
	
	/**
	 * CID_CONTRATO VARCHAR2(6) N. Identificacao Cidade.
	 */
	private String cidContrato;
	
	/**
	 * DT_INI DATE Data de inicio.
	 */
	private Date dtIni;
	
	/**
	 * DT_FIM DATE Data fim.
	 */
	private Date dtFim;
	
	/**
	 * Lista de entidades SnRelProdutoFormaEnvioBean
	 */
	private List<SnRelProdutoFormaEnvioBean> lstSnRelProdutoFormaEnvioBean;
	
	/**
	 * Construtor padrao.
	 */
	public SnRelProdutoEnvioAvisoBean() {
		super(ID_PRODUTO_FORMA_ENVIO);
	}

	
	/**
	 * Recupera o identificador da relacao produto x forma de envio.
	 * 
	 * @return Returns the idProdutoFormaEnvio.
	 *
	 * @hibernate.id 
	 * 		column = "id_produto_forma_envio"
	 * 		generator-class="assigned"
	 * 		unsaved-value="null"
	 */
	public Long getIdProdutoFormaEnvio() {
		return idProdutoFormaEnvio;
	}

	/**
	 * @param idProdutoFormaEnvio The idProdutoFormaEnvio to set.
	 */
	public void setIdProdutoFormaEnvio(Long idProdutoFormaEnvio) {
		this.idProdutoFormaEnvio = idProdutoFormaEnvio;
	}


	/**
	 * Recupera o identificador do produto.
	 * 
	 * @return Returns the idProduto.
	 *
	 * @hibernate.property 
	 * 		column = "id_produto"
	 * 		type="long"
	 */
	public Long getIdProduto() {
		return idProduto;
	}

	/**
	 * @param idPorduto The idPorduto to set.
	 */
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	/**
	 * Recupera o identificador da cidade.
	 * 
	 * @return Returns the cidContrato.
	 *
	 * @hibernate.property 
	 * 		column = "cid_contrato"
	 * 		type="string"
	 */
	public String getCidContrato() {
		return cidContrato;
	}

	/**
	 * @param cidContrato The cidContrato to set.
	 */
	public void setCidContrato(String cidContrato) {
		this.cidContrato = cidContrato;
	}

	 /**
	  * Recupera a data de inicio.
	  * 
     * @return Returns the dtIni.
     * @hibernate.property column = "dt_ini"
     * type = "timestamp"
     */
	public Date getDtIni() {
		return dtIni;
	}

	 /**
     * @param dtIni The dtIni to set.
     * 
     */
	public void setDtIni(Date dtIni) {
		this.dtIni = dtIni;
	}

	/**
	 * Recupera da data fim.
	 * 
     * @return Returns the dtFim.
     * @hibernate.property column = "dt_fim"
     * type = "timestamp"
     */
	public Date getDtFim() {
		return dtFim;
	}

	 /**
     * @param dtFim The dtFim to set.
     * 
     */
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}


	/**
	 * Recupera a lista da entidade lstSnRelProdutoFormaEnvioBean.
	 * 
	 * @return the lstSnRelProdutoFormaEnvioBean
	 * 
	 * @hibernate.bag table="sn_rel_produto_forma_envio" inverse="false"
	 * @hibernate.collection-one-to-many
	 * class="br.com.netservicos.core.bean.sn.SnRelProdutoFormaEnvioBean"
	 * @hibernate.collection-key column="ID_PRODUTO_FORMA_ENVIO"
	 * @return List
     */
	public List<SnRelProdutoFormaEnvioBean> getLstSnRelProdutoFormaEnvioBean() {
		return lstSnRelProdutoFormaEnvioBean;
	}
	
	/**
	 * @param lstSnRelProdutoFormaEnvioBean The lstSnRelProdutoFormaEnvioBean to set.
	 * 
	 */
	public void setLstSnRelProdutoFormaEnvioBean(
			List<SnRelProdutoFormaEnvioBean> lstSnRelProdutoFormaEnvioBean) {
		this.lstSnRelProdutoFormaEnvioBean = lstSnRelProdutoFormaEnvioBean;
	}

}
