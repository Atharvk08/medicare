package com.medicare.user_service.Controller;

import com.medicare.user_service.DTO.MedicalRecordRequestDTO;
import com.medicare.user_service.Model.MedicalRecord;
import com.medicare.user_service.Service.MedicalRecordService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medical-records")
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMedicalRecord(@Valid @RequestBody MedicalRecordRequestDTO requestDTO){
        MedicalRecord savedRecord = medicalRecordService.createRecord(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRecord);
    }
}
