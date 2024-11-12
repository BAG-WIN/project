package ru.mtuci.project.controller;

import lombok.RequiredArgsConstructor;
import ru.mtuci.project.model.ProjectDetails;
import ru.mtuci.project.repository.DetailsRepository;
import ru.mtuci.project.model.Project;
import ru.mtuci.project.model.Details;
import ru.mtuci.project.repository.DetailsRepository;
import ru.mtuci.project.service.ProjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/details")
@RequiredArgsConstructor
public class DetailsController {

    private final DetailsRepository detailsRepository;
    private final ProjectService projectService;

    @PostMapping("/{project_id}/save")
    public void save(@PathVariable(value = "project_id") Long projectId,
                     @RequestBody Details details) {
        Project project = projectService.findById(projectId);
        details.setProject(project);
        detailsRepository.save(details);
    }
}
