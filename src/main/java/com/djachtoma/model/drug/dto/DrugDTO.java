package com.djachtoma.model.drug.dto;


import com.djachtoma.model.refund.dto.RefundDTO;
import com.djachtoma.model.substance.dto.SubstanceDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DrugDTO {

    private String id;
    private String name;
    private Set<SubstanceDTO> substances;
    private RefundDTO refund;
}
