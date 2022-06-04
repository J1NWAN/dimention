package com.guestbook.dimention.controller;

import com.guestbook.dimention.dto.ContactDTO;
import com.guestbook.dimention.entity.Contact;
import com.guestbook.dimention.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

    private final ContactService contactService;

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/map")
    public String map() {
        return "kakaoMap";
    }

    @PostMapping("/create/contact")
    public String createContact(Model model, ContactDTO contactDTO) {
        System.out.println("contactDTO: " + contactDTO);
        contactService.contactCreate(contactDTO);
        return String.format("redirect:/index");
    }
}
