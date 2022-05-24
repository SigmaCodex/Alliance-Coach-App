package com.alliance.coaching.service;

import com.alliance.coaching.entity.CoachingForm;
import com.alliance.coaching.repository.CoachingFormRepo;
import com.alliance.coaching.util.FileUpload;
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

    // TODO: 5/19/2022 create new form
    public void create(CoachingForm coachingForm, MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        coachingForm.setAttachedFile(fileName);
        Long id = coachingFormRepo.save(coachingForm).getId();
        String uploadDir = "src/main/resources/files/form-file/" + id;
        FileUpload.uploadFile(uploadDir, fileName, file);
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
