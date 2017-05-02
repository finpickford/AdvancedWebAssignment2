package com.wristwatch.service;

import com.wristwatch.domain.LoginForm;
import com.wristwatch.domain.UserSearchForm;
import com.wristwatch.domain.User;
import com.wristwatch.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by web on 18/04/17.
 */

//A service to deal with each user request.
@Service
public class UserService {

    // Link to the user repo.
    @Autowired
    UserRepository userRepository;

    // Save the user using the save method in the repo.
    public User save(User u) {
        return userRepository.save(u);
    }

    // List all users using the find all method.
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Delete the user using the delete method in the repo.
    public void delete(User user)
    {
        userRepository.delete(user);
    }

    // validate the user's login, to check they are in the database.
    public boolean validatedLogin(LoginForm user)
    {
        // Check the input, if the user account and password result is more than 0, login.
        List<User> users = userRepository.checkUserInput(user.getAccountname(), user.getPassword());
        return users !=null && users.size()>0;
    }

    // Search each user.
    public List<User> searchUsers(UserSearchForm user)
    {
        return userRepository.searchUsers(user.getFirstname(), user.getLastname());
    }
}
