package br.com.netservicos.netcrmcore.webservices.prospect.manterprospect.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;
import br.com.netservicos.netcrmcore.webservices.complextypes.IdentificacaoOperadoraType;

public class DadosProspectType implements BaseComplexType {

	private static final long serialVersionUID = 4272930613410280413L;

	private IdentificacaoOperadoraType cidadeOperadora;	
	private String nome;
	private String dddTelPrincipal;
	private String telPrincipal;
	private String codHp;
	private String idTipoVenda;
	private String idCampanha;
	private String idMidia;
	private String idTipoContrato;
	private String idTipoAssinante;
	private String idTipoSegmento;

	public DadosProspectType(){
		super();
	}
	
    public IdentificacaoOperadoraType getCidadeOperadora() {
        return cidadeOperadora;
    }

    public void setCidadeOperadora(IdentificacaoOperadoraType cidadeOperadora) {
        this.cidadeOperadora = cidadeOperadora;
    }
	
	public String getIdTipoSegmento() {
        return idTipoSegmento;
    }


    public void setIdTipoSegmento(String idTipoSegmento) {
        this.idTipoSegmento = idTipoSegmento;
    }


    public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDddTelPrincipal() {
		return dddTelPrincipal;
	}


	public void setDddTelPrincipal(String dddTelPrincipal) {
		this.dddTelPrincipal = dddTelPrincipal;
	}


	public String getTelPrincipal() {
		return telPrincipal;
	}


	public void setTelPrincipal(String telPrincipal) {
		this.telPrincipal = telPrincipal;
	}


	public String getCodHp() {
		return codHp;
	}


	public void setCodHp(String codHp) {
		this.codHp = codHp;
	}

    public String getIdTipoVenda() {
        return idTipoVenda;
    }

    public void setIdTipoVenda(String idTipoVenda) {
        this.idTipoVenda = idTipoVenda;
    }

    public String getIdCampanha() {
        return idCampanha;
    }

    public void setIdCampanha(String idCampanha) {
        this.idCampanha = idCampanha;
    }

    public String getIdMidia() {
        return idMidia;
    }

    public void setIdMidia(String idMidia) {
        this.idMidia = idMidia;
    }

    public String getIdTipoContrato() {
        return idTipoContrato;
    }

    public void setIdTipoContrato(String idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public String getIdTipoAssinante() {
        return idTipoAssinante;
    }

    public void setIdTipoAssinante(String idTipoAssinante) {
        this.idTipoAssinante = idTipoAssinante;
    }  	
	
}
