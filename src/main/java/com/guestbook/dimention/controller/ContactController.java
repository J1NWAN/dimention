package com.guestbook.dimention.controller;

import com.guestbook.dimention.dto.ContactDTO;
import com.guestbook.dimention.entity.Contact;
import com.guestbook.dimention.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/contact")
public class ContactController {
    private final ContactService contactService;

    @GetMapping("/create")
    public String createContact(ContactDTO contactDTO, Principal principal, Model model) {
        contactDTO.setUsername(principal.getName());
        model.addAttribute("contactDTO", contactDTO);
        return "contact";
    }

    @PostMapping("/create")
    public String createContact(@Valid ContactDTO contactDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "contact";
        }

        Integer id = Math.toIntExact(contactService.contactCount());
        contactService.contactCreate(id+1, contactDTO);
        return "redirect:/";
    }

    @RequestMapping("/detail")
    @ResponseBody
    public Contact detailContact(Model model, Integer id) {
        Contact contact = this.contactService.getContact(id);
        model.addAttribute("contact", contact);
        return contact;
    }
}
