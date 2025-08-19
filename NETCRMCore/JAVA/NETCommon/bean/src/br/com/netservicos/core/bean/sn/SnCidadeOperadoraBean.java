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
* $Id: SnCidadeOperadoraBean.java,v 1.7 2011/01/26 12:12:57 T0196500 Exp $
*/
package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>Description :</B><BR>
 * Classe Bean que representa a tabela sn_cidade_operadora
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
 * @version $Revision: 1.7 $
 * 
 * @hibernate.class 
 * 		table="sn_cidade_operadora"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true" 
 *		batch-size="10"
 *		schema="prod_jd"
 *
 *  @hibernate.cache
 *		usage="read-only"
 *
 */
public class SnCidadeOperadoraBean extends DomainBean {

	private static final long serialVersionUID = 7801195029245035582L;
	public static final String CID_CONTRATO = "cidContrato";
	public static final String PROCURA_CID_CONTRATO_POR_COD_OPERADORA = "procuraCidContratoPorCodOperadora";
    public static final String OBTER_COD_OPERADORA_POR_CID_CONTRATO = "obterCodOperadoraPorCidContrato";
	
	private String cidContrato;
	private String ciNome;
	private String ciEstado;
	private String idEmpresa;
	private String razaoSocial;
	private String nomePessoa;
	private String codOperadora;
	private SnTipoTributacaoBean tipoTributacao;
	private String codOpeJde;
	private String codLocalidadeEbt;
	private String codMunicipioIbge;
	
	public SnCidadeOperadoraBean() {
		super(CID_CONTRATO);
	}
	
	public SnCidadeOperadoraBean(String cidContrato) {
		this();
		this.cidContrato = cidContrato;
	}

	/**
	 * @return Returns the cidContrato.
	 *
	 * @hibernate.id 
	 * 		generator-class="assigned"
	 * 		unsaved-value="null"
	 * 		column="cid_contrato"
	 */
	public String getCidContrato() {
		return cidContrato;
	}

	/**
	 * @param cidContrato 
	 *				The cidContrato to set.
	 */
	public void setCidContrato(String cidContrato) {
		this.cidContrato = cidContrato;
	}

	/**
	 * @return Returns the ciNome.
	 *
	 * @hibernate.property
	 * 		column="ci_nome"
	 * 		type="string"
	 */
	public String getCiNome() {
		return ciNome;
	}

	/**
	 * @param ciNome 
	 *				The ciNome to set.
	 */
	public void setCiNome(String ciNome) {
		this.ciNome = ciNome;
	}

	/**
	 * @return Returns the ciEstado.
	 *
	 * @hibernate.property
	 * 		column="ci_estado"
	 * 		type="string"
	 */
	public String getCiEstado() {
		return ciEstado;
	}

	/**
	 * @param ciEstado 
	 *				The ciEstado to set.
	 */
	public void setCiEstado(String ciEstado) {
		this.ciEstado = ciEstado;
	}

	/**
	 * @return Returns the idEmpresa.
	 *
	 * @hibernate.property
	 * 		column="id_empresa"
	 * 		type="string"
	 */
	public String getIdEmpresa() {
		return idEmpresa;
	}

	/**
	 * @param idEmpresa 
	 *				The idEmpresa to set.
	 */
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	/**
	 * @return Returns the razaoSocial.
	 *
	 * @hibernate.property
	 * 		column="razao_social"
	 * 		type="string"
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * @param razaoSocial 
	 *				The razaoSocial to set.
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	/**
	 * @return Returns the nomePessoa.
	 *
	 * @hibernate.property
	 * 		column="nome_pessoa"
	 * 		type="string"
	 */
	public String getNomePessoa() {
		return nomePessoa;
	}

	/**
	 * @param nomePessoa 
	 *				The nomePessoa to set.
	 */
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	/**
	 * @return Returns the codOperadora.
	 *
	 * @hibernate.property
	 * 		column="cod_operadora"
	 * 		type="string"
	 */
	public String getCodOperadora() {
		return codOperadora;
	}

	/**
	 * @param codOperadora 
	 *				The codOperadora to set.
	 */
	public void setCodOperadora(String codOperadora) {
		this.codOperadora = codOperadora;
	}

	/**
	 * @return Returns the tipoTributacao.
	 *
	 * @hibernate.many-to-one  
	 * 		name="tipoTributacao"
	 * 		class="br.com.netservicos.core.bean.sn.SnTipoTributacaoBean"
	 * 		column="id_tipo_tribut"
	 * 		cascade="none"
	 *		lazy="proxy"      
	 */
	public SnTipoTributacaoBean getTipoTributacao() {
		return tipoTributacao;
	}

	/**
	 * @param tipoTributacao 
	 *				The tipoTributacao to set.
	 */
	public void setTipoTributacao(SnTipoTributacaoBean tipoTributacao) {
		this.tipoTributacao = tipoTributacao;
	}

	/**
	 * @return Returns the codOpeJde.
	 *
	 * @hibernate.property
	 * 		column="cod_ope_jde"
	 * 		type="string"
	 */
	public String getCodOpeJde() {
		return codOpeJde;
	}

	/**
	 * @param codOpeJde 
	 *				The codOpeJde to set.
	 */
	public void setCodOpeJde(String codOpeJde) {
		this.codOpeJde = codOpeJde;
	}

	/**
	 * @return Returns the codLocalidadeEbt.
	 *
	 * @hibernate.property
	 * 		column="cod_localidade_ebt"
	 * 		type="string"
	 */
	public String getCodLocalidadeEbt() {
		return codLocalidadeEbt;
	}

	/**
	 * @param codLocalidadeEbt 
	 *				The codLocalidadeEbt to set.
	 */
	public void setCodLocalidadeEbt(String codLocalidadeEbt) {
		this.codLocalidadeEbt = codLocalidadeEbt;
	}

	/**
	 * @return Returns the codMunicipioIbge.
	 *
	 * @hibernate.property
	 * 		column="cd_municipio_ibge"
	 * 		type="string"
	 */
	public String getCodMunicipioIbge() {
		return codMunicipioIbge;
	}

	/**
	 * @param codMunicipioIbge 
	 *				The codMunicipioIbge to set.
	 */
	public void setCodMunicipioIbge(String codMunicipioIbge) {
		this.codMunicipioIbge = codMunicipioIbge;
	}

}
