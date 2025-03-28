package com.medicare.user_service.DTO;

import com.medicare.user_service.Model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalDataDTO {

    private String userId;

    private String bloodType;
    private Set<String> allergies;
    private Set<String> chronicDiseases;
    private Set<String> medications;
    private String vaccinationRecords;
}
