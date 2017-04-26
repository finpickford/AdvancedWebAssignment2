package com.wristwatch.service;

import com.wristwatch.domain.WatchbrandModel;
import com.wristwatch.domain.WatchbrandModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by web on 26/04/17.
 */
@Service
public class WatchbrandModelService {

    @Autowired
    WatchbrandModelRepository watchbrandModelRepository;

    public WatchbrandModel save(WatchbrandModel m) { return watchbrandModelRepository.save(m); }

}
