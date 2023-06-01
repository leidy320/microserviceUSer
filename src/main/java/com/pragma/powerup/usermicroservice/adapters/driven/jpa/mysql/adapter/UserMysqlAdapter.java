package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.MailAlreadyExistsException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.PersonAlreadyExistsException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IUserEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IRoleRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IUserRepository;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IUserResponseMapper;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class UserMysqlAdapter implements IUserPersistencePort {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;
    private final IRoleRepository roleRepository;
    private  final IUserResponseMapper userResponseMapper;
    @Override
    public void saveOwner(User user) {

        validationDniAlreadyExist(user);
        validationMailAlreadyExist(user);

        RoleEntity role = roleRepository.getById(Constants.OWNER_ROLE_ID);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity userEntity = userEntityMapper.toEntity(user);
        userEntity.setRole(role);
        userRepository.save(userEntity);

    }
    public void saveEmploye(User user) {

        validationDniAlreadyExist(user);
        validationMailAlreadyExist(user);

        RoleEntity role = roleRepository.getById(Constants.EMPLOYEE_ROLE_ID);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity userEntity = userEntityMapper.toEntity(user);
        userEntity.setRole(role);
        userRepository.save(userEntity);

    }

    @Override
    public void saveCustomer(User user) {
        validationDniAlreadyExist(user);
        validationMailAlreadyExist(user);

        RoleEntity role = roleRepository.getById(Constants.CUSTOMER_ROLE_ID);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity userEntity = userEntityMapper.toEntity(user);
        userEntity.setRole(role);
        userRepository.save(userEntity);
    }

    private void validationMailAlreadyExist(User user) {
        if (userRepository.existsByMail(user.getMail())){
            throw new MailAlreadyExistsException();
        }
    }

    private void validationDniAlreadyExist(User user) {
        if (userRepository.findByDniNumber(user.getDniNumber()).isPresent()) {
            throw new PersonAlreadyExistsException();
        }
    }

    @Override
    public String getUserById(Long id) {
        UserEntity userEntity =  userRepository.findById(id).get();
        return userEntity.getRole().getName();
    }
}
