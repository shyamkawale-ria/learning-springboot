package com.shyamdemo.learning_springboot.datajpa.one_to_many_unidirectional;

import com.shyamdemo.learning_springboot.datajpa.EntityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/one-to-many-uni/customer")
@RestController
public class Customer1Controller {

    @Autowired
    EntityService<Customer1> customerEntityService;

    /*
     */
    @GetMapping
    public List<Customer1> getCustomers() {
        return customerEntityService.fetchAll();
    }

    /*
     */
    @GetMapping("/{id}")
    public ResponseEntity<Customer1> getCustomerById(@PathVariable Long id) {
        return customerEntityService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*
     */
    @PostMapping
    public ResponseEntity<Customer1> createCustomer(@RequestBody Customer1 customer1) {
        return new ResponseEntity<>(customerEntityService.create(customer1), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer1> updateCustomer(@PathVariable Long id, @RequestBody Customer1 customer1) {
        try {
            return ResponseEntity.ok(customerEntityService.update(id, customer1));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        try {
            customerEntityService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
