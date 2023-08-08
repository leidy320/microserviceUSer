package com.pragma.powerup.usermicroservice.domain.api;


import com.pragma.powerup.usermicroservice.domain.exceptions.ValidateUserException;
import com.pragma.powerup.usermicroservice.domain.model.User;

public interface IUserServicePort {
    void saveOwner(User user) throws ValidateUserException;
    void saveEmploye(User user) throws ValidateUserException;

    void saveCustomer(User user) throws ValidateUserException;
    String getUserById(Long id);
    String getPhoneById(Long id);
}
