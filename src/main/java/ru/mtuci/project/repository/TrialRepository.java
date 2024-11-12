package ru.mtuci.project.repository;

import ru.mtuci.project.model.LicenseHistory;
import ru.mtuci.project.model.Trial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrialRepository extends JpaRepository<Trial, Long> {
}
