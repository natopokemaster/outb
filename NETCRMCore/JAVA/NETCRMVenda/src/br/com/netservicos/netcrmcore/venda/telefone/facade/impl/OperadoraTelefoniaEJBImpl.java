package br.com.netservicos.netcrmcore.venda.telefone.facade.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.netservicos.core.bean.sn.SnOperadoraTelefoniaBean;
import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.netcrmcore.venda.constants.OperadoraTelefoniaConstants;
import br.com.netservicos.netcrmcore.venda.core.facade.impl.AbstractNETCRMVendaEJBImpl;
import br.com.netservicos.netcrmcore.venda.telefone.facade.OperadoraTelefoniaService;

/**
 * EJB responsável por listar dados de operadoras de telefonia
 * 
 * @author marcio@mdantas.com.br
 * 
 * @ejb.bean name="OperadoraTelefoniaEJB" type="Stateless"
 *           display-name="OperadoraTelefoniaEJB"
 *           description="OperadoraTelefoniaEJB Session EJB Stateless"
 *           view-type="both" jndi-name="netcrmcore/venda/ejb/OperadoraTelefoniaEJB"
 *           local-jndi-name="netcrmcore/venda/ejb/local/OperadoraTelefoniaEJB"
 *           transaction-type="Container"
 * 
 * @ejb.interface local-extends="javax.ejb.EJBLocalObject"
 *                extends="javax.ejb.EJBObject"
 * 
 * @ejb.home local-extends="javax.ejb.EJBLocalHome" extends="javax.ejb.EJBHome"
 * 
 */
public class OperadoraTelefoniaEJBImpl extends AbstractNETCRMVendaEJBImpl implements
		OperadoraTelefoniaService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1713492184667415249L;
	
	private static final Integer CONSTANT_3 = 3;

	/**
	 * Operação que realiza a reserva de um ou mais números de telefone.
	 * 
	 * @ejb.interface-method view-type = "both"
	 * @ejb.transaction type="Required"
	 * @ejb.permission role-name="CRM_LISTAR_OPERADORA_TELEFONIA"
	 */
	@Override
	public List<DynamicBean> listarOperadorasTelefonia(Bean bean) throws IOException {
		
		DynamicBean dynaBean = (DynamicBean) bean;
		return obterOperadorasTelefonia(dynaBean);
		
	}
	
	/**
	 * Operação que realiza a busca dos dados de nome da operadora de telefonia. 
	 * @param bean
	 * @return id_operadora_telefonia,nm_operadora_telefonia,fc_produto_ebt,nr_ddd
	 * 
	 * @since 04/10/2010
	 */
	/*private List<DynamicBean> searchDadosOperadoraTelefonia(Bean bean) {
		
		DynamicBean dynaBean = (DynamicBean) bean;
		
		List<DynamicBean> operadoraList =  super.search(SnOperadoraTelefoniaBean.LST_OPERADORA_TELEFONIA_BY_DDD, dynaBean);
		if (!operadoraList.isEmpty()){
			for(DynamicBean contratoBean : operadoraList){
				return contratoBean;
			}
		}
		
		return null;
		
	}*/
	
	private List<DynamicBean> obterOperadorasTelefonia(final Bean bean) {
		
		// Validando os campos de entrada
		if(!bean.getBeanProperty(OperadoraTelefoniaConstants.PNUMERO_DDD).equals("")){
			return this.popularOperadoraTelefonia(this.search(
					SnOperadoraTelefoniaBean.LST_OPERADORA_TELEFONIA_BY_DDD, bean, false));
		}

		return null;
	}
	
	private List<DynamicBean> popularOperadoraTelefonia(final List lst) {

		final List<DynamicBean> operadoraList = new ArrayList<DynamicBean>();
		for (final Object object : lst) {
			final Object[] tmp = (Object[]) object;
			final DynamicBean bean = new DynamicBean();
			bean.set(OperadoraTelefoniaConstants.CODIGO_OPERADORA_TELEFONIA, tmp[0]);
			bean.set(OperadoraTelefoniaConstants.NOME_OPERADORA_TELEFONIA, tmp[1]);
			bean.set(OperadoraTelefoniaConstants.PRODUTO_EBT, tmp[2]);
			bean.set(OperadoraTelefoniaConstants.NUMERO_DDD, tmp[CONSTANT_3]);
			operadoraList.add(bean);
		}
		return operadoraList;
	}
	
		
}
