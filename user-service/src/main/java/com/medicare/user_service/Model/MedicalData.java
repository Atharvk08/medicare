package com.medicare.user_service.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "medical_data")
@Builder
public class MedicalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "blood_type")
    private String bloodType;

    @ElementCollection
    @CollectionTable(name = "allergies", joinColumns = @JoinColumn(name = "medical_data_id"))
    @Column(name = "allergy")
    private Set<String> allergies;

    @ElementCollection
    @CollectionTable(name = "chronic_diseases", joinColumns = @JoinColumn(name = "medical_data_id"))
    @Column(name = "disease")
    private Set<String> chronicDiseases;

    @ElementCollection
    @CollectionTable(name = "medications", joinColumns = @JoinColumn(name = "medical_data_id"))
    @Column(name = "medication")
    private Set<String> medications;

    @Column(name = "vaccination_records")
    private String vaccinationRecords;

    @OneToOne(mappedBy = "medicalData")
    private User user;
}
