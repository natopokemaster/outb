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
* $Id: SnEnderExtBean.java,v 1.3 2010/05/14 19:25:13 T5001097 Exp $
*/
package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>Description :</B><BR>
 * Classe Bean que representa a tabela sn_ender_ext
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
 * 		table="sn_ender_ext"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true" 
 *		batch-size="10"
 *
 */
public class SnEnderExtBean extends DomainBean {

	private static final long serialVersionUID = 8054886740938321448L;
	public static final String ID_ENDER = "idEnder";
	
	private Long idEnder;
	private String ender;
	private String num;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private Long cep;
	private Integer apto;
	private String edificio;
	private Integer numOrdem;
	private SnAssinanteBean assinante;
	private Integer enderCobranca;
	private Integer enderRevista;
	private String referencia;
	private Integer enderCobrancaReduzido;

	public SnEnderExtBean() {
		super(ID_ENDER);
	}
	
	public SnEnderExtBean(Long idEnder) {
		this();
		this.idEnder = idEnder;
	}

	/**
	 * @return Returns the idEnder.
	 *
	 * @hibernate.id 
	 *		generator-class="sequence"
	 *		column="id_ender"
	 *		type="long"
	 * 
	 * @hibernate.generator-param
	 * 		name="sequence"
	 * 		value="ssn_id_ender_ext"
	 */
	public Long getIdEnder() {
		return idEnder;
	}

	/**
	 * @param idEnder 
	 *				The idEnder to set.
	 */
	public void setIdEnder(Long idEnder) {
		this.idEnder = idEnder;
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
	 * @return Returns the num.
	 *
	 * @hibernate.property
	 *		column="num"
	 *		type="string"
	 */
	public String getNum() {
		return num;
	}

	/**
	 * @param num 
	 *				The num to set.
	 */
	public void setNum(String num) {
		this.num = num;
	}

	/**
	 * @return Returns the complemento.
	 *
	 * @hibernate.property
	 *		column="complemento"
	 *		type="string"
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento 
	 *				The complemento to set.
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
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
	 * @return Returns the apto.
	 *
	 * @hibernate.property
	 *		column="apto"
	 *		type="integer"
	 */
	public Integer getApto() {
		return apto;
	}

	/**
	 * @param apto 
	 *				The apto to set.
	 */
	public void setApto(Integer apto) {
		this.apto = apto;
	}

	/**
	 * @return Returns the edificio.
	 *
	 * @hibernate.property
	 *		column="edificio"
	 *		type="string"
	 */
	public String getEdificio() {
		return edificio;
	}

	/**
	 * @param edificio 
	 *				The edificio to set.
	 */
	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}

	/**
	 * @return Returns the numOrdem.
	 *
	 * @hibernate.property
	 *		column="num_ordem"
	 *		type="integer"
	 */
	public Integer getNumOrdem() {
		return numOrdem;
	}

	/**
	 * @param numOrdem 
	 *				The numOrdem to set.
	 */
	public void setNumOrdem(Integer numOrdem) {
		this.numOrdem = numOrdem;
	}

	/**
	 * @return Returns the assinante.
	 *
	 * @hibernate.many-to-one
	 * 		name="assinante"
	 * 		class="br.com.netservicos.core.bean.sn.SnAssinanteBean"
	 *		column="id_assinante"
	 * 		cascade="none"
	 *		lazy="proxy"      
	 */
	public SnAssinanteBean getAssinante() {
		return assinante;
	}

	/**
	 * @param assinante 
	 *				The assinante to set.
	 */
	public void setAssinante(SnAssinanteBean assinante) {
		this.assinante = assinante;
	}

	/**
	 * @return Returns the enderCobranca.
	 *
	 * @hibernate.property
	 *		column="ender_cobranca"
	 *		type="integer"
	 */
	public Integer getEnderCobranca() {
		return enderCobranca;
	}

	/**
	 * @param enderCobranca 
	 *				The enderCobranca to set.
	 */
	public void setEnderCobranca(Integer enderCobranca) {
		this.enderCobranca = enderCobranca;
	}

	/**
	 * @return Returns the enderRevista.
	 *
	 * @hibernate.property
	 *		column="ender_revista"
	 *		type="integer"
	 */
	public Integer getEnderRevista() {
		return enderRevista;
	}

	/**
	 * @param enderRevista 
	 *				The enderRevista to set.
	 */
	public void setEnderRevista(Integer enderRevista) {
		this.enderRevista = enderRevista;
	}

	/**
	 * @return Returns the referencia.
	 *
	 * @hibernate.property
	 *		column="referencia"
	 *		type="string"
	 */
	public String getReferencia() {
		return referencia;
	}

	/**
	 * @param referencia 
	 *				The referencia to set.
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	/**
	 * @return Returns the enderCobrancaReduzido.
	 *
	 * @hibernate.property
	 *		column="ender_cobranca_reduzido"
	 *		type="integer"
	 */
	public Integer getEnderCobrancaReduzido() {
		return enderCobrancaReduzido;
	}

	/**
	 * @param enderCobrancaReduzido 
	 *				The enderCobrancaReduzido to set.
	 */
	public void setEnderCobrancaReduzido(Integer enderCobrancaReduzido) {
		this.enderCobrancaReduzido = enderCobrancaReduzido;
	}

}
