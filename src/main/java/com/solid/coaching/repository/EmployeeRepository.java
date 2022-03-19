package com.solid.coaching.repository;

import com.solid.coaching.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 19, 2022 4:19 PM
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
