package com.example.web;

import com.example.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static java.util.UUID.randomUUID;

@RestController
@RequestMapping("/users")
@PreAuthorize("hasAuthority('SCOPE_cep-api-server/read')")
public class UsersController {

    private static Map<String, User> users = new TreeMap<>();

    @GetMapping
    public Collection<User> list() {
        return users.values();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        user.setId(randomUUID().toString());
        users.put(user.getId(), user);

        return user;
    }

    @GetMapping("/{id}")
    public User find(@PathVariable String id) {
        return users.get(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        users.remove(id);
    }

}
