package com.djachtoma.model.substance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubstanceDTO {

    private String id;
    private String name;
    private Set<String> categories;
}
