package com.jwt.starter.example.service;

import com.jwt.starter.service.core.MemberService;
import com.jwt.starter.service.core.domain.SMember;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Override
    public SMember findByUsername(String s) {
        return new SMember();
    }
}
