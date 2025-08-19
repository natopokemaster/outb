package br.com.netservicos.netcrmcore.cliente.cobranca.facade.impl;

import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources.ERRO_SERVICO;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBElement;

import br.com.netservicos.atendimento.evento.registrocontato.IncluirRegistroContato;
import br.com.netservicos.atendimento.evento.registrocontato.IncluirRegistroContatoResponse;
import br.com.netservicos.atendimento.registrocontato.ws.service.IncluirRegistroContatoWebService;
import br.com.netservicos.core.bean.sn.SnContratoBean;
import br.com.netservicos.core.bean.sn.SnContratoKey;
import br.com.netservicos.core.bean.sn.SnFormaEnvioFaturaBean;
import br.com.netservicos.core.bean.sn.SnRelCoboletamentoContratoBean;
import br.com.netservicos.core.bean.sn.SnRelCoboletamentoContratoKey;
import br.com.netservicos.core.bean.sn.SnTipoOcorrenciaBean;
import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.exception.system.ResourceException;
import br.com.netservicos.framework.service.webservice.WebServiceFactory;
import br.com.netservicos.framework.service.webservice.header.NETFrameworkWSHeader;
import br.com.netservicos.modelocanonico.evento.ws.types.Contato;
import br.com.netservicos.modelocanonico.evento.ws.types.FormaContatoTelefone;
import br.com.netservicos.modelocanonico.evento.ws.types.ObjectFactory;
import br.com.netservicos.modelocanonico.evento.ws.types.RegistroContato;
import br.com.netservicos.modelocanonico.evento.ws.types.TipoEvento;
import br.com.netservicos.modelocanonico.usuario.ws.types.Usuario;
import br.com.netservicos.modelocanonico.v2.identificacaocontrato.ContratoType;
import br.com.netservicos.modelocanonico.v2.identificacaocontrato.IdentificacaoContratoType;
import br.com.netservicos.netcrmcore.cliente.cobranca.facade.ManutencaoDadosCobrancaContratoService;
import br.com.netservicos.netcrmcore.cliente.constants.ManutencaoDadosCobrancaContants;
import br.com.netservicos.netcrmcore.cliente.core.facade.impl.AbstractNETCRMClienteEJBImpl;
import br.com.netservicos.netheader.ws.types.Atendimento;
import br.com.netservicos.netheader.ws.types.Header;

/**
 * <P>
 * <B> Description : </B> <BR>
 * Componente criado apartir dos componentes: .
 * </P>
 * <P>
 * <B> Issues : </B>
 * 
 * <PRE>
 *                           Prior
 * Date       By             Version  Project/CSR    Description
 * ---------- -------------- -------- -------------- ---------------------------
 * 20/01/2010 Alexandre Soares N/A      NETcrmcore Created.
 * =============================================================================
 * </PRE>
 * 
 * @ejb.bean name="ManutencaoDadosCobrancaContratoEJB" type="Stateless"
 *           display-name="ManutencaoDadosCobrancaContratoEJB"
 *           description="ManutencaoDadosCobrancaContratoEJB Session EJB Stateless"
 *           view-type="both"
 *           jndi-name="netcrmcore/cliente/ejb/ManutencaoDadosCobrancaContratoEJB"
 *           local-jndi-name=
 *           "netcrmcore/cliente/ejb/local/ManutencaoDadosCobrancaContratoEJB"
 *           transaction-type="Container"
 * 
 * 
 * @ejb.interface local-extends="javax.ejb.EJBLocalObject"
 *                extends="javax.ejb.EJBObject"
 * 
 * @ejb.home local-extends="javax.ejb.EJBLocalHome" extends="javax.ejb.EJBHome"
 * 
 * @ejb.permission role-name="ALTERAR_DADO_COBRANCA_CONTRATO"
 */
public class ManutencaoDadosCobrancaContratoEJBImpl extends
		AbstractNETCRMClienteEJBImpl implements
		ManutencaoDadosCobrancaContratoService {

	private static final long serialVersionUID = 2727557977773198723L;

	/**
	 * @ejb.interface-method view-type="both"
	 * @ejb.transaction type = "Required"
	 * @ejb.permission role-name="ALTERAR_DADO_COBRANCA_CONTRATO"
	 * 
	 * @param bean
	 * @return
	 * @throws ParseException
	 * @throws RemoteException
	 */
	public RegistroContato alterarDadosCobrancaContrato(Bean bean)
			throws ParseException {

		DynamicBean dynaBean = (DynamicBean) bean;

		// Instancia retorno
		RegistroContato evento = null;

		// Encontrar Contrato
		SnContratoBean contratoBean = new SnContratoBean();
		SnContratoKey contratokey = new SnContratoKey(
				(Long) dynaBean
						.get(ManutencaoDadosCobrancaContants.NR_CONTRATO),
				(String) dynaBean
						.get(ManutencaoDadosCobrancaContants.CD_CIDADE));
		contratoBean.setCompositeKey(contratokey);
		contratoBean = (SnContratoBean) super.findByPrimaryKey(contratoBean);
		String obs = (String) dynaBean
				.get(ManutencaoDadosCobrancaContants.OBSERVACAO);

		if (dynaBean.get(ManutencaoDadosCobrancaContants.TIPO_POSTAGEM) != null
				&& ((Long) dynaBean
						.get(ManutencaoDadosCobrancaContants.TIPO_POSTAGEM))
						.longValue() > 0) {

			// Alterar TipoPostagem

			SnFormaEnvioFaturaBean formaEnvioFaturaBean = new SnFormaEnvioFaturaBean();
			formaEnvioFaturaBean.setIdFormaEnvioFatura((Long) dynaBean
					.get(ManutencaoDadosCobrancaContants.TIPO_POSTAGEM));

			obs = obs
					+ ManutencaoDadosCobrancaContants.STR_CAMPO_ID_FORMA_ENVIO
					+ formaEnvioFaturaBean.getIdFormaEnvioFatura().toString()
					+ ManutencaoDadosCobrancaContants.STR_FECHA;
			dynaBean.set(ManutencaoDadosCobrancaContants.OBSERVACAO, obs);

			contratoBean.setFormaEnvioFatura(formaEnvioFaturaBean);
			super.update(contratoBean, super.getUserSession()
					.getCurrentDbService());

			dynaBean.set(ManutencaoDadosCobrancaContants.DESCRICAO,
					ManutencaoDadosCobrancaContants.DS_TIPO_OC_FAT_EMAIL);
			List lst = super.search(SnTipoOcorrenciaBean.BUSCAR_POR_DESCRICAO,
					dynaBean);

			if (lst != null && !lst.isEmpty()) {
				SnTipoOcorrenciaBean snTipoOcorrenciaBean = (SnTipoOcorrenciaBean) lst
						.get(0);
				TipoEvento tipoEvento = new TipoEvento();
				tipoEvento.setIdentificador(snTipoOcorrenciaBean
						.getIdTipoOcorrencia());
				tipoEvento.setDescricao(snTipoOcorrenciaBean.getDescricao());
				dynaBean.set(ManutencaoDadosCobrancaContants.TIPO_EVENTO,
						tipoEvento);
			}

			// Chamar Webservices - RegistroContato
			incluirRegistroContato(dynaBean);

		} else {

			// Alterar TipoCoboletamento
			SnRelCoboletamentoContratoBean snRelCoboletamentoContratoBean = consultaCoboletamento(contratoBean);
			Boolean tpCoboletamento = (Boolean) dynaBean
					.get(ManutencaoDadosCobrancaContants.INDICADOR_COBOLETAMENTO);
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					ManutencaoDadosCobrancaContants.STR_DATE_PATTERN);
			Date date = new Date();
			String dataAtual = dateFormat.format(date);
			snRelCoboletamentoContratoBean
					.setDtFim(dateFormat.parse(dataAtual));

			SnRelCoboletamentoContratoBean snRelCoboletamentoContratoBeanNovo = new SnRelCoboletamentoContratoBean();
			SnRelCoboletamentoContratoKey snRelCoboletamentoContratoKey = new SnRelCoboletamentoContratoKey();
			snRelCoboletamentoContratoKey.setCidContrato((String) dynaBean
					.get(ManutencaoDadosCobrancaContants.CD_CIDADE));
			snRelCoboletamentoContratoKey.setNumContrato((Long) dynaBean
					.get(ManutencaoDadosCobrancaContants.NR_CONTRATO));
			snRelCoboletamentoContratoKey.setDtInicio(date);
			snRelCoboletamentoContratoBeanNovo.setDtFim(dateFormat
					.parse(ManutencaoDadosCobrancaContants.STR_DATA_FIM));
			snRelCoboletamentoContratoBeanNovo
					.setComposite(snRelCoboletamentoContratoKey);
			snRelCoboletamentoContratoBeanNovo.setIdUsr(this.userInfo
					.getUserId());
			if (tpCoboletamento) {
				// snRelCoboletamentoContratoBean.setTpCoboletamento(ManutencaoDadosCobrancaContants.STR_SIM);
				snRelCoboletamentoContratoBeanNovo
						.setTpCoboletamento(ManutencaoDadosCobrancaContants.STR_SIM);
				obs = obs
						+ ManutencaoDadosCobrancaContants.STR_CAMPO_TP_COBOLETAMENTO
						+ ManutencaoDadosCobrancaContants.STR_SIM
						+ ManutencaoDadosCobrancaContants.STR_FECHA;
			} else {
				// snRelCoboletamentoContratoBean.setTpCoboletamento(ManutencaoDadosCobrancaContants.STR_NAO);
				snRelCoboletamentoContratoBeanNovo
						.setTpCoboletamento(ManutencaoDadosCobrancaContants.STR_NAO);
				obs = obs
						+ ManutencaoDadosCobrancaContants.STR_CAMPO_TP_COBOLETAMENTO
						+ ManutencaoDadosCobrancaContants.STR_NAO
						+ ManutencaoDadosCobrancaContants.STR_FECHA;
			}
			dynaBean.set(ManutencaoDadosCobrancaContants.OBSERVACAO, obs);

			super.update(snRelCoboletamentoContratoBean, super.getUserSession()
					.getCurrentDbService());
			super.insert(snRelCoboletamentoContratoBeanNovo, super
					.getUserSession().getCurrentDbService());

			dynaBean.set(
					ManutencaoDadosCobrancaContants.DESCRICAO,
					ManutencaoDadosCobrancaContants.DS_TIPO_OC_DESMEM_FAT_DEFINITIVO);
			List lst = super.search(SnTipoOcorrenciaBean.BUSCAR_POR_DESCRICAO,
					dynaBean);

			if (lst != null && !lst.isEmpty()) {
				SnTipoOcorrenciaBean snTipoOcorrenciaBean = (SnTipoOcorrenciaBean) lst
						.get(0);
				TipoEvento tipoEvento = new TipoEvento();
				tipoEvento.setIdentificador(snTipoOcorrenciaBean
						.getIdTipoOcorrencia());
				tipoEvento.setDescricao(snTipoOcorrenciaBean.getDescricao());
				dynaBean.set(ManutencaoDadosCobrancaContants.TIPO_EVENTO,
						tipoEvento);
			}

			// Chamar Webservices - RegistroContato
			incluirRegistroContato(dynaBean);
		}

		return evento;
	}

	private SnRelCoboletamentoContratoBean consultaCoboletamento(
			SnContratoBean contratoBean) {

		SnRelCoboletamentoContratoBean snRelCoboletamentoContratoBean = new SnRelCoboletamentoContratoBean();
		SnRelCoboletamentoContratoKey snRelCoboletamentoContratoKey = new SnRelCoboletamentoContratoKey(
				contratoBean.getCompositeKey().getNumContrato(), contratoBean
						.getCompositeKey().getCidContrato(), null);
		snRelCoboletamentoContratoBean
				.setPrimaryKey(snRelCoboletamentoContratoKey);

		List list = super.search(
				SnRelCoboletamentoContratoBean.LAST_COBOLETAMENTO_CONTRATO,
				snRelCoboletamentoContratoBean, false);

		if (!list.isEmpty()) {
			snRelCoboletamentoContratoBean = (SnRelCoboletamentoContratoBean) list
					.get(0);
		}
		return snRelCoboletamentoContratoBean;
	}

	private RegistroContato incluirRegistroContato(DynamicBean dynaBean) {

		IncluirRegistroContatoWebService service = null;

		// Instancia retorno
		RegistroContato evento = null;

		try {

			service = WebServiceFactory
					.getService(
							IncluirRegistroContatoWebService.class,
							context.getCallerPrincipal(),
							ManutencaoDadosCobrancaContants.APPLICATION_CONTEXT_WEBSERVICE);
			IncluirRegistroContatoResponse response = (IncluirRegistroContatoResponse) service
					.incluirRegistroContato(getRegistrocontato(dynaBean),
							getHeaderWebService(dynaBean));
			evento = response.getRegistroContato();

		} catch (Exception e) {

			if (!e.getMessage().contains("Sucesso")) {

				String mensagem = this
						.getMessage(
								ERRO_SERVICO,
								new Object[] { ManutencaoDadosCobrancaContants.RESOURCE__REGISTRO_CONTATO });
				ResourceException ex = new ResourceException(ERRO_SERVICO,
						mensagem, this.getClass().getName(), e);
				throw ex;

			}

		}

		return evento;

	}

	private IncluirRegistroContato getRegistrocontato(DynamicBean bean) {

		IncluirRegistroContato incluirRegistroContato = new IncluirRegistroContato();
		IdentificacaoContratoType identificacaoContratoType = new IdentificacaoContratoType();
		RegistroContato registroContato = new RegistroContato();
		ContratoType contrato = new ContratoType();
		contrato.setIdentificacaoCidade((String) bean
				.get(ManutencaoDadosCobrancaContants.CD_CIDADE));
		contrato.setNumeroContrato((Long) bean
				.get(ManutencaoDadosCobrancaContants.NR_CONTRATO));
		identificacaoContratoType.setContrato(contrato);
		registroContato.setTipo((TipoEvento) bean
				.get(ManutencaoDadosCobrancaContants.TIPO_EVENTO));
		registroContato.setObservacao((String) bean
				.get(ManutencaoDadosCobrancaContants.OBSERVACAO));
		Contato contato = new Contato();
		contato.setNomeContato((String) bean
				.get(ManutencaoDadosCobrancaContants.NOME_CONTATO));
		FormaContatoTelefone formaContato = new FormaContatoTelefone();
		registroContato.setIdentificador(Long.valueOf(1));
		String telefone = (String) bean
				.get(ManutencaoDadosCobrancaContants.TELEFONE_CONTATO);

		// alterado pelo projeto nono digito.
		if (telefone != null && !telefone.equals("")) {
			if (telefone.substring(0, 1).equals("0")) {
				telefone = telefone.substring(1);
			}
			formaContato.setDDD(telefone.substring(0, 2));
			String telefoneFormatado = "";
			if (telefone.length() <= 11) {
				telefoneFormatado = telefone.substring(2);
			} else {
				// quem executou o serviço passou um telefone invalido
				// dessa forma estamos passando o telefone zerado para não
				// ocorrer erro na geração da ocorrencia
				telefoneFormatado = "00000000";
			}
			JAXBElement<String> telefoneContato = new ObjectFactory()
					.createFormaContatoTelefoneNumeroTelefone(telefoneFormatado);
			formaContato.setNumeroTelefone(telefoneContato);
		}

		contato.setFormaContato(formaContato);
		registroContato
				.setOrigemEvento(ManutencaoDadosCobrancaContants.INTERNET);

		Usuario usuario = new Usuario();
		usuario.setLoginUsuario(this.userInfo.getUserId());
		registroContato.setUsuario(usuario);
		registroContato.setContato(contato);
		incluirRegistroContato
				.setIdentificacaoContrato(identificacaoContratoType);
		incluirRegistroContato.setRegistroContato(registroContato);

		return incluirRegistroContato;
	}

	/**
	 * Gera header com as informacoes necessarias para a chamada de inserir
	 * Informacao Registro Contato
	 * 
	 * @param dadosContato
	 * @return
	 */
	private Header getHeaderWebService(DynamicBean bean) {

		// DynamicBean dynamicBean = (DynamicBean) bean;
		NETFrameworkWSHeader netFrameworkWSHeader = (NETFrameworkWSHeader) bean
				.get(ManutencaoDadosCobrancaContants.HEADER);
		Header header = new Header();

		header.setAplicacao(netFrameworkWSHeader.getAplicacao());
		header.setFuncionalidade(netFrameworkWSHeader.getFuncionalidade());
		header.setVersaoServico(netFrameworkWSHeader.getVersaoServico());
		header.setToken(netFrameworkWSHeader.getToken());
		header.setUsername(netFrameworkWSHeader.getUsername());

		Atendimento atendimento = new Atendimento();
		if (netFrameworkWSHeader.getAtendimento() != null) {
			atendimento.setNumeroChamada(netFrameworkWSHeader.getAtendimento()
					.getNumeroChamada());
			atendimento.setNumeroProtocolo(netFrameworkWSHeader
					.getAtendimento().getNumeroProtocolo());
		}
		header.setAtendimento(atendimento);

		return header;
	}

}
