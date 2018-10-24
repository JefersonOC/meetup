package io.github.blackfishlabs.demo.dao;

import io.github.blackfishlabs.demo.dao.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Mono<User> findByApiKey(String apiKey);
}
