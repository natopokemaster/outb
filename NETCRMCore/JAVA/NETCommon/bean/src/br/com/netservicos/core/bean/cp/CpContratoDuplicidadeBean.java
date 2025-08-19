package br.com.netservicos.core.bean.cp;

import br.com.netservicos.framework.core.bean.DomainBean;

/**  
 	 * @hibernate.class table="cp_contrato_duplicidade"
	 *                  dynamic-insert="true"
	 *                  dynamic-update="true"
	 *                  lazy="true" 
	 *					batch-size="10"
	 *                  
	 *      
	 * @hibernate.query name="lstContratoDuplicidadeToDelete"
	 * 					query="select 
	 * 								pp.idContratoDuplicidade
	 * 							from
	 * 								br.com.netservicos.core.bean.cp.CpContratoDuplicidadeBean pp
	 * 					     where
	 * 							pp.proposta.idProposta = :idProposta"
	 * 
	 * @hibernate.query name="lstContratoDuplicidadeProposta"
	 * 					query="from
	 * 								br.com.netservicos.core.bean.cp.CpContratoDuplicidadeBean pp
	 * 					      where
	 * 							    pp.proposta.idProposta = :idProposta"
	 * 
     * @hibernate.query name="lstVariacaoPendenciaDuplicidadeCpfCnpj"
	 * 					query="SELECT cpv.descricao		        
  	 *							FROM   br.com.netservicos.core.bean.cp.CpRelPendenciaPropostaBean crpp,
     * 								   br.com.netservicos.core.bean.cp.CpRelPendenciasVariacoesBean crpv,
     *  							   br.com.netservicos.core.bean.cp.CpPendenciasVariacoesBean cpv
 	 *							WHERE  crpp.pendenciaVariacao.idPendVariacao = crpv.idPendVariacao
   	 *								  AND crpv.pendenciasVariacoes.idVariacao  = cpv.idVariacao
     * 								  AND crpp.proposta.idProposta  = :proposta.idProposta
     * 								  AND crpp.pendencia.idPendencia = :pendencia.idPendencia"      
     *                            
	 * @hibernate.query name="lstContratoDuplicidadeCpf"
	 * 					query="SELECT ccd.numContrato, ccd.nmCidade, ccd.nmAssinante, ccd.dsStatus		        
  	 *							FROM   br.com.netservicos.core.bean.cp.CpContratoDuplicidadeBean ccd
  	 *							WHERE ccd.proposta.idProposta = :proposta.idProposta
   	 *								  AND ccd.idCidade   = :proposta.cidadeOperadora.idCidade"                                                                               
	 *                                            
*/

public class CpContratoDuplicidadeBean extends DomainBean {
	
	/**
	 * 
	 * construtor padrão
	 */
	public CpContratoDuplicidadeBean(String arg0) {
		super("idContratoDuplicidade");
	}
	
	public CpContratoDuplicidadeBean() {
		super("idContratoDuplicidade");
	}
 
	private static final long serialVersionUID = 1L;
	private Long idContratoDuplicidade;
    private CpPropostaBean proposta;
    private Long numContrato;
    private String nmCidade;
    private String idCidade;
    private String nmAssinante;
    private Long idPendencia;
    private String dsStatus;
    

	/**
	 * @hibernate.property
	 * 			column="id_pendencia"
	 * @return
	 */
	public Long getIdPendencia() {
		return idPendencia;
	}
	public void setIdPendencia(Long idPendencia) {
		this.idPendencia = idPendencia;
	}
	
	 /**
     * @hibernate.many-to-one
     *      column="id_proposta"
     * @return
     */
	public CpPropostaBean getProposta() {
		return proposta;
	}

	public void setProposta(CpPropostaBean proposta) {
		this.proposta = proposta;
	}
	
	/**
	 * @hibernate.property
	 * 			column="ds_status"
	 * @return
	 */
	public String getDsStatus() {
		return dsStatus;
	}

	public void setDsStatus(String dsStatus) {
		this.dsStatus = dsStatus;
	}
	
	/**
	 * @hibernate.property
	 * 			column="id_cidade"
	 * @return
	 */
	public String getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(String idCidade) {
		this.idCidade = idCidade;
	}
	
	/**
	 * @hibernate.property
	 * 			column="nm_assinante"
	 * @return
	 */
	public String getNmAssinante() {
		return nmAssinante;
	}

	public void setNmAssinante(String nmAssinante) {
		this.nmAssinante = nmAssinante;
	}
	
	/**
	 * @hibernate.property
	 * 			column="nm_cidade"
	 * @return
	 */
	public String getNmCidade() {
		return nmCidade;
	}

	public void setNmCidade(String nmCidade) {
		this.nmCidade = nmCidade;
	}
	
	/**
	 * @hibernate.property
	 * 			column="num_contrato"
	 * @return
	 */
	public Long getNumContrato() {
		return numContrato;
	}

	public void setNumContrato(Long numContrato) {
		this.numContrato = numContrato;
	}

	/**
     * @hibernate.id
     * 		column="id_contrato_duplicidade"	
     * 		generator-class="sequence"
     * @hibernate.generator-param
     *      name="sequence"
     *      value="sqcp_contrato_duplicidade"
     * @return
     */
	public Long getIdContratoDuplicidade() {
		return idContratoDuplicidade;
	}
	public void setIdContratoDuplicidade(Long idContratoDuplicidade) {
		this.idContratoDuplicidade = idContratoDuplicidade;
	}

}
