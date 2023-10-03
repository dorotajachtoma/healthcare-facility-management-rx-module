package com.djachtoma.model.refund;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "refund")
public class Refund {

    @Id
    private String id;
    private String code;
    private BigDecimal refundPercentage;
    private boolean isRefundByGovernment;
}
