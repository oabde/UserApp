package com.ao.usersmanagement.services;

import com.ao.usersmanagement.model.User;

public interface IUserService {

    User registerUser(User user);

    User getUserDetails(Long id);

}
