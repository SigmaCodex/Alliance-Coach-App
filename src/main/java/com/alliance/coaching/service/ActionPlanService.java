package com.alliance.coaching.service;

import com.alliance.coaching.entity.ActionPlan;
import com.alliance.coaching.repository.ActionPlanRepository;
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
public class ActionPlanService {

    private final ActionPlanRepository actionPlanRepository;

    // TODO: 3/26/2022 create new action plan
    public ActionPlan create(ActionPlan actionPlan) {
        return actionPlanRepository.save(actionPlan);
    }

    // TODO: 3/26/2022 get all action plan by coaching form id
    public List<ActionPlan> getAllActionPlanByCoachingFormId(Long id) {
        return actionPlanRepository.findAllByCoachingFormId(id);
    }

    // TODO: 3/26/2022 update action plan
    public void update(Long id, ActionPlan actionPlan) {
        ActionPlan currentActionPlan = actionPlanRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("Action plan not found"));
        // TODO: 3/26/2022 validate new action plan content
        // this will set new data to old action plan
        currentActionPlan.setActionPlan(actionPlan.getActionPlan());
        actionPlanRepository.save(currentActionPlan);
    }

    // TODO: 3/26/2022 delete action plan
    public void delete(Long id) {
        actionPlanRepository.deleteById(id);
    }

}
