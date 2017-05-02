package com.wristwatch.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by web on 18/04/17.
 */

// Create a Jpa repo to deal with storing user details.
public interface UserRepository extends JpaRepository<User, Long> {

    // Create a list to find each name and password.
    List<User> findByFirstnameAndPassword(String accountname, String password);

    // Create a query to select each user based on the firstname and password given.
    @Query("SELECT user FROM User user WHERE user.firstname=?1 and user.password=?2")
    List<User> checkUserInput(String accountname, String password);

    @Query("SELECT user from User user WHERE user.firstname LIKE ?1 and user.lastname LIKE ?2")
    List<User> searchUsers(String firstname, String lastname);
}
