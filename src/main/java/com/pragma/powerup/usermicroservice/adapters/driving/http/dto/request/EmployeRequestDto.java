package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
@AllArgsConstructor
@Getter
public class EmployeRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String mail;
    @NotBlank
    private String phone;
    private String address;
    private String idDniType;
    @NotBlank
    private String dniNumber;
    @NotBlank
    private String idPersonType;
    @NotBlank
    private String password;

    private Date birthDate;
}
