package com.wristwatch.controller;

import com.wristwatch.domain.WatchbrandModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by web on 26/04/17.
 */
@Controller
@RequestMapping(value = "/templates/watchbrandmodel")
public class WatchbrandModelController {

    @RequestMapping(value = "/addmodel", method = RequestMethod.GET)
    public String addModelView(Model model)
    {
        WatchbrandModel watchbrandModel = new WatchbrandModel();
        model.addAttribute("templates/watchbrandmodel", watchbrandModel);

        return "templates/watchbrandmodel/addWatchbrandModel";
    }


}
