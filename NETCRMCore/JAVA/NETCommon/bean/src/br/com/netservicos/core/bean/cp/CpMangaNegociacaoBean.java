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

import br.com.netservicos.core.bean.sn.SnCidadeOperadoraBean;
import br.com.netservicos.core.bean.sn.SnProdutoBean;
import br.com.netservicos.core.bean.sn.SnPromocaoBean;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela CP_MANGA_NEGOCIACAO.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "cp_manga_negociacao" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class CpMangaNegociacaoBean extends DomainBean {

	private static final long serialVersionUID = -3788328900863671184L;

    private static final String PRIMARY_KEY = "idMangaNegociacao";

    private Long idMangaNegociacao;
    private String dsMangaNegociacao;
    private Date dtIni;
    private Date dtFim;
    private Long qtTotalUtilizacao;
    private Long idStatusManga;
    private Integer fnGeraPendencia;
    private Integer qtUtilizada;
    private SnProdutoBean produto;
    private SnPromocaoBean promocao;
    private SnCidadeOperadoraBean cidade;
    private CpAtributoBean idTipoManga;

    /**
     * Construtor Padrão.
     */
    public CpMangaNegociacaoBean() {
        super(CpMangaNegociacaoBean.PRIMARY_KEY);
    }

    /**
     * @return Returns the SnCidadeOperadoraBean
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.sn.SnCidadeOperadoraBean"
     *                        column="cid_contrato"
     */
    public SnCidadeOperadoraBean getCidade() {
        return this.cidade;
    }

    /**
     * @return Returns the dsMangaNegociacao
     * @hibernate.property column="ds_manga_negociacao"
     */
    public String getDsMangaNegociacao() {
        return this.dsMangaNegociacao;
    }

    /**
     * @return Returns the dtFim
     * @hibernate.property column="dt_fim"
     */
    public Date getDtFim() {
        return this.dtFim;
    }

    /**
     * @return Returns the dtIni
     * @hibernate.property column="dt_ini"
     */
    public Date getDtIni() {
        return this.dtIni;
    }

    /**
     * @return Returns the fnGeraPendencia
     * @hibernate.property column="fn_gera_pendencia"
     */
    public Integer getFnGeraPendencia() {
        return this.fnGeraPendencia;
    }

    /**
     * @return Returns the idAtividade.
     * @hibernate.id column="id_manga_negociacao"
     *               generator-class="sequence"
     * @hibernate.generator-param name="sequence" value=""
     */
    public Long getIdMangaNegociacao() {
        return this.idMangaNegociacao;
    }

    /**
     * @return Returns the SnProdutoBean
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.sn.SnProdutoBean"
     *                        column="id_produto"
     */
    public SnProdutoBean getProduto() {
        return this.produto;
    }

    /**
     * @return Returns the SnPromocaoBean
     * @hibernate.many-to-one column="id_promocao"
     */
    public SnPromocaoBean getPromocao() {
        return this.promocao;
    }

    /**
     * @return Returns the qtUtilizada
     * @hibernate.property column="qt_utilizada"
     */
    public Integer getQtUtilizada() {
        return this.qtUtilizada;
    }

    /**
     * @return Returns the idStatusManga
     * @hibernate.property column="id_status_manga"
     */
    public Long getIdStatusManga() {
        return this.idStatusManga;
    }

    /**
     * @return Returns the CpAtributoBean
     * @hibernate.many-to-one column="id_tipo_manga"
     */
    public CpAtributoBean getIdTipoManga() {
        return this.idTipoManga;
    }

    /**
     * @return Returns the qttotalUtilizacao.
     * @hibernate.property column="qt_total_utilizacao"
     */
    public Long getQtTotalUtilizacao() {
        return this.qtTotalUtilizacao;
    }

	/**
	 * @param idMangaNegociacao the idMangaNegociacao to set
	 */
	public void setIdMangaNegociacao(Long idMangaNegociacao) {
		this.idMangaNegociacao = idMangaNegociacao;
	}

	/**
	 * @param dsMangaNegociacao the dsMangaNegociacao to set
	 */
	public void setDsMangaNegociacao(String dsMangaNegociacao) {
		this.dsMangaNegociacao = dsMangaNegociacao;
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
	 * @param qtTotalUtilizacao the qtTotalUtilizacao to set
	 */
	public void setQtTotalUtilizacao(Long qtTotalUtilizacao) {
		this.qtTotalUtilizacao = qtTotalUtilizacao;
	}

	/**
	 * @param idStatusManga the idStatusManga to set
	 */
	public void setIdStatusManga(Long idStatusManga) {
		this.idStatusManga = idStatusManga;
	}

	/**
	 * @param fnGeraPendencia the fnGeraPendencia to set
	 */
	public void setFnGeraPendencia(Integer fnGeraPendencia) {
		this.fnGeraPendencia = fnGeraPendencia;
	}

	/**
	 * @param qtUtilizada the qtUtilizada to set
	 */
	public void setQtUtilizada(Integer qtUtilizada) {
		this.qtUtilizada = qtUtilizada;
	}

	/**
	 * @param produto the produto to set
	 */
	public void setProduto(SnProdutoBean produto) {
		this.produto = produto;
	}

	/**
	 * @param promocao the promocao to set
	 */
	public void setPromocao(SnPromocaoBean promocao) {
		this.promocao = promocao;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(SnCidadeOperadoraBean cidade) {
		this.cidade = cidade;
	}

	/**
	 * @param idTipoManga the idTipoManga to set
	 */
	public void setIdTipoManga(CpAtributoBean idTipoManga) {
		this.idTipoManga = idTipoManga;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idMangaNegociacao != null) {
            result = prime * result + this.idMangaNegociacao.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof CpMangaNegociacaoBean) {
            final CpMangaNegociacaoBean comp = (CpMangaNegociacaoBean) key;
            test = this.getIdMangaNegociacao().equals(comp.getIdMangaNegociacao());
        }
        return test;
    }
}