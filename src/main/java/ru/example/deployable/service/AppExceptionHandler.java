package ru.example.deployable.service;

import org.springframework.beans.TypeMismatchException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.example.deployable.domain.AppError;
import ru.example.deployable.domain.RealmNotFoundException;
import java.util.stream.Collectors;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	                                                              HttpHeaders headers,
	                                                              HttpStatus status,
	                                                              WebRequest request) {
		String message = ex.getBindingResult()
			.getFieldErrors()
			.stream()
			.map(DefaultMessageSourceResolvable::getDefaultMessage)
			.collect(Collectors.joining());
		return ResponseEntity.badRequest()
			.body(new AppError().setCode(message));
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return ResponseEntity.badRequest()
				.body(new AppError().setCode("InvalidArgument"));
	}

	@ExceptionHandler(value = RealmNotFoundException.class)
	public ResponseEntity<AppError> onRealmNotFoundException(RealmNotFoundException exception) {
		return new ResponseEntity<>(
			new AppError().setCode(exception.getMessage()), HttpStatus.NOT_FOUND
		);
	}
}
