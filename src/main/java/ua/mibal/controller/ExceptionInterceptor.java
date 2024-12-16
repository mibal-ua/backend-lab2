package ua.mibal.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ua.mibal.controller.model.ConstraintViolationProblemDetails;
import ua.mibal.exception.BadRequestException;
import ua.mibal.exception.NotFoundException;

import static java.net.URI.create;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ProblemDetail.forStatusAndDetail;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Slf4j
@RestControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    ProblemDetail handle(BadRequestException e) {
        log.info("BadRequestException caught: " + e.getMessage());
        ProblemDetail problemDetail = forStatusAndDetail(BAD_REQUEST, e.getMessage());
        problemDetail.setType(create("bad-request"));
        problemDetail.setTitle(e.getMessage());
        return problemDetail;
    }
    
    @ExceptionHandler(NotFoundException.class)
    ProblemDetail handle(NotFoundException e) {
        log.info("Entity Not Found exception caught: " + e.getMessage());
        ProblemDetail problemDetail = forStatusAndDetail(NOT_FOUND, e.getMessage());
        problemDetail.setType(create("not-found"));
        problemDetail.setTitle(e.getMessage());
        return problemDetail;
    }
    
    @ExceptionHandler(Exception.class)
    ProblemDetail handle(Exception e) {
        log.error("Unknown exception caught: " + e.getMessage());
        ProblemDetail problemDetail = forStatusAndDetail(INTERNAL_SERVER_ERROR, e.getMessage());
        problemDetail.setTitle("Internal Server Error. Contact support");
        return problemDetail;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        log.info("Input params validation failed");
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(ConstraintViolationProblemDetails.of(e));
    }
}
