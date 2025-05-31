package com.shyamdemo.learning_springboot.datajpa.one_to_one_unidirectional;

import com.shyamdemo.learning_springboot.datajpa.EntityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/one-to-one-uni/userdetails")
@RestController
public class UserDetail1Controller {

    @Autowired
    EntityService<UserDetail1> userDetail1EntityService;

    /*
    Hibernate: select ud1_0.id,ud1_0.age,ud1_0.name,ud1_0.address_id from user_details1 ud1_0
    Hibernate: select ua1_0.id,ua1_0.city,ua1_0.country,ua1_0.pin_code,ua1_0.state,ua1_0.street from user_addresses1 ua1_0 where ua1_0.id=?
     */
    @GetMapping
    public List<UserDetail1> getUserDetails() {
        return userDetail1EntityService.fetchAll();
    }

    /*
    Hibernate: select ud1_0.id,ud1_0.age,ud1_0.name,ua1_0.id,ua1_0.city,ua1_0.country,ua1_0.pin_code,ua1_0.state,ua1_0.street from user_details1 ud1_0 left join user_addresses1 ua1_0 on ua1_0.id=ud1_0.address_id where ud1_0.id=?
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDetail1> getUserDetailById(@PathVariable Long id) {
        return userDetail1EntityService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*
    (if address is given: ) Hibernate: insert into user_addresses1 (city,country,pin_code,state,street,id) values (?,?,?,?,?,default)
    Hibernate: insert into user_details1 (age,name,address_id,id) values (?,?,?,default)
     */
    @PostMapping
    public ResponseEntity<UserDetail1> createUserDetail(@RequestBody UserDetail1 userDetail) {
        return new ResponseEntity<>(userDetail1EntityService.create(userDetail), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDetail1> updateUserDetail(@PathVariable Long id, @RequestBody UserDetail1 userDetail) {
        try {
            return ResponseEntity.ok(userDetail1EntityService.update(id, userDetail));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserDetail(@PathVariable Long id) {
        try {
            userDetail1EntityService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
