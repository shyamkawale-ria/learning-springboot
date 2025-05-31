package com.shyamdemo.learning_springboot.datajpa.one_to_one_unidirectional;

import com.shyamdemo.learning_springboot.datajpa.EntityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAddress1ServiceImpl implements EntityService<UserAddress1> {

    @Autowired
    UserAddress1Repository userAddress1Repository;

    @Override
    public List<UserAddress1> fetchAll() {
        return userAddress1Repository.findAll();
    }

    @Override
    public Optional<UserAddress1> findById(Long id) {
        return userAddress1Repository.findById(id);
    }

    @Override
    public UserAddress1 create(UserAddress1 entity) {
        return userAddress1Repository.save(entity);
    }

    @Override
    public UserAddress1 update(Long id, UserAddress1 entity) {
        return userAddress1Repository.findById(id)
                .map(existing -> {
                    existing.setCity(entity.getCity());
                    existing.setCountry(entity.getCountry());
                    existing.setState(entity.getState());
                    existing.setStreet(entity.getStreet());
                    existing.setPinCode(entity.getPinCode());
                    return userAddress1Repository.save(existing);
                })
                .orElseThrow(() -> new EntityNotFoundException("UserAddress not found with ID: " + id));
    }

    @Override
    public void delete(Long id) {
        if (!userAddress1Repository.existsById(id)) {
            throw new EntityNotFoundException("UserAddress not found with ID: " + id);
        }
        userAddress1Repository.deleteById(id);
    }
}
