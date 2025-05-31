package com.shyamdemo.learning_springboot.datajpa.one_to_one_bidirectional;

import com.shyamdemo.learning_springboot.datajpa.EntityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/one-to-one-bi/userdetails")
@RestController
public class UserDetail2Controller {

    @Autowired
    EntityService<UserDetail2> userDetail1OneToOneBiService;

    /*
     */
    @GetMapping
    public List<UserDetail2> getUserDetails() {
        return userDetail1OneToOneBiService.fetchAll();
    }

    /*
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDetail2> getUserDetailById(@PathVariable Long id) {
        return userDetail1OneToOneBiService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*
     */
    @PostMapping
    public ResponseEntity<UserDetail2> createUserDetail(@RequestBody UserDetail2 userDetail) {
        return new ResponseEntity<>(userDetail1OneToOneBiService.create(userDetail), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDetail2> updateUserDetail(@PathVariable Long id, @RequestBody UserDetail2 userDetail) {
        try {
            return ResponseEntity.ok(userDetail1OneToOneBiService.update(id, userDetail));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserDetail(@PathVariable Long id) {
        try {
            userDetail1OneToOneBiService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
