package com.ctrlcv.er_sentinel_manager.service;

import com.ctrlcv.er_sentinel_manager.data.dto.HospitalResponseDto;
import com.ctrlcv.er_sentinel_manager.data.entity.EmergencyRoomSevereCapacityInfo;
import com.ctrlcv.er_sentinel_manager.data.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DataManagerService {

    @Autowired
    private HospitalRepository hospitalRepository;
    private HospitalEquipmentRepository hospitalEquipmentRepository;
    private EmergencyRoomRepository emergencyRoomRepository;
    private EmergencyMessageRepository emergencyMessageRepository;
    private EmergencyRoomSevereCapacityInfoRepository emergencyRoomSevereCapacityInfoRepository;

    public HospitalResponseDto getHospital(){

    }

}
