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
import java.util.List;

import br.com.netservicos.core.bean.sn.SnCaracteristicaBean;
import br.com.netservicos.core.bean.sn.SnLocalizacaoBean;
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
 * @hibernate.class table = "cp_ponto" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 * 
 * 
 * @hibernate.query name  = "lstQntTelNaoReservadosVoip"
 *                 query = "SELECT ponto.idPonto 
 *                          FROM br.com.netservicos.core.bean.cp.CpPontoBean ponto
 *                          WHERE ponto.proposta.idProposta = :proposta.idProposta
 *                          AND ponto.caracteristica.idCaracteristica = 4
 *                          AND ponto.idPonto NOT IN (SELECT reserva.ponto.idPonto 
 *                          FROM br.com.netservicos.core.bean.cp.CpReservaTelefoneVoipBean reserva
 *                          WHERE reserva.ponto.idPonto = ponto.idPonto)"
 * 
 * 
 */
public class CpPontoBean extends DomainBean {

    private static final long serialVersionUID = 5712807267587234236L;

    public static final String LST_QTDADE_PRODUTOS_VOIP_NAO_RESERVADOS = "lstQntTelNaoReservadosVoip";
    
    private static final String PRIMARY_KEY = "idPonto";

    private Long idPonto;
    private BigDecimal precoProd;
    private BigDecimal vlPrimeiroMes;
    private Integer retornoTelefonico;
    private CpPontoBean pontoPai;
    private CpPropostaBean proposta;
    private SnPromocaoBean promocao;
    private SnCaracteristicaBean caracteristica;
    private SnProdutoBean produto;
    private SnPlanoPgtoBean planoPgto;
    private SnLocalizacaoBean localizacao;
    private CpTipoPontoBean tipoPonto;
    private CpMangaNegociacaoBean mangaNegociacao;
    private List produtosAgregados;
    private List reservasVoip;
    
    /**
     * The default constructor of this class.
     */
    public CpPontoBean() {
        super(CpPontoBean.PRIMARY_KEY);
        metaData.put("produtosAgregados", CpProdutosAgregadosBean.class); 
    }
    
    
    /**
     * @hibernate.id column="id_ponto"
     *               generator-class="sequence"
     * @hibernate.generator-param name="sequence"
     *                            value="scp_ponto"
     * @return Long
     */
    public Long getIdPonto() {
        return this.idPonto;
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
     * @return Integer - Returns the retornoTelefonico.
     * @hibernate.property column="retorno_telefonico"
     */
    public Integer getRetornoTelefonico() {
        return this.retornoTelefonico;
    }
    
    /**
     * @return Returns the idPromocao.
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.sn.SnPromocaoBean"
     *                        column="id_promocao"
     *                        lazy="false"
     */
    public SnPromocaoBean getPromocao() {
        return this.promocao;
    }
    
    /**
     * @return SnCaracteristicaBean.
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.sn.SnCaracteristicaBean"
     *                        column="id_caracteristica"
     *                        lazy="false"
     */
    public SnCaracteristicaBean getCaracteristica() {
        return this.caracteristica;
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
     * @return Returns the idLocalizacao.
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.sn.SnLocalizacaoBean"
     *                        column="id_localizacao"
     *                        lazy="false"
     */
    public SnLocalizacaoBean getLocalizacao() {
        return this.localizacao;
    }

    /**
     * @return Returns the idProduto.
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.sn.SnProdutoBean"
     *                        column="id_produto"
     *                        lazy="false"
     */
    public SnProdutoBean getProduto() {
        return this.produto;
    }

    /**
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.cp.CpPontoBean"
     *                        column="id_ponto_pai"
     *                        lazy="false"
     * @return CpPontoBean
     */
    public CpPontoBean getPontoPai() {
        return this.pontoPai;
    }

    /**
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.cp.CpPropostaBean"
     *                        column="id_proposta"
     *                        not-null="true"
     *                        insert="true"
     *                        update="false"
     *                        lazy="false"
     * @return CpPropostaBean
     */
    public CpPropostaBean getProposta() {
        return this.proposta;
    }

    /**
     * @return Returns the idTipoPonto.
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.cp.CpTipoPontoBean"
     *                        column="id_tipo_ponto"
     *                        cascade="none"
     *                        not-null="true"
     *                        lazy="false"
     */
    public CpTipoPontoBean getTipoPonto() {
        return this.tipoPonto;
    }

    /**
     * @return Returns the descricao.
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.cp.CpMangaNegociacaoBean"
     *                        column="ID_MANGA_NEGOCIACAO"
     */
    public CpMangaNegociacaoBean getMangaNegociacao() {
        return this.mangaNegociacao;
    }

    /**
	 * @param idPonto the idPonto to set
	 */
	public void setIdPonto(Long idPonto) {
		this.idPonto = idPonto;
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

	/**
	 * @param retornoTelefonico the retornoTelefonico to set
	 */
	public void setRetornoTelefonico(Integer retornoTelefonico) {
		this.retornoTelefonico = retornoTelefonico;
	}

	/**
	 * @param pontoPai the pontoPai to set
	 */
	public void setPontoPai(CpPontoBean pontoPai) {
		this.pontoPai = pontoPai;
	}

	/**
	 * @param proposta the proposta to set
	 */
	public void setProposta(CpPropostaBean proposta) {
		this.proposta = proposta;
	}

	/**
	 * @param promocao the promocao to set
	 */
	public void setPromocao(SnPromocaoBean promocao) {
		this.promocao = promocao;
	}

	/**
	 * @param caracteristica the caracteristica to set
	 */
	public void setCaracteristica(SnCaracteristicaBean caracteristica) {
		this.caracteristica = caracteristica;
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
	 * @param localizacao the localizacao to set
	 */
	public void setLocalizacao(SnLocalizacaoBean localizacao) {
		this.localizacao = localizacao;
	}

	/**
	 * @param tipoPonto the tipoPonto to set
	 */
	public void setTipoPonto(CpTipoPontoBean tipoPonto) {
		this.tipoPonto = tipoPonto;
	}

	/**
	 * @param mangaNegociacao the mangaNegociacao to set
	 */
	public void setMangaNegociacao(CpMangaNegociacaoBean mangaNegociacao) {
		this.mangaNegociacao = mangaNegociacao;
	}
	
	 /**
     * @hibernate.bag
     *      table="cp_produtos_agregados"
     *      inverse="true"
     *      lazy="true"
     *      batch-size="5"
     *      cascade="delete"
     * @hibernate.collection-one-to-many 
     *      class="br.com.netservicos.core.bean.cp.CpProdutosAgregadosBean"
     * @hibernate.collection-key
     *      column="id_ponto"
     * 
     * @return
     */
    public List getProdutosAgregados() {
        return produtosAgregados;
    }
    
    public void setProdutosAgregados(List produtosAgregados) {
        this.produtosAgregados = produtosAgregados;
    }
    

    /**
     * @hibernate.bag
     *      table = "cp_reserva_telefone_voip"
     *      lazy = "true"
     *      cascade = "delete"
     * @hibernate.collection-one-to-many 
     *      class = "br.com.netservicos.core.bean.cp.CpReservaTelefoneVoipBean"
     * @hibernate.collection-key 
     *      column = "id_ponto"
     * @return
     */
    public List getReservasVoip() {
        return reservasVoip;
    }
    
    public void setReservasVoip(List reservasVoip) {
        this.reservasVoip = reservasVoip;
    }

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idPonto != null) {
            result = prime * result + this.idPonto.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof CpPontoBean) {
            final CpPontoBean comp = (CpPontoBean) key;
            test = this.getIdPonto().equals(comp.getIdPonto());
        }
        return test;
    }
}
