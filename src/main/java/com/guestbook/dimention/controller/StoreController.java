package com.guestbook.dimention.controller;

import com.guestbook.dimention.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreController {

    @RequestMapping("/index")
    public String storeIndexPage() {
        return "store/index";
    }
}
