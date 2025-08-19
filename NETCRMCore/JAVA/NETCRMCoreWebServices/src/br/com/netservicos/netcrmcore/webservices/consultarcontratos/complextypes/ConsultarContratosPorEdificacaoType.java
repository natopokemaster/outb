package br.com.netservicos.netcrmcore.webservices.consultarcontratos.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class ConsultarContratosPorEdificacaoType implements BaseComplexType {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4272930613410280413L;

	public ConsultarContratosPorEdificacaoType(){
		super();
	}
	
	/**
	 * @param identificacaoOperadoraNET
	 * @param codigoImovel
	 * @param codigoHP
	 */
	public ConsultarContratosPorEdificacaoType(
			IdentificacaoOperadoraType identificacaoOperadoraNET,
			String codigoImovel, String codigoHP) {
		super();
		this.identificacaoOperadoraNET = identificacaoOperadoraNET;
		this.codigoImovel = codigoImovel;
		this.codigoHP = codigoHP;
	}

	private IdentificacaoOperadoraType identificacaoOperadoraNET; //operadoraNET
	private String codigoImovel; //edificação
	private String codigoHP; //domicilio

	/**
	 * @return the identificacaoOperadoraNET
	 */
	public IdentificacaoOperadoraType getIdentificacaoOperadoraNET() {
		return identificacaoOperadoraNET;
	}

	/**
	 * @param identificacaoOperadoraNET the identificacaoOperadoraNET to set
	 */
	public void setIdentificacaoOperadoraNET(
			IdentificacaoOperadoraType identificacaoOperadoraNET) {
		this.identificacaoOperadoraNET = identificacaoOperadoraNET;
	}

	/**
	 * @return the codigoImovel
	 */
	public String getCodigoImovel() {
		return codigoImovel;
	}

	/**
	 * @param codigoImovel the codigoImovel to set
	 */
	public void setCodigoImovel(String codigoImovel) {
		this.codigoImovel = codigoImovel;
	}

	/**
	 * @return the codigoHP
	 */
	public String getCodigoHP() {
		return codigoHP;
	}

	/**
	 * @param codigoHP the codigoHP to set
	 */
	public void setCodigoHP(String codigoHP) {
		this.codigoHP = codigoHP;
	}
	
}
