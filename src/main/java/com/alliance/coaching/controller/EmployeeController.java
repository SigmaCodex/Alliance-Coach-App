package com.alliance.coaching.controller;

import com.alliance.coaching.entity.Employee;
import com.alliance.coaching.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project Alliance-Coach-App
 * @created May 19, 2022 10:14 PM
 */

@Controller
@RequestMapping("/c")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // TODO: 5/19/2022 view all users on hr home page/dashboard
    @GetMapping("/hr-home")
    public ModelAndView redirectHomeHR() {
        ModelAndView modelAndView = new ModelAndView();
        List<Employee> employees = employeeService.getAll();
        modelAndView.addObject("employees", employees);
        modelAndView.setViewName("hr/hr-user-management");
        return modelAndView;
    }

    // TODO: 5/19/2022 register an employee and redirect back to home
    @PostMapping("/add-employee")
    public ModelAndView createEmployee(@ModelAttribute Employee employee) {
        employeeService.create(employee);
        return new ModelAndView(new RedirectView("/c/hr-home"));
    }

    // TODO: 5/19/2022 login employee using email and password
    @PostMapping("/login")
    @ResponseBody
    public String loginEmployee(@ModelAttribute Employee employee, HttpSession httpSession) {
        Employee loginEmployee = employeeService.loginEmployee(employee.getEmail(), employee.getPassword());
        if(loginEmployee != null){
            httpSession.setAttribute("employee", loginEmployee);
            if (loginEmployee.getEmployeeType().equals("Coach")) {
                return "Coach";
            }
            if(loginEmployee.getEmployeeType().equals("HR")){
                return "HR";
            }
        }
        return "invalid";
    }

    // TODO: 5/19/2022 update an existing employee record
    @PostMapping("/update-employee/{id}")
    public ModelAndView updateEmployee(@PathVariable("id") Long id, @ModelAttribute Employee employee, HttpSession httpSession) {
        employeeService.update(id, employee);
        httpSession.setAttribute("employee", employeeService.getById(id));
        return new ModelAndView(new RedirectView("/c/hr-home"));
    }

    // TODO: 5/27/2022 update an existing employee record from cards
    @PostMapping("/update-card-employee/{id}")
    public ModelAndView updateEmployeeCard(@PathVariable("id") Long id, @ModelAttribute Employee employee) {
        employeeService.update(id, employee);
        return new ModelAndView(new RedirectView("/c/hr-home"));
    }

    // TODO: 5/19/2022 delete an employee record
    @GetMapping("/delete-employee/{id}")
    public ModelAndView deleteEmployee(@PathVariable("id") Long id) {
        employeeService.delete(id);
        return new ModelAndView(new RedirectView("/c/hr-home"));
    }

}
