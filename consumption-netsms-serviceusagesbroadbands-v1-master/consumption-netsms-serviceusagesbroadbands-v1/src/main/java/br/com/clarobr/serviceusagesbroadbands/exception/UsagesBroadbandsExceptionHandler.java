package br.com.clarobr.serviceusagesbroadbands.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.MethodNotAllowedException;

import javax.naming.ServiceUnavailableException;


@ControllerAdvice
public class UsagesBroadbandsExceptionHandler {

	private static final String ERROR_API_CODE = "API-SERVICEUSAGESBROADBANDS-";

	private static final String API_DOCS_URL = "https://api.claro.com.br/docs";

	private static final String RELATED = "related";

	public UsagesBroadbandsExceptionHandler() {
		// TODO document why this constructor is empty
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorInfoWrapper> errorBadRequest(BadRequestException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.BAD_REQUEST;
		String errorCode = ERROR_API_CODE + httpCode.value();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				e.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<ErrorInfoWrapper> unauthorized(UnauthorizedException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.UNAUTHORIZED;
		String errorCode = ERROR_API_CODE + httpCode.value();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				e.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(ForbiddenException.class)
	public ResponseEntity<ErrorInfoWrapper> forbidden(ForbiddenException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.FORBIDDEN;
		String errorCode = ERROR_API_CODE + httpCode.value();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				e.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorInfoWrapper> resourceNotFound(NotFoundException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.NOT_FOUND;
		String errorCode = ERROR_API_CODE + httpCode.value();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				e.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(MethodNotAllowedException.class)
	public ResponseEntity<ErrorInfoWrapper> methodNotAllowed(MethodNotAllowedException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.METHOD_NOT_ALLOWED;
		String errorCode = ERROR_API_CODE + httpCode.value();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				e.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(NotAcceptableException.class)
	public ResponseEntity<ErrorInfoWrapper> notAcceptable(NotAcceptableException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.NOT_ACCEPTABLE;
		String errorCode = ERROR_API_CODE + httpCode.value();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				e.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(ConflictException.class)
	public ResponseEntity<ErrorInfoWrapper> conflict(ConflictException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.CONFLICT;
		String errorCode = ERROR_API_CODE + httpCode.value();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				e.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(GoneException.class)
	public ResponseEntity<ErrorInfoWrapper> gone(GoneException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.GONE;
		String errorCode = ERROR_API_CODE + httpCode.value();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				e.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(UnsupportedMediaTypeException.class)
	public ResponseEntity<ErrorInfoWrapper> unsupportedMediaType(UnsupportedMediaTypeException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
		String errorCode = ERROR_API_CODE + httpCode.value();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				e.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<ErrorInfoWrapper> unsupportedHttpMediaType(HttpMediaTypeNotSupportedException ex, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
		String errorCode = ERROR_API_CODE + httpCode.value();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				ex.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(UnprocessableEntityException.class)
	public ResponseEntity<ErrorInfoWrapper> unprocessableEntity(UnprocessableEntityException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.UNPROCESSABLE_ENTITY;
		String errorCode = e.getErrorCode();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				e.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}


	@ExceptionHandler(TooManyRequestsException.class)
	public ResponseEntity<ErrorInfoWrapper> tooManyRequests(TooManyRequestsException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.TOO_MANY_REQUESTS;
		String errorCode = ERROR_API_CODE + httpCode.value();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				e.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(UnavailableForLegalReasonsException.class)
	public ResponseEntity<ErrorInfoWrapper> unavailableForLegalReasons(UnavailableForLegalReasonsException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS;
		String errorCode = ERROR_API_CODE + httpCode.value();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				e.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(InternalServerErrorException.class)
	public ResponseEntity<ErrorInfoWrapper> internalServerError(InternalServerErrorException ex, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.INTERNAL_SERVER_ERROR;
		String errorCode = ERROR_API_CODE + httpCode.value();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				ex.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(ServiceUnavailableException.class)
	public ResponseEntity<ErrorInfoWrapper> serviceUnavailable(ServiceUnavailableException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.SERVICE_UNAVAILABLE;
		String errorCode = ERROR_API_CODE + httpCode.value();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				e.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<ErrorInfoWrapper> database(DatabaseException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.BAD_REQUEST;
		String errorCode = ERROR_API_CODE + httpCode.value();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				e.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfoWrapper> validationExceptionHandler(final MethodArgumentNotValidException manvex,
			final HttpServletRequest request) {
		final HttpStatus httpCode = HttpStatus.BAD_REQUEST;
		String errorCode = ERROR_API_CODE + httpCode.value();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				manvex.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorInfoWrapper> validationExceptionHandler(final ConstraintViolationException cvex, HttpServletRequest request) {
		final HttpStatus httpCode = HttpStatus.BAD_REQUEST;
		String errorCode = ERROR_API_CODE + httpCode.value();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				cvex.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorInfoWrapper> typeMismatchException(final MethodArgumentTypeMismatchException ex, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.BAD_REQUEST;
		String errorCode = ERROR_API_CODE + httpCode.value();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				ex.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorInfoWrapper> httpMessageNotReadableException(final HttpMessageNotReadableException ex, HttpServletRequest request) {
		final HttpStatus httpCode = HttpStatus.BAD_REQUEST;
		String errorCode = ERROR_API_CODE + httpCode.value();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				ex.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<ErrorInfoWrapper> httpClientErrorException(final HttpClientErrorException ex, HttpServletRequest request) {
		final HttpStatus httpCode = HttpStatus.BAD_REQUEST;
		String errorCode = ERROR_API_CODE + httpCode.value();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				ex.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ErrorInfoWrapper> missingRequestParamException(final MissingServletRequestParameterException ex,
			HttpServletRequest request) {
		final HttpStatus httpCode = HttpStatus.BAD_REQUEST;
		String errorCode = ERROR_API_CODE + httpCode.value();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				ex.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ErrorInfoWrapper> requestMethodNotSupportedException(final HttpRequestMethodNotSupportedException ex,
			HttpServletRequest request) {
		final HttpStatus httpCode = HttpStatus.METHOD_NOT_ALLOWED;
		String errorCode = ERROR_API_CODE + httpCode.value();

		var link = Link.builder()
				.rel(RELATED)
				.href(API_DOCS_URL)
				.build();

		var errorInfo = new ErrorInfo(
				httpCode.value(),
				errorCode,
				httpCode.getReasonPhrase(),
				ex.getMessage(),
				link
		);

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

}