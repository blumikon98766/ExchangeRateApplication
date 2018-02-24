package pl.com.bottega.exchangerate.ui;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.com.bottega.exchangerate.domain.NoRateException;
import pl.com.bottega.exchangerate.domain.commands.CommandInvalidException;
import pl.com.bottega.exchangerate.domain.commands.Validatable;
import pl.com.bottega.exchangerate.infrastructure.NoSuchEntityException;

@ControllerAdvice
public class ErrorHandlers {

	private static final String APPLICATION_JSON = "application/json";

//	@ExceptionHandler(CommandInvalidException.class)
//	public ResponseEntity<Validatable.ValidationErrors> handleInvalidCommandException(CommandInvalidException ex) {
//		HttpHeaders headers = new HttpHeaders();
//		headers.set(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON);
//		return new ResponseEntity<>(
//				ex.getValidationErrors(),
//				headers,
//				HttpStatus.UNPROCESSABLE_ENTITY
//		);
//	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Entity with given id does not exist")
	@ExceptionHandler(NoSuchEntityException.class)
	public void handleEntityNotFound() {

	}

	@ExceptionHandler(CommandInvalidException.class)
	public ResponseEntity handleInvalidCommand(CommandInvalidException ex) {
		return new ResponseEntity(ex.getValidationErrors(), HttpStatus.UNPROCESSABLE_ENTITY);
	}





	@ExceptionHandler(NoRateException.class)
	public ResponseEntity<String> handleNoRateException() {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON);
		return new ResponseEntity<>(
				"{\"error\": \"no exchange rate defined\"}",
				headers,
				HttpStatus.UNPROCESSABLE_ENTITY
		);
	}

}
