package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.UserResponseDto;
import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.exceptions.ValidateUserException;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;

import java.util.Date;

public class UserUseCase implements IUserServicePort {
    private final int MAX_AGE = 18;
    private final int MAX_CHARACTER = 13;
    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort personPersistencePort) {
        this.userPersistencePort = personPersistencePort;
    }

    @Override
    public void saveOwner(User user) throws ValidateUserException {
        validateInfoToUser(user);
        userPersistencePort.saveOwner(user);
    }

    @Override
    public String getUserById(Long id) {
        return userPersistencePort.getUserById(id);
    }

    private void validateInfoToUser(User user) throws ValidateUserException {
        validatePhone(user.getPhone());
        validateDni(user.getDniNumber());
        validateMail(user.getMail());
        validateAge(user.getBirthDate());
    }

    private void validateAge(Date date) throws ValidateUserException {
        int age = new Date().getYear() - date.getYear() ;
        if(age< MAX_AGE) {
            throw new ValidateUserException("la persona es menor de edad, tiene que ser mayor de edad");
        }
    }

    private void validateMail(String mail) throws ValidateUserException {
        if(!mail.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new ValidateUserException("No es un email el valor ingresado");
        }
    }

    private void validateDni(String dni) throws ValidateUserException {
        if(dni.matches(".*[a-zA-Z]+.*")) {
            throw new ValidateUserException("El Campo documento de identidad solo acepta numeros");
        }
    }

    private void validatePhone(String phone) throws ValidateUserException {

        if(phone.length() >= MAX_CHARACTER || phone.matches(".*[a-zA-Z]+.*")) {
            throw new ValidateUserException("El numero de telefono no debe superar los 13 caracteres, ni debe contener letras");
        }
    }


}
    






