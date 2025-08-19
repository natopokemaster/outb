package br.com.netservicos.netcrmcore.webservices.manutencaodadoscobranca.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class RegistroEventoDadoCobrancaType implements BaseComplexType {

	private static final long serialVersionUID = -2666878924347728431L;

    private String protocolo;
    private String numeroChamado;
    private String nomeContato;
    private String formaContato;
    private String identificador;
    
	public String getProtocolo() {
		return protocolo;
	}
	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}
	public String getNumeroChamado() {
		return numeroChamado;
	}
	public void setNumeroChamado(String numeroChamado) {
		this.numeroChamado = numeroChamado;
	}
	public String getNomeContato() {
		return nomeContato;
	}
	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}
	public String getFormaContato() {
		return formaContato;
	}
	public void setFormaContato(String formaContato) {
		this.formaContato = formaContato;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
    
}
