declare namespace xf = "http://netservicos.com/geral/criarErroServidorIndisponivel/";
declare namespace ns0 = "http://schemas.xmlsoap.org/soap/envelope/";

declare function xf:criarErroServidorIndisponivel()
    as element(ns0:Fault) { 
        <ns0:Fault>        
             <faultcode>soapenv:Server</faultcode>
             <faultstring>Não foi possível acessar serviços - contate o suporte</faultstring>
            <detail />
         </ns0:Fault>
};

xf:criarErroServidorIndisponivel()