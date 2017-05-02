package com.wristwatch.controller;

import com.wristwatch.domain.User;
import com.wristwatch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by web on 18/04/17.
 */

// Create a controller to deal with the home.
@Controller
public class HomeController {
    @Autowired
    UserService userService;

    // Load the home page.
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

    // Load the dashboard.
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(HttpSession session) {

        if(session.getAttribute("login")==null)
        {
            return "redirect:/user/login";
        }

        return "dashboard";


    }

    // Load the location page.
    @RequestMapping(value = "/location", method = RequestMethod.GET)
    public String location(HttpSession session) {

        if(session.getAttribute("login")==null)
        {
            return "redirect:/user/login";
        }

        return "location";


    }

}
