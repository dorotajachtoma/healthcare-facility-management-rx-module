package com.djachtoma.repository;

import com.djachtoma.model.prescription.Prescription;
import org.neo4j.springframework.data.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends ReactiveNeo4jRepository<Prescription, String> {

}
