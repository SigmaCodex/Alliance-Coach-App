package com.alliance.coaching.controller;

import com.alliance.coaching.entity.TeamMember;
import com.alliance.coaching.service.TeamMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
        teamMemberService.create(teamMember);
        return new ModelAndView(new RedirectView("/c/user-management"));
    }

    // TODO: 3/28/2022 login team member
    @PostMapping("/user-management")
    public ModelAndView loginTeamMember(@ModelAttribute TeamMember login, HttpSession session) {
        TeamMember teamMember = teamMemberService.loginEmployee(login.getUsername(), login.getPassword());
        session.setAttribute("member", teamMember);
        // TODO: 3/28/2022 Coach portal by condition
        if (teamMember.getEmployeeType().equals("Coach")) {
            return new ModelAndView(new RedirectView("/c/coaching-form-management"));
        }
        // TODO: 3/28/2022 HR portal as default
        return new ModelAndView(new RedirectView("/c/user-management"));
    }

    @Transactional
    @PostMapping("/user-update/{id}")
    public ModelAndView updateUser(@PathVariable("id") Long id, @ModelAttribute TeamMember teamMember) {
        teamMemberService.update(id, teamMember);
        return new ModelAndView(new RedirectView("/c/user-management"));
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id) {
        teamMemberService.delete(id);
        return new ModelAndView(new RedirectView("/c/user-management"));
    }

    @GetMapping("/user-management")
    public ModelAndView redirectHome() {
        ModelAndView modelAndView = new ModelAndView();
        List<TeamMember> members = teamMemberService.getAll();
        modelAndView.setViewName("hr/hr-user-management");
        modelAndView.addObject("members", members);
        return modelAndView;
    }

    @GetMapping("/coaching-form-management")
    public ModelAndView redirectForms() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("coach/coach-employee-coaching-form-management");
        return modelAndView;
    }

}
