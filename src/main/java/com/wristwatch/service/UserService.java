package com.wristwatch.service;

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

}
