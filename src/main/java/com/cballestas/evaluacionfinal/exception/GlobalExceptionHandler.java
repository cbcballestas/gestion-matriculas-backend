package com.cballestas.evaluacionfinal.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ModelNotFoundException.class)
    public ProblemDetail handleModelNotFoundException(ModelNotFoundException exception) {
        ProblemDetail body = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), exception.getMessage());
        body.setTitle("Record Not Found");
        return body;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleAllExceptions(Exception exception) {
        ProblemDetail body = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(500), exception.getMessage());
        body.setTitle("Global Exception");
        return body;
    }

    @ExceptionHandler(SQLException.class)
    public ProblemDetail handleSQLException(SQLException exception, WebRequest req){
        ProblemDetail body = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(409), exception.getMessage());
        body.setTitle("SQL Exception");
        return body;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status,
                                                                  WebRequest request) {
        ProblemDetail body = ProblemDetail.forStatus(HttpStatusCode.valueOf(400));
        body.setTitle("Errors");

        // Se obtienen errores de los campos
        List<String> errors = ex.getBindingResult().getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();

        body.setProperty("errors", errors);

        return ResponseEntity.badRequest().body(body);
    }
}
