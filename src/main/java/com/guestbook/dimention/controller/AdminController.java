package com.guestbook.dimention.controller;

import com.guestbook.dimention.entity.Contact;
import com.guestbook.dimention.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final String PATH = "admin";
    private final ContactService contactService;

    @GetMapping("/dashboard")
    public String page(Model model) {
        System.out.println("AdminController.page");
        return PATH + "/dashboard";
    }

    @GetMapping("/mail")
    public String mailList(Model model) {
        List<Contact> list = this.contactService.getList();
        model.addAttribute("list", list);
        return "admin/mail";
    }
}
