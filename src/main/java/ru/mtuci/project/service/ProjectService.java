package ru.mtuci.project.service;

import ru.mtuci.project.model.Project;

import java.util.List;

public interface ProjectService {

    void save(Project project);

    List<Project> findAll();

    Project findById(long id);
}
