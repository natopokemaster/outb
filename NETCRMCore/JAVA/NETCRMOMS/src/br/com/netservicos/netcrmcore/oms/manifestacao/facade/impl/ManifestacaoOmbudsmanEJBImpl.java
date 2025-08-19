package br.com.netservicos.netcrmcore.oms.manifestacao.facade.impl;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.hibernate.dialect.SQLServerDialect.TrimFunction;

import br.com.netservicos.core.bean.oms.CanalAtendimentoBean;
import br.com.netservicos.core.bean.oms.IntegracaoManifestacaoBean;
import br.com.netservicos.core.bean.sn.SnAssinanteBean;
import br.com.netservicos.core.bean.sn.SnCidadeOperadoraBean;
import br.com.netservicos.core.bean.sn.SnContratoBean;
import br.com.netservicos.core.bean.sn.SnContratoKey;
import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.exception.system.ResourceException;
import br.com.netservicos.framework.util.loader.ResourceLoader;
import br.com.netservicos.netcrmcore.oms.constants.ManifestacaoOmbudsmanConstants;
import br.com.netservicos.netcrmcore.oms.core.facade.impl.AbstractNETCRMOMSEJBImpl;
import br.com.netservicos.netcrmcore.oms.manifestacao.facade.ManifestacaoOmbudsmanService;
import br.com.netservicos.netcrmcore.oms.resources.NETCRMOMSResources;

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
  * @ejb.bean name="ManifestacaoOmbudsmanEJB"
 * 		type="Stateless"
 * 		display-name="ManifestacaoOmbudsmanEJB"
 *      description="ManifestacaoOmbudsmanEJB Session EJB Stateless"
 *      view-type="both"
 *      jndi-name="netcrmcore/oms/ejb/ManifestacaoOmbudsmanEJB"
 * 		local-jndi-name="netcrmcore/oms/ejb/local/ManifestacaoOmbudsmanEJB"
 *		transaction-type="Container"
 *
 *
 * @ejb.interface local-extends="javax.ejb.EJBLocalObject"
 *                extends="javax.ejb.EJBObject"
 * 
 * @ejb.home local-extends="javax.ejb.EJBLocalHome" extends="javax.ejb.EJBHome"   
 *
 */
public class ManifestacaoOmbudsmanEJBImpl extends AbstractNETCRMOMSEJBImpl implements ManifestacaoOmbudsmanService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5892963549835564447L;

	/**
	 *@ejb.interface-method view-type="both"
	 *@ejb.transaction	type = "Required"
	 *
	 * @param bean
	 * @return
	 * @throws IOException 
	 * @throws RemoteException 
	 */
	@SuppressWarnings("unchecked")
	public void incluirIntegracaoManifestacaoContrato(Bean bean) throws IOException{
		
		DynamicBean dynaBean = (DynamicBean) bean;
		
		IntegracaoManifestacaoBean integracaoManifestacaoBean = new IntegracaoManifestacaoBean();
		CanalAtendimentoBean canalAtendimentoBean = new CanalAtendimentoBean();
		List<CanalAtendimentoBean> canalAtendimentoList; 
				
		integracaoManifestacaoBean.setDhUltAtualiz(new Date());
		integracaoManifestacaoBean.setCdUsuario(this.userInfo.getUserId());
		integracaoManifestacaoBean.setStIntegracao(ManifestacaoOmbudsmanConstants.AGUARDANDO_ANALISE_OUVIDORIA);
		canalAtendimentoBean.setDsCanalAtendimento((String)dynaBean.get(ManifestacaoOmbudsmanConstants.DSCANALATENDIMENTO));
		
		// Recupera CidContrato por meio do Cod_Operadora
		List<SnCidadeOperadoraBean> snCidadeOperadoraList = super.search(SnCidadeOperadoraBean.PROCURA_CID_CONTRATO_POR_COD_OPERADORA, dynaBean);
		if (!snCidadeOperadoraList.isEmpty()){
			for (SnCidadeOperadoraBean cidadeOperadoraBean : snCidadeOperadoraList){
				//integracaoManifestacaoBean.setCdCidadeOperadora(cidadeOperadoraBean.getCidContrato());
				integracaoManifestacaoBean.setNmCidade(cidadeOperadoraBean.getCiNome());
			}
		}
		
		List<SnContratoBean> contratoList =  super.search(SnContratoBean.PROCURA_CONTRATO_POR_NUM_CONTRATO_COD_OPERADORA, dynaBean);
		if (!contratoList.isEmpty()){
			for(SnContratoBean contratoBean : contratoList){
				
				integracaoManifestacaoBean.setNmCliente(contratoBean.getAssinante().getNomeTitular());
				
				if (contratoBean.getAssinante().getCpf().trim().length() > 14){
					integracaoManifestacaoBean.setNrDocumento(contratoBean.getAssinante().getCpf().substring(1));
				}else{
					integracaoManifestacaoBean.setNrDocumento(contratoBean.getAssinante().getCpf());
				}
			}
		}
		
		String currentdbservice = this.userInfo.getCurrentDbService();
		String omsdatabase = ManifestacaoOmbudsmanConstants.DATASOURCE_OMS + loadEnviromentConfigPropertiesAliasDatabase();

		this.userInfo.setCurrentDbService(omsdatabase);
		
		dynaBean.set(ManifestacaoOmbudsmanConstants.CANAL_ATENDIMENTO, canalAtendimentoBean);
		canalAtendimentoList = (List<CanalAtendimentoBean>)super.search(CanalAtendimentoBean.PROCURA_CANAL_POR_DESCRICAO, dynaBean);
		
		if (!canalAtendimentoList.isEmpty()){
			for(CanalAtendimentoBean canalBean : canalAtendimentoList){
				integracaoManifestacaoBean.setCanalAtendimentoBean(canalBean);
			}
		}else{
			String mensagem = this.getMessage(NETCRMOMSResources.ERRO_CANAL_ATENDIMENTO, new Object[] {ManifestacaoOmbudsmanConstants.RESOURCE_MANIFESTACAO_OMBUDSMAN });
			ResourceException ex = new ResourceException(NETCRMOMSResources.ERRO_CANAL_ATENDIMENTO,mensagem, this.getClass().getName());
			throw ex;
		}
		
		integracaoManifestacaoBean.setCdOperadora((String) dynaBean.get(ManifestacaoOmbudsmanConstants.CDOPERADORA));
		integracaoManifestacaoBean.setCdContrato((Long)dynaBean.get(ManifestacaoOmbudsmanConstants.CDCONTRATO));
		integracaoManifestacaoBean.setDsAssunto((String) dynaBean.get(ManifestacaoOmbudsmanConstants.DSASSUNTO));
		integracaoManifestacaoBean.setDsManifestacao((String)dynaBean.get(ManifestacaoOmbudsmanConstants.DSMANIFESTACAO));
		integracaoManifestacaoBean.setCdProtocolo((String) dynaBean.get(ManifestacaoOmbudsmanConstants.CDPROTOCOLO));
		integracaoManifestacaoBean.setTpPessoa((String)dynaBean.get(ManifestacaoOmbudsmanConstants.TPPESSOA));
		
		super.insert(integracaoManifestacaoBean, omsdatabase);
		this.userInfo.setCurrentDbService(currentdbservice);
	}
	
	/**
	 *@ejb.interface-method view-type="both"
	 *@ejb.transaction	type = "Required"
	 *
	 * @param bean
	 * @return
	 * @throws RemoteException 
	 */
	@SuppressWarnings("unchecked")
	public void incluirIntegracaoManifestacaoCliente(Bean bean)throws IOException{
		
		DynamicBean dynaBean = (DynamicBean) bean;
		
		IntegracaoManifestacaoBean integracaoManifestacaoBean = new IntegracaoManifestacaoBean();
		CanalAtendimentoBean canalAtendimentoBean = new CanalAtendimentoBean();
		List<CanalAtendimentoBean> canalAtendimentoList; 
		
		integracaoManifestacaoBean.setDhUltAtualiz(new Date());
		integracaoManifestacaoBean.setCdUsuario(this.userInfo.getUserId());
		integracaoManifestacaoBean.setStIntegracao(ManifestacaoOmbudsmanConstants.AGUARDANDO_ANALISE_OUVIDORIA);
		integracaoManifestacaoBean.setDsAssunto((String) dynaBean.get(ManifestacaoOmbudsmanConstants.DSASSUNTO));
		integracaoManifestacaoBean.setNmBairro((String)dynaBean.get(ManifestacaoOmbudsmanConstants.NMBAIRRO));
		canalAtendimentoBean.setDsCanalAtendimento((String)dynaBean.get(ManifestacaoOmbudsmanConstants.DSCANALATENDIMENTO));
		
		String currentdbservice = this.userInfo.getCurrentDbService();
		String omsdatabase = ManifestacaoOmbudsmanConstants.DATASOURCE_OMS + loadEnviromentConfigPropertiesAliasDatabase();

		this.userInfo.setCurrentDbService(omsdatabase);
		
		dynaBean.set(ManifestacaoOmbudsmanConstants.CANAL_ATENDIMENTO, canalAtendimentoBean);
		canalAtendimentoList = (List<CanalAtendimentoBean>)super.search(CanalAtendimentoBean.PROCURA_CANAL_POR_DESCRICAO, dynaBean);
		
		if (!canalAtendimentoList.isEmpty()){
				for(CanalAtendimentoBean canalBean : canalAtendimentoList){
					integracaoManifestacaoBean.setCanalAtendimentoBean(canalBean);
				}
		}else{	
			String mensagem = this.getMessage(NETCRMOMSResources.ERRO_CANAL_ATENDIMENTO, new Object[] {ManifestacaoOmbudsmanConstants.RESOURCE_MANIFESTACAO_OMBUDSMAN });
			ResourceException ex = new ResourceException(NETCRMOMSResources.ERRO_CANAL_ATENDIMENTO, mensagem, this.getClass().getName());
			throw ex;	
		}
		
		integracaoManifestacaoBean.setNrCep((String)dynaBean.get(ManifestacaoOmbudsmanConstants.NRCEP));
		integracaoManifestacaoBean.setNmCidade((String)dynaBean.get(ManifestacaoOmbudsmanConstants.NMCIDADE));
				
		integracaoManifestacaoBean.setTpPessoa(((String)dynaBean.get(ManifestacaoOmbudsmanConstants.TPPESSOA)).toUpperCase());
		
		if (integracaoManifestacaoBean.getTpPessoa().toUpperCase().equals(ManifestacaoOmbudsmanConstants.PESSOA_FISICA)){
			integracaoManifestacaoBean.setNrDocumento((String)dynaBean.get(ManifestacaoOmbudsmanConstants.CPF));
		}
		
		if(integracaoManifestacaoBean.getTpPessoa().toUpperCase().equals(ManifestacaoOmbudsmanConstants.PESSOA_JURIDICA)){
			integracaoManifestacaoBean.setNrDocumento((String)dynaBean.get(ManifestacaoOmbudsmanConstants.CNPJ));
		}
		
		integracaoManifestacaoBean.setDsComplemento((String)dynaBean.get(ManifestacaoOmbudsmanConstants.DSCOMPLEMENTO));
		integracaoManifestacaoBean.setDsManifestacao((String)dynaBean.get(ManifestacaoOmbudsmanConstants.DSMANIFESTACAO));
		integracaoManifestacaoBean.setDsEmail((String)dynaBean.get(ManifestacaoOmbudsmanConstants.DSEMAIL));
		integracaoManifestacaoBean.setNmLogradouro((String)dynaBean.get(ManifestacaoOmbudsmanConstants.NMLOGRADOURO));
		integracaoManifestacaoBean.setNmCliente((String)dynaBean.get(ManifestacaoOmbudsmanConstants.NMCLIENTE));
		integracaoManifestacaoBean.setNrLogradouro((String)dynaBean.get(ManifestacaoOmbudsmanConstants.NRLOGRADOURO));
		integracaoManifestacaoBean.setNrTelCliente((String)dynaBean.get(ManifestacaoOmbudsmanConstants.NRTELEFONECLIENTE));
		integracaoManifestacaoBean.setSgUf((String)dynaBean.get(ManifestacaoOmbudsmanConstants.SGUF));
		
		super.insert(integracaoManifestacaoBean, omsdatabase);
		this.userInfo.setCurrentDbService(currentdbservice);
	}
	/**
	 * Método responsável por configurar o Alias do Database OMS.
	 * 
	 * @return
	 * @throws IOException
	 */
	public String loadEnviromentConfigPropertiesAliasDatabase() throws IOException {
		
		Properties propConfig = new Properties();
		synchronized (propConfig) {
			final ResourceLoader resourceLoader = new ResourceLoader(ManifestacaoOmbudsmanConstants.ENVIROMENT_CONFIG);
			propConfig.load(resourceLoader.getStream());
		}

		String aliasDatabase = propConfig.getProperty(ManifestacaoOmbudsmanConstants.BASE_OMS);
		
		return aliasDatabase;
	}
	
}
