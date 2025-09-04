# Author: Gabriel Joioso @ DXC
# Date: 2024-11-01

@apiproxy
Feature: API proxy endpoints - Usage Broadbands GET

	@services @GET
	Scenario: 0. Test / GET endpoint - Consulta consolidada utilizando customerContractId e operatorCode com sucesso, response code 200
		Given I set headers to
			| name             | value                                                                                          								 |
			| Authorization    | Basic q5kschvahv                                                                             								 |
			| X-QueryString    | customerContractId=295300&operatorCode=013&addressableCode=000E5CDDDDE92&startDate=2012-02-16&endDate=2013-01-30&detailed=false |
		When I GET /consumption-netsms-serviceusagebroadbands/consumption/v1/netsms/serviceusages/broadbands
		Then response code should be 200
		And response body should be valid json

	Scenario: 1. Test / GET endpoint - Consulta detalhada utilizando customerContractId e operatorCode com sucesso, response code 200
		Given I set headers to
			| name             | value                                                                                          								|
			| Authorization    | Basic Zm9vOjEyMzQ1                                                                             								|
			| X-QueryString    | customerContractId=295300&operatorCode=013&addressableCode=000E5CDDDDE92&startDate=2012-02-16&endDate=2013-01-30&detailed=true |
		When I GET /consumption-netsms-serviceusagebroadbands/consumption/v1/netsms/serviceusages/broadbands
		Then response code should be 200
		And response body should be valid json

	Scenario: 2. Test / GET endpoint - Consulta consolidada utilizando customerContractId e cityId com sucesso, response code 200
		Given I set headers to
			| name             | value                                                                                          							 |
			| Authorization    | Basic Zm9vOjEyMzQ1                                                                             							 |
			| X-QueryString    | customerContractId=295300&cityId=25666&addressableCode=000E5CDDDDE92&startDate=2012-02-16&endDate=2013-01-30&detailed=false |
		When I GET /consumption-netsms-serviceusagebroadbands/consumption/v1/netsms/serviceusages/broadbands
		Then response code should be 200
		And response body should be valid json

	Scenario: 3. Test / GET endpoint - Consulta consolidada utilizando smartCard com sucesso, response code 200
		Given I set headers to
			| name             | value                                                                                          			  |
			| Authorization    | Basic Zm9vOjEyMzQ1                                                                             			  |
			| X-QueryString    | smartCardNumber=000E5CDDDDE92&addressableCode=000E5CDDDDE92&startDate=2012-02-16&endDate=2013-01-30&detailed=false |
		When I GET /consumption-netsms-serviceusagebroadbands/consumption/v1/netsms/serviceusages/broadbands
		Then response code should be 200
		And response body should be valid json

	Scenario: 4. Test / GET endpoint - Consulta consolidada sem passar customerContractId ou smartCard, response code 400
	Given I set headers to
		| name             | value                                                                                          |
		| Authorization    | Basic Zm9vOjEyMzQ1                                                                             |
		| X-QueryString    | addressableCode=000E5CDDDDE92&startDate=2012-02-16&endDate=2013-01-30&detailed=false 			|
		When I GET /consumption-netsms-serviceusagebroadbands/consumption/v1/netsms/serviceusages/broadbands
		Then response code should be 400
		And response body should be valid json

	Scenario: 5. Test / GET endpoint - Consulta consolidada passando o contrato mas sem operatorCode ou cityId, response code 400
		Given I set headers to
			| name             | value                                                                                          							|
			| Authorization    | Basic Zm9vOjEyMzQ1                                                                             						    |
			| X-QueryString    | customerContractId=295300&addressableCode=000E5CDDDDE92&startDate=2012-02-16&endDate=2013-01-30&detailed=false 			|
		When I GET /consumption-netsms-serviceusagebroadbands/consumption/v1/netsms/serviceusages/broadbands
		Then response code should be 400
		And response body should be valid json

	Scenario: 6. Test / GET endpoint - Consulta consolidada com formato de data invalido, response code 400
		Given I set headers to
			| name             | value                                                                                          											|
			| Authorization    | Basic Zm9vOjEyMzQ1                                                                             						    				|
			| X-QueryString    | customerContractId=295300&operatorCode=013&addressableCode=000E5CDDDDE92&startDate=2012-02-32&endDate=2013-01-32&detailed=false 			|
		When I GET /consumption-netsms-serviceusagebroadbands/consumption/v1/netsms/serviceusages/broadbands
		Then response code should be 400
		And response body should be valid json

	Scenario: 7. Test / GET endpoint - Ausencia de campos requeridos, response code 400
		Given I set headers to
			| name             | value                                                                                          							|
			| Authorization    | Basic Zm9vOjEyMzQ1                                                                             						    |
			| X-QueryString    | customerContractId=295300&operatorCode=013 																				|
		When I GET /consumption-netsms-serviceusagebroadbands/consumption/v1/netsms/serviceusages/broadbands
		Then response code should be 400
		And response body should be valid json

	Scenario: 8. Test / GET endpoint - X-Query String em formato invalido, response code 400
		Given I set headers to
			| name             | value                                                                                          							     |
			| Authorization    | Basic Zm9vOjEyMzQ1                                                                             						         |
			| X-QueryString    | customerContractId295300&operatorCode=013&addressableCode=000E5CDDDE92&startDate=2012-02-16&endDate=2013-01-30&detailed=false   |
		When I GET /consumption-netsms-serviceusagebroadbands/consumption/v1/netsms/serviceusages/broadbands
		Then response code should be 400
		And response body should be valid json

	Scenario: 9. Test / GET endpoint - Campo endDate contém uma data anterior a startDate, response code 400
		Given I set headers to
			| name             | value                                                                                          							     |
			| Authorization    | Basic Zm9vOjEyMzQ1                                                                             						         |
			| X-QueryString    | customerContractId=295300&operatorCode=013&addressableCode=000E5CDDDE92&startDate=2012-02-16&endDate=2011-01-30&detailed=false  |
		When I GET /consumption-netsms-serviceusagebroadbands/consumption/v1/netsms/serviceusages/broadbands
		Then response code should be 400
		And response body should be valid json

	Scenario: 10. Test / GET endpoint - CityId não encontrado de acordo com o operatorCode passado no request, response code 422
		Given I set headers to
			| name             | value                                                                                          							     |
			| Authorization    | Basic Zm9vOjEyMzQ1                                                                             						         |
			| X-QueryString    | customerContractId=295300&operatorCode=099&addressableCode=000E5CDDDE92&startDate=2012-02-16&endDate=2013-01-30&detailed=false  |
		When I GET /consumption-netsms-serviceusagebroadbands/consumption/v1/netsms/serviceusages/broadbands
		Then response code should be 422
		And response body should be valid json

	Scenario: 11. Test / GET endpoint - Dados do assinante não encontrado, response code 422
		Given I set headers to
			| name             | value                                                                                          							     |
			| Authorization    | Basic Zm9vOjEyMzQ1                                                                             						         |
			| X-QueryString    | customerContractId=29&operatorCode=013&addressableCode=000E5CDDDE92&startDate=2012-02-16&endDate=2013-01-30&detailed=false      |
		When I GET /consumption-netsms-serviceusagebroadbands/consumption/v1/netsms/serviceusages/broadbands
		Then response code should be 422
		And response body should be valid json
