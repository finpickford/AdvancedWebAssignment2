package com.wristwatch.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by web on 18/04/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByFirstnameAndPassword(String accountname, String password);

    @Query("SELECT user FROM User user WHERE user.firstname=?1 and user.password=?2")
    List<User> checkUserInput(String accountname, String password);

    @Query("SELECT user from User user WHERE user.firstname LIKE ?1 and user.lastname LIKE ?2")
    List<User> searchUsers(String firstname, String lastname);
}
