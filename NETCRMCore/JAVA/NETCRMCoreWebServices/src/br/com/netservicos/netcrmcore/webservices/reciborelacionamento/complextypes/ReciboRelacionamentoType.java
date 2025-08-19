package br.com.netservicos.netcrmcore.webservices.reciborelacionamento.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class ReciboRelacionamentoType implements BaseComplexType {

	private static final long serialVersionUID = 8779539600000279381L;
	
	private Object xmlReciboRelacionamento;

	public Object getXmlReciboRelacionamento() {
		return xmlReciboRelacionamento;
	}

	public void setXmlReciboRelacionamento(Object xmlReciboRelacionamento) {
		this.xmlReciboRelacionamento = xmlReciboRelacionamento;
	}
}
