package com.djachtoma.model.constant;

import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

@Getter
@RedisHash(value = "specialization")
public enum Specialization {

    INTERNAL_MEDICINE("Internal Medicine"),
    FAMILY_MEDICINE("Family Medicine"),
    ANESTHESIOLOGY("Anesthesiology"),
    SURGERY("Surgery"),
    EMERGENCY_MEDICINE("Emergency Medicine"),
    DERMATOLOGY("Dermatology"),
    PEDIATRICS("Pediatrics"),
    NEUROLOGY("Neurology"),
    PSYCHIATRY("Psychiatry"),
    GYNAECOLOGY("Gynaecology"),
    PATHOLOGY("Pathology"),
    PHYSICAL_THERAPY("Physical Therapy"),
    GENERAL_SURGERY("General Surgery"),
    ONCOLOGY("Oncology"),
    RADIOLOGY("Radiology"),
    OPHTHALMOLOGY("Ophthalmology"),
    UROLOGY("Urology"),
    NUCLEAR_MEDICINE("Nuclear Medicine"),
    IMMUNOLOGY("Immunology"),
    PREVENTIVE_HEALTHCARE("Preventive Healthcare"),
    OTOLARYNGOLOGY("Otolaryngology"),
    ;


    private final String description;

    Specialization(String description) {
        this.description = description;
    }
}
