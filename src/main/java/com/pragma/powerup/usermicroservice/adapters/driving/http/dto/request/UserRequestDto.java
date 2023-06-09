package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class UserRequestDto {
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
    private String idPersonType;
    @NotBlank
    private String password;
    @NotBlank
    private Date birthDate;
}
