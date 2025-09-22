(:: pragma  parameter="$fault" type="anyType" ::)
(:: pragma bea:schema-type-parameter parameter="$defaultMessage" type="ns0:Message" location="../../../modelocanonicoV2/geral/Message.xsd" ::)
(:: pragma bea:schema-type-return type="ns0:Message" location="../../../modelocanonicoV2/geral/Message.xsd" ::)

declare namespace xf = "http://tempuri.org/general/NETESBExceptionHandler/transformation/TransformarFaultCodMsgTratadaEmMessage/";
declare namespace ns0 = "http://netservicos.com.br/core/schema";
declare namespace soap-env-11 = "http://schemas.xmlsoap.org/soap/envelope/";
declare namespace soap-env-12 = "http://www.w3.org/2003/05/soap-envelope";
declare namespace config = "http://www.bea.com/wli/sb/stages/transform/config";

declare function xf:TransformarFaultCodMsgTratadaEmMessage($fault as element(*),
    $defaultMessage as element())
    as element() {
        <ns0:Message>
            	{if ($fault//config:ReceivedFaultDetail/node()) then (
	     		   if (matches(data($fault//config:faultcode/node()),"^(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}") ) then (
		                <ns0:ID_MSG>{data($fault//config:faultcode)}</ns0:ID_MSG> 
				   ) else if (($fault//config:faultstring/node()
								and matches(fn:data($fault//config:faultstring),"(\{)(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}:") ) ) then (
					  	<ns0:ID_MSG>{substring-after(substring-before($fault//config:faultstring,":"),"{")}</ns0:ID_MSG> 
				    ) else if (($fault//config:faultstring/node()
								and matches(fn:data($fault//config:faultstring),"^(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}:") ) ) then (
					  	<ns0:ID_MSG>{substring-before($fault//config:faultstring,":")}</ns0:ID_MSG> 					
  					) else (
		  	    		<ns0:ID_MSG>{ data($defaultMessage//ns0:ID_MSG) }</ns0:ID_MSG>  				
		  	    	)
  				) else if ($fault//soap-env-12:Fault/node()) then (
	     		   if ($fault//soap-env-12:Code/soap-env-12:Value/node()
	                     and matches(data($fault//soap-env-12:Code/soap-env-12:Value),"^(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}") ) then (
		                <ns0:ID_MSG>{data($fault//soap-env-12:Code/soap-env-12:Value)}</ns0:ID_MSG> 
		           ) else if ($fault//soap-env-12:Code/soap-env-12:Subcode/soap-env-12:Value/node()
	                     		and matches(data($fault//soap-env-12:Code/soap-env-12:Subcode/soap-env-12:Value),"^(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}") ) then (
		                <ns0:ID_MSG>{data($fault//soap-env-12:Code/soap-env-12:Subcode/soap-env-12:Value)}</ns0:ID_MSG> 	           
				   ) else if (($fault//soap-env-12:Reason/soap-env-12:Text/node()
								and matches(fn:data($fault//soap-env-12:Reason/soap-env-12:Text),"(\{)(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}:") ) ) then (
					  	<ns0:ID_MSG>{substring-after(substring-before($fault//soap-env-12:Reason/soap-env-12:Text,":"),"{")}</ns0:ID_MSG> 
				    ) else if (($fault//soap-env-12:Reason/soap-env-12:Text/node()
								and matches(fn:data($fault//soap-env-12:Reason/soap-env-12:Text),"^(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}:") ) ) then (
					  	<ns0:ID_MSG>{substring-before($fault//soap-env-12:Reason/soap-env-12:Text,":")}</ns0:ID_MSG> 					
  					) else (
		  	    		<ns0:ID_MSG>{ data($defaultMessage//ns0:ID_MSG) }</ns0:ID_MSG>  				
  					)
  				) else if ($fault//soap-env-11:Fault/node()) then (
	     		   if (matches(data($fault//faultcode/node()),"^(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}") ) then (
		                <ns0:ID_MSG>{data($fault//faultcode)}</ns0:ID_MSG> 
				   ) else if (($fault//faultstring/node()
								and matches(fn:data($fault//faultstring),"(\{)(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}:") ) ) then (
					  	<ns0:ID_MSG>{substring-after(substring-before($fault//faultstring,":"),"{")}</ns0:ID_MSG> 
				    ) else if (($fault//faultstring/node()
								and matches(fn:data($fault//faultstring),"^(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}:") ) ) then (
					  	<ns0:ID_MSG>{substring-before($fault//faultstring,":")}</ns0:ID_MSG> 					
  					) else (
		  	    		<ns0:ID_MSG>{ data($defaultMessage//ns0:ID_MSG) }</ns0:ID_MSG>  				
		  	    	)
  				) else (
		  	    	<ns0:ID_MSG>{ data($defaultMessage//ns0:ID_MSG) }</ns0:ID_MSG>  				
  				)
				 }
            <ns0:NOME_ERRO/>
     		  {if ($fault//config:faultstring/node() 
								and (    matches(fn:data($fault//config:faultcode),"^(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}") 
								      or matches(fn:data($fault//config:faultstring),"(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}:"))
								) then (
	                <ns0:MENSAGEM_DETALHADA>{data($fault//config:faultstring)}</ns0:MENSAGEM_DETALHADA> 
  				) else if ($fault//soap-env-12:Reason/soap-env-12:Text/node()
								and (
								      matches(data($fault//soap-env-12:Code/soap-env-12:Value),"^(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}")
								   or matches(data($fault//soap-env-12:Code/soap-env-12:Subcode/soap-env-12:Value),"^(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}")
								   or matches(fn:data($fault//soap-env-12:Reason/soap-env-12:Text),"(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}:")								   
								   )
							) then (
	                <ns0:MENSAGEM_DETALHADA>{data($fault//soap-env-12:Reason/soap-env-12:Text)}</ns0:MENSAGEM_DETALHADA> 
 				) else if ($fault//faultstring/node()
								and (    matches(data($fault//faultcode/node()),"^(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}")
								      or matches(fn:data($fault//faultstring),"(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}:") 								      
								    )    
								  ) then (
	                <ns0:MENSAGEM_DETALHADA>{data($fault//faultstring)}</ns0:MENSAGEM_DETALHADA> 
  				) else (
		  	    	<ns0:MENSAGEM_DETALHADA>{ data($defaultMessage//ns0:MENSAGEM_DETALHADA) }</ns0:MENSAGEM_DETALHADA>  				
  				)
				 }  				 
				 
     		  {if ($fault//config:faultstring/node() 
								and (    matches(fn:data($fault//config:faultcode),"^(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}") 
								      or matches(fn:data($fault//config:faultstring),"(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}:"))
								) then (
	                <ns0:MENSAGEM_USUARIO>{data($fault//config:faultstring)}</ns0:MENSAGEM_USUARIO> 
  				) else if ($fault//soap-env-12:Reason/soap-env-12:Text/node()
								and (
								      matches(data($fault//soap-env-12:Code/soap-env-12:Value),"^(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}")
								   or matches(data($fault//soap-env-12:Code/soap-env-12:Subcode/soap-env-12:Value),"^(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}")
								   or matches(fn:data($fault//soap-env-12:Reason/soap-env-12:Text),"(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}:")								   
								   )
							) then (
	                <ns0:MENSAGEM_USUARIO>{data($fault//soap-env-12:Reason/soap-env-12:Text)}</ns0:MENSAGEM_USUARIO> 
 				) else if ($fault//faultstring/node()
								and (    matches(data($fault//faultcode/node()),"^(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}")
								      or matches(fn:data($fault//faultstring),"(ESB|WLI)-[A-Z]{3,20}-[0-9]{4,8}:") 								      
								    )    
								  ) then (
	                <ns0:MENSAGEM_USUARIO>{data($fault//faultstring)}</ns0:MENSAGEM_USUARIO> 
  				) else (
		  	    	<ns0:MENSAGEM_USUARIO>{ data($defaultMessage//ns0:MENSAGEM_USUARIO) }</ns0:MENSAGEM_USUARIO>  				
  				)
				 }
            <ns0:CATEGORIA_MENSAGEM>{ data($defaultMessage//ns0:CATEGORIA_MENSAGEM) }</ns0:CATEGORIA_MENSAGEM>
            <ns0:CODIGO_SISTEMA>{ data($defaultMessage//ns0:CODIGO_SISTEMA) }</ns0:CODIGO_SISTEMA>
        </ns0:Message>
};

declare variable $fault as element(*) external;
declare variable $defaultMessage as element() external;

xf:TransformarFaultCodMsgTratadaEmMessage($fault,
    $defaultMessage)