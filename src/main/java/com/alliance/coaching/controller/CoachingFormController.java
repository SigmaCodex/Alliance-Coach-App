package com.alliance.coaching.controller;

import com.alliance.coaching.entity.CoachingForm;
import com.alliance.coaching.service.CoachingFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 26, 2022 5:00 PM
 */

@Controller
@RequestMapping("/c")
@RequiredArgsConstructor
public class CoachingFormController {

    private final CoachingFormService coachingFormService;

    // TODO: 3/26/2022 CRUD for coaching form

    @GetMapping("/form-management")
    public ModelAndView redirectForms() {
        ModelAndView modelAndView = new ModelAndView();
//        List<CoachingForm> coachingForm = coachingFormService.getAll();
//        modelAndView.addObject("forms", coachingForm);
        modelAndView.setViewName("hr/hr-coaching-form-management");
        return modelAndView;
    }

}
