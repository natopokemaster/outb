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
* $Id: SnAssinanteBean.java,v 1.4 2011/01/19 16:25:12 T0196500 Exp $
*/
package br.com.netservicos.core.bean.sn;

import java.util.Date;
import java.util.List;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>Description :</B><BR>
 * Classe Bean que representa a tabela sn_assinante
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
 * 04/01/2010 Guilherme Mello         NetCRM			sql by.IdAssinante
 * ==============================================================================
 * </PRE>
 *
 * @author Luis Henrique Carneiro
 * @since 04/01/2010
 * @version $Revision: 1.4 $
 * 
 * @hibernate.class
 * 		table="sn_assinante"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true" 
 *		batch-size="10"
 *
 * @hibernate.query 
 * 		name = "assinanteByNumContratoCidade"
 * 		query = "SELECT
 * 					a
 * 				FROM 
 * 					br.com.netservicos.core.bean.sn.SnAssinanteBean a,
 * 					br.com.netservicos.core.bean.sn.SnContratoBean c
 * 				WHERE 
 *   				a.idAssinante = c.assinante.idAssinante and
 *   				c.compositeKey.numContrato = :compositeKey.numContrato AND
 *   			    c.compositeKey.cidContrato = :compositeKey.cidContrato"
 *   
 */
public class SnAssinanteBean extends DomainBean {

	private static final long serialVersionUID = 820618364406797045L;
	public static final String ID_ASSINANTE = "idAssinante";
    
	public static final String ASSINANTE_BY_NUMCONTRATO_CIDADE = "assinanteByNumContratoCidade";
	public static final String LST_ASSINANTE_BY_EDIFICACAO = "lstDadosAssinanteByEdificacao";
	
	private Long idAssinante;
	private String nomeTitular;
	private SnEnderBean enderInstalacao;
	private SnEnderBean enderRevista;
	private SnEnderExtBean enderCobranca;
	private String cpf;
	private String numRg;
	private SnOrgaoExpedidorBean orgaoExpedidor;
	private SnProfissaoBean profissao;
	private Date dtNascimento;
	private String telRes;
	private String telCom;
	private String ramal;
	private String fax;
	private SnTipoPessoaBean tipoPessoa;
	private Long indicadoPor;
	private Long qtdBonus;
	private SnSexoBean sexo;
	private SnEstadoCivilBean estadoCivil;
	private Integer spc;
	private String email;
	private String telOutros;
	private Integer estrangeiro;
	private Integer emailDefault;
	private SnEscolaridadeBean escolaridade;
	private String nomeMae;
	private String nomePai;
	private String ccTelCel;
	private String cdSuframa;
	private List<SnEnderecoCobrancaBean> enderecosCobranca;

	public SnAssinanteBean() {
		super(ID_ASSINANTE);
	}
	
	public SnAssinanteBean(Long idAssinante) {
		this();
		this.idAssinante = idAssinante;
	}

	/**
	 * @return Returns the idAssinante.
	 *
	 * @hibernate.id 
	 *		generator-class="sequence"
	 *		unsaved-value="null"
	 *		column="id_assinante"
	 *		type="long"
	 *
	 * @hibernate.generator-param 
	 * 		name="sequence"
	 * 		value="ssn_id_assinante"
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
	 * @return Returns the nomeTitular.
	 *
	 * @hibernate.property
	 *		column="nome_titular"
	 *		type="string"
	 */
	public String getNomeTitular() {
		return nomeTitular;
	}

	/**
	 * @param nomeTitular 
	 *				The nomeTitular to set.
	 */
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	/**
	 * @return Returns the enderInstalacao.
	 *
	 * @hibernate.many-to-one
	 * 		name="enderInstalacao"
	 * 		class="br.com.netservicos.core.bean.sn.SnEnderBean"
	 *		column="id_ender_instalacao"
	 * 		cascade="none"
	 *		lazy="proxy"      
	 */
	public SnEnderBean getEnderInstalacao() {
		return enderInstalacao;
	}

	/**
	 * @param enderInstalacao 
	 *				The enderInstalacao to set.
	 */
	public void setEnderInstalacao(SnEnderBean enderInstalacao) {
		this.enderInstalacao = enderInstalacao;
	}

	/**
	 * @return Returns the enderRevista.
	 *
	 * @hibernate.many-to-one
	 * 		name="enderRevista"
	 * 		class="br.com.netservicos.core.bean.sn.SnEnderBean"
	 *		column="id_ender_revista"
	 * 		cascade="none"
	 *		lazy="proxy"      
	 */
	public SnEnderBean getEnderRevista() {
		return enderRevista;
	}

	/**
	 * @param enderRevista 
	 *				The enderRevista to set.
	 */
	public void setEnderRevista(SnEnderBean enderRevista) {
		this.enderRevista = enderRevista;
	}

	/**
	 * @return Returns the enderCobranca.
	 *
	 * @hibernate.many-to-one
	 * 		name="enderCobranca"
	 * 		class="br.com.netservicos.core.bean.sn.SnEnderExtBean"
	 *		column="id_ender_cobranca"
	 * 		cascade="none"
	 *		lazy="proxy"      
	 */
	public SnEnderExtBean getEnderCobranca() {
		return enderCobranca;
	}

	/**
	 * @param enderCobranca 
	 *				The enderCobranca to set.
	 */
	public void setEnderCobranca(SnEnderExtBean enderCobranca) {
		this.enderCobranca = enderCobranca;
	}

	/**
	 * @return Returns the cpf.
	 *
	 * @hibernate.property
	 *		column="cpf"
	 *		type="string"
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf 
	 *				The cpf to set.
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return Returns the numRg.
	 *
	 * @hibernate.property
	 *		column="num_rg"
	 *		type="string"
	 */
	public String getNumRg() {
		return numRg;
	}

	/**
	 * @param numRg 
	 *				The numRg to set.
	 */
	public void setNumRg(String numRg) {
		this.numRg = numRg;
	}

	/**
	 * @return Returns the orgaoExpedidor.
	 *
	 * @hibernate.many-to-one
	 * 		name="orgaoExpedidor"
	 * 		class="br.com.netservicos.core.bean.sn.SnOrgaoExpedidorBean"
	 *		column="id_orgao_expedidor"
	 * 		cascade="none"
	 *		lazy="proxy"      
	 */
	public SnOrgaoExpedidorBean getOrgaoExpedidor() {
		return orgaoExpedidor;
	}

	/**
	 * @param orgaoExpedidor 
	 *				The orgaoExpedidor to set.
	 */
	public void setOrgaoExpedidor(SnOrgaoExpedidorBean orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}

	/**
	 * @return Returns the profissao.
	 *
	 * @hibernate.many-to-one
	 * 		name="profissao"
	 * 		class="br.com.netservicos.core.bean.sn.SnProfissaoBean"
	 *		column="id_profissao"
	 * 		cascade="none"
	 *		lazy="proxy"      
	 */
	public SnProfissaoBean getProfissao() {
		return profissao;
	}

	/**
	 * @param profissao 
	 *				The profissao to set.
	 */
	public void setProfissao(SnProfissaoBean profissao) {
		this.profissao = profissao;
	}

	/**
	 * @return Returns the dtNascimento.
	 *
	 * @hibernate.property
	 *		column="dt_nascimento"
	 */
	public Date getDtNascimento() {
		return dtNascimento;
	}

	/**
	 * @param dtNascimento 
	 *				The dtNascimento to set.
	 */
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	/**
	 * @return Returns the telRes.
	 *
	 * @hibernate.property
	 *		column="tel_res"
	 *		type="string"
	 */
	public String getTelRes() {
		return telRes;
	}

	/**
	 * @param telRes 
	 *				The telRes to set.
	 */
	public void setTelRes(String telRes) {
		this.telRes = telRes;
	}

	/**
	 * @return Returns the telCom.
	 *
	 * @hibernate.property
	 *		column="tel_com"
	 *		type="string"
	 */
	public String getTelCom() {
		return telCom;
	}

	/**
	 * @param telCom 
	 *				The telCom to set.
	 */
	public void setTelCom(String telCom) {
		this.telCom = telCom;
	}

	/**
	 * @return Returns the ramal.
	 *
	 * @hibernate.property
	 *		column="ramal"
	 *		type="string"
	 */
	public String getRamal() {
		return ramal;
	}

	/**
	 * @param ramal 
	 *				The ramal to set.
	 */
	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	/**
	 * @return Returns the fax.
	 *
	 * @hibernate.property
	 *		column="fax"
	 *		type="string"
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @param fax 
	 *				The fax to set.
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @return Returns the tipoPessoa.
	 *
	 * @hibernate.many-to-one
	 * 		name="tipoPessoa"
	 * 		class="br.com.netservicos.core.bean.sn.SnTipoPessoaBean"
	 *		column="id_tipo_pessoa"
	 * 		cascade="none"
	 *		lazy="proxy"      
	 */
	public SnTipoPessoaBean getTipoPessoa() {
		return tipoPessoa;
	}

	/**
	 * @param tipoPessoa 
	 *				The tipoPessoa to set.
	 */
	public void setTipoPessoa(SnTipoPessoaBean tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	/**
	 * @return Returns the indicadoPor.
	 *
	 * @hibernate.property
	 *		column="indicado_por"
	 *		type="long"
	 */
	public Long getIndicadoPor() {
		return indicadoPor;
	}

	/**
	 * @param indicadoPor 
	 *				The indicadoPor to set.
	 */
	public void setIndicadoPor(Long indicadoPor) {
		this.indicadoPor = indicadoPor;
	}

	/**
	 * @return Returns the qtdBonus.
	 *
	 * @hibernate.property
	 *		column="qtd_bonus"
	 *		type="long"
	 */
	public Long getQtdBonus() {
		return qtdBonus;
	}

	/**
	 * @param qtdBonus 
	 *				The qtdBonus to set.
	 */
	public void setQtdBonus(Long qtdBonus) {
		this.qtdBonus = qtdBonus;
	}

	/**
	 * @return Returns the sexo.
	 *
	 * @hibernate.many-to-one
	 * 		name="sexo"
	 * 		class="br.com.netservicos.core.bean.sn.SnSexoBean"
	 *		column="id_sexo"
	 * 		cascade="none"
	 *		lazy="proxy"      
	 */
	public SnSexoBean getSexo() {
		return sexo;
	}

	/**
	 * @param sexo 
	 *				The sexo to set.
	 */
	public void setSexo(SnSexoBean sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return Returns the estadoCivil.
	 *
	 * @hibernate.many-to-one
	 * 		name="estadoCivil"
	 * 		class="br.com.netservicos.core.bean.sn.SnEstadoCivilBean"
	 *		column="id_estado_civil"
	 * 		cascade="none"
	 *		lazy="proxy"      
	 */
	public SnEstadoCivilBean getEstadoCivil() {
		return estadoCivil;
	}

	/**
	 * @param estadoCivil 
	 *				The estadoCivil to set.
	 */
	public void setEstadoCivil(SnEstadoCivilBean estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	/**
	 * @return Returns the spc.
	 *
	 * @hibernate.property
	 *		column="spc"
	 *		type="int"
	 */
	public Integer getSpc() {
		return spc;
	}

	/**
	 * @param spc 
	 *				The spc to set.
	 */
	public void setSpc(Integer spc) {
		this.spc = spc;
	}

	/**
	 * @return Returns the email.
	 *
	 * @hibernate.property
	 *		column="e_mail"
	 *		type="string"
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email 
	 *				The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return Returns the telOutros.
	 *
	 * @hibernate.property
	 *		column="tel_outros"
	 *		type="string"
	 */
	public String getTelOutros() {
		return telOutros;
	}

	/**
	 * @param telOutros 
	 *				The telOutros to set.
	 */
	public void setTelOutros(String telOutros) {
		this.telOutros = telOutros;
	}

	/**
	 * @return Returns the estrangeiro.
	 *
	 * @hibernate.property
	 *		column="estrangeiro"
	 *		type="int"
	 */
	public Integer getEstrangeiro() {
		return estrangeiro;
	}

	/**
	 * @param estrangeiro 
	 *				The estrangeiro to set.
	 */
	public void setEstrangeiro(Integer estrangeiro) {
		this.estrangeiro = estrangeiro;
	}

	/**
	 * @return Returns the emailDefault.
	 *
	 * @hibernate.property
	 *		column="e_mail_default"
	 *		type="int"
	 */
	public Integer getEmailDefault() {
		return emailDefault;
	}

	/**
	 * @param emailDefault 
	 *				The emailDefault to set.
	 */
	public void setEmailDefault(Integer emailDefault) {
		this.emailDefault = emailDefault;
	}

	/**
	 * @return Returns the escolaridade.
	 *
	 * @hibernate.many-to-one
	 * 		name="escolaridade"
	 * 		class="br.com.netservicos.core.bean.sn.SnEscolaridadeBean"
	 *		column="id_escolaridade"
	 * 		cascade="none"
	 *		lazy="proxy"      
	 */
	public SnEscolaridadeBean getEscolaridade() {
		return escolaridade;
	}

	/**
	 * @param escolaridade 
	 *				The escolaridade to set.
	 */
	public void setEscolaridade(SnEscolaridadeBean escolaridade) {
		this.escolaridade = escolaridade;
	}

	/**
	 * @return Returns the nomeMae.
	 *
	 * @hibernate.property
	 *		column="nome_mae"
	 *		type="string"
	 */
	public String getNomeMae() {
		return nomeMae;
	}

	/**
	 * @param nomeMae 
	 *				The nomeMae to set.
	 */
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	/**
	 * @return Returns the nomePai.
	 *
	 * @hibernate.property
	 *		column="nome_pai"
	 *		type="string"
	 */
	public String getNomePai() {
		return nomePai;
	}

	/**
	 * @param nomePai 
	 *				The nomePai to set.
	 */
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	/**
	 * @return Returns the ccTelCel.
	 *
	 * @hibernate.property
	 *		column="cc_tel_cel"
	 *		type="string"
	 */
	public String getCcTelCel() {
		return ccTelCel;
	}

	/**
	 * @param ccTelCel 
	 *				The ccTelCel to set.
	 */
	public void setCcTelCel(String ccTelCel) {
		this.ccTelCel = ccTelCel;
	}

	/**
	 * @return Returns the cdSuframa.
	 *
	 * @hibernate.property
	 *		column="cd_suframa"
	 *		type="string"
	 */
	public String getCdSuframa() {
		return cdSuframa;
	}

	/**
	 * @param cdSuframa 
	 *				The cdSuframa to set.
	 */
	public void setCdSuframa(String cdSuframa) {
		this.cdSuframa = cdSuframa;
	}

	/**
	 * @return Returns the enderecosCobranca.
	 *
	 * @hibernate.bag
     *		table="sn_endereco_cobranca"
     *      cascade="none"
     *      lazy="true"
     *      batch-size="5"
     *      insert="false"
     *		update="false"
     *
     * @hibernate.collection-one-to-many 
     *		class="br.com.netservicos.core.bean.sn.SnEnderecoCobrancaBean"
     *
     * @hibernate.collection-key
     *		column="id_assinante"
	 */
	public List<SnEnderecoCobrancaBean> getEnderecosCobranca() {
		return enderecosCobranca;
	}

	/**
	 * @param enderecosCobranca 
	 *				The enderecosCobranca to set.
	 */
	public void setEnderecosCobranca(List<SnEnderecoCobrancaBean> enderecosCobranca) {
		this.enderecosCobranca = enderecosCobranca;
	}

}
