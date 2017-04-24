package com.wristwatch.controller;

import com.wristwatch.domain.Watchbrand;
import com.wristwatch.service.WatchbrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

        List<Watchbrand> watchbrands = watchbrandService.findAll();

        model.addAttribute("watchbrand", watchbrands);
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
    @ResponseBody
    public String addBrand(Model model, @ModelAttribute("watchbrand") Watchbrand watchbrand)
    {
        watchbrandService.save(watchbrand);
        return "Succesfull for: "+watchbrand.getBrandname();
//        return "watchbrand/index";
    }
}
