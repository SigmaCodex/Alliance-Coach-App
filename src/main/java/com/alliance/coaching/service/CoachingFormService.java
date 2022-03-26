package com.alliance.coaching.service;

import com.alliance.coaching.entity.CoachingForm;
import com.alliance.coaching.repository.CoachingFormRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 26, 2022 3:11 PM
 */

@Service
@RequiredArgsConstructor
public class CoachingFormService {

    private final CoachingFormRepository coachingFormRepository;

    // TODO: 3/26/2022 create new coaching form
    public CoachingForm create(CoachingForm coachingForm) {
        return coachingFormRepository.save(coachingForm);
    }

    // TODO: 3/26/2022 get coaching form by id
    public CoachingForm getById(Long id) {
        if (coachingFormRepository.findById(id).isPresent()) {
            return coachingFormRepository.findById(id).get();
        }
        throw new IllegalStateException("Coaching form not found");
    }

    // TODO: 3/26/2022 get all coaching form by coach id
    public List<CoachingForm> getAllCoachingFormByCoachId(Long id) {
        return coachingFormRepository.findAllByCoachId(id);
    }

    // TODO: 3/26/2022 get all coaching form, this may be applicable to HR only
    public List<CoachingForm> getAll() {
        return coachingFormRepository.findAll();
    }

    // TODO: 3/26/2022 update coaching form
    public void update(Long id, CoachingForm coachingForm) {
        CoachingForm currentCoachingForm = coachingFormRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("Coaching form not found"));
        // TODO: 3/26/2022 validate new coaching content
        // this will set new data to old action plan
        currentCoachingForm.setTopicArea(coachingForm.getTopicArea());
        currentCoachingForm.setBenefit(coachingForm.getBenefit());
        coachingFormRepository.save(currentCoachingForm);
    }

    // TODO: 3/26/2022 delete coaching form
    public void delete(Long id) {
        coachingFormRepository.deleteById(id);
    }
}
