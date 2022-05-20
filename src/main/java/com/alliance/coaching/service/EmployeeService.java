package com.alliance.coaching.service;

import com.alliance.coaching.entity.Employee;
import com.alliance.coaching.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project Alliance-Coach-App
 * @created May 19, 2022 9:50 PM
 */

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    // TODO: 5/19/2022 create new employee
    public Employee create(Employee employee) {
        // TODO: 5/19/2022 check if employee record (email) already exist/taken
        if (employeeRepo.findByEmail(employee.getEmail()).isPresent()) {
            throw new IllegalStateException("Sorry, email already taken.");
        }
        // TODO: 5/19/2022 hash password (bcrypt algo)
        employee.setPassword(new BCryptPasswordEncoder().encode(employee.getPassword()));
        return employeeRepo.save(employee);
    }

    // TODO: 5/19/2022 get employee by id
    public Employee getById(Long id) {
        return employeeRepo.findById(id).get();
    }

    // TODO: 5/19/2022 get all employee
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    // TODO: 5/19/2022 update employee record
    public void update(Long id, Employee employee) {
        // TODO: 5/19/2022 find the existing record of employee to be updated
        Employee currentRecord = employeeRepo.findById(id).get();
        // TODO: 5/19/2022 check new entry if not empty and to be updated
        if (employee.getFirstName() != null)
            currentRecord.setFirstName(employee.getFirstName());
        if (employee.getLastName() != null)
            currentRecord.setLastName(employee.getLastName());
        if (employee.getContactNo() != null)
            currentRecord.setContactNo(employee.getContactNo());
        if (employee.getEmployeeType() != null)
            currentRecord.setEmployeeType(employee.getEmployeeType());
        if (employee.getRolePosition() != null)
            currentRecord.setRolePosition(employee.getRolePosition());
        employeeRepo.save(currentRecord);
    }

    // TODO: 5/19/2022 delete employee by id
    public void delete(Long id) {
        employeeRepo.deleteById(id);
    }

    // TODO: 5/19/2022 login employee using their credentials
    public Employee loginEmployee(String email, String password) {
        if (employeeRepo.findByEmail(email).isPresent()) {
            Employee employee = employeeRepo.findByEmail(email).get();
            // TODO: 5/19/2022 check if password match with hashed
            if (new BCryptPasswordEncoder().matches(password, employee.getPassword())) {
                return employee;
            }
            throw new IllegalStateException("Incorrect password.");
        }
        throw new IllegalStateException("Employee does not exist.");
    }

}
