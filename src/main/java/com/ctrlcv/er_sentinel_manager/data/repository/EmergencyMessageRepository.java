package com.ctrlcv.er_sentinel_manager.data.repository;

import com.ctrlcv.er_sentinel_manager.data.entity.EmergencyMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmergencyMessageRepository extends JpaRepository<EmergencyMessage, Integer> {
    Optional<EmergencyMessage> findByHospital_DutyId(String dutyId);
    List<EmergencyMessage> findAllByHospital_DutyId(String dutyId);
}
