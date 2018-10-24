package io.github.blackfishlabs.demo.service.impl;

import io.github.blackfishlabs.demo.dao.UserRepository;
import io.github.blackfishlabs.demo.dao.entity.User;
import io.github.blackfishlabs.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<User> createUser(User user) {
        return userRepository.insert(user);
    }

    @Override
    public Mono<User> findOne(String id) {
        return userRepository.findById(id).switchIfEmpty(Mono.error(new Exception("No User found with key: " + id)));
    }
}
