package com.guestbook.dimention.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/intro")
public class IntroController {

    @RequestMapping("")
    public String intro() {
        return "intro";
    }
}
