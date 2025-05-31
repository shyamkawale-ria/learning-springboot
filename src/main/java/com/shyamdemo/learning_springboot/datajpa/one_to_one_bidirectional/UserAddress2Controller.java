package com.shyamdemo.learning_springboot.datajpa.one_to_one_bidirectional;

import com.shyamdemo.learning_springboot.datajpa.EntityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/one-to-one-bi/useraddress")
@RestController
public class UserAddress2Controller {

    @Autowired
    EntityService<UserAddress2> userAddressEntityService;

    @GetMapping
    public List<UserAddress2> getUserAddresss() {
        return userAddressEntityService.fetchAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAddress2> getUserAddressById(@PathVariable Long id) {
        return userAddressEntityService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserAddress2> createUserAddress(@RequestBody UserAddress2 userAddress) {
        return new ResponseEntity<>(userAddressEntityService.create(userAddress), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAddress2> updateUserAddress(@PathVariable Long id, @RequestBody UserAddress2 userAddress) {
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
