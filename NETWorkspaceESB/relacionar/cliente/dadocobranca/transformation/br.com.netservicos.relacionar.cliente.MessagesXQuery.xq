xquery version "1.0" encoding "Cp1252";
(:: pragma bea:global-element-return element="ns0:Messages" location="../../../../modelocanonicoV2/geral/Message.xsd" ::)

declare namespace xf = "http://www.netservicos.com.br/faturar/faturamento/transformation/br.com.netservicos.faturar.faturamento.MessagesXQuery/";
declare namespace ns0 = "http://netservicos.com.br/core/schema";

declare function xf:getMessages()
as element(ns0:Messages) {
<ns0:Messages>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-CLIEN-0000</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_SUCESSO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Operação executada com sucesso</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Operação executada com sucesso</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>INFO</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
</ns0:Messages>
};

xf:getMessages()