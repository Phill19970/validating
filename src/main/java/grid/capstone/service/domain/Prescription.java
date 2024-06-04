package grid.capstone.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import grid.capstone.service.medicalRecord_service.domain.MedicalRecord;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

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
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medication;

    @FutureOrPresent(message = "Start date cannot be in the past")
    private LocalDate startDate;

    @Future(message = "End Date Should be in the future")
    private LocalDate endDate;
    private Integer dosage;
    private BigDecimal total;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "medical_record_id")
    @JsonIgnore
    private MedicalRecord medicalRecord;


    public void updateObject(Prescription prescription) {
        UpdateTool(prescription.getMedication(), this::setMedication);
        UpdateTool(prescription.getStartDate(), this::setStartDate);
        UpdateTool(prescription.getEndDate(), this::setEndDate);
        UpdateTool(prescription.getDosage(), this::setDosage);
        UpdateTool(prescription.getTotal(), this::setTotal);
    }

}
