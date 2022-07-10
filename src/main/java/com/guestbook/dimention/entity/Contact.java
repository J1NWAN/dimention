package com.guestbook.dimention.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Contact {
    @Id
    private Integer id;

    @Column(length = 50)
    private String username;

    @Column(length = 200)
    private String email;

    @Column(columnDefinition = "TEXT")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String message;

    private LocalDateTime createDate;
}
