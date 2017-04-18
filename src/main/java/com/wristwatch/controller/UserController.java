package com.wristwatch.controller;

import com.wristwatch.domain.User;
import com.wristwatch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by web on 18/04/17.
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerView(Model model)
    {

        User user = new User();
        model.addAttribute("user", user);

        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    @ResponseBody
    public String register(Model model, @ModelAttribute("user") User user)
    {
        userService.save(user);
        return "redirect:/";
    }
}
