package com.alliance.coaching.service;

import com.alliance.coaching.entity.DesiredOutcome;
import com.alliance.coaching.repository.DesiredOutcomeRepository;
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
public class DesiredOutcomeService {

    private final DesiredOutcomeRepository desiredOutcomeRepository;

    // TODO: 3/26/2022 create new desired outcome
    public DesiredOutcome create(DesiredOutcome desiredOutcome) {
        return desiredOutcomeRepository.save(desiredOutcome);
    }

    // TODO: 3/26/2022 get all desired outcome by coaching form id
    public List<DesiredOutcome> getAllDesiredOutcomeByCoachingFormId(Long id) {
        return desiredOutcomeRepository.findAllByCoachingFormId(id);
    }

    // TODO: 3/26/2022 update desired outcome
    public void update(Long id, DesiredOutcome desiredOutcome) {
        DesiredOutcome currentDesiredOutcome = desiredOutcomeRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("Desired outcome not found"));
        // TODO: 3/26/2022 validate new desired outcome content
        // this will set new data to old desired outcome
        currentDesiredOutcome.setDesiredOutcome(desiredOutcome.getDesiredOutcome());
        desiredOutcomeRepository.save(currentDesiredOutcome);
    }

    // TODO: 3/26/2022 delete desired outcome
    public void delete(Long id) {
        desiredOutcomeRepository.deleteById(id);
    }
}
