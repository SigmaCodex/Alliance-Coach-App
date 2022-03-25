package com.solid.coaching.service;

import com.solid.coaching.entity.Employee;
import com.solid.coaching.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 19, 2022 4:21 PM
 */

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    // TODO: 3/19/2022 update employee

    public void deleteEmployeeDetails(Long id) {
        employeeRepository.deleteById(id);
    }

}
