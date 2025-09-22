(:: pragma bea:global-element-parameter parameter="$modalidadePagamentoContrato1" element="ns3:ModalidadePagamentoContrato" location="../wsdl/business/DadoCobrancaBSWSDLV1_0.wsdl" ::)
(:: pragma bea:local-element-return type="ns0:consultarResponse/modalidadePagamentoContrato" location="../wsdl/proxy/DadoCobrancaWSDL12V1_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/cliente/dadocobranca/transformation/TransformarRetornoEmModalidadePagamentoCanonicoXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/DadoCobranca/";
declare namespace ns1 = "http://www.netservicos.com.br/modelocanonico/v2/formapagamento";
declare namespace ns3 = "http://www.netservicos.com.br/DadoCobranca/schemas";
declare namespace ns2 = "http://www.netservicos.com.br/modelocanonico/v2/contrato";

declare function xf:TransformarRetornoEmModalidadePagamentoCanonicoXQuery($modalidadePagamentoContrato1 as element(ns3:ModalidadePagamentoContrato))
    as element() {
        <modalidadePagamentoContrato>
            {
                for $DiaVencimento in $modalidadePagamentoContrato1/ns3:DiaVencimento
                return
                    <ns2:DiaVencimento>{ data($DiaVencimento) }</ns2:DiaVencimento>
            }
            {
                for $IndicadorCoboletamento in $modalidadePagamentoContrato1/ns3:IndicadorCoboletamento
                return
                    <ns2:IndicadorCoboletamento>{ data($IndicadorCoboletamento) }</ns2:IndicadorCoboletamento>
            }
            {
            	if(data($modalidadePagamentoContrato1/ns3:TipoPostagemFatura) = "E-mail") then
            		<ns2:TipoPostagemFatura>{ xs:string("EMAIL") }</ns2:TipoPostagemFatura>
            	else(
            		if(data($modalidadePagamentoContrato1/ns3:TipoPostagemFatura) = "Correio") then
            			<ns2:TipoPostagemFatura>{ xs:string("CORREIO") }</ns2:TipoPostagemFatura>
            		else(
            		)
            	)
            }

                {
                 if((data($modalidadePagamentoContrato1/ns3:FormaPagamento) = 1) or (data($modalidadePagamentoContrato1/ns3:FormaPagamento) = 4) or (data($modalidadePagamentoContrato1/ns3:FormaPagamento) = 5)) then
                		<ns2:FormaPagamentoBoleto/>
                 else(
                 	if(data($modalidadePagamentoContrato1/ns3:FormaPagamento) = 2) then
                 		<ns2:FormaPagamentoDebitoContaCorrente>
							<ns2:NomeTitularContaCorrente>{ data($modalidadePagamentoContrato1/ns3:FormaPagamentoDebitoContaCorrente/ns3:NomeTitularContaCorrente) }</ns2:NomeTitularContaCorrente>
							<ns2:AgenciaContaCorrente>{ data($modalidadePagamentoContrato1/ns3:FormaPagamentoDebitoContaCorrente/ns3:AgenciaContaCorrente) }</ns2:AgenciaContaCorrente>
							{
								if(data($modalidadePagamentoContrato1/ns3:FormaPagamentoDebitoContaCorrente/ns3:DigitoContaCorrente/node())) then
									<ns2:NumeroContaCorrente>{data($modalidadePagamentoContrato1/ns3:FormaPagamentoDebitoContaCorrente/ns3:NumeroContaCorrente)}</ns2:NumeroContaCorrente>
								else(
									<ns2:NumeroContaCorrente>{substring(data($modalidadePagamentoContrato1/ns3:FormaPagamentoDebitoContaCorrente/ns3:NumeroContaCorrente),1,xs:int(string-length(data($modalidadePagamentoContrato1/ns3:FormaPagamentoDebitoContaCorrente/ns3:NumeroContaCorrente))) - xs:int(1))}</ns2:NumeroContaCorrente>
								)
							}
							{
								if(data($modalidadePagamentoContrato1/ns3:FormaPagamentoDebitoContaCorrente/ns3:DigitoContaCorrente/node())) then
									<ns2:DigitoContaCorrente>{data($modalidadePagamentoContrato1/ns3:FormaPagamentoDebitoContaCorrente/ns3:DigitoContaCorrente)}</ns2:DigitoContaCorrente>
								else(
									<ns2:DigitoContaCorrente>{substring(data($modalidadePagamentoContrato1/ns3:FormaPagamentoDebitoContaCorrente/ns3:NumeroContaCorrente), string-length(data($modalidadePagamentoContrato1/ns3:FormaPagamentoDebitoContaCorrente/ns3:NumeroContaCorrente)))}</ns2:DigitoContaCorrente>
								)
							}
							<ns2:BancoContaCorrente>
								<ns2:Identificador>{ data($modalidadePagamentoContrato1/ns3:FormaPagamentoDebitoContaCorrente/ns3:BancoContaCorrente/ns3:Identificador) }</ns2:Identificador>
								<ns2:NomeBanco>{ data($modalidadePagamentoContrato1/ns3:FormaPagamentoDebitoContaCorrente/ns3:BancoContaCorrente/ns3:NomeBanco) }</ns2:NomeBanco>
							</ns2:BancoContaCorrente>
                 		</ns2:FormaPagamentoDebitoContaCorrente>
                 	else(
                 		<ns2:FormaPagamentoCartaoCredito>
                 			<ns2:NomeTitularCartaoCredito>{ data($modalidadePagamentoContrato1/ns3:FormaPagamentoCartaoCredito/ns3:NomeTitularCartaoCredito) }</ns2:NomeTitularCartaoCredito>
                 			<ns2:NumeroCartaoCredito>{ data($modalidadePagamentoContrato1/ns3:FormaPagamentoCartaoCredito/ns3:NumeroCartaoCredito) }</ns2:NumeroCartaoCredito>
                 			<ns2:ValidadeCartaoCredito>{ data($modalidadePagamentoContrato1/ns3:FormaPagamentoCartaoCredito/ns3:ValidadeCartaoCredito) }</ns2:ValidadeCartaoCredito>
                 			<ns2:OperadoraCartaoCredito>
                 			<ns2:Identificador>{ data($modalidadePagamentoContrato1/ns3:FormaPagamentoCartaoCredito/ns3:OperadoraCartaoCredito/ns3:Identificador) }</ns2:Identificador>
                 			<ns2:NomeOperadora>{ data($modalidadePagamentoContrato1/ns3:FormaPagamentoCartaoCredito/ns3:OperadoraCartaoCredito/ns3:NomeOperadora) }</ns2:NomeOperadora>
                 			</ns2:OperadoraCartaoCredito>
                 		</ns2:FormaPagamentoCartaoCredito>
                 	)
                 )
                }
            {
                for $PeriodicidadeCobranca in $modalidadePagamentoContrato1/ns3:PeriodicidadeCobranca
                return
                    <ns2:PeriodicidadeCobranca>{ data($PeriodicidadeCobranca) }</ns2:PeriodicidadeCobranca>
            }
            {
                for $PoliticaCobranca in $modalidadePagamentoContrato1/ns3:PoliticaCobranca
                return
                    <ns2:PoliticaCobranca>{ data($PoliticaCobranca) }</ns2:PoliticaCobranca>
            }
        </modalidadePagamentoContrato>
};

declare variable $modalidadePagamentoContrato1 as element(ns3:ModalidadePagamentoContrato) external;

xf:TransformarRetornoEmModalidadePagamentoCanonicoXQuery($modalidadePagamentoContrato1)
