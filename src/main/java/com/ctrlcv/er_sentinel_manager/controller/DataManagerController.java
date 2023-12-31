package com.ctrlcv.er_sentinel_manager.controller;


import com.ctrlcv.er_sentinel_manager.data.dto.ERoomResponseDto;
import com.ctrlcv.er_sentinel_manager.data.dto.ESevereResponseDto;
import com.ctrlcv.er_sentinel_manager.data.dto.EquipmentResponseDto;
import com.ctrlcv.er_sentinel_manager.data.dto.MessageResponseDto;
import com.ctrlcv.er_sentinel_manager.data.entity.Hospital;
import com.ctrlcv.er_sentinel_manager.service.DataManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class DataManagerController {

    @Autowired
    private DataManagerService DataManagerService;


    @GetMapping("/hospital")
    public ResponseEntity<List<Hospital>> getAllHospital() {
        List<Hospital> hospitals = DataManagerService.getAllHospital();
        return new ResponseEntity<>(hospitals, HttpStatus.OK);
    }

    @GetMapping("/hospital/{dutyId}/equipment")
    public ResponseEntity<EquipmentResponseDto> getHospitalEquipment(@RequestParam String dutyId) {
        EquipmentResponseDto equipmentResponseDto = DataManagerService.getEquipmentInfo(dutyId);
        return new ResponseEntity<>(equipmentResponseDto, HttpStatus.OK);
    }

    @GetMapping("/hospital/{dutyId}/message")
    public ResponseEntity<List<MessageResponseDto>> getHospitalMessage(@RequestParam String dutyId){
        List<MessageResponseDto> messageResponseDtoList = DataManagerService.getEmergencyMessage(dutyId);
        return new ResponseEntity<>(messageResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/hospital/{dutyId}/emergency")
    public ResponseEntity<ERoomResponseDto> getEmergencyInfo(@RequestParam String dutyId){
        ERoomResponseDto eRoomResponseDto = DataManagerService.getEmergencyRoom(dutyId);
        return new ResponseEntity<>(eRoomResponseDto, HttpStatus.OK);
    }

    @GetMapping("/hospital/{dutyId}/servere")
    public ResponseEntity<ESevereResponseDto> getSevereInfo(@RequestParam String dutyId){
        ESevereResponseDto eSevereResponseDto = DataManagerService.getEmergencySevere(dutyId);
        return new ResponseEntity<>(eSevereResponseDto, HttpStatus.OK);
    }
}
