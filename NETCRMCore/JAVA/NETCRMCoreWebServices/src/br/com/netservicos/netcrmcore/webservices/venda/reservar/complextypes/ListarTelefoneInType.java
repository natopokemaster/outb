package br.com.netservicos.netcrmcore.webservices.venda.reservar.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;
import br.com.netservicos.netcrmcore.webservices.complextypes.IdentificacaoOperadoraType;

public class ListarTelefoneInType implements BaseComplexType {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6272930613410560415L;

	public ListarTelefoneInType() {
		super();
	}
	
	/**
	 * @param identificacaoOperadoraNET
	 * @param cidContrato
	 * @param dddTelefoneVoip
	 * @param numTelefoneVoipInicial
	 * @param golden
	 * @param numContrato
	 * @param idProposta
	 * @param limiteDeTelefones
	 */
	public ListarTelefoneInType(
			IdentificacaoOperadoraType identificacaoOperadoraNET,
			String cidContrato, String dddTelefoneVoip,
			String numTelefoneVoipInicial, String golden, String numContrato,
			String idProposta, String limiteDeTelefones) {
		super();
		this.identificacaoOperadoraNET = identificacaoOperadoraNET;
		this.cidContrato = cidContrato;
		this.dddTelefoneVoip = dddTelefoneVoip;
		this.numTelefoneVoipInicial = numTelefoneVoipInicial;
		this.golden = golden;
		this.numContrato = numContrato;
		this.idProposta = idProposta;
		this.limiteDeTelefones = limiteDeTelefones;
	}

	private IdentificacaoOperadoraType identificacaoOperadoraNET;
	private String cidContrato;
	private String dddTelefoneVoip;
	private String numTelefoneVoipInicial;
	private String golden;
	private String numContrato;
	private String idProposta;
	private String limiteDeTelefones;

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
	 * @return the cidContrato
	 */
	public String getCidContrato() {
		return cidContrato;
	}

	/**
	 * @param cidContrato the cidContrato to set
	 */
	public void setCidContrato(String cidContrato) {
		this.cidContrato = cidContrato;
	}

	/**
	 * @return the dddTelefoneVoip
	 */
	public String getDddTelefoneVoip() {
		return dddTelefoneVoip;
	}

	/**
	 * @param dddTelefoneVoip the dddTelefoneVoip to set
	 */
	public void setDddTelefoneVoip(String dddTelefoneVoip) {
		this.dddTelefoneVoip = dddTelefoneVoip;
	}

	/**
	 * @return the numTelefoneVoipInicial
	 */
	public String getNumTelefoneVoipInicial() {
		return numTelefoneVoipInicial;
	}

	/**
	 * @param numTelefoneVoipInicial the numTelefoneVoipInicial to set
	 */
	public void setNumTelefoneVoipInicial(String numTelefoneVoipInicial) {
		this.numTelefoneVoipInicial = numTelefoneVoipInicial;
	}

	/**
	 * @return the golden
	 */
	public String getGolden() {
		return golden;
	}

	/**
	 * @param golden the golden to set
	 */
	public void setGolden(String golden) {
		this.golden = golden;
	}

	/**
	 * @return the numContrato
	 */
	public String getNumContrato() {
		return numContrato;
	}

	/**
	 * @param numContrato the numContrato to set
	 */
	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}

	/**
	 * @return the idProposta
	 */
	public String getIdProposta() {
		return idProposta;
	}

	/**
	 * @param idProposta the idProposta to set
	 */
	public void setIdProposta(String idProposta) {
		this.idProposta = idProposta;
	}

	/**
	 * @return the limiteDeTelefones
	 */
	public String getLimiteDeTelefones() {
		return limiteDeTelefones;
	}

	/**
	 * @param limiteDeTelefones the limiteDeTelefones to set
	 */
	public void setLimiteDeTelefones(String limiteDeTelefones) {
		this.limiteDeTelefones = limiteDeTelefones;
	}
	
}
