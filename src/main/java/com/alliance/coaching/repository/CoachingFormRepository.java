package com.alliance.coaching.repository;

import com.alliance.coaching.entity.CoachingForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 26, 2022 3:05 PM
 */

@Repository
public interface CoachingFormRepository extends JpaRepository<CoachingForm, Long> {

    List<CoachingForm> findAllByCoachId(Long id);

}
