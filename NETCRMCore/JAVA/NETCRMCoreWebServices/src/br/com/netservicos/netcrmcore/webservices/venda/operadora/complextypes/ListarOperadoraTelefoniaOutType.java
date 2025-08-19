package br.com.netservicos.netcrmcore.webservices.venda.operadora.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class ListarOperadoraTelefoniaOutType implements BaseComplexType {

	private static final long serialVersionUID = -2666878924314523941L;
	
    /**
	 * 
	 */
	public ListarOperadoraTelefoniaOutType() {
		super();
	}
	
	/**
	 * @param codigoOperadoraTelefonia
	 * @param nomeOperadoraTelefonia
	 * @param produtoEBT
	 * @param numeroDDD
	 */
	public ListarOperadoraTelefoniaOutType(Integer codigoOperadoraTelefonia,
			String nomeOperadoraTelefonia, String produtoEBT, String numeroDDD) {
		super();
		this.codigoOperadoraTelefonia = codigoOperadoraTelefonia;
		this.nomeOperadoraTelefonia = nomeOperadoraTelefonia;
		this.produtoEBT = produtoEBT;
		this.numeroDDD = numeroDDD;
	}

	private Integer codigoOperadoraTelefonia;
    private String nomeOperadoraTelefonia;
    private String produtoEBT;
    private String numeroDDD;

	/**
	 * @return the codigoOperadoraTelefonia
	 */
	public Integer getCodigoOperadoraTelefonia() {
		return codigoOperadoraTelefonia;
	}

	/**
	 * @param codigoOperadoraTelefonia the codigoOperadoraTelefonia to set
	 */
	public void setCodigoOperadoraTelefonia(Integer codigoOperadoraTelefonia) {
		this.codigoOperadoraTelefonia = codigoOperadoraTelefonia;
	}

	/**
	 * @return the nomeOperadoraTelefonia
	 */
	public String getNomeOperadoraTelefonia() {
		return nomeOperadoraTelefonia;
	}

	/**
	 * @param nomeOperadoraTelefonia the nomeOperadoraTelefonia to set
	 */
	public void setNomeOperadoraTelefonia(String nomeOperadoraTelefonia) {
		this.nomeOperadoraTelefonia = nomeOperadoraTelefonia;
	}

	/**
	 * @return the produtoEBT
	 */
	public String getProdutoEBT() {
		return produtoEBT;
	}

	/**
	 * @param produtoEBT the produtoEBT to set
	 */
	public void setProdutoEBT(String produtoEBT) {
		this.produtoEBT = produtoEBT;
	}

	/**
	 * @return the numeroDDD
	 */
	public String getNumeroDDD() {
		return numeroDDD;
	}

	/**
	 * @param numeroDDD the numeroDDD to set
	 */
	public void setNumeroDDD(String numeroDDD) {
		this.numeroDDD = numeroDDD;
	}

}
