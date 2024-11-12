package ru.mtuci.project.repository;

import ru.mtuci.project.model.Device;
import ru.mtuci.project.model.DeviceLicense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceLicenseRepository extends JpaRepository<DeviceLicense, Long> {
}
