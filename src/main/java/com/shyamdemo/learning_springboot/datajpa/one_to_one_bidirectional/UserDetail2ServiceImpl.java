package com.shyamdemo.learning_springboot.datajpa.one_to_one_bidirectional;

import com.shyamdemo.learning_springboot.datajpa.EntityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetail2ServiceImpl implements EntityService<UserDetail2> {

    @Autowired
    UserDetail2Repository userDetail2Repository;

    @Override
    public List<UserDetail2> fetchAll() {
        return userDetail2Repository.findAll();
    }

    @Override
    public Optional<UserDetail2> findById(Long id) {
        return userDetail2Repository.findById(id);
    }

    @Override
    public UserDetail2 create(UserDetail2 entity) {
        return userDetail2Repository.save(entity);
    }

    @Override
    public UserDetail2 update(Long id, UserDetail2 entity) {
        return userDetail2Repository.findById(id)
                .map(existing -> {
                    existing.setName(entity.getName());
                    existing.setAge(entity.getAge());
                    existing.setUserAddress(entity.getUserAddress());
                    return userDetail2Repository.save(existing);
                })
                .orElseThrow(() -> new EntityNotFoundException("UserDetail not found with ID: " + id));
    }

    @Override
    public void delete(Long id) {
        if (!userDetail2Repository.existsById(id)) {
            throw new EntityNotFoundException("UserDetail not found with ID: " + id);
        }
        userDetail2Repository.deleteById(id);
    }
}
