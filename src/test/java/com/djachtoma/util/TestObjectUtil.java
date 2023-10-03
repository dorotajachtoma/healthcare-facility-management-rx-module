package com.djachtoma.util;


import com.djachtoma.model.constant.Category;
import com.djachtoma.model.constant.Specialization;
import com.djachtoma.model.constant.Title;
import com.djachtoma.model.drug.Drug;
import com.djachtoma.model.drug.dto.DrugDTO;
import com.djachtoma.model.patient.Patient;
import com.djachtoma.model.patient.dto.PatientDTO;
import com.djachtoma.model.physician.Physician;
import com.djachtoma.model.physician.dto.PhysicianDTO;
import com.djachtoma.model.prescription.Prescription;
import com.djachtoma.model.prescription.dto.PrescriptionDTO;
import com.djachtoma.model.refund.Refund;
import com.djachtoma.model.refund.dto.RefundDTO;
import com.djachtoma.model.substance.Substance;
import com.djachtoma.model.substance.dto.SubstanceDTO;
import com.djachtoma.reference.entity.model.Gender;
import com.djachtoma.reference.entity.model.IDCard;
import com.djachtoma.reference.entity.model.PhoneNumber;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@UtilityClass
public class TestObjectUtil {

    public static final String ID = "ID";
    public static final String CODE = "CODE";
    public static final String NAME = "NAME";
    public static final String CITY = "CITY";
    public static final String ZIP_CODE = "ZIP_CODE";
    public static final String ADDRESS = "ADDRESS";
    public static final String SURNAME = "SURNAME";
    public static final String PHONE_NUMBER = "PHONE_NUMBER";
    public static final String ID_CARD_SERIES_NUMBER = "ID_CARD_SERIES_NUMBER";
    public static final LocalDateTime DATE_OF_BIRTH = LocalDateTime.of(2023, 1, 1, 1, 1, 0);
    public static final BigDecimal REFUND_PERCENTAGE = BigDecimal.valueOf(75);

    public static PrescriptionDTO getPrescriptionDTO() {
        return PrescriptionDTO.builder()
                .id(ID)
                .code(CODE)
                .physician(getPhysicianDTO())
                .patient(getPatientDTO())
                .drugs(Set.of(getDrugDTO()))
                .build();
    }

    public static Prescription getPrescription() {
        return Prescription.builder()
                .id(ID)
                .code(CODE)
                .physician(getPhysician())
                .patient(getPatient())
                .drugs(Set.of(getDrug()))
                .build();
    }

    public static DrugDTO getDrugDTO() {
        return DrugDTO.builder()
                .id(ID)
                .name(NAME)
                .substances(Set.of(getSubstanceDTO()))
                .refund(getRefundDTO())
                .build();
    }

    public static Drug getDrug() {
        return Drug.builder()
                .id(ID)
                .name(NAME)
                .substances(Set.of(getSubstance()))
                .refund(getRefund())
                .build();
    }

    public static SubstanceDTO getSubstanceDTO() {
        return SubstanceDTO.builder()
                .id(ID)
                .name(NAME)
                .categories(Set.of(Category.BENZODIAZEPINE.name()))
                .build();
    }

    public static Substance getSubstance() {
        return Substance.builder()
                .id(ID)
                .name(NAME)
                .categories(Set.of(Category.BENZODIAZEPINE))
                .build();
    }

    public static RefundDTO getRefundDTO() {
        return RefundDTO.builder()
                .id(ID)
                .code(CODE)
                .refundPercentage(REFUND_PERCENTAGE)
                .isRefundByGovernment(true)
                .build();
    }

    public static Refund getRefund() {
        return Refund.builder()
                .id(ID)
                .code(CODE)
                .refundPercentage(REFUND_PERCENTAGE)
                .isRefundByGovernment(true)
                .build();
    }

    public static PatientDTO getPatientDTO() {
        return PatientDTO.builder()
                .id(ID)
                .name(NAME)
                .surname(SURNAME)
                .dateOfBirth(DATE_OF_BIRTH)
                .gender(Gender.MALE.name())
                .idCardSeriesNumber(ID_CARD_SERIES_NUMBER)
                .phoneNumber(PHONE_NUMBER)
                .address(ADDRESS)
                .city(CITY)
                .zipCode(ZIP_CODE)
                .build();
    }

    public static PhysicianDTO getPhysicianDTO() {
        return PhysicianDTO.builder()
                .id(ID)
                .name(NAME)
                .surname(SURNAME)
                .dateOfBirth(DATE_OF_BIRTH)
                .gender(Gender.MALE.name())
                .idCardSeriesNumber(ID_CARD_SERIES_NUMBER)
                .phoneNumber(PHONE_NUMBER)
                .address(ADDRESS)
                .city(CITY)
                .zipCode(ZIP_CODE)
                .specializations(Set.of(Specialization.EMERGENCY_MEDICINE.name()))
                .title(Title.FO.name())
                .build();
    }

    public static Patient getPatient() {
        return Patient.builder()
                .id(ID)
                .name(NAME)
                .surname(SURNAME)
                .dateOfBirth(DATE_OF_BIRTH)
                .gender(Gender.MALE)
                .idCard(IDCard.builder()
                        .seriesNumber(ID_CARD_SERIES_NUMBER)
                        .build())
                .phoneNumber(PhoneNumber.builder()
                        .number(PHONE_NUMBER)
                        .build())
                .address(com.djachtoma.reference.entity.model.Address.builder()
                        .address(ADDRESS)
                        .city(CITY)
                        .zipCode(ZIP_CODE)
                        .build())
                .build();
    }

    public static Physician getPhysician() {
        return Physician.builder()
                .id(ID)
                .name(NAME)
                .surname(SURNAME)
                .dateOfBirth(DATE_OF_BIRTH)
                .gender(Gender.MALE)
                .idCard(IDCard.builder()
                        .seriesNumber(ID_CARD_SERIES_NUMBER)
                        .build())
                .phoneNumber(PhoneNumber.builder()
                        .number(PHONE_NUMBER)
                        .build())
                .address(com.djachtoma.reference.entity.model.Address.builder()
                        .address(ADDRESS)
                        .city(CITY)
                        .zipCode(ZIP_CODE)
                        .build())
                .specialization(Set.of(Specialization.EMERGENCY_MEDICINE))
                .title(Title.FO)
                .build();
    }


}
