/*
 * Created on 16/08/2005
 *
 * Copyright © 2005 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.core.bean.cp;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela cp_endereco_prospect.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- -------------------------
 * Criação							14/09/2010 Wellington Maeda
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>  
 * 
 *
 * @hibernate.class table = "cp_endereco_prospect"
 *                  dynamic-insert = "true"
 *                  dynamic-update = "true"
 *                  lazy="false"
 *                  batch-size="10"
 *
 *@hibernate.query name = "lstEnderecoInstalacaoBiderecional"
 *                  query = "select endereco.idEnderecoProspect 
 *                           from br.com.netservicos.core.bean.cp.CpEnderecoProspectBean endereco
 *                           where endereco.prospect.proposta.idProposta = :idProposta and
 *                                 endereco.tipoEndereco.idTipoEndereco = 1 and
 *                                 endereco.bidirecional = 1"                  
 *      
 *                      
 */

public class CpEnderecoProspectBean extends DomainBean {

    private static final long serialVersionUID = -8538386208438464624L;

    public static final String LST_ENDERECO_INSTALACAO_BIDIRECIONAL = "lstEnderecoInstalacaoBiderecional";
    
    private static final String ID_ENDERECO_PROSPECT = "idEnderecoProspect";
    public static final String PROPERTY_ENDERECO = "endereco";
    public static final int TIPO_ENDERECO_INSTALACAO = 1;
    public static final int TIPO_COBRANCA = 2;
    public static final int TIPO_ENDERECO_COBRANCA = 2;

    
    private String bairro;
    private Integer bidirecional;
    private String cep;
    private String cidade;
    private String complemento;
    private String desclogradouro;
    private String endcompleto;
    private String estado;
    private Integer idEdificacao;
    private Long idEnderecoProspect;
    private String numero;
    private CpProspectBean prospect;
    private String tipoEdificacao;
    private CpTipoEnderecoBean tipoEndereco;
    private String referencia;
    private String tipoPostagem;
    private Integer idLogradouroEcn;
    private Integer idBairroEcn;
    private Integer idUnidadeOperacionalEcn;
    // Campos transientes
    private String idCidade;

    public CpEnderecoProspectBean() {
        super(ID_ENDERECO_PROSPECT);
    }
    
    public CpEnderecoProspectBean(Long idEnderecoProspect) {
        this();        
        setIdEnderecoProspect(idEnderecoProspect);
    }

    /**
     * Obtains and returns the new value of the bairro attribute.
     * 
     * @return Returns the bairro.
     * 
     * @hibernate.property
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Obtains and returns the new value of the cep attribute.
     * 
     * @return Returns the cep.
     * 
     * @hibernate.property
     */
    public String getCep() {
        return cep;
    }

    /**
     * Obtains and returns the new value of the cidade attribute.
     * 
     * @return Returns the cidade.
     * 
     * @hibernate.property
     * 		column="ds_cidade"
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Obtains and returns the new value of the complemento attribute.
     * 
     * @return Returns the complemento.
     * 
     * @hibernate.property
     *      column="complementos"
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * 
     * @return String
     * 
     * @hibernate.property
     */
    public String getDesclogradouro() {
        return desclogradouro;
    }

    /**
     * 
     * @return String
     * 
     * @hibernate.property
     */
    public String getEndcompleto() {
        return endcompleto;
    }

    /**
     * Obtains and returns the new value of the estado attribute.
     * 
     * @return Returns the estado.
     * 
     * @hibernate.property
     * 		column="ds_estado"
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Obtains and returns the new value of the idEdificacao attribute.
     * 
     * @return Returns the idEdificacao.
     * 
     * @hibernate.property
     * 		column="id_edificacao"
     */
    public Integer getIdEdificacao() {
        return idEdificacao;
    }

    /**
     * @hibernate.id 
     * 		column="id_endereco_prospect"
     * 		generator-class="sequence"
     * @hibernate.generator-param
     *      name="sequence"
     *      value="scp_endereco_prospect"
     * 
     * @return
     */
    public Long getIdEnderecoProspect() {
        return idEnderecoProspect;
    }

    /**
     * 
     * @return String
     * 
     * @hibernate.property
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @hibernate.many-to-one
     *      column="id_prospect"
     *      insert="true"
     *      update="false"
     *      not-null="true"
     *      lazy="proxy"
     * 
     * @return
     */
    public CpProspectBean getProspect() {
        return prospect;
    }

    /**
     * 
     * @return String
     * 
     * @hibernate.property
     * 		column="tipo_edificacao"
     */
    public String getTipoEdificacao() {
        return tipoEdificacao;
    }

    /**
     * @hibernate.many-to-one 
     * 		cascade="none"
     * 		column="id_tipo_endereco"
     * 		not-null="true"
     * 		lazy="proxy"
     * 
     * @return
     */
    public CpTipoEnderecoBean getTipoEndereco() {
        return tipoEndereco;
    }

    /**
     * 
     * @return String
     * 
     * @hibernate.property
     * 		column="referencia"
     */
    public String getReferencia() {
		return referencia;
	}

    /**
     * 
     * @return String
     * 
     * @hibernate.property 
     * 		column="tp_postagem"
     */
    public String getTipoPostagem() {
		return tipoPostagem;
	}
    
    /**
     * @hibernate.property
     * 		column="bidirecional"
     * 
     * @return
     */
    public Integer getBidirecional() {
        return bidirecional;
    }
    
    /**
     * 
     * @return Integer
     * 
     * @hibernate.property 
     * 		column="id_bairro_ecn"
     */
	public Integer getIdBairroEcn() {
		return idBairroEcn;
	}

	/**
     * 
     * @return Integer
     * 
     * @hibernate.property 
     * 		column="id_logradouro_ecn"
     */
	public Integer getIdLogradouroEcn() {
		return idLogradouroEcn;
	}

	/**
     * 
     * @return Integer
     * 
     * @hibernate.property 
     * 		column="id_unidade_operacional_ecn"
     */
	public Integer getIdUnidadeOperacionalEcn() {
		return idUnidadeOperacionalEcn;
	}
	
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * 
     * @param desclogradouro
     */
    public void setDesclogradouro(String desclogradouro) {
        this.desclogradouro = desclogradouro;
    }

    /**
     * 
     * @param endcompleto
     */
    public void setEndcompleto(String endcompleto) {
        this.endcompleto = endcompleto;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setIdEdificacao(Integer idEdificacao) {
        this.idEdificacao = idEdificacao;
    }

    public void setIdEnderecoProspect(Long idProspect) {
        this.idEnderecoProspect = idProspect;
    }

    /**
     * 
     * @param numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setProspect(CpProspectBean prospect) {
        this.prospect = prospect;
    }

    /**
     * 
     * @param tipoEdificacao
     */
    public void setTipoEdificacao(String tipoEdificacao) {
        this.tipoEdificacao = tipoEdificacao;
    }

    /**
     * 
     * @param tipoEndereco
     */
    public void setTipoEndereco(CpTipoEnderecoBean tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    /**
     * 
     * @param referencia
     */
    public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

    /**
     * 
     * @param tipoPostagem
     */
	public void setTipoPostagem(String tipoPostagem) {
		this.tipoPostagem = tipoPostagem;
	}
	
    public void setBidirecional(Integer bidirecional) {
        this.bidirecional = bidirecional;
    }
    

	public void setIdBairroEcn(Integer idBairroEcn) {
		this.idBairroEcn = idBairroEcn;
	}
	
	public void setIdLogradouroEcn(Integer idLogradouroEcn) {
		this.idLogradouroEcn = idLogradouroEcn;
	}

	public void setIdUnidadeOperacionalEcn(Integer idUnidadeOperacionalEcn) {
		this.idUnidadeOperacionalEcn = idUnidadeOperacionalEcn;
	} 

	/**
     * Metodo utilizado apenas para armazenar em memoria o codigo da cidade selecionada no filtro de 
     * Pesquisar Logradouro, utilizado no Caso de Uso Endereco de Cobranca.
     * 
     * @return idCidade
     */
	public String getIdCidade() {
		return idCidade;
	}

	/**
	 * @param idCidade the idCidade to set
	 * @transient 
	 */
	public void setIdCidade(String idCidade) {
		this.idCidade = idCidade;
	}

	public int hashCode() {
		final int prime = 31;
	    int result = 1;
	    result = prime * result;
	    if (this.idEnderecoProspect!= null) {
	    	result = prime * result + this.idEnderecoProspect.hashCode();
	    }
	    return result;
	}

	public boolean equals(final Object key) {
		boolean test = super.equals(key);
        if (key instanceof CpPropostaBean) { 
            final CpEnderecoProspectBean comp = (CpEnderecoProspectBean) key;
            test = this.getIdEnderecoProspect().equals(comp.getIdEnderecoProspect());
        }
        return test;
    }

}
