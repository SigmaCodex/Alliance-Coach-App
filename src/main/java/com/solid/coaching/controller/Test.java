package com.solid.coaching.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 18, 2022 11:47 PM
 */

@Controller // for view only
//@RestController // for data only
// localhost:8080/api/v1
@RequestMapping("/api/v1")
public class Test {

    // localhost:8080/api/v1/greet
    @GetMapping("/greet")
    public String greet() {
        return "Test";
    }

}
