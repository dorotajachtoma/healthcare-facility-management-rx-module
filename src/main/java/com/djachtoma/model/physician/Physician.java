package com.djachtoma.model.physician;

import com.djachtoma.model.constant.Specialization;
import com.djachtoma.model.constant.Title;
import com.djachtoma.reference.entity.model.Address;
import com.djachtoma.reference.entity.model.Gender;
import com.djachtoma.reference.entity.model.IDCard;
import com.djachtoma.reference.entity.model.Person;
import com.djachtoma.reference.entity.model.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "physician")
public class Physician extends Person {

    @Id
    private String id;
    private Set<Specialization> specialization;
    private Title title;

    @Builder
    public Physician(String name, String surname, LocalDateTime dateOfBirth, Gender gender, IDCard idCard, PhoneNumber phoneNumber, Address address, String id, Set<Specialization> specialization, Title title) {
        super(name, surname, dateOfBirth, gender, idCard, phoneNumber, address);
        this.id = id;
        this.specialization = specialization;
        this.title = title;
    }
}
