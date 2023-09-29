package com.djachtoma.service;

import com.djachtoma.exception.PrescriptionNotFoundException;
import com.djachtoma.model.drug.dto.DrugMapper;
import com.djachtoma.model.patient.dto.PatientMapper;
import com.djachtoma.model.physician.dto.PhysicianMapper;
import com.djachtoma.model.prescription.Prescription;
import com.djachtoma.model.prescription.dto.PrescriptionDTO;
import com.djachtoma.model.prescription.dto.PrescriptionMapper;
import com.djachtoma.repository.PrescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.djachtoma.utils.ObjectUtils.nullSafeUpdate;


@Service
@RequiredArgsConstructor
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    public Flux<PrescriptionDTO> getPrescriptions() {
        Iterable<PrescriptionDTO> prescriptions = Stream.of(prescriptionRepository.findAll().iterator())
                .map(prescription -> PrescriptionMapper.toDTO(prescription.next()))
                .collect(Collectors.toList());
        return Flux.fromIterable(prescriptions);
    }

    public Mono<PrescriptionDTO> getPrescription(String id) {
        return Mono.just(PrescriptionMapper.toDTO(getPrescriptionById(id)));
    }

    @Transactional
    public Mono<PrescriptionDTO> createPrescription(PrescriptionDTO prescriptionDTO) {
        Prescription prescription = PrescriptionMapper.toEntity(prescriptionDTO);
        prescriptionRepository.save(prescription);
        return Mono.just(PrescriptionMapper.toDTO(prescription));
    }

    @Transactional
    public void deletePrescription(String id) {
        Prescription prescription = getPrescriptionById(id);
        prescriptionRepository.delete(prescription);
    }

    @Transactional
    public Mono<PrescriptionDTO> updatePrescription(String id, PrescriptionDTO PrescriptionDTO) {
        Prescription Prescription = getPrescriptionById(id);
        updatePrescriptionEntity(Prescription, PrescriptionDTO);
        return Mono.just(PrescriptionMapper.toDTO(Prescription));
    }


    private Prescription getPrescriptionById(String id) {
        return prescriptionRepository.findById(id)
                .orElseThrow(() -> new PrescriptionNotFoundException(String.format("Prescription with provided ID: %s does not exist.", id)));
    }

    private void updatePrescriptionEntity(Prescription prescription, PrescriptionDTO prescriptionDTO) {
        nullSafeUpdate(prescriptionDTO.getCode(), prescriptionDTO::getCode, prescription::setCode);
        nullSafeUpdate(prescriptionDTO.getPatient(), prescriptionDTO::getPatient, x -> prescription.setPatient(PatientMapper.toEntity(x)));
        nullSafeUpdate(prescriptionDTO.getPhysician(), prescriptionDTO::getPhysician, x -> prescription.setPhysician(PhysicianMapper.toEntity(x)));
        nullSafeUpdate(prescriptionDTO.getDrugs(), prescriptionDTO::getDrugs, x -> prescription.setDrugs(prescriptionDTO.getDrugs().stream()
                .map(d -> DrugMapper.toEntity(d))
                .collect(Collectors.toSet())));
        prescriptionRepository.save(prescription);
    }


}
