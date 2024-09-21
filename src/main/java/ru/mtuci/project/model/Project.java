package ru.mtuci.project.model;

import jakarta.persistence.;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Colomn
    private int number;

    @OneToOne
    @MapsId
    //@Colomn(nullable = false)
    private ProjectDetails details;
}

//подключить бд, создать две таблички: создать "Пользователя" (логин, пароль, id), создать сущность "Лицензии" (дата создания, имя, ключ ативации). Зависимость один к одному
