package ru.mtuci.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.project.model.Project;
import ru.mtuci.project.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/")
    @PreAuthorize("hasAnyAuthority('read')")
    public List<Project> findAll() {
        return projectService.findAll();
    }

    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('modification')")
    public void save(@RequestBody Project project) {
        projectService.save(project);
    }
} 
