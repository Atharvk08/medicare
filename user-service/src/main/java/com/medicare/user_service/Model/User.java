package com.medicare.user_service.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@Table(name = "users")
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(
            name = "user_seq",
            sequenceName = "user_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    private Long id;

    @Transient
    public String getFormattedId(){
        return String.format("%05d",this.id);
    }

    @Column(nullable = false, unique = true)
    private String email;
    @Column(name = "email_verified")
    private boolean emailVerified;

    @Column(nullable = false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name="role")
    private Set<String> roles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medical_data_id", referencedColumnName = "id")
    private MedicalData medicalData;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicalRecord> medicalRecords;

    private String firstName;
    private String lastName;

    private String phoneNumber;

    // Example address fields - you can customize as needed
    private String street;
    private String city;
    private String state;
    private String zipCode;

    private String gender;

    private LocalDate dateOfBirth;

    private String profilePictureUrl;

    private String languagePreference;
    private String timeZone;

    // For example, ACTIVE, INACTIVE, SUSPENDED
    private String status;

    private LocalDateTime lastLogin;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // Additional security fields
    private String passwordResetToken;
    private LocalDateTime passwordResetTokenExpiry;

    private boolean multiFactorEnabled;

    @PrePersist
    public void prePersist(){
        createdAt=LocalDateTime.now();
        updatedAt=createdAt;
    }

    @PreUpdate
    public void preUpdate(){
        updatedAt=LocalDateTime.now();
    }

}
