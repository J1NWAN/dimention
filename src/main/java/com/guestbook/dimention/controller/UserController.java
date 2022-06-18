package com.guestbook.dimention.controller;

import com.guestbook.dimention.dto.UserDTO;
import com.guestbook.dimention.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/signin")
    public String signIn(UserDTO userDTO) {
        return "signin_form";
    }

    @PostMapping("/signin")
    public String signIn(@Valid UserDTO userDTO, BindingResult bindingResult, String userId, String password, Model model) {
        // 검증 오류 결과 보관
        Map<String, String> errors = new HashMap<>();

        if (ObjectUtils.isEmpty(userDTO.getUserId()) || ObjectUtils.isEmpty(userDTO.getPassword1())) {
            errors.put("id", "아이디 또는 비밀번호가 틀렸습니다.");
            bindingResult.addError(new FieldError("userDTO", "userId", "아이디 또는 비밀번호가 틀렸습니다."));
        }

        if(bindingResult.hasErrors()) {
            return "signin_form";
        }
        return "redirect:/";
    }

    @PostMapping("/signup")
    public String signup(@Valid UserDTO userDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        if (!userDTO.getPassword1().equals(userDTO.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }

        userService.create(userDTO);

        return "redirect:/";
    }
}
