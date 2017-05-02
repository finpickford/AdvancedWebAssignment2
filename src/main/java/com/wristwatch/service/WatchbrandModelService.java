package com.wristwatch.service;

import com.wristwatch.domain.WatchbrandModel;
import com.wristwatch.domain.WatchbrandModelRepository;
import com.wristwatch.domain.WatchbrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by web on 26/04/17.
 */
@Service
public class WatchbrandModelService {

    @Autowired
    WatchbrandModelRepository watchbrandModelRepository;

    public WatchbrandModel save(WatchbrandModel m) {

        return watchbrandModelRepository.save(m); }

    public void delete(WatchbrandModel watchbrandModel) { watchbrandModelRepository.delete(watchbrandModel); }

    public List<WatchbrandModel> findAll() { return watchbrandModelRepository.findAll(); }

}
