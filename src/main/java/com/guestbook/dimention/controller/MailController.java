package com.guestbook.dimention.controller;

import com.guestbook.dimention.dto.MailDTO;
import com.guestbook.dimention.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @GetMapping("/send")
    public MailDTO sendMail(String email, String message) {
        MailDTO mailDTO = new MailDTO();

        mailDTO.setEmail(email);
        mailDTO.setTitle("DIMENTION 님이 발송한 이메일입니다.");
        mailDTO.setMessage(message);
        mailService.sendMail(mailDTO);

        return mailDTO;
    }
}
