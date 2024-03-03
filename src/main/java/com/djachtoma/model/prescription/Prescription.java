package com.djachtoma.model.prescription;

import com.djachtoma.model.drug.Drug;
import com.djachtoma.model.patient.Patient;
import com.djachtoma.model.physician.Physician;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.springframework.data.core.schema.GeneratedValue;
import org.neo4j.springframework.data.core.schema.Node;
import org.neo4j.springframework.data.core.schema.Relationship;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Node("PRESCRIPTION")
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {

    @Id
    @GeneratedValue
    private String id;
    private String code;
    @Relationship(type = "PRESCRIBER", direction = Relationship.Direction.INCOMING)
    private Physician physician;
    @Relationship(type = "PRESCRIBED_TO", direction = Relationship.Direction.INCOMING)
    private Patient patient;
    @Relationship(type = "DRUGS", direction = Relationship.Direction.INCOMING)
    private Set<Drug> drugs = new HashSet<>();

    @CreatedDate
    private LocalDateTime localDateTime;
}

