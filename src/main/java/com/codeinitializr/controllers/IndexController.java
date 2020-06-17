package com.codeinitializr.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * IndexController
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping(value="")
    public ModelAndView getIndex(ModelAndView mv) {
        mv = new ModelAndView("unlogged/index");
        return mv;
    }
    
}