package com.djachtoma.model.substance;

import com.djachtoma.model.constant.Category;
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
@Node("CATEGORY")
@AllArgsConstructor
@NoArgsConstructor
public class Substance {

    @Id
    @GeneratedValue
    private String id;
    private String name;
    @Relationship(type = "CATEGORIES", direction = Relationship.Direction.INCOMING)
    private Set<Category> categories;
}

