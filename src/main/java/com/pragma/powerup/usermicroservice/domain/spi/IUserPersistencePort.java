package com.pragma.powerup.usermicroservice.domain.spi;



import com.pragma.powerup.usermicroservice.domain.model.User;

public interface IUserPersistencePort {
    void saveOwner(User user);
    void saveEmploye(User user);
    void saveCustomer(User user);
    String getUserById(Long id);
    String getPhoneById(Long id);
}
