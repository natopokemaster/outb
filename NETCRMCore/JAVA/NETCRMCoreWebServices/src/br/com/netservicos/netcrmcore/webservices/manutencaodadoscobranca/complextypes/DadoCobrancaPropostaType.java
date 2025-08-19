package br.com.netservicos.netcrmcore.webservices.manutencaodadoscobranca.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class DadoCobrancaPropostaType implements BaseComplexType {

	private static final long serialVersionUID = -694746599674934214L;

	public DadoCobrancaPropostaType(){
		super();
	}
	
	public DadoCobrancaPropostaType(String numeroProposta, String identificacaoCidade, Long idTipoPostagem){
		this.numeroProposta = numeroProposta;
		this.identificacaoCidade = identificacaoCidade;
		this.idTipoPostagem = idTipoPostagem;
	}
	
	private String numeroProposta;
    private String identificacaoCidade;
    private Long idTipoPostagem;
    
	public String getNumeroProposta() {
		return numeroProposta;
	}
	public void setNumeroProposta(String numeroProposta) {
		this.numeroProposta = numeroProposta;
	}
	public String getIdentificacaoCidade() {
		return identificacaoCidade;
	}
	public void setIdentificacaoCidade(String identificacaoCidade) {
		this.identificacaoCidade = identificacaoCidade;
	}
	public Long getIdTipoPostagem() {
		return idTipoPostagem;
	}
	public void setIdTipoPostagem(Long idTipoPostagem) {
		this.idTipoPostagem = idTipoPostagem;
	}
    
    
}
