xquery version "1.0" encoding "Cp1252";
(:: pragma bea:global-element-return element="ns0:Messages" location="../../../modelocanonicoV2/geral/Message.xsd" ::)

declare namespace xf = "http://www.netservicos.com.br/relacionar/atendimento/transformation/br.com.netservicos.relacionar.atendimento.MessagesXQuery/";
declare namespace ns0 = "http://netservicos.com.br/core/schema";

declare function xf:getMessages()
as element(ns0:Messages) {
<ns0:Messages>
	<ns0:Message>
		<ns0:ID_MSG>ESB-ATEND-0000</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_SUCESSO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Opera��o executada com sucesso</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Opera��o executada com sucesso</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>INFO</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-ATEND-0002</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_OPERACAO_INVALIDA</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>A opera��o solicitada para o servi�o n�o � v�lida.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>A opera��o solicitada para o servi�o n�o � v�lida.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-ATEND-0003</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_ERRO_INESPERADO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Ocorreu um erro inesperado.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Ocorreu um erro inesperado.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-ATEND-0004</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>CPF, CNPJ ou Telefone de Contato s�o de preenchimento obrigat�rio, embora ambos n�o possam estar preenchidos na mesma requisi��o.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>CPF, CNPJ ou Telefone de Contato s�o de preenchimento obrigat�rio, embora ambos n�o possam estar preenchidos na mesma requisi��o.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-ATEND-0005</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_CAMPO_INVALIDO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>CPF/CNPJ inv�lido.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>CPF/CNPJ inv�lido.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-ATEND-0006</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>DDD � de preenchimento obrigat�rio.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>DDD � de preenchimento obrigat�rio.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-ATEND-0007</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>N�mero do Telefone � de preenchimento obrigat�rio.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>N�mero do Telefone � de preenchimento obrigat�rio.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-ATEND-0008</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_CAMPO_INVALIDO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>N�mero de Telefone inv�lido.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>N�mero de Telefone inv�lido.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-ATEND-0009</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_PARAMETRO_OBRIGATORIO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Quantidade de faturas ou Per�odo para pesquisa devem ser informados.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Quantidade de faturas ou Per�odo para pesquisa devem ser informados.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERRO</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
	  	<ns0:ID_MSG>ESB-ATEND-0010</ns0:ID_MSG>
	  	<ns0:NOME_ERRO>ESB_ERRO_OPERACAO_INVALIDA</ns0:NOME_ERRO>
	  	<ns0:MENSAGEM_DETALHADA>Opera��o Inv�lida.</ns0:MENSAGEM_DETALHADA>
	  	<ns0:MENSAGEM_USUARIO>Opera��o Inv�lida.</ns0:MENSAGEM_USUARIO>
	  	<ns0:CATEGORIA_MENSAGEM>ERRO</ns0:CATEGORIA_MENSAGEM>
	  	<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>		
	<ns0:Message>
		<ns0:ID_MSG>ESB-ATEND-0011</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_ERRO_PESQUISA</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'N�o foi poss�vel realizar a pesquisa de clientes para a base: {0}'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'N�o foi poss�vel realizar a pesquisa de clientes para a base: {0}'}</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
	  	<ns0:ID_MSG>ESB-ATEND-0012</ns0:ID_MSG>
	  	<ns0:NOME_ERRO>ESB_ERRO_CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
	  	<ns0:MENSAGEM_DETALHADA>{'Campo {0} � Obrigat�rio.'}</ns0:MENSAGEM_DETALHADA>
	  	<ns0:MENSAGEM_USUARIO>{'Campo {0} � Obrigat�rio.'}</ns0:MENSAGEM_USUARIO>
	  	<ns0:CATEGORIA_MENSAGEM>ERRO</ns0:CATEGORIA_MENSAGEM>
	  	<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
		<ns0:ID_MSG>ESB-ATEND-0013</ns0:ID_MSG>
		<ns0:NOME_ERRO>Nenhuma altera��o foi realizada</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Nenhuma altera��o foi realizada</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Nenhuma altera��o foi realizada</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-ATEND-0014</ns0:ID_MSG>
		<ns0:NOME_ERRO>N�o � poss�vel inserir dados de pessoas f�sicas para pessoas jur�dicas e vice-versa.</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>N�o � poss�vel inserir dados de pessoas f�sicas para pessoas jur�dicas e vice-versa.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>N�o � poss�vel inserir dados de pessoas f�sicas para pessoas jur�dicas e vice-versa.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
		<ns0:ID_MSG>ESB-ATEND-0015</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_ERRO_RECURSO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'Erro durante a execu��o do recurso: {0}.'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'Erro durante a execu��o do recurso: {0}.'}</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-ATEND-0016</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_CONTRATO_INVALIDO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Contrato informado n�o � coletivo.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Contrato informado n�o � coletivo.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-ATEND-0017</ns0:ID_MSG>
		<ns0:NOME_ERRO>Contrato n�o encontrado</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Contrato n�o encontrado</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Contrato n�o encontrado</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-ATEND-0018</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_REQUEST_INVALIDO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'Request Inv�lido: {0}.'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'Request Inv�lido: {0}.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERRO</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
	  <ns0:ID_MSG>ESB-ATEND-0019</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_ERRO_VALIDACAO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'O canal de atendimento {0} � inv�lido.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'O canal de atendimento {0} � inv�lido.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERRO</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
		<ns0:ID_MSG>ESB-ATEND-0020</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_PERIODO_INCONSISTENTE</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>O Per�odo informado est� inconsistente.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>O Per�odo informado est� inconsistente.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-ATEND-0021</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_ERRO_VALIDACAO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'Formato inv�lido para o campo {0}.'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'Formato inv�lido para o campo {0}.'}</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-ATEND-0022</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_ERRO_VALIDACAO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Ocorreu um erro de valida��o.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Ocorreu um erro de valida��o.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  	<ns0:ID_MSG>ESB-ATEND-0023</ns0:ID_MSG>
	  	<ns0:NOME_ERRO>ESB_ERRO_CAMPO_INVALID0</ns0:NOME_ERRO>
	  	<ns0:MENSAGEM_DETALHADA>N�o foi possivel identificar o Canal Atendimento.</ns0:MENSAGEM_DETALHADA>
	  	<ns0:MENSAGEM_USUARIO>N�o foi possivel identificar o Canal Atendimento.</ns0:MENSAGEM_USUARIO>
	  	<ns0:CATEGORIA_MENSAGEM>ERRO</ns0:CATEGORIA_MENSAGEM>
	  	<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  	<ns0:ID_MSG>ESB-ATEND-0024</ns0:ID_MSG>
	  	<ns0:NOME_ERRO>ESB_ERRO_CONTRATO_INVALID0</ns0:NOME_ERRO>
	  	<ns0:MENSAGEM_DETALHADA>N�o foi possivel consultar as manifesta��es do contrato.</ns0:MENSAGEM_DETALHADA>
	  	<ns0:MENSAGEM_USUARIO>N�o foi possivel consultar as manifesta��es do contrato.</ns0:MENSAGEM_USUARIO>
	  	<ns0:CATEGORIA_MENSAGEM>ERRO</ns0:CATEGORIA_MENSAGEM>
	  	<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>		
	<ns0:Message>
	  	<ns0:ID_MSG>ESB-ATEND-0026</ns0:ID_MSG>
	  	<ns0:NOME_ERRO>ESB_ERRO_TAMANHO_PAGINA_MARIOR_ZERO</ns0:NOME_ERRO>
	  	<ns0:MENSAGEM_DETALHADA>O tamanho da p�gina deve ser maior que zero.</ns0:MENSAGEM_DETALHADA>
	  	<ns0:MENSAGEM_USUARIO>O tamanho da p�gina deve ser maior que zero.</ns0:MENSAGEM_USUARIO>
	  	<ns0:CATEGORIA_MENSAGEM>ERRO</ns0:CATEGORIA_MENSAGEM>
	  	<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
</ns0:Messages>
};

xf:getMessages()