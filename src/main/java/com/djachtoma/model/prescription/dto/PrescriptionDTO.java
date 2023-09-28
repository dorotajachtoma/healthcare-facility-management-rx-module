package com.djachtoma.model.prescription.dto;

import com.djachtoma.model.drug.dto.DrugDTO;
import com.djachtoma.model.patient.dto.PatientDTO;
import com.djachtoma.model.physician.dto.PhysicianDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDTO {

    private String id;
    private String code;
    private PhysicianDTO physician;
    private PatientDTO patient;
    private Set<DrugDTO> drugs;
}
