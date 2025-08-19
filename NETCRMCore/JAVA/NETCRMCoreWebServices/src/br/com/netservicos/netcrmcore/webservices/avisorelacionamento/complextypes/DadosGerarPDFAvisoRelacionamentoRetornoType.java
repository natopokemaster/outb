package br.com.netservicos.netcrmcore.webservices.avisorelacionamento.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class DadosGerarPDFAvisoRelacionamentoRetornoType implements BaseComplexType {

	private static final long serialVersionUID = -2666878924314523941L;
	
	private byte[] pdf;
	private Object xml;

	/**
	 * @return the pdf
	 */
	public byte[] getPdf() {
		return pdf;
	}

	/**
	 * @param pdf the pdf to set
	 */
	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}

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
