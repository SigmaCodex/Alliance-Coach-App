package com.alliance.coaching.service;

import com.alliance.coaching.entity.Action;
import com.alliance.coaching.entity.CoachingForm;
import com.alliance.coaching.repository.ActionRepo;
import com.alliance.coaching.repository.CoachingFormRepo;
import com.alliance.coaching.util.FileUpload;
import org.apache.commons.io.FilenameUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project Alliance-Coach-App
 * @created May 19, 2022 10:45 PM
 */

@Service
@RequiredArgsConstructor
public class CoachingFormService {

    private final CoachingFormRepo coachingFormRepo;
    private final ActionRepo actionRepo;

    // TODO: 5/19/2022 create new form
    public void create(CoachingForm coachingForm, String action, MultipartFile file) throws IOException {
        String fileName = coachingForm.getSupervisor().getId()
                + "-"
                + coachingForm.getSupervisor().getLastName()
                + "_" + coachingForm.getCreatedAt()
                + "." + FilenameUtils.getExtension(file.getOriginalFilename());
        coachingForm.setAttachedFile(fileName);
        Long id = coachingFormRepo.save(coachingForm).getId();
        // TODO: 5/25/2022 setup attached file
        String uploadDir = "src/main/resources/files/form-file/" + coachingForm.getSupervisor().getId();
        FileUpload.uploadFile(uploadDir, fileName, file);
        // TODO: 5/25/2022 save action plans delimited by new line
        String[] actions = action.split("\\R");
        createActionPlan(id, actions);
    }

    // TODO: 5/25/2022 save action plan
    public void createActionPlan(Long id, String[] actions) {
        CoachingForm coachingForm = coachingFormRepo.findById(id).get();
        for (String actionPlan : actions) {
            Action action = new Action();
            action.setForm(coachingForm);
            action.setActionPlan(actionPlan);
            actionRepo.save(action);
        }
    }

    // TODO: 5/19/2022 get form by id
    public CoachingForm getById(Long id) {
        return coachingFormRepo.findById(id).get();
    }

    // TODO: 5/19/2022 get all forms
    public List<CoachingForm> getAll() {
        return coachingFormRepo.findAll();
    }

    // TODO: 5/25/2022 delete form
    public void delete(Long id) {
        coachingFormRepo.deleteById(id);
        // TODO: 5/25/2022 if cascade does not work, delete by brute force
    }

}
