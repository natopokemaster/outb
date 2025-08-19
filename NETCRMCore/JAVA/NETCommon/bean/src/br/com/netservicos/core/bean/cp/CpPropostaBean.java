/*
 * Created on 13/12/2004
 *
 * Copyright © 2004 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.core.bean.cp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.netservicos.core.bean.sn.SnPeriodoBean;
import br.com.netservicos.core.bean.sn.SnTipoSegmentoBean;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela cp_proposta.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- -------------------------
 * 
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                           Prior
 * Date       By             Version  Project/CSR    Description
 * ---------- -------------- -------- -------------- ----------------------------
 * 20/01/2010 Alexandre Soares N/A      netcrmcore      Created.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table="cp_proposta"
 *                   dynamic-insert="true"
 *                   dynamic-update="true"
 *                   lazy="true"
 *                   batch-size="10"
 *                   schema="netsales"
 *   
 * @hibernate.cache usage="read-write"                
 * 
 */
public class CpPropostaBean extends DomainBean {

    public static final String ATRIBUTO_ID_PROPOSTA = "idProposta";
    public static final String PROPERTY_PROPOSTA = "proposta";


    private static final long serialVersionUID = -3257889501669425209L;

    private Date dtAtend;
    private Date dtLiberacao;
    private Date dtVenda;
  
    private String idAreaDespacho;
    private BigDecimal vlrTotalFatura;
    private BigDecimal vlrTotalMens;
    
    private Integer idPerfilCliente;
    private String idAtendente;
    private Integer idCampanha;
    private Integer idMidia;
    private Long idProposta;
    private Integer idSistemaSinal;
    private Integer idTipoAssinante;
    private Integer idTipoContrato;
    private Integer idTipoVenda;
    private Long idVendedor;
    private Integer numContrato;
    private String observacao;
    private String obsos;
    private Integer idAgendamentoSA;
    private Date dtFaturaRateio;
    private String dsContato;
    private String nrDddContato;
    private String nrTelContato;
    private List pendenciasProposta;
    private List pendenciasPropostaEmAberto;
    private CpStatusPropostaBean statusProposta;
    private CpScpcPropostaBean scpcProposta;
    private CpProspectBean prospect;
    private List pontos;
    private List pontosAdicionais;
    private CpVendedorBean vendedor;
    private SnTipoSegmentoBean tipoSegmento;
    private List pontosPrincipais;
    private List dadosPontos;    
    private List<CpRelPendenciaPropostaBean> lstPendenciasProposta;    
    private SnPeriodoBean periodoAgendamento;
    private Integer idAgendamento;
    
//  esses campos nao sao persistidos (transients) 
    private Long idEmpresa;
    private Long idEquipeVenda;
    
    private CpCidadeOperadoraBean cidadeOperadora;
    private Integer fnAgendaPadrao; 
    private Integer fnAgendaConveniencia;
    
    public CpPropostaBean() {
        super(ATRIBUTO_ID_PROPOSTA);
        idTipoAssinante = new Integer(1);        
    }

    public CpPropostaBean(Long idProposta) {
        this();

        this.idProposta = idProposta;        
        metaData.put("pontos", CpPontoBean.class);
        metaData.put("pontosPrincipais", CpPontoBean.class);
    }

  

    /**
     * @return Returns the dtAtend.
     * 
     * @hibernate.property
     * 		column = "dt_atend"
     */
    public Date getDtAtend() {
        return dtAtend;
    }

    /**
     * @return Returns the dtLiberacao.
     * 
     * @hibernate.property
     * 		column = "dt_liberacao"
     */
    public Date getDtLiberacao() {
        return dtLiberacao;
    }

    /**
     * @return Returns the dtVenda.
     * 
     * @hibernate.property
     * 		column = "dt_venda"
     */
    public Date getDtVenda() {
        return dtVenda;
    }


   
    /**
     * @return Returns the idAtendente.
     * 
     * @hibernate.property
     * 		column = "id_atendente"
     */
    public String getIdAtendente() {
        return idAtendente;
    }

    /**
     * @return Returns the idCampanha.
     * 
     * @hibernate.property
     * 		column = "id_campanha"
     */
    public Integer getIdCampanha() {
        return idCampanha;
    }

    /**
     * @return Returns the idMidia.
     * 
     * @hibernate.property
     * 		column = "id_midia"
     */
    public Integer getIdMidia() {
        return idMidia;
    }


    /**
     * @return Returns the idProposta.
     * 
     * @hibernate.id
     * 		column="id_proposta"
     * 		generator-class="sequence"
     * @hibernate.generator-param
     *      name="sequence"
     *      value="scp_proposta"
     */
    public Long getIdProposta() {
        return idProposta;
    }

    /**
     * @return Returns the idSistemaSinal.
     * 
     * @hibernate.property
     * 		column = "id_sistema_sinal"
     */
    public Integer getIdSistemaSinal() {
        return idSistemaSinal;
    }

    /**
     * @return Returns the idTipoAssinante.
     * 
     * @hibernate.property
     * 		column = "id_tipo_assinante"
     */
    public Integer getIdTipoAssinante() {
        return idTipoAssinante;
    }

    /**
     * @return Returns the idTipoContrato.
     * 
     * @hibernate.property
     * 		column = "id_tipo_contrato"
     */
    public Integer getIdTipoContrato() {
        return idTipoContrato;
    }

    /**
     * @return Returns the idTipoVenda.
     * 
     * @hibernate.property
     * 		column = "id_tipo_venda"
     */
    public Integer getIdTipoVenda() {
        return idTipoVenda;
    }

    /**
     * @return Returns the idVendedor.
     * 
     * @hibernate.property
     * 		column = "id_vendedor"
     * 		insert="true"
     * 		update="true"
     */
    public Long getIdVendedor() {
        return idVendedor;
    }


    /**
     * @return Returns the numContrato.
     * 
     * @hibernate.property
     * 		column = "num_contrato"
     */
    public Integer getNumContrato() {
        return numContrato;
    }

    /**
     * @return Returns the observacao.
     * 
     * @hibernate.property
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @return Returns the obsos.
     * 
     * @hibernate.property
     */
    public String getObsos() {
        return obsos;
    }

    /**
     * @param dtAtend The dtAtend to set.
     */
    public void setDtAtend(Date dtAtend) {
        this.dtAtend = dtAtend;
    }

    /**
     * @param dtLiberacao The dtLiberacao to set.
     */
    public void setDtLiberacao(Date dtLiberacao) {
        this.dtLiberacao = dtLiberacao;
    }

    /**
     * @param dtVenda The dtVenda to set.
     */
    public void setDtVenda(Date dtVenda) {
        this.dtVenda = dtVenda;
    }

  
    /**
     * @param idAtendente The idAtendente to set.
     */
    public void setIdAtendente(String idAtendente) {
        this.idAtendente = idAtendente;
    }

    /**
     * @param idCampanha The idCampanha to set.
     */
    public void setIdCampanha(Integer idCampanha) {
        this.idCampanha = idCampanha;
    }

    /**
     * @param idMidia The idMidia to set.
     */
    public void setIdMidia(Integer idMidia) {
        this.idMidia = idMidia;
    }


    /**
     * @param idProposta The idProposta to set.
     */
    public void setIdProposta(Long idProposta) {
        this.idProposta = idProposta;
    }

    /**
     * @param idSistemaSinal The idSistemaSinal to set.
     */
    public void setIdSistemaSinal(Integer idSistemaSinal) {
        this.idSistemaSinal = idSistemaSinal;
    }

    /**
     * @param idTipoAssinante The idTipoAssinante to set.
     */
    public void setIdTipoAssinante(Integer idTipoAssinante) {
        this.idTipoAssinante = idTipoAssinante;
    }

    /**
     * @param idTipoContrato The idTipoContrato to set.
     */
    public void setIdTipoContrato(Integer idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    /**
     * @param idTipoVenda The idTipoVenda to set.
     */
    public void setIdTipoVenda(Integer idTipoVenda) {
        this.idTipoVenda = idTipoVenda;
    }

    /**
     * @param idVendedor The idVendedor to set.
     */
    public void setIdVendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
    }


    /**
     * @param numContrato The numContrato to set.
     */
    public void setNumContrato(Integer numContrato) {
        this.numContrato = numContrato;
    }

    /**
     * @param observacao The observacao to set.
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * @param obsos The obsos to set.
     */
    public void setObsos(String obsos) {
        this.obsos = obsos;
    }

    /**
     * @hibernate.property
     *      column="vlr_total_fatura"
     * @return
     */
    public BigDecimal getVlrTotalFatura() {
        return vlrTotalFatura;
    }

    public void setVlrTotalFatura(BigDecimal vlrTotalFatura) {
        this.vlrTotalFatura = vlrTotalFatura;
    }

   
	
	/**
	 * @hibernate.property
	 * 		column="VLR_TOTAL_MENS"
	 * 
	 * @return
	 */
	public BigDecimal getVlrTotalMens() {
		return vlrTotalMens;
	}

	public void setVlrTotalMens(BigDecimal vlrTotalMens) {
		this.vlrTotalMens = vlrTotalMens;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Long getIdEquipeVenda() {
		return idEquipeVenda;
	}

	public void setIdEquipeVenda(Long idEquipeVenda) {
		this.idEquipeVenda = idEquipeVenda;
	}

	/**
	 * @hibernate.property
	 * 		column="ID_AREA_DESPACHO"
	 * 
	 * @return
	 */	
	public String getIdAreaDespacho() {
		return idAreaDespacho;
	}

	
	public void setIdAreaDespacho(String idAreaDespacho) {
		this.idAreaDespacho = idAreaDespacho;
	}
	
	/**
	 * @hibernate.property
	 * 		column="id_perfil_cliente"
	 * 
	 * @return
	 */	
	public Integer getIdPerfilCliente(){
		return this.idPerfilCliente;
	}
	
	public void setIdPerfilCliente(Integer idPerfilCliente){
		this.idPerfilCliente = idPerfilCliente;
	}


	/**
	 * @hibernate.property
	 * 		column="FN_AGENDA_CONVENIENCIA"
	 * 
	 * @return
	 */
	public Integer getFnAgendaConveniencia() {
		return fnAgendaConveniencia;
	}

	public void setFnAgendaConveniencia(Integer fnAgendaConveniencia) {
		this.fnAgendaConveniencia = fnAgendaConveniencia;
	}

	/**
	 * @hibernate.property
	 * 		column="FN_AGENDA_PADRAO"
	 * 
	 * @return
	 */
	public Integer getFnAgendaPadrao() {
		return fnAgendaPadrao;
	}

	public void setFnAgendaPadrao(Integer fnAgendaPadrao) {
		this.fnAgendaPadrao = fnAgendaPadrao;
	}

	public Integer getIdAgendamentoSA() {
		return idAgendamentoSA;
	}

	public void setIdAgendamentoSA(Integer idAgendamentoSA) {
		this.idAgendamentoSA = idAgendamentoSA;
	}
    /**
     * @return Returns the dtFaturaRateio.
     * 
     * @hibernate.property
     * 		column = "dt_fatura_rateio"
     */
    public Date getDtFaturaRateio() {
        return dtFaturaRateio;
    }

    /**
     * @param dtFaturaRateio The dtFaturaRateio to set.
     */
    public void setDtFaturaRateio(Date dtFaturaRateio) {
        this.dtFaturaRateio = dtFaturaRateio;
    }	
    
    /**
     * @return Returns the dsContato.
     * 
     * @hibernate.property
     * 		column = "ds_contato"
     */
    public String getDsContato() {
        return dsContato;
    }

    /**
     * @param dsContato The dsContato to set.
     */
    public void setDsContato(String dsContato) {
        this.dsContato = dsContato;
    }	    

    /**
     * @return Returns the nrDddContato.
     * 
     * @hibernate.property
     * 		column = "nr_ddd_contato"
     */
    public String getNrDddContato() {
        return nrDddContato;
    }

    /**
     * @param nrDddContato The nrDddContato to set.
     */
    public void setNrDddContato(String nrDddContato) {
        this.nrDddContato = nrDddContato;
    }
    
    /**
     * @return Returns the nrTelContato.
     * 
     * @hibernate.property
     * 		column = "nr_tel_contato"
     */
    public String getNrTelContato() {
        return nrTelContato;
    }

    /**
     * @param nrTelContato The nrTelContato to set.
     */
    public void setNrTelContato(String nrTelContato) {
        this.nrTelContato = nrTelContato;
    }
    
    /**
     * @hibernate.bag
     *      table="cp_rel_pendencia_proposta"
     *      cascade="delete"
     *      inverse="true"
     *      lazy="true"
     *      batch-size="5"
     * @hibernate.collection-one-to-many 
     *      class="br.com.netservicos.core.bean.cp.CpRelPendenciaPropostaBean"
     * @hibernate.collection-key
     *      column="id_proposta"
     * @return
     */
    public List getPendenciasProposta() {
        return pendenciasProposta;
    }
    
    public void setPendenciasProposta(List pendenciaProposta) {
        this.pendenciasProposta = pendenciaProposta;
    }
    
    /**
     * @hibernate.bag
     *      table="cp_rel_pendencia_proposta"
     *      cascade="delete"
     *      inverse="true"
     *      lazy="true"
     *      batch-size="20"
     *      where="dt_fechamento is null"
     * @hibernate.collection-one-to-many 
     *      class="br.com.netservicos.core.bean.cp.CpRelPendenciaPropostaBean"
     * @hibernate.collection-key
     *      column="id_proposta"
     * 
     * @return
     */
	public List getPendenciasPropostaEmAberto() {
		return pendenciasPropostaEmAberto;
	}
	
	public void setPendenciasPropostaEmAberto(List pendenciasPropostaEmAberto) {
		this.pendenciasPropostaEmAberto = pendenciasPropostaEmAberto;
	}
	
	   /**
     * @return Returns the statusProposta.
     * 
     * @hibernate.many-to-one
     * 		column="id_status_proposta"
     */
    public CpStatusPropostaBean getStatusProposta() {
        return statusProposta;
    }
    
    /**
     * @param statusProposta The statusProposta to set.
     */
    public void setStatusProposta(CpStatusPropostaBean statusProposta) {
        this.statusProposta = statusProposta;
    }
    
    /**
     * @hibernate.many-to-one
     * 		column="id_cidade"
     * 		not-null="true"
     * 		insert="true"
     * 		update="false"
     * 
     * @return
     */
    public CpCidadeOperadoraBean getCidadeOperadora() {
        return cidadeOperadora;
    }
	
    public void setCidadeOperadora(CpCidadeOperadoraBean cidade) {
        this.cidadeOperadora = cidade;
    }
    
    /**
     * @hibernate.one-to-one
     *      constrained="false" 
     *      cascade = "delete"
     *      lazy="proxy"
     *      
     * @return
     */
    public CpScpcPropostaBean getScpcProposta() {
        return scpcProposta;
    }
    
    public void setScpcProposta(CpScpcPropostaBean scpcProposta) {
        this.scpcProposta = scpcProposta;
    }
    
    /**
     * @hibernate.many-to-one  
     * 		column="id_prospect"
     * 		lazy="proxy"
     *  
     * @return Returns the prospect.
     */
    public CpProspectBean getProspect() {
        return prospect;
    }
    
    /**
     * @param prospect The prospect to set.
     */
    public void setProspect(CpProspectBean prospect) {
        this.prospect = prospect;
    }
    
    /**
     * @hibernate.bag
     * 		table="cp_ponto"
     * 		cascade="delete"
     * 		inverse="true"
     * 		lazy="true"
     *      batch-size="5"
     *      order-by="id_ponto asc"
     * @hibernate.collection-one-to-many 
     * 		class="br.com.netservicos.core.bean.cp.CpPontoBean"
     * @hibernate.collection-key
     * 		column="id_proposta"
     * @return
     */
    public List getPontos() {
        return pontos;
    }
    
    public void setPontos(List pontos) {
        this.pontos = pontos;
    }
    
    /**
     * @hibernate.bag
     *      table="cp_ponto"
     *      cascade="none"
     *      inverse="true"
     *      lazy="true"
     *      batch-size="20"
     *      where="id_tipo_ponto = 6"
     * @hibernate.collection-one-to-many 
     *      class="br.com.netservicos.core.bean.cp.CpPontoBean"
     * @hibernate.collection-key
     *      column="id_proposta"
     * 
     * @return
     */
    public List getPontosAdicionais() {
        return pontosAdicionais;
    }
    
    public void setPontosAdicionais(List pontosAdicionais) {
        this.pontosAdicionais = pontosAdicionais;
    }
    
    /**
     * @hibernate.many-to-one
     *      column="id_vendedor"
     *      insert="false"
     *      update="false"
     * @return
     */
    public CpVendedorBean getVendedor() {
        return vendedor;
    }

    public void setVendedor(CpVendedorBean vendedor) {
        this.vendedor= vendedor;
    }
    
    /**
     * @hibernate.many-to-one
     *      column="id_tipo_segmento"
     *      insert="true"
     *      update="true"
     *      lazy="proxy"
     * 
     * @return
     */
    public SnTipoSegmentoBean getTipoSegmento() {
        return tipoSegmento;
    }

    public void setTipoSegmento(SnTipoSegmentoBean tipoSegmento) {
        this.tipoSegmento = tipoSegmento;
    }
    
    /**
     * @hibernate.bag 
     *      table="cp_ponto"
     *      cascade="none"
     *      lazy="true"
     *      inverse="true"
     *      insert="false"
     *      update="false"
     *      batch-size="10"
     *      where="id_tipo_ponto = 5"
     * @hibernate.collection-one-to-many 
     *      class="br.com.netservicos.core.bean.cp.CpPontoBean"
     * @hibernate.collection-key
     *      column="id_proposta"
     * @return
     */
    public List getPontosPrincipais() {
        return pontosPrincipais;
    }

    public void setPontosPrincipais(List pontosPrincipais) {
        this.pontosPrincipais = pontosPrincipais;
    }

    /**
     * @hibernate.bag 
     *      table="cp_ponto"
     *      cascade="none"
     *      lazy="true"
     *      inverse="true"
     *      insert="false"
     *      update="false"
     *      batch-size="30"
     *      where="id_tipo_ponto in (1,2,3,4)"
     * @hibernate.collection-one-to-many 
     *      class="br.com.netservicos.core.bean.cp.CpPontoBean"
     * @hibernate.collection-key
     *      column="id_proposta"
     * @return
     */
    public List getDadosPontos() {
        return dadosPontos;
    }

    public void setDadosPontos(List dadosPontosVirtua) {
        this.dadosPontos = dadosPontosVirtua;
    }
    
    /**
     * @hibernate.bag table="cp_rel_pendencia_proposta" cascade="delete"
     *                inverse="true" lazy="true" batch-size="5"
     * @hibernate.collection-one-to-many
     *                                   class="br.com.netservicos.core.bean.cp.CpRelPendenciaPropostaBean"
     * @hibernate.collection-key column="id_proposta"
     * @return List<CpRelPendenciaPropostaBean>.
     */
    public List<CpRelPendenciaPropostaBean> getLstPendenciasProposta() {
        return this.lstPendenciasProposta;
    }

    /**
     * @param lstPendProposta
     * @since 08/03/2010
     * @author mauricio.araujo
     */
    public void setLstPendenciasProposta(final List<CpRelPendenciaPropostaBean> lstPendProposta) {
        this.lstPendenciasProposta = lstPendProposta;
    }
    
    /**
     * @hibernate.many-to-one column="id_agendamento" insert="false"
     *                        update="false" lazy="proxy"
     * @return
     */
    public SnPeriodoBean getPeriodoAgendamento() {
        return this.periodoAgendamento;
    }

    public void setPeriodoAgendamento(final SnPeriodoBean periodoAgendamento) {
        this.periodoAgendamento = periodoAgendamento;
    }
    
    /**
     * @return Returns the idAgendamento.
     * 
     * @hibernate.property
     *      column = "id_agendamento"
     */
    public Integer getIdAgendamento() {
        return idAgendamento;
    }
    
    
    /**
     * @param idAgendamento The idAgendamento to set.
     */
    public void setIdAgendamento(Integer idAgendamento) {
        this.idAgendamento = idAgendamento;
    }
    
   
   
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idProposta!= null) {
            result = prime * result + this.idProposta.hashCode();
        }
        return result;
    }

   
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof CpPropostaBean) { 
            final CpPropostaBean comp = (CpPropostaBean) key;
            test = this.getIdProposta().equals(comp.getIdProposta());
        }
        return test;
    }
    

}