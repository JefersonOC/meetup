package io.github.blackfishlabs.demo.service;

import io.github.blackfishlabs.demo.dao.entity.User;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<User> createUser(User user);

    Mono<User> findOne(String id);
}
