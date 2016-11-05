package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Ola on 04.11.2016.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/", method = GET)
    public String login()
    {
        return "index";
    }
}
