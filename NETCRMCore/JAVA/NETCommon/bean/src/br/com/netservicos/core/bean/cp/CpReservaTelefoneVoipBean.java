package br.com.netservicos.core.bean.cp;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * @hibernate.class table = "cp_reserva_telefone_voip" batch-size = "10"
 *                  dynamic-update = "true" lazy="false"
 * 
 * 
 * @author Bruno Borges
 * 
 * @hibernate.query name  = "lstReservaTelByDddTel"
 *                 query = "SELECT reserva.idVoip 
 *                          FROM br.com.netservicos.core.bean.cp.CpReservaTelefoneVoipBean reserva
 *                          WHERE reserva.ddd = :ddd
 *                          AND reserva.telefone = :telefone"
 *                          
 * @hibernate.query name  = "findReservaTelByDddTel"
 *                 query = "SELECT reserva 
 *                          FROM br.com.netservicos.core.bean.cp.CpReservaTelefoneVoipBean reserva
 *                          WHERE reserva.ddd = :ddd
 *                          AND reserva.telefone = :telefone"
 *                          
 * @hibernate.query name  = "lstReservaTelByIdPonto"
 *                 query = "SELECT reserva.idVoip 
 *                          FROM br.com.netservicos.core.bean.cp.CpReservaTelefoneVoipBean reserva
 *                          WHERE reserva.ponto.idPonto = :idPonto"
 * 
 * @hibernate.query name  = "lstReservaTelByIdPontoAssinante"
 *                 query = "SELECT reserva.idVoip 
 *                          FROM br.com.netservicos.core.bean.cp.CpReservaTelefoneVoipBean reserva
 *                          WHERE reserva.pontoAssinante.idPontoAssinante = :idPontoAssinante"
 *                          
 * @hibernate.query name  = "listReservaTelByIdPontoAssinante"
 *                 query = "select reserva from
 *                              br.com.netservicos.core.bean.cp.CpReservaTelefoneVoipBean reserva
 *                              inner join reserva.pontoAssinante pontoAssinante
 *                          WHERE
 *                              pontoAssinante.idPontoAssinante = :idPontoAssinante"
 *                          
 * @hibernate.query
 * 					name = "lstReservaTelefoneByIdPontoAssinante"
 * 					query = "from CpReservaTelefoneVoipBean rt
 * 							 where
 * 								rt.pontoAssinante.idPontoAssinante = :idPontoAssinantePrincipal"                          
 *                                                   
 * 
 * @hibernate.query name = "lstTelefonesReservadosAssinante"
 *                  query = "SELECT
 *                              reserva.telefone
 *                          FROM
 *                              br.com.netservicos.core.bean.cp.CpReservaTelefoneVoipBean reserva
 *                          WHERE
 *                              reserva.pontoAssinante.solicitacaoAssinante.dtCancelamento is NULL AND
 *                              reserva.pontoAssinante.solicitacaoAssinante.propostaAssinante.dtVenda is NULL AND
 *                              reserva.pontoAssinante.solicitacaoAssinante.propostaAssinante.idPropostaAssinante = :propostaAssinante.idPropostaAssinante"
 *
 * @hibernate.query name = "lstTelefonesReservadosProposta"
 *                  query = "SELECT
 *                              reserva.telefone
 *                          FROM
 *                              br.com.netservicos.core.bean.cp.CpReservaTelefoneVoipBean reserva
 *                          WHERE
 *                              reserva.ponto.proposta.idProposta = :idProposta"
 *
 * @hibernate.query 
 * 					name = "lstDeleteReservasByPontoAssinante" 
 * 					query = "from CpReservaTelefoneVoipBean rt
 * 							 where 
 * 								rt.ddd = :reservaTelefone.ddd and
 * 							 	rt.telefone = :reservaTelefone.telefone and
 * 								rt.pontoAssinante.idPontoAssinante = :idPontoAssinante"
 */
public class CpReservaTelefoneVoipBean extends DomainBean {
	
    private static final long serialVersionUID = -8716591466923452406L;
    private String ddd;
    private Long idVoip;
    private CpPontoBean ponto;
    private String telefone;
    private Integer publicar;
    private String nomePublicar;
    private CpPontoAssinanteBean pontoAssinante;
    
    public CpReservaTelefoneVoipBean() {
        super("idVoip");
    }

    public CpReservaTelefoneVoipBean(Long idVoip) {
        this();
        setIdVoip(idVoip);
    }
    
    /**
     * @hibernate.property 
     * @return
     */
    public String getDdd() {
        return ddd;
    }
    
    /**
     * @hibernate.property 
     * @return
     */
    public Integer getPublicar() {
        return publicar;
    }
    
    /**
     * @hibernate.property
     *      column = "nome_publicar" 
     * @return
     */
    public String getNomePublicar() {
        return nomePublicar;
    }

    /**
     * @hibernate.id
     *      column = "id_voip"
     *      generator-class = "sequence"
     * @hibernate.generator-param 
     *      name = "sequence"
     *      value = "scp_reserva_telefone_voip"
     *      
     * @return
     */
    public Long getIdVoip() {
        return idVoip;
    }
    
    /**
     * 
     * @param idVoip
     */
    public void setIdVoip(Long idVoip) {
    	this.idVoip = idVoip;
    }
    
    /**
     * @hibernate.many-to-one
     *      column="id_ponto_assinante"
     *      cascade = "none"
     * 
     * @return
     */
    public CpPontoAssinanteBean getPontoAssinante() {
		return pontoAssinante;
	}

	public void setPontoAssinante(CpPontoAssinanteBean pontoAssinante) {
		this.pontoAssinante = pontoAssinante;
	}

    /**
     * @hibernate.many-to-one
     *      column="id_ponto"
     *      cascade = "none"
     * 
     * @return
     */
    public CpPontoBean getPonto() {
        return ponto;
    }

	/**
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 * column="telefone"
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone The telefone to set.
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @param ddd The ddd to set.
	 */
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	/**
	 * @param nomePublicar The nomePublicar to set.
	 */
	public void setNomePublicar(String nomePublicar) {
		this.nomePublicar = nomePublicar;
	}

	/**
	 * @param ponto The ponto to set.
	 */
	public void setPonto(CpPontoBean ponto) {
		this.ponto = ponto;
	}

	/**
	 * @param publicar The publicar to set.
	 */
	public void setPublicar(Integer publicar) {
		this.publicar = publicar;
	}
    
    
}