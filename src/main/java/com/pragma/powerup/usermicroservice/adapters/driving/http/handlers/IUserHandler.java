package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.EmployeRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.UserResponseDto;
import com.pragma.powerup.usermicroservice.domain.exceptions.ValidateUserException;
import com.pragma.powerup.usermicroservice.domain.model.User;

public interface IUserHandler {
    void saveOwner(UserRequestDto personRequestDto) throws ValidateUserException;
    void saveEmploye(EmployeRequestDto employeRequestDto) throws ValidateUserException;
    String getUserById(Long id);
}
