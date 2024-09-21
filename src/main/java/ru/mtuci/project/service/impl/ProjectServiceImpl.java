package ru.mtuci.project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mtuci.project.model.Project;
import ru.mtuci.project.repository.ProjectRepository;
import ru.mtuci.project.service.ProjectService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public void save(Project project) {
        projectRepository.save(project);
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

}
