package com.alliance.coaching.controller;

import com.alliance.coaching.service.DesiredOutcomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 26, 2022 5:01 PM
 */

@Controller
@RequestMapping("/outcome")
@RequiredArgsConstructor
public class DesiredOutcomeController {

    private final DesiredOutcomeService desiredOutcomeService;

    // TODO: 3/26/2022 CRUD for desired outcome

}
