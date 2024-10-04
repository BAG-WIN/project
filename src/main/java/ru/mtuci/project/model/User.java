package ru.mtuci.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "licence")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String date;

    @Column
    private String name;

    @Column
    private String key;
}
