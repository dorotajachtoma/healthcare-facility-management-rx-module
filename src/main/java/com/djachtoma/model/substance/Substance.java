package com.djachtoma.model.substance;

import com.djachtoma.model.constant.Category;
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
@RedisHash(value = "substance")
public class Substance {

    @Id
    private String id;
    private String name;
    private Set<Category> categories;
}
