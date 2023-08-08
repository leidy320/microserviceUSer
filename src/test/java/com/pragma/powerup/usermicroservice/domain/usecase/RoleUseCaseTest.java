package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.exceptions.ValidateUserException;
import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IRolePersistencePort;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RoleUseCaseTest {
    @InjectMocks
    private RoleUseCase roleUseCase;
    @Mock
    private IRolePersistencePort rolePersistencePort;

    public RoleUseCaseTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldgetAllRoles()  {
        roleUseCase.getAllRoles();
        Mockito.verify(rolePersistencePort, Mockito.times(1)).getAllRoles();
    }

}
