package br.com.netservicos.netcrmcore.webservices.manutencaoextensaofone.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class ResultadoSolicitarType implements BaseComplexType {

	private static final long serialVersionUID = 7024256704328460200L;

	private String[] codigoOrdemCampo = new String[] {};

	public String[] getCodigoOrdemCampo() {
		return codigoOrdemCampo;
	}

	public void setCodigoOrdemCampo(String[] codigosOrdemCampo) {
		if (codigosOrdemCampo == null) {
			this.codigoOrdemCampo = new String[] {};
		}else{
			this.codigoOrdemCampo = codigosOrdemCampo.clone();			
		}
	}	
	
}
