package br.com.netservicos.netcrmcore.webservices.prospect.manterprospect.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class DadosProspectRetornoType implements BaseComplexType {

	private static final long serialVersionUID = -2666878924314523941L;

    private Long idProspect;
    private Long idProposta;

	public Long getIdProspect() {
		return idProspect;
	}

	public void setIdProspect(Long idProspect) {
		this.idProspect = idProspect;
	}

	public Long getIdProposta() {
		return idProposta;
	}

	public void setIdProposta(Long idProposta) {
		this.idProposta = idProposta;
	}
    
	
	
	    
}
