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

import br.com.netservicos.core.bean.rh.RhPessoaBean;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela CP_VENDEDOR.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "cp_vendedor" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class CpVendedorBean extends DomainBean {

	private static final long serialVersionUID = 3668220317301248495L;

	private static final String PRIMARY_KEY = "idVendedor";

	private Long idVendedor;
	private RhPessoaBean pessoa;
	private Long idEquipeVenda;
	private String cpf;
	private Date dtAdmissao;
	private Date dtDesligamento;
	private String numMatricula;
	private String area;
	private String centroCusto;
	private String gestorDireto;
	private String endereco;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	private String telResidencial;
	private String telCelular;
	private String email;
	private Date dtNascimento;
	private Date criadoEm;
	private String criadoPor;
	private Date alteradoEm;
	private String alteradoPor;
	private String cargo;
	private String departamento;

    /**
     * Construtor Default.
     */
    public CpVendedorBean() {
        super(CpVendedorBean.PRIMARY_KEY);
    }

    /**
     * @return Returns the idVendedor
     * @hibernate.id generator-class="sequence" unsaved-value = "null"
     *               column="id_vendedor" type = "long"
     * @hibernate.generator-param name = "sequence" value = "scp_vendedor"
     */
    public Long getIdVendedor() {
        return this.idVendedor;
    }

    /**
     * @return Returns the RhPessoaBean
     * @hibernate.many-to-one
     *                        class="br.com.netservicos.core.bean.rh.RhPessoaBean"
     *                        column="id_pessoa" lazy="proxy"
     */
    public RhPessoaBean getPessoa() {
        return this.pessoa;
    }
    
    /**
     * @return Returns the idEquipeVenda
     * @hibernate.id generator-class="sequence" unsaved-value = "null"
     *               column="id_equipe_venda" type = "long"
     */
    public Long getIdEquipeVenda() {
        return this.idEquipeVenda;
    }

    /**
     * @return Returns the alteradoEm
     * @hibernate.property column="alterado_em"
     */
    public Date getAlteradoEm() {
        return this.alteradoEm;
    }

    /**
     * @return Returns the alteradoPor
     * @hibernate.property column="alterado_por"
     */
    public String getAlteradoPor() {
        return this.alteradoPor;
    }

    /**
     * @return Returns the area
     * @hibernate.property column="area"
     */
    public String getArea() {
        return this.area;
    }

    /**
     * @return Returns the bairro
     * @hibernate.property column="bairro"
     */
    public String getBairro() {
        return this.bairro;
    }

    /**
     * @return Returns the centroCusto
     * @hibernate.property column="centro_custo"
     */
    public String getCentroCusto() {
        return this.centroCusto;
    }

    /**
     * @return Returns the cep
     * @hibernate.property column="cep"
     */
    public String getCep() {
        return this.cep;
    }

    /**
     * @return Returns the cidade
     * @hibernate.property column="cidade"
     */
    public String getCidade() {
        return this.cidade;
    }

    /**
     * @return Returns the criadoEm
     * @hibernate.property column="criado_em"
     */
    public Date getCriadoEm() {
        return this.criadoEm;
    }

    /**
     * @return Returns the criadoPor
     * @hibernate.property column="criado_por"
     */
    public String getCriadoPor() {
        return this.criadoPor;
    }

    /**
     * @return Returns the dtAdmissao
     * @hibernate.property column="dt_admissao"
     */
    public Date getDtAdmissao() {
        return this.dtAdmissao;
    }

    /**
     * @return Returns the dtDesligamento
     * @hibernate.property column="dt_desligamento"
     */
    public Date getDtDesligamento() {
        return this.dtDesligamento;
    }

    /**
     * @return Returns the dtNascimento
     * @hibernate.property column="dt_nascimento"
     */
    public Date getDtNascimento() {
        return this.dtNascimento;
    }

    /**
     * @return Returns the email
     * @hibernate.property column="email"
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @return Returns the endereco
     * @hibernate.property column="endereco"
     */
    public String getEndereco() {
        return this.endereco;
    }

    /**
     * @return Returns the estado
     * @hibernate.property column="estado"
     */
    public String getEstado() {
        return this.estado;
    }

    /**
     * @return Returns the gestorDireto
     * @hibernate.property column="gestor_direto"
     */
    public String getGestorDireto() {
        return this.gestorDireto;
    }

    /**
     * @return Returns the numMatricula
     * @hibernate.property column="num_matricula"
     */
    public String getNumMatricula() {
        return this.numMatricula;
    }

    /**
     * @return Returns the telCelular
     * @hibernate.property column="tel_celular"
     */
    public String getTelCelular() {
        return this.telCelular;
    }

    /**
     * @return Returns the telResidencial
     * @hibernate.property column="tel_residencial"
     */
    public String getTelResidencial() {
        return this.telResidencial;
    }

    /**
     * @return Returns the cpf
     * @hibernate.property column="cpf"
     */
    public String getCpf() {
        return this.cpf;
    }

    /**
     * @return Returns the departamento
     * @hibernate.property column="departamento"
     */
    public String getDepartamento() {
        return this.departamento;
    }

    /**
     * @return Returns the cargo
     * @hibernate.property column="cargo"
     */
    public String getCargo() {
        return this.cargo;
    }
    
    /**
	 * @param idVendedor the idVendedor to set
	 */
	public void setIdVendedor(Long idVendedor) {
		this.idVendedor = idVendedor;
	}

	/**
	 * @param pessoa the pessoa to set
	 */
	public void setPessoa(RhPessoaBean pessoa) {
		this.pessoa = pessoa;
	}

	/**
	 * @param idEquipeVenda the idEquipeVenda to set
	 */
	public void setIdEquipeVenda(Long idEquipeVenda) {
		this.idEquipeVenda = idEquipeVenda;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @param dtAdmissao the dtAdmissao to set
	 */
	public void setDtAdmissao(Date dtAdmissao) {
		this.dtAdmissao = dtAdmissao;
	}

	/**
	 * @param dtDesligamento the dtDesligamento to set
	 */
	public void setDtDesligamento(Date dtDesligamento) {
		this.dtDesligamento = dtDesligamento;
	}

	/**
	 * @param numMatricula the numMatricula to set
	 */
	public void setNumMatricula(String numMatricula) {
		this.numMatricula = numMatricula;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @param centroCusto the centroCusto to set
	 */
	public void setCentroCusto(String centroCusto) {
		this.centroCusto = centroCusto;
	}

	/**
	 * @param gestorDireto the gestorDireto to set
	 */
	public void setGestorDireto(String gestorDireto) {
		this.gestorDireto = gestorDireto;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @param telResidencial the telResidencial to set
	 */
	public void setTelResidencial(String telResidencial) {
		this.telResidencial = telResidencial;
	}

	/**
	 * @param telCelular the telCelular to set
	 */
	public void setTelCelular(String telCelular) {
		this.telCelular = telCelular;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param dtNascimento the dtNascimento to set
	 */
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	/**
	 * @param criadoEm the criadoEm to set
	 */
	public void setCriadoEm(Date criadoEm) {
		this.criadoEm = criadoEm;
	}

	/**
	 * @param criadoPor the criadoPor to set
	 */
	public void setCriadoPor(String criadoPor) {
		this.criadoPor = criadoPor;
	}

	/**
	 * @param alteradoEm the alteradoEm to set
	 */
	public void setAlteradoEm(Date alteradoEm) {
		this.alteradoEm = alteradoEm;
	}

	/**
	 * @param alteradoPor the alteradoPor to set
	 */
	public void setAlteradoPor(String alteradoPor) {
		this.alteradoPor = alteradoPor;
	}

	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idVendedor != null) {
            result = prime * result + this.idVendedor.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof CpVendedorBean) {
            final CpVendedorBean comp = (CpVendedorBean) key;
            test = this.getIdVendedor().equals(comp.getIdVendedor());
        }
        return test;
    }
}
