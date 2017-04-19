package com.wristwatch.controller;

import com.wristwatch.domain.User;
import com.wristwatch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/delete/{user}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable User user)
    {
        String name = user.getFirstname()+ " "+user.getLastname();

        userService.delete(user);

        return name;
    }
}
