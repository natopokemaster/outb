xquery version "1.0" encoding "ISO-8859-1";
(:: pragma bea:global-element-parameter parameter="$messages" element="ns0:Messages" location="../../modelocanonicoV2/geral/Message.xsd" ::)
(:: pragma bea:global-element-return element="ns0:Messages" location="../../modelocanonicoV2/geral/Message.xsd" ::)

declare namespace xf = "http://www.netservicos.com.br/ativar/roteamento/transformation/br.com.netservicos.ativar.roteamento.MessagesXQuery/";
declare namespace ns0 = "http://netservicos.com.br/core/schema";

declare function xf:getMessages()
as element(ns0:Messages) {
<ns0:Messages>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0000</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_SUCESSO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Opera��o executada com sucesso</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Opera��o executada com sucesso</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>INFO</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0001</ns0:ID_MSG>
	  <ns0:NOME_ERRO>PARAMETROS_OBRIGATORIOS_NAO_PREENCHIDOS</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Ou Contrato ou Smart Card ou Protocolo ou Endereco MAC devem ser informados.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Ou Contrato ou Smart Card ou Protocolo ou Endereco MAC devem ser informados.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0002</ns0:ID_MSG>
	  <ns0:NOME_ERRO>CIDADE_NAO_ENCONTRADA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Cidade n�o encontrada para a operadora informada.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Cidade n�o encontrada para a operadora informada.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0003</ns0:ID_MSG>
	  <ns0:NOME_ERRO>EQUIPAMENTO_NAO_ASSINANTE</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Equipamento vinculado ao Smartcard ou Endere�o Mac informado, n�o est� vinculado a um assinante.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Equipamento vinculado ao Smartcard ou Endere�o Mac informado, n�o est� vinculado a um assinante.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0004</ns0:ID_MSG>
	  <ns0:NOME_ERRO>CIDADE_NAO_ENCONTRADA_PROTOCOLO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Cidade / Operadora n�o encontrada para Protocolo Informado. Verifique o Protocolo.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Cidade / Operadora n�o encontrada para Protocolo Informado. Verifique o Protocolo.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0005</ns0:ID_MSG>
	  <ns0:NOME_ERRO>CONTRATO_NAO_ENCONTRADO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Contrato n�o encontrado para os par�metros informados.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Contrato n�o encontrado para os par�metros informados.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0006</ns0:ID_MSG>
	  <ns0:NOME_ERRO>OPERADORA_NAO_ENCONTRADA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Operadora n�o encontrada para a ciadade informada.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Operadora n�o encontrada para a ciadade informada.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0007</ns0:ID_MSG>
	  <ns0:NOME_ERRO>CIDADE_OU_OPERADORA_OBRIGATORIO_NAO_PREENCHIDO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Quando o contrato � informado � obrigat�rio informar a Operadora ou C�digo da Cidade onde o contrato est� localizado.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Quando o contrato � informado � obrigat�rio informar a Operadora ou C�digo da Cidade onde o contrato est� localizado.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0008</ns0:ID_MSG>
	  <ns0:NOME_ERRO>MENSAGEM_ERRO_NAO_ENCONTRADA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>N�o foi poss�vel determinar a mensagem de erro adequada, considerando os par�metros informados.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>N�o foi poss�vel determinar a mensagem de erro adequada, considerando os par�metros informados.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0009</ns0:ID_MSG>
	  <ns0:NOME_ERRO>FALHA_AO_TRATAR_ERRO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Ocorreu uma falha ao tratar a mensagem de erro.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Ocorreu uma falha ao tratar a mensagem de erro.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0010</ns0:ID_MSG>
	  <ns0:NOME_ERRO>FALHA_AO_EXECUTAR_OPERACAO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'A opera��o {0} foi executada, por�m n�o apresentou o resultado esperado: {1}.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'A opera��o {0} foi executada, por�m n�o apresentou o resultado esperado: {1}. Verifique os detalhes do erro.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0011</ns0:ID_MSG>
	  <ns0:NOME_ERRO>CAMPO_OBRIGATORIO_NAO_PREENCHIDO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Codigo da Operadora ou Identificador da Cidade devem estar preenchidos.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Codigo da Operadora ou Identificador da Cidade devem estar preenchidos.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0012</ns0:ID_MSG>
	  <ns0:NOME_ERRO>BASE_NAO_IDENTIFICADA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Nao foi possivel identificar a base.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Nao foi possivel identificar a base.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0013</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_ERRO_INESPERADO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Ocorreu um erro inesperado.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Ocorreu um erro inesperado.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0014</ns0:ID_MSG>
	  <ns0:NOME_ERRO>MESSAGE_CODE_NAO_PREENCHIDO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>O par�metro c�digo da mensagem n�o foi informado e � obrigat�rio.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>O par�metro c�digo da mensagem n�o foi informado e � obrigat�rio.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0015</ns0:ID_MSG>
	  <ns0:NOME_ERRO>VERSAO_SOAP_INVALIDA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Parametro vers�o de SOAP inv�lido. Apenas Vers�es 1.1 e 1.2 s�o suportadas.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Parametro vers�o de SOAP inv�lido. Apenas Vers�es 1.1 e 1.2 s�o suportadas.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>			
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0016</ns0:ID_MSG>
	  <ns0:NOME_ERRO>BUSCA_MENSAGEM_NOK</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Ocorreu um problema ao identificar localizar a mensagem do c�digo enviado.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Ocorreu um problema ao identificar localizar a mensagem do c�digo enviado.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0026</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_ERRO_INESPERADO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Ocorreu um erro inesperado.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Ocorreu um erro inesperado.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0027</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_ERRO_INFORMACAO_OBRIGATORIA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>� necess�rio informar o protocolo ou a proposta.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>� necess�rio informar o protocolo ou a proposta.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0028</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_ERRO_INFORMACAO_OBRIGATORIA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>� necess�rio informar c�digo da operadora ou identificador da cidade.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>� necess�rio informar c�digo da operadora ou identificador da cidade.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0029</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_ERRO_IDENTIFICACAO_OPERADORA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>N�o foi poss�vel identificar a operadora do protocolo.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>N�o foi poss�vel identificar a operadora do protocolo.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0030</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_ERRO_EXCESSO_INFORMACOES</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>� necess�rio informar apenas uma das entidades: identificacaoContrato ou identificacaoProposta.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>� necess�rio informar apenas uma das entidades: identificacaoContrato ou identificacaoProposta.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0031</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_ERRO_INFORMACAO_OBRIGATORIA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>� necess�rio informar identificacaoContrato ou identificaoProposta.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>� necess�rio informar identificacaoContrato ou identificaoProposta</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0032</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_ERRO_BUSCA_PROTOCOLO_NAO_SUPORTADA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>A busca por protocolo ainda n�o � suportada nesta vers�o.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>A busca por protocolo ainda n�o � suportada nesta vers�o.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
</ns0:Messages>
};

declare function xf:SearchMessagesXQuery($messageCode as xs:string)
    as element(ns0:Messages) {
        <ns0:Messages>
            {
                for $MensagemRow in xf:getMessages()/ns0:Message[ns0:ID_MSG = $messageCode]
                return
                    <ns0:Message>{ $MensagemRow/@* , $MensagemRow/node() }</ns0:Message>
            }
        </ns0:Messages> 
};

declare variable $messages as element(ns0:Messages) external;
declare variable $messageCode as xs:string external;

xf:SearchMessagesXQuery(
    $messageCode)