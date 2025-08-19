/*
 * Created on 13/10/2010
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

import br.com.netservicos.core.bean.sn.SnPlanoPgtoBean;
import br.com.netservicos.core.bean.sn.SnPromocaoBean;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela CP_REL_PONTO_EXTENSAO.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 13/10/2010
 * @version 1.0
 * @hibernate.class table = "cp_rel_ponto_extensao" 
 * 					dynamic-insert="true" dynamic-update="true"
 *                  batch-size="10"
 */
public class CpRelPontoExtensaoBean extends DomainBean {

    private static final long serialVersionUID = 6533148456083248352L;

    private static final String PRIMARY_KEY = "idPontoExtensao";

    private Long idPontoExtensao;
    private CpPontoBean ponto;
    private SnPromocaoBean promocao;
    private SnPlanoPgtoBean planoPagamento;
    private Date dtIni;
    private Date dtFim;
    private Integer instalado;
    private String telContato;
    private String nomeContato;
    private String observacao;

    /**
     * Construtor padrão
     */
    public CpRelPontoExtensaoBean() {
        super(CpRelPontoExtensaoBean.PRIMARY_KEY);
    }

    /**
     * @return Returns the idProdutoAgregado.
     * @hibernate.id column="id_ponto_extensao" generator-class="sequence"
     * @hibernate.generator-param name="sequence" value="SQ_REL_PONTO_EXTENSAO"
     */
    public Long getIdPontoExtensao() {
        return this.idPontoExtensao;
    }

    /**
     * @hibernate.many-to-one column="id_ponto" not-null="true" lazy="false"
     * @return CpPontoBean
     */
    public CpPontoBean getPonto() {
        return this.ponto;
    }

    /**
     * @return Returns the id_promocao.
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.sn.SnPromocaoBean" column = "id_promocao"
     *                        insert="true" update="true" lazy="false"
     */
    public SnPromocaoBean getPromocao() {
        return this.promocao;
    }

    /**
     * @return Returns the id_plano_pgto.
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.sn.SnPlanoPgtoBean" column = "id_plano_pgto"
     *                        insert="true" update="true" lazy="false"
     */
    public SnPlanoPgtoBean getPlanoPagamento() {
        return this.planoPagamento;
    }

    /**
     * @hibernate.property column="DT_INI"
     * @return Date
     */
    public Date getDtIni() {
        return this.dtIni;
    }

    /**
     * @hibernate.property column="DT_FIM"
     * @return Date
     */
    public Date getDtFim() {
        return this.dtFim;
    }

    /**
     * @hibernate.property column="INSTALADO"
     * @return Integer
     */
    public Integer getInstalado() {
        return this.instalado;
    }

    /**
     * @hibernate.property column="TEL_CONTATO"
     * @return String
     */
    public String getTelContato() {
        return this.telContato;
    }

    /**
     * @hibernate.property column="NM_CONTATO"
     * @return String
     */
    public String getNomeContato() {
        return this.nomeContato;
    }

    /**
     * @hibernate.property column="DS_OBS"
     * @return String
     */
    public String getObservacao() {
        return this.observacao;
    }
    
    /**
	 * @param idPontoExtensao the idPontoExtensao to set
	 */
	public void setIdPontoExtensao(Long idPontoExtensao) {
		this.idPontoExtensao = idPontoExtensao;
	}

	/**
	 * @param ponto the ponto to set
	 */
	public void setPonto(CpPontoBean ponto) {
		this.ponto = ponto;
	}

	/**
	 * @param promocao the promocao to set
	 */
	public void setPromocao(SnPromocaoBean promocao) {
		this.promocao = promocao;
	}

	/**
	 * @param planoPagamento the planoPagamento to set
	 */
	public void setPlanoPagamento(SnPlanoPgtoBean planoPagamento) {
		this.planoPagamento = planoPagamento;
	}

	/**
	 * @param dtIni the dtIni to set
	 */
	public void setDtIni(Date dtIni) {
		this.dtIni = dtIni;
	}

	/**
	 * @param dtFim the dtFim to set
	 */
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	/**
	 * @param instalado the instalado to set
	 */
	public void setInstalado(Integer instalado) {
		this.instalado = instalado;
	}

	/**
	 * @param telContato the telContato to set
	 */
	public void setTelContato(String telContato) {
		this.telContato = telContato;
	}

	/**
	 * @param nomeContato the nomeContato to set
	 */
	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idPontoExtensao != null) {
            result = prime * result + this.idPontoExtensao.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof CpRelPontoExtensaoBean) {
            final CpRelPontoExtensaoBean comp = (CpRelPontoExtensaoBean) key;
            test = this.getIdPontoExtensao().equals(comp.getIdPontoExtensao());
        }
        return test;
    }
}