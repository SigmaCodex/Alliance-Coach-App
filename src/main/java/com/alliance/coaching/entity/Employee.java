package com.alliance.coaching.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project Alliance-Coach-App
 * @created May 19, 2022 9:01 PM
 */

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private Long id;

    @Column(name = "email", columnDefinition = "VARCHAR (50) UNIQUE NOT NULL")
    private String email;

    @Column(name = "password", columnDefinition = "VARCHAR (100) NOT NULL")
    private String password;

    @Column(name = "first_name", columnDefinition = "VARCHAR (50) NOT NULL")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "VARCHAR (50) NOT NULL")
    private String lastName;

    @Column(name = "contact_no", columnDefinition = "VARCHAR (20)")
    private String contactNo;

    @Column(name = "employee_type", columnDefinition = "VARCHAR (50) NOT NULL")
    private String employeeType;

    @Column(name = "role_position", columnDefinition = "VARCHAR (100) NOT NULL")
    private String rolePosition;

    @Transient
    private String fullName;

    @Transient
    public String getFullName() {
        return firstName + ' ' + lastName;
    }

}
