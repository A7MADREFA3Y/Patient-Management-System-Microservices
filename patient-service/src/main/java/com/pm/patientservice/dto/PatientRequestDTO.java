package com.pm.patientservice.dto;

import com.pm.patientservice.dto.validators.CreatePatientValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequestDTO {

    @NotBlank (message = "Name can't be empty ")
    @Size (max = 100, message = "Name can't exceed 100 characters")
    private String name;

    @NotBlank (message = "Email can't be empty ")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Date of birth is required")
    private String dateOfBirth;

    @NotBlank (groups = CreatePatientValidationGroup.class
            ,message = "Registered date is required")
    private String registeredDate;

}
