package br.com.netservicos.netcrmcore.webservices.avisorelacionamento.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class DadosSolicitarReenvioAvisoRelacionamentoRetornoType implements BaseComplexType {

	private static final long serialVersionUID = -2666878924314523941L;
	
	private Long idReenvio;

	/**
	 * @return the idReenvio
	 */
	public Long getIdReenvio() {
		return idReenvio;
	}

	/**
	 * @param idReenvio the idReenvio to set
	 */
	public void setIdReenvio(Long idReenvio) {
		this.idReenvio = idReenvio;
	}
}
