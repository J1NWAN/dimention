package com.guestbook.dimention.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ContactDTO {
    private Integer id;
    private String username;
    private String email;
    private String message;
    private LocalDateTime createDate;
}
