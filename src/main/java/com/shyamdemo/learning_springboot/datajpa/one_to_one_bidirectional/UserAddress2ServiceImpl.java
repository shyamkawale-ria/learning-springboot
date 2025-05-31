package com.shyamdemo.learning_springboot.datajpa.one_to_one_bidirectional;

import com.shyamdemo.learning_springboot.datajpa.EntityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAddress2ServiceImpl implements EntityService<UserAddress2> {

    @Autowired
    UserAddress2Repository userAddress2Repository;

    @Override
    public List<UserAddress2> fetchAll() {
        return userAddress2Repository.findAll();
    }

    @Override
    public Optional<UserAddress2> findById(Long id) {
        return userAddress2Repository.findById(id);
    }

    @Override
    public UserAddress2 create(UserAddress2 entity) {
        return userAddress2Repository.save(entity);
    }

    @Override
    public UserAddress2 update(Long id, UserAddress2 entity) {
        return userAddress2Repository.findById(id)
                .map(existing -> {
                    existing.setCity(entity.getCity());
                    existing.setCountry(entity.getCountry());
                    existing.setState(entity.getState());
                    existing.setStreet(entity.getStreet());
                    existing.setPinCode(entity.getPinCode());
                    return userAddress2Repository.save(existing);
                })
                .orElseThrow(() -> new EntityNotFoundException("UserAddress not found with ID: " + id));
    }

    @Override
    public void delete(Long id) {
        if (!userAddress2Repository.existsById(id)) {
            throw new EntityNotFoundException("UserAddress not found with ID: " + id);
        }

        userAddress2Repository.deleteById(id);
    }
}
