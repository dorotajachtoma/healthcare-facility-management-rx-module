package com.djachtoma.model.refund.dto;

import com.djachtoma.model.drug.dto.DrugMapper;
import com.djachtoma.model.refund.Refund;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class RefundMapper {

    public static Refund toEntity(RefundDTO dto) {
        return Refund.builder()
                .id(dto.getId())
                .code(dto.getCode())
                .refundPercentage(dto.getRefundPercentage())
                .drug(Objects.nonNull(dto.getDrug()) ? DrugMapper.toEntity(dto.getDrug()) : null)
                .isRefundByGovernment(dto.isRefundByGovernment())
                .build();
    }

    public static RefundDTO toDTO(Refund refund) {
        return RefundDTO.builder()
                .id(refund.getId())
                .code(refund.getCode())
                .refundPercentage(refund.getRefundPercentage())
                .drug(Objects.nonNull(refund.getDrug()) ? DrugMapper.toDTO(refund.getDrug()) : null)
                .isRefundByGovernment(refund.isRefundByGovernment())
                .build();
    }

}
