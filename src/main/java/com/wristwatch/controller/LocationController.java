package com.wristwatch.controller;

import com.wristwatch.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by web on 01/05/17.
 */
@Controller
public class LocationController {

    @RequestMapping(value = "/location", method = RequestMethod.GET)
    public String locationView(HttpSession session) {

        if(session.getAttribute("login")==null)
        {
            return "redirect:/user/login";
        }

        return "location";
    }
}
