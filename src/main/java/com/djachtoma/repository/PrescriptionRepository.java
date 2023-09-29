package com.djachtoma.repository;

import com.djachtoma.model.prescription.Prescription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends CrudRepository<Prescription, String> {

}
