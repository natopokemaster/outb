package br.com.netservicos.netcrmcore.webservices.manutencaoextensaofone.complextypes;


public class ParametrosSolicitarExtensaoFoneType {
	
	private IdentificadorContratoType identificadorContrato;
	
	private DadosExtensaoFoneType dadosExtensaoFone;

	public IdentificadorContratoType getIdentificadorContrato() {
		return identificadorContrato;
	}

	public void setIdentificadorContrato(
			IdentificadorContratoType identificadorContrato) {
		this.identificadorContrato = identificadorContrato;
	}

	public DadosExtensaoFoneType getDadosExtensaoFone() {
		return dadosExtensaoFone;
	}

	public void setDadosExtensaoFone(DadosExtensaoFoneType dadosExtensaoFone) {
		this.dadosExtensaoFone = dadosExtensaoFone;
	}

}
