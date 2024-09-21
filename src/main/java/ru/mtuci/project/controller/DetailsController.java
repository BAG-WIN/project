package ru.mtuci.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mtuci.project.model.ProjectDetails;
import ru.mtuci.project.repository.DetailsRepository;

@RestController
@RequestMapping("/details")
@RequiredArgsConstructor
public class DetailsController {

    private final DetailsRepository detailsRepository;

    @PostMapping
    public void save(ProjectDetails details) {
        detailsRepository.save(details);
    }
}
