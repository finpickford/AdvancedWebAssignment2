package com.wristwatch.controller;

import com.wristwatch.domain.Watchbrand;
import com.wristwatch.domain.WatchbrandSearchForm;
import com.wristwatch.service.WatchbrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by web on 24/04/17.
 */

// Create a controller to deal with the watch brands. Map it using the mapping below.
@Controller
@RequestMapping(value = "/watchbrand")
public class WatchbrandController {

    // Link to the brand service file.
    @Autowired
    WatchbrandService watchbrandService;

    // Create a method to show all the brands.
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String all(Model model, HttpSession session)
    {

        // If the user isn't logged in, redirect to login.
        if(session.getAttribute("login")==null)
        {
            return "redirect:/user/login";
        }

        // Create a list of every brand from the declared service.
        List<Watchbrand> watchbrand = watchbrandService.findAll();

        model.addAttribute("watchbrand", watchbrand);
        return "watchbrand/index";
    }

    // Create a method to add a brand, load the form.
    @RequestMapping(value = "/addbrand", method = RequestMethod.GET)
    public String addBrandView(Model model)
    {
        Watchbrand watchbrand = new Watchbrand();
        model.addAttribute("watchbrand", watchbrand);

        return "watchbrand/addWatchbrand";
    }

    // Create the post method to add a brand.
    @RequestMapping(value = "/addbrand", method = RequestMethod.POST)
    public String addBrand(Model model, @ModelAttribute("watchbrand") Watchbrand watchbrand)
    {

        // Save the brand in the brand service declared using the variable param.
        watchbrandService.save(watchbrand);
        return "redirect:/watchbrand/all";
    }

    // Create a method to update the brand, load the form.
    @RequestMapping(value = "/updatebrand/{watchbrand}", method = RequestMethod.GET)
    public String updateView(Model model, @PathVariable Watchbrand watchbrand)
    {
        model.addAttribute("watchbrand", watchbrand);
        return "watchbrand/updateWatchBrand";
    }

    // Create a method to update the brand at the post.
    @RequestMapping(value = "/updatebrand", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("watchbrand") Watchbrand watchbrand)
    {

        // Save the brand service.
        watchbrandService.save(watchbrand);
        return "redirect:/watchbrand/all";
    }

    // Create a method to delete the brand.
    @RequestMapping(value = "/deletebrand/{watchbrand}", method = RequestMethod.GET)
    public String deleteBrand(@PathVariable Watchbrand watchbrand)
    {

        // Delete it from the service.
        watchbrandService.delete(watchbrand);

        return "redirect:/watchbrand/all";
    }

    // Create a method to search for a brand.
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchBrandView(Model model, HttpSession session)
    {
        if(session.getAttribute("login")==null)
        {
            return "redirect:/user/login";
        }

        // Create a new search instance.
        WatchbrandSearchForm searchForm = new WatchbrandSearchForm();
        model.addAttribute("searchCriteria", searchForm);
        return "watchbrand/watchbrandSearch";
    }

    // Post the search.
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(Model model, @ModelAttribute("searchCriteria") WatchbrandSearchForm searchForm)
    {

        // Create a list of the search results using the search form instance.
        List<Watchbrand> watchbrand = watchbrandService.searchWatchbrand(searchForm);
        model.addAttribute("watchbrand", watchbrand);
        return "watchbrand/watchbrandSearch";
    }

    // Create a method to view each brands details specified.
    @RequestMapping(value = "/viewbrand/{watchbrand}", method = RequestMethod.GET)
    public String viewBrand(Model model, @PathVariable Watchbrand watchbrand)
    {
        model.addAttribute("watchbrand", watchbrand);
        return "watchbrand/viewWatchBrand";
    }

}
