package com.djachtoma.model.patient;


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

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("patient")
public class Patient extends Person implements Serializable {

    @Id
    private String id;

    @Builder
    public Patient(String name, String surname, LocalDateTime dateOfBirth, Gender gender, IDCard idCard, PhoneNumber phoneNumber, Address address, String id) {
        super(name, surname, dateOfBirth, gender, idCard, phoneNumber, address);
        this.id = id;
    }
}
