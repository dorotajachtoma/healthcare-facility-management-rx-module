package com.djachtoma.model.substance.dto;

import com.djachtoma.model.constant.Category;
import com.djachtoma.model.substance.Substance;

import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

public class SubstanceMapper {

    public static Substance toEntity(SubstanceDTO dto) {
        return Substance.builder()
                .id(dto.getId())
                .name(dto.getName())
                .categories(Objects.nonNull(dto.getCategories()) ? dto.getCategories().stream()
                        .map(s -> Category.valueOf(s))
                        .collect(Collectors.toSet()) : Collections.emptySet())
                .build();
    }

    public static SubstanceDTO toDTO(Substance substance) {
        return SubstanceDTO.builder()
                .id(substance.getId())
                .name(substance.getName())
                .categories(Objects.nonNull(substance.getCategories()) ? substance.getCategories().stream()
                        .map(Category::name)
                        .collect(Collectors.toSet()) : Collections.emptySet())
                .build();
    }
}
