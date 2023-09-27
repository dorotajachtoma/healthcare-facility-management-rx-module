package com.djachtoma.model.physician.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class PhysicianDTO implements Comparable<PhysicianDTO> {

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
    private String title;
    private Set<String> specializations;

    @Override
    public int compareTo(PhysicianDTO o) {
        return Integer.compare(this.hashCode(), o.hashCode());
    }
}
