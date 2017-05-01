package com.wristwatch.service;

import com.wristwatch.domain.WatchbrandModel;
import com.wristwatch.domain.WatchbrandModelRepository;
import com.wristwatch.domain.WatchbrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by web on 26/04/17.
 */
@Service
public class WatchbrandModelService {

    @Autowired
    WatchbrandModelRepository watchbrandModelRepository;
    WatchbrandRepository watchbrandRepository;

    public WatchbrandModel save(WatchbrandModel m) {

        m.setWatchbrand(watchbrandRepository.findOne(m.getBrandID()));
        return watchbrandModelRepository.save(m); }

}
