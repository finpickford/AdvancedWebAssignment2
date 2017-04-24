package com.wristwatch.service;

import com.wristwatch.domain.Watchbrand;
import com.wristwatch.domain.WatchbrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by web on 24/04/17.
 */

@Service
public class WatchbrandService {

    @Autowired
    WatchbrandRepository watchbrandRepository;

    public Watchbrand save(Watchbrand w) { return watchbrandRepository.save(w); }

    public List<Watchbrand> findAll() { return watchbrandRepository.findAll(); }
}
