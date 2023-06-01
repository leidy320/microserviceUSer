package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.CustomerRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.EmployeRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.domain.exceptions.ValidateUserException;

public interface IUserHandler {
    void saveOwner(UserRequestDto personRequestDto) throws ValidateUserException;
    void saveEmploye(EmployeRequestDto employeRequestDto) throws ValidateUserException;
    void saveCustomer(CustomerRequestDto customerRequestDto) throws ValidateUserException;
    String getUserById(Long id);

}
