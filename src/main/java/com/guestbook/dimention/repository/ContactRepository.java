package com.guestbook.dimention.repository;

import com.guestbook.dimention.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
