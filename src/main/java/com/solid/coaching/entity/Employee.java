package com.solid.coaching.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 19, 2022 3:40 PM
 */

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
