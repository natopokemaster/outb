xquery version "1.0" encoding "Cp1252";
(:: pragma bea:global-element-return element="ns0:Messages" location="../../../modelocanonicoV2/geral/Message.xsd" ::)

declare namespace xf = "http://www.netservicos.com.br/Infraestrutura/rede/transformation/br.com.netservicos.infraestrutura.rede.MessagesXQuery/";
declare namespace ns0 = "http://netservicos.com.br/core/schema";

declare function xf:getMessages()
as element(ns0:Messages) {
<ns0:Messages>
	<ns0:Message>
		<ns0:ID_MSG>ESB-REDES-0000</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_SUCESSO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Operação executada com sucesso.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Operação executada com sucesso.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>INFO</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-REDES-0001</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_NETHEADER_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>É obrigatória a informação do NETHeader para a operação solicitada.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>É obrigatória a informação do NETHeader para a operação solicitada.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-REDES-0002</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_OPERACAO_INVALIDA</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>A operação solicitada para o serviço não é válida.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>A operação solicitada para o serviço não é válida.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-REDES-0003</ns0:ID_MSG>
		<ns0:NOME_ERRO>BASE_NAO_IDENTIFICADA</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Não foi possível identificar a base.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Não foi possível identificar a base.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-REDES-0004</ns0:ID_MSG>
		<ns0:NOME_ERRO>CAMPO_OBRIGATORIO_NAO_PREENCHIDO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Operadora ou Cidade devem ser informadas.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Operadora ou Cidade devem ser informadas.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-REDES-0005</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>O campo de identificação de endereço é obrigatório.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>O campo de identificação de endereço é obrigatório.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-REDES-0006</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_ERRO_INESPERADO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Ocorreu um erro inesperado.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Ocorreu um erro inesperado.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-REDES-0007</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_ERRO_VALIDACAO_CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'Erro de Validação: {0}'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'Erro de Validação: {0}'}</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-REDES-0008</ns0:ID_MSG>
		<ns0:NOME_ERRO>CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Descrição do Local de Domicílio é de preenchimento obrigatório.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Descrição do Local de Domicílio é de preenchimento obrigatório.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>	
	<ns0:Message>
		<ns0:ID_MSG>ESB-REDES-0009</ns0:ID_MSG>
		<ns0:NOME_ERRO>CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>Identificador do Local do Domicílio é de preenchimento obrigatório.</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>Identificador do Local do Domicílio é de preenchimento obrigatório.</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-REDES-0010</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_ERRO_RECURSO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'Erro durante a execução do recurso: {0}.'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'Erro durante a execução do recurso: {0}.'}</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-REDES-0011</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_ERRO_CAMPO_OBRIGATORIO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'Campo {0} é Obrigatório.'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'Campo {0} é Obrigatório.'}</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
		<ns0:ID_MSG>ESB-REDES-0012</ns0:ID_MSG>
		<ns0:NOME_ERRO>ESB_REQUEST_INVALIDO</ns0:NOME_ERRO>
		<ns0:MENSAGEM_DETALHADA>{'Request inválido: {0}.'}</ns0:MENSAGEM_DETALHADA>
		<ns0:MENSAGEM_USUARIO>{'Request inválido: {0}.'}</ns0:MENSAGEM_USUARIO>
		<ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
		<ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
</ns0:Messages>
};

xf:getMessages()