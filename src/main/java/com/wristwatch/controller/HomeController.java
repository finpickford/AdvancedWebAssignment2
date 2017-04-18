package com.wristwatch.controller;

import com.wristwatch.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by web on 18/04/17.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
//    @ResponseBody
    public String index(Model model) {

        User user = new User();

//        user.setFirstname("Fin");
//        user.setLastname("Pickford");
//        user.setPassword("test");

        model.addAttribute( "user", user);
        return "index";
    }
}
