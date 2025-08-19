package br.com.netservicos.core.bean.geo;

import br.com.netservicos.framework.core.bean.WebBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela geo_tecnico_equipe_ri.
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
 * 06/06/2005 Ramon Carvalho N/A      Entidades      Created.
 * 06/06/2005 Ramon Carvalho 1.0      Entidades      Development.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "geo_tecnico_equipe_ri"
 *                   dynamic-insert = "true"
 *                   dynamic-update = "true"
 *  					proxy="br.com.netservicos.core.bean.geo.GeoTecnicoEquipeRiBean"
 * 					lazy="true" 
 *
 * @hibernate.query name  = "lstGeoTecnicoEquipeRi"
 *                   query = "FROM 	br.com.netservicos.core.bean.geo.GeoTecnicoEquipeRiBean as bean"
 *
 * @hibernate.query name  = "lstGeoTecnicoEquipeRiByIdPessoa"
 *                   query = "FROM 	br.com.netservicos.core.bean.geo.GeoTecnicoEquipeRiBean as bean
 *                   		 WHERE  bean.compositeKey.idPessoa = :idPessoa"
 *
 * @hibernate.query name  = "lstGeoTecnicoEquipeRiByPrimary"
 *                   query = "SELECT equipe
 *                   		 FROM 	br.com.netservicos.core.bean.geo.GeoTecnicoEquipeRiBean tecnicoEquipe,
 *                   				br.com.netservicos.core.bean.geo.GeoEquipeRiBean equipe
 *                   		 WHERE  tecnicoEquipe.compositeKey.idEquipeRi = equipe.idEquipeRi
 *                   		   AND  tecnicoEquipe.compositeKey.ciCodigo = equipe.ciCodigo
 *                   		   AND  tecnicoEquipe.compositeKey.idPessoa = :primaryKey"
 * 
 */
public class GeoTecnicoEquipeRiBean extends WebBean {

	private GeoTecnicoEquipeRiKey compositeKey;

	public GeoTecnicoEquipeRiBean() {
		super("compositeKey");
	}

	/**
	 * @hibernate.id
	 * type = "composite"
	 */
	public GeoTecnicoEquipeRiKey getCompositeKey() {
		return compositeKey;
	}

	public void setCompositeKey(GeoTecnicoEquipeRiKey compositeKey) {
		this.compositeKey = compositeKey;
	}

	public boolean equals(Object bean) {
		if (bean instanceof GeoTecnicoEquipeRiBean) {
			return compositeKey
					.equals(((GeoTecnicoEquipeRiBean) bean).compositeKey);
		} else {
			return false;
		}
	}

}
