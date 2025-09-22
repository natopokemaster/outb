xquery version "1.0" encoding "ISO-8859-1";
(:: pragma bea:global-element-parameter parameter="$messages" element="ns0:Messages" location="../../../modelocanonicoV2/geral/Message.xsd" ::)
(:: pragma bea:global-element-return element="ns0:Messages" location="../../../modelocanonicoV2/geral/Message.xsd" ::)

declare namespace xf = "http://www.netservicos.com.br/ativar/roteamento/transformation/br.com.netservicos.ativar.roteamento.MessagesXQuery/";
declare namespace ns0 = "http://netservicos.com.br/core/schema";

declare function xf:getMessages()
as element(ns0:Messages) {
<ns0:Messages>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0000</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_SUCESSO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Opera��o executada com sucesso</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Opera��o executada com sucesso</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>INFO</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0001</ns0:ID_MSG>
	  <ns0:NOME_ERRO>CAMPO_OBRIGATIO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Campo {0} � obrigat�rio.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Campo {0} � obrigat�rio.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERRO</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0002</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ALTERACAO_COBRANCA_NAO_REALIZADA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Nenhuma altera��o foi realizada.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Nenhuma altera��o foi realizada.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>INFO</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0005</ns0:ID_MSG>
	  <ns0:NOME_ERRO>NUMERO_CONTRATO_OBRIGATORIO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>O Numero do Contrato e obrigat�rio.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>O Numero do Contrato e obrigat�rio.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERRO</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0006</ns0:ID_MSG>
	  <ns0:NOME_ERRO>CONTRATO_OU_PROPOSTA_NAO_IDENTIFICADOS</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>N�o foi poss�vel identificar a proposta ou contrato a ser consultado os dados da cobran�a.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>N�o foi poss�vel identificar a proposta ou contrato a ser consultado os dados da cobran�a.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERRO</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0007</ns0:ID_MSG>
	  <ns0:NOME_ERRO></ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'O hit {0} n�o foi encontrado ou n�o est� em estado de envio.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'O hit {0} n�o foi encontrado ou n�o est� em estado de envio.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0008</ns0:ID_MSG>
	  <ns0:NOME_ERRO></ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'N�o � poss�vel enviar o hit {0} nesta execu��o pois ele n�o est� em status compat�vel.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'N�o � poss�vel enviar o hit {0} nesta execu��o pois ele n�o est� em status compat�vel.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0010</ns0:ID_MSG>
	  <ns0:NOME_ERRO></ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Erro inesperado na integracao com a Embratel. {0}'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Erro inesperado na integracao com a Embratel. {0}'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0011</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ERRO_BASE_NAO_IDENTIFICADA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Nao foi possivel identificar a base.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Nao foi possivel identificar a base..</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERRO</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0012</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ERRO_BUSCA_FORMA_PAGAMENTO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Nao foi possivel listar a forma de pagamento.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Nao foi possivel listar a forma de pagamento.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERRO</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0013</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ERRO_BUSCA_DADO_COBRANCA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>N�o foi poss�vel consultar os dados de cobran�a do contrato ou proposta informados.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>N�o foi poss�vel consultar os dados de cobran�a do contrato ou proposta informados.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERRO</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0014</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ALTERACAO_PARAMETRO_OBRIGATORIO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>� obrigat�rio informar o IndicadorCoboletamento ou o TipoPostagem.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>� obrigat�rio informar o IndicadorCoboletamento ou o TipoPostagem.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERRO</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0015</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ALTERACAO_DADOS_IDENTICOS</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Dados informados para altera��o sao identicos aos ja cadastrados.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Dados informados para altera��o sao identicos aos ja cadastrados.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERRO</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0016</ns0:ID_MSG>
	  <ns0:NOME_ERRO>DADO_INCORRETO_INDICADORCOBOLETAMENTO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'O valor do campo {0} deve ser {1} ou {2}.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'O valor do campo {0} deve ser {1} ou {2}.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERRO</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0017</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ALTERACAO_COBOLETAMENTO_PROPOSTA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Indicador de Co-Boletamento n�o pode ser alterado na proposta.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Indicador de Co-Boletamento n�o pode ser alterado na proposta.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERRO</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0018</ns0:ID_MSG>
	  <ns0:NOME_ERRO></ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'O campo {0} ou o campo {1} deve ser preenchido.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'O campo {0} ou o campo {1} deve ser preenchido.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0019</ns0:ID_MSG>
	  <ns0:NOME_ERRO></ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Erro durante a execu��o do recurso: {0}.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Erro durante a execu��o do recurso: {0}.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0020</ns0:ID_MSG>
	  <ns0:NOME_ERRO></ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'O HIT obtido � inv�lido. {0}.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'O HIT obtido � inv�lido. {0}.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0021</ns0:ID_MSG>
	  <ns0:NOME_ERRO></ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Erro de valida��o.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Erro de valida��o.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0022</ns0:ID_MSG>
	  <ns0:NOME_ERRO></ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Ocorreu um erro inesperado.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Ocorreu um erro inesperado.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0023</ns0:ID_MSG>
	  <ns0:NOME_ERRO></ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Hit n�o encontrado.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Hit n�o encontrado.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
    <ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0024</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_ERRO_INESPERADO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Erro inesperado ao acessar recurso: {0}.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Erro inesperado ao acessar recurso: {0}.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-CLIEN-0025</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_OPERACAO_INVALIDA</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>A opera��o solicitada para o servi�o n�o � v�lida.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>A opera��o solicitada para o servi�o n�o � v�lida.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0026</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_REQUEST_INVALIDO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Request Inv�lido {0}.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Request Inv�lido {0}.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0027</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_TIPO_CONTRATO_COLETIVIDADE_INVALIDO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>N�o foi gerado o recibo, pois o tipo de contrato/coletividade n�o � v�lido.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>N�o foi gerado o recibo, pois o tipo de contrato/coletividade n�o � v�lido.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0028</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_RECIBO_INVALIDO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'O tipo recibo {0}, n�o � v�lido.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'O tipo recibo {0}, n�o � v�lido.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0029</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_CAMPOS_EM_BRANCO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'O(s) campo(s) {0} n�o pode(m) estar em branco.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'O(s) campo(s) {0} n�o pode(m) estar em branco.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0030</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_PERIODO_E_OU_QUANTIDADE_NAO_INFORMADO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Nenhum per�odo ou quantidade informado.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Nenhum per�odo ou quantidade informado.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0031</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_FORMATO_DATA_INVALIDA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'O(s) campo(s) {0} cont�m formato de data inv�lido.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'O(s) campo(s) {0} cont�m formato de data inv�lido.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0032</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_DATA_FIM_MENOR_DATA_INICIO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'O(s) campo(s) {0} cont�m a Data Fim menor que Data In�cio.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'O(s) campo(s) {0} cont�m a Data Fim menor que Data In�cio.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0033</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_CARACTER_INVALIDO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'O(s) campo(s) {0} cont�m caracter inv�lido.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'O(s) campo(s) {0} cont�m caracter inv�lido.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0034</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_TITULARIDADE_INVALIDO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Titularidade Incompat�vel'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'A Titularidade (CPF/CNPJ) do telefone {0} est� diferente na Claro.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0035</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_TERMINAL_NAO_CLARO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Terminal n�o pertence � operadora Claro.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'O telefone {0} n�o pertence a operadora Claro. O telefone a ser adicionado deve ser da Claro.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0036</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_TERMINAL_NAO_ATIVO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Terminal Claro Principal n�o ATIVO na Claro.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'O telefone {0} n�o encontra-se ATIVO na Claro.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0037</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_TERMINAL_NAO_POS_PAGO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Terminal inserido no campo Claro Principal n�o � P�s-Pago.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'O telefone {0} n�o � P�s-Pago. O telefone Titular Principal deve ser um P�s-Pago.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0038</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_TERMINAL_NAO_POS_PAGO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Servi�o de Valida��o Indispon�vel'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Servi�o de Valida��o Indispon�vel'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0039</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_TERMINAL_INVALIDO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Terminal inv�lido.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Terminal inv�lido.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>		
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0040</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_ASSINATE_CLARO_NAO_ECONTRADO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Assinante Claro n�o encontrado.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Assinante Claro n�o encontrado.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0041</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_CLIENTE_CLARO_NAO_ECONTRADO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Cliente Claro n�o encontrado.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Cliente Claro n�o encontrado.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0042</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_CONTA_NAO_ECONTRADO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Conta n�o encontrado.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Conta n�o encontrado.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0045</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_PLANO_PRECO_CLARO_NAO_ECONTRADO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Plano Preco Claro Nao Encontrado.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Plano Preco Claro Nao Encontrado.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>		
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0046</ns0:ID_MSG>
	  <ns0:NOME_ERRO>PARAMETRO_INVALIDO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Parametro {0} invalido.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Parametro {0} invalido.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0050</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_CPF_CNPJ_INVALIDO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'CPF/CNPJ inv�lido.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'CPF/CNPJ inv�lido.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>						
</ns0:Messages>
};

xf:getMessages()