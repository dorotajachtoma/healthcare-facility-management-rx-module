package com.djachtoma.model.drug.dto;

import com.djachtoma.model.drug.Drug;
import com.djachtoma.model.substance.dto.SubstanceMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class DrugMapper {

    public static Drug toEntity(DrugDTO dto) {
        return Drug.builder()
                .id(dto.getId())
                .name(dto.getName())
                .substances(Objects.nonNull(dto.getSubstances()) ? dto.getSubstances().stream()
                        .map(s -> SubstanceMapper.toEntity(s))
                        .collect(Collectors.toSet()) : Collections.emptySet())
                .build();
    }

    public static DrugDTO toDTO(Drug drug) {
        return DrugDTO.builder()
                .id(drug.getId())
                .name(drug.getName())
                .substances(Objects.nonNull(drug.getSubstances()) ? drug.getSubstances().stream()
                        .map(s -> SubstanceMapper.toDTO(s))
                        .collect(Collectors.toSet()) : Collections.emptySet())
                .build();
    }


}
