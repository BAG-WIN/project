package ru.mtuci.project.repository;

import ru.mtuci.project.model.License;
import ru.mtuci.project.model.LicenseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseTypeRepository extends JpaRepository<LicenseType, Long> {

}