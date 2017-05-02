package com.wristwatch.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by web on 24/04/17.
 */

// Create a repo in order to store each watch brand. Extend the Jpa repo.
public interface WatchbrandRepository extends JpaRepository<Watchbrand, Long> {

    // Create a query to be used with searching. Select the brandname that's like the search term.
    @Query("SELECT watchbrand from Watchbrand watchbrand WHERE watchbrand.brandname LIKE %?1%")
    List<Watchbrand> searchWatchbrand(String brandname);

}
