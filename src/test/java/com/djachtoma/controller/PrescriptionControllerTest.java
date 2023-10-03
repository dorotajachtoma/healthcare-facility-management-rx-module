package com.djachtoma.controller;

import com.djachtoma.configuration.RedisContainerSetup;
import com.djachtoma.configuration.TestSetup;
import com.djachtoma.model.prescription.dto.PrescriptionDTO;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDateTime;
import java.util.List;

import static com.djachtoma.util.TestObjectUtil.getPrescriptionDTO;
import static org.assertj.core.api.Assertions.assertThat;

public class PrescriptionControllerTest extends TestSetup {

    private static final String NAME = "NAME";
    private static final String SURNAME = "SURNAME";
    private static final LocalDateTime DATE_OF_BIRTH = LocalDateTime.of(2023, 5, 10, 0, 0);
    private static final String PHONE_NUMBER = "552-123-565";
    private static final String ID_CARD_SERIES_NUMBER = "DFG2312";
    private static final String CITY = "CITY";
    private static final String ZIP_CODE = "ZIP_CODE";
    private static final String STREET = "STREET";

    @Autowired
    private WebTestClient client;

    private RedisContainerSetup redisContainerSetup;

    @BeforeEach
    public void setup() {
        redisContainerSetup.start();
    }

    @Test
    public void getAllPrescriptionsShouldReturnAllPrescription() {
        //given
        PrescriptionDTO prescriptionDTO = getPrescriptionDTO();
        this.client.post()
                .uri("/api/Prescription")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(prescriptionDTO)
                .exchange()
                .expectBody(PrescriptionDTO.class)
                .returnResult()
                .getResponseBody();

        //when
        List<PrescriptionDTO> result = this.client.get()
                .uri("/api/Prescription")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectBodyList(PrescriptionDTO.class)
                .returnResult()
                .getResponseBody();

        //then
        PrescriptionDTO created = result.get(0);

    }

    @Test
    public void getPrescriptionShouldReturnPrescriptionDTO() {
        //given
        PrescriptionDTO prescriptionDTO = getPrescriptionDTO();
        PrescriptionDTO created = this.client.post()
                .uri("/api/Prescription")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(prescriptionDTO)
                .exchange()
                .expectBody(PrescriptionDTO.class)
                .returnResult()
                .getResponseBody();

        //when
        PrescriptionDTO result = this.client.get()
                .uri("/api/Prescription/" + created.getId())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectBody(PrescriptionDTO.class)
                .returnResult()
                .getResponseBody();

        //then

    }

    @Test
    public void createPrescriptionShouldReturnPrescriptionDTO() {
        //given
        PrescriptionDTO prescriptionDTO = getPrescriptionDTO();

        //when
        PrescriptionDTO created = this.client.post()
                .uri("/api/Prescription")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(prescriptionDTO)
                .exchange()
                .expectBody(PrescriptionDTO.class)
                .returnResult()
                .getResponseBody();

        //then

    }

    @Test
    public void updatePrescriptionShouldReturnPrescriptionDTO() {
        //given
        PrescriptionDTO prescriptionDTO = getPrescriptionDTO();
        PrescriptionDTO created = this.client.post()
                .uri("/api/Prescription")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(prescriptionDTO)
                .exchange()
                .expectBody(PrescriptionDTO.class)
                .returnResult()
                .getResponseBody();

        //when

        PrescriptionDTO result = this.client.patch()
                .uri("/api/Prescription/" + created.getId())
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(prescriptionDTO)
                .exchange()
                .expectBody(PrescriptionDTO.class)
                .returnResult()
                .getResponseBody();
        //then
        assertThat(result).isEqualTo(created);
    }

    @Test
    public void deletePrescriptionShouldDeletePrescription() {
        //given
        PrescriptionDTO prescriptionDTO = getPrescriptionDTO();
        PrescriptionDTO created = this.client.post()
                .uri("/api/Prescription")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(prescriptionDTO)
                .exchange()
                .expectBody(PrescriptionDTO.class)
                .returnResult()
                .getResponseBody();

        //when
        this.client.delete()
                .uri("/api/Prescription/" + created.getId())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk();
    }

}
