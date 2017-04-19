package com.wristwatch.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by web on 18/04/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByFirstnameAndPassword(String accountname, String password);
}
