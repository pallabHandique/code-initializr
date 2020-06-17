package com.codeinitializr.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * LoginController
 */
@RestController
@RequestMapping("/")
public class LoginController {

    @GetMapping(value = "login")
    public ModelAndView getLoginPage(ModelAndView mv){
        mv = new ModelAndView("unlogged/login");
        return mv;
    }
}