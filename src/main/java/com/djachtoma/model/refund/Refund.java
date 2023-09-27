package com.djachtoma.model.refund;

import com.djachtoma.model.drug.Drug;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "refund")
public class Refund {

    @Id
    private String id;
    private String code;
    private BigDecimal refundPercentage;
    private Drug drug;
    private boolean isRefundByGovernment;
}
