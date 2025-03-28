package com.medicare.user_service.Repository;

import com.medicare.user_service.Model.MedicalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalDetailsRepository extends JpaRepository<MedicalData, Long> {
}
