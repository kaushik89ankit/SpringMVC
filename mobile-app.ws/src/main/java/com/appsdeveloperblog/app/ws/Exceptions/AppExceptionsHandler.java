package com.appsdeveloperblog.app.ws.Exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.appsdeveloperblog.app.ws.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionsHandler {

	@ExceptionHandler(value = { UserServiceException.class })
	public ResponseEntity<Object> handleUuserServiceException(UserServiceException ex, WebRequest req) {

		ErrorMessage error = new ErrorMessage(new Date(), ex.getMessage());

		return new ResponseEntity<Object>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	public ResponseEntity<Object> handleInvalidRequestBody(Exception ex, WebRequest request) {

		ErrorMessage error = new ErrorMessage(new Date(), ex.getMessage());

		return new ResponseEntity<Object>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleGenericExceptions(Exception ex, WebRequest request) {

		ErrorMessage error = new ErrorMessage(new Date(), ex.getMessage());

		return new ResponseEntity<Object>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

}
