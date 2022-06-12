package com.guestbook.dimention.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 화면에서 전달되는 입력 값 검증
 */
@Getter @Setter
public class ContactForm {
    @NotEmpty(message = "이름은 필수항목입니다.")
    @Size(max = 50)
    private String username;

    @NotEmpty(message = "이메일은 필수항목입니다.")
    @Email(message = "이메일 형식에 맞지 않습니다.")
    @Size(max = 200)
    private String email;

    @NotEmpty(message = "내용은 필수항목입니다.")
    private String message;
}
