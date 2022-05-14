package com.alliance.coaching.service;

import com.alliance.coaching.entity.Timeline;
import com.alliance.coaching.repository.TimelineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 26, 2022 3:12 PM
 */

@Service
@RequiredArgsConstructor
public class TimelineService {

    private final TimelineRepository timelineRepository;

    // TODO: 3/26/2022 create new timeline
    public Timeline create(Timeline timeline) {
        return timelineRepository.save(timeline);
    }

    // TODO: 3/26/2022 get all timeline by coaching form id
    public List<Timeline> getAllTimelineByCoachingFormId(Long id) {
        return timelineRepository.findAllByCoachingFormId(id);
    }

    // TODO: 3/26/2022 update timeline
    public void update(Long id, Timeline timeline) {
        Timeline currentTimeline = timelineRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("Timeline not found"));
        // TODO: 3/26/2022 validate new timeline content
        // this is to set new data to old timeline
        currentTimeline.setNote(timeline.getNote());
        currentTimeline.setDate(timeline.getDate());
        timelineRepository.save(currentTimeline);
    }

    // TODO: 3/26/2022 delete timeline
    public void delete(Long id) {
        timelineRepository.deleteById(id);
    }

}
