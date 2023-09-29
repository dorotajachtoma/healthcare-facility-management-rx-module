package com.djachtoma.controller;

import com.djachtoma.model.prescription.dto.PrescriptionDTO;
import com.djachtoma.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PrescriptionController {
    
    private final PrescriptionService prescriptionService;

    @GetMapping
    public Flux<PrescriptionDTO> getPrescriptions() {
        log.info("%s is invoked.", this.getClass().getName() + ".getPrescriptions");
        return prescriptionService.getPrescriptions();
    }

    @GetMapping("/{id}")
    public Mono<PrescriptionDTO> getPrescription(@PathVariable String id) {
        log.info("%s is invoked.", this.getClass().getName() + ".getPrescription");
        return prescriptionService.getPrescription(id);
    }

    @PostMapping
    public Mono<PrescriptionDTO> createPrescription(@RequestBody PrescriptionDTO PrescriptionDTO) {
        log.info("%s is invoked.", this.getClass().getName() + ".createPrescription");
        return prescriptionService.createPrescription(PrescriptionDTO);
    }

    @PatchMapping("/{id}")
    public Mono<PrescriptionDTO> updatePrescription(@PathVariable String id, @RequestBody PrescriptionDTO PrescriptionDTO) {
        log.info("%s is invoked.", this.getClass().getName() + ".updatePrescription");
        return prescriptionService.updatePrescription(id, PrescriptionDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePrescription(@PathVariable String id) {
        log.info("%s is invoked.", this.getClass().getName() + ".deletePrescription");
        prescriptionService.deletePrescription(id);
    }
}
