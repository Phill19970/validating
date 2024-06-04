package grid.capstone.service.medicalRecord_service.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import grid.capstone.service.appointmet_service.domain.Appointment;
import grid.capstone.service.doctor_service.domain.Doctor;
import grid.capstone.service.patient_service.domain.Patient;
import grid.capstone.service.domain.Prescription;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import static grid.capstone.util.UpdateUtil.UpdateTool;

/**
 * @author Javaughn Stephenson
 * @since 15/06/2023
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Check in date is required")
    @PastOrPresent(message = "Check in date cannot be in the future")
    private LocalDate checkInDate;
    private String notes;
    private String disease;
    private String status;

    @NotBlank(message = "Room number is required")
    private String roomNo;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonIgnore
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @OneToMany(mappedBy = "medicalRecord", cascade = CascadeType.ALL)
    private List<Prescription> prescriptions;

    public void updateObject(MedicalRecord medicalRecord) {
        UpdateTool(medicalRecord.getCheckInDate(), this::setCheckInDate);
        UpdateTool(medicalRecord.getNotes(), this::setNotes);
        UpdateTool(medicalRecord.getDisease(), this::setDisease);
        UpdateTool(medicalRecord.getStatus(), this::setStatus);
        UpdateTool(medicalRecord.getRoomNo(), this::setRoomNo);
    }
}
