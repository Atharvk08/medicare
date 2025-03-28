package com.medicare.user_service.Service;

import com.medicare.user_service.DTO.MedicalDataDTO;
import com.medicare.user_service.DTO.MedicalRecordRequestDTO;
import com.medicare.user_service.DTO.UserRegistrationDTO;
import com.medicare.user_service.Model.MedicalData;
import com.medicare.user_service.Model.User;
import com.medicare.user_service.Repository.MedicalDetailsRepository;
import com.medicare.user_service.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;
    private final MedicalDetailsRepository medicalDetailsRepository;

    @Autowired
    public UserService(UserRepository userRepository, MedicalDetailsRepository medicalDetailsRepository) {
        this.repository=userRepository;
        this.medicalDetailsRepository = medicalDetailsRepository;
    }

    public void addUser(User user){
        repository.save(user);
    }

    public User addUser(UserRegistrationDTO registrationDTO){
        String email= repository.findByEmail(registrationDTO.getEmail());
        if(email!=null || !email.isEmpty())
            throw new RuntimeException("User Already exists");

        User user = User.builder()
                .email(registrationDTO.getEmail())
                .password(registrationDTO.getPassword())
                .gender(registrationDTO.getGender())
                .firstName(registrationDTO.getFirstName())
                .lastName(registrationDTO.getLastName())
                .phoneNumber(registrationDTO.getPhoneNumber())
                .street(registrationDTO.getStreet())
                .city(registrationDTO.getCity())
                .state(registrationDTO.getState())
                .zipCode(registrationDTO.getZipCode())
                .languagePreference(registrationDTO.getLanguagePreference())
                .dateOfBirth(registrationDTO.getDateOfBirth())
                .roles(registrationDTO.getRoles())
                .build();

        return repository.save(user);
    }

    public MedicalData addMedicalData(MedicalDataDTO dataDTO){
        User user = repository.findById(Long.valueOf(dataDTO.getUserId()))
                .orElseThrow(()-> new RuntimeException("User Not Found"));

        MedicalData data= MedicalData.builder()
                .user(user)
                .medications(dataDTO.getMedications())
                .bloodType(dataDTO.getBloodType())
                .allergies(dataDTO.getAllergies())
                .chronicDiseases(dataDTO.getChronicDiseases())
                .vaccinationRecords(dataDTO.getVaccinationRecords())
                .build();

        return data;
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> {
                    return new RuntimeException("User not found");
                });
    }

    public void createUser(User user) {
        repository.save(user);
    }

    public void updateUser(User user) {
        repository.save(user);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }


}
