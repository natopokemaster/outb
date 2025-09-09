package br.com.clarobr.contractprospectservice.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;

@ControllerAdvice
public class ResourceExceptionHandler {

	private static final String ERROR_API_CODE = "API-CUSTOMERSPROSPECTS-";
	private String now;

	public ResourceExceptionHandler() {
		final var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
		this.now = formatter.format(LocalDateTime.now());
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorInfoWrapper> errorBadRequest(BadRequestException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.BAD_REQUEST;
		String errorCode = ERROR_API_CODE
				+ (!e.getParameterName().isEmpty() ? e.getParameterName() : String.valueOf(httpCode.value()));
		var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(),
				e.getMessage(),
				request.getRequestURI());
		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);
		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<ErrorInfoWrapper> unauthorized(UnauthorizedException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.UNAUTHORIZED;
		String errorCode = ERROR_API_CODE + httpCode.value();
		var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(),
				e.getMessage(),
				request.getRequestURI());
		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);
		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(ForbiddenException.class)
	public ResponseEntity<ErrorInfoWrapper> forbidden(ForbiddenException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.FORBIDDEN;
		String errorCode = ERROR_API_CODE + httpCode.value();
		var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(),
				e.getMessage(),
				request.getRequestURI());
		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);
		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorInfoWrapper> resourceNotFound(NotFoundException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.NOT_FOUND;
		String errorCode = ERROR_API_CODE
				+ (!e.getParameterName().isEmpty() ? e.getParameterName() : String.valueOf(httpCode.value()));
		var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(),
				e.getMessage(),
				request.getRequestURI());
		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);
		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(MethodNotAllowedException.class)
	public ResponseEntity<ErrorInfoWrapper> methodNotAllowed(MethodNotAllowedException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.METHOD_NOT_ALLOWED;
		String errorCode = ERROR_API_CODE + httpCode.value();
		var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(),
				e.getMessage(),
				request.getRequestURI());
		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);
		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(NotAcceptableException.class)
	public ResponseEntity<ErrorInfoWrapper> notAcceptable(NotAcceptableException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.NOT_ACCEPTABLE;
		String errorCode = ERROR_API_CODE + httpCode.value();
		var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(),
				e.getMessage(),
				request.getRequestURI());
		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);
		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(ConflictException.class)
	public ResponseEntity<ErrorInfoWrapper> conflict(ConflictException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.CONFLICT;
		String errorCode = ERROR_API_CODE + httpCode.value();
		var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(),
				e.getMessage(),
				request.getRequestURI());
		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);
		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(GoneException.class)
	public ResponseEntity<ErrorInfoWrapper> gone(GoneException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.GONE;
		String errorCode = ERROR_API_CODE + httpCode.value();
		var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(),
				e.getMessage(),
				request.getRequestURI());
		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);
		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(UnsupportedMediaTypeException.class)
	public ResponseEntity<ErrorInfoWrapper> unsupportedMediaType(UnsupportedMediaTypeException e,
			HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
		String errorCode = ERROR_API_CODE + httpCode.value();
		var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(),
				e.getMessage(),
				request.getRequestURI());
		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);
		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<ErrorInfoWrapper> unsupportedHttpMediaType(HttpMediaTypeNotSupportedException ex,
			HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
		String errorCode = ERROR_API_CODE + httpCode.value();
		var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(),
				ex.getMessage(),
				request.getRequestURI());
		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);
		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(UnprocessableEntityException.class)
	public ResponseEntity<ErrorInfoWrapper> unprocessableEntity(UnprocessableEntityException e,
			HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.UNPROCESSABLE_ENTITY;
		String errorCode = ERROR_API_CODE
				+ (!e.getParameterName().isEmpty() ? e.getParameterName() : String.valueOf(httpCode.value()));
		var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(),
				e.getMessage(),
				request.getRequestURI());
		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);
		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(TooManyRequestsException.class)
	public ResponseEntity<ErrorInfoWrapper> tooManyRequests(TooManyRequestsException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.TOO_MANY_REQUESTS;
		String errorCode = ERROR_API_CODE + httpCode.value();
		var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(),
				e.getMessage(),
				request.getRequestURI());
		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);
		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(UnavailableForLegalReasonsException.class)
	public ResponseEntity<ErrorInfoWrapper> unavailableForLegalReasons(UnavailableForLegalReasonsException e,
			HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS;
		String errorCode = ERROR_API_CODE + httpCode.value();
		var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(),
				e.getMessage(),
				request.getRequestURI());
		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);
		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(InternalServerErrorException.class)
	public ResponseEntity<ErrorInfoWrapper> internalServerError(InternalServerErrorException ex,
			HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.INTERNAL_SERVER_ERROR;
		String errorCode = ERROR_API_CODE + httpCode.value();
		var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(),
				ex.getMessage(),
				request.getRequestURI());
		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);
		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(CircuitBreakerException.class)
	public ResponseEntity<ErrorInfoWrapper> circuitBreakerException(CircuitBreakerException ex,
			HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.SERVICE_UNAVAILABLE;
		String errorCode = ERROR_API_CODE + httpCode.value();
		var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(),
				ex.getMessage(),
				request.getRequestURI());
		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);
		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<ErrorInfoWrapper> database(DatabaseException e, HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.BAD_REQUEST;
		String errorCode = ERROR_API_CODE + httpCode.value();
		var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(),
				e.getMessage(),
				request.getRequestURI());
		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);
		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfoWrapper> validationExceptionHandler(final MethodArgumentNotValidException manvex,
			final HttpServletRequest request) {
		final HttpStatus httpCode = HttpStatus.BAD_REQUEST;
		final String errorCode = ERROR_API_CODE + httpCode.value();
		final var defaultMessage = new StringBuilder();

		manvex.getBindingResult().getFieldErrors()
				.forEach(error -> defaultMessage.append(error.getDefaultMessage()).append(" "));

		final var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(),
				defaultMessage.toString(), request.getRequestURI());
		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorInfoWrapper> validationExceptionHandler(final ConstraintViolationException cvex,
			HttpServletRequest request) {
		final var httpCode = HttpStatus.BAD_REQUEST;
		final String errorCode = ERROR_API_CODE + httpCode.value();
		final var defaultMessage = new StringBuilder();

		cvex.getConstraintViolations().forEach(cv -> defaultMessage.append(cv.getMessage()).append(" "));

		final var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(),
				defaultMessage.toString(), request.getRequestURI());

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorInfoWrapper> typeMismatchException(final MethodArgumentTypeMismatchException ex,
			HttpServletRequest request) {
		HttpStatus httpCode = HttpStatus.BAD_REQUEST;
		String errorCode = ERROR_API_CODE + httpCode.value();
		var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(),
				ex.getCause().getMessage(),
				request.getRequestURI());

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorInfoWrapper> httpMessageNotReadableException(final HttpMessageNotReadableException ex,
			HttpServletRequest request) {
		final HttpStatus httpCode = HttpStatus.BAD_REQUEST;
		final String errorCode = ERROR_API_CODE + httpCode.value();
		final String message = ex.getMostSpecificCause().getMessage();
		var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(), message,
				request.getRequestURI());

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<ErrorInfoWrapper> httpClientErrorException(final HttpClientErrorException ex,
			HttpServletRequest request)
			throws JsonProcessingException {
		final var httpCode = HttpStatus.BAD_REQUEST;
		final var errorCode = ERROR_API_CODE + httpCode.value();
		var message = "";
		final ObjectMapper mapper = new ObjectMapper().findAndRegisterModules()
				.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
		try {
			final ErrorInfoWrapper wrapper = mapper.readValue(ex.getResponseBodyAsString(), ErrorInfoWrapper.class);
			message = wrapper.getError().getDetailedMessage();
		} catch (JsonProcessingException ex1) {
			final var errorInfo = mapper.readValue(ex.getResponseBodyAsString(), ErrorInfo.class);
			message = errorInfo.getDetailedMessage();
		}
		final var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(),
				message,
				request.getRequestURI());

		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ErrorInfoWrapper> missingRequestParamException(final MissingServletRequestParameterException ex,
			HttpServletRequest request) {
		final HttpStatus httpCode = HttpStatus.BAD_REQUEST;
		final String errorCode = ERROR_API_CODE + httpCode.value();
		String message = ex.getMessage();
		var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(), message,
				request.getRequestURI());
		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ErrorInfoWrapper> requestMethodNotSupportedException(
			final HttpRequestMethodNotSupportedException ex,
			HttpServletRequest request) {
		final HttpStatus httpCode = HttpStatus.METHOD_NOT_ALLOWED;
		final String errorCode = ERROR_API_CODE + httpCode.value();
		String message = ex.getMessage();
		var errorInfo = new ErrorInfo(this.now, httpCode.value(), errorCode, httpCode.getReasonPhrase(), message,
				request.getRequestURI());
		var errorInfoWrapper = new ErrorInfoWrapper();
		errorInfoWrapper.setError(errorInfo);

		return ResponseEntity.status(httpCode).body(errorInfoWrapper);
	}

}