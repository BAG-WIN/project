package ru.mtuci.project.repository;

import ru.mtuci.project.model.Role;
import ru.mtuci.project.model.Trial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
