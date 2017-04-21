package com.wristwatch.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by web on 18/04/17.
 */
public interface WatchBrandRepository extends JpaRepository<WatchBrand, Long> {
    List<WatchBrand> findByBrandname(String brandname);

    @Query("SELECT watchBrand FROM WatchBrand watchBrand WHERE watchBrand.brandname=?1")
    List<WatchBrand> checkUserInput(String brandname);

    @Query("SELECT watchBrand FROM WatchBrand watchBrand WHERE watchBrand.brandname LIKE ?1")
    List<WatchBrand> searchWatchBrands(String brandname);
}
