package com.guestbook.dimention.controller;

import com.guestbook.dimention.dto.ContactDTO;
import com.guestbook.dimention.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/contact")
public class ContactController {
    private final ContactService contactService;

    @PostMapping("/create")
    public String createContact(Model model, ContactDTO contactDTO) {
        contactService.contactCreate(contactDTO);
        return String.format("redirect:/index");
    }
}
