package com.medicare.user_service.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDTO {
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String firstName;
    private String lastName;

    @NotNull
    private String phoneNumber;

    private Set<String> roles;

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String gender;
    private String languagePreference;
    private LocalDate dateOfBirth;
}
