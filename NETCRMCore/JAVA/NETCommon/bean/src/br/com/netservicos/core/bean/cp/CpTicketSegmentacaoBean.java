package br.com.netservicos.core.bean.cp;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;

import br.com.netservicos.core.bean.sn.SnTipoSegmentoBean;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * @hibernate.class 
 *      table = "cp_ticket_segmentacao"
 *      batch-size = "10"
 *      dynamic-update = "true"
 *      lazy = "false"
 * 
 * @hibernate.cache
 *      usage = "read-write"
 *      
 * @hibernate.query name  = "lstCpTicketSegmentacao"
 *                  query = "FROM br.com.netservicos.core.bean.cp.CpTicketSegmentacaoBean"      
 *
 * @hibernate.query name  = "lstCpTicketSegmentacaoVigente"
 *                  query = "FROM br.com.netservicos.core.bean.cp.CpTicketSegmentacaoBean bean                            
 *                           where bean.vlrCondicionalMin <= :vlrTotalMens
 *                             and bean.vlrCondicionalMax >= :vlrTotalMens
 *                             and bean.cidadeOperadora.idCidade = :cidadeOperadora.idCidade
 *                             and bean.dtInicio <= sysdate
 *                             and bean.dtFim >= sysdate"
 *                             
 * @hibernate.query 
 *      name = "lstSearchTickets" 
 *      query = "SELECT 
 *                      t.idTicket,
 *                      t.tipoSegmento.descricao,
 *                      t.vlrCondicionalMin,
 *                      t.vlrCondicionalMax,
 *                      t.dtInicio,
 *                      t.dtFim,
 *                      t.cidadeOperadora.nomeCidade
 *               FROM br.com.netservicos.core.bean.cp.CpTicketSegmentacaoBean t
 *               WHERE t.cidadeOperadora.idCidade = :cidadeOperadora.idCidade
 *               AND (:tipoSegmento.idTipoSegmento IS NULL OR t.tipoSegmento.idTipoSegmento = :tipoSegmento.idTipoSegmento)
 *               AND (:dtInicio IS NULL OR t.dtInicio >= :dtInicio)
 *               AND (:dtFim IS NULL OR t.dtFim <= :dtFim)
 *               ORDER BY t.dtInicio DESC"
 *               
 * @hibernate.query 
 *      name = "lstSearchTicketsConflitantes" 
 *      query = "FROM br.com.netservicos.core.bean.cp.CpTicketSegmentacaoBean t
 *               WHERE t.cidadeOperadora.idCidade = :cidadeOperadora.idCidade
 *               AND ((:dtInicio between t.dtInicio AND t.dtFim OR :dtFim between t.dtInicio AND t.dtFim OR (:dtInicio < t.dtInicio AND :dtFim > t.dtFim)) 
 *               AND (:vlrCondicionalMin >= t.vlrCondicionalMin AND :vlrCondicionalMin <= t.vlrCondicionalMax OR :vlrCondicionalMax >= t.vlrCondicionalMin AND :vlrCondicionalMax <= t.vlrCondicionalMax))"
 *           
 *
 * @author Bruno Borges
 */
public class CpTicketSegmentacaoBean extends DomainBean {
    public static final String LST_CP_TICKET_VIGENTE = "lstCpTicketSegmentacaoVigente";
    public static final String LST_SEARCH_TICKETS_CONFLITANTES = "lstSearchTicketsConflitantes";


    private Date dtFim;
    private Date dtInicio;
    private Long idTicket;
    private BigDecimal vlrCondicionalMax;
    private BigDecimal vlrCondicionalMin;
    private SnTipoSegmentoBean tipoSegmento;
    private CpCidadeOperadoraBean cidadeOperadora;

    public CpTicketSegmentacaoBean() {
        super("idTicket");
    }

    public CpTicketSegmentacaoBean(Long idTicket) {
        this();
        setIdTicket(idTicket);
    }

    /**
     * @hibernate.property 
     *      column = "dt_fim"
     * 
     * @return
     */
    public Date getDtFim() {
        return dtFim;
    }

    /**
     * @hibernate.property
     *      column = "dt_inicio"      
     * 
     * @return
     */
    public Date getDtInicio() {
        return dtInicio;
    }

    /**
     * @hibernate.id
     *      column = "id_ticket"
     *      generator-class = "sequence"
     * @hibernate.generator-param 
     *      name = "sequence"
     *      value = "scp_ticket_segmentacao"
     * 
     * @return
     */
    public Long getIdTicket() {
        return idTicket;
    }

    /**
     * @hibernate.property
     *      column = "vlr_condicional_max"
     * 
     * @return
     */
    public BigDecimal getVlrCondicionalMax() {
        return vlrCondicionalMax;
    }

    /**
     * @hibernate.property
     *      column = "vlr_condicional_min"
     * 
     * @return
     */
    public BigDecimal getVlrCondicionalMin() {
        return vlrCondicionalMin;
    }

    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public void setVlrCondicionalMax(BigDecimal vlrCondicionalMax) {
        this.vlrCondicionalMax = vlrCondicionalMax;
    }

    public void setVlrCondicionalMin(BigDecimal vlrCondicionalMin) {
        this.vlrCondicionalMin = vlrCondicionalMin;
    }

    public boolean equals(Object o) {
        if (o instanceof CpTicketSegmentacaoBean) {
            Long id = getIdTicket();
            Long oldId = ((CpTicketSegmentacaoBean) o).getIdTicket();
            return id != null ? id.equals(oldId) : false;
        }

        return false;
    }

    public int hashCode() {
        return new HashCodeBuilder(7, 19).append(dtInicio).append(dtFim)
                .append(vlrCondicionalMax).append(vlrCondicionalMin)
                .toHashCode();
    }
    
    
    /**
     * @hibernate.many-to-one
     *      column="id_tipo_segmento"
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
     * @hibernate.many-to-one
     *      column="id_cidade"
     * 
     * @return
     */
    public CpCidadeOperadoraBean getCidadeOperadora() {
        return cidadeOperadora;
    }

    public void setCidadeOperadora(CpCidadeOperadoraBean cidadeOperadora) {
        this.cidadeOperadora = cidadeOperadora;
    }

}