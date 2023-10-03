package com.djachtoma.model.drug;

import com.djachtoma.model.refund.Refund;
import com.djachtoma.model.substance.Substance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "drug")
public class Drug {

    @Id
    private String id;
    private String name;
    private Set<Substance> substances;
    private Refund refund;
}
