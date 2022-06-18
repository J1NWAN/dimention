package com.guestbook.dimention.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/around")
public class AroundController {

    @RequestMapping("")
    public String around() {
        return "around";
    }
}
