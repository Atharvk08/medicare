package com.medicare.user_service.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "medical_records")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Long patientId;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Long doctorId;

    @Column(nullable = false)
    private LocalDateTime recordDate;

    @Column
    private String consultationType;

    @ElementCollection
    @CollectionTable(name = "record_symptoms", joinColumns = @JoinColumn(name = "medical_record_id"))
    @Column(name = "symptoms")
    private List<String> symptoms;

    @Column
    private String diagnosis;

    @Column
    private String severityLevel;

    @Column(columnDefinition = "TEXT")
    private String consultationNotes;

    //String to class Prescription in future
    private List<String> prescriptions;

    //String to class in future
    private List<String> tests;

    //payment integration -> Payment class
    private String paymentId;


/* for future
    @Column
    private String insuranceClaimStatus;

    @Column
    private String insuranceReferenceId;

    @Column(columnDefinition = "TEXT")
    private String emergencyAction;

    @Column
    private Boolean hospitalAdmissionStatus;

    @Column(nullable = false, updatable = false)
    private String createdBy;

    @Column
    private String lastUpdatedBy;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;
    */
}
