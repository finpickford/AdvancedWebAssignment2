package com.wristwatch.controller;

import com.wristwatch.domain.WatchBrand;
import com.wristwatch.service.WatchBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by web on 18/04/17.
 */

@Controller
@RequestMapping(value = "/watchbrand")
public class WatchBrandController {
    @Autowired
    WatchBrandService watchBrandService;

    @RequestMapping(value = "/watchbrand/addbrand", method = RequestMethod.GET)
    public String addBrandView(Model model)
    {

        WatchBrand watchBrand = new WatchBrand();
        model.addAttribute("watchBrand", watchBrand);

        return "watchbrands/addWatchBrand";
    }

    @RequestMapping(value = "/addbrand", method = RequestMethod.POST)
//    @ResponseBody
    public String addBrand(Model model, @Valid @ModelAttribute("watchBrand") WatchBrand watchBrand, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            model.addAttribute("watchBrand", watchBrand);
            model.addAttribute("message", "Please provide information in each field.");
            return "watchbrands/addWatchBrand";
        }
        watchBrandService.save(watchBrand);
        return "redirect:/";
    }

//    @RequestMapping(value = "/search", method = RequestMethod.GET)
//    public String searchView(Model model)
//    {
//        UserSearchForm searchForm = new UserSearchForm();
//        model.addAttribute("searchCriteria", searchForm);
//        return "user/search";
//    }

    @RequestMapping(value = "/update/{watchBrand}", method = RequestMethod.GET)
    public String updateWatchBrandView(Model model, @PathVariable WatchBrand watchBrand)
    {
        model.addAttribute("watchBrand", watchBrand);
        return "watchbrands/updateWatchBrand";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateWatchBrand(Model model, @ModelAttribute("watchBrand") WatchBrand watchBrand)
    {
        watchBrandService.save(watchBrand);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{watchBrand}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable WatchBrand watchBrand)
    {
        String name = watchBrand.getBrandname()+ " ";

        watchBrandService.delete(watchBrand);

        return name;
    }
}
