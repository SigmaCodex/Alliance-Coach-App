package com.alliance.coaching.controller;

import com.alliance.coaching.entity.TeamMember;
import com.alliance.coaching.service.TeamMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @PostMapping("/")
    public ModelAndView registerEmployee(@ModelAttribute TeamMember teamMember) {
        ModelAndView modelAndView = new ModelAndView();
        TeamMember savedTeamMember = teamMemberService.create(teamMember);
        modelAndView.setViewName("home");
        modelAndView.addObject("team_member", savedTeamMember);
        return modelAndView;
    }

    // TODO: 3/28/2022 login team member
    @GetMapping("/login")
    public String loginTeamMember(@RequestParam String username,
                                  @RequestParam String password) {
        TeamMember teamMember = teamMemberService.loginEmployee(username, password);
        // TODO: 3/28/2022 HR portal
        if (teamMember.getEmployeeType().equals("HR")) {
            return "hr_portal";
        }
        // TODO: 3/28/2022 Coach portal
        if (teamMember.getEmployeeType().equals("Coach")) {
            return "coach_portal";
        }
        return "index";
    }

}
