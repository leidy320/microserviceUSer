package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.exceptions.ValidateUserException;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    @Test
    void shouldSaveOwner() throws ValidateUserException, ParseException {
        User user = new User();
        user.setPhone("310458532");
        user.setDniNumber("1234556026");
        user.setMail("leidy@gmail.com");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = formato.parse("23/11/1998");
        user.setBirthDate(fecha);
        userUseCase.saveOwner(user);

        Mockito.verify(userPersistencePort, Mockito.times(1)).saveOwner(Mockito.any());
    }

    @Test
    void shouldsaveEmploye() throws ValidateUserException, ParseException {
        User user = new User();
        user.setPhone("310458532");
        user.setDniNumber("1234556026");
        user.setMail("rodolfo@gmail.com");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = formato.parse("23/11/1994");
        user.setBirthDate(fecha);
        userUseCase.saveEmploye(user);

        Mockito.verify(userPersistencePort, Mockito.times(1)).saveEmploye(Mockito.any());
    }

    @Test
    void shouldsaveCustomer() throws ValidateUserException, ParseException {
        User user = new User();
        user.setPhone("310458532");
        user.setDniNumber("1234556026");
        user.setMail("rodolfo@gmail.com");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = formato.parse("23/11/1994");
        user.setBirthDate(fecha);
        userUseCase.saveCustomer(user);

        Mockito.verify(userPersistencePort, Mockito.times(1)).saveCustomer(Mockito.any());
    }


    @Test
    void shouldgetUserById()  {
        userUseCase.getUserById(1L);
        Mockito.verify(userPersistencePort, Mockito.times(1)).getUserById(Mockito.any());
    }
    @Test
    void shouldgetPhoneById() {
        userUseCase.getPhoneById(1L);
        Mockito.verify(userPersistencePort, Mockito.times(1)).getPhoneById(Mockito.any());
    }


}
