package br.com.netservicos.netcrmcore.cliente.cobranca.facade.impl;

import java.rmi.RemoteException;

import br.com.netservicos.core.bean.cp.CpCobrancaBean;
import br.com.netservicos.core.bean.sn.SnFormaEnvioFaturaBean;
import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.modelocanonico.evento.ws.types.RegistroContato;
import br.com.netservicos.netcrmcore.cliente.cobranca.facade.ManutencaoDadosCobrancaPropostaService;
import br.com.netservicos.netcrmcore.cliente.constants.ManutencaoDadosCobrancaContants;
import br.com.netservicos.netcrmcore.cliente.core.facade.impl.AbstractNETCRMClienteEJBImpl;


/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 *  Componente criado apartir dos componentes: .
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>
 *                           Prior
 * Date       By             Version  Project/CSR    Description
 * ---------- -------------- -------- -------------- ---------------------------
 * 20/01/2010 Alexandre Soares N/A      NETcrmcore Created.
 * =============================================================================
 * </PRE>
  * @ejb.bean name="ManutencaoDadosCobrancaPropostaEJB"
 * 		type="Stateless"
 * 		display-name="ManutencaoDadosCobrancaPropostaEJB"
 *      description="ManutencaoDadosCobrancaPropostaEJB Session EJB Stateless"
 *      view-type="both"
 *      jndi-name="netcrmcore/cliente/ejb/ManutencaoDadosCobrancaPropostaEJB"
 * 		local-jndi-name="netcrmcore/cliente/ejb/local/ManutencaoDadosCobrancaPropostaEJB"
 *		transaction-type="Container"
 *
 *
 * @ejb.interface local-extends="javax.ejb.EJBLocalObject"
 *                extends="javax.ejb.EJBObject"
 * 
 * @ejb.home local-extends="javax.ejb.EJBLocalHome" extends="javax.ejb.EJBHome"   
 *
 * @ejb.permission role-name="ALTERAR_DADO_COBRANCA_PROPOSTA"
 */
public class ManutencaoDadosCobrancaPropostaEJBImpl extends
		AbstractNETCRMClienteEJBImpl implements ManutencaoDadosCobrancaPropostaService{


	/**
	 * 
	 */
	private static final long serialVersionUID = 2727557977773198732L;

	/**
	 *@ejb.interface-method view-type="both"
	 *@ejb.transaction	type = "Required"
	 *@ejb.permission role-name="ALTERAR_DADO_COBRANCA_PROPOSTA"
	 *
	 * @param bean
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws RemoteException 
	 */
	public RegistroContato alterarDadosCobrancaProposta(Bean bean){

		DynamicBean dynaBean = (DynamicBean) bean;
		
		//Encontrar Contrato
		CpCobrancaBean cobrancaBean = new CpCobrancaBean();
		cobrancaBean.setIdProposta((Long.valueOf((String.valueOf(dynaBean.get(ManutencaoDadosCobrancaContants.NR_PROPOSTA))))));
		
		cobrancaBean = (CpCobrancaBean) super.findByPrimaryKey(cobrancaBean);
		
		//Alterar TipoPostagem
		SnFormaEnvioFaturaBean formaEnvio = new SnFormaEnvioFaturaBean();
		formaEnvio.setIdFormaEnvioFatura((Long)dynaBean.get(ManutencaoDadosCobrancaContants.TIPO_POSTAGEM));
		formaEnvio = (SnFormaEnvioFaturaBean) super.findByPrimaryKey(formaEnvio);
		cobrancaBean.setIdFormaEnvFat(formaEnvio);		
		super.update(cobrancaBean, super.getUserSession().getCurrentDbService());

		return null;

	}

}
