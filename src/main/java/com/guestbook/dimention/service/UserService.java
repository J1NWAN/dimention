package com.guestbook.dimention.service;

import com.guestbook.dimention.dto.SiteUserDTO;
import com.guestbook.dimention.entity.SiteUser;
import com.guestbook.dimention.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(SiteUserDTO userDTO) {
        SiteUser siteUser = new SiteUser();
        siteUser.setUserId(userDTO.getUserId());
        siteUser.setUsername(userDTO.getUsername());

        siteUser.setPassword(passwordEncoder.encode(userDTO.getPassword1()));
        siteUser.setEmail(userDTO.getEmail());

        if(whoisIp()) {
            siteUser.setUserType("관리자");
        } else {
            siteUser.setUserType("일반");
        }

        System.out.println(whoisIp());
        userRepository.save(siteUser);
        return siteUser;
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
