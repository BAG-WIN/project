package ru.mtuci.project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mtuci.project.model.Project;
import ru.mtuci.project.repository.ProjectRepository;
import ru.mtuci.project.service.ProjectService;
import ru.mtuci.project.repository.DetailsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final DetailsRepository detailsRepository;

    @Override
    public void save(Project project) {
        project.getDetails().forEach(details -> {
            details.setProject(project);
            detailsRepository.save(details);
        });
        projectRepository.save(project);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(long id) {
        return projectRepository.findById(id).orElse(new Project());
    }
}
