package com.djachtoma.model.refund;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.springframework.data.core.schema.GeneratedValue;
import org.neo4j.springframework.data.core.schema.Node;
import org.springframework.data.annotation.Id;
import java.math.BigDecimal;

@Data
@Builder
@Node("REFUND")
@AllArgsConstructor
@NoArgsConstructor
public class Refund {

    @Id
    @GeneratedValue
    private String id;
    private String code;
    private BigDecimal refundPercentage;
    private boolean isRefundByGovernment;
}
