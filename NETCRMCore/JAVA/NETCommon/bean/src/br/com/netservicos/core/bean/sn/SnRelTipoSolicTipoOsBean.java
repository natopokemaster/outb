package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * 
 * @hibernate.class table = "sn_rel_tipo_solic_tipo_os"
 *                   dynamic-insert = "true"
 *                   dynamic-update = "true"
 *                   lazy="true"
 *                   proxy="br.com.netservicos.core.bean.sn.SnRelTipoSolicTipoOsBean"
 *                   
 * @hibernate.query name = "lstSnRelTipoSolicTipoOsBean"
 * 					query = "FROM br.com.netservicos.core.bean.sn.SnRelTipoSolicTipoOsBean bean                   
 * 
 * @hibernate.query name = "lstCountSnRelTipoSolicTipoOs"                   
 * 					query = "	SELECT COUNT(*)
 * 								FROM br.com.netservicos.core.bean.sn.SnRelTipoSolicTipoOsBean bean
 * 								WHERE bean.compositeKey.tipoSolicProd.idTipoSolicProd = :idTipoSolicProd"
 * 
 * @hibernate.query name = "listarIdTipoOs"
 * 					query = "SELECT snRelTipoSolicTipoOsBean.compositeKey.tipoOs.idTipoOs 
 * 							 FROM br.com.netservicos.core.bean.sn.SnRelTipoSolicTipoOsBean snRelTipoSolicTipoOsBean,
 * 							 br.com.netservicos.core.bean.sn.SnTipoSolicProdBean snTipoSolicProdBean
 * 							 WHERE snRelTipoSolicTipoOsBean.compositeKey.tipoSolicProd.idTipoSolicProd = snTipoSolicProdBean.idTipoSolicProd
 * 							 AND snTipoSolicProdBean.tipoSolic.idTipoSolic IN(:listaIdTipoSolict)
 * 							 AND snTipoSolicProdBean.produtoDe IN(:listaProdutoDe)
 * 							 AND snTipoSolicProdBean.produtoPara IN(:listaProdutoPara)"
 * 
 * 
 * @hibernate.query name = "listarIdTipoOsProspect"
 * 					query = "select c.compositeKey.tipoOs.idTipoOs 
 * 							 from 
 * 							 br.com.netservicos.core.bean.cp.CpPontoBean p,
 * 							 br.com.netservicos.core.bean.cp.CpTipoPontoBean tp,
 * 							 br.com.netservicos.core.bean.sn.SnRelTipoSolicTipoOsBean c,
 * 							 br.com.netservicos.core.bean.sn.SnTipoSolicProdBean d
 * 							 where p.proposta.idProposta = :idProposta
 * 							 and p.tipoPonto.idTipoPonto = tp.idTipoPonto
 * 							 and p.produto.idProduto = d.produtoPara.idProduto
 * 							 and d.produtoDe = 999
 * 							 and d.tipoSolic.idTipoSolic = decode(tp.idTipoPonto,5,1,6,2)
 * 							 and d.tipoRelacionamento.idTipoRelacionamento in (1,3)
 *							 and d.idTipoSolicProd = c.compositeKey.tipoSolicProd.idTipoSolicProd
 *							 and p.tipoPonto.idTipoPonto in (5,6)"
 * 
 * 
 * 
 */
public class SnRelTipoSolicTipoOsBean extends DomainBean {

	public static final String LST_SN_REL_TIPO_SOLIC_TIPO_OS = "lstSnRelTipoSolicTipoOsBean";
	
	/** Constante que representa a query listarIdTipoOs */
	public static final String LISTA_ID_TIPO_OS = "listarIdTipoOs";
	
	public static final String LISTA_ID_TIPO_OS_PROSPECT = "listarIdTipoOsProspect";

	private SnRelTipoSolicTipoOsKey compositeKey;

	public SnRelTipoSolicTipoOsBean() {
		super("compositeKey");
	}

	/**
	 * @hibernate.id
	 * type = "composite"
	 * 
	 * @return
	 */
	public SnRelTipoSolicTipoOsKey getCompositeKey() {
		return compositeKey;
	}

	public void setCompositeKey(SnRelTipoSolicTipoOsKey compositeKey) {
		this.compositeKey = compositeKey;
	}

}
