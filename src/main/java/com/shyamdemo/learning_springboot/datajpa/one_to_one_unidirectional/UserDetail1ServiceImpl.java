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
    UserDetail1Repository userDetail1Repository;

    @Override
    public List<UserDetail1> fetchAll() {
        return userDetail1Repository.findAll();
    }

    @Override
    public Optional<UserDetail1> findById(Long id) {
        return userDetail1Repository.findById(id);
    }

    @Override
    public UserDetail1 create(UserDetail1 entity) {
        return userDetail1Repository.save(entity);
    }

    @Override
    public UserDetail1 update(Long id, UserDetail1 entity) {
        return userDetail1Repository.findById(id)
                .map(existing -> {
                    existing.setName(entity.getName());
                    existing.setAge(entity.getAge());
                    existing.setUserAddress(entity.getUserAddress());
                    return userDetail1Repository.save(existing);
                })
                .orElseThrow(() -> new EntityNotFoundException("UserDetail not found with ID: " + id));
    }

    @Override
    public void delete(Long id) {
        if (!userDetail1Repository.existsById(id)) {
            throw new EntityNotFoundException("UserDetail not found with ID: " + id);
        }
        userDetail1Repository.deleteById(id);
    }
}
