package ru.mtuci.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProjectController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam String str) {
        return str;
    }
}
