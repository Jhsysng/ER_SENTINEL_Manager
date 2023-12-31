package com.ctrlcv.er_sentinel_manager.service;

import com.ctrlcv.er_sentinel_manager.data.dto.*;
import com.ctrlcv.er_sentinel_manager.data.entity.*;
import com.ctrlcv.er_sentinel_manager.data.repository.*;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class DataManagerService {

    @Autowired
    private final HospitalRepository hospitalRepository;
    private final HospitalEquipmentRepository hospitalEquipmentRepository;
    private final EmergencyRoomRepository emergencyRoomRepository;
    private final EmergencyMessageRepository emergencyMessageRepository;
    private final EmergencyRoomSevereCapacityInfoRepository emergencyRoomSevereCapacityInfoRepository;

    public DataManagerService(HospitalRepository hospitalRepository, HospitalEquipmentRepository hospitalEquipmentRepository, EmergencyRoomRepository emergencyRoomRepository, EmergencyMessageRepository emergencyMessageRepository, EmergencyRoomSevereCapacityInfoRepository emergencyRoomSevereCapacityInfoRepository) {
        this.hospitalRepository = hospitalRepository;
        this.hospitalEquipmentRepository = hospitalEquipmentRepository;
        this.emergencyRoomRepository = emergencyRoomRepository;
        this.emergencyMessageRepository = emergencyMessageRepository;
        this.emergencyRoomSevereCapacityInfoRepository = emergencyRoomSevereCapacityInfoRepository;
    }

    public List<Hospital> getAllHospital(){
        log.info("[getAllHospital]");
        return hospitalRepository.findAll();
    }

    public EquipmentResponseDto getEquipmentInfo(String dutyId){
        log.info("[getEquipmentInfo] input dutyId:{}",dutyId);
        Optional<HospitalEquipment> hospitalEquipment=hospitalEquipmentRepository.findByHospital_DutyId(dutyId);

        if(hospitalEquipment.isPresent()){
            log.info("[getEquipmentInfo] hospitalEquipment Service do");
            EquipmentResponseDto equipmentResponseDto=new EquipmentResponseDto();
            equipmentResponseDto.setDutyId(hospitalEquipment.get().getHospital().getDutyId());
            equipmentResponseDto.setCT(hospitalEquipment.get().getCT());
            equipmentResponseDto.setMRI(hospitalEquipment.get().getMRI());
            equipmentResponseDto.setVentilator(hospitalEquipment.get().getVentilator());
            equipmentResponseDto.setVentilatorForChildren(hospitalEquipment.get().getVentilatorForChildren());
            equipmentResponseDto.setAngiographyMachine(hospitalEquipment.get().getAngiographyMachine());
            equipmentResponseDto.setCRRT(hospitalEquipment.get().getCRRT());
            equipmentResponseDto.setECMO(hospitalEquipment.get().getECMO());
            equipmentResponseDto.setHyperbaricOxygenTherapyUnit(hospitalEquipment.get().getHyperbaricOxygenTherapyUnit());
            equipmentResponseDto.setCentralTemperatureManagementCapable(hospitalEquipment.get().getCentralTemperatureManagementCapable());
            equipmentResponseDto.setAmbulance(hospitalEquipment.get().getAmbulance());
            equipmentResponseDto.setUpdateTime(hospitalEquipment.get().getUpdateTime());

            return equipmentResponseDto;
        }
        else{
            log.error("[getEquipmentInfo] hospitalEquipment is not present");
            throw new RuntimeException("hospitalEquipment is not present");
        }
    }

    public ERoomResponseDto getEmergencyRoom(String dutyId){
        log.info("[getEmergencyRoom] input dutyId:{}",dutyId);
        Optional<EmergencyRoom> emergencyRoom=emergencyRoomRepository.findByHospital_DutyId(dutyId);
        if(emergencyRoom.isPresent()){
            log.info("[getEmergencyRoom] emergencyRoom Service do");
            ERoomResponseDto eRoomResponseDto=new ERoomResponseDto();
            eRoomResponseDto.setDutyId(emergencyRoom.get().getHospital().getDutyId());
            eRoomResponseDto.setName(emergencyRoom.get().getName());
            eRoomResponseDto.setPhoneNumber(emergencyRoom.get().getPhoneNumber());
            eRoomResponseDto.setPediatricAvailableBeds(emergencyRoom.get().getPediatricAvailableBeds());
            eRoomResponseDto.setPediatricStandardBeds(emergencyRoom.get().getPediatricStandardBeds());
            eRoomResponseDto.setAdultAvailableBeds(emergencyRoom.get().getAdultAvailableBeds());
            eRoomResponseDto.setAdultStandardBeds(emergencyRoom.get().getAdultStandardBeds());
            eRoomResponseDto.setApiUpdateTime(emergencyRoom.get().getApiUpdateTime());
            eRoomResponseDto.setUpdateTime(emergencyRoom.get().getUpdateTime());

            return eRoomResponseDto;
        }
        else{
            log.error("[getEmergencyRoom] emergencyRoom is not present");
            throw new RuntimeException("emergencyRoom is not present");
        }
    }

    public ESevereResponseDto getEmergencySevere(String dutyId){
        log.info("[getEmergencySevere] input dutyId:{}",dutyId);
        Optional<EmergencyRoomSevereCapacityInfo> emergencyRoomSevereCapacityInfo=emergencyRoomSevereCapacityInfoRepository.findByHospital_DutyId(dutyId);
        if(emergencyRoomSevereCapacityInfo.isPresent()){
            log.info("[getEmergencySevere] emergencyRoomSevereCapacityInfo Service do");
            ESevereResponseDto eSevereResponseDto=new ESevereResponseDto();
            eSevereResponseDto.setDutyId(emergencyRoomSevereCapacityInfo.get().getHospital().getDutyId());
            eSevereResponseDto.setMyocardialInfarction(emergencyRoomSevereCapacityInfo.get().getMyocardialInfarction());
            eSevereResponseDto.setCerebralInfarction(emergencyRoomSevereCapacityInfo.get().getCerebralInfarction());
            eSevereResponseDto.setSubarachnoidHemorrhage(emergencyRoomSevereCapacityInfo.get().getSubarachnoidHemorrhage());
            eSevereResponseDto.setOtherBrainHemorrhage(emergencyRoomSevereCapacityInfo.get().getOtherBrainHemorrhage());
            eSevereResponseDto.setThoracicAorta(emergencyRoomSevereCapacityInfo.get().getThoracicAorta());
            eSevereResponseDto.setAbdominalAorta(emergencyRoomSevereCapacityInfo.get().getAbdominalAorta());
            eSevereResponseDto.setGallbladderDisease(emergencyRoomSevereCapacityInfo.get().getGallbladderDisease());
            eSevereResponseDto.setBileDuctDisease(emergencyRoomSevereCapacityInfo.get().getBileDuctDisease());
            eSevereResponseDto.setNonTraumaticAbdominalEmergency(emergencyRoomSevereCapacityInfo.get().getNonTraumaticAbdominalEmergency());
            eSevereResponseDto.setInfantIntestinalObstruction(emergencyRoomSevereCapacityInfo.get().getInfantIntestinalObstruction());
            eSevereResponseDto.setEmergencyGastrointestinalEndoscopy(emergencyRoomSevereCapacityInfo.get().getEmergencyGastrointestinalEndoscopy());
            eSevereResponseDto.setEmergencyGastrointestinalEndoscopyForChildren(emergencyRoomSevereCapacityInfo.get().getEmergencyGastrointestinalEndoscopyForChildren());
            eSevereResponseDto.setEmergencyBronchoscopy(emergencyRoomSevereCapacityInfo.get().getEmergencyBronchoscopy());
            eSevereResponseDto.setEmergencyBronchoscopyForChildren(emergencyRoomSevereCapacityInfo.get().getEmergencyBronchoscopyForChildren());
            eSevereResponseDto.setLowBirthWeightInfant(emergencyRoomSevereCapacityInfo.get().getLowBirthWeightInfant());
            eSevereResponseDto.setObstetricDelivery(emergencyRoomSevereCapacityInfo.get().getObstetricDelivery());
            eSevereResponseDto.setObstetricSurgery(emergencyRoomSevereCapacityInfo.get().getObstetricSurgery());
            eSevereResponseDto.setEmergencyGynecologicalSurgery(emergencyRoomSevereCapacityInfo.get().getEmergencyGynecologicalSurgery());
            eSevereResponseDto.setSevereBurns(emergencyRoomSevereCapacityInfo.get().getSevereBurns());
            eSevereResponseDto.setLimbReattachmentExtremities(emergencyRoomSevereCapacityInfo.get().getLimbReattachmentExtremities());
            eSevereResponseDto.setLimbReattachmentOther(emergencyRoomSevereCapacityInfo.get().getLimbReattachmentOther());
            eSevereResponseDto.setEmergencyDialysisHD(emergencyRoomSevereCapacityInfo.get().getEmergencyDialysisHD());
            eSevereResponseDto.setEmergencyDialysisCRRT(emergencyRoomSevereCapacityInfo.get().getEmergencyDialysisCRRT());
            eSevereResponseDto.setPsychiatry(emergencyRoomSevereCapacityInfo.get().getPsychiatry());
            eSevereResponseDto.setOphthalmicSurgery(emergencyRoomSevereCapacityInfo.get().getOphthalmicSurgery());
            eSevereResponseDto.setRadiologyVascularIntervention(emergencyRoomSevereCapacityInfo.get().getRadiologyVascularIntervention());
            eSevereResponseDto.setRadiologyVascularInterventionForChildren(emergencyRoomSevereCapacityInfo.get().getRadiologyVascularInterventionForChildren());
            eSevereResponseDto.setInfantIntestinalAge(emergencyRoomSevereCapacityInfo.get().getInfantIntestinalAge());
            eSevereResponseDto.setGastrointestinalEndoscopyAge(emergencyRoomSevereCapacityInfo.get().getGastrointestinalEndoscopyAge());
            eSevereResponseDto.setBronchoscopyAge(emergencyRoomSevereCapacityInfo.get().getBronchoscopyAge());
            eSevereResponseDto.setLowBirthWeightAge(emergencyRoomSevereCapacityInfo.get().getLowBirthWeightAge());
            eSevereResponseDto.setRadiologyAge(emergencyRoomSevereCapacityInfo.get().getRadiologyAge());
            eSevereResponseDto.setUpdateTime(emergencyRoomSevereCapacityInfo.get().getUpdateTime());


            return eSevereResponseDto;
        }
        else{
            log.error("[getEmergencySevere] emergencyRoomSevereCapacityInfo is not present");
            throw new RuntimeException("emergencyRoomSevereCapacityInfo is not present");
        }
    }

    public List<MessageResponseDto> getEmergencyMessage(String dutyId){
        log.info("[getEmergencyMessage] input dutyId:{}",dutyId);
        List<MessageResponseDto> messageResponseDtoList=emergencyMessageRepository.findAllByHospital_DutyId(dutyId).stream().map(MessageResponseDto::new).toList();
        return messageResponseDtoList;
    }

    /*
    @Override
    public ProductResponseDto getProduct(Long number){
        LOGGER.info("[getProduct] input number:{}",number);
        Product product=productRepository.findById(number).get();

        LOGGER.info("[getProduct] product number : {}, name : {}",product.getNumber(),product.getName());

        ProductResponseDto productResponseDto=new ProductResponseDto();
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());

        return productResponseDto;
    }*/
}
