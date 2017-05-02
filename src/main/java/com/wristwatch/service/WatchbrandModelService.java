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

//A service to deal with each watchbrand's model.
@Service
public class WatchbrandModelService {

    // Link to the watchbrand model repo.
    @Autowired
    WatchbrandModelRepository watchbrandModelRepository;

    // Save the watch brand model using the save method in the repo.
    public WatchbrandModel save(WatchbrandModel m) {

        return watchbrandModelRepository.save(m); }

    // Delete the watch brand model using the delete method in the repo.
    public void delete(WatchbrandModel watchbrandModel) { watchbrandModelRepository.delete(watchbrandModel); }

    // List all watch brand models in the repo.
    public List<WatchbrandModel> findAll() { return watchbrandModelRepository.findAll(); }

}
