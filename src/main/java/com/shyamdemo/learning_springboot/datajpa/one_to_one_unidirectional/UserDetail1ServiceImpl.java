package com.shyamdemo.learning_springboot.datajpa.one_to_one_unidirectional;

import com.shyamdemo.learning_springboot.datajpa.EntityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetail1ServiceImpl implements EntityService<UserDetail1> {

    @Autowired
    UserDetail1Repository userDetailRepository;

    @Override
    public List<UserDetail1> fetchAll() {
        return userDetailRepository.findAll();
    }

    @Override
    public Optional<UserDetail1> findById(Long id) {
        return userDetailRepository.findById(id);
    }

    @Override
    public UserDetail1 create(UserDetail1 userDetail) {
        return userDetailRepository.save(userDetail);
    }

    @Override
    public UserDetail1 update(Long id, UserDetail1 newUserDetail) {
        return userDetailRepository.findById(id)
                .map(existing -> {
                    existing.setName(newUserDetail.getName());
                    existing.setAge(newUserDetail.getAge());
                    existing.setUserAddress(newUserDetail.getUserAddress());
                    return userDetailRepository.save(existing);
                })
                .orElseThrow(() -> new EntityNotFoundException("UserDetail not found with ID: " + id));
    }

    @Override
    public void delete(Long id) {
        if (!userDetailRepository.existsById(id)) {
            throw new EntityNotFoundException("UserDetail not found with ID: " + id);
        }
        userDetailRepository.deleteById(id);
    }
}
