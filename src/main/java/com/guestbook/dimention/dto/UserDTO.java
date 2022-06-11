package com.guestbook.dimention.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserDTO {
    @Size(min = 3, max = 25)
    @NotEmpty(message = "ID는 필수항목입니다.")
    private String userId;

    @NotEmpty(message = "이름은 필수항목입니다.")
    private String username;

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String password2;

    @NotEmpty(message = "이메일은 필수항목입니다.")
    @Email(message = "이메일 형식에 맞지 않습니다.")
    private String email;

    private LocalDateTime createDate;
}
