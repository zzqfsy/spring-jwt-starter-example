package com.jwt.starter.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@PreAuthorize("hasRole('admin')")
public class TestController {

    @PreAuthorize("@jwtUserRulesService.ruleLegal(authentication, 17)")
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test1() {
        return "success";
    }
}
