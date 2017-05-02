package com.wristwatch.service;

import com.wristwatch.domain.Watchbrand;
import com.wristwatch.domain.WatchbrandRepository;
import com.wristwatch.domain.WatchbrandSearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by web on 24/04/17.
 */

//A service to deal with the watchbrands.
@Service
public class WatchbrandService {

    // Link to the brand repo.
    @Autowired
    WatchbrandRepository watchbrandRepository;

    // Save the watchbrand using the repo save method.
    public Watchbrand save(Watchbrand w) { return watchbrandRepository.save(w); }

    // Delete the watchbrand using the repo delete method.
    public void delete(Watchbrand watchbrand) { watchbrandRepository.delete(watchbrand); }

    // Find all of the watchbrands.
    public List<Watchbrand> findAll() { return watchbrandRepository.findAll(); }

    // Search for each watchbrand using the brand name.
    public List<Watchbrand> searchWatchbrand(WatchbrandSearchForm watchbrand)
    {
    // If its empty, show all brands.
        if(watchbrand.getBrandname().isEmpty())
        {
            return watchbrandRepository.findAll();
        }

        return watchbrandRepository.searchWatchbrand(watchbrand.getBrandname());
    }
}
