package br.com.netservicos.netcrmcore.webservices.venda.reservar.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;
import br.com.netservicos.netcrmcore.webservices.complextypes.IdentificacaoOperadoraType;

public class ReservarTelefoneInType implements BaseComplexType {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6272930613410560415L;

	
	private IdentificacaoOperadoraType cidadeOperadora;
	private String idProposta;
	private String publicaNumero;
	private DadosReservaTelefoneInType[] dadosReservaTelefone;
	
    public IdentificacaoOperadoraType getCidadeOperadora() {
        return cidadeOperadora;
    }
    public void setCidadeOperadora(IdentificacaoOperadoraType cidadeOperadora) {
        this.cidadeOperadora = cidadeOperadora;
    }
    public String getIdProposta() {
        return idProposta;
    }
    public void setIdProposta(String idProposta) {
        this.idProposta = idProposta;
    }
    public String getPublicaNumero() {
        return publicaNumero;
    }
    public void setPublicaNumero(String publicaNumero) {
        this.publicaNumero = publicaNumero;
    }
    public DadosReservaTelefoneInType[] getDadosReservaTelefone() {
        return dadosReservaTelefone;
    }
    public void setDadosReservaTelefone(DadosReservaTelefoneInType[] dadosReservaTelefone) {
        this.dadosReservaTelefone = dadosReservaTelefone;
    }
	
    	
	
	
		
    
	
}
