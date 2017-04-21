package com.wristwatch.service;

import com.wristwatch.domain.LoginForm;
import com.wristwatch.domain.WatchBrand;
import com.wristwatch.domain.WatchBrandRepository;
import com.wristwatch.domain.WatchBrandSearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by web on 18/04/17.
 */

@Service
public class WatchBrandService {

    @Autowired
    WatchBrandRepository watchBrandRepository;

    public WatchBrand save(WatchBrand u) {
        return watchBrandRepository.save(u);
    }

    public List<WatchBrand> findAll() {
        return watchBrandRepository.findAll();
    }

    public void delete(WatchBrand watchBrand)
    {
        watchBrandRepository.delete(watchBrand);
    }


    public List<WatchBrand> searchWatchBrand(WatchBrandSearchForm watchBrand)
    {
        return watchBrandRepository.searchWatchBrands(watchBrand.getBrandname());
    }
}
