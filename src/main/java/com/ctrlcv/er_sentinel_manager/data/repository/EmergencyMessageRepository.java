package com.ctrlcv.er_sentinel_manager.data.repository;

import com.ctrlcv.er_sentinel_manager.data.entity.EmergencyMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyMessageRepository extends JpaRepository<EmergencyMessage, Integer> {
}
