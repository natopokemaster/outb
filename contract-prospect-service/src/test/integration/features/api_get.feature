# Author: Carmem Pereira @ DXC
# Date: 2022-05-10

@apiproxy
Feature: Backend contract-prospect-service - responsável por efetuar a consulta dos dados do Contrato de Venda (Prospect) de um contrato do NETSMS.

  # 1. Test / GET Consulta por Smart Card Pessoa FISICA - Expected code: 200
#
  Scenario: 1. Test / GET Consulta por Smart Card Pessoa FISICA - Expected code: 200
    Given I set content-type header to application/json
    And I set smartcardnumber header to S001153689638A39
    And I set Authorization header to Basic Zm9vOjEyMzQ1
    When I GET contract-prospect-service/contracts/prospects
    Then response code should be 200
    And response body path $.data.customerProspects.[0].id should not be empty
    And response body path $.data.customerProspects.[0].name should not be empty
    And response body path $.data.customerProspects.[0].personType should not be empty
    And response body path $.data.customerProspects.[0].personType should be FISICA
    And response body path $.data.customerProspects.[0].contract.customerAccountId should not be empty
    And response body path $.data.customerProspects.[0].contract.verificationDigit should not be empty


# 2. Test / GET Consulta por Contrato e Código da Operadora Pessoa FISICA - Expected code: 200
#
  Scenario: 2. Test / GET Consulta por Contrato e Código da Operadora Pessoa FISICA - Expected code: 200
    Given I set content-type header to application/json
    And I set customeraccountid header to 269406
    And I set operatorcode header to 021
    And I set Authorization header to Basic Zm9vOjEyMzQ1
    When I GET contract-prospect-service/contracts/prospects
    Then response code should be 200
    And response body path $.data.customerProspects.[0].id should not be empty
    And response body path $.data.customerProspects.[0].name should not be empty
    And response body path $.data.customerProspects.[0].personType should not be empty
    And response body path $.data.customerProspects.[0].personType should be FISICA
    And response body path $.data.customerProspects.[0].contract.customerAccountId should be 269406
    And response body path $.data.customerProspects.[0].contract.organization.operatorCode should be 021


# 3. Test / GET Consulta por Contrato e Código da Cidade Pessoa FISICA - Expected code: 200
	Scenario: 3. Test / GET Consulta por Contrato e Código da Cidade Pessoa FISICA - Expected code: 200
    Given I set content-type header to application/json
    And I set customeraccountid header to 181873296
    And I set cityid header to 02121
    And I set Authorization header to Basic Zm9vOjEyMzQ1
    When I GET contract-prospect-service/contracts/prospects
    Then response code should be 200
    And response header content-type should be application/json
    And response body path $.data.customerProspects.[0].contract.customerAccountId should be 181873296
    And response body path $.data.customerProspects.[0].contract.customerAccountId should not be empty
    And response body path $.data.customerProspects.[0].contract.verificationDigit should not be empty
    And response body path $.data.customerProspects.[0].contract.verificationDigit should be 1
    And response body path $.data.customerProspects.[0].contract.organization.cityId should not be empty
    And response body path $.data.customerProspects.[0].contract.organization.cityId should be 02121


# 4. Test / GET Consulta por Número de Protocolo Pessoa FISICA - Expected code: 200
	Scenario: 4. Test / GET Consulta por Número de Protocolo Pessoa FISICA - Expected code: 200
    Given I set content-type header to application/json
    And I set protocolnumber header to 021180000003827
    And I set Authorization header to Basic Zm9vOjEyMzQ1
    When I GET contract-prospect-service/contracts/prospects
    Then response code should be 200
    And response header content-type should be application/json
    And response body path $.data.customerProspects.[0].id should not be empty
    And response body path $.data.customerProspects.[0].name should not be empty
    And response body path $.data.customerProspects.[0].personType should not be empty
    And response body path $.data.customerProspects.[0].personType should be FISICA
    And response body path $.data.customerProspects.[0].contract.customerAccountId should not be empty


# 5. Test / GET Consulta por Código do Endereçável Pessoa FISICA - Expected code: 200
	Scenario: 5. Test / GET Consulta por Código do Endereçável Pessoa FISICA - Expected code: 200
    Given I set content-type header to application/json
    And I set addressablecode header to S001153689638A39
    And I set Authorization header to Basic Zm9vOjEyMzQ1
    When I GET contract-prospect-service/contracts/prospects
    Then response code should be 200
    And response header content-type should be application/json
    And response body path $.data.customerProspects.[0].id should not be empty
    And response body path $.data.customerProspects.[0].name should not be empty
    And response body path $.data.customerProspects.[0].personType should be FISICA
    And response body path $.data.customerProspects.[0].contract.customerAccountId should not be empty
    And response body path $.data.customerProspects.[0].contract.verificationDigit should not be empty


# 6. Test / GET Consulta por CPF/CNPJ Pessoa FISICA - Expected code: 200
	Scenario: 6. Test / GET Consulta por CPF/CNPJ Pessoa FISICA - Expected code: 200
    Given I set content-type header to application/json
    And I set identificationid header to 25762034186
    And I set Authorization header to Basic Zm9vOjEyMzQ1
    When I GET contract-prospect-service/contracts/prospects
    Then response code should be 200
    And response header content-type should be application/json
    And response body path $.data.customerProspects.[0].id should not be empty
    And response body path $.data.customerProspects.[0].name should not be empty
    And response body path $.data.customerProspects.[0].personType should be FISICA
    And response body path $.data.customerProspects.[0].contract.customerAccountId should not be empty
    And response body path $.data.customerProspects.[0].contract.verificationDigit should not be empty


# 7. Test / GET Consulta por Número do Telefone Pessoa FISICA - Expected code: 200
	Scenario: 7. Test / GET Consulta por Número do Telefone Pessoa FISICA - Expected code: 200
    Given I set content-type header to application/json
    And I set areacode header to 022
    And I set phonenumber header to 221123193
    And I set Authorization header to Basic Zm9vOjEyMzQ1
    When I GET contract-prospect-service/contracts/prospects
    Then response code should be 200
    And response header content-type should be application/json
    And response body path $.data.customerProspects.[0].name should be XEOM HMJMXL ZXZGD KK JRUMOR
    And response body path $.data.customerProspects.[0].personType should be FISICA
    And response body path $.data.customerProspects.[0].contract.customerAccountId should be 269406


# 8. Test / GET Consulta por Smart Card Pessoa JURIDICA - Expected code: 200
	Scenario: 8. Test / GET Consulta por Smart Card Pessoa JURIDICA - Expected code: 200
    Given I set content-type header to application/json
    And I set smartcardnumber header to DE0ILDHCG285512D
    And I set Authorization header to Basic Zm9vOjEyMzQ1
    When I GET contract-prospect-service/contracts/prospects
    Then response code should be 200
    And response header content-type should be application/json
    And response body path $.data.customerProspects.[0].id should not be empty
    And response body path $.data.customerProspects.[0].id should be 500
    And response body path $.data.customerProspects.[0].name should not be empty
    And response body path $.data.customerProspects.[0].name should be YTLNMTX MQVFKSS VA YSLOZVZN
    And response body path $.data.customerProspects.[0].personType should not be empty
    And response body path $.data.customerProspects.[0].personType should be JURIDICA
    And response body path $.data.customerProspects.[0].contract.customerAccountId should not be empty
    And response body path $.data.customerProspects.[0].contract.verificationDigit should not be empty



# 9. Test / GET Consulta por Contrato e Código da Operadora Pessoa JURIDICA - Expected code: 200
	Scenario: 9. Test / GET Consulta por Contrato e Código da Operadora Pessoa JURIDICA - Expected code: 200
    Given I set content-type header to application/json
    And I set customeraccountid header to 663999
    And I set operatorcode header to 052
    And I set Authorization header to Basic Zm9vOjEyMzQ1
    When I GET contract-prospect-service/contracts/prospects
    Then response code should be 200
    And response header content-type should be application/json
    And response body path $.data.customerProspects.[0].personType should be JURIDICA
    And response body path $.data.customerProspects.[0].organizationIdentifications.[0].type should be CNPJ


# 10. Test / GET Consulta por Contrato e Código da Cidade Pessoa JURIDICA - Expected code: 200
	Scenario: 10. Test / GET Consulta por Contrato e Código da Cidade Pessoa JURIDICA - Expected code: 200
    Given I set content-type header to application/json
    And I set customeraccountid header to 663999
    And I set cityid header to 05509
    And I set Authorization header to Basic Zm9vOjEyMzQ1
    When I GET contract-prospect-service/contracts/prospects
    Then response code should be 200
    And response header content-type should be application/json
    And response body path $.data.customerProspects.[0].personType should be JURIDICA
    And response body path $.data.customerProspects.[0].organizationIdentifications.[0].type should be CNPJ
    And response body path $.data.customerProspects.[0].contract.organization.cityId should be 05509
    And response body path $.data.customerProspects.[0].contract.organization.operatorCityName should be CAMPINAS

# 11. Test / GET Consulta por Número de Protocolo Pessoa JURIDICA - Expected code: 200
	Scenario: 11. Test / GET Consulta por Número de Protocolo Pessoa JURIDICA - Expected code: 200
    Given I set content-type header to application/json
    And I set protocolnumber header to 021200750372014
    And I set Authorization header to Basic Zm9vOjEyMzQ1
    When I GET contract-prospect-service/contracts/prospects
    Then response code should be 200
    And response header content-type should be application/json
    And response body path $.data.customerProspects.[0].id should be 18435850
    And response body path $.data.customerProspects.[0].personType should be JURIDICA


# 12. Test / GET Consulta por Código do Endereçável Pessoa JURIDICA - Expected code: 200
	Scenario: 12. Test / GET Consulta por Código do Endereçável Pessoa JURIDICA - Expected code: 200
    Given I set content-type header to application/json
    And I set addressablecode header to DE0ILDHCG285512D
    And I set Authorization header to Basic Zm9vOjEyMzQ1
    When I GET contract-prospect-service/contracts/prospects
    Then response code should be 200
    And response header content-type should be application/json
    And response body path $.data.customerProspects.[0].id should not be empty
    And response body path $.data.customerProspects.[0].id should be 500
    And response body path $.data.customerProspects.[0].name should not be empty
    And response body path $.data.customerProspects.[0].name should be YTLNMTX MQVFKSS VA YSLOZVZN
    And response body path $.data.customerProspects.[0].personType should not be empty
    And response body path $.data.customerProspects.[0].personType should be JURIDICA
    And response body path $.data.customerProspects.[0].contract.customerAccountId should not be empty
    And response body path $.data.customerProspects.[0].contract.verificationDigit should not be empty

# 13. Test / GET Consulta por CNPJ Pessoa JURIDICA - Expected code: 200
	Scenario: 13. Test / GET Consulta por CNPJ Pessoa JURIDICA - Expected code: 200
    Given I set content-type header to application/json
    And I set Authorization header to Basic Zm9vOjEyMzQ1
    And I set identificationid header to 461781349243186
    When I GET contract-prospect-service/contracts/prospects
    Then response code should be 200
    And response header content-type should be application/json
    And response body path $.data.customerProspects.[0].id should be 500
    And response body path $.data.customerProspects.[0].personType should be JURIDICA
    And response body path $.data.customerProspects.[0].organizationIdentifications.[0].type should be CNPJ


# 14. Test / GET Consulta por Número do Telefone Pessoa JURIDICA - Expected code: 200
	Scenario: 14. Test / GET Consulta por Número do Telefone Pessoa JURIDICA - Expected code: 200
    Given I set content-type header to application/json
    And I set Authorization header to Basic Zm9vOjEyMzQ1
    And I set areacode header to 43
    And I set phonenumber header to 34327333
    When I GET contract-prospect-service/contracts/prospects
    Then response code should be 200
    And response header content-type should be application/json
    And response body path $.data.customerProspects.[0].id should be 500
    And response body path $.data.customerProspects.[0].personType should be JURIDICA
    And response body path $.data.customerProspects.[0].organizationIdentifications.[0].type should be CNPJ


# 15. Test / GET Consulta por Contrato e Código da Operadora INVALIDO Pessoa FISICA - Expected code: 400
	Scenario: 15. Test / GET Consulta por Contrato e Código da Operadora INVALIDO Pessoa FISICA - Expected code: 400
    Given I set content-type header to application/json
    And I set customeraccountid header to 12419529
    And I set operatorcode header to @
    And I set Authorization header to Basic Zm9vOjEyMzQ1
    When I GET contract-prospect-service/contracts/prospects
    Then response code should be 400
    And response body path $.error.httpCode should be 400


# 16. Test / GET Consulta por Contrato e Código da Cidade INVALIDA Pessoa FISICA - Expected code: 400
	Scenario: 16. Test / GET Consulta por Contrato e Código da Cidade INVALIDA Pessoa FISICA - Expected code: 400
    Given I set content-type header to application/json
    And I set customeraccountid header to 12419529
    And I set cityid header to !
    And I set Authorization header to Basic Zm9vOjEyMzQ1
    When I GET contract-prospect-service/contracts/prospects
    Then response code should be 400
    And response body path $.error.httpCode should be 400


# 17. Test / GET Consulta por Número de Protocolo INVALIDO Pessoa FISICA  - Expected code: 400
	Scenario: 17. Test / GET Consulta por Número de Protocolo INVALIDO Pessoa FISICA  - Expected code: 400
    Given I set content-type header to application/json
    And I set protocolnumber header to 123A45
    And I set Authorization header to Basic Zm9vOjEyMzQ1
    When I GET contract-prospect-service/contracts/prospects
    Then response code should be 400
    And response body path $.error.httpCode should be 400

# 18. Test / GET Consulta por CPF INVALIDO Pessoa FISICA   - Expected code: 400
	Scenario: 18. Test / GET Consulta por CPF INVALIDO Pessoa FISICA   - Expected code: 400
    Given I set content-type header to application/json
    And I set identificationid header to 41573ABC200
    And I set Authorization header to Basic Zm9vOjEyMzQ1
    When I GET contract-prospect-service/contracts/prospects
    Then response code should be 400
    And response body path $.error.httpCode should be 400


# 19. Test / GET Consulta por Número do Telefone INVALIDO Pessoa FISICA   - Expected code: 400
	Scenario: 19. Test / GET Consulta por Número do Telefone INVALIDO Pessoa FISICA   - Expected code: 400
    Given I set content-type header to application/json
    And I set phonenumber header to teste_24322134Y
    And I set areacode header to 11
    And I set Authorization header to Basic Zm9vOjEyMzQ1
    When I GET contract-prospect-service/contracts/prospects
    Then response code should be 400
    And response body path $.error.httpCode should be 400

# 20. Test / GET Consulta por DDD INVALIDO Pessoa FISICA   - Expected code: 400
	Scenario: 20. Test / GET Consulta por DDD INVALIDO Pessoa FISICA   - Expected code: 400
    Given I set content-type header to application/json
    And I set areacode header to teste_xx
    And I set phonenumber header to 24322134
    And I set Authorization header to Basic Zm9vOjEyMzQ1
    When I GET contract-prospect-service/contracts/prospects
    Then response code should be 400
    And response body path $.error.httpCode should be 400


# 22. Test / GET Consulta de dados cadastrais (Generico) - Expected code: 400
	Scenario: 22. Test / GET Consulta de dados cadastrais (Generico) - Expected code: 400
    Given I set content-type header to application/json
    And I set Authorization header to Basic Zm9vOjEyMzQ1
    When I GET contract-prospect-service/contracts/prospects
    Then response code should be 400
    And response body path $.error.httpCode should be 400
