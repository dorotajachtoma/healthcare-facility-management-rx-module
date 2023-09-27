package com.djachtoma.model;

import com.djachtoma.model.drug.Drug;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "prescription")
public class Prescription {

    @Id
    private String id;
    private String code;
    private Physician physician;
    private Patient patient;
    private Set<Drug> drugs;
}
