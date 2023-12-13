package br.com.ifomeadaf1rst.exception.advice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.ifomeadaf1rst.exception.EntidadeNaoEncontradaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.ifomeadaf1rst.dto.exception.ApiErrorDTO;
import br.com.ifomeadaf1rst.dto.exception.ApiSubErrorDTO;
import br.com.ifomeadaf1rst.dto.exception.ApiValidationErrorDTO;
import br.com.ifomeadaf1rst.dto.exception.ApiValidationErrorListDTO;
import br.com.ifomeadaf1rst.exception.BusinessException;
import jakarta.validation.UnexpectedTypeException;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<ApiErrorDTO> captureBusinessException(BusinessException e) {
		ApiErrorDTO apiError = new ApiErrorDTO();
	    apiError.setStatus(HttpStatus.BAD_REQUEST.value());
	    apiError.setMessage("Validation error");
	    apiError.setTimestamp(LocalDateTime.now());
	    apiError.setMessage(e.getMessage());
	    return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = EntidadeNaoEncontradaException.class)
	public ResponseEntity<String> captureRestauranteNotFoundException() {
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler({MethodArgumentNotValidException.class, UnexpectedTypeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> validationHandler(MethodArgumentNotValidException e) {
        ApiErrorDTO apiError = new ApiErrorDTO();
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());
        apiError.setMessage("Validation error");
        apiError.setTimestamp(LocalDateTime.now());

        List<ApiSubErrorDTO> subErrors = e.getBindingResult().getFieldErrors().stream().map(
        		error -> {
        			ApiValidationErrorDTO apiValidationError = new ApiValidationErrorDTO();
        			apiValidationError.setObject(error.getObjectName());
        			apiValidationError.setField(error.getField());
        			apiValidationError.setRejectedValue(error.getRejectedValue());
        			apiValidationError.setMessage(error.getDefaultMessage());
        			return apiValidationError;
        		}
        		).collect(Collectors.toList());

        ApiValidationErrorListDTO validationErrorList = new ApiValidationErrorListDTO();
        validationErrorList.setErrors(subErrors);

        apiError.setSubErrors(List.of(validationErrorList));

        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

}
