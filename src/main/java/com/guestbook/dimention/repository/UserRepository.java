package com.guestbook.dimention.repository;

import com.guestbook.dimention.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<SiteUser, Integer> {
    Optional<SiteUser> findByuserId(String userId);
}
