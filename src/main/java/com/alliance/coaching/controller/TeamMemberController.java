package com.alliance.coaching.controller;

import com.alliance.coaching.service.TeamMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 26, 2022 5:01 PM
 */

@Controller
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamMemberController {

    private final TeamMemberService teamMemberService;

    // TODO: 3/26/2022 CRUD for team member

}
