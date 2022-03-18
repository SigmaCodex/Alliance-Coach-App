package com.solid.coaching.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 18, 2022 11:47 PM
 */

@RestController
@RequestMapping("/api/v1")
public class Test {

    @GetMapping("/")
    public String greet() {
        return "Hello, SOLIDS!";
    }

}
