package com.guestbook.dimention.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/map")
    public String map() {
        return "kakaoMap";
    }
}
