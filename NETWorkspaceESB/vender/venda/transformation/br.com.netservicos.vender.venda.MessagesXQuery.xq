xquery version "1.0" encoding "Cp1252";
(:: pragma bea:global-element-return element="ns0:Messages" location="../../../modelocanonicoV2/geral/Message.xsd" ::)

declare namespace xf = "http://www.netservicos.com.br/vender/venda/transformation/br.com.netservicos.vender.venda.MessagesXQuery/";
declare namespace ns0 = "http://netservicos.com.br/core/schema";

declare function xf:getMessages()
as element(ns0:Messages) {
<ns0:Messages>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-VENDA-0000</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_SUCESSO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Opera��o executada com sucesso</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Opera��o executada com sucesso</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>INFO</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0001</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_NETHEADER_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>� obrigat�ria a informa��o do NETHeader para a opera��o solicitada.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>� obrigat�ria a informa��o do NETHeader para a opera��o solicitada.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0002</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_OPERACAO_INVALIDA</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>A opera��o solicitada para o servi�o n�o � v�lida.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>A opera��o solicitada para o servi�o n�o � v�lida.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0003</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>O campo identifica��o da campanha � obrigat�rio.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>O campo identifica��o da campanha � obrigat�rio.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0004</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>O campo descri��o da campanha � obrigat�rio.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>O campo de descri��o da campanha � obrigat�rio.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0005</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_ERRO_INESPERADO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Ocorreu um erro inesperado.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Ocorreu um erro inesperado.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0006</ns0:ID_MSG>
		<ns0:NOME_ERRO>CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Identificador do Canal de Venda � de preenchimento obrigat�rio.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Identificador do Canal de Venda � de preenchimento obrigat�rio.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0007</ns0:ID_MSG>
		<ns0:NOME_ERRO>CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Descri��o do Canal de Venda � de preenchimento obrigat�rio.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Descri��o do Canal de Venda � de preenchimento obrigat�rio.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0008</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Identificador da Empresa de Venda � de preenchimento obrigat�rio.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Identificador da Empresa de Venda � de preenchimento obrigat�rio.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0009</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Descri��o da Empresa de Venda � de preenchimento obrigat�rio.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Descri��o da Empresa de Venda � de preenchimento obrigat�rio.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0010</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Identificador da Equipe de Venda � de preenchimento obrigat�rio.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Identificador da Equipe de Venda � de preenchimento obrigat�rio.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0011</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Descri��o da Equipe de Venda � de preenchimento obrigat�rio.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Descri��o da Equipe de Venda � de preenchimento obrigat�rio.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0012</ns0:ID_MSG>
		<ns0:NOME_ERRO>CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Identificador do Vendedor � de preenchimento obrigat�rio.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Identificador do Vendedor � de preenchimento obrigat�rio.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0013</ns0:ID_MSG>
		<ns0:NOME_ERRO>CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Login do Vendedor � de preenchimento obrigat�rio.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Login do Vendedor � de preenchimento obrigat�rio.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0014</ns0:ID_MSG>
		<ns0:NOME_ERRO>CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Nome do Vendedor � de preenchimento obrigat�rio.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Nome do Vendedor � de preenchimento obrigat�rio.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0015</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Identificador da M�dia � de preenchimento obrigat�rio.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Identificador da M�dia � de preenchimento obrigat�rio.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0016</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Descri��o da M�dia � de preenchimento obrigat�rio.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Descri��o da M�dia � de preenchimento obrigat�rio.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0024</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Telefone � de preenchimento obrigat�rio.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Telefone � de preenchimento obrigat�rio.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0027</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_CAMPO_INVALIDO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Telefone deve ser num�rico.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Telefone deve ser num�rico.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0028</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_CAMPO_INVALIDO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>DDD deve ser num�rico.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>DDD deve ser num�rico.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0029</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_ERRO_INESPERADO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'Existe erro de cadastro no login {0}, por favor contatar o service desk.'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'Existe erro de cadastro no login {0}, por favor contatar o service desk.'}</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0031</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_ERRO_RECURSO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'Erro durante a execu��o do recurso: {0}.'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'Erro durante a execu��o do recurso: {0}.'}</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0032</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_REQUEST_INVALIDO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'Request Inv�lido: {0}.'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'Request Inv�lido: {0}.'}</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0033</ns0:ID_MSG>
		<ns0:NOME_ERRO></ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'O campo {0} � obrigat�rio.'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'O campo {0} � obrigat�rio.'}</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0034</ns0:ID_MSG>
		<ns0:NOME_ERRO>CAMPO_X_OU_CAMPO_Y_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'O campo {0} ou o campo {1} deve ser preenchido.'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'O campo {0} ou o campo {1} deve ser preenchido.'}</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0035</ns0:ID_MSG>
		<ns0:NOME_ERRO></ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Erro de valida��o.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Erro de valida��o.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0036</ns0:ID_MSG>
		<ns0:NOME_ERRO></ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Ocorreu um erro inesperado.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Ocorreu um erro inesperado.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0037</ns0:ID_MSG>
		<ns0:NOME_ERRO></ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Quantidade de n�meros maior que a permitida.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Quantidade de n�meros maior que a permitida.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0038</ns0:ID_MSG>
		<ns0:NOME_ERRO></ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'O hit {0} n�o foi encontrado, ou n�o est� em estado de envio.'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'O hit {0} n�o foi encontrado, ou n�o est� em estado de envio.'}</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0039</ns0:ID_MSG>
		<ns0:NOME_ERRO></ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'N�o � poss�vel enviar o hit {0} nesta execu��o pois ele n�o est� em status compat�vel.'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'N�o � poss�vel enviar o hit {0} nesta execu��o pois ele n�o est� em status compat�vel.'}</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0040</ns0:ID_MSG>
		<ns0:NOME_ERRO></ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'Erro inesperado na integracao com a Embratel. {0}'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'Erro inesperado na integracao com a Embratel. {0}'}</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	
        <ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0041</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_REQUEST_INVALIDO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'Request Inv�lido: {0}.'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'Request Inv�lido: {0}.'}</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-VENDA-0042</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'{0} � obrigat�rio.'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'{0} � obrigat�rio.'}</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
    <ns0:Message>
	  <ns0:ID_MSG>ESB-VENDA-0043</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_ERRO_INESPERADO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Erro durante a execu��o do recurso: {0}.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Erro durante a execu��o do recurso: {0}.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
    <ns0:Message>
	  <ns0:ID_MSG>ESB-VENDA-0044</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Para checagem de cr�dito de pessoa f�sica os campos nomeCliente e dataNascimento devem ser preenchidos'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Para checagem de cr�dito de pessoa f�sica os campos nomeCliente e dataNascimento devem ser preenchidos'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
</ns0:Messages>
};

xf:getMessages()