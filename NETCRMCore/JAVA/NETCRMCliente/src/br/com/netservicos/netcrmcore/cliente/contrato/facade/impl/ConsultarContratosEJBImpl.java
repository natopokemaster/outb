	package br.com.netservicos.netcrmcore.cliente.contrato.facade.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.netservicos.core.bean.sn.SnCidadeOperadoraBean;
import br.com.netservicos.core.bean.sn.SnContratoBean;
import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.netcrmcore.cliente.contrato.facade.ConsultarContratosService;
import br.com.netservicos.netcrmcore.cliente.core.facade.impl.AbstractNETCRMClienteEJBImpl;

/**
 * EJB responsável por consultar contratos.
 * 
 * @author marcio@mdantas.com.br
 * 
 * @ejb.bean 
 *		name="ConsultarContratosEJB"
 *		type="Stateless"
 * 		display-name="ConsultarContratosEJB"
 *		description="ConsultarContratosEJB Session EJB Stateless"
 *		view-type="both"
 *		jndi-name="netcrmcore/cliente/ejb/ConsultarContratosEJB"
 *		local-jndi-name="netcrmcore/cliente/ejb/local/ConsultarContratosEJB"
 *		transaction-type="Container"
 * 	
 * @ejb.interface
 *		local-extends="javax.ejb.EJBLocalObject"
 *		extends="javax.ejb.EJBObject"
 *
 * @ejb.home
 *		local-extends="javax.ejb.EJBLocalHome"
 *		extends="javax.ejb.EJBHome"
 *   
 */
public class ConsultarContratosEJBImpl extends
		AbstractNETCRMClienteEJBImpl implements ConsultarContratosService {
    
    private static final Integer CONSTANT_0 = 0;
    private static final Integer CONSTANT_1 = 1;
    private static final Integer CONSTANT_2 = 2;
    private static final Integer CONSTANT_3 = 3;
    private static final Integer CONSTANT_4 = 4;
    private static final Integer CONSTANT_5 = 5;
    private static final Integer CONSTANT_6 = 6;
    private static final Integer CONSTANT_7 = 7;
    private static final Integer CONSTANT_8 = 8;
    private static final Integer CONSTANT_9 = 9;
    private static final Integer CONSTANT_10 = 10;
    private static final Integer CONSTANT_11 = 11;

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1713492184667431518L;
	
	
	/**
	 * Operação que realiza a consulta de contratos por edificacao.
	 * 
	 * @ejb.interface-method view-type = "both"
	 * @ejb.transaction type="Required"
	 * @ejb.permission role-name="CRM_CONSULTAR_CONTRATOS_EDIFICACAO"
	 */
	public List<DynamicBean> consultarContratosPorImovelAndHP(Bean bean) throws IOException{
		
		DynamicBean dynaBean = (DynamicBean) bean;
		return obterContratos(dynaBean);
			
	}
	
	private List<DynamicBean> obterContratos(final Bean bean) {
		
		// Validando os campos de entrada
		if(!bean.getBeanProperty("codigoImovel").equals("") && bean.getBeanProperty("codigoHP").equals("")){
			return this.searchDadosContrato(this.search(
					SnContratoBean.LST_CONTRATO_BY_IMOVEL, bean, false));
		} else if (!bean.getBeanProperty("codigoHP").equals("") && !bean.getBeanProperty("codigoImovel").equals("")){
			return this.searchDadosContrato(this.search(
					SnContratoBean.LST_CONTRATO_BY_HP, bean, false));
		}

		return null;
	}
	
	private List<DynamicBean> searchDadosContrato(final List lst) {

		final List<DynamicBean> contratoList = new ArrayList<DynamicBean>();
		for (final Object object : lst) {
			final Object[] tmp = (Object[]) object;
			final DynamicBean bean = new DynamicBean();
			bean.set("codOperadora", tmp[CONSTANT_0]);
			bean.set("idStatus", tmp[CONSTANT_1]);
			bean.set("descricaoStatus", tmp[CONSTANT_2]);
			bean.set("codHP", tmp[CONSTANT_3]);
			bean.set("codImovel", tmp[CONSTANT_4]);
			bean.set("cidContrato", tmp[CONSTANT_5]);
			bean.set("idTipoContrato", tmp[CONSTANT_6]);
			bean.set("descricaoTipoContrato", tmp[CONSTANT_7]);
			if(tmp[CONSTANT_8] == null){
				bean.set("descricaoModalidade", "");
			}else{
				bean.set("descricaoModalidade", tmp[CONSTANT_8]);
			}
			bean.set("numContrato", tmp[CONSTANT_9]);
			bean.set("idAssinante", tmp[CONSTANT_10]);
			bean.set("nomeTitular", tmp[CONSTANT_11]);
			contratoList.add(bean);
		}
		return contratoList;
	}
	
	/**
	 * Operação que realiza a busca da cidade contrato passando o 
	 * código da operadora.
	 * 
	 * @param bean
	 * @return SnCidadeOperadoraBean
	 * 
	 * @since 14/09/2010
	 */
	private SnCidadeOperadoraBean searchCidadeContratoByCodOperadora (Bean bean) {
		
		List<SnContratoBean> contratoList; 
		
		//Recupera CidContrato por codOperadora
		Collection<?> ret = super.search(SnCidadeOperadoraBean.PROCURA_CID_CONTRATO_POR_COD_OPERADORA, bean, false);

		if (!ret.isEmpty()) {
			return (SnCidadeOperadoraBean) ret.iterator().next();
		}
		
		return null;
	}
	
}
