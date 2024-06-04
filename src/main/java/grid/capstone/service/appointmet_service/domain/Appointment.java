package grid.capstone.service.appointmet_service.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import grid.capstone.service.doctor_service.domain.Doctor;
import grid.capstone.service.medicalRecord_service.domain.MedicalRecord;
import grid.capstone.service.patient_service.domain.Patient;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

import static grid.capstone.util.UpdateUtil.UpdateTool;

/**
 * @author Javaughn Stephenson
 * @since 15/06/2023
 */

@Data
@ToString(exclude = "patient")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Appointment date is required")
    @FutureOrPresent(message = "Appointment must be in the future or present")
    private LocalDate appointmentDate;

    @NotNull(message = "Start time is required")
    private LocalTime startTime;

    @NotNull(message = "End time is required")
    private LocalTime endTime;

    @NotBlank(message = "Reason is required")
    private String reason;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonIgnore
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonIgnore
    private Patient patient;

    @OneToOne
    @JsonIgnore
    private MedicalRecord medicalRecord;


    public void updateObject(Appointment appointment) {
        UpdateTool(appointment.getAppointmentDate(), this::setAppointmentDate);
        UpdateTool(appointment.getStartTime(), this::setStartTime);
        UpdateTool(appointment.getEndTime(), this::setEndTime);
        UpdateTool(appointment.getReason(), this::setReason);
        UpdateTool(appointment.getMedicalRecord(), this::setMedicalRecord);
    }

}
