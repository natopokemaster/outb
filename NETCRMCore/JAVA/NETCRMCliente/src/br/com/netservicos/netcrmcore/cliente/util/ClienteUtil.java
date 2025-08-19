package br.com.netservicos.netcrmcore.cliente.util;

import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.ASSINANTE_CNPJ;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.ASSINANTE_CPF;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.ASSINANTE_DATA_NASCIMENTO;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.ASSINANTE_NOME_TITULAR;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.ASSINANTE_TIPO_PESSOA;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.ASSINANTE_TIPO_PESSOA_FISICA;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.CONTRATO_CIDADE;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.CONTRATO_NUM_CONTRATO;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.DADOS_CONTATO_TELEFONE_CELULAR;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.DADOS_CONTATO_TELEFONE_COMERCIAL;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.DADOS_CONTATO_TELEFONE_RESIDENCIAL;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.DADOS_REGISTRO_CONTATO_DDD_TELEFONE;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.DADOS_REGISTRO_CONTATO_EVENTO;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.DADOS_REGISTRO_CONTATO_NOME_CONTATO;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.DADOS_REGISTRO_CONTATO_NUMERO_TELEFONE;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.DADOS_REGISTRO_CONTATO_TIPO_EVENTO_REQUISICAO_INTERNA;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.NET_HEADER_APLICACAO;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.NET_HEADER_FUNCIONALIDADE;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.NET_HEADER_NUMERO_CHAMADA;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.NET_HEADER_NUMERO_PROTOCOLO;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.NET_HEADER_TOKEN;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.NET_HEADER_USERNAME;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.NET_HEADER_VERSAO_SERVICO;

import java.util.Calendar;
import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import br.com.netservicos.atendimento.evento.registrocontato.IncluirRegistroContato;
import br.com.netservicos.atendimento.evento.requisicaointerna.IncluirRequisicaoInterna;
import br.com.netservicos.core.bean.sn.SnTipoOcorrenciaBean;
import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.modelocanonico.evento.ws.types.Contato;
import br.com.netservicos.modelocanonico.evento.ws.types.FormaContatoTelefone;
import br.com.netservicos.modelocanonico.evento.ws.types.ObjectFactory;
import br.com.netservicos.modelocanonico.evento.ws.types.OrdemInterna;
import br.com.netservicos.modelocanonico.evento.ws.types.RegistroContato;
import br.com.netservicos.modelocanonico.evento.ws.types.TipoEvento;
import br.com.netservicos.modelocanonico.usuario.ws.types.EmailType;
import br.com.netservicos.modelocanonico.usuario.ws.types.Usuario;
import br.com.netservicos.modelocanonico.v2.identificacaocontrato.ContratoType;
import br.com.netservicos.modelocanonico.v2.identificacaocontrato.IdentificacaoContratoType;
import br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants;
import br.com.netservicos.netheader.ws.types.Atendimento;
import br.com.netservicos.netheader.ws.types.Header;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

public class ClienteUtil {

	private static final String NEW_LINE = System.getProperty("line.separator");
	private static final String NECESSARIO_ALTERACAO_PARA = "NECESSÁRIO ALTERAÇÃO PARA: ";

	/**
	 * 
	 * Retorna a propriedade de um bean. Se estiver null, retorna String vazia.
	 * 
	 * @param b
	 * @param property
	 * @return
	 * 
	 * @since 11/01/2010
	 */
	public static String getBeanProperty(Bean b, String property) {
		String res = b.getBeanProperty(property);
		
		if (res == null) {
			res = "";
		}
		
		return res;
	}

	/**
	 * 
	 * Operacao que verifica se esta atualizando um atributo da base de dados. Considera null e string vazia
	 * como iguais.
	 * 
	 * @param newValue
	 * @param dbValue
	 * @return
	 * 
	 * @since 11/01/2010
	 */
	public static boolean isUpdating(String newValue, String dbValue) {
		boolean updating = false;
		// Considera null e vazio como iguais
		if (dbValue == null) {
			dbValue = "";
		}
		if (newValue == null) {
			newValue = "";
		}
		
		if (!newValue.equals(dbValue)) {
			updating = true;
		}
		
		return updating;
	}

	/**
	 * Gera payload com as informacoes necessarias para o registro contato:
	 * 
	 * @param dadosContato
	 * @return
	 */
	public static IncluirRegistroContato getPayloadRegistroContato(Bean bean, String observacoes, String userName,
			SnTipoOcorrenciaBean snTipoOcorrencia) {
		// Payload
		IncluirRegistroContato incluirRegistroContato = new IncluirRegistroContato();
		
		// REGISTRO CONTATO
		RegistroContato registroContato = new RegistroContato();
		
		// Usuario
		Usuario usuario = new Usuario();
		usuario.setLoginUsuario(userName);
		EmailType email = new EmailType();
		usuario.setEmailUsuario(email);
		
		registroContato.setUsuario(usuario);
		
		// TipoEvento
		TipoEvento tipoEvento = new TipoEvento();
		// tipoEvento.identificador = 1
		tipoEvento.setIdentificador(snTipoOcorrencia.getIdTipoOcorrencia());
		tipoEvento.setDescricao(snTipoOcorrencia.getDescricao()); 
		registroContato.setTipo(tipoEvento);
		
		// Observacao => Recebido no request
		StringBuffer observacao = new StringBuffer();
		if (getBeanProperty(bean,ClienteConstants.DADOS_REGISTRO_CONTATO_OBSERVACAO) != null) {
			observacao.append(
					getBeanProperty(bean,ClienteConstants.DADOS_REGISTRO_CONTATO_OBSERVACAO)).append(NEW_LINE);
		}
		observacao.append(observacoes);
		registroContato.setObservacao(observacao.toString());

		// Data Evento
		XMLGregorianCalendar xmlGregorianCalendar = new XMLGregorianCalendarImpl();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		xmlGregorianCalendar.setYear(calendar.get(Calendar.YEAR));
		xmlGregorianCalendar.setDay(calendar.get(Calendar.DAY_OF_MONTH));
		xmlGregorianCalendar.setMonth(calendar.get(Calendar.MONTH)+ 1);
		registroContato.setDataEvento(xmlGregorianCalendar);
		
		// Contato => Recebido no request
		Contato contato = new Contato();
		contato.setNomeContato(getBeanProperty(bean, DADOS_REGISTRO_CONTATO_NOME_CONTATO));
		FormaContatoTelefone formaContatoTelefone = new FormaContatoTelefone();
		if (getBeanProperty(bean, DADOS_REGISTRO_CONTATO_DDD_TELEFONE) != null) {
			formaContatoTelefone.setDDD(getBeanProperty(bean, DADOS_REGISTRO_CONTATO_DDD_TELEFONE));
		}
		if (getBeanProperty(bean, DADOS_REGISTRO_CONTATO_NUMERO_TELEFONE) != null) {
			formaContatoTelefone.setNumeroTelefone(
					new ObjectFactory().createFormaContatoTelefoneNumeroTelefone(
							getBeanProperty(bean, DADOS_REGISTRO_CONTATO_NUMERO_TELEFONE)));
		}
		contato.setFormaContato(formaContatoTelefone);
		registroContato.setContato(contato);

		// origemOcorrencia => Utilizar o elemento sistema do NETHeader
		//TODO getBeanProperty(dadosContato, NET_HEADER_APLICACAO));
		registroContato.setOrigemEvento("TELEFONE");
		
		incluirRegistroContato.setRegistroContato(registroContato);
		
		// IDENTIFICACAO CONTRATO
		br.com.netservicos.modelocanonico.v2.identificacaocontrato.IdentificacaoContratoType identificacaoContratoType 
			= new IdentificacaoContratoType();
		
		// contratoNET => Indentificação do contrato, recebido no request.
		ContratoType contratoType = new ContratoType();
		contratoType.setNumeroContrato(Long.valueOf(getBeanProperty(bean, CONTRATO_NUM_CONTRATO)));

		// operadoraNET => Criar uma OperaraNET com base na operadora corrent
		contratoType.setIdentificacaoCidade(getBeanProperty(bean, CONTRATO_CIDADE));
		
		identificacaoContratoType.setContrato(contratoType);
		incluirRegistroContato.setIdentificacaoContrato(identificacaoContratoType);

		return incluirRegistroContato;
	}
	
	
	/**
	 * Gera payload com as informacoes necessarias para o registro contato:
	 * 
	 * @param dadosContato
	 * @return
	 */
	public static IncluirRequisicaoInterna getPayloadRequisicaoInterna(String observacao, Bean bean, String userName) 
	{
		IncluirRequisicaoInterna incluirRequisicaoInterna = new IncluirRequisicaoInterna();
		
		// IDENTIFICACAO CONTRATO
		IdentificacaoContratoType identificacaoContratoType = new IdentificacaoContratoType();
		incluirRequisicaoInterna.setIdentificacaoContrato(identificacaoContratoType);
		
		// contratoNET => Indentificação do contrato, recebido no request.
		ContratoType contratoType = new ContratoType();
		identificacaoContratoType.setContrato(contratoType);
		
		// operadoraNET => Criar uma OperaraNET com base na operadora corrent
		contratoType.setIdentificacaoCidade(getBeanProperty(bean, CONTRATO_CIDADE));
		contratoType.setNumeroContrato(Long.valueOf(getBeanProperty(bean, CONTRATO_NUM_CONTRATO)));

		// Informacoes Payload
		OrdemInterna ordemInterna = new OrdemInterna();
		incluirRequisicaoInterna.setOrdemInterna(ordemInterna);
		
		// Usuario
		Usuario usuario = new Usuario();
		usuario.setLoginUsuario(userName);
		usuario.setEmailUsuario(new EmailType());
		ordemInterna.setUsuario(usuario);
		
		// evento
		TipoEvento tipoEvento = new TipoEvento();
		tipoEvento.setIdentificador(Long.valueOf(DADOS_REGISTRO_CONTATO_EVENTO)); // evento => 1
		tipoEvento.setDescricao(DADOS_REGISTRO_CONTATO_TIPO_EVENTO_REQUISICAO_INTERNA); 
		ordemInterna.setTipo(tipoEvento);
		
		StringBuffer observacoes = new StringBuffer();
		observacoes.append(NECESSARIO_ALTERACAO_PARA).append(NEW_LINE);
		
		// observacao => Recebido no request
		if (getBeanProperty(bean,ClienteConstants.DADOS_REGISTRO_CONTATO_OBSERVACAO) != null) {
			observacoes.append(
					getBeanProperty(bean,ClienteConstants.DADOS_REGISTRO_CONTATO_OBSERVACAO)).append(NEW_LINE);
		}
		observacoes.append(observacao);
		ordemInterna.setObservacao(observacoes.toString());
		
		XMLGregorianCalendar xmlGregorianCalendar = new XMLGregorianCalendarImpl();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		xmlGregorianCalendar.setYear(calendar.get(Calendar.YEAR));
		xmlGregorianCalendar.setDay(calendar.get(Calendar.DAY_OF_MONTH));
		xmlGregorianCalendar.setMonth(calendar.get(Calendar.MONTH)+ 1);
		ordemInterna.setDataEvento(xmlGregorianCalendar);
		
		// nomeContato => Recebido no request
		// CONTATO
		Contato contato = new Contato();
		contato.setNomeContato(getBeanProperty(bean, DADOS_REGISTRO_CONTATO_NOME_CONTATO));
		FormaContatoTelefone formaContatoTelefone = new FormaContatoTelefone();
		if (getBeanProperty(bean, DADOS_REGISTRO_CONTATO_DDD_TELEFONE) != null) {
			formaContatoTelefone.setDDD(getBeanProperty(bean, DADOS_REGISTRO_CONTATO_DDD_TELEFONE));
		}
		if (getBeanProperty(bean, DADOS_REGISTRO_CONTATO_NUMERO_TELEFONE) != null) {
			formaContatoTelefone.setNumeroTelefone(
					new ObjectFactory().createFormaContatoTelefoneNumeroTelefone(
							getBeanProperty(bean, DADOS_REGISTRO_CONTATO_NUMERO_TELEFONE)));
		}
		contato.setFormaContato(formaContatoTelefone);
		ordemInterna.setContato(contato);

		// origemOcorrencia => Utilizar o elemento sistema do NETHeader
		ordemInterna.setOrigemEvento("TELEFONE"); //TODO getBeanProperty(dadosContato, NET_HEADER_APLICACAO));
		
		// telefoneContato => Recebido no request
		// TODO onde setar esse fone??

		return incluirRequisicaoInterna;
		
	}
	
	/**
	 * Gera header com as informacoes necessarias para a chamada de 
	 * inserir Informacao Registro Contato
	 * 
	 * @param dadosContato
	 * @return
	 */
	public static Header getHeaderWebService(Bean bean) {
		Header header = new Header();
		
		header.setAplicacao(getBeanProperty(bean, NET_HEADER_APLICACAO));
		header.setFuncionalidade(getBeanProperty(bean, NET_HEADER_FUNCIONALIDADE));
		header.setVersaoServico(getBeanProperty(bean, NET_HEADER_VERSAO_SERVICO));
		header.setToken(getBeanProperty(bean, NET_HEADER_TOKEN));
		header.setUsername(getBeanProperty(bean,NET_HEADER_USERNAME)); 
		Atendimento atendimento = new Atendimento();
		atendimento.setNumeroChamada(getBeanProperty(bean, NET_HEADER_NUMERO_CHAMADA));
		atendimento.setNumeroProtocolo(getBeanProperty(bean, NET_HEADER_NUMERO_PROTOCOLO));
		header.setAtendimento(atendimento);

		return header;
	}

	/**
	 * 
	 * Completa com letras à esquerda
	 * 
	 * @param valueToPad
	 * @param filler
	 * @param size
	 * @return
	 * 
	 * @since 19/01/2010
	 */
	public static String lpad(String valueToPad, String filler, int size) {
		
		if (valueToPad != null && !valueToPad.trim().isEmpty()){
			StringBuilder builder = new StringBuilder();

			while (builder.length() + valueToPad.length() < size) {
				builder.append(filler);
			}
			builder.append(valueToPad);
			return builder.toString();
		}
		
		return "";
	}  
	public static String montarLogEntradaDadosRegistroContato(IncluirRegistroContato registroContato) {
		StringBuffer dadosRegistroContato = new StringBuffer();
		dadosRegistroContato.append("Registro Contato: ");
		dadosRegistroContato.append(getLineFeed());
		dadosRegistroContato.append("Identificação Contrato: ");
		dadosRegistroContato.append(registroContato.getIdentificacaoContrato());
		dadosRegistroContato.append(getLineFeed());
		dadosRegistroContato.append("Identificador: ");
		dadosRegistroContato.append(registroContato.getRegistroContato().getIdentificador());
		dadosRegistroContato.append(getLineFeed());
		dadosRegistroContato.append("Tipo Evento: ");
		dadosRegistroContato.append(registroContato.getRegistroContato().getTipo());
		dadosRegistroContato.append(getLineFeed());
		dadosRegistroContato.append("Usuário: ");
		dadosRegistroContato.append(registroContato.getRegistroContato().getUsuario());
		dadosRegistroContato.append(getLineFeed());
		dadosRegistroContato.append("Origem Evento: ");
		dadosRegistroContato.append(registroContato.getRegistroContato().getOrigemEvento());
		dadosRegistroContato.append(getLineFeed());
		dadosRegistroContato.append("Descrição: ");
		dadosRegistroContato.append(registroContato.getRegistroContato().getDescricao());
		dadosRegistroContato.append(getLineFeed());
		dadosRegistroContato.append("Observação: ");
		dadosRegistroContato.append(registroContato.getRegistroContato().getObservacao());
		return registroContato.toString();
	}
	public static String montarLogEntradaDadosCadastrais(Bean dadosCadastrais){
		StringBuffer dados = new StringBuffer();
		dados.append(NET_HEADER_USERNAME + ": " + 
				getBeanProperty(dadosCadastrais, NET_HEADER_USERNAME));
		dados.append(getLineFeed());
		dados.append(CONTRATO_CIDADE + ": " + 
				getBeanProperty(dadosCadastrais, CONTRATO_CIDADE));
		dados.append(getLineFeed());
		dados.append(CONTRATO_NUM_CONTRATO + ": " + 
				getBeanProperty(dadosCadastrais, CONTRATO_NUM_CONTRATO));
		dados.append(getLineFeed());
		dados.append(ASSINANTE_NOME_TITULAR + ": " + 
				getBeanProperty(dadosCadastrais, ASSINANTE_NOME_TITULAR));
		dados.append(getLineFeed());
		dados.append(ASSINANTE_DATA_NASCIMENTO + ": " +
				getBeanProperty(dadosCadastrais, ASSINANTE_DATA_NASCIMENTO));
		dados.append(getLineFeed());
		String tipoPessoa = getBeanProperty(dadosCadastrais, ASSINANTE_TIPO_PESSOA);
		dados.append(ASSINANTE_TIPO_PESSOA + ": " + tipoPessoa);
		if (tipoPessoa.equals(ASSINANTE_TIPO_PESSOA_FISICA)) {
			dados.append(ASSINANTE_CPF + ": " + 
					getBeanProperty(dadosCadastrais, ASSINANTE_CPF));
		} else {
			dados.append(ASSINANTE_CNPJ + ": " +
					getBeanProperty(dadosCadastrais, ASSINANTE_CNPJ));
		}
		dados.append(getLineFeed());
		return dados.toString();
	}
	public static String montarLogEntradaDadosContato(Bean dadosContato){
		StringBuffer dados = new StringBuffer();
		dados.append(NET_HEADER_USERNAME + ": " + 
				getBeanProperty(dadosContato, NET_HEADER_USERNAME));
		dados.append(getLineFeed());
		dados.append(CONTRATO_CIDADE + ": " + 
				getBeanProperty(dadosContato, CONTRATO_CIDADE));
		dados.append(getLineFeed());
		dados.append(CONTRATO_NUM_CONTRATO + ": " + 
				getBeanProperty(dadosContato, CONTRATO_NUM_CONTRATO));
		dados.append(getLineFeed());
		dados.append(DADOS_CONTATO_TELEFONE_CELULAR + ": " + 
				getBeanProperty(dadosContato, DADOS_CONTATO_TELEFONE_CELULAR));
		dados.append(getLineFeed());
		dados.append(DADOS_CONTATO_TELEFONE_COMERCIAL + ": " +
				getBeanProperty(dadosContato, DADOS_CONTATO_TELEFONE_COMERCIAL));
		dados.append(getLineFeed());
		dados.append(DADOS_CONTATO_TELEFONE_RESIDENCIAL + ": " +
				getBeanProperty(dadosContato, DADOS_CONTATO_TELEFONE_RESIDENCIAL));
		dados.append(getLineFeed());
		return dados.toString();
	}
	public static String getLineFeed(){
		return NEW_LINE;
	}
}
