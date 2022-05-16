package com.alliance.coaching.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 28, 2022 8:33 AM
 */

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class BaseController {

    // TODO: 3/28/2022 login page
    @GetMapping("")
    public String loginPage() {
        return "index";
    }

    @GetMapping("register")
    public String registerView() {
        return "register";
    }

    // TODO: 5/15/2022 logout user
    @PostMapping("")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }
}