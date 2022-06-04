package com.guestbook.dimention.service;

import com.guestbook.dimention.dto.ContactDTO;
import com.guestbook.dimention.entity.Contact;
import com.guestbook.dimention.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public void contactCreate(ContactDTO contactDTO) {
        Contact contact = new Contact();

        contact.setUsername(contactDTO.getUsername());
        contact.setEmail(contactDTO.getEmail());
        contact.setMessage(contactDTO.getMessage());
        contact.setCreateDate(LocalDateTime.now());

        contactRepository.save(contact);
        System.out.println("contact 등록완료!");
    }
}
