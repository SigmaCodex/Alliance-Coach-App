package com.alliance.coaching.repository;

import com.alliance.coaching.entity.ActionPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 26, 2022 3:06 PM
 */

@Repository
public interface ActionPlanRepository extends JpaRepository<ActionPlan, Long> {

    List<ActionPlan> findAllByCoachingFormId(Long id);

}
