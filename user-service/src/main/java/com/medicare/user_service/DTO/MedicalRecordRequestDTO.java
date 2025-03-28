package com.medicare.user_service.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecordRequestDTO {
    @NotNull
    private Long patientId;

    @NotNull
    private Long doctorId;

    @NotBlank
    private String diagnosis;

    private String consultationNotes;

    private List<String> prescribedMedications;
}
