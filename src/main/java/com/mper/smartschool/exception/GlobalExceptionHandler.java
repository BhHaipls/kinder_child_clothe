package com.mper.smartschool.exception;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ApiError> handleEntityNotFoundException(NotFoundException ex, Locale locale) {
        Object[] args = {ex.getByWhat()};
        String errorMessage = messageSource.getMessage(ex.getMessage(), args, locale);

        ApiError apiError = ApiError.builder()
                .message(errorMessage)
                .status(HttpStatus.NOT_FOUND)
                .errors(Collections.singletonList(errorMessage))
                .build();
        log.error("Entity not found, thrown:", ex);
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        ApiError apiError = ApiError.builder()
                .message("Invalid arguments")
                .status(HttpStatus.BAD_REQUEST)
                .errors(errors)
                .build();
        log.error("Bad request. Errors: {}", errors);
        return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
        ApiError apiError = ApiError.builder()
                .message(ex.getLocalizedMessage())
                .status(HttpStatus.BAD_REQUEST)
                .errors(Collections.singletonList("error occurred"))
                .build();
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @Data
    @Builder
    public static class ApiError {
        private HttpStatus status;
        private String message;
        private List<String> errors;
    }
}
