/**
* Created on 04/01/2010
* Project : NETCommon
*
* Copyright © 2007 NET.
* Brasil
* All rights reserved.
*
* This software is the confidential and proprietary information of NET.
* You shall not disclose such Confidential Information and shall use it only in
* accordance with the terms of the license agreement you entered into
* with Net Serviços.
*
* $Id: SnEnderecoCobrancaBean.java,v 1.3 2010/05/14 19:25:13 T5001097 Exp $
*/
package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>Description :</B><BR>
 * Classe Bean que representa a tabela sn_endereco_cobranca
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
 * 04/01/2010 Luis Carneiro  N/A      NetCRM            Criação
 * ==============================================================================
 * </PRE>
 *
 * @author Luis Henrique Carneiro
 * @since 04/01/2010
 * @version $Revision: 1.3 $
 * 
 * @hibernate.class 
 *		table="sn_endereco_cobranca"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true" 
 *		batch-size="10"
 *
 */
public class SnEnderecoCobrancaBean extends DomainBean {

	private static final long serialVersionUID = 8095102220942877673L;
	public static final String ID_ASSINANTE = "idAssinante";
	
	private Long idAssinante;
	private String ender;
	private String bairro;
	private Long cep;
	private String celula;
	private String cidade;
	private String estado;
	private Integer enderInstalacao;
	
	public SnEnderecoCobrancaBean() {
		super(ID_ASSINANTE);
	}
	
	public SnEnderecoCobrancaBean(Long idAssinante) {
		this();
		this.idAssinante = idAssinante;
	}

	/**
	 * @return Returns the idAssinante.
	 *
	 * @hibernate.id 
	 *		generator-class="assigned"
	 *		unsaved-value="null"
	 *		column="id_assinante"
	 *		type="long"
	 */
	public Long getIdAssinante() {
		return idAssinante;
	}

	/**
	 * @param idAssinante 
	 *				The idAssinante to set.
	 */
	public void setIdAssinante(Long idAssinante) {
		this.idAssinante = idAssinante;
	}

	/**
	 * @return Returns the ender.
	 *
	 * @hibernate.property
	 *		column="ender"
	 *		type="string"
	 */
	public String getEnder() {
		return ender;
	}

	/**
	 * @param ender 
	 *				The ender to set.
	 */
	public void setEnder(String ender) {
		this.ender = ender;
	}

	/**
	 * @return Returns the bairro.
	 *
	 * @hibernate.property
	 *		column="bairro"
	 *		type="string"
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro 
	 *				The bairro to set.
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return Returns the cep.
	 *
	 * @hibernate.property
	 *		column="cep"
	 *		type="long"
	 */
	public Long getCep() {
		return cep;
	}

	/**
	 * @param cep 
	 *				The cep to set.
	 */
	public void setCep(Long cep) {
		this.cep = cep;
	}

	/**
	 * @return Returns the celula.
	 *
	 * @hibernate.property
	 *		column="celula"
	 *		type="string"
	 */
	public String getCelula() {
		return celula;
	}

	/**
	 * @param celula 
	 *				The celula to set.
	 */
	public void setCelula(String celula) {
		this.celula = celula;
	}

	/**
	 * @return Returns the cidade.
	 *
	 * @hibernate.property
	 *		column="cidade"
	 *		type="string"
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade 
	 *				The cidade to set.
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return Returns the estado.
	 *
	 * @hibernate.property
	 *		column="estado"
	 *		type="string"
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado 
	 *				The estado to set.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return Returns the enderInstalacao.
	 *
	 * @hibernate.property
	 *		column="ender_instalacao"
	 *		type="integer"
	 */
	public Integer getEnderInstalacao() {
		return enderInstalacao;
	}

	/**
	 * @param enderInstalacao 
	 *				The enderInstalacao to set.
	 */
	public void setEnderInstalacao(Integer enderInstalacao) {
		this.enderInstalacao = enderInstalacao;
	}

}
