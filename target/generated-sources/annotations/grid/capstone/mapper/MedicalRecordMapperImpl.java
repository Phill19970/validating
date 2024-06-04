package grid.capstone.mapper;

import grid.capstone.dto.v1.MedicalRecordDTO;
import grid.capstone.service.appointmet_service.domain.Appointment;
import grid.capstone.service.doctor_service.domain.Doctor;
import grid.capstone.service.domain.Prescription;
import grid.capstone.service.medicalRecord_service.domain.MedicalRecord;
import grid.capstone.service.patient_service.domain.Patient;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-04T05:25:13-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class MedicalRecordMapperImpl implements MedicalRecordMapper {

    @Override
    public MedicalRecordDTO toDTO(MedicalRecord medicalRecord) {
        if ( medicalRecord == null ) {
            return null;
        }

        MedicalRecordDTO.MedicalRecordDTOBuilder medicalRecordDTO = MedicalRecordDTO.builder();

        medicalRecordDTO.doctorId( medicalRecordDoctorId( medicalRecord ) );
        medicalRecordDTO.patientId( medicalRecordPatientId( medicalRecord ) );
        medicalRecordDTO.appointmentId( medicalRecordAppointmentId( medicalRecord ) );
        medicalRecordDTO.checkInDate( medicalRecord.getCheckInDate() );
        medicalRecordDTO.notes( medicalRecord.getNotes() );
        medicalRecordDTO.disease( medicalRecord.getDisease() );
        medicalRecordDTO.status( medicalRecord.getStatus() );
        medicalRecordDTO.roomNo( medicalRecord.getRoomNo() );
        List<Prescription> list = medicalRecord.getPrescriptions();
        if ( list != null ) {
            medicalRecordDTO.prescriptions( new ArrayList<Prescription>( list ) );
        }

        return medicalRecordDTO.build();
    }

    @Override
    public MedicalRecord toEntity(MedicalRecordDTO medicalRecordDTO) {
        if ( medicalRecordDTO == null ) {
            return null;
        }

        MedicalRecord.MedicalRecordBuilder medicalRecord = MedicalRecord.builder();

        medicalRecord.doctor( medicalRecordDTOToDoctor( medicalRecordDTO ) );
        medicalRecord.patient( medicalRecordDTOToPatient( medicalRecordDTO ) );
        medicalRecord.appointment( medicalRecordDTOToAppointment( medicalRecordDTO ) );
        medicalRecord.checkInDate( medicalRecordDTO.getCheckInDate() );
        medicalRecord.notes( medicalRecordDTO.getNotes() );
        medicalRecord.disease( medicalRecordDTO.getDisease() );
        medicalRecord.status( medicalRecordDTO.getStatus() );
        medicalRecord.roomNo( medicalRecordDTO.getRoomNo() );
        List<Prescription> list = medicalRecordDTO.getPrescriptions();
        if ( list != null ) {
            medicalRecord.prescriptions( new ArrayList<Prescription>( list ) );
        }

        return medicalRecord.build();
    }

    private Long medicalRecordDoctorId(MedicalRecord medicalRecord) {
        if ( medicalRecord == null ) {
            return null;
        }
        Doctor doctor = medicalRecord.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        Long id = doctor.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long medicalRecordPatientId(MedicalRecord medicalRecord) {
        if ( medicalRecord == null ) {
            return null;
        }
        Patient patient = medicalRecord.getPatient();
        if ( patient == null ) {
            return null;
        }
        Long id = patient.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long medicalRecordAppointmentId(MedicalRecord medicalRecord) {
        if ( medicalRecord == null ) {
            return null;
        }
        Appointment appointment = medicalRecord.getAppointment();
        if ( appointment == null ) {
            return null;
        }
        Long id = appointment.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Doctor medicalRecordDTOToDoctor(MedicalRecordDTO medicalRecordDTO) {
        if ( medicalRecordDTO == null ) {
            return null;
        }

        Doctor.DoctorBuilder doctor = Doctor.builder();

        doctor.id( medicalRecordDTO.getDoctorId() );

        return doctor.build();
    }

    protected Patient medicalRecordDTOToPatient(MedicalRecordDTO medicalRecordDTO) {
        if ( medicalRecordDTO == null ) {
            return null;
        }

        Patient.PatientBuilder patient = Patient.builder();

        patient.id( medicalRecordDTO.getPatientId() );

        return patient.build();
    }

    protected Appointment medicalRecordDTOToAppointment(MedicalRecordDTO medicalRecordDTO) {
        if ( medicalRecordDTO == null ) {
            return null;
        }

        Appointment.AppointmentBuilder appointment = Appointment.builder();

        appointment.id( medicalRecordDTO.getAppointmentId() );

        return appointment.build();
    }
}
