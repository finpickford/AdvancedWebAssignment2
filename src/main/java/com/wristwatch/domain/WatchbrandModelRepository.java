package com.wristwatch.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by web on 26/04/17.
 */

// Create a repo to store the watch brand model.
public interface WatchbrandModelRepository extends JpaRepository<WatchbrandModel, Long>{
}
