package ru.mtuci.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mtuci.project.model.ApplicationUser;
import ru.mtuci.project.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<ApplicationUser> findByEmail(String email)
}
