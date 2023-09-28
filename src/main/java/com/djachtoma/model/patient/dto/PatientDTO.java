package com.djachtoma.model.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO implements Comparable<PatientDTO> {

    private String id;
    private String name;
    private String surname;
    private LocalDateTime dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String idCardSeriesNumber;
    private String city;
    private String zipCode;
    private String address;

    @Override
    public int compareTo(PatientDTO o) {
        return Integer.compare(this.hashCode(), o.hashCode());
    }
}
