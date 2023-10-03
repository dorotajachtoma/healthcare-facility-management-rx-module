package com.djachtoma.model.refund.dto;

import com.djachtoma.model.drug.dto.DrugDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RefundDTO {

    private String id;
    private String code;
    private BigDecimal refundPercentage;
    private boolean isRefundByGovernment;

}
