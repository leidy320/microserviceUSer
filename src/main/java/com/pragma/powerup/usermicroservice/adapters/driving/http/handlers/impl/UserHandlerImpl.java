package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.CustomerRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.EmployeRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserHandler;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IUserRequestMapper;
import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.exceptions.ValidateUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserHandlerImpl implements IUserHandler {
    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;

    @Override
    public void saveOwner(UserRequestDto userRequestDto) throws ValidateUserException {
        userServicePort.saveOwner(userRequestMapper.toUser(userRequestDto));
    }

    @Override
    public void saveEmploye(EmployeRequestDto employeRequestDto) throws ValidateUserException {
        userServicePort.saveEmploye(userRequestMapper.toEmploye(employeRequestDto));
    }

    @Override
    public void saveCustomer(CustomerRequestDto customerRequestDto) throws ValidateUserException {
        userServicePort.saveCustomer(userRequestMapper.toCustomer(customerRequestDto));
    }

    @Override
    public String getUserById(Long id) {
        return userServicePort.getUserById(id);
    }
    @Override
    public String getPhoneById(Long id) {
        return userServicePort.getPhoneById(id);
    }
}


