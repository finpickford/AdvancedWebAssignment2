package com.wristwatch.controller;

import com.wristwatch.domain.Watchbrand;
import com.wristwatch.service.WatchbrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by web on 24/04/17.
 */

@Controller
@RequestMapping(value = "/watchbrand")
public class WatchbrandController {

    @Autowired
    WatchbrandService watchbrandService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String all(Model model)
    {

        List<Watchbrand> watchbrand = watchbrandService.findAll();

        model.addAttribute("watchbrand", watchbrand);
        return "watchbrand/index";
    }

    @RequestMapping(value = "/addbrand", method = RequestMethod.GET)
    public String addBrandView(Model model)
    {
        Watchbrand watchbrand = new Watchbrand();
        model.addAttribute("watchbrand", watchbrand);

        return "watchbrand/addWatchbrand";
    }

    @RequestMapping(value = "/addbrand", method = RequestMethod.POST)
    public String addBrand(Model model, @ModelAttribute("watchbrand") Watchbrand watchbrand)
    {
        watchbrandService.save(watchbrand);
        return "watchbrand/index";
    }

    @RequestMapping(value = "/deletebrand/{watchbrand}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteBrand(@PathVariable Watchbrand watchbrand)
    {
        String name = watchbrand.getBrandname();
        watchbrandService.delete(watchbrand);

        return name;
    }
}
