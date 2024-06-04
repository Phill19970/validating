package grid.capstone.mapper;

import grid.capstone.dto.v1.DoctorDTO;
import grid.capstone.service.doctor_service.domain.Doctor;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-04T05:25:13-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class DoctorMapperImpl implements DoctorMapper {

    @Override
    public Doctor toEntity(DoctorDTO doctorDTO) {
        if ( doctorDTO == null ) {
            return null;
        }

        Doctor.DoctorBuilder doctor = Doctor.builder();

        doctor.id( doctorDTO.getId() );
        doctor.username( doctorDTO.getUsername() );

        return doctor.build();
    }

    @Override
    public DoctorDTO toDTO(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorDTO.DoctorDTOBuilder doctorDTO = DoctorDTO.builder();

        doctorDTO.id( doctor.getId() );
        doctorDTO.username( doctor.getUsername() );

        return doctorDTO.build();
    }
}
