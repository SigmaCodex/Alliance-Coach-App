package com.alliance.coaching.controller;

import com.alliance.coaching.service.CoachingFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 26, 2022 5:00 PM
 */

@Controller
@RequestMapping("/form")
@RequiredArgsConstructor
public class CoachingFormController {

    private final CoachingFormService coachingFormService;

    // TODO: 3/26/2022 CRUD for coaching form

}
