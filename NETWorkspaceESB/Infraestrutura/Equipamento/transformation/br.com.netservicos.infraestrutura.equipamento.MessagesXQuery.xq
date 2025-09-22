xquery version "1.0" encoding "Cp1252";
(:: pragma bea:global-element-return element="ns0:Messages" location="../../../modelocanonicoV2/geral/Message.xsd" ::)

declare namespace xf = "http://www.netservicos.com.br/Infraestrutura/Equipamento/transformation/br.com.netservicos.infraestrutura.equipamento.MessagesXQuery/";
declare namespace ns0 = "http://netservicos.com.br/core/schema";

declare function xf:getMessages()
as element(ns0:Messages) {
<ns0:Messages>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-EQUIP-0000</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_SUCESSO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Operação executada com sucesso</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Operação executada com sucesso</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>INFO</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-EQUIP-0003</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'{0} é obrigatório.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'{0} é obrigatório.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-EQUIP-0004</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_REQUEST_INVALIDO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Request inválido: {0}.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Request inválido: {0}.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-EQUIP-0005</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ERRO_INESPERADO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Erro durante a execução do recurso: {0}.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Erro durante a execução do recurso: {0}.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-EQUIP-0006</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_OPERACAO_INVALID</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>A operação solicitada para o serviço não é válida.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>A operação solicitada para o serviço não é válida.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
	  <ns0:ID_MSG>ESB-EQUIP-0007</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_CIDADE_NAO_ENCONTRADA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>{'Erro cidade não cadastra para validação de Certidao de Nascimento.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'Erro cidade não cadastra para validação de Certidao de Nascimento.'}</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
</ns0:Messages>
};
xf:getMessages()