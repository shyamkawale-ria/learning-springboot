package com.shyamdemo.learning_springboot.datajpa.one_to_many_unidirectional;

import com.shyamdemo.learning_springboot.datajpa.EntityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/one-to-many-uni/order")
@RestController
public class Order1Controller {

    @Autowired
    EntityService<Order1> orderEntityService;

    @GetMapping
    public List<Order1> getOrders() {
        return orderEntityService.fetchAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order1> getOrderById(@PathVariable Long id) {
        return orderEntityService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Order1> createOrder(@RequestBody Order1 order1) {
        return new ResponseEntity<>(orderEntityService.create(order1), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order1> updateOrder(@PathVariable Long id, @RequestBody Order1 order1) {
        try {
            return ResponseEntity.ok(orderEntityService.update(id, order1));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        try {
            orderEntityService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
