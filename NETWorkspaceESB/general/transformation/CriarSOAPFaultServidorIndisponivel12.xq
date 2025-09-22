declare namespace xf = "http://netservicos.com/geral/criarErroServidorIndisponivel/";
declare namespace soap12 = "http://www.w3.org/2003/05/soap-envelope";

declare function xf:criarErroServidorIndisponivel12()
    as element(soap12:Fault) { 
        <soap12:Fault>
         <soap12:Code>
            <soap12:Value>soapenv:Server</soap12:Value>
         </soap12:Code>
         <soap12:Reason>
            <soap12:Text>Não foi possível acessar serviços - contate o suporte</soap12:Text>
         </soap12:Reason>
         <soap12:Detail>
            <detail>Não foi possível acessar serviços - contate o suporte</detail>
         </soap12:Detail>
      </soap12:Fault>

};

xf:criarErroServidorIndisponivel12()