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
	  <ns0:MENSAGEM_DETALHADA>Operação executada com sucesso</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Operação executada com sucesso</ns0:MENSAGEM_USUARIO>
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
	  <ns0:MENSAGEM_DETALHADA>Cidade não encontrada para a operadora informada.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Cidade não encontrada para a operadora informada.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0003</ns0:ID_MSG>
	  <ns0:NOME_ERRO>EQUIPAMENTO_NAO_ASSINANTE</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Equipamento vinculado ao Smartcard ou Endereço Mac informado, não está vinculado a um assinante.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Equipamento vinculado ao Smartcard ou Endereço Mac informado, não está vinculado a um assinante.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0004</ns0:ID_MSG>
	  <ns0:NOME_ERRO>CIDADE_NAO_ENCONTRADA_PROTOCOLO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Cidade / Operadora não encontrada para Protocolo Informado. Verifique o Protocolo.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Cidade / Operadora não encontrada para Protocolo Informado. Verifique o Protocolo.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0005</ns0:ID_MSG>
	  <ns0:NOME_ERRO>CONTRATO_NAO_ENCONTRADO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Contrato não encontrado para os parâmetros informados.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Contrato não encontrado para os parâmetros informados.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0006</ns0:ID_MSG>
	  <ns0:NOME_ERRO>OPERADORA_NAO_ENCONTRADA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Operadora não encontrada para a ciadade informada.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Operadora não encontrada para a ciadade informada.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0007</ns0:ID_MSG>
	  <ns0:NOME_ERRO>CIDADE_OU_OPERADORA_OBRIGATORIO_NAO_PREENCHIDO</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Quando o contrato é informado é obrigatório informar a Operadora ou Código da Cidade onde o contrato está localizado.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Quando o contrato é informado é obrigatório informar a Operadora ou Código da Cidade onde o contrato está localizado.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0008</ns0:ID_MSG>
	  <ns0:NOME_ERRO>MENSAGEM_ERRO_NAO_ENCONTRADA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Não foi possível determinar a mensagem de erro adequada, considerando os parâmetros informados.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Não foi possível determinar a mensagem de erro adequada, considerando os parâmetros informados.</ns0:MENSAGEM_USUARIO>
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
	  <ns0:MENSAGEM_DETALHADA>{'A operação {0} foi executada, porém não apresentou o resultado esperado: {1}.'}</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>{'A operação {0} foi executada, porém não apresentou o resultado esperado: {1}. Verifique os detalhes do erro.'}</ns0:MENSAGEM_USUARIO>
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
	  <ns0:MENSAGEM_DETALHADA>O parâmetro código da mensagem não foi informado e é obrigatório.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>O parâmetro código da mensagem não foi informado e é obrigatório.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0015</ns0:ID_MSG>
	  <ns0:NOME_ERRO>VERSAO_SOAP_INVALIDA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Parametro versão de SOAP inválido. Apenas Versões 1.1 e 1.2 são suportadas.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Parametro versão de SOAP inválido. Apenas Versões 1.1 e 1.2 são suportadas.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>			
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0016</ns0:ID_MSG>
	  <ns0:NOME_ERRO>BUSCA_MENSAGEM_NOK</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Ocorreu um problema ao identificar localizar a mensagem do código enviado.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Ocorreu um problema ao identificar localizar a mensagem do código enviado.</ns0:MENSAGEM_USUARIO>
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
	  <ns0:MENSAGEM_DETALHADA>É necessário informar o protocolo ou a proposta.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>É necessário informar o protocolo ou a proposta.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0028</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_ERRO_INFORMACAO_OBRIGATORIA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>É necessário informar código da operadora ou identificador da cidade.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>É necessário informar código da operadora ou identificador da cidade.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0029</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_ERRO_IDENTIFICACAO_OPERADORA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>Não foi possível identificar a operadora do protocolo.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>Não foi possível identificar a operadora do protocolo.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0030</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_ERRO_EXCESSO_INFORMACOES</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>É necessário informar apenas uma das entidades: identificacaoContrato ou identificacaoProposta.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>É necessário informar apenas uma das entidades: identificacaoContrato ou identificacaoProposta.</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0031</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_ERRO_INFORMACAO_OBRIGATORIA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>É necessário informar identificacaoContrato ou identificaoProposta.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>É necessário informar identificacaoContrato ou identificaoProposta</ns0:MENSAGEM_USUARIO>
	  <ns0:CATEGORIA_MENSAGEM>ERROR</ns0:CATEGORIA_MENSAGEM>
	  <ns0:CODIGO_SISTEMA></ns0:CODIGO_SISTEMA>
	</ns0:Message>
	<ns0:Message>
	  <ns0:ID_MSG>ESB-GERAL-0032</ns0:ID_MSG>
	  <ns0:NOME_ERRO>ESB_ERRO_BUSCA_PROTOCOLO_NAO_SUPORTADA</ns0:NOME_ERRO>
	  <ns0:MENSAGEM_DETALHADA>A busca por protocolo ainda não é suportada nesta versão.</ns0:MENSAGEM_DETALHADA>
	  <ns0:MENSAGEM_USUARIO>A busca por protocolo ainda não é suportada nesta versão.</ns0:MENSAGEM_USUARIO>
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