package com.ctrlcv.er_sentinel_manager.data.repository;

import com.ctrlcv.er_sentinel_manager.data.entity.EmergencyRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyRoomRepository extends JpaRepository<EmergencyRoom, Integer> {
}
