package grid.capstone.mapper;

import grid.capstone.dto.v1.AppointmentDTO;
import grid.capstone.service.appointmet_service.domain.Appointment;
import grid.capstone.service.doctor_service.domain.Doctor;
import grid.capstone.service.patient_service.domain.Patient;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-04T05:25:13-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class AppointmentMapperImpl implements AppointmentMapper {

    @Override
    public AppointmentDTO toDTO(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }

        AppointmentDTO.AppointmentDTOBuilder appointmentDTO = AppointmentDTO.builder();

        appointmentDTO.doctorId( appointmentDoctorId( appointment ) );
        appointmentDTO.patientId( appointmentPatientId( appointment ) );
        appointmentDTO.appointmentDate( appointment.getAppointmentDate() );
        appointmentDTO.startTime( appointment.getStartTime() );
        appointmentDTO.endTime( appointment.getEndTime() );
        appointmentDTO.reason( appointment.getReason() );

        return appointmentDTO.build();
    }

    @Override
    public Appointment toEntity(AppointmentDTO appointmentDTO) {
        if ( appointmentDTO == null ) {
            return null;
        }

        Appointment.AppointmentBuilder appointment = Appointment.builder();

        appointment.doctor( appointmentDTOToDoctor( appointmentDTO ) );
        appointment.patient( appointmentDTOToPatient( appointmentDTO ) );
        appointment.appointmentDate( appointmentDTO.getAppointmentDate() );
        appointment.startTime( appointmentDTO.getStartTime() );
        appointment.endTime( appointmentDTO.getEndTime() );
        appointment.reason( appointmentDTO.getReason() );

        return appointment.build();
    }

    private Long appointmentDoctorId(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }
        Doctor doctor = appointment.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        Long id = doctor.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long appointmentPatientId(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }
        Patient patient = appointment.getPatient();
        if ( patient == null ) {
            return null;
        }
        Long id = patient.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Doctor appointmentDTOToDoctor(AppointmentDTO appointmentDTO) {
        if ( appointmentDTO == null ) {
            return null;
        }

        Doctor.DoctorBuilder doctor = Doctor.builder();

        doctor.id( appointmentDTO.getDoctorId() );

        return doctor.build();
    }

    protected Patient appointmentDTOToPatient(AppointmentDTO appointmentDTO) {
        if ( appointmentDTO == null ) {
            return null;
        }

        Patient.PatientBuilder patient = Patient.builder();

        patient.id( appointmentDTO.getPatientId() );

        return patient.build();
    }
}
