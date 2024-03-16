package io.github.junrdev.todoapp.util;

import io.github.junrdev.todoapp.util.exceptions.TodoNotFoundException;
import io.github.junrdev.todoapp.util.response.ErrorDev;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class ErrorAdvicer {

    @Value("${spring.development.env}")
    private String env;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<ErrorDev> resolveTodoNotFoundException(TodoNotFoundException ex) {

        if (env.equals("dev") || env.equals("development")) {
            var resp = ErrorDev.builder()
                    .code(HttpStatus.NOT_FOUND.value())
                    .message(ex.getMessage())
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                    .trace(ex.getStackTrace().toString())
                    .build();
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
        }

        var resp = ErrorDev.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .trace("")
                .build();

        return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);

    }
}
