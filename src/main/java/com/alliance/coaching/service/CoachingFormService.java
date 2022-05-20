package com.alliance.coaching.service;

import com.alliance.coaching.entity.CoachingForm;
import com.alliance.coaching.repository.CoachingFormRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project Alliance-Coach-App
 * @created May 19, 2022 10:45 PM
 */

@Service
@RequiredArgsConstructor
public class CoachingFormService {

    private final CoachingFormRepo coachingFormRepo;

    // TODO: 5/19/2022 create new form
    public CoachingForm create(CoachingForm coachingForm) {
        return coachingFormRepo.save(coachingForm);
    }

    // TODO: 5/19/2022 get form by id
    public CoachingForm getById(Long id) {
        return coachingFormRepo.findById(id).get();
    }

    // TODO: 5/19/2022 get all forms
    public List<CoachingForm> getAll() {
        return coachingFormRepo.findAll();
    }

}
