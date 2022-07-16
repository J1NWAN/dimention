package com.guestbook.dimention.controller;

import com.guestbook.dimention.dto.SiteUserDTO;
import com.guestbook.dimention.entity.Contact;
import com.guestbook.dimention.entity.SiteUser;
import com.guestbook.dimention.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    /**
     * 로그인
     * @param
     * @return
     */
    @GetMapping("/login")
    public String signIn() {
        return "signin_form";
    }

    @PostMapping("/login")
    public String signIn(@Valid SiteUserDTO siteUserDTO, BindingResult bindingResult) {
        // 검증 오류 결과 보관
        Map<String, String> errors = new HashMap<>();

        if (ObjectUtils.isEmpty(siteUserDTO.getUserId()) || ObjectUtils.isEmpty(siteUserDTO.getPassword1())) {
            errors.put("id", "아이디 또는 비밀번호가 틀렸습니다.");
            bindingResult.addError(new FieldError("userDTO", "userId", "아이디 또는 비밀번호가 틀렸습니다."));
        }

        if(bindingResult.hasErrors()) {
            return "signin_form";
        }
        return "redirect:/";
    }

    /**
     * 회원가입
     * @param siteUserDTO
     * @return
     */
    @GetMapping("/signup")
    public String signUp(SiteUserDTO siteUserDTO) {
        return "signup_form";
    }

    @PostMapping("/signup")
    public String signUp(@Valid SiteUserDTO siteUserDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        if (!siteUserDTO.getPassword1().equals(siteUserDTO.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }

        try {
            Integer id = Math.toIntExact(userService.userCount());
            userService.create(siteUserDTO, id);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "signup_form";

        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "signup_form";
        }

        return "redirect:/";
    }

    @RequestMapping("/detail")
    @ResponseBody
    public SiteUser detailContact(Model model, Integer id) {
        SiteUser siteUser = this.userService.getSiteUser(id);
        model.addAttribute("siteUser", siteUser);
        return siteUser;
    }
}
