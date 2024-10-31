package ru.mtuci.project.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users")
public class ApplicationUser {

    @Id
    @GeneratedValue
    private UUID id;

    private String username;

    private String password;

    private String email;

    @Enumerated(EnumType.STRING)
    private ApplicationRole role;
}
