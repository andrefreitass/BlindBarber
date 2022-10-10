package br.com.blinde.barberShop.external.exception;

import br.com.blinde.barberShop.businessrule.exception.entities.ExceptionResponse;
import br.com.blinde.barberShop.businessrule.messages.MessageSourceServiceImpl;
import br.com.blinde.barberShop.businessrule.messages.MessageTypeEnum;
import br.com.blinde.barberShop.businessrule.exception.NoSuchElementException;
import lombok.AllArgsConstructor;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.Objects;

@ControllerAdvice
@RestController
@AllArgsConstructor
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSourceServiceImpl message;

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(
            Exception ex, WebRequest request) {

        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .timestamp(new Date())
                .message(ex.getMessage())
                .details(request.getDescription(false))
                .build();

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public final ResponseEntity<ExceptionResponse> handleNoSuchElementException(
            NoSuchElementException ex, WebRequest request) {

        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .timestamp(new Date())
                .message(ex.getMessage())
                .details(request.getDescription(false))
                .build();

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatusCode status, WebRequest request) {

        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .timestamp(new Date())
                .message(message.getMessage(MessageTypeEnum.NOT_VALID.getMessage(), Objects.requireNonNull(ex.getBindingResult()
                        .getFieldError()).getField()))
                .details(request.getDescription(false))
                .build();

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
                                                                  HttpStatusCode status, WebRequest request) {

        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .timestamp(new Date())
                .message(message.getMessage(MessageTypeEnum.ERROR_PARSE.getMessage()))
                .details(request.getDescription(false))
                .build();

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .timestamp(new Date())
                .message(message.getMessage(MessageTypeEnum.ERROR_CONVERTER.getMessage()))
                .details(request.getDescription(false))
                .build();

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}