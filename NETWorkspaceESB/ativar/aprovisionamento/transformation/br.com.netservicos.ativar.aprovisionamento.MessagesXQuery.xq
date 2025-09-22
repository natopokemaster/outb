xquery version "1.0" encoding "Cp1252";
(:: pragma bea:global-element-return element="ns0:Messages" location="../../../modelocanonicoV2/geral/Message.xsd" ::)

declare namespace xf = "http://www.netservicos.com.br/ativar/aprovisionamento/transformation/br.com.netservicos.ativar.aprovisionamento.MessagesXQuery/";
declare namespace ns0 = "http://netservicos.com.br/core/schema";

declare function xf:getMessages()
as element(ns0:Messages) {
<ns0:Messages>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-APROV-0000</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_SUCESSO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Opera��o executada com sucesso</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Opera��o executada com sucesso</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>INFO</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
    <ns0:Message>
	  <ns0:ID_MSG>ESB-APROV-0001</ns0:ID_MSG>
	  <ns0:NOME_ERRO></ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'O campo {0} � obrigat�rio.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'O campo {0} � obrigat�rio.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-APROV-0002</ns0:ID_MSG>
	  <ns0:NOME_ERRO></ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'O campo {0} ou o campo {1} deve ser preenchido.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'O campo {0} ou o campo {1} deve ser preenchido.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-APROV-0003</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_ERRO_RECURSO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Erro durante a execu��o do recurso: {0}.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Erro durante a execu��o do recurso: {0}.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-APROV-0004</ns0:ID_MSG>
	  <ns0:NOME_ERRO></ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'O HIT obtido � inv�lido. {0}.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'O HIT obtido � inv�lido. {0}.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-APROV-0005</ns0:ID_MSG>
	  <ns0:NOME_ERRO></ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Request inv�lido. {0}.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Request inv�lido. {0}.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>		
		<ns0:Message>
	  <ns0:ID_MSG>ESB-APROV-0007</ns0:ID_MSG>
	  <ns0:NOME_ERRO></ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Erro de valida��o.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Erro de valida��o.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
	  <ns0:ID_MSG>ESB-APROV-0008</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_ERRO_INESPERADO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Ocorreu um erro inesperado.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Ocorreu um erro inesperado.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-APROV-0009</ns0:ID_MSG>
	  <ns0:NOME_ERRO></ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Reiniciar processamento.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Reiniciar processamento.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
	  <ns0:ID_MSG>ESB-APROV-0010</ns0:ID_MSG>
	  <ns0:NOME_ERRO></ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Hit n�o encontrado.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Hit n�o encontrado.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-APROV-0011</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_OPERACAO_INVALIDA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>A opera��o solicitada para o servi�o n�o � v�lida.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>A opera��o solicitada para o servi�o n�o � v�lida.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-APROV-0012</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'{0} � de preenchimento obrigat�rio.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'{0} � de preenchimento obrigat�rio.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-APROV-0013</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_ERRO_VALIDACAO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Ocorreu um erro de valida��o.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Ocorreu um erro de valida��o.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-APROV-0014</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_REQUEST_INVALIDO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Request Inv�lido {0}.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Request Inv�lido {0}.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-APROV-0015</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_PERIODO_INVALIDO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Informe per�odo ou quantidade de registros para executar a pesquisa.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Informe per�odo ou quantidade de registros para executar a pesquisa.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>

	<ns0:Message>
		<ns0:ID_MSG>ESB-APROV-0016</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_PERIODO_INCONSISTENTE</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>O Per�odo informado est� inconsistente.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>O Per�odo informado est� inconsistente.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-APROV-0017</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_FORMATO_INVALIDO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'Formato inv�lido para o campo {0}.'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'Formato inv�lido para o campo {0}.'}</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
<ns0:Message>
	  <ns0:ID_MSG>ESB-APROV-0018</ns0:ID_MSG>
	  <ns0:NOME_ERRO>CONCORRENCIA_ENVIO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'N�o � poss�vel enviar o hit {0} nesta execu��o pois ele n�o est� em status compat�vel.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'N�o � poss�vel enviar o hit {0} nesta execu��o pois ele n�o est� em status compat�vel.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-APROV-0019</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ERRO_INTEGRACAO_EMBRATEL</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Erro inesperado na integracao com a Embratel. {0}'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Erro inesperado na integracao com a Embratel. {0}'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
		<ns0:ID_MSG>ESB-APROV-0021</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_ALTERACAO_ORDEM</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'N�o foi poss�vel alterar o status da ordem de ativa��o {0}.'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'N�o foi poss�vel alterar o status da ordem de ativa��o {0}.'}</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-APROV-0022</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_FORMATO_DATA_INVALIDA</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'O(s) campo(s) {0} cont�m formato de data inv�lido.'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'O(s) campo(s) {0} cont�m formato de data inv�lido.'}</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-APROV-0023</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_DATA_FIM_MENOR_DATA_INICIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'O(s) campo(s) {0} cont�m a Data Fim menor que Data In�cio.'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'O(s) campo(s) {0} cont�m a Data Fim menor que Data In�cio.'}</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
		<ns0:ID_MSG>ESB-APROV-0024</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_ERRO_INESPERADO_CLARO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'Erro inesperado com a integra磯 com a Claro.'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'Erro inesperado com a integra磯 com a Claro.'}</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
</ns0:Messages>
};

xf:getMessages()