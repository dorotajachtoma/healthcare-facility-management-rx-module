package com.djachtoma.model.physician.dto;

import com.djachtoma.model.constant.Specialization;
import com.djachtoma.model.constant.Title;
import com.djachtoma.model.physician.Physician;
import com.djachtoma.reference.entity.model.Address;
import com.djachtoma.reference.entity.model.Gender;
import com.djachtoma.reference.entity.model.IDCard;
import com.djachtoma.reference.entity.model.PhoneNumber;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class PhysicianMapper {
    
    public static PhysicianDTO toDTO(Physician physician) {
        return PhysicianDTO.builder()
                .id(physician.getId())
                .name(physician.getName())
                .surname(physician.getSurname())
                .gender(physician.getGender().name())
                .dateOfBirth(physician.getDateOfBirth())
                .phoneNumber(physician.getPhoneNumber().getNumber())
                .idCardSeriesNumber(physician.getIdCard().getSeriesNumber())
                .city(physician.getAddress().getCity())
                .zipCode(physician.getAddress().getZipCode())
                .address(physician.getAddress().getAddress())
                .specializations(Objects.nonNull(physician.getSpecialization()) ? physician.getSpecialization().stream()
                        .map(Specialization::name)
                        .collect(Collectors.toSet()) : null)
                .title(physician.getTitle().name())
                .build();
    }

    public static Physician toEntity(PhysicianDTO physicianDTO) {
        return Physician.builder()
                .name(physicianDTO.getName())
                .surname(physicianDTO.getSurname())
                .dateOfBirth(physicianDTO.getDateOfBirth())
                .gender(Gender.valueOf(physicianDTO.getGender()))
                .idCard(IDCard.builder()
                        .seriesNumber(physicianDTO.getIdCardSeriesNumber())
                        .build())
                .phoneNumber(PhoneNumber.builder()
                        .number(physicianDTO.getPhoneNumber())
                        .build())
                .address(Address.builder()
                        .city(physicianDTO.getCity())
                        .zipCode(physicianDTO.getZipCode())
                        .address(physicianDTO.getAddress())
                        .build())
                .specialization(physicianDTO.getSpecializations().stream()
                        .map(specialization -> Specialization.valueOf(specialization))
                        .collect(Collectors.toSet()))
                .title(Title.valueOf(physicianDTO.getTitle()))
                .build();
    }
}
