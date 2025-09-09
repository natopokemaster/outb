package br.com.clarobr.contractprospectservice.constants;

import java.sql.Date;

public class ContractProspectServiceConstansts {

	public static final int ACCEPTED = 202;
	public static final int OK = 200;

	public static final int BAD_REQUEST = 400;
	public static final int FORBIDDEN = 403;
	public static final int GONE = 410;
	public static final int METHOD_NOT_ALLOWED = 405;
	public static final int NOT_ACCEPTABLE = 406;
	public static final int NOT_FOUND = 404;
	public static final int TOO_MANY_REQUESTS = 429;
	public static final int UNAUTHORIZED = 401;
	public static final int UNAVAILABLE_FOR_LEGAL_REASONS = 451;
	public static final int UNPROCESSABLE_ENTITY = 422;

	public static final int DEFAULT_CITY_CODE_LENGTH = 5;
	public static final int DEFAULT_CNPJ_LENGTH = 14;
	public static final int DEFAULT_CPF_LENGTH = 11;
	public static final int DEFAULT_INTERACTION_ID_LENGTH = 15;
	public static final int DEFAULT_PHONE_NUMBER_LENGTH = 11;

	public static final int INTERNAL_SERVER_ERROR = 500;
	public static final int SERVICE_UNAVAILABLE = 503;

	public static final String FAILED_RESPONSE = "0";
	public static final String SUCCESSFUL_RESPONSE = "1";

	public static final String COM_PHONE_COLUMN = "TEL_COM";
	public static final String MOB_PHONE_COLUMN = "CC_TEL_CEL";
	public static final String RES_PHONE_COLUMN = "TEL_RES";

	public static final String FLAG_NO = "N";
	public static final String FLAG_YES = "S";

	public static final String FLAG_DEFAULTER = "INADIMPLENTE";
	public static final String FLAG_NOT_DEFAULTER = "ADIMPLENTE";

	public static final String FL_STATUS_BI = "A";

	public static final String CITY_CODE = "cityId";
	public static final String DOCUMENT_NUMBER = "documentNumber";

	public static final String INTERNAL_SERVER_ERROR_MESSAGE = "Internal Server Error";
	public static final String NOT_FOUND_MESSAGE = "Not entities found";

	public static final String NETUNO_MIGRATION_VALUE = "1";

	public static final Integer ANALOGIC_PAYTV = 1;
	public static final Integer DIGITAL_PAYTV = 3;
	public static final Integer INTERNET = 2;
	public static final Integer NETFONE = 3;
	public static final String NETFONE_VALUE = "netfone";
	public static final String TELEFONE_CELULAR = "celular";
	public static final String TELEFONE_COMERCIAL = "comercial";
	public static final String TELEFONE_RESIDENCIAL = "residencial";

	public static final String AFFILIATED_CONTRACT = "3";

	public static final String CENTRALIZED_BILLING_UNITY_ADD = "2";
	public static final String CODE_INVALID_FORMAT = "003";
	public static final String CODE_INVALID_REQUEST = "002";
	public static final String CODE_NOT_FOUND = "404";
	public static final String CODE_PARAMS_NOT_FOUND = "001";
	public static final String DESCENTRALIZED_BILLING = "3";

	public static final String CODE_CONTRACT_NOT_FOUND = "005";

	public static final String CODE_INVALID_PARAMETER = "006";
	public static final String CODE_UTILS_BAD_REQUEST = "009";
	public static final String CODE_UTILS_NOT_FOUND = "008";
	public static final String CODE_UTILS_UNPROCESSABLE = "010";

	public static final String DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE = "{}: {} - Call {} - Params: {}";
	public static final String DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END = "End {}: {} - Call {} - Params: {}";
	public static final String DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START = "Starting {}: {} - Call {} - Params: {}";
	public static final String DEFAULT_LOG_FORMAT_END_MESSAGE = "End resource {} - Params: {}";
	public static final String DEFAULT_LOG_FORMAT_ERROR = "Class: {} - Method {} - Error: {} - StackTrace: {}";
	public static final String DEFAULT_LOG_FORMAT_ERROR_WITHOUT_STACK_TRACE = "Class: {} - Method {} - Error: {}";
	public static final String DEFAULT_LOG_FORMAT_GENERIC_MESSAGE = "Class: {} - Method {} - Message: {}";
	public static final String DEFAULT_LOG_FORMAT_METHOD_INSIDE_CLASS_END = "End {}: {} - Params: {}";
	public static final String DEFAULT_LOG_FORMAT_METHOD_INSIDE_CLASS_START = "Starting {}: {} - Params: {}";
	public static final String DEFAULT_LOG_FORMAT_START_MESSAGE = "Launch resource {} - Params: {}";

	public static final String DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_RESOURCE_METHOD_GET_CONTRACT_PROSPECTS = "getContractProspects";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_CREATE_GET_CONTRACT_PROSPECTS = "getContractProspects";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_GET_CUSTOMER_PROSPECT_DATA = "getCustomerProspectData";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_GET_CUSTOMER_PROSPECT_DATA_BY_DOCUMENT_ID = "getCustomerProspectDataByDocumentId" ;
	public static final String DEFAULT_LOG_MESSAGE_CLASS_FIND_SN_REL_STATUS_CONTRATO_SERVICE_METHOD_FIND_SN_REL_STATUS_CONTRATO = "findSnRelStatusContrato";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_RH_PESSOA_JURIDICA_SERVICE_METHOD_FIND_RH_PESSOA_JURIDICA = "findRhPessoaJuridica";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_RH_PESSOA_JURIDICA_SERVICE_METHOD_FIND_RH_PESSOA_JURIDICA_AND_SET_CONTRACT = "findRhPessoaJuridicaAndSetContract";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_ASSINANTE_SERVICE_METHOD_FIND_ASSINANTE = "getCustomerProspectData";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_ASSINANTE_SERVICE_METHOD_FIND_ASSINANTE_BY_DOCUMENT_ID = "findAssinanteByDocumentId";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_ASSINANTE_SERVICE_METHOD_FIND_ASSINANTE_BY_PHONE_NUMBER_AND_AREA_CODE = "findAssinanteByAreaCodeAndPhoneNumber";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_CIDADE_OPERADORA_SERVICE_METHOD_FIND_CIDADE_OPERADORA = "findCidadeOperadora";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_CIDADE_OPERADORA_SERVICE_METHOD_FIND_CIDADE_OPERADORA_AND_SET_CONTRACT = "findCidadeOperadoraAndSetContract";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_CONTRATO_SERVICE_METHOD_FIND_CONTRATO_BY_CUSTOMER_ACCOUNT_ID_AND_CITY_ID = "findContratoByCustomerAccountIdAndCityId";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_CONTRATO_SERVICE_METHOD_FIND_CONTRATO_BY_ID_ASSINATE = "findContratoByIdAssinate";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_ESTADO_CIVIL_SERVICE_METHOD_FIND_ASSINANTE = "findEstadoCivil";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_ORGAO_EXPEDIDOR_SERVICE_METHOD_FIND_ORGAO_EXPEDIDOR = "findOrgaoExpedidor";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_PREPOSTO_SERVICE_METHOD_FIND_SN_PREPOSTA_BY_NUM_CONTRATO_AND_CID_CONTRATO = "findSnPrepostaByNumContratoAndCidContrato";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_PROFISSAO_SERVICE_METHOD_FIND_PROFISSAO = "findProfissao";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_RAZAO_CANCELAMENTO_SERVICE_METHOD_FIND_RAZAO_CANCELAMENTO = "findRazaoCancelamento";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_REL_ASSINANTE_SEGMENTACAO_SERVICE_METHOD_FIND_REL_ASSINANTE_SEGMENTACAO = "findRelAssinanteSegmentacao";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_SEXO_SERVICE_METHOD_FIND_SEXO = "findSexo";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_STATUS_CONTRATO_SERVICE_METHOD_FIND_STATUS_CONTRATO = "findStatusContrato";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_STATUS_CONTRATO_SERVICE_METHOD_FIND_STATUS_CONTRATO_AND_SET_CONTRACT = "findStatusContratoAndSetContract";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_TELEFONE_VOIP_SERVICE_METHOD_FIND_TELEPHONES = "findTelephones";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_CONTRATO_SERVICE_METHOD_FIND_TIPO_CONTRATO = "findTipoContrato";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_CONTRATO_SERVICE_METHOD_FIND_TIPO_CONTRATO_AND_SET_CONTRACT = "findTipoContratoAndSetContract";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_SEGMENTO_SERVICE_METHOD_FIND_TIPO_SEGMENTO = "findTipoSegmento";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_SEGMENTO_SERVICE_METHOD_FIND_TIPO_SEGMENTO_AND_SET_CONTRACT = "findTipoSegmentoAndSetContract";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_VENDA_SERVICE_METHOD_FIND_TIPO_VENDA = "findTipoVenda";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_VENDA_SERVICE_METHOD_FIND_TIPO_VENDA_AND_SET_CONTRACT = "findTipoVendaAndSetContract";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_VALIDATE_UTILS_METHOD_VALIDATE_INTERACTION_ID = "validateInteractionId";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_VALIDATE_UTILS_METHOD_VALIDE_CONTRACT_PROSPECT_INPUT = "valideContractProspectInput";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_VSN_VENDEDORES_SERVICE_METHOD_FIND_VSN_VENDEDOR = "findVsnVendedor";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_VSN_VENDEDORES_SERVICE_METHOD_FIND_VSN_VENDEDOR_AND_SET_CONTRACT = "findVsnVendedorAndSetContract";
	public static final String DEFAULT_LOG_MESSAGE_CONTRACT_PROSPECT_RESOURCE = "ContractProspectResource";
	public static final String DEFAULT_LOG_MESSAGE_CONTRACT_PROSPECT_SERVICE = "ContractProspectService";
	public static final String DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE = "CustomerProspectService";
	public static final String DEFAULT_LOG_MESSAGE_RH_PESSOA_JURIDICA_SERVICE = "RhPessoaJuridicaServiceImpl";
	public static final String DEFAULT_LOG_MESSAGE_SN_ASSINANTE_SERVICE = "SnAssinanteServiceImpl";
	public static final String DEFAULT_LOG_MESSAGE_SN_CIDADE_OPERADORA_SERVICE = "SnCidadeOperadora";
	public static final String DEFAULT_LOG_MESSAGE_SN_CONTRATO_SERVICE = "SnContratoServiceImpl";
	public static final String DEFAULT_LOG_MESSAGE_SN_CONTRATO_SERVICE_IMPL = "SnContratoServiceImpl";
	public static final String DEFAULT_LOG_MESSAGE_SN_ESCOLARIDADE_SERVICE = "SnEscolaridadeServiceImpl";
	public static final String DEFAULT_LOG_MESSAGE_SN_ESTADO_CIVIL_SERVICE = "SnEstadoCivilServiceImpl";
	public static final String DEFAULT_LOG_MESSAGE_SN_ORGAO_EXPEDIDOR_SERVICE = "SnOrgaoExpedidorServiceImpl";
	public static final String DEFAULT_LOG_MESSAGE_SN_PROFISSAO_SERVICE = "SnProfissaoServiceImpl";
	public static final String DEFAULT_LOG_MESSAGE_SN_RAZAO_CANCELAMENTO_SERVICE = "SnRazaoCancelamentoServiceImpl";
	public static final String DEFAULT_LOG_MESSAGE_SN_REL_ASSINANTE_SEGMENTACAO_SERVICE = "SnRelAssinanteSegmentacaoServiceImpl";
	public static final String DEFAULT_LOG_MESSAGE_SN_REL_STATUS_CONTRATO_SERVICE = "SnRelStatusContratoServiceImpl";
	public static final String DEFAULT_LOG_MESSAGE_SN_SEXO_SERVICE = "SnSexoServiceImpl";
	public static final String DEFAULT_LOG_MESSAGE_SN_STATUS_CONTRATO_SERVICE = "SnStatusContratoServiceImpl";
	public static final String DEFAULT_LOG_MESSAGE_SN_TELEFONE_VOIP_SERVICE = "SnTelefoneVoipServiceImpl";
	public static final String DEFAULT_LOG_MESSAGE_SN_TIPO_CONTRATO_SERVICE = "SnTipoContratoServiceImpl";
	public static final String DEFAULT_LOG_MESSAGE_SN_TIPO_SEGMENTO_SERVICE = "SnTipoSegmentoServiceImpl";
	public static final String DEFAULT_LOG_MESSAGE_SN_TIPO_VENDA_SERVICE = "SnTipoVendaServiceImpl";
	public static final String DEFAULT_LOG_MESSAGE_VSN_VENDEDORES_SERVICE = "VsnVendedoresServiceImpl";

	public static final String DEFAULT_LOG_MESSAGE_FIND_CONTRATO_BY_CUSTOMER_ACCOUNT_ID_AND_CITY_ID = "findContratoByCustomerAccountIdAndCityId";

	public static final String MESSAGE_END_OBTAIN_CUSTOMER_PROCESS = "End contract/customer process";
	public static final String MESSAGE_END_UTILS_PROCESS = "End contract/utils process";
	public static final String MESSAGE_ENTRY_REQUEST_DEFAULT = "Request Entry: ";
	public static final String MESSAGE_FIND_BY_CITY_CODE = "Find by City Code: ";
	public static final String MESSAGE_FIND_BY_CONTRACT = "Find by contract: ";
	public static final String MESSAGE_FIND_BY_INTERACTION_ID = "Find by Interaction ID: ";
	public static final String MESSAGE_FIND_BY_MAC_ADDRESS = "Find by Mac Address: ";
	public static final String MESSAGE_FIND_BY_OPERATOR_CODE = "Find by Operator Code: ";
	public static final String MESSAGE_FIND_BY_SMARTCARD = "Find by SmartCard: ";
	public static final String MESSAGE_FIND_CITY_BY_OPERATOR = "Find City by Operator";
	public static final String MESSAGE_FIND_CONTACT = "Find contact.";
	public static final String MESSAGE_FIND_CUSTOMER = "Find Customer.";
	public static final String MESSAGE_FIND_DISPATCHIN_AGENCY = "Find Dispatching Agency";
	public static final String MESSAGE_FIND_EDUCATION_DEGREE = "Find Education Degree";
	public static final String MESSAGE_FIND_NETPHONE = "Find NetPhone.";
	public static final String MESSAGE_FIND_OPERATOR_BY_CITY = "Find Operator by City";
	public static final String MESSAGE_FIND_TYPE = "Find Type.";
	public static final String MESSAGE_REQUEST_DEFAULT = "Request: ";
	public static final String MESSAGE_RESPONSE_DEFAULT = "Response: ";
	public static final String MESSAGE_START_OBTAIN_CUSTOMER_PROCESS = "Start contract/customer process";
	public static final String MESSAGE_START_UTILS_PROCESS = "Start contract/utils process";
	public static final String MESSAGE_UTILITY_CLASS = "Utility class";
	public static final String MESSAGE_VALIDATE_INTERACTION_ID = "Validating interactionId";

	public static final String ERROR_CONTRACT_UTILS_NOT_FOUND = "Resource not found.";
	public static final String ERROR_MESSAGE_AREA_CODE = "Area Code format is invalid. Only numbers is valid";
	public static final String ERROR_MESSAGE_CB_EQUIPAMENT_NOT_LINKED_CUSTOMER = "Unhandled Circuit Breaker Exception by: ";
	public static final String ERROR_MESSAGE_CITY_CODE_LENGTH_INVALID = "City code must be contains 5 numbers. City code length is invalid: ";
	public static final String ERROR_MESSAGE_CITY_CODE_NOT_FOUND_BY_OPERATOR_CODE = "City code not found for Operator Code.";
	public static final String ERROR_MESSAGE_CITY_CODE_VALID = "City code format is invalid. Only numbers is valid";
	public static final String ERROR_MESSAGE_CONTRACT_CITY_CODE_REQUIRED = "Contract Number and City Code must be entered.";
	public static final String ERROR_MESSAGE_CONTRACT_NOT_FOUND = "Contract not found";
	public static final String ERROR_MESSAGE_CONTRACT_NOT_FOUND_INPUT_PARAMETER = "Contract not found for input parameter.";
	public static final String ERROR_MESSAGE_CONTRACT_NUMBER_MISSING_PARAMETER = "For requests that uses Customer Account, it is necessary to enter the City Id or Operator Code. It is mandatory to fill only one of the two fields informed.";
	public static final String ERROR_MESSAGE_COSTUMER_NOT_FOUND = "Customer not found";
	public static final String ERROR_MESSAGE_DOCUMENT_NUMBER = "Document Number format is invalid. Only numbers is valid";
	public static final String ERROR_MESSAGE_EQUIPAMENT_NOT_LINKED_CUSTOMER = "Equipment is not linked to a customer.";
	public static final String ERROR_MESSAGE_ERROR_DEFAULT = "Error During Process";
	public static final String ERROR_MESSAGE_FIND_SN_CONTRATO = "snContrato not found";
	public static final String ERROR_MESSAGE_FORMAT_INVALID = "Format data field informed is no valid. Only numbers are valid. Please check the documentation out to know the correct way to fill in the fields.";
	public static final String ERROR_MESSAGE_INTERACTION_ID_INVALID = "Interaction Id format is invalid: ";
	public static final String ERROR_MESSAGE_INTERACTION_ID_LENGTH_INVALID = "Interaction Id length is invalid: ";
	public static final String ERROR_MESSAGE_MANDATORY_CITY_OR_OPERATOR_CODE = "City Code or Operator code is mandatory with Contract entity";
	public static final String ERROR_MESSAGE_MULTITHREADING_WITH_PARAMETER = "Error multithreading: {} ";
	public static final String ERROR_MESSAGE_OPERATOR_CODE_NOT_FOUND_BY_CITY_CODE = "Operator Code not found for City code.";
	public static final String ERROR_MESSAGE_OPERATOR_CODE_VALID = "Operator code format is invalid. Only numbers is valid";
	public static final String ERROR_MESSAGE_PARAMETERS_CONTRACTS_PROSPECT = "Required some parameters are not found: Smart Card Number, Customer Account Id, Protocol Number, Addressable Code, Document Id or Telephone (areaCode + phoneNumber). It is mandatory to fill only one of the six fields informed.";
	public static final String ERROR_MESSAGE_PHONE_NUMBER = "Phone Number format is invalid. Only numbers is valid";
	public static final String ERROR_MESSAGE_PREFIX_SERVICE = "API-CONTRACTSADDRESSES-";
	public static final String ERROR_MESSAGE_VALIDATE_ADDRESSABLE_CODE = "Addressable Code format is invalid.";
	public static final String ERROR_MESSAGE_VALIDATE_SMARTCARD_NUMBER = "Smartcard Number format is invalid. Only numbers is valid";
	public static final String ERROR_MIDDLE_DEFAULT = " With message: ";
	public static final String ERROR_RESOURCE_NOT_FOUND = "Resource not found.";
	public static final String ERROR_STARTS_DEFAULT = "Error by: ";
	public static final String ERROR_UNHANDLED_CB_EXCEPTION = "Unhandled Circuit Breaker Exception";
	public static final String ERROR_UNHANDLED_CB_EXCEPTION_BY = "Unhandled Circuit Breaker Exception by: ";
	public static final String ERROR_UNHANDLED_EXCEPTION = "Unhandled Exception by: ";
	public static final String HEADER_KEY_ADDRESSABLE_CODE = "addressableCode";
	public static final String HEADER_KEY_ALIAS_DATABASE = "aliasDatabase";
	public static final String HEADER_KEY_AREA_CODE = "areaCode";
	public static final String HEADER_KEY_CITY_CODE = "cityId";
	public static final String HEADER_KEY_CITY_ID = "cityId";
	public static final String HEADER_KEY_CUSTOMER_ACCOUNT_ID = "customerAccountId";
	public static final String HEADER_KEY_IDENTIFICATION_ID = "identificationId";
	public static final String HEADER_KEY_OPERATOR_CODE = "operatorCode";
	public static final String HEADER_KEY_PHONE_NUMBER = "phoneNumber";
	public static final String HEADER_KEY_PROTOCOL_NUMBER = "protocolNumber";
	public static final String HEADER_KEY_SMARTCARD = "smartCardNumber";

	public static final String DEFAULT_BLANK_VALUE = " ";
	public static final String DEFAULT_BOOLEAN_VALUE_FALSE = "false";
	public static final String DEFAULT_COMPANY_DOCUMENT_TYPE = "CNPJ";
	public static final String DEFAULT_LOCAL_NAME_ASSINANTE = "ASSINANTE";
	public static final String DEFAULT_SOA_PARAM_CUSTOMER = "CONV_SOA_CUSTOMER";

	public static final String DEFAULT_DOCUMENT_TYPE_FISICA = "CPF";
	public static final String DEFAULT_DOCUMENT_TYPE_JURIDICA = "CNPJ";
	public static final String DEFAULT_PASSAPORTE = "PASSAPORTE";
	public static final String DEFAULT_PERSON_TYPE_FISICA = "FISICA";
	public static final String DEFAULT_PERSON_TYPE_JURIDICA = "JURIDICA";
	public static final String DEFAULT_RG = "RG";
	public static final String DEFAULT_INSCRICAO_ESTADUAL = "INSCRICAO_ESTADUAL";
	public static final Date DEFAULT_DATA_FIM = Date.valueOf("2049-12-30");

	public static final String DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_CREATE_CONTRACT = "createContract";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_CUSTOMER_PROSPECT = "customerProspect";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_GET_CUSTOMER_PROSPECT_DATA_BY_AREA_CODE_AND_PHONE_NUMBER = "getCustomerProspectDataByAreaCodeAndPhoneNumber";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_GET_CUSTOMER_PROSPECT_DATA_BY_CONTRACT_IDENTIFICATION = "getCustomerProspectDataByContractIdentification";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_CUSTOMER_PROSPECT_SERVICE_REQUEST_CONTRACT_IDENTIFICATION = "requestContractIdentification";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_ASSINANTE_SERVICE_METHOD_FIND_CONTRATO_BY_CUSTOMER_ACCOUNT_ID_AND_CITY_ID = "findContratoByCustomerAccountIdAndCityId";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_ESCOLARIDADE_SERVICE_SERVICE_METHOD_FIND_ESCOLARIDADE = "findEscolaridade";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_ORGAO_EXPEDIDOR_SERVICE_SERVICE_METHOD_FIND_ORGAO_EXPEDIDOR = "findOrgaoExpedidor";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_SEXO_SERVICE_SERVICE_METHOD_FIND_SEXO = "findSexo";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_SN_SN_ESTADO_CIVIL_SERVICE_SERVICE_METHOD_FIND_ESTADO_CIVIL = "findEstadoCivil";
	public static final String DEFAULT_LOG_MESSAGE_CLASS_TELEFONE_VOIP_SERVICE_SERVICE_METHOD_FIND_TELEPHONES = "findTelephones";
	public static final String EMAIL_TYPE = "";
	public static final String HARDFORNE = "HardFone";

    private ContractProspectServiceConstansts() {
		throw new IllegalStateException(MESSAGE_UTILITY_CLASS);
	}
}
