package com.wristwatch.controller;

import com.wristwatch.domain.LoginForm;
import com.wristwatch.domain.User;
import com.wristwatch.domain.UserSearchForm;
import com.wristwatch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import javax.validation.Valid;

import javax.servlet.http.HttpSession;

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

        return "user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    @ResponseBody
    public String register(Model model, @Valid @ModelAttribute("user") User user, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            model.addAttribute("user", user);
            model.addAttribute("message", "Please provide information in each field.");
            return "user/register";
        }
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginView(Model model)
    {
        LoginForm user = new LoginForm();
        model.addAttribute("user", user);
        return "user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @ResponseBody
    public String login(Model model, @Valid @ModelAttribute("user") LoginForm user, BindingResult bindingResult, HttpSession session)
    {
        if(bindingResult.hasErrors()){
            model.addAttribute("user", user);
            model.addAttribute("message", "Please provide information in each field.");
            return "/user/login";
        }

        if(userService.validatedLogin(user)==false)
        {
            model.addAttribute("user", user);
            model.addAttribute("message", "Your account name and password are incorrect.");
            return "user/login";
        }
//        userService.save(user);
        session.setAttribute("login", true);

        return "redirect:/";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model, HttpSession session)
    {
//        if(session.getAttribute("login")==null)
//        {
//            return "logout_error";
//        }

        session.removeAttribute("login");
        return "redirect:/user/login";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchView(Model model)
    {
        UserSearchForm searchForm = new UserSearchForm();
        model.addAttribute("searchCriteria", searchForm);
        return "user/search";
    }

    @RequestMapping(value = "/update/{user}", method = RequestMethod.GET)
    public String updateView(Model model, @PathVariable User user)
    {
        model.addAttribute("user", user);
        return "user/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("user") User user)
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
