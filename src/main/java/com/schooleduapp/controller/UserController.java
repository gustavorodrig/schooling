package com.schooleduapp.controller;

import com.schooleduapp.entity.User;
import com.schooleduapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/users")
@Slf4j
@RequiredArgsConstructor
public class UserController
{
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findByCode(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if (!user.isPresent()) {
            log.error("User " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(user.get());
    }

    //TODO DELETE THIS SINCE A NEW USER IS CREATED WHEN ITS REGISTERED
    @PostMapping
    public ResponseEntity create(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    //TODO SEE HOW TO UPDATE PASSWORD, CAN'T CHANGE THE EMAIL
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @Valid @RequestBody User user) {
        if (!userService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!userService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
