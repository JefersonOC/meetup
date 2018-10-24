package io.github.blackfishlabs.demo.web.controller;

import io.github.blackfishlabs.demo.dao.entity.User;
import io.github.blackfishlabs.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/v1/notes/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> create(@PathVariable String id) {
        log.debug("create User with key : {}", id);
        return userService.createUser(new User(id));
    }
}
