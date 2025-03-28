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

    @Column(nullable = false)
    private String consultationType;

    @ElementCollection
    @CollectionTable(name = "record_symptoms", joinColumns = @JoinColumn(name = "medical_record_id"))
    @Column(name = "symptom")
    private List<String> symptoms;

    @Column(nullable = false)
    private String diagnosis;

    @Column
    private String severityLevel;

    @Column(columnDefinition = "TEXT")
    private String consultationNotes;

    //String to class in future
    private String prescriptions;

    //String to class in future
    private List<String> tests;

    //payment integration -> Payment class
    private String paymentId;

}
