package br.com.clarobr.contractprospectservice.util;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.BadRequestException;
import br.com.clarobr.contractprospectservice.models.input.ContractProspectInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;

@Slf4j
@SuppressWarnings("all")
public abstract class ValidateUtils {

	private ValidateUtils() {
		throw new IllegalStateException(ContractProspectServiceConstansts.MESSAGE_UTILITY_CLASS);
	}

	public static ContractProspectInput valideContractProspectInput(HttpHeaders httpHeaders) throws BadRequestException {
		var contractProspectInput = new ContractProspectInput();
		contractProspectInput.setSmartCardNumber(httpHeaders.getFirst(ContractProspectServiceConstansts.HEADER_KEY_SMARTCARD));
		contractProspectInput.setCustomerAccountId(httpHeaders.getFirst(ContractProspectServiceConstansts.HEADER_KEY_CUSTOMER_ACCOUNT_ID));
		contractProspectInput.setOperatorCode(httpHeaders.getFirst(ContractProspectServiceConstansts.HEADER_KEY_OPERATOR_CODE));
		contractProspectInput.setCityId(httpHeaders.getFirst(ContractProspectServiceConstansts.HEADER_KEY_CITY_ID));
		contractProspectInput.setProtocolNumber(httpHeaders.getFirst(ContractProspectServiceConstansts.HEADER_KEY_PROTOCOL_NUMBER));
		contractProspectInput.setAddressableCode(httpHeaders.getFirst(ContractProspectServiceConstansts.HEADER_KEY_ADDRESSABLE_CODE));
		contractProspectInput.setDocumentId(httpHeaders.getFirst(ContractProspectServiceConstansts.HEADER_KEY_IDENTIFICATION_ID));
		contractProspectInput.setAreaCode(httpHeaders.getFirst(ContractProspectServiceConstansts.HEADER_KEY_AREA_CODE));
		contractProspectInput.setPhoneNumber(httpHeaders.getFirst(ContractProspectServiceConstansts.HEADER_KEY_PHONE_NUMBER));

		if((StringUtils.isNull(contractProspectInput.getSmartCardNumber()) || StringUtils.isBlank(contractProspectInput.getSmartCardNumber())) &&
				(StringUtils.isNull(contractProspectInput.getCustomerAccountId()) || contractProspectInput.getCustomerAccountId().equals(0)) &&
				(StringUtils.isNull(contractProspectInput.getProtocolNumber()) || StringUtils.isBlank(contractProspectInput.getProtocolNumber())) &&
				(StringUtils.isNull(contractProspectInput.getAddressableCode()) || StringUtils.isBlank(contractProspectInput.getAddressableCode())) &&
				(StringUtils.isNull(contractProspectInput.getDocumentId()) || StringUtils.isNull(contractProspectInput.getDocumentId())) &&
				(StringUtils.isNull(contractProspectInput.getAreaCode()) || StringUtils.isNull(contractProspectInput.getAreaCode())) &&
				(StringUtils.isNull(contractProspectInput.getPhoneNumber()) || StringUtils.isNull(contractProspectInput.getPhoneNumber()))
		){
			log.error(ContractProspectServiceConstansts.ERROR_MESSAGE_PARAMETERS_CONTRACTS_PROSPECT, ContractProspectServiceConstansts.CODE_PARAMS_NOT_FOUND);
			throw new BadRequestException(ContractProspectServiceConstansts.ERROR_MESSAGE_PARAMETERS_CONTRACTS_PROSPECT, ContractProspectServiceConstansts.CODE_PARAMS_NOT_FOUND);
		}
		else if(!StringUtils.isNull(contractProspectInput.getCustomerAccountId()) && (StringUtils.isNull(contractProspectInput.getCityId())) &&
				!StringUtils.isNull(contractProspectInput.getCustomerAccountId()) && (StringUtils.isNull(contractProspectInput.getOperatorCode()))) {
			log.error(ContractProspectServiceConstansts.ERROR_MESSAGE_CONTRACT_NUMBER_MISSING_PARAMETER, ContractProspectServiceConstansts.CODE_INVALID_REQUEST);
			throw new BadRequestException(ContractProspectServiceConstansts.ERROR_MESSAGE_CONTRACT_NUMBER_MISSING_PARAMETER, ContractProspectServiceConstansts.CODE_INVALID_REQUEST);
		}
		else if(
				(!StringUtils.isNull(contractProspectInput.getCustomerAccountId())) &&
				((contractProspectInput.getCustomerAccountId() == "0") ||
						(contractProspectInput.getCustomerAccountId().length() < 0)) ||
				(!StringUtils.isBlank(contractProspectInput.getCustomerAccountId())) &&
				(!StringUtils.hasOnlyNumbers(contractProspectInput.getCustomerAccountId()))
		) {
			log.error(ContractProspectServiceConstansts.ERROR_MESSAGE_FORMAT_INVALID, ContractProspectServiceConstansts.CODE_INVALID_FORMAT);
			throw new BadRequestException(ContractProspectServiceConstansts.ERROR_MESSAGE_FORMAT_INVALID, ContractProspectServiceConstansts.CODE_INVALID_FORMAT);
		}
		else if((!StringUtils.isNull(contractProspectInput.getCityId())) &&
				(!StringUtils.isBlank(contractProspectInput.getCityId())) &&
				(!StringUtils.hasOnlyNumbers(contractProspectInput.getCityId().toString()))) {
			log.error(ContractProspectServiceConstansts.ERROR_MESSAGE_FORMAT_INVALID, ContractProspectServiceConstansts.CODE_INVALID_FORMAT);
			throw new BadRequestException(ContractProspectServiceConstansts.ERROR_MESSAGE_FORMAT_INVALID, ContractProspectServiceConstansts.CODE_INVALID_FORMAT);
		}
		else if((!StringUtils.isNull(contractProspectInput.getOperatorCode())) &&
				(!StringUtils.isBlank(contractProspectInput.getOperatorCode())) &&
				(!StringUtils.hasOnlyNumbers(contractProspectInput.getOperatorCode().toString()))) {
			log.error(ContractProspectServiceConstansts.ERROR_MESSAGE_FORMAT_INVALID, ContractProspectServiceConstansts.CODE_INVALID_FORMAT);
			throw new BadRequestException(ContractProspectServiceConstansts.ERROR_MESSAGE_FORMAT_INVALID, ContractProspectServiceConstansts.CODE_INVALID_FORMAT);
		}
		else if((!StringUtils.isNull(contractProspectInput.getProtocolNumber())) &&
				(!StringUtils.isBlank(contractProspectInput.getProtocolNumber())) &&
				(!StringUtils.hasOnlyNumbers(contractProspectInput.getProtocolNumber()))){
			log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
					  ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_VALIDATE_UTILS_METHOD_VALIDE_CONTRACT_PROSPECT_INPUT,
					  ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_VALIDATE_UTILS_METHOD_VALIDATE_INTERACTION_ID,
					  contractProspectInput.getProtocolNumber());
			validateInteractionId(contractProspectInput.getProtocolNumber());
		}
		else if((!StringUtils.isNull(contractProspectInput.getDocumentId())) &&
				(!StringUtils.isBlank(contractProspectInput.getDocumentId())) &&
				(!StringUtils.hasOnlyNumbers(contractProspectInput.getDocumentId()))) {
			log.error(ContractProspectServiceConstansts.ERROR_MESSAGE_FORMAT_INVALID, ContractProspectServiceConstansts.CODE_INVALID_FORMAT);
			throw new BadRequestException(ContractProspectServiceConstansts.ERROR_MESSAGE_FORMAT_INVALID, ContractProspectServiceConstansts.CODE_INVALID_FORMAT);
		}
		else if(!StringUtils.isNull(contractProspectInput.getAreaCode()) && !StringUtils.isBlank(contractProspectInput.getAreaCode()) &&
				StringUtils.isNull(contractProspectInput.getPhoneNumber()) && StringUtils.isBlank(contractProspectInput.getPhoneNumber())) {

			log.error(ContractProspectServiceConstansts.ERROR_MESSAGE_PARAMETERS_CONTRACTS_PROSPECT, ContractProspectServiceConstansts.CODE_PARAMS_NOT_FOUND);
			throw new BadRequestException(ContractProspectServiceConstansts.ERROR_MESSAGE_PARAMETERS_CONTRACTS_PROSPECT, ContractProspectServiceConstansts.CODE_PARAMS_NOT_FOUND);

		}
		else if(!StringUtils.isNull(contractProspectInput.getPhoneNumber()) && !StringUtils.isBlank(contractProspectInput.getPhoneNumber()) &&
			     StringUtils.isNull(contractProspectInput.getAreaCode()) && StringUtils.isBlank(contractProspectInput.getAreaCode()))
		{
				log.error(ContractProspectServiceConstansts.ERROR_MESSAGE_PARAMETERS_CONTRACTS_PROSPECT, ContractProspectServiceConstansts.CODE_PARAMS_NOT_FOUND);
				throw new BadRequestException(ContractProspectServiceConstansts.ERROR_MESSAGE_PARAMETERS_CONTRACTS_PROSPECT, ContractProspectServiceConstansts.CODE_PARAMS_NOT_FOUND);
		}
		else if((!StringUtils.isNull(contractProspectInput.getAreaCode()) && (!StringUtils.isBlank(contractProspectInput.getAreaCode()))) &&
				(!StringUtils.isNull(contractProspectInput.getPhoneNumber()) && (!StringUtils.isBlank(contractProspectInput.getPhoneNumber())))
		) {
			if(!StringUtils.hasOnlyNumbers(contractProspectInput.getAreaCode())){
				log.error(ContractProspectServiceConstansts.ERROR_MESSAGE_FORMAT_INVALID, ContractProspectServiceConstansts.CODE_INVALID_FORMAT);
				throw new BadRequestException(ContractProspectServiceConstansts.ERROR_MESSAGE_FORMAT_INVALID, ContractProspectServiceConstansts.CODE_INVALID_FORMAT);
			}
			if(!StringUtils.hasOnlyNumbers(contractProspectInput.getPhoneNumber())){
				log.error(ContractProspectServiceConstansts.ERROR_MESSAGE_FORMAT_INVALID, ContractProspectServiceConstansts.CODE_INVALID_FORMAT);
				throw new BadRequestException(ContractProspectServiceConstansts.ERROR_MESSAGE_FORMAT_INVALID, ContractProspectServiceConstansts.CODE_INVALID_FORMAT);
			}
		}

		return contractProspectInput;
	}
	public static void validateInteractionId(String protocolNumber) throws BadRequestException {

		if(!StringUtils.hasOnlyNumbers(protocolNumber)) {
			log.error(ContractProspectServiceConstansts.ERROR_MESSAGE_FORMAT_INVALID, ContractProspectServiceConstansts.CODE_INVALID_FORMAT);
			throw new BadRequestException(ContractProspectServiceConstansts.ERROR_MESSAGE_FORMAT_INVALID, ContractProspectServiceConstansts.CODE_INVALID_FORMAT);
		}
		else if(protocolNumber.length() != ContractProspectServiceConstansts.DEFAULT_INTERACTION_ID_LENGTH) {
			log.error(ContractProspectServiceConstansts.ERROR_MESSAGE_FORMAT_INVALID, ContractProspectServiceConstansts.CODE_INVALID_FORMAT);
			throw new BadRequestException(ContractProspectServiceConstansts.ERROR_MESSAGE_FORMAT_INVALID, ContractProspectServiceConstansts.CODE_INVALID_FORMAT);
		}
	}
}
