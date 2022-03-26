package com.alliance.coaching.repository;

import com.alliance.coaching.entity.Timeline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 26, 2022 3:10 PM
 */

@Repository
public interface TimelineRepository extends JpaRepository<Timeline, Long> {

    List<Timeline> findAllByCoachingFormId(Long id);

}
