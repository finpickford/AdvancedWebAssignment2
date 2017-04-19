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

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User u) {
        return userRepository.save(u);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void delete(User user)
    {
        userRepository.delete(user);
    }

    public boolean validatedLogin(LoginForm user)
    {

        List<User> users = userRepository.checkUserInput(user.getAccountname(), user.getPassword());
//        List<User> users = userRepository.findByFirstnameAndPassword(user.getAccountname(), user.getPassword());
        return users !=null && users.size()>0;
    }

    public List<User> searchUsers(UserSearchForm user)
    {
        return userRepository.searchUsers(user.getFirstname(), user.getLastname());
    }
}
