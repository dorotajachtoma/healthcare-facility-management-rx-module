package com.djachtoma.model.prescription.dto;

import com.djachtoma.model.drug.dto.DrugMapper;
import com.djachtoma.model.patient.dto.PatientMapper;
import com.djachtoma.model.physician.dto.PhysicianMapper;
import com.djachtoma.model.prescription.Prescription;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class PrescriptionMapper {


    public static Prescription toEntity(PrescriptionDTO dto) {
        return Prescription.builder()
                .id(dto.getId())
                .code(dto.getCode())
                .physician(Objects.nonNull(dto.getPhysician()) ? PhysicianMapper.toEntity(dto.getPhysician()) : null)
                .patient(Objects.nonNull(dto.getPatient()) ? PatientMapper.toEntity(dto.getPatient()) : null)
                .drugs(Objects.nonNull(dto.getDrugs()) ? dto.getDrugs().stream()
                        .map(d -> DrugMapper.toEntity(d))
                        .collect(Collectors.toSet()) : Collections.emptySet())
                .build();
    }

    public static PrescriptionDTO toDTO(Prescription prescription) {
        return PrescriptionDTO.builder()
                .id(prescription.getId())
                .code(prescription.getCode())
                .physician(Objects.nonNull(prescription.getPhysician()) ? PhysicianMapper.toDTO(prescription.getPhysician()) : null)
                .patient(Objects.nonNull(prescription.getPatient()) ? PatientMapper.toDTO(prescription.getPatient()) : null)
                .drugs(Objects.nonNull(prescription.getDrugs()) ? prescription.getDrugs().stream()
                        .map(d -> DrugMapper.toDTO(d))
                        .collect(Collectors.toSet()) : Collections.emptySet())
                .build();
    }

}
