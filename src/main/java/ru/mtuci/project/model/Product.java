package ru.mtuci.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private boolean is_blocked;
}
