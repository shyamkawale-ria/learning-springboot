package com.shyamdemo.learning_springboot.datajpa.one_to_one_unidirectional;

import com.shyamdemo.learning_springboot.datajpa.EntityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/one-to-one-uni/useraddress")
@RestController
public class UserAddress1Controller {

    @Autowired
    EntityService<UserAddress1> userAddress1EntityService;

    @GetMapping
    public List<UserAddress1> getUserAddresss() {
        return userAddress1EntityService.fetchAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAddress1> getUserAddressById(@PathVariable Long id) {
        return userAddress1EntityService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserAddress1> createUserAddress(@RequestBody UserAddress1 userAddress) {
        return new ResponseEntity<>(userAddress1EntityService.create(userAddress), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAddress1> updateUserAddress(@PathVariable Long id, @RequestBody UserAddress1 userAddress) {
        try {
            return ResponseEntity.ok(userAddress1EntityService.update(id, userAddress));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserAddress(@PathVariable Long id) {
        try {
            userAddress1EntityService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
