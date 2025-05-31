package com.shyamdemo.learning_springboot.datajpa.one_to_many_unidirectional;

import com.shyamdemo.learning_springboot.datajpa.EntityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Order1ServiceImpl implements EntityService<Order1> {

    @Autowired
    Order1Repository order1Repository;

    @Override
    public List<Order1> fetchAll() {
        return order1Repository.findAll();
    }

    @Override
    public Optional<Order1> findById(Long id) {
        return order1Repository.findById(id);
    }

    @Override
    public Order1 create(Order1 entity) {
        return order1Repository.save(entity);
    }

    @Override
    public Order1 update(Long id, Order1 entity) {
        return order1Repository.findById(id)
                .map(existing -> {
                    existing.setProductName(entity.getProductName());
                    return order1Repository.save(existing);
                })
                .orElseThrow(() -> new EntityNotFoundException("Order not found with ID: " + id));
    }

    @Override
    public void delete(Long id) {
        if (!order1Repository.existsById(id)) {
            throw new EntityNotFoundException("Order not found with ID: " + id);
        }

        order1Repository.deleteById(id);
    }
}
