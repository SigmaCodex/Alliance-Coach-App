package com.alliance.coaching.controller;

import com.alliance.coaching.entity.Action;
import com.alliance.coaching.entity.CoachingForm;
import com.alliance.coaching.entity.Employee;
import com.alliance.coaching.service.ActionService;
import com.alliance.coaching.service.CoachingFormService;
import com.alliance.coaching.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project Alliance-Coach-App
 * @created May 19, 2022 10:43 PM
 */

@Controller
@RequestMapping("/c")
@RequiredArgsConstructor
public class CoachingFormController {

    private final EmployeeService employeeService;
    private final CoachingFormService coachingFormService;
    private final ActionService actionService;

    // TODO: 5/19/2022 view all forms associated with Coach on their home page
    @GetMapping("/coach-home")
    public ModelAndView redirectHomeCoach() {
        ModelAndView modelAndView = new ModelAndView();
        List<CoachingForm> forms = coachingFormService.getAll();
        modelAndView.addObject("forms", forms);
        modelAndView.setViewName("coach/coach-employee-coaching-form-management");
        return modelAndView;
    }

    // TODO: 5/19/2022 create new form
    @PostMapping("/add-form")
    public ModelAndView createForm(@ModelAttribute CoachingForm coachingForm,
                                   @RequestParam String action,
                                   @RequestParam("file") MultipartFile file) throws IOException {
        coachingFormService.create(coachingForm, action, file);
        return new ModelAndView(new RedirectView("/c/coach-home"));
    }

    // TODO: 5/26/2022 add new action plan by coach id
    @PostMapping("/add-action/{id}")
    public ModelAndView addNewAction(@PathVariable("id") Long id, @ModelAttribute Action action) {
        actionService.create(id, action);
        return new ModelAndView(new RedirectView("/c/view-action/" + id));
    }

    // TODO: 5/26/2022 update form
    @PostMapping("/update-form/{id}")
    public ModelAndView updateForm(@PathVariable("id") Long id,
                                   @ModelAttribute CoachingForm coachingForm,
                                   @RequestParam("file") MultipartFile file) throws IOException {
        coachingFormService.updateForm(id, coachingForm, file);
        return new ModelAndView(new RedirectView("/c/view-form/" + id));
    }

    // TODO: 5/26/2022 update action plan
    @PostMapping("/update-action/{id}/{formId}")
    public ModelAndView updateActionPlan(@PathVariable("id") Long id,
                                         @RequestParam String status,
                                         @RequestParam String actionPlan,
                                         @ModelAttribute Employee employee,
                                         @RequestParam MultipartFile file,
                                         @PathVariable("formId") Long formId) {
        actionService.update(id, status);
        actionService.sendEmail(employee, file, status, formId, actionPlan);
        return new ModelAndView(new RedirectView("/c/view-action/" + formId)) ;
    }
    
    // TODO: 5/20/2022 redirect to page for creating form
    @GetMapping("/form")
    public String formView() {
        return "coach/coach-create-employee-coaching-form";
    }

    // TODO: 5/19/2022 view selected form
    @GetMapping("/view-form/{id}")
    public ModelAndView viewForm(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        CoachingForm coachingForm = coachingFormService.getById(id);
        List<Action> actionList = actionService.getList(coachingForm.getId());
        int currentProgress = actionService.currentProgress(coachingForm.getId());
        modelAndView.addObject("form", coachingForm);
        modelAndView.addObject("actions", actionList);
        modelAndView.addObject("currentProgress", currentProgress);
        modelAndView.setViewName("coach/coach-view-employee-form");
        return modelAndView;
    }

    // TODO: 5/26/2022 view all action plan by coaching id
    @GetMapping("/view-action/{id}")
    public ModelAndView viewActions(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("formId", id);
        modelAndView.addObject("actions", actionService.getList(id));
        modelAndView.addObject("currentProgress", actionService.currentProgress(id));
        modelAndView.setViewName("coach/coach-action-plan-management");
        return modelAndView;
    }

    // TODO: 5/26/2022 view form ready to update
    @GetMapping("/update/{id}")
    public ModelAndView updateReadyForm(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("form", coachingFormService.getById(id));
        modelAndView.setViewName("coach/coach-update-employee-coaching-form");
        return modelAndView;
    }

    // TODO: 5/25/2022 delete selected form
    @GetMapping("/delete-form/{id}")
    public String deleteForm(@PathVariable("id") Long id) {
        coachingFormService.delete(id);
        return "redirect:/c/coach-home";
    }

    // TODO: 5/26/2022 delete action plan
    @GetMapping("/delete-action/{id}/{formId}")
    public String deleteAction(@PathVariable("id") Long id, @PathVariable("formId") Long formId) {
        actionService.delete(id);
        return "redirect:/c/view-action/" + formId;
    }

    // TODO: 5/26/2022 update coach information
    @PostMapping("/update-coach/{id}")
    public String updateCoach(@PathVariable("id") Long id, @ModelAttribute Employee employee, HttpSession httpSession) {
        employeeService.update(id, employee);
        httpSession.setAttribute("employee", employeeService.getById(id));
        return "redirect:/c/coach-home";
    }

}
