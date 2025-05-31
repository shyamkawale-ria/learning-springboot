package com.shyamdemo.learning_springboot.datajpa.one_to_many_unidirectional;

import com.shyamdemo.learning_springboot.datajpa.EntityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Customer1ServiceImpl implements EntityService<Customer1> {

    @Autowired
    Customer1Repository customer1Repository;

    @Override
    public List<Customer1> fetchAll() {
        return customer1Repository.findAll();
    }

    @Override
    public Optional<Customer1> findById(Long id) {
        return customer1Repository.findById(id);
    }

    @Override
    public Customer1 create(Customer1 entity) {
        return customer1Repository.save(entity);
    }

    @Override
    public Customer1 update(Long id, Customer1 entity) {
        return customer1Repository.findById(id)
                .map(existing -> {
                    existing.setName(entity.getName());
                    existing.setAge(entity.getAge());
                    return customer1Repository.save(existing);
                })
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with ID: " + id));
    }

    @Override
    public void delete(Long id) {
        if (!customer1Repository.existsById(id)) {
            throw new EntityNotFoundException("Customer not found with ID: " + id);
        }
        customer1Repository.deleteById(id);
    }
}
