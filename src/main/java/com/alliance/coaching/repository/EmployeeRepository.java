package com.alliance.coaching.repository;

import com.alliance.coaching.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 26, 2022 3:05 PM
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
