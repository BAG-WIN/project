package ru.mtuci.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mtuci.project.model.Project;

// пример конфигурации:
@Configuration
public class Config {

    @Bean
    public DI di() {
        return new DI(new Project());
    }
}
