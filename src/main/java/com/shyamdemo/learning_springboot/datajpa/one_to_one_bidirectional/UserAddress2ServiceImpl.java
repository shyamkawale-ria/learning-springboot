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
    UserAddress2Repository userAddressRepository;

    @Override
    public List<UserAddress2> fetchAll() {
        return userAddressRepository.findAll();
    }

    @Override
    public Optional<UserAddress2> findById(Long id) {
        return userAddressRepository.findById(id);
    }

    @Override
    public UserAddress2 create(UserAddress2 userAddress) {
        return userAddressRepository.save(userAddress);
    }

    @Override
    public UserAddress2 update(Long id, UserAddress2 newUserAddress) {
        return userAddressRepository.findById(id)
                .map(existing -> {
                    existing.setCity(newUserAddress.getCity());
                    existing.setCountry(newUserAddress.getCountry());
                    existing.setState(newUserAddress.getState());
                    existing.setStreet(newUserAddress.getStreet());
                    existing.setPinCode(newUserAddress.getPinCode());
                    return userAddressRepository.save(existing);
                })
                .orElseThrow(() -> new EntityNotFoundException("UserAddress not found with ID: " + id));
    }

    @Override
    public void delete(Long id) {
        if (!userAddressRepository.existsById(id)) {
            throw new EntityNotFoundException("UserAddress not found with ID: " + id);
        }

        userAddressRepository.deleteById(id);
    }
}
