package com.alliance.coaching.service;

import com.alliance.coaching.entity.Action;
import com.alliance.coaching.repository.ActionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project Alliance-Coach-App
 * @created May 26, 2022 12:13 AM
 */

@Service
@RequiredArgsConstructor
public class ActionService {

    private final ActionRepo actionRepo;

    // TODO: 5/26/2022 update action specific using id
    public void update(Long id, Action action) {
        Action currentRecord = actionRepo.findById(id).get();
        currentRecord.setActionPlan(action.getActionPlan());
        actionRepo.save(action);
    }

    // TODO: 5/26/2022 show all actions according to id of form
    public List<Action> getList(Long id) {
        return actionRepo.findAllByFormId(id);
    }

    // TODO: 5/26/2022 return progress indicator/number
    public int currentProgress(Long id) {
        int progress = 0;
        for (Action action : actionRepo.findAllByFormId(id)) {
            progress += action.getStatus();
        }
        return progress;
    }

    // TODO: 5/26/2022 delete action using id 
    public void delete(Long id) {
        actionRepo.deleteById(id);
    }

}
