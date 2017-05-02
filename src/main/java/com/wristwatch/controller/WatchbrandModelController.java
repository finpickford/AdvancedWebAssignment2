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

// Create a controller for the watchbrand models. Map it using the istance below.
@Controller
@RequestMapping(value = "/watchbrandmodel")
public class WatchbrandModelController {

    // Link the service.
    @Autowired
    WatchbrandModelService watchbrandModelService;

    // Create a method to add a watchbrand model, with the specified watchbrand given. Show the form.
    @RequestMapping(value = "/addmodel/{watchbrand}", method = RequestMethod.GET)
    public String addModelView(Model model, @PathVariable Watchbrand watchbrand)
    {
        // Create an instance of watchbrand model.
        WatchbrandModel watchbrandModel = new WatchbrandModel();
        // Set the watchbrand in the watchbrand model, as the watchbrand passed through.
        watchbrandModel.setWatchbrand(watchbrand);
        model.addAttribute("watchbrandmodel", watchbrandModel);

        return "watchbrandmodel/addWatchbrandModel";
    }
    // Create a method to add a model at the post method.
    @RequestMapping(value = "/addmodel", method = RequestMethod.POST)
    public String addModel(Model model, @ModelAttribute("watchbrandmodel") WatchbrandModel watchbrandModel)
    {
        // Save the brand model in the service.
        watchbrandModelService.save(watchbrandModel);

        return "redirect:/watchbrand/all";
    }

    // Create a method to show all of the models.
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String all(Model model, HttpSession session)
    {
        // If the user isnt logged in, redirect.
        if(session.getAttribute("login")==null)
        {
            return "redirect:/user/login";
        }

        // Create a list of every model using the service find all method.
        List<WatchbrandModel> watchbrandModel = watchbrandModelService.findAll();

        model.addAttribute("watchbrandmodel", watchbrandModel);
        return "watchbrandmodel/all";
    }

    // Create a method to view the model details.
    @RequestMapping(value = "/viewmodel/{watchbrandmodel}", method = RequestMethod.GET)
    public String viewBrandModel(Model model, @PathVariable("watchbrandmodel") WatchbrandModel watchbrandModel)
    {
        model.addAttribute("watchbrandmodel", watchbrandModel);
        return "watchbrandmodel/viewWatchbrandModel";
    }

    // Create a method to update each model specified, load the form.
    @RequestMapping(value = "/updatemodel/{watchbrandmodel}", method = RequestMethod.GET)
    public String updateView(Model model, @PathVariable("watchbrandmodel") WatchbrandModel watchbrandModel)
    {
        model.addAttribute("watchbrandmodel", watchbrandModel);
        return "watchbrandmodel/updateWatchbrandModel";
    }

    // Create a method to update the model at the post stage.
    @RequestMapping(value = "/updatemodel", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("watchbrandModel") WatchbrandModel watchbrandModel)
    {
        watchbrandModelService.save(watchbrandModel);
        return "redirect:/watchbrand/all";
    }

    // Create a method to delete the watch brand model.
    @RequestMapping(value = "/delete/{watchbrandmodel}", method = RequestMethod.GET)
    public String deleteBrand(@PathVariable("watchbrandmodel") WatchbrandModel watchbrandModel)
    {
        // Delete the brand in the service.
        watchbrandModelService.delete(watchbrandModel);

        return "redirect:/watchbrand/all";
    }



}
