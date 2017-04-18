package com.wristwatch.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by web on 18/04/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
