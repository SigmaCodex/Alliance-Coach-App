package com.alliance.coaching.repository;

import com.alliance.coaching.entity.CoachingForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project Alliance-Coach-App
 * @created May 19, 2022 9:46 PM
 */

@Repository
public interface CoachingFormRepo extends JpaRepository<CoachingForm, Long> {
}
