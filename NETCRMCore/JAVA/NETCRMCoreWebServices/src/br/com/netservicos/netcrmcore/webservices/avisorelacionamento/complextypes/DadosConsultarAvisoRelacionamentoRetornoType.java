package br.com.netservicos.netcrmcore.webservices.avisorelacionamento.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class DadosConsultarAvisoRelacionamentoRetornoType implements BaseComplexType {

	private static final long serialVersionUID = -2666878924314523941L;
	
	private Object xml;

	/**
	 * @return the xml
	 */
	public Object getXml() {
		return xml;
	}

	/**
	 * @param xml the xml to set
	 */
	public void setXml(Object xml) {
		this.xml = xml;
	}
}
