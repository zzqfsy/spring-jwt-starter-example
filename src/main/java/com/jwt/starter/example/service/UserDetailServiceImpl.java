package com.jwt.starter.example.service;

import com.jwt.starter.security.api.JwtUserFactory;
import com.jwt.starter.service.core.domain.SAuthGroup;
import com.jwt.starter.service.core.domain.SMember;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if ("zzqfsy".equals(s)) {
            SMember sMember = new SMember();
            sMember.setId(1);
            sMember.setUsername("zzqfsy");
            sMember.setIsAdministrator(1);
            sMember.setPassword("e10adc3949ba59abbe56e057f20f883e");
            List<SAuthGroup> sAuthGroups = new ArrayList<>();
            sMember.setsAuthGroups(sAuthGroups);
            sMember.setStatus(1);
            sMember.setAddTime(new Date());
            return JwtUserFactory.create(sMember);
        }
        return null;
    }
}
