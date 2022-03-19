package com.solid.coaching.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 19, 2022 3:40 PM
 */

@Entity
@Table(name = "employee")
public class Employee {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username", columnDefinition = "VARCHAR(50)")
    private String username;

    @Column(name = "password", columnDefinition = "VARCHAR(100)")
    private String password;

    @Column(name = "first_name", columnDefinition = "VARCHAR(50)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "VARCHAR(50)")
    private String lastName;

    @Column(name = "contact_no", columnDefinition = "VARCHAR(15)")
    private String contactNo;

    @Column(name = "emp_type", columnDefinition = "VARCHAR(50)")
    private String employeeType;

    public Employee() {
    }

    public Employee(String username, String password, String firstName, String lastName, String contactNo, String employeeType) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        this.employeeType = employeeType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }
}
