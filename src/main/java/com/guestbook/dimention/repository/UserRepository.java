package com.guestbook.dimention.repository;

import com.guestbook.dimention.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
