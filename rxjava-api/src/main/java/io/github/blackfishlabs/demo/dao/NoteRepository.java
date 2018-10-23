package io.github.blackfishlabs.demo.dao;

import io.github.blackfishlabs.demo.dao.entity.Note;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface NoteRepository extends ReactiveMongoRepository<Note, String> {

    Mono<Note> findById(String id);
}
