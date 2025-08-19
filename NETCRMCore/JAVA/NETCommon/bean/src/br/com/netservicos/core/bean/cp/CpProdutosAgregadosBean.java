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

import java.math.BigDecimal;

import br.com.netservicos.core.bean.sn.SnPlanoPgtoBean;
import br.com.netservicos.core.bean.sn.SnProdutoBean;
import br.com.netservicos.core.bean.sn.SnPromocaoBean;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela CP_PONTO.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "cp_produtos_agregados" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class CpProdutosAgregadosBean extends DomainBean {

	private static final long serialVersionUID = -3478756620991899719L;

	private static final String PRIMARY_KEY = "idProdutoAgregado";    

    private Long idProdutoAgregado = null;
    private CpPontoBean ponto;
    private SnProdutoBean produto;
    private SnPlanoPgtoBean planoPgto;    
    private SnPromocaoBean promocao;
    private CpMangaNegociacaoBean mangaNegociacao;
    private Integer quantidade;
    private BigDecimal precoProd;
    private BigDecimal vlPrimeiroMes;

    /** 
     * Construtor Padrão
     */
    public CpProdutosAgregadosBean() {
        super(PRIMARY_KEY);
    }
    
    /**
     * @return Returns the idProdutoAgregado.
     * @hibernate.id column="id_produto_agregado" generator-class="sequence"
     * @hibernate.generator-param name="sequence" value="scp_produtos_agregados"
     */
    public Long getIdProdutoAgregado() {
        return idProdutoAgregado;
    }
    
    /**
     * @return Returns the CpPontoBean
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.cp.CpPontoBean"
     * 						  column="id_ponto"
     * 		                  not-null="true"
     * 						  lazy="false"
     */
    public CpPontoBean getPonto() {
        return ponto;
    }
    
    /**
     * @return Returns the SnProdutoBean.
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.sn.SnProdutoBean"
     *                        column="id_produto"
     *                        lazy="false"
     */
    public SnProdutoBean getProduto() {
        return this.produto;
    }
    
    /**
     * @return SnPlanoPgtoBean.
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.sn.SnPlanoPgtoBean"
     *                        column="id_cond_pagto"
     *                        not-null="true"
     *                        lazy="false"
     */
    public SnPlanoPgtoBean getPlanoPgto() {
        return this.planoPgto;
    }
    
    /**
     * @return Returns the SnPromocaoBean.
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.sn.SnPromocaoBean"
     *                        column="id_promocao"
     *                        lazy="false"
     */
    public SnPromocaoBean getPromocao() {
        return this.promocao;
    }
    
	/**
	 * @return Returns the CpMangaNegociacaoBean.
	 *
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.cp.CpMangaNegociacaoBean"
	 *  					  column="id_manga_negociacao"
	 *  					  lazy="false"
	 */
	public CpMangaNegociacaoBean getMangaNegociacao() {
		return mangaNegociacao;
	}
	
    /**
     * @return Returns the quantidade.
     * 
     * @hibernate.property column="quantidade"
     */
    public Integer getQuantidade() {
        return quantidade;
    }
    
    /**
     * @return Returns the precoProd.
     * @hibernate.property column="preco_prod"
     */
    public BigDecimal getPrecoProd() {
        if (this.precoProd != null) {
            return this.precoProd.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }
        return this.precoProd;
    }

    /**
     * @return Returns the vlPrimeiroMes.
     * @hibernate.property column="vl_primeiro_mes"
     */
    public BigDecimal getVlPrimeiroMes() {
        if (this.vlPrimeiroMes != null) {
            return this.vlPrimeiroMes.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }
        return this.vlPrimeiroMes;
    }
    
	/**
	 * @param idProdutoAgregado the idProdutoAgregado to set
	 */
	public void setIdProdutoAgregado(Long idProdutoAgregado) {
		this.idProdutoAgregado = idProdutoAgregado;
	}

	/**
	 * @param ponto the ponto to set
	 */
	public void setPonto(CpPontoBean ponto) {
		this.ponto = ponto;
	}

	/**
	 * @param produto the produto to set
	 */
	public void setProduto(SnProdutoBean produto) {
		this.produto = produto;
	}

	/**
	 * @param planoPgto the planoPgto to set
	 */
	public void setPlanoPgto(SnPlanoPgtoBean planoPgto) {
		this.planoPgto = planoPgto;
	}

	/**
	 * @param promocao the promocao to set
	 */
	public void setPromocao(SnPromocaoBean promocao) {
		this.promocao = promocao;
	}

	/**
	 * @param mangaNegociacao the mangaNegociacao to set
	 */
	public void setMangaNegociacao(CpMangaNegociacaoBean mangaNegociacao) {
		this.mangaNegociacao = mangaNegociacao;
	}

	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @param precoProd the precoProd to set
	 */
	public void setPrecoProd(BigDecimal precoProd) {
		this.precoProd = precoProd;
	}

	/**
	 * @param vlPrimeiroMes the vlPrimeiroMes to set
	 */
	public void setVlPrimeiroMes(BigDecimal vlPrimeiroMes) {
		this.vlPrimeiroMes = vlPrimeiroMes;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idProdutoAgregado != null) {
            result = prime * result + this.idProdutoAgregado.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof CpProdutosAgregadosBean) {
            final CpProdutosAgregadosBean comp = (CpProdutosAgregadosBean) key;
            test = this.getIdProdutoAgregado().equals(comp.getIdProdutoAgregado());
        }
        return test;
    }
}