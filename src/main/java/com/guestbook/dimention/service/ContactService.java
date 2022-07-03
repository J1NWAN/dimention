package com.guestbook.dimention.service;

import com.guestbook.dimention.DataNotFoundException;
import com.guestbook.dimention.dto.ContactDTO;
import com.guestbook.dimention.entity.Contact;
import com.guestbook.dimention.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.*;

@RequiredArgsConstructor
@Service
public class ContactService {

    private final ContactRepository contactRepository;

//    /**
//     * Contact 등록 시, 유효성 체크
//     * @param errors
//     * @return
//     */
//    public Map<String, String> validateHandling(Errors errors) {
//        Map<String, String> validatorResult = new HashMap<>();
//
//        for(FieldError error : errors.getFieldErrors()) {
//            String validKeyName = String.format("valid_%s", error.getField());
//            validatorResult.put(validKeyName, error.getDefaultMessage());
//        }
//
//        return validatorResult;
//    }

    public List<Contact> getList() {
        return this.contactRepository.findAll();
    }

    public Contact getContact(Integer id) {
        Optional<Contact> contact = this.contactRepository.findById(id);
        if(contact.isPresent()) {
            return contact.get();
        } else {
            throw new DataNotFoundException("question not Found");
        }
    }

    public void contactCreate(ContactDTO contactDTO) {
        Contact contact = new Contact();

        contact.setUsername(contactDTO.getUsername());
        contact.setEmail(contactDTO.getEmail());
        contact.setTitle(contactDTO.getTitle());
        contact.setMessage(contactDTO.getMessage());
        contact.setCreateDate(LocalDateTime.now());

        contactRepository.save(contact);
        System.out.println("contact 등록완료!");
    }

}
