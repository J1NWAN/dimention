package com.guestbook.dimention.service;

import com.guestbook.dimention.dto.UserDTO;
import com.guestbook.dimention.entity.User;
import com.guestbook.dimention.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User create(UserDTO userDTO) {
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setUsername(userDTO.getUsername());

        user.setPassword(passwordEncoder.encode(userDTO.getPassword1()));
        user.setEmail(userDTO.getEmail());

        if(whoisIp()) {
            user.setUserType("관리자");
        } else {
            user.setUserType("일반");
        }

        System.out.println(whoisIp());
        userRepository.save(user);
        return user;
    }

    public boolean whoisIp() {
        String hostIp = null;
        String[] publicIp = {"127.0.0.1", "192.168.0.8", "218.38.137.27"};
        boolean result = false;

        try {
            hostIp = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            hostIp = "";
        }

        for(int i=0; i< publicIp.length; i++) {
            if(hostIp.equals(publicIp[i])) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }
}
