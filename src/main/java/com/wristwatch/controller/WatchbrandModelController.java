package com.wristwatch.controller;

import com.wristwatch.domain.Watchbrand;
import com.wristwatch.domain.WatchbrandModel;
import com.wristwatch.service.WatchbrandModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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
        watchbrandModel.setWatchbrand(watchbrand);
        model.addAttribute("watchbrandmodel", watchbrandModel);

        return "watchbrandmodel/addWatchbrandModel";
    }

    @RequestMapping(value = "/addmodel", method = RequestMethod.POST)
    public String addModel(Model model, @ModelAttribute("watchbrandmodel") WatchbrandModel watchbrandModel)
    {
        watchbrandModelService.save(watchbrandModel);

        return "redirect:/watchbrand/all";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String all(Model model, HttpSession session)
    {

        if(session.getAttribute("login")==null)
        {
            return "redirect:/user/login";
        }

        List<WatchbrandModel> watchbrandModel = watchbrandModelService.findAll();

        model.addAttribute("watchbrandmodel", watchbrandModel);
        return "watchbrandmodel/all";
    }

    @RequestMapping(value = "/viewmodel/{watchbrandmodel}", method = RequestMethod.GET)
    public String viewBrandModel(Model model, @PathVariable("watchbrandmodel") WatchbrandModel watchbrandModel)
    {
        model.addAttribute("watchbrandmodel", watchbrandModel);
        return "watchbrandmodel/viewWatchbrandModel";
    }


    @RequestMapping(value = "/updatemodel/{watchbrandmodel}", method = RequestMethod.GET)
    public String updateView(Model model, @PathVariable("watchbrandmodel") WatchbrandModel watchbrandModel)
    {

        model.addAttribute("watchbrandmodel", watchbrandModel);
        return "watchbrandmodel/updateWatchbrandModel";
    }

    @RequestMapping(value = "/updatemodel", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("watchbrandModel") WatchbrandModel watchbrandModel)
    {
        watchbrandModelService.save(watchbrandModel);
        return "redirect:/watchbrand/all";
    }

    @RequestMapping(value = "/delete/{watchbrandmodel}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteBrand(@PathVariable("watchbrandmodel") WatchbrandModel watchbrandModel)
    {
        String name = watchbrandModel.getModelname();
        watchbrandModelService.delete(watchbrandModel);

        return name;
    }



}
