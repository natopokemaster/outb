package br.com.netservicos.netcrmcore.webservices.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class IdentificacaoOperadoraType implements BaseComplexType {

	private static final long serialVersionUID = 4272930613410280413L;

	private String codigoOperadora; 
	private String identificacaoCidade;

	public IdentificacaoOperadoraType(){
		super();
	}
	
	/**
	 * @param codigoOperadora
	 * @param identificacaoCidade
	 */
	public IdentificacaoOperadoraType(String codigoOperadora, String identificacaoCidade) {
		super();
		this.codigoOperadora = codigoOperadora;
		this.identificacaoCidade = identificacaoCidade;
	}

	/**
	 * @return the codigoOperadora
	 */
	public String getCodigoOperadora() {
		return codigoOperadora;
	}

	/**
	 * @param codigoOperadora the codigoOperadora to set
	 */
	public void setCodigoOperadora(String codigoOperadora) {
		this.codigoOperadora = codigoOperadora;
	}

	/**
	 * @return the identificacaoCidade
	 */
	public String getIdentificacaoCidade() {
		return identificacaoCidade;
	}

	/**
	 * @param identificacaoCidade the identificacaoCidade to set
	 */
	public void setIdentificacaoCidade(String identificacaoCidade) {
		this.identificacaoCidade = identificacaoCidade;
	}
}
