package com.solid.coaching.controller;

import com.solid.coaching.entity.Employee;
import com.solid.coaching.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 19, 2022 4:25 PM
 */

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/")
    public void addNewEmployee(HttpServletRequest request, ModelMap map) {
        // TODO: 3/19/2022 map the employee details for view 
    }
    
    @GetMapping("/")
    public List<Employee> getEmployees() {
        // TODO: 3/19/2022 return all employee 
        return null;
    }
    
    @GetMapping("/{id}")
    public String getEmployee(@PathVariable("id") Long id) {
        // TODO: 3/19/2022 get employee by id 
        return null;
    }

    // TODO: 3/19/2022 consume json data 
    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable("id") Long id) {
        // TODO: 3/19/2022 update employee details 
    }
    
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        // TODO: 3/19/2022 delete employee details 
    }
    
}
