package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.exceptions.ValidateUserException;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;


public class UserUseCaseTest {
    @InjectMocks
    private UserUseCase userUseCase;
    @Mock
    private IUserPersistencePort userPersistencePort;

    public UserUseCaseTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void  shouldGenerateExceptionByAge() {
        Date age= new Date();
        assertThrows(ValidateUserException.class, () -> userUseCase.validateAge(age), "la persona es menor de edad, tiene que ser mayor de edad");
    }

    @Test
    void  shouldGenerateExceptionByMail() {
        String mail= "leidy.rodas";
        assertThrows(ValidateUserException.class, () -> userUseCase.validateMail(mail), "No es un email el valor ingresado");
    }

    @Test
    void  shouldGenerateExceptionByDni() {
        String dni= "13569jsldk";
        assertThrows(ValidateUserException.class, () -> userUseCase.validateDni(dni), "El Campo documento de identidad solo acepta numeros");
    }
    @Test
    void  shouldGenerateExceptionByPhone() {
        String phone= "13569jsldk";
        assertThrows(ValidateUserException.class, () -> userUseCase.validatePhone(phone), "El numero de telefono no debe superar los 13 caracteres, ni debe contener letras");
    }


}
