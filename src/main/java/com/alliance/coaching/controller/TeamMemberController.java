package com.alliance.coaching.controller;

import com.alliance.coaching.entity.TeamMember;
import com.alliance.coaching.service.TeamMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 26, 2022 5:01 PM
 */

@Controller
@RequestMapping("/c")
@RequiredArgsConstructor
public class TeamMemberController {

    private final TeamMemberService teamMemberService;

    // TODO: 3/26/2022 CRUD for team member

    @PostMapping("/user-register")
    public ModelAndView registerEmployee(@ModelAttribute TeamMember teamMember) {
        ModelAndView modelAndView = new ModelAndView();
        teamMemberService.create(teamMember);
        List<TeamMember> members = teamMemberService.getAll();
        modelAndView.setViewName("hr/hr-user-management");
        modelAndView.addObject("members", members);
        return modelAndView;
    }

    // TODO: 3/28/2022 login team member
    @PostMapping("/user-management")
    public ModelAndView loginTeamMember(@ModelAttribute TeamMember login, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        TeamMember teamMember = teamMemberService.loginEmployee(login.getUsername(), login.getPassword());
        List<TeamMember> members = teamMemberService.getAll();
        // TODO: 3/28/2022 HR portal
        if (teamMember.getEmployeeType().equals("HR")) {
            modelAndView.setViewName("hr/hr-user-management");
        }
        // TODO: 3/28/2022 Coach portal
        if (teamMember.getEmployeeType().equals("Coach")) {
            modelAndView.setViewName("coach/coach-employee-coaching-form-management");
        }
        session.setAttribute("member", teamMember);
        modelAndView.addObject("members", members);
        return modelAndView;
    }

    @Transactional
    @PostMapping("/user-update/{id}")
    public ModelAndView updateUser(@PathVariable("id") Long id, @ModelAttribute TeamMember teamMember) {
        ModelAndView modelAndView = new ModelAndView();
        teamMemberService.update(id, teamMember);
        List<TeamMember> members = teamMemberService.getAll();
        modelAndView.setViewName("hr/hr-user-management");
        modelAndView.addObject("members", members);
        return modelAndView;
    }

}
