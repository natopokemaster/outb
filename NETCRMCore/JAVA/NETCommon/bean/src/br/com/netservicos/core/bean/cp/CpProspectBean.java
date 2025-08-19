/*
 * Created on 21/09/2010
 * Project : NETCommon
 * Copyright © 2010 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */

package br.com.netservicos.core.bean.cp;

import java.util.Date;
import java.util.List;

import br.com.netservicos.core.bean.sn.SnTipoPessoaBean;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela CP_PROSPECT.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "cp_prospect" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class CpProspectBean extends DomainBean {

	private static final long serialVersionUID = 7488200268598335751L;

	private static final String PRIMARY_KEY = "idProspect";

    private Long idProspect;
    private Long cpf;
    private Long cnpj;
    private String nome;
    private String telPrincipal;
    private CpPropostaBean proposta;
    private CpCartaoCreditoBean cartaoCredito;
    private CpCidadeOperadoraBean cidadeOperadora;
    private CpContaCorrenteBean contaCorrente;
    private Integer idMidia;
    private Date dataNascimento;
    private Date dataNascFilho1;
    private Date dataNascFilho2;
    private String dddTelCom;
    private String dddTelFax;
    private String dddTelOutros;
    private String dddTelPrincipal;
    private String dddTelRes;
    private String email;
    private Integer estrangeiro;
    private Integer idEscolaridade;
    private Integer idEstadoCivil;
    private Long idOportunidade;
    private Integer idOrgaoExpedidor;
    private Integer idProfissao;
    private Integer idTipoPessoa;
    private String ie;
    private String internet;
    private String nomeConjuge;
    private String nomeFilho1;
    private String nomeFilho2;
    private String nomeMae;
    private String nomePai;
    private Integer numFilhos;
    private String numPassaporte;
    private Integer numResidentes;
    private Integer numTelevisores;
    private String ramal;
    private String rg;
    private Integer sexo;
    private String telCom;
    private String telFax;
    private String telOutros;
    private String telRes;
    private String timeFutebol;
    private String descricaoOrigem;
    private CpRelConcorrenteProspBean relConcorrenteProspect;
    private String ccTelCel;
    private String codigoSuframa;
    private String flagSuframa;
    private SnTipoPessoaBean tipoPessoa;
    private String areaLocal;
    private List enderecos;
    private List chamados;
    private List atributos;
    
    /**
     * Construtor Padrão.
     */
    public CpProspectBean() {    	
        super(CpProspectBean.PRIMARY_KEY);
        metaData.put("enderecos", CpEnderecoProspectBean.class);
    }
    
    /**
     * @return Returns the 
     * @hibernate.id column="id_prospect" generator-class="sequence"
     * @hibernate.generator-param name="sequence" value="scp_prospect"
     */
    public Long getIdProspect() {
    	
        return this.idProspect;
    }

    /**
     * @return Returns the CpCartaoCreditoBean
     * @hibernate.one-to-one constrained="false" cascade="delete" lazy="proxy"
     */
    public CpCartaoCreditoBean getCartaoCredito() {
        return this.cartaoCredito;
    }

    /**
     * @return Returns the cidadeOperadora.
     * @hibernate.many-to-one column="id_cidade" cascade="none" lazy="proxy"
     */
    public CpCidadeOperadoraBean getCidadeOperadora() {
        return this.cidadeOperadora;
    }

    /**
     * @return Returns the cnpj.
     * @hibernate.property column="cnpj"
     */
    public Long getCnpj() {
        return this.cnpj;
    }

    /**
     * @return Returns the CpContaCorrenteBean
     * @hibernate.one-to-one constrained="false" cascade="delete" lazy="proxy" lazy="proxy"
     */
    public CpContaCorrenteBean getContaCorrente() {
        return this.contaCorrente;
    }

    /**
     * @return Returns the cpf.
     * @hibernate.property column="cpf"
     */
    public Long getCpf() {
        return this.cpf;
    }

    /**
     * @return Returns the dataNascimento.
     * @hibernate.property column="dt_nascimento" type = "date"
     */
    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    /**
     * @return Returns the dataNascimFilho1.
     * @hibernate.property column="dt_nascimento_filho1" type = "date"
     */
    public Date getDataNascFilho1() {
        return this.dataNascFilho1;
    }

    /**
     * @return Returns the dataNascimFilho2.
     * @hibernate.property column="dt_nascimento_filho2" type = "date"
     */
    public Date getDataNascFilho2() {
        return this.dataNascFilho2;
    }

    /**
     * @return Returns the dddTelCom.
     * @hibernate.property column="ddd_com"
     */
    public String getDddTelCom() {
        return this.dddTelCom;
    }

    /**
     * @return Returns the dddTelFax.
     * @hibernate.property column="ddd_fax"
     */
    public String getDddTelFax() {
        return this.dddTelFax;
    }

    /**
     * @return Returns the dddTelOutros.
     * @hibernate.property column="ddd_outros"
     */
    public String getDddTelOutros() {
        return this.dddTelOutros;
    }

    /**
     * @return Returns the dddTelPrincipal.
     * @hibernate.property column="ddd_principal"
     */
    public String getDddTelPrincipal() {
        return this.dddTelPrincipal;
    }

    /**
     * @return Returns the dddTelRes.
     * @hibernate.property column="ddd_res"
     */
    public String getDddTelRes() {
        return this.dddTelRes;
    }

    /**
     * @return Returns the email.
     * @hibernate.property column="email"
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @return Returns the estrangeiro.
     * @hibernate.property column="estrangeiro"
     */
    public Integer getEstrangeiro() {
        return this.estrangeiro;
    }

    /**
     * @return Returns the idEscolaridade.
     * @hibernate.property column="id_escolariedade"
     */
    public Integer getIdEscolaridade() {
        return this.idEscolaridade;
    }

    /**
     * @return Returns the idEstadoCivil.
     * @hibernate.property column="id_estado_civil"
     */
    public Integer getIdEstadoCivil() {
        return this.idEstadoCivil;
    }

    /**
     * @return Returns the idMidia
     * @hibernate.property column="id_midia"
     */
    public Integer getIdMidia() {
        return this.idMidia;
    }

    /**
     * @return Returns the idOportunidade.
     * @hibernate.property column="id_oportunidade"
     */
    public Long getIdOportunidade() {
        return this.idOportunidade;
    }

    /**
     * @return Returns the idOrgaoExpedidor.
     * @hibernate.property column="id_orgao_expedidor"
     */
    public Integer getIdOrgaoExpedidor() {
        return this.idOrgaoExpedidor;
    }

    /**
     * @return Returns the idProfissao.
     * @hibernate.property column="id_profissao"
     */
    public Integer getIdProfissao() {
        return this.idProfissao;
    }

    /**
     * @return Returns the idTipoPessoa.
     * @hibernate.property column="id_tipo_pessoa"
     */
    public Integer getIdTipoPessoa() {
        return this.idTipoPessoa;
    }

    /**
     * @return Returns the ie.
     * @hibernate.property column="ie"
     */
    public String getIe() {
        return this.ie;
    }

    /**
     * @return Returns the internet.
     * @hibernate.property column="internet"
     */
    public String getInternet() {
        return this.internet;
    }

    /**
     * @return Returns the nome.
     * @hibernate.property column="nome"
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * @return Returns the nomeConjuge.
     * @hibernate.property column="nome_conjuge"
     */
    public String getNomeConjuge() {
        return this.nomeConjuge;
    }

    /**
     * @return Returns the nomeFilho1.
     * @hibernate.property column="nome_filho1"
     */
    public String getNomeFilho1() {
        return this.nomeFilho1;
    }

    /**
     * @return Returns the nomeFilho2.
     * @hibernate.property column="nome_filho2"
     */
    public String getNomeFilho2() {
        return this.nomeFilho2;
    }

    /**
     * @return Returns the nomeMae.
     * @hibernate.property column="nome_mae"
     */
    public String getNomeMae() {
        return this.nomeMae;
    }

    /**
     * @return Returns the nomePai.
     * @hibernate.property column="nome_pai"
     */
    public String getNomePai() {
        return this.nomePai;
    }

    /**
     * @return Returns the numFilhos.
     * @hibernate.property column="num_filhos"
     */
    public Integer getNumFilhos() {
        return this.numFilhos;
    }

    /**
     * @return String
     * @hibernate.property column="num_passaporte"
     */
    public String getNumPassaporte() {
        return this.numPassaporte;
    }

    /**
     * @return Returns the numResidentes.
     * @hibernate.property column="num_residentes"
     */
    public Integer getNumResidentes() {
        return this.numResidentes;
    }

    /**
     * @return Returns the numTelevisores.
     * @hibernate.property column="num_televisores"
     */
    public Integer getNumTelevisores() {
        return this.numTelevisores;
    }

    /**
     * @return CpPropostaBean
     * @hibernate.one-to-one property-ref="prospect" lazy="proxy"
     */
    public CpPropostaBean getProposta() {
        return this.proposta;
    }

    /**
     * @return Returns the ramal.
     * @hibernate.property column="ramal"
     */
    public String getRamal() {
        return this.ramal;
    }

    /**
     * @return Returns the rg.
     * @hibernate.property column="rg"
     */
    public String getRg() {
        return this.rg;
    }

    /**
     * @return Returns the sexo.
     * @hibernate.property column="sexo"
     */
    public Integer getSexo() {
        return this.sexo;
    }

    /**
     * @return Returns the telCom.
     * @hibernate.property column="tel_com"
     */
    public String getTelCom() {
        return this.telCom;
    }

    /**
     * @return Returns the telFax.
     * @hibernate.property column="tel_fax"
     */
    public String getTelFax() {
        return this.telFax;
    }

    /**
     * @return Returns the telOutros.
     * @hibernate.property column="tel_outros"
     */
    public String getTelOutros() {
        return this.telOutros;
    }

    /**
     * @return Returns the codigoSuframa.
     * @hibernate.property column="cd_suframa"
     */
    public String getCodigoSuframa() {
        return this.codigoSuframa;
    }

    /**
     * @return Returns the telPrincipal.
     * @hibernate.property column="tel_principal"
     */
    public String getTelPrincipal() {
        return this.telPrincipal;
    }

    /**
     * @return Returns the telRes.
     * @hibernate.property column="tel_res"
     */
    public String getTelRes() {
        return this.telRes;
    }

    /**
     * @return Returns the timeFutebol.
     * @hibernate.property column="time_futebol"
     */
    public String getTimeFutebol() {
        return this.timeFutebol;
    }

    /**
     * @return Returns the SnTipoPessoaBean
     * @hibernate.many-to-one column="id_tipo_pessoa"
     *                        insert="false" update="false"
     */
    public SnTipoPessoaBean getTipoPessoa() {
        return this.tipoPessoa;
    }

    /**
     * @return Returns the descricaoOrigem
     * @hibernate.property formula = "(SELECT A.DESCRICAO FROM CP_ATRIBUTO A WHERE A.ID_ATRIBUTO IN ( SELECT
     *                     B.ID_ATRIBUTO FROM CP_REL_ATRIBUTO_PROSPECT B WHERE B.ID_PROSPECT(+) = ID_PROSPECT
     *                     ) AND
     *                     A.ID_TIPO_ATRIBUTO = 1)"
     */
    public String getDescricaoOrigem() {
        return this.descricaoOrigem;
    }

    /**
     * @return Returns the CpRelConcorrenteProspBean
     * @hibernate.one-to-one property-ref="prospect" cascade="save-update" lazy="false" return
     *                       CpRelConcorrenteProspectBean
     */
    public CpRelConcorrenteProspBean getRelConcorrenteProspect() {
        return this.relConcorrenteProspect;
    }

    /**
     * @return Returns the ccTelCel
     * @hibernate.property column="cc_tel_cel" type="string"
     */
    public String getCcTelCel() {
        return this.ccTelCel;
    }

    /**
     * @return Returns the flagSuframa
     * @hibernate.property formula = "(SELECT PAR.VLR_PARAMETRO_STR FROM SN_PARAMETRO PAR WHERE
     *                     PAR.NOME_PARAMETRO
     *                     = 'CODIGO_SUFRAMA' AND PAR.ID_EMPRESA = (SELECT CIDOP.ID_EMPRESA FROM
     *                     SN_CIDADE_OPERADORA CIDOP WHERE CIDOP.CID_CONTRATO = ID_CIDADE))"
     */
    public String getFlagSuframa() {
        return this.flagSuframa;
    }

	/**
	 * @return the areaLocal
	 */
	public String getAreaLocal() {
		return areaLocal;
	}

	/**
	 * @param areaLocal the areaLocal to set
	 */
	public void setAreaLocal(String areaLocal) {
		this.areaLocal = areaLocal;
	}

	/**
	 * @param idProspect the idProspect to set
	 */
	public void setIdProspect(Long idProspect) {
		this.idProspect = idProspect;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @param telPrincipal the telPrincipal to set
	 */
	public void setTelPrincipal(String telPrincipal) {
		this.telPrincipal = telPrincipal;
	}

	/**
	 * @param proposta the proposta to set
	 */
	public void setProposta(CpPropostaBean proposta) {
		this.proposta = proposta;
	}

	/**
	 * @param cartaoCredito the cartaoCredito to set
	 */
	public void setCartaoCredito(CpCartaoCreditoBean cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	/**
	 * @param cidadeOperadora the cidadeOperadora to set
	 */
	public void setCidadeOperadora(CpCidadeOperadoraBean cidadeOperadora) {
		this.cidadeOperadora = cidadeOperadora;
	}

	/**
	 * @param contaCorrente the contaCorrente to set
	 */
	public void setContaCorrente(CpContaCorrenteBean contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	/**
	 * @param idMidia the idMidia to set
	 */
	public void setIdMidia(Integer idMidia) {
		this.idMidia = idMidia;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @param dataNascFilho1 the dataNascFilho1 to set
	 */
	public void setDataNascFilho1(Date dataNascFilho1) {
		this.dataNascFilho1 = dataNascFilho1;
	}

	/**
	 * @param dataNascFilho2 the dataNascFilho2 to set
	 */
	public void setDataNascFilho2(Date dataNascFilho2) {
		this.dataNascFilho2 = dataNascFilho2;
	}

	/**
	 * @param dddTelCom the dddTelCom to set
	 */
	public void setDddTelCom(String dddTelCom) {
		this.dddTelCom = dddTelCom;
	}

	/**
	 * @param dddTelFax the dddTelFax to set
	 */
	public void setDddTelFax(String dddTelFax) {
		this.dddTelFax = dddTelFax;
	}

	/**
	 * @param dddTelOutros the dddTelOutros to set
	 */
	public void setDddTelOutros(String dddTelOutros) {
		this.dddTelOutros = dddTelOutros;
	}

	/**
	 * @param dddTelPrincipal the dddTelPrincipal to set
	 */
	public void setDddTelPrincipal(String dddTelPrincipal) {
		this.dddTelPrincipal = dddTelPrincipal;
	}

	/**
	 * @param dddTelRes the dddTelRes to set
	 */
	public void setDddTelRes(String dddTelRes) {
		this.dddTelRes = dddTelRes;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param estrangeiro the estrangeiro to set
	 */
	public void setEstrangeiro(Integer estrangeiro) {
		this.estrangeiro = estrangeiro;
	}

	/**
	 * @param idEscolaridade the idEscolaridade to set
	 */
	public void setIdEscolaridade(Integer idEscolaridade) {
		this.idEscolaridade = idEscolaridade;
	}

	/**
	 * @param idEstadoCivil the idEstadoCivil to set
	 */
	public void setIdEstadoCivil(Integer idEstadoCivil) {
		this.idEstadoCivil = idEstadoCivil;
	}

	/**
	 * @param idOportunidade the idOportunidade to set
	 */
	public void setIdOportunidade(Long idOportunidade) {
		this.idOportunidade = idOportunidade;
	}

	/**
	 * @param idOrgaoExpedidor the idOrgaoExpedidor to set
	 */
	public void setIdOrgaoExpedidor(Integer idOrgaoExpedidor) {
		this.idOrgaoExpedidor = idOrgaoExpedidor;
	}

	/**
	 * @param idProfissao the idProfissao to set
	 */
	public void setIdProfissao(Integer idProfissao) {
		this.idProfissao = idProfissao;
	}

	/**
	 * @param idTipoPessoa the idTipoPessoa to set
	 */
	public void setIdTipoPessoa(Integer idTipoPessoa) {
		this.idTipoPessoa = idTipoPessoa;
	}

	/**
	 * @param ie the ie to set
	 */
	public void setIe(String ie) {
		this.ie = ie;
	}

	/**
	 * @param internet the internet to set
	 */
	public void setInternet(String internet) {
		this.internet = internet;
	}

	/**
	 * @param nomeConjuge the nomeConjuge to set
	 */
	public void setNomeConjuge(String nomeConjuge) {
		this.nomeConjuge = nomeConjuge;
	}

	/**
	 * @param nomeFilho1 the nomeFilho1 to set
	 */
	public void setNomeFilho1(String nomeFilho1) {
		this.nomeFilho1 = nomeFilho1;
	}

	/**
	 * @param nomeFilho2 the nomeFilho2 to set
	 */
	public void setNomeFilho2(String nomeFilho2) {
		this.nomeFilho2 = nomeFilho2;
	}

	/**
	 * @param nomeMae the nomeMae to set
	 */
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	/**
	 * @param nomePai the nomePai to set
	 */
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	/**
	 * @param numFilhos the numFilhos to set
	 */
	public void setNumFilhos(Integer numFilhos) {
		this.numFilhos = numFilhos;
	}

	/**
	 * @param numPassaporte the numPassaporte to set
	 */
	public void setNumPassaporte(String numPassaporte) {
		this.numPassaporte = numPassaporte;
	}

	/**
	 * @param numResidentes the numResidentes to set
	 */
	public void setNumResidentes(Integer numResidentes) {
		this.numResidentes = numResidentes;
	}

	/**
	 * @param numTelevisores the numTelevisores to set
	 */
	public void setNumTelevisores(Integer numTelevisores) {
		this.numTelevisores = numTelevisores;
	}

	/**
	 * @param ramal the ramal to set
	 */
	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	/**
	 * @param rg the rg to set
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	/**
	 * @param telCom the telCom to set
	 */
	public void setTelCom(String telCom) {
		this.telCom = telCom;
	}

	/**
	 * @param telFax the telFax to set
	 */
	public void setTelFax(String telFax) {
		this.telFax = telFax;
	}

	/**
	 * @param telOutros the telOutros to set
	 */
	public void setTelOutros(String telOutros) {
		this.telOutros = telOutros;
	}

	/**
	 * @param telRes the telRes to set
	 */
	public void setTelRes(String telRes) {
		this.telRes = telRes;
	}

	/**
	 * @param timeFutebol the timeFutebol to set
	 */
	public void setTimeFutebol(String timeFutebol) {
		this.timeFutebol = timeFutebol;
	}

	/**
	 * @param descricaoOrigem the descricaoOrigem to set
	 */
	public void setDescricaoOrigem(String descricaoOrigem) {
		this.descricaoOrigem = descricaoOrigem;
	}

	/**
	 * @param relConcorrenteProspect the relConcorrenteProspect to set
	 */
	public void setRelConcorrenteProspect(
			CpRelConcorrenteProspBean relConcorrenteProspect) {
		this.relConcorrenteProspect = relConcorrenteProspect;
	}

	/**
	 * @param ccTelCel the ccTelCel to set
	 */
	public void setCcTelCel(String ccTelCel) {
		this.ccTelCel = ccTelCel;
	}

	/**
	 * @param codigoSuframa the codigoSuframa to set
	 */
	public void setCodigoSuframa(String codigoSuframa) {
		this.codigoSuframa = codigoSuframa;
	}

	/**
	 * @param flagSuframa the flagSuframa to set
	 */
	public void setFlagSuframa(String flagSuframa) {
		this.flagSuframa = flagSuframa;
	}

	/**
	 * @param tipoPessoa the tipoPessoa to set
	 */
	public void setTipoPessoa(SnTipoPessoaBean tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	 /**
     * @hibernate.bag
     * 		table="cp_endereco_prospect"
     * 		cascade="delete"
     * 		inverse="true"
     * 		lazy="true"
     *      batch-size="5"
     * @hibernate.collection-one-to-many 
     * 		class="br.com.netservicos.core.bean.cp.CpEnderecoProspectBean"
     * @hibernate.collection-key
     * 		column="id_prospect"
     * @return
     */
    public List getEnderecos() {
        return enderecos;
    }
    
    public void setEnderecos(List enderecos) {
        this.enderecos = enderecos;
    }
    
    /**
     * @hibernate.bag
     *      table="cp_chamado"
     *      cascade="delete"
     *      inverse="true"
     *      lazy="true"
     *      batch-size="5"
     * @hibernate.collection-one-to-many 
     *      class="br.com.netservicos.core.bean.cp.CpChamadoBean"
     * @hibernate.collection-key 
     *      column="id_prospect"
     * 
     * @return
     */
    public List getChamados() {
        return chamados;
    }
    
    public void setChamados(List chamados) {
        this.chamados = chamados;
    }

    /**
     * @hibernate.bag
     *      table="cp_rel_atributo_prospect"
     *      cascade="none"
     *      lazy="true"
     * @hibernate.collection-many-to-many 
     *      class="br.com.netservicos.core.bean.cp.CpAtributoBean"
     *      column="id_atributo"
     * @hibernate.collection-key  
     *      column="id_prospect"
     * 
     * @return
     */
    public List getAtributos() {
        return atributos;
    }
    
    public void setAtributos(List atributos) {
        this.atributos = atributos;
    }
    

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idProspect != null) {
            result = prime * result + this.idProspect.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof CpProspectBean) {
            final CpProspectBean comp = (CpProspectBean) key;
            test = this.getIdProspect().equals(comp.getIdProspect());
        }
        return test;
    }
}
