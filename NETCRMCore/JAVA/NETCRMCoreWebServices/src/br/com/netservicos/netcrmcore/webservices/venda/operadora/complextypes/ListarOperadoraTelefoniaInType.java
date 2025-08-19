package br.com.netservicos.netcrmcore.webservices.venda.operadora.complextypes;

import javax.xml.bind.annotation.XmlElement;

import br.com.netservicos.framework.core.bean.BaseComplexType;
import br.com.netservicos.netcrmcore.webservices.complextypes.IdentificacaoOperadoraType;

public class ListarOperadoraTelefoniaInType implements BaseComplexType {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6272930613410560415L;

	public ListarOperadoraTelefoniaInType() {
		super();
	}

	/**
	 * @param identificacaoOperadoraNET
	 * @param numeroDDD
	 */
	public ListarOperadoraTelefoniaInType(
			IdentificacaoOperadoraType identificacaoOperadoraNET,
			Integer numeroDDD) {
		super();
		this.identificacaoOperadoraNET = identificacaoOperadoraNET;
		this.numeroDDD = numeroDDD;
	}

	IdentificacaoOperadoraType identificacaoOperadoraNET;
	@XmlElement (nillable=true, required=false)
	private Integer numeroDDD;

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
	 * @return the numeroDDD
	 */
	public Integer getNumeroDDD() {
		return numeroDDD;
	}

	/**
	 * @param numeroDDD the numeroDDD to set
	 */
	public void setNumeroDDD(Integer numeroDDD) {
		this.numeroDDD = numeroDDD;
	}

}
