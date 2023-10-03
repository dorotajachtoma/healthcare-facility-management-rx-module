package com.djachtoma.model.refund.dto;

import com.djachtoma.model.refund.Refund;
import org.springframework.stereotype.Component;


@Component
public class RefundMapper {

    public static Refund toEntity(RefundDTO dto) {
        return Refund.builder()
                .id(dto.getId())
                .code(dto.getCode())
                .refundPercentage(dto.getRefundPercentage())
                .isRefundByGovernment(dto.isRefundByGovernment())
                .build();
    }

    public static RefundDTO toDTO(Refund refund) {
        return RefundDTO.builder()
                .id(refund.getId())
                .code(refund.getCode())
                .refundPercentage(refund.getRefundPercentage())
                .isRefundByGovernment(refund.isRefundByGovernment())
                .build();
    }

}
