package grid.capstone.service.patient_service.service;

import grid.capstone.dto.v1.PatientDTO;
import grid.capstone.service.patient_service.domain.Patient;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * @author Javaughn Stephenson
 * @since 15/06/2023
 */

public interface PatientService {

    /**
     * Get a specific patient based on the
     * patientId passed
     *
     * @param patientId
     * @return A patient object
     * @throws ResourceNotFoundException when the id cannot be found
     */
    Patient getPatient(Long patientId);

    /**
     * Save a patient to the database
     *
     * @param patientDTO patient DTO
     * @param doctorId id of the doctor
     * @return HttpStatus code
     */
    HttpStatus savePatient(PatientDTO patientDTO, Long doctorId);

    /**
     * Get all patients associate with a doctor
     * @param doctorId id of the doctor
     * @return list of patients
     */
    List<Patient> getAllPatients(Long doctorId);
}
