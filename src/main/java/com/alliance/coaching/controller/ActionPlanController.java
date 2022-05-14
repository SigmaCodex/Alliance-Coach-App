package com.alliance.coaching.controller;

import com.alliance.coaching.service.ActionPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 26, 2022 4:27 PM
 */

@Controller
@RequestMapping("/action")
@RequiredArgsConstructor
public class ActionPlanController {

    private final ActionPlanService actionPlanService;

    // TODO: 3/26/2022 CRUD for action plan

}
