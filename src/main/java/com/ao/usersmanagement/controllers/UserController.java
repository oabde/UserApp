package com.ao.usersmanagement.controllers;

import com.ao.usersmanagement.dto.UserDto;
import com.ao.usersmanagement.model.User;
import com.ao.usersmanagement.services.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class UserController implements IUserController{

    private final IUserService userService;

    private final ModelMapper mapper;

    public UserController(IUserService userService, ModelMapper mm) {
        this.userService = userService;
        this.mapper = mm;
    }

    @Override
    public ResponseEntity<UserDto> createUser(@Valid User user) {

        var userToRegister = mapper.map(userService.registerUser(user), UserDto.class);
        var httpHeaders = new HttpHeaders();
        httpHeaders.add("User", "/user/" + userToRegister.getIdUser().toString());
        return new ResponseEntity<>(userToRegister, httpHeaders, HttpStatus.CREATED);
    }

    @Override
    public UserDto getUserDetails(long userId) {
      return  mapper.map(userService.getUserDetails(userId), UserDto.class);
    }
}
