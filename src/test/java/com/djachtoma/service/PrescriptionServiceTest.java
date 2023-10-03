package com.djachtoma.service;

import com.djachtoma.exception.PrescriptionNotFoundException;
import com.djachtoma.model.prescription.Prescription;
import com.djachtoma.model.prescription.dto.PrescriptionDTO;
import com.djachtoma.model.prescription.dto.PrescriptionMapper;
import com.djachtoma.repository.PrescriptionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;
import java.util.Set;

import static com.djachtoma.util.TestObjectUtil.getPrescription;
import static com.djachtoma.util.TestObjectUtil.getPrescriptionDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class PrescriptionServiceTest {

    @InjectMocks
    private PrescriptionService prescriptionService;

    @Mock
    private PrescriptionRepository prescriptionRepository;

    @Mock
    private PrescriptionMapper prescriptionMapper;

    @Test
    public void getFacilities_shouldReturnAllFacilities() {
        //given
        Set<Prescription> prescriptions = Set.of(getPrescription());
        when(prescriptionRepository.findAll()).thenReturn(prescriptions);

        //when
        prescriptionService.getPrescriptions();

        //then
        verify(prescriptionRepository, times(1)).findAll();
    }

    @Test
    public void getPrescription_shouldReturnPrescriptionById() {
        //given
        Prescription prescription = getPrescription();
        PrescriptionDTO prescriptionDTO = getPrescriptionDTO();
        when(prescriptionRepository.findById(prescription.getId())).thenReturn(Optional.of(prescription));

        //when
        prescriptionService.getPrescription(prescription.getId());

        //then
        verify(prescriptionRepository, times(1)).findById(prescription.getId());
    }

    @Test
    public void getPrescription_shouldThrowExceptionPrescriptionNotFound() {
        //given
        Prescription prescription = getPrescription();

        //when
        Throwable throwable = catchThrowable(() -> prescriptionService.getPrescription(prescription.getId()));

        //then
        assertThat(throwable).isInstanceOf(PrescriptionNotFoundException.class);
        assertThat(throwable).hasMessageContaining("Prescription with provided ID: ID does not exist.");
    }

    @Test
    public void createPrescription_shouldReturnPrescription() {
        //given
        PrescriptionDTO prescriptionDTO = getPrescriptionDTO();
        Prescription prescription = getPrescription();
        when(prescriptionRepository.findById(prescription.getId())).thenReturn(Optional.of(prescription));
        when(prescriptionRepository.save(prescription)).thenReturn(prescription);

        //when
        prescriptionService.updatePrescription(prescription.getId(), prescriptionDTO);

        //then
        verify(prescriptionRepository, times(1)).save(prescription);
    }

    @Test
    public void updatePrescription_shouldReturnUpdatedPrescription() {
        //given
        PrescriptionDTO prescriptionDTO = getPrescriptionDTO();
        Prescription prescription = getPrescription();
        when(prescriptionRepository.save(prescription)).thenReturn(prescription);

        //when
        prescriptionService.createPrescription(prescriptionDTO);

        //then
        verify(prescriptionRepository, times(1)).save(prescription);
    }

    @Test
    public void updatePrescription_shouldThrowException() {
        //given
        PrescriptionDTO prescriptionDTO = getPrescriptionDTO();
        Prescription prescription = getPrescription();

        //when
        Throwable throwable = catchThrowable(() -> prescriptionService.getPrescription(prescription.getId()));

        //then
        assertThat(throwable).isInstanceOf(PrescriptionNotFoundException.class);
        assertThat(throwable).hasMessageContaining("Prescription with provided ID: ID does not exist.");
    }

    @Test
    public void deletePrescription_shouldDelete() {
        //given
        Prescription prescription = getPrescription();
        when(prescriptionRepository.findById(prescription.getId())).thenReturn(Optional.of(prescription));

        //when
        prescriptionService.deletePrescription(prescription.getId());

        //then
        verify(prescriptionRepository, times(1)).delete(prescription);
    }

    @Test
    public void deletePrescription_shouldThrowException() {
        //given
        Prescription prescription = getPrescription();

        //when
        Throwable throwable = catchThrowable(() -> prescriptionService.getPrescription(prescription.getId()));

        //then
        assertThat(throwable).isInstanceOf(PrescriptionNotFoundException.class);
        assertThat(throwable).hasMessageContaining("Prescription with provided ID: ID does not exist.");
    }
}
