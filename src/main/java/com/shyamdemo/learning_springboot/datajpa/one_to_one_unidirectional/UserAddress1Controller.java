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
    EntityService<UserAddress1> userAddressEntityService;

    @GetMapping
    public List<UserAddress1> getUserAddresss() {
        return userAddressEntityService.fetchAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAddress1> getUserAddressById(@PathVariable Long id) {
        return userAddressEntityService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserAddress1> createUserAddress(@RequestBody UserAddress1 userAddress) {
        return new ResponseEntity<>(userAddressEntityService.create(userAddress), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAddress1> updateUserAddress(@PathVariable Long id, @RequestBody UserAddress1 userAddress) {
        try {
            return ResponseEntity.ok(userAddressEntityService.update(id, userAddress));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserAddress(@PathVariable Long id) {
        try {
            userAddressEntityService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
