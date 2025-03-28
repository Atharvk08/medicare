package com.medicare.user_service.Service;

import com.medicare.user_service.DTO.MedicalRecordRequestDTO;
import com.medicare.user_service.Model.MedicalRecord;
import com.medicare.user_service.Model.User;
import com.medicare.user_service.Repository.MedicalRecordRepository;
import com.medicare.user_service.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;
    private final UserRepository userRepository;

    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository, UserRepository userRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.userRepository = userRepository;
    }

    public MedicalRecord createRecord(MedicalRecordRequestDTO requestDTO){
        User patient = userRepository.findById(requestDTO.getPatientId())
                .orElseThrow(()-> new RuntimeException("Patient Not Found"));
        User doctor = userRepository.findById(requestDTO.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor Not Found"));

        //create record
        MedicalRecord record = MedicalRecord.builder()
                .patientId(patient.getId())
                .doctorId(doctor.getId())
                .recordDate(LocalDateTime.now())
                .diagnosis(requestDTO.getDiagnosis())
                .consultationNotes(requestDTO.getConsultationNotes())
                .prescriptions(requestDTO.getPrescribedMedications())
                .build();
        return medicalRecordRepository.save(record);
    }


}
