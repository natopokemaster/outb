package br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;
import br.com.netservicos.netcrmcore.webservices.complextypes.IdentificacaoOperadoraType;

public class DadosDeleteLstProdutosType implements BaseComplexType {
	
	private static final long serialVersionUID = 6097190291989870750L;

	private IdentificacaoOperadoraType cidadeOperadora;	
	private Long idProposta;
	private Long[] lstIdProduto;
	
	/**
	 * Construtor Padrão.
	 */
	public DadosDeleteLstProdutosType(){
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

	/**
	 * @return the lstIdProduto
	 */
	public Long[] getLstIdProduto() {
		return lstIdProduto;
	}

	/**
	 * @param lstIdProduto the lstIdProduto to set
	 */
	public void setLstIdProduto(Long[] lstIdProduto) {
		this.lstIdProduto = lstIdProduto;
	}
}
