package com.ao.usersmanagement.services;

import com.ao.usersmanagement.dao.UserRepository;
import com.ao.usersmanagement.exception.UserNotFoundException;
import com.ao.usersmanagement.exception.UserRequestException;
import com.ao.usersmanagement.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService implements IUserService {

    private final UserRepository userDao;

    @Override
    public User registerUser(User user) {

        long age =LocalDate.from(user.getBirth()).until(LocalDate.now(), ChronoUnit.YEARS);
        if(age>=18 && "FRANCE".equals(user.getCountry())){
            return userDao.save(user);
        }
        throw new UserRequestException("Only adult French residents are allowed to create an account!");
    }

    @Override
    public User getUserDetails(Long id) {

        Optional<User> userDetails = userDao.findById(id);

        if(userDetails.isPresent()){
            return userDetails.get();
        }
        throw new UserNotFoundException("User with Id "+id+" Does not Exist !");
    }
}
