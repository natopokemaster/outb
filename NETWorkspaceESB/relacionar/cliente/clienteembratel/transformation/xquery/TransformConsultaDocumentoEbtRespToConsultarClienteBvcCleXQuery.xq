(:: pragma bea:local-element-parameter parameter="$retornoSolicitacao" type="ns18:Data/ns18:Solicitacao/ns18:RetornoSolicitacao" location="../../wsdl/business/SRV-1149.wsdl" ::)
(:: pragma bea:global-element-return element="ns7:consultarClienteBvcResponse" location="../../wsdl/proxy/ClienteEmbratelWSDLV1.wsdl" ::)

declare namespace functx = "http://www.functx.com";
declare namespace ns20 = "http://www.netservicos.com.br/modelocanonico/v2/bolsacredito";
declare namespace ns13 = "http://www.netservicos.com.br/modelocanonico/v2/produto";
declare namespace ns4 = "http://www.netservicos.com.br/modelocanonico/v2/endereco";
declare namespace xf = "http://tempuri.org/relacionar/cliente/clienteembratel/transformation/TransformarDataEmClienteProspectXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/modelocanonico/v2/produtocontratado";
declare namespace ns7 = "http://www.netservicos.com.br/ClienteEmbratelV1";
declare namespace ns16 = "http://www.netservicos.com.br/modelocanonico/v2/oferta";
declare namespace ns5 = "http://www.netservicos.com.br/modelocanonico/v2/cliente";
declare namespace ns12 = "http://www.netservicos.com.br/modelocanonico/v2/moeda";
declare namespace ns18 = "http://www.embratel.com.br/schConsultaDocumento.xsd";
declare namespace ns6 = "http://www.netservicos.com.br/modelocanonico/v2/venda";
declare namespace ns11 = "http://www.netservicos.com.br/modelocanonico/v2/atendimento";
declare namespace ns9 = "http://www.netservicos.com.br/modelocanonico/v2/evento";
declare namespace ns17 = "http://www.netservicos.com.br/modelocanonico/v2/fatura";
declare namespace ns19 = "http://www.netservicos.com.br/modelocanonico/v2/empresa";
declare namespace ns1 = "http://www.netservicos.com.br/modelocanonico/v2/formapagamento";
declare namespace ns14 = "http://www.netservicos.com.br/modelocanonico/v2/rede";
declare namespace ns3 = "http://www.netservicos.com.br/modelocanonico/v2/contrato";
declare namespace ns2 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoContrato";
declare namespace ns21 = "http://www.netservicos.com.br/modelocanonico/v2/contratoparceiro";
declare namespace ns15 = "http://www.netservicos.com.br/modelocanonico/v2/equipamento";
declare namespace ns8 = "http://www.netservicos.com.br/modelocanonico/v2/usuario";
declare namespace ns10 = "http://www.netservicos.com.br/modelocanonico/v2/cobranca";

declare function functx:yyyymmdd-to-date 
  ( $dateString as xs:string? )  as xs:date? {       
   if (empty($dateString)) then ()   
   else xs:date(replace(concat(substring($dateString,5,5),substring($dateString,0,5)), '^\D*(\d{2})\D*(\d{2})\D*(\d{4})\D*$', '$3-$1-$2'))
};

declare function xf:TransformarDataEmClienteProspectXQuery($retornoSolicitacao as element())
    as element(ns7:consultarClienteBvcResponse) {
       <ns7:consultarClienteBvcResponse>{
			for $pessoa in $retornoSolicitacao/ns18:Pessoa[1] return (
					
				if (data($pessoa/ns18:ind_tpo_doc) eq '1') then
					let $pessoaFisica := $pessoa/ns18:PessoaFisica return (
						<ns7:clienteProspect>
							<ns5:ClienteProspect>                 
								{
									for $nom_pessoa_fisica in $pessoaFisica/ns18:nom_pessoa_fisica return
									<ns5:nome>{ data($nom_pessoa_fisica) }</ns5:nome>
								}

								<ns5:tipoPessoa>fisica</ns5:tipoPessoa>

								{
									for $cod_cpf in $pessoaFisica/ns18:cod_cpf return
									<ns5:CPF>{ data($cod_cpf) }</ns5:CPF>
								}								
								{
									for $cod_inscr_estadual in $pessoa/ns18:cod_inscr_estadual return
									<ns5:InscricaoEstadual>{ data($cod_inscr_estadual) }</ns5:InscricaoEstadual>
								}								
								{
									for $dta_nascim in data($pessoaFisica/ns18:dta_nascim)
									where fn:string-length($dta_nascim) >= 8
									return
									<ns5:DataNascimento>{ functx:yyyymmdd-to-date($dta_nascim) }</ns5:DataNascimento>
								}								
								{
									for $ind_sexo in data($pessoaFisica/ns18:ind_sexo)
									where $ind_sexo ne ''
									return
										<ns5:Sexo>{
											if ($ind_sexo eq '1') then 'MASCULINO'
											else if ($ind_sexo eq '2') then 'FEMININO'
											else if ($ind_sexo eq '9') then 'NAO SE APLICA'
											else ()
										}</ns5:Sexo>
								}								
								{
									for $nom_mae in $pessoaFisica/ns18:nom_mae return
									<ns5:NomeMae>{ data($nom_mae) }</ns5:NomeMae>
								}								
								{
									for $cod_ddd in $pessoaFisica/ns18:cod_ddd return
									<ns5:TelefonesContato>
										<ns5:telefoneContato>
											<ns5:DDD>{ data($cod_ddd) }</ns5:DDD>
											<ns5:numeroTelefone>{ data($pessoaFisica/ns18:num_telef) }</ns5:numeroTelefone>
										</ns5:telefoneContato>
									</ns5:TelefonesContato>
								}								
								{
									for $ind_tpo_cliente in fn:number($pessoa/ns18:ind_tpo_cliente)
									where fn:string($ind_tpo_cliente) ne 'NaN' and $ind_tpo_cliente ne 0
									return
										<ns5:TipoCliente>{ xs:int($ind_tpo_cliente) }</ns5:TipoCliente>
								}							
							</ns5:ClienteProspect>
						</ns7:clienteProspect>,
					
				        for $dta_obito in $pessoaFisica/ns18:dta_obito return
					        <ns7:dataObito>{ data($dta_obito) }</ns7:dataObito>,							
					
						for $endereco in $pessoa/ns18:EnderecoResponse return							
							<ns7:endereco>
								<ns4:Endereco>
									{
										for $des_uf in $endereco/ns18:CEPResponse/ns18:CNLResponse/ns18:des_uf
										return
											<ns4:UF>{ data($des_uf) }</ns4:UF>
									}
									{
										for $cod_municip_IBGE in $endereco/ns18:CEPResponse/ns18:CNLResponse/ns18:cod_municip_IBGE
										return
											<ns4:idCidade>{ xs:long( data($cod_municip_IBGE) ) }</ns4:idCidade>
									}
									{
										for $des_municipio in $endereco/ns18:CEPResponse/ns18:CNLResponse/ns18:des_municipio
										return
											<ns4:cidade>{ data($des_municipio) }</ns4:cidade>
									}
									{
										for $num_cep in $endereco/ns18:CEPResponse/ns18:num_cep
										return
											<ns4:CEP>{ data($num_cep) }</ns4:CEP>
									}
									{
										for $des_bairro in $endereco/ns18:CEPResponse/ns18:des_bairro
										return
											<ns4:bairro>{ data($des_bairro) }</ns4:bairro>
									}
									{
										for $ind_tpo_lograd in $endereco/ns18:CEPResponse/ns18:ind_tpo_lograd
										return
											<ns4:tipoLogradouro>{ data($ind_tpo_lograd) }</ns4:tipoLogradouro>
									}
									{
										for $des_logradouro in $endereco/ns18:CEPResponse/ns18:des_logradouro
										return
											<ns4:logradouro>{ data($des_logradouro) }</ns4:logradouro>
									}
									{
										for $num_endereco in $endereco/ns18:num_endereco
										return
											<ns4:numeroEndereco>{ data($num_endereco) }</ns4:numeroEndereco>
									}
									{
										for $des_comp_endereco in $endereco/ns18:des_comp_endereco
										return
											<ns4:complemento>{ data($des_comp_endereco) }</ns4:complemento>
									}
								</ns4:Endereco>
							</ns7:endereco>,

						for $ind_situacao_inscr_estadual in fn:number($pessoa/ns18:ind_situacao_inscr_estadual)
						where fn:string($ind_situacao_inscr_estadual) ne 'NaN' and $ind_situacao_inscr_estadual ne 0
						return
							<ns7:situacaoInscricaoEstadual>{
								if ($ind_situacao_inscr_estadual eq 1) then 'HABILITADA'
								else if ($ind_situacao_inscr_estadual eq 2) then 'HABILITADA COM RESTRIÇÕES'
								else if ($ind_situacao_inscr_estadual eq 3) then 'NAO HABILITADA'
								else if ($ind_situacao_inscr_estadual eq 4) then 'INDEFERIMENTO DE BAIXA'
								else if ($ind_situacao_inscr_estadual eq 5) then 'INDISPONÍVEL'
								else if ($ind_situacao_inscr_estadual eq 6) then 'INEXISTENTE'
								else if ($ind_situacao_inscr_estadual eq 7) then 'PARALIZAÇÃO DE ATIVIDADE'
								else if ($ind_situacao_inscr_estadual eq 8) then 'BAIXADA'
								else if ($ind_situacao_inscr_estadual eq 9) then 'CANCELADA'
								else ()
							}</ns7:situacaoInscricaoEstadual>,

						for $dta_situacao_inscr_estadual in data($pessoa/ns18:dta_situacao_inscr_estadual)
						where fn:string-length($dta_situacao_inscr_estadual) >= 8
						return
							<ns7:dataSituacaoInscricaoEstadual>{functx:yyyymmdd-to-date($dta_situacao_inscr_estadual)}</ns7:dataSituacaoInscricaoEstadual>,

						for $ind_situacao_cadast_PF in fn:number($pessoaFisica/ns18:ind_situacao_cadast)
						where fn:string($ind_situacao_cadast_PF) ne 'NaN'
						return
							<ns7:situacaoCadastral>{ 								
								if ($ind_situacao_cadast_PF eq 0) then 'Regular'
								else if ($ind_situacao_cadast_PF eq 1) then 'Cancelada por Encerramento de Espólio'
								else if ($ind_situacao_cadast_PF eq 2) then 'Suspensa'
								else if ($ind_situacao_cadast_PF eq 3) then 'Cancelada por Óbito sem Espólio'
								else if ($ind_situacao_cadast_PF eq 4) then 'Pendente de Regularização'
								else if ($ind_situacao_cadast_PF eq 5) then 'Cancelada por Multiplicidade'
								else if ($ind_situacao_cadast_PF eq 8) then 'Nula'
								else if ($ind_situacao_cadast_PF eq 9) then 'Cancelada de Ofício'
								else()								
							}</ns7:situacaoCadastral>
		
					)
				else if (data($pessoa/ns18:ind_tpo_doc) eq '2') then
					let $pessoaJuridica := $pessoa/ns18:PessoaJuridica return (
						<ns7:clienteProspect>
							<ns5:ClienteProspect>		
								<ns5:tipoPessoa>juridica</ns5:tipoPessoa>							
								{
									for $cod_cnpj in $pessoaJuridica/ns18:cod_cnpj
									return
										<ns5:CNPJ>{ data($cod_cnpj) }</ns5:CNPJ>
								}
								{
									for $cod_inscr_estadual in $pessoa/ns18:cod_inscr_estadual
									return
										<ns5:InscricaoEstadual>{ data($cod_inscr_estadual) }</ns5:InscricaoEstadual>
								}
								{
									for $des_email in $pessoaJuridica/ns18:des_email return
										if(fn:not(fn:empty($des_email)) and normalize-space($des_email) ne '')then
											(<ns5:Emails>
												<ns5:Emails>
													<ns5:EnderecoEmail>{ data($des_email) }</ns5:EnderecoEmail>
												</ns5:Emails>
											</ns5:Emails>)
										else()
								}
								{
									if ($pessoaJuridica/ns18:cod_ddd1 ne ''
											or $pessoaJuridica/ns18:cod_ddd2 ne '') then                    	
										<ns5:TelefonesContato>
										{
											for $cod_ddd1 in $pessoaJuridica/ns18:cod_ddd1
											return
												<ns5:telefoneContato>
													<ns5:DDD>{ data($cod_ddd1) }</ns5:DDD>
													<ns5:numeroTelefone>{ data($pessoaJuridica/ns18:num_telef1) }</ns5:numeroTelefone>
												</ns5:telefoneContato>
										}
										{
											for $cod_ddd2 in $pessoaJuridica/ns18:cod_ddd2
											return
												<ns5:telefoneContato>
													<ns5:DDD>{ data($cod_ddd2) }</ns5:DDD>
													<ns5:numeroTelefone>{ data($pessoaJuridica/ns18:num_telef2) }</ns5:numeroTelefone>
												</ns5:telefoneContato>
										}
										</ns5:TelefonesContato>
									else ()                        
								}
								{
									for $cod_inscr_SUFRAMA in $pessoaJuridica/ns18:cod_inscr_SUFRAMA
									return
										<ns5:CodigoSuframa>{ data($cod_inscr_SUFRAMA) }</ns5:CodigoSuframa>
								}
								{
									for $ind_tpo_cliente in fn:number($pessoa/ns18:ind_tpo_cliente)
									where fn:string($ind_tpo_cliente) ne 'NaN' and $ind_tpo_cliente ne 0
									return
										<ns5:TipoCliente>{ xs:int($ind_tpo_cliente) }</ns5:TipoCliente>
								}							
							</ns5:ClienteProspect>						
						</ns7:clienteProspect>,						
						
						for $endereco in $pessoa/ns18:EnderecoResponse return
							<ns7:endereco>
								<ns4:Endereco>
									{
										for $des_uf in $endereco/ns18:CEPResponse/ns18:CNLResponse/ns18:des_uf
										return
											<ns4:UF>{ data($des_uf) }</ns4:UF>
									}
									{
										for $cod_municip_IBGE in $endereco/ns18:CEPResponse/ns18:CNLResponse/ns18:cod_municip_IBGE
										return
											<ns4:idCidade>{ xs:long( data($cod_municip_IBGE) ) }</ns4:idCidade>
									}
									{
										for $des_municipio in $endereco/ns18:CEPResponse/ns18:CNLResponse/ns18:des_municipio
										return
											<ns4:cidade>{ data($des_municipio) }</ns4:cidade>
									}
									{
										for $num_cep in $endereco/ns18:CEPResponse/ns18:num_cep
										return
											<ns4:CEP>{ data($num_cep) }</ns4:CEP>
									}
									{
										for $des_bairro in $endereco/ns18:CEPResponse/ns18:des_bairro
										return
											<ns4:bairro>{ data($des_bairro) }</ns4:bairro>
									}
									{
										for $ind_tpo_lograd in $endereco/ns18:CEPResponse/ns18:ind_tpo_lograd
										return
											<ns4:tipoLogradouro>{ data($ind_tpo_lograd) }</ns4:tipoLogradouro>
									}
									{
										for $des_logradouro in $endereco/ns18:CEPResponse/ns18:des_logradouro
										return
											<ns4:logradouro>{ data($des_logradouro) }</ns4:logradouro>
									}
									{
										for $num_endereco in $endereco/ns18:num_endereco
										return
											<ns4:numeroEndereco>{ data($num_endereco) }</ns4:numeroEndereco>
									}
									{
										for $des_comp_endereco in $endereco/ns18:des_comp_endereco
										return
											<ns4:complemento>{ data($des_comp_endereco) }</ns4:complemento>
									}
								</ns4:Endereco>
							</ns7:endereco>,

						for $ind_CNAE in $pessoaJuridica/ns18:CNAE[1] return
							<ns7:cnae>
								{
									for $ind_CNAE in data($pessoaJuridica/ns18:CNAE[1]/ns18:ind_CNAE)
									where $ind_CNAE ne ''
									return
										<ns7:identificador>{
											if ($ind_CNAE eq '1') then 'Principal'
											else if ($ind_CNAE eq '2') then 'Secundario'
											else ()
										}</ns7:identificador>
								}
								{
									for $cod_CNAE in $pessoaJuridica/ns18:CNAE[1]/ns18:cod_CNAE
									return
										<ns7:descricao>{ data($cod_CNAE) }</ns7:descricao>
								}
							</ns7:cnae>,

						for $ind_situacao_inscr_estadual in fn:number($pessoa/ns18:ind_situacao_inscr_estadual)
						where fn:string($ind_situacao_inscr_estadual) ne 'NaN' and $ind_situacao_inscr_estadual ne 0
						return
							<ns7:situacaoInscricaoEstadual>{
									if ($ind_situacao_inscr_estadual eq 1) then 'HABILITADA'
									else if ($ind_situacao_inscr_estadual eq 2) then 'HABILITADA COM RESTRIÇÕES'
									else if ($ind_situacao_inscr_estadual eq 3) then 'NAO HABILITADA'
									else if ($ind_situacao_inscr_estadual eq 4) then 'INDEFERIMENTO DE BAIXA'
									else if ($ind_situacao_inscr_estadual eq 5) then 'INDISPONÍVEL'
									else if ($ind_situacao_inscr_estadual eq 6) then 'INEXISTENTE'
									else if ($ind_situacao_inscr_estadual eq 7) then 'PARALIZAÇÃO DE ATIVIDADE'
									else if ($ind_situacao_inscr_estadual eq 8) then 'BAIXADA'
									else if ($ind_situacao_inscr_estadual eq 9) then 'CANCELADA'
									else ()
								}</ns7:situacaoInscricaoEstadual>,

						for $dta_situacao_inscr_estadual in data($pessoa/ns18:dta_situacao_inscr_estadual)
						where fn:string-length($dta_situacao_inscr_estadual) >= 8
						return
							<ns7:dataSituacaoInscricaoEstadual>{functx:yyyymmdd-to-date($dta_situacao_inscr_estadual)}</ns7:dataSituacaoInscricaoEstadual>,

						for $ind_estabelec in data($pessoaJuridica/ns18:ind_estabelec)
						where $ind_estabelec ne ''
						return
							<ns7:indicadorEstabelecimento>{
								if ($ind_estabelec eq '1') then 'Matriz'
								else if ($ind_estabelec eq '2') then 'Filial'
								else()
							}</ns7:indicadorEstabelecimento>,

						for $nom_fantasia in $pessoaJuridica/ns18:nom_fantasia
						return
							<ns7:nomeFantasia>{ data($nom_fantasia) }</ns7:nomeFantasia>,

						for $ind_situacao_cadast_PJ in fn:number($pessoaJuridica/ns18:ind_situacao_cadast)
						where fn:string($ind_situacao_cadast_PJ) ne 'NaN' and $ind_situacao_cadast_PJ ne 0
						return
							<ns7:situacaoCadastral>{ 
								if ($ind_situacao_cadast_PJ eq 1) then 'Nula'
								else if ($ind_situacao_cadast_PJ eq 2) then 'Ativa'
								else if ($ind_situacao_cadast_PJ eq 3) then 'Suspensa'
								else if ($ind_situacao_cadast_PJ eq 4) then 'Inapta'
								else if ($ind_situacao_cadast_PJ eq 8) then 'Baixada'
								else()
							}</ns7:situacaoCadastral>,

						for $dta_situacao_cadast in data($pessoaJuridica/ns18:dta_situacao_cadast)
						where fn:string-length($dta_situacao_cadast) >= 8
						return
							<ns7:dataSituacaoCadastral>{ functx:yyyymmdd-to-date($dta_situacao_cadast) }</ns7:dataSituacaoCadastral>,

						for $cod_natureza_jurid in $pessoaJuridica/ns18:cod_natureza_jurid
						return
							<ns7:codigoNaturezaJuridica>{ xs:int( data($cod_natureza_jurid) ) }</ns7:codigoNaturezaJuridica>,

						for $dta_abertura_estabelec in $pessoaJuridica/ns18:dta_abertura_estabelec
						where fn:string-length($dta_abertura_estabelec) >= 8
						return
							<ns7:dataAberturaEstabelecimento>{ functx:yyyymmdd-to-date($dta_abertura_estabelec) }</ns7:dataAberturaEstabelecimento>,

						for $ind_porte_serpro in fn:number($pessoaJuridica/ns18:ind_porte_serpro)
						where fn:string($ind_porte_serpro) ne 'NaN' and $ind_porte_serpro ne 0
						return
							<ns7:porteSerpro>{
								if ($ind_porte_serpro eq 1) then 'Microempresa'
								else if ($ind_porte_serpro eq 3) then 'Empresa de Pequeno Porte'
								else if ($ind_porte_serpro eq 5) then 'Demais'
								else ()
							}</ns7:porteSerpro>,

						for $ind_opcao_simples in data($pessoaJuridica/ns18:ind_opcao_simples)
						where $ind_opcao_simples ne ''
						return
							<ns7:indicadorOpcaoSimples>{
								if (fn:upper-case($ind_opcao_simples) eq 'S') then fn:true()
								else fn:false()
							}</ns7:indicadorOpcaoSimples>,

						for $ind_situacao_inscr_SUFRAMA in fn:number($pessoaJuridica/ns18:ind_situacao_inscr_SUFRAMA)
						where fn:string($ind_situacao_inscr_SUFRAMA) ne 'NaN' and $ind_situacao_inscr_SUFRAMA ne 0
						return
							<ns7:situacaoSuframa>{
								if ($ind_situacao_inscr_SUFRAMA eq 1) then 'Bloqueado'
								else if ($ind_situacao_inscr_SUFRAMA eq 2) then 'Cancelado'
								else if ($ind_situacao_inscr_SUFRAMA eq 3) then 'Habilitada'
								else if ($ind_situacao_inscr_SUFRAMA eq 4) then 'Inativa'
								else if ($ind_situacao_inscr_SUFRAMA eq 5) then 'Não habilitada'
								else if ($ind_situacao_inscr_SUFRAMA eq 6) then 'Inexistente'
								else ()
							}</ns7:situacaoSuframa>,

						for $dta_situacao_inscr_SUFRAMA in data($pessoaJuridica/ns18:dta_situacao_inscr_SUFRAMA)
						where fn:string-length($dta_situacao_inscr_SUFRAMA) >= 8
						return
							<ns7:dataSituacaoSuframa>{  functx:yyyymmdd-to-date($dta_situacao_inscr_SUFRAMA) }</ns7:dataSituacaoSuframa>,

						for $cod_pais_estab_exterior in $pessoaJuridica/ns18:cod_pais_estab_exterior
						return
							<ns7:indicadorInternacional>{
								if (data($cod_pais_estab_exterior) eq '' or data($cod_pais_estab_exterior) eq '0') then fn:false()
								else fn:true()
							}</ns7:indicadorInternacional>
					)
				else (),
					
				for $ind_classe_consumo in $pessoa/ns18:ind_classe_consumo where fn:string($ind_classe_consumo) ne 'NaN'
				return
					<ns7:classeConsumo>{ data($ind_classe_consumo) }</ns7:classeConsumo>,
					
				for $ind_tipo_assinante in $pessoa/ns18:ind_tipo_assinante where fn:string($ind_tipo_assinante) ne 'NaN'
				return
					<ns7:naturezaAssinante>{ data($ind_tipo_assinante) }</ns7:naturezaAssinante>,
					
				for $ind_tpo_cliente in $pessoa/ns18:ind_tpo_cliente where fn:string($ind_tpo_cliente) ne 'NaN'
				return
					<ns7:tipoCliente>{ data($ind_tpo_cliente) }</ns7:tipoCliente>
				)
		}</ns7:consultarClienteBvcResponse>
};

declare variable $retornoSolicitacao as element() external;

xf:TransformarDataEmClienteProspectXQuery($retornoSolicitacao)
