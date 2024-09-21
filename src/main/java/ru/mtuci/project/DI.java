package ru.mtuci.project;

import ru.mtuci.project.model.Project;

// внедрение зависимости, пример:
public class DI {
    private Project project;

    public DI(Project project) {
        this.project = project;
    }
}
