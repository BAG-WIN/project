package ru.mtuci.project.controller;

import ru.mtuci.project.model.ApplicationUser;
import ru.mtuci.project.service.impl.UserDetailsServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final UserDetailsServiceImpl userDetailsService;

    @PostMapping
    public ResponseEntity<?> registration(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password
    ) {
       return ResponseEntity.ok("Регистрация успешно завершена");
    }
}
