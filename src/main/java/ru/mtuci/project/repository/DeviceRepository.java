package ru.mtuci.project.repository;

import ru.mtuci.project.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}