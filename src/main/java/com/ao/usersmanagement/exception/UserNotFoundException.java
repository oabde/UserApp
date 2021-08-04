package com.ao.usersmanagement.exception;

public class UserNotFoundException extends UserRequestException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
