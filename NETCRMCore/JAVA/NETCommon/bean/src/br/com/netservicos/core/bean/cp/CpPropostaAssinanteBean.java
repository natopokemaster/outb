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

import br.com.netservicos.core.bean.sn.SnCampanhaBean;
import br.com.netservicos.core.bean.sn.SnContratoBean;
import br.com.netservicos.core.bean.sn.SnMidiaBean;
import br.com.netservicos.core.bean.sn.SnTipoVendaBean;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela CP_PROPOSTA_ASSINANTE.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "cp_proposta_assinante" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class CpPropostaAssinanteBean extends DomainBean {

    private static final long serialVersionUID = 3426350158905922057L;

    private static final String PRIMARY_KEY = "idPropostaAssinante";
    
    public static final String LST_PROPOSTA_ASSINANTE_BY_ID_PROPOSTA = "lstPropostaAssinante";
   
    private Long idPropostaAssinante;
    private Date dtVenda;
    private String idAtendente;
    private Date dtAtendimento;
    private String dsObservacao;
    private Long idAgendamento;
    private Double vlTotalFatura;
    private Double vlTotalMens;
    private Integer fnAgendaPadrao;
    private Integer fnAgendaConveniencia;
    private CpStatusPropostaBean statusProposta;
    private SnContratoBean contrato;
    private CpCidadeOperadoraBean cidadeOperadora;
    private SnMidiaBean midia;
    private CpVendedorBean vendedor;
    private SnTipoVendaBean tipoVenda;
    private SnCampanhaBean campanha;


    /**
     * Construtor padrão
     */
    public CpPropostaAssinanteBean() {
        super(CpPropostaAssinanteBean.PRIMARY_KEY);
    }
    
    /**
     * @return Returns the idPropostaAssinante
     * @hibernate.id column = "ID_PROPOSTA_ASSINANTE" length = "10"
     *               generator-class = "sequence"
     * @hibernate.generator-param name = "sequence"
     *                            value = "SQCP_PROPOSTA_ASSINANTE"
     */
    public Long getIdPropostaAssinante() {
        return this.idPropostaAssinante;
    }

    /**
     * @return Returns the statusProposta
     * @hibernate.many-to-one column = "ID_STATUS_PROPOSTA"
     *                        lazy="proxy"
     */
    public CpStatusPropostaBean getStatusProposta() {
        return this.statusProposta;
    }

    /**
     * @return Returns the vendedor
     * @hibernate.many-to-one column = "ID_VENDEDOR"
     *                        lazy="proxy"
     */
    public CpVendedorBean getVendedor() {
        return this.vendedor;
    }

    /**
     * @return SnTipoVendaBean
     * @hibernate.many-to-one column = "ID_TIPO_VENDA"
     *                        lazy="proxy"
     */
    public SnTipoVendaBean getTipoVenda() {
        return this.tipoVenda;
    }

    /**
     * @return Returns the dsObservacao
     * @hibernate.property column = "DS_OBSERVACAO"
     */
    public String getDsObservacao() {
        return this.dsObservacao;
    }

    /**
     * @return Returns the dtAtendimento
     * @hibernate.property column = "DT_ATENDIMENTO"
     */
    public Date getDtAtendimento() {
        return this.dtAtendimento;
    }

    /**
     * @return Returns the dtVenda
     * @hibernate.property column = "DT_VENDA"
     */
    public Date getDtVenda() {
        return this.dtVenda;
    }

    /**
     * @return Returns the idAgendamento
     * @hibernate.property column = "ID_AGENDAMENTO"
     */
    public Long getIdAgendamento() {
        return this.idAgendamento;
    }

    /**
     * @return Returns the idAtendente
     * @hibernate.property column = "ID_ATENDENTE"
     */
    public String getIdAtendente() {
        return this.idAtendente;
    }

    /**
     * @return Returns the campanha
     * @hibernate.many-to-one column = "ID_CAMPANHA"
     *                        lazy="proxy"
     */
    public SnCampanhaBean getCampanha() {
        return this.campanha;
    }

    /**
     * @return Returns the contrato
     */
    public SnContratoBean getContrato() {
        return this.contrato;
    }

    /**
     * @return Returns the midia
     * @hibernate.many-to-one column = "ID_MIDIA"
     *                        lazy="proxy"
     */
    public SnMidiaBean getMidia() {
        return this.midia;
    }

    /**
     * @return Returns the vlTotalFatura
     * @hibernate.property column = "VL_TOTAL_FATURA"
     */
    public Double getVlTotalFatura() {
        return this.vlTotalFatura;
    }

    /**
     * @return Returns the vlTotalMens
     * @hibernate.property column = "VL_TOTAL_MENS"
     */
    public Double getVlTotalMens() {
        return this.vlTotalMens;
    }

    /**
     * @return CpCidadeOperadoraBean
     * @hibernate.many-to-one column = "CID_CONTRATO" lazy="proxy"
     *                        update="false" insert="false" lazy="proxy"
     */
    public CpCidadeOperadoraBean getCidadeOperadora() {
        return this.cidadeOperadora;
    }

    /**
     * @hibernate.property column="FN_AGENDA_CONVENIENCIA"
     * @return Integer
     */
    public Integer getFnAgendaConveniencia() {
        return this.fnAgendaConveniencia;
    }

    /**
     * @hibernate.property column="FN_AGENDA_PADRAO"
     * @return Integer
     */
    public Integer getFnAgendaPadrao() {
        return this.fnAgendaPadrao;
    }
    
    /**
	 * @param idPropostaAssinante the idPropostaAssinante to set
	 */
	public void setIdPropostaAssinante(Long idPropostaAssinante) {
		this.idPropostaAssinante = idPropostaAssinante;
	}

	/**
	 * @param dtVenda the dtVenda to set
	 */
	public void setDtVenda(Date dtVenda) {
		this.dtVenda = dtVenda;
	}

	/**
	 * @param idAtendente the idAtendente to set
	 */
	public void setIdAtendente(String idAtendente) {
		this.idAtendente = idAtendente;
	}

	/**
	 * @param dtAtendimento the dtAtendimento to set
	 */
	public void setDtAtendimento(Date dtAtendimento) {
		this.dtAtendimento = dtAtendimento;
	}

	/**
	 * @param dsObservacao the dsObservacao to set
	 */
	public void setDsObservacao(String dsObservacao) {
		this.dsObservacao = dsObservacao;
	}

	/**
	 * @param idAgendamento the idAgendamento to set
	 */
	public void setIdAgendamento(Long idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	/**
	 * @param vlTotalFatura the vlTotalFatura to set
	 */
	public void setVlTotalFatura(Double vlTotalFatura) {
		this.vlTotalFatura = vlTotalFatura;
	}

	/**
	 * @param vlTotalMens the vlTotalMens to set
	 */
	public void setVlTotalMens(Double vlTotalMens) {
		this.vlTotalMens = vlTotalMens;
	}

	/**
	 * @param fnAgendaPadrao the fnAgendaPadrao to set
	 */
	public void setFnAgendaPadrao(Integer fnAgendaPadrao) {
		this.fnAgendaPadrao = fnAgendaPadrao;
	}

	/**
	 * @param fnAgendaConveniencia the fnAgendaConveniencia to set
	 */
	public void setFnAgendaConveniencia(Integer fnAgendaConveniencia) {
		this.fnAgendaConveniencia = fnAgendaConveniencia;
	}

	/**
	 * @param statusProposta the statusProposta to set
	 */
	public void setStatusProposta(CpStatusPropostaBean statusProposta) {
		this.statusProposta = statusProposta;
	}

	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(SnContratoBean contrato) {
		this.contrato = contrato;
	}

	/**
	 * @param cidadeOperadora the cidadeOperadora to set
	 */
	public void setCidadeOperadora(CpCidadeOperadoraBean cidadeOperadora) {
		this.cidadeOperadora = cidadeOperadora;
	}

	/**
	 * @param midia the midia to set
	 */
	public void setMidia(SnMidiaBean midia) {
		this.midia = midia;
	}

	/**
	 * @param vendedor the vendedor to set
	 */
	public void setVendedor(CpVendedorBean vendedor) {
		this.vendedor = vendedor;
	}

	/**
	 * @param tipoVenda the tipoVenda to set
	 */
	public void setTipoVenda(SnTipoVendaBean tipoVenda) {
		this.tipoVenda = tipoVenda;
	}

	/**
	 * @param campanha the campanha to set
	 */
	public void setCampanha(SnCampanhaBean campanha) {
		this.campanha = campanha;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        if (this.idPropostaAssinante != null) {
            result = prime * result + this.idPropostaAssinante.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof CpPropostaAssinanteBean) {
            final CpPropostaAssinanteBean comp = (CpPropostaAssinanteBean) key;
            test = this.getIdPropostaAssinante().equals(comp.getIdPropostaAssinante());
        }
        return test;
    }
}