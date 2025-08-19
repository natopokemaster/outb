/*
 * Created on 20/09/2010
 * Project : NETCommon
 * Copyright © 2010 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */

package br.com.netservicos.core.bean.rh;

import java.util.Date;
import java.util.Locale;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela RH_PESSOA.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 20/09/2010
 * @version 1.0
 * @hibernate.class table = "rh_pessoa"
 */
public class RhPessoaBean extends DomainBean {

    public static final long serialVersionUID = 5644965742L;

    public static final String PRIMARY_KEY = "idPessoa";

    private String idPessoa;
    private String nomePessoa;
    private String idRamoAtividade;
    private Date dataCadastroPessoa;
    private String email;
    private String telefone;
    private RhTipoPessoaBean tipoPessoa;

    /**
     * Construtor Padrão.
     */
    public RhPessoaBean() {
        super(RhPessoaBean.PRIMARY_KEY);
    }

    public RhPessoaBean(final String idPessoa) {
        this();
        this.idPessoa = idPessoa;
    }

    /**
     * @return Returns the idPessoa
     * @hibernate.id generator-class="assigned" unsaved-value = "null"
     *               column="id_pessoa"
     */
    public String getIdPessoa() {
        return this.idPessoa;
    }

    /**
     * @return Returns the dataCadastroPessoa.
     * @hibernate.property column = "DATA_CADASTRO_PESSOA" type = "date"
     */
    public Date getDataCadastroPessoa() {
        return this.dataCadastroPessoa;
    }

    /**
     * @return Returns the email.
     * @hibernate.property column = "E_MAIL" type = "string"
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @return Returns the idRamoAtividade.
     * @hibernate.property column = "ID_RAMO_ATIVIDADE" type = "string"
     */
    public String getIdRamoAtividade() {
        return this.idRamoAtividade;
    }

    /**
     * @return Returns the nomePessoa.
     * @hibernate.property column = "NOME_PESSOA" type = "string"
     */
    public String getNomePessoa() {
        return this.nomePessoa;
    }

    /**
     * @return Returns the telefone.
     * @hibernate.property column = "TELEFONE" type = "string"
     */
    public String getTelefone() {
        return this.telefone;
    }

    /**
     * @return Returns the RhTipoPessoaBean.
     * @hibernate.many-to-one class =
     *                        "br.com.netservicos.core.bean.rh.RhTipoPessoaBean"
     *                        cascade="delete" column="cod_tipo_pessoa"
     *                        not-null="true"
     */
    public RhTipoPessoaBean getTipoPessoa() {
        return this.tipoPessoa;
    }
    
    /**
	 * @param idPessoa the idPessoa to set
	 */
	public void setIdPessoa(String idPessoa) {
		this.idPessoa = idPessoa;
	}

	/**
	 * @param idRamoAtividade the idRamoAtividade to set
	 */
	public void setIdRamoAtividade(String idRamoAtividade) {
		this.idRamoAtividade = idRamoAtividade;
	}

	/**
	 * @param dataCadastroPessoa the dataCadastroPessoa to set
	 */
	public void setDataCadastroPessoa(Date dataCadastroPessoa) {
		this.dataCadastroPessoa = dataCadastroPessoa;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
    /**
     * @param nomePessoaP
     *        The nomePessoa to set.
     */
    public void setNomePessoa(final String nomePessoaP) {
        this.nomePessoa = nomePessoaP;
        if (nomePessoaP != null) {
            this.nomePessoa = nomePessoaP.toUpperCase(new Locale("pt", "BR")).trim();
        }
    }

	/**
	 * @param tipoPessoa the tipoPessoa to set
	 */
	public void setTipoPessoa(RhTipoPessoaBean tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.idPessoa == null) ? 0 : this.idPessoa.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof RhPessoaBean) {
            final RhPessoaBean comp = (RhPessoaBean) key;
            test = this.getIdPessoa().equals(comp.getIdPessoa());
        }
        return test;
    }
}
