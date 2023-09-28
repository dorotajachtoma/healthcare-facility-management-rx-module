package com.djachtoma.model.patient.dto;

import com.djachtoma.model.patient.Patient;
import com.djachtoma.reference.entity.model.Address;
import com.djachtoma.reference.entity.model.Gender;
import com.djachtoma.reference.entity.model.IDCard;
import com.djachtoma.reference.entity.model.PhoneNumber;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public static PatientDTO toDTO(Patient patient) {
        return PatientDTO.builder()
                .id(patient.getId())
                .name(patient.getName())
                .surname(patient.getSurname())
                .gender(patient.getGender().name())
                .dateOfBirth(patient.getDateOfBirth())
                .phoneNumber(patient.getPhoneNumber().getNumber())
                .idCardSeriesNumber(patient.getIdCard().getSeriesNumber())
                .city(patient.getAddress().getCity())
                .zipCode(patient.getAddress().getZipCode())
                .address(patient.getAddress().getAddress())
                .build();
    }

    public static Patient toEntity(PatientDTO patientDTO) {
        return Patient.builder()
                .name(patientDTO.getName())
                .surname(patientDTO.getSurname())
                .dateOfBirth(patientDTO.getDateOfBirth())
                .gender(Gender.valueOf(patientDTO.getGender()))
                .idCard(IDCard.builder()
                        .seriesNumber(patientDTO.getIdCardSeriesNumber())
                        .build())
                .phoneNumber(PhoneNumber.builder()
                        .number(patientDTO.getPhoneNumber())
                        .build())
                .address(Address.builder()
                        .city(patientDTO.getCity())
                        .zipCode(patientDTO.getZipCode())
                        .address(patientDTO.getAddress())
                        .build())
                .build();
    }


}
