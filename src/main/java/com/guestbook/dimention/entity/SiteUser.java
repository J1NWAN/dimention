package com.guestbook.dimention.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
public class SiteUser {

    @Id
    private Integer id;

    @Column(unique = true)
    private String userId;

    private String username;

    private String password;

    @Column(unique = true)
    private String email;

    private String userType;

    private String phone;

    private LocalDateTime createDate;

    private Date updateDate;
}
