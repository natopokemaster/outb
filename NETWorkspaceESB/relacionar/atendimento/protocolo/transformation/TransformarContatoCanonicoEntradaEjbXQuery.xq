(:: pragma bea:global-element-parameter parameter="$associarProtocoloAtendimento1" element="ns0:associarProtocoloAtendimento" location="../wsdl/proxyservice/AssociarProtocoloAtendimentoWSDL12.wsdl" ::)
(:: pragma bea:global-element-return element="ns3:associarProtocoloAtendimento" location="../wsdl/business/AssociarProtocoloAtendimentoBS.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/protocolo/transformation/TransformarContatoCanonicoEntradaEjbXQuery/";
declare namespace netservicos = "http://www.netservicos.com.br/";
declare namespace even = "http://www.netservicos.com.br/modelocanonico/evento";
declare namespace ns3 = "http://www.openuri.org/";
declare namespace ns2 = "java:br.com.netservicos.atendimento.protocolo.bean";
declare namespace xsi = "http://www.w3.org/2001/XMLSchema-instance";

declare function xf:TransformarContatoCanonicoEntradaEjbXQuery($associarProtocoloAtendimento1 as element(netservicos:associarProtocoloAtendimento))
    as element(ns3:associarProtocoloAtendimento) {
        <ns3:associarProtocoloAtendimento>
            <ns3:contato>
            {
            if ($associarProtocoloAtendimento1/netservicos:contato/even:Protocolo/node()) then (
                <ns2:numeroProtocolo>{ data($associarProtocoloAtendimento1/netservicos:contato/even:Protocolo) }</ns2:numeroProtocolo>
             )
             else (
                <ns2:numeroProtocolo>{ data($associarProtocoloAtendimento1/even:contato//even:Protocolo) }</ns2:numeroProtocolo>             
             )
             }

            {
            if ($associarProtocoloAtendimento1/netservicos:contato/even:Protocolo/node()) then (
                <ns2:numeroChamado>{ data($associarProtocoloAtendimento1/netservicos:contato/even:NumeroChamado) }</ns2:numeroChamado>
             )
             else (
                <ns2:numeroChamado>{ data($associarProtocoloAtendimento1/even:contato//even:NumeroChamado) }</ns2:numeroChamado>             
             )
             }             

       <!-- Inicio das transformacoes para retrocompatibilidade -->
                
            {
	            for $id in $associarProtocoloAtendimento1/even:contato/even:evento/even:Eventos/even:IdentificadorOrdemInterna
	            return
                        <ns2:eventos>
                        <ns2:identificador>{fn:data($id)}</ns2:identificador>
                        <ns2:tipoIdentificador>1</ns2:tipoIdentificador>
                        </ns2:eventos>
             }

            {
	            for $id in $associarProtocoloAtendimento1/even:contato/even:evento/even:Eventos/even:IdentificadorRegistroSistemica
	            return
                        <ns2:eventos>
                        <ns2:identificador>{fn:data($id)}</ns2:identificador>
                        <ns2:tipoIdentificador>2</ns2:tipoIdentificador>
                        </ns2:eventos>
             }

            {
	            for $id in $associarProtocoloAtendimento1/even:contato/even:evento/even:Eventos/even:IdentifcadorOrdemCampo
	            return
                        <ns2:eventos>
                        <ns2:identificador>{fn:data($id)}</ns2:identificador>
                        <ns2:tipoIdentificador>3</ns2:tipoIdentificador>
                        </ns2:eventos>
             }
            
            {
	            for $id in $associarProtocoloAtendimento1/even:contato/even:evento/even:Eventos/even:IdentificadorOrdemCampo
	            return
                        <ns2:eventos>
                        <ns2:identificador>{fn:data($id)}</ns2:identificador>
                        <ns2:tipoIdentificador>3</ns2:tipoIdentificador>
                        </ns2:eventos>
             }
                                                       
            {
	            for $id in $associarProtocoloAtendimento1/even:contato/even:evento/even:Eventos/even:IdentificadorOrdemAtivacao
	            return
                        <ns2:eventos>
                        <ns2:identificador>{fn:data($id)}</ns2:identificador>
                        <ns2:tipoIdentificador>4</ns2:tipoIdentificador>
                        </ns2:eventos>
             }

            {
	            for $id in $associarProtocoloAtendimento1/even:contato/even:evento/even:Eventos/even:IdentificadorRegistroContato
	            return
                        <ns2:eventos>
                        <ns2:identificador>{fn:data($id)}</ns2:identificador>
                        <ns2:tipoIdentificador>5</ns2:tipoIdentificador>
                        </ns2:eventos>
             }
             <!-- Fim das transformacoes para retrocompatibilidade -->  
                           
             <!-- Inicio das transformacoes para compatibilidade com tipos abstratos-->
                
            {
	            for $id in $associarProtocoloAtendimento1/netservicos:contato/even:evento/even:Eventos[ends-with(@xsi:type , ':OrdemInterna')]
	            return
                        <ns2:eventos>
                        <ns2:identificador>{fn:data($id//even:IdentificadorOrdemInterna)}</ns2:identificador>
                        <ns2:tipoIdentificador>1</ns2:tipoIdentificador>
                        </ns2:eventos>
             }

            {
	            for $id in $associarProtocoloAtendimento1/netservicos:contato/even:evento/even:Eventos[ends-with(@xsi:type , ':RegistroSistemica')]
	            return
                        <ns2:eventos>
                        <ns2:identificador>{fn:data($id//even:IdentificadorRegistroSistemica)}</ns2:identificador>
                        <ns2:tipoIdentificador>2</ns2:tipoIdentificador>
                        </ns2:eventos>
             }

            {
	            for $id in $associarProtocoloAtendimento1/netservicos:contato/even:evento/even:Eventos[ends-with(@xsi:type , ':OrdemCampo')]
	            return
                        <ns2:eventos>
                        <ns2:identificador>{fn:concat(fn:data($id//even:IdentificadorOrdemCampo),fn:data($id//even:IdentifcadorOrdemCampo))}</ns2:identificador>
                        <ns2:tipoIdentificador>3</ns2:tipoIdentificador>
                        </ns2:eventos>
             }
                                                      
            {
	            for $id in $associarProtocoloAtendimento1/netservicos:contato/even:evento/even:Eventos[ends-with(@xsi:type , ':OrdemAtivacao')]
	            return
                        <ns2:eventos>
                        <ns2:identificador>{fn:data($id//even:IdentificadorOrdemAtivacao)}</ns2:identificador>
                        <ns2:tipoIdentificador>4</ns2:tipoIdentificador>
                        </ns2:eventos>
             }

            {
	            for $id in $associarProtocoloAtendimento1/netservicos:contato/even:evento/even:Eventos[ends-with(@xsi:type , ':RegistroContato')]
	            return
                        <ns2:eventos>
                        <ns2:identificador>{fn:data($id//even:IdentificadorRegistroContato)}</ns2:identificador>
                        <ns2:tipoIdentificador>5</ns2:tipoIdentificador>
                        </ns2:eventos>
             }
             <!-- Fim das transformacoes para compatibilidade com tipos abstratos --> 
                             
                {
                    for $evento in $associarProtocoloAtendimento1/netservicos:contato/even:evento/even:Eventos//even:OrdemInterna
                    return
                        <ns2:eventos>
                        <ns2:identificador>{fn:data($evento/even:IdentificadorOrdemInterna)}</ns2:identificador>
                        <ns2:tipoIdentificador>1</ns2:tipoIdentificador>
                        </ns2:eventos>
                }
                {
                    for $evento in $associarProtocoloAtendimento1/netservicos:contato/even:evento/even:Eventos//even:RegistroSistemica
                    return
                        <ns2:eventos>
                        <ns2:identificador>{fn:data($evento/even:IdentificadorRegistroSistemica)}</ns2:identificador>
                        <ns2:tipoIdentificador>2</ns2:tipoIdentificador>
                        </ns2:eventos>
                }
                {
                    for $evento in $associarProtocoloAtendimento1/netservicos:contato/even:evento/even:Eventos//even:OrdemCampo
                    return
                        <ns2:eventos>
                        <ns2:identificador>{fn:data($evento/even:IdentifcadorOrdemCampo)}</ns2:identificador>
                        <ns2:tipoIdentificador>3</ns2:tipoIdentificador>
                        </ns2:eventos>
                }
                {
                    for $evento in $associarProtocoloAtendimento1/netservicos:contato/even:evento/even:Eventos//even:OrdemAtivacao
                    return
                        <ns2:eventos>
                        <ns2:identificador>{fn:data($evento/even:IdentificadorOrdemAtivacao)}</ns2:identificador>
                        <ns2:tipoIdentificador>4</ns2:tipoIdentificador>
                        </ns2:eventos>
                }
                {
                    for $evento in $associarProtocoloAtendimento1/netservicos:contato/even:evento/even:Eventos//even:RegistroContato
                    return
                        <ns2:eventos>
                        <ns2:identificador>{fn:data($evento/even:IdentificadorRegistroContato)}</ns2:identificador>
                        <ns2:tipoIdentificador>5</ns2:tipoIdentificador>
                        </ns2:eventos>
                }
            </ns3:contato>
        </ns3:associarProtocoloAtendimento>
};

declare variable $associarProtocoloAtendimento1 as element(netservicos:associarProtocoloAtendimento) external;

xf:TransformarContatoCanonicoEntradaEjbXQuery($associarProtocoloAtendimento1)
