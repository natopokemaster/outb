package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 *  Classe Key que representa a chave composta para a tabela sn_rel_produto_forma_envio.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- -------------------------
 * 
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                               Prior
 * Date       By                 Version  Project/CSR     Description
 * ---------- ------------------ -------- --------------  -----------------------
 * 02/04/2011 Leonardo Sugahara    N/A    Aviso de Compra Created.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class
 * 		table="sn_rel_produto_forma_envio"
 * 		schema = "PROD_JD"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true" 
 *		batch-size="10"
 *   
 */
public class SnRelProdutoFormaEnvioBean extends DomainBean {

	private static final long serialVersionUID = -6458923466734665204L;

	public static final String COMPOSITE_KEY = "compositeKey";
	
	/**
	 * Entidade que representa as chaves primarias da tabela sn_rel_produto_forma_envio.
	 */
	private SnRelProdutoFormaEnvioKey compositeKey;
	
	/**
	 * NR_ORDEM NUMBER(3) N. Identificador no numero da ordem.
	 */
	private Integer nrOrdem;
	
	/**
	 * Construtor padrao.
	 */
	public SnRelProdutoFormaEnvioBean() {
		super(COMPOSITE_KEY);
	}

	/**
	 * Recupera as chaves compostas da tabela sn_rel_produto_forma_envio.
	 * 
	 * @return Returns the compositeKey.
	 * @hibernate.id
	 * type = "composite"
	 * 
	 */
	public SnRelProdutoFormaEnvioKey getCompositeKey() {
		return compositeKey;
	}

	/**
	 * @param compositeKey The compositeKey to set.
	 * 
	 */
	public void setCompositeKey(SnRelProdutoFormaEnvioKey compositeKey) {
		this.compositeKey = compositeKey;
	}

	/**
	 * Recupera o numero da ordem.
	 * 
	 * @return Returns the nrOrdem.
	 *
	 * @hibernate.property 
	 * 		column = "nr_ordem"
	 * 		type="integer"
	 */
	public Integer getNrOrdem() {
		return nrOrdem;
	}

	/**
	 * @param nrOrdem The nrOrdem to set.
	 */
	public void setNrOrdem(Integer nrOrdem) {
		this.nrOrdem = nrOrdem;
	}
	
}
