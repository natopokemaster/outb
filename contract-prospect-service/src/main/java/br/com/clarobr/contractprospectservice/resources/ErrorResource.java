package br.com.clarobr.contractprospectservice.resources;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clarobr.contractprospectservice.exception.BadRequestException;
import br.com.clarobr.contractprospectservice.exception.InternalServerErrorException;
import br.com.clarobr.contractprospectservice.exception.NotFoundException;
import br.com.clarobr.contractprospectservice.exception.UnauthorizedException;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;

@RestController
@RequestMapping("/error")
public class ErrorResource {

	private static final int BAD_REQUEST_STATUS = 400;
	private static final int UNAUTHORIZED_STATUS = 401;
	private static final int NOT_FOUND_STATUS = 404;
	/**
	 * Reservado para futura implementacao private static final int
	 * METHOD_NOT_ALLOWED_STATUS = 405; private static final int
	 * NOT_ACCEPTABLE_STATUS = 406;
	 */
	private static final int UNPROCESSABLE_ENTITY_STATUS = 422;

	@GetMapping
	@PostMapping
	@PutMapping
	@DeleteMapping
	@PatchMapping
	public void checkError(HttpServletResponse response) throws BadRequestException, UnauthorizedException,
			NotFoundException, UnprocessableEntityException, InternalServerErrorException {

		switch (response.getStatus()) {

			case BAD_REQUEST_STATUS:
				throw new BadRequestException(HttpStatus.BAD_REQUEST.getReasonPhrase());
			case UNAUTHORIZED_STATUS:
				throw new UnauthorizedException(HttpStatus.UNAUTHORIZED.getReasonPhrase());
			case NOT_FOUND_STATUS:
				throw new NotFoundException(HttpStatus.NOT_FOUND.getReasonPhrase());
			case UNPROCESSABLE_ENTITY_STATUS:
				throw new UnprocessableEntityException(HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
			default:
				throw new InternalServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		}
	}
}