package com.guestbook.dimention.controller;

import com.guestbook.dimention.dto.ContactDTO;
import com.guestbook.dimention.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/contact")
public class ContactController {
    private final ContactService contactService;

    @GetMapping("/create")
    public String createContact(ContactDTO contactDTO) {
        return "contact";
    }

    @PostMapping("/create")
    public String createContact(@Valid ContactDTO contactDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "contact";
        }

        contactService.contactCreate(contactDTO);
        return "redirect:/index";
    }
}
