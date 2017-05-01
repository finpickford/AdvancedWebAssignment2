package com.wristwatch.controller;

import com.wristwatch.domain.User;
import com.wristwatch.service.UserService;
import com.wristwatch.service.WatchbrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by web on 18/04/17.
 */
@Controller
public class HomeController {
    @Autowired
    UserService userService;

    @Autowired
    WatchbrandService watchbrandService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {

        if(session.getAttribute("login")==null)
        {
            return "redirect:/user/login";
        }

        List<User> users = userService.findAll();


        model.addAttribute( "users", users);
        return "index";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(HttpSession session) {

        if(session.getAttribute("login")==null)
        {
            return "redirect:/user/login";
        }


        return "dashboard";


    }

    @RequestMapping(value = "/location", method = RequestMethod.GET)
    public String location(HttpSession session) {

        if(session.getAttribute("login")==null)
        {
            return "redirect:/user/login";
        }


        return "location";


    }



}
