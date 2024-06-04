package grid.capstone.mapper;

import grid.capstone.dto.v1.PatientDTO;
import grid.capstone.service.patient_service.domain.Patient;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-04T05:25:13-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class PatientMapperImpl implements PatientMapper {

    @Override
    public Patient toEntity(PatientDTO patientDTO) {
        if ( patientDTO == null ) {
            return null;
        }

        Patient.PatientBuilder patient = Patient.builder();

        patient.username( patientDTO.getUsername() );
        patient.phoneNumber( patientDTO.getPhoneNumber() );
        patient.email( patientDTO.getEmail() );
        patient.age( patientDTO.getAge() );
        patient.bloodGroup( patientDTO.getBloodGroup() );
        patient.religion( patientDTO.getReligion() );
        patient.occupation( patientDTO.getOccupation() );
        if ( patientDTO.getGender() != null ) {
            patient.gender( patientDTO.getGender().charAt( 0 ) );
        }
        patient.maritalStatus( patientDTO.getMaritalStatus() );
        patient.description( patientDTO.getDescription() );

        return patient.build();
    }

    @Override
    public PatientDTO toDTO(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientDTO.PatientDTOBuilder patientDTO = PatientDTO.builder();

        patientDTO.username( patient.getUsername() );
        patientDTO.phoneNumber( patient.getPhoneNumber() );
        patientDTO.email( patient.getEmail() );
        patientDTO.age( patient.getAge() );
        patientDTO.bloodGroup( patient.getBloodGroup() );
        patientDTO.religion( patient.getReligion() );
        patientDTO.occupation( patient.getOccupation() );
        if ( patient.getGender() != null ) {
            patientDTO.gender( patient.getGender().toString() );
        }
        patientDTO.maritalStatus( patient.getMaritalStatus() );
        patientDTO.description( patient.getDescription() );

        return patientDTO.build();
    }
}
