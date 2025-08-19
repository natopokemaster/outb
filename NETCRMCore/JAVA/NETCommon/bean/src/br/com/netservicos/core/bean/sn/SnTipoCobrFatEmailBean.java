package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela sn_tipo_cobr_fat_email.
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
 *                           Prior
 * Date       By             Version  Project/CSR    Description
 * ---------- -------------- -------- -------------- ----------------------------
 * 29/09/2009 Leonar E.Inoue N/A      Faturas Email  Created.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "sn_tipo_cobr_fat_email"
 *                  dynamic-insert = "false"
 *                  dynamic-update = "false"
 * 				    lazy = "true"
 * 
 * @hibernate.cache
 *      usage="read-write"
 * 
 * @hibernate.query name  = "lstSnTipoCobrFatEmail"
 *                  query = "FROM	br.com.netservicos.core.bean.sn.SnTipoCobrFatEmailBean tipoCobrFatEmail"
 *
 * @hibernate.query name  = "lstSnTipoCobrFatEmailByCobrancaAndCidade"
 *                  query = "FROM	br.com.netservicos.core.bean.sn.SnTipoCobrFatEmailBean tipoCobrFatEmail
 *                  		where tipoCobrFatEmail.compositeKey.idTipoCobranca = :idTipoCobranca 
 *                  		and tipoCobrFatEmail.compositeKey.cidContrato = :cidContrato"
 *                   
 */

public class SnTipoCobrFatEmailBean extends DomainBean {

	private static final long serialVersionUID = 2636395672749754978L;
	
	//CONSTANTES PARA AS HQL
	public static final String LST_TIPO_COBR_FAT_EMAIL_BY_PARAMS = "lstSnTipoCobrFatEmailByCobrancaAndCidade";
	
	
	private SnTipoCobrFatEmailKey compositeKey;
	
	public SnTipoCobrFatEmailBean() {
		super("compositeKey");
	}

	
	/**
	 * @hibernate.id
	 * type = "composite"
	 * 
	 */
	public SnTipoCobrFatEmailKey getCompositeKey() {
		return compositeKey;
	}

	/**
	 * @param compositeKey The compositeKey to set.
	 * 
	 */
	public void setCompositeKey(SnTipoCobrFatEmailKey compositeKey) {
		this.compositeKey = compositeKey;
	}
}
