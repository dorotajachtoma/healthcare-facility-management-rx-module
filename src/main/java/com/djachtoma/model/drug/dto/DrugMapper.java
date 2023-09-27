package com.djachtoma.model.drug.dto;

import com.djachtoma.model.drug.Drug;

public class DrugMapper {

    private static Drug toEntity(DrugDTO dto) {
        return Drug.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}
