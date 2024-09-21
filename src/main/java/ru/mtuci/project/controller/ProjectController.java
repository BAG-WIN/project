package ru.mtuci.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.project.model.Project;
import ru.mtuci.project.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/")
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @PostMapping("/save")
    public void getModProject (@RequestBody Project project) {
        projectService.save(project);
    }
} 
