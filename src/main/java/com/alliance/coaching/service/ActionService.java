package com.alliance.coaching.service;

import com.alliance.coaching.entity.Action;
import com.alliance.coaching.entity.CoachingForm;
import com.alliance.coaching.entity.Employee;
import com.alliance.coaching.repository.ActionRepo;
import com.alliance.coaching.repository.CoachingFormRepo;
import com.alliance.coaching.util.Email;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project Alliance-Coach-App
 * @created May 26, 2022 12:13 AM
 */

@Service
@RequiredArgsConstructor
public class ActionService {

    private final CoachingFormRepo coachingFormRepo;
    private final ActionRepo actionRepo;
    private final Email email;

    // TODO: 5/26/2022 add new action plan with coaching form id
    public void create(Long id, Action action) {
        CoachingForm coachingForm = coachingFormRepo.findById(id).get();
        action.setForm(coachingForm);
        actionRepo.save(action);
    }

    // TODO: 5/26/2022 update current action plan
    public void update(Long id, String status) {
        Action currentRecord = actionRepo.findById(id).get();
        String splitStatus = status.split("%")[0];
        currentRecord.setStatus(Integer.parseInt(splitStatus));
        currentRecord.setLastModified(new Timestamp(System.currentTimeMillis()));
        actionRepo.save(currentRecord);
    }

    // TODO: 5/27/2022 send email to HR for the evidence
    public void sendEmail(Employee employee, MultipartFile file, String status, Long formId, String actionPlan) {
        String fileName = employee.getId()
                + "-"
                + employee.getLastName()
                + "-update-action-plan"
                + "." + FilenameUtils.getExtension(file.getOriginalFilename());
        email.setSenderEmail(employee.getEmail());
        email.setSender(employee.getFirstName() +  " " + employee.getLastName());
        email.setSenderContact(employee.getContactNo());
        email.setFile(file);
        email.setFileName(fileName);
        email.setTo("hackmetry01@gmail.com");
        email.sendUpdateAction(status, formId, actionPlan);
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
        return progress / actionRepo.findAllByFormId(id).size();
    }

    // TODO: 5/26/2022 delete action using id 
    public void delete(Long id) {
        actionRepo.deleteById(id);
    }

}
