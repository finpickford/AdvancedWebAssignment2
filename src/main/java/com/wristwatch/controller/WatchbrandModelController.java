package com.wristwatch.controller;

import com.wristwatch.domain.Watchbrand;
import com.wristwatch.domain.WatchbrandModel;
import com.wristwatch.service.WatchbrandModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by web on 26/04/17.
 */
@Controller
@RequestMapping(value = "/watchbrandmodel")
public class WatchbrandModelController {

    @Autowired
    WatchbrandModelService watchbrandModelService;

    @RequestMapping(value = "/addmodel/{watchbrand}", method = RequestMethod.GET)
    public String addModelView(Model model, @PathVariable Watchbrand watchbrand)
    {
        WatchbrandModel watchbrandModel = new WatchbrandModel();
        model.addAttribute("watchbrandmodel", watchbrandModel);

        return "watchbrandmodel/addWatchbrandModel";
    }

    @RequestMapping(value = "/addmodel/{watchbrand}", method = RequestMethod.POST)
    public String addModelView(Model model, @ModelAttribute("watchbrandmodel") WatchbrandModel watchbrandModel)
    {
        watchbrandModelService.save(watchbrandModel);

        return "redirect:/";
    }



}
