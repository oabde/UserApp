package com.ao.usersmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value={UserRequestException.class})
    public ResponseEntity<Object> handleUserException(UserRequestException e){

        UserException userException = new UserException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(userException,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(value={UserNotFoundException.class})
    public ResponseEntity<Object> handleUserException(UserNotFoundException e){

        UserException userException = new UserException(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(userException,HttpStatus.NOT_FOUND);

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value={MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        List<UserException> listException = ex.getBindingResult().getAllErrors().stream().map(error -> {
            UserException userException = new UserException(
                    error.getDefaultMessage(),
                    HttpStatus.BAD_REQUEST,
                    ZonedDateTime.now(ZoneId.of("Z")));
            return userException;
        }).collect(Collectors.toList());

        return new ResponseEntity<>(listException,HttpStatus.BAD_REQUEST);
    }

}
