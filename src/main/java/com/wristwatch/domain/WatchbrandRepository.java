package com.wristwatch.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by web on 24/04/17.
 */
public interface WatchbrandRepository extends JpaRepository<Watchbrand, Long> {

    @Query("SELECT watchbrand from Watchbrand watchbrand WHERE watchbrand.brandname LIKE %?1%")
    List<Watchbrand> searchWatchbrand(String brandname);
}
