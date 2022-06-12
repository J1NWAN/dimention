package com.guestbook.dimention.service;

import com.guestbook.dimention.dto.ContactDTO;
import com.guestbook.dimention.entity.Contact;
import com.guestbook.dimention.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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
