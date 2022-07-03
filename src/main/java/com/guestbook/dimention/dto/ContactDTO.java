package com.guestbook.dimention.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
public class ContactDTO {
    @NotEmpty(message = "이름은 필수항목입니다.")
    private String username;

    @NotEmpty(message = "이메일은 필수항목입니다.")
    @Email(message = "이메일 형식에 맞지 않습니다.")
    private String email;

    @NotEmpty(message = "제목은 필수항목입니다.")
    private String title;

    @NotEmpty(message = "내용은 필수항목입니다.")
    private String message;

    private LocalDateTime createDate;
}
