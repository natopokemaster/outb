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

import br.com.netservicos.core.bean.sn.SnFormaEnvioFaturaBean;
import br.com.netservicos.core.bean.sn.SnTipoCobrancaBean;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela CP_COBRANCA.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 *                              
 * @hibernate.class table = "cp_cobranca" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 * 
 * 
 * @hibernate.query name = "lstDtFaturaRateio"
 *                  query = " select PROPOSTA.dtFaturaRateio 
 *                            from 
 *                            br.com.netservicos.core.bean.cp.CpPropostaBean as PROPOSTA, 
 *                            br.com.netservicos.core.bean.cp.CpCobrancaBean as COBRANCA
 *                            where PROPOSTA.idProposta = COBRANCA.idProposta
 *                            And PROPOSTA.idProposta = :idProposta" 
 *                            
 *                            
 *                            
 *@hibernate.query name = "lstDiaVencimento"
 *                  query = "select SN_DIA_VC1.idDiaVcto,
 *                                  SN_DIA_VC1.dia
 *                                  from 
 *                                  br.com.netservicos.core.bean.sn.SnDiaVctoBean as SN_DIA_VC1,
 *                                  br.com.netservicos.core.bean.sn.SnRelDiaVctoOperadoraBean as RVO
 *                                  where   SN_DIA_VC1.idDiaVcto = RVO.idDiaVcto
 *                                  AND     RVO.cidContrato = :cidadeOperadora.idCidade
 *                                  AND     RVO.idFormaPagamento = 1
 *                                  order by SN_DIA_VC1.dia"
 * 
 * 
 */
public class CpCobrancaBean extends DomainBean {

    public static final String DT_FATURA_RATEIO = "lstDtFaturaRateio";
    public static final String LST_DIA_VENCIMENTO = "lstDiaVencimento";
    private static final long serialVersionUID = -7156790613737335962L;

    private static final String PRIMARY_KEY = "idProposta";
    

    private Integer cobrancaVicenda;
    private Integer diaVencimento;
    private Integer idPeriocidade;
    private Long idProposta;
    private Integer pagtoAssProposta;
    private CpPropostaBean proposta;
    private SnTipoCobrancaBean tipoCobranca;
    private SnFormaEnvioFaturaBean idFormaEnvFat;

    /**
	 * Construtor Padrão.
	 */
    public CpCobrancaBean() {
        super(CpCobrancaBean.PRIMARY_KEY);
    }

    /**
     * @return Returns the cobrancaVicenda
     * @hibernate.property column="cobranca_vicenda"
     */
    public Integer getCobrancaVicenda() {
        return this.cobrancaVicenda;
    }

    /**
     * @return Returns the 
     * @hibernate.property column="id_dia_vencimento"
     */
    public Integer getDiaVencimento() {
        return this.diaVencimento;
    }

    /**
     * @return Returns the 
     * @hibernate.property column="id_periocidade"
     */
    public Integer getIdPeriocidade() {
        return this.idPeriocidade;
    }

    /**
     * @return Returns the 
     * @hibernate.id column="id_proposta"
     *               generator-class="foreign"
     * @hibernate.generator-param name="property"
     *                            value="proposta"
     */
    public Long getIdProposta() {
        return this.idProposta;
    }

    /**
     * @return Returns the 
     * @hibernate.property column="pagto_ass_proposta"
     */
    public Integer getPagtoAssProposta() {
        return this.pagtoAssProposta;
    }

    /**
     * @return Returns the CpPropostaBean
     * @hibernate.one-to-one class="br.com.netservicos.core.bean.cp.CpPropostaBean"
     *                       constrained="true"
     *                       cascade = "none"
     *                       lazy="proxy"
     */
    public CpPropostaBean getProposta() {
        return this.proposta;
    }

    /**
     * @return Returns the SnTipoCobrancaBean
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.sn.SnTipoCobrancaBean"
     *                        column="id_tipo_cobranca"
     *                        insert="true"
     *                        update="true"
     *                        lazy="proxy"
     */
    public SnTipoCobrancaBean getTipoCobranca() {
        return this.tipoCobranca;
    }

    /**
     * @return Returns the SnFormaEnvioFaturaBean
     * @hibernate.many-to-one column="ID_FORMA_ENVIO_FATURA" cascade="none"
     *                        not-null="false" lazy="proxy"
     */

    public SnFormaEnvioFaturaBean getIdFormaEnvFat() {
        return this.idFormaEnvFat;
    }

    /**
	 * @param cobrancaVicenda the cobrancaVicenda to set
	 */
	public void setCobrancaVicenda(Integer cobrancaVicenda) {
		this.cobrancaVicenda = cobrancaVicenda;
	}

	/**
	 * @param diaVencimento the diaVencimento to set
	 */
	public void setDiaVencimento(Integer diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	/**
	 * @param idPeriocidade the idPeriocidade to set
	 */
	public void setIdPeriocidade(Integer idPeriocidade) {
		this.idPeriocidade = idPeriocidade;
	}

	/**
	 * @param idProposta the idProposta to set
	 */
	public void setIdProposta(Long idProposta) {
		this.idProposta = idProposta;
	}

	/**
	 * @param pagtoAssProposta the pagtoAssProposta to set
	 */
	public void setPagtoAssProposta(Integer pagtoAssProposta) {
		this.pagtoAssProposta = pagtoAssProposta;
	}

	/**
	 * @param proposta the proposta to set
	 */
	public void setProposta(CpPropostaBean proposta) {
		this.proposta = proposta;
	}

	/**
	 * @param tipoCobranca the tipoCobranca to set
	 */
	public void setTipoCobranca(SnTipoCobrancaBean tipoCobranca) {
		this.tipoCobranca = tipoCobranca;
	}

	/**
	 * @param idFormaEnvFat the idFormaEnvFat to set
	 */
	public void setIdFormaEnvFat(SnFormaEnvioFaturaBean idFormaEnvFat) {
		this.idFormaEnvFat = idFormaEnvFat;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idProposta != null) {
            result = prime * result + this.idProposta.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof CpCobrancaBean) {
            final CpCobrancaBean comp = (CpCobrancaBean) key;
            test = this.getIdProposta().equals(comp.getIdProposta());
        }
        return test;
    }
}
