package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>Description :</B><BR>
 * Classe Bean que representa a tabela sn_ddd_operadora_telefonia
 * </P>
 * <P>
 * <B> Issues : <BR>
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- ------------------------
 * 
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                           Prior
 * Date       By             Version  Project/CSR    	Description
 * ---------- -------------- -------- --------------    -------------------------
 * 04/10/2010 Márcio Dantas  N/A      NetCombo           Criação
 * ==============================================================================
 * </PRE>
 *
 * @author marcio@mdantas.com.br
 * @since 04/10/2010
 * @version $Revision: 1.2 $
 * 
 * @hibernate.class 
 * 		table="sn_ddd_operadora_telefonia"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true" 
 *		batch-size="10"
 *
 * @hibernate.cache
 *		usage="read-only"
 */
public class SnDddOperadoraTelefoniaBean extends DomainBean {

	private static final long serialVersionUID = -3617106157918283418L;
	public static final String PRIMARY_KEY = "compositeKey";

	private SnDddOperadoraTelefoniaKey compositeKey;

	public SnDddOperadoraTelefoniaBean() {
		super(PRIMARY_KEY);
	}

	/**
	 * @return Returns the compositeKey.
	 *
	 * @hibernate.id
	 * 		type="composite"
	 */
	public SnDddOperadoraTelefoniaKey getCompositeKey() {
		return compositeKey;
	}

	/**
	 * @param compositeKey 
	 *				The compositeKey to set.
	 */
	public void setCompositeKey(SnDddOperadoraTelefoniaKey compositeKey) {
		this.compositeKey = compositeKey;
	}

}
