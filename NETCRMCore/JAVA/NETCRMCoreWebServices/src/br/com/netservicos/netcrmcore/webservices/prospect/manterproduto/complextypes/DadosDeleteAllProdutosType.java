package br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;
import br.com.netservicos.netcrmcore.webservices.complextypes.IdentificacaoOperadoraType;

public class DadosDeleteAllProdutosType implements BaseComplexType {
	
	private static final long serialVersionUID = -6184032207048508314L;

	private IdentificacaoOperadoraType cidadeOperadora;
	private Long idProposta;
	
	/**
	 * Construtor Padrão.
	 */
	public DadosDeleteAllProdutosType(){
		super();
	}

	/**
	 * @return the cidadeOperadora
	 */
	public IdentificacaoOperadoraType getCidadeOperadora() {
		return cidadeOperadora;
	}

	/**
	 * @param cidadeOperadora the cidadeOperadora to set
	 */
	public void setCidadeOperadora(IdentificacaoOperadoraType cidadeOperadora) {
		this.cidadeOperadora = cidadeOperadora;
	}
	
	/**
	 * @return the idProposta
	 */
	public Long getIdProposta() {
		return idProposta;
	}

	/**
	 * @param idProposta the idProposta to set
	 */
	public void setIdProposta(Long idProposta) {
		this.idProposta = idProposta;
	}
}
