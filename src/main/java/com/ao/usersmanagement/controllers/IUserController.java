package com.ao.usersmanagement.controllers;

import com.ao.usersmanagement.dto.UserDto;
import com.ao.usersmanagement.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Validated
@RequestMapping("user")
public interface IUserController {

    @PostMapping(value = "/Register-user")
    ResponseEntity<UserDto> createUser(@Valid @RequestBody User user);
    
    @GetMapping(value ="/{user_id}")
    UserDto getUserDetails(@PathVariable("user_id") long userId);
}
