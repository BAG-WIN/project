package ru.mtuci.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mtuci.project.model.License;

public interface LicenseRepository extends JpaRepository<License, Long> {

}