package com.djachtoma.model.drug;

import com.djachtoma.model.refund.Refund;
import com.djachtoma.model.substance.Substance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.springframework.data.core.schema.GeneratedValue;
import org.neo4j.springframework.data.core.schema.Node;
import org.neo4j.springframework.data.core.schema.Relationship;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Data
@Builder
@Node("DRUG")
@AllArgsConstructor
@NoArgsConstructor
public class Drug {

    @Id
    @GeneratedValue
    private String id;
    private String name;
    @Relationship(type = "SUBSTANCES", direction = Relationship.Direction.INCOMING)
    private Set<Substance> substances;
    private Refund refund;
}


