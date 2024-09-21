package ru.mtuci.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "details")
public class ProjectDetails {

    @Id
    @GeneratedValue
    private Long id;

    @Colomn(name = "location", nullable = false)
    private String location;
}
