package io.github.blackfishlabs.demo.service;

import io.github.blackfishlabs.demo.dao.entity.Note;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NoteService {

    Mono<Note> createNote(Note note);

    Mono<Note> updateNote(Note note, String id);

    Flux<Note> findAll();

    Mono<Note> findOne(String id);

    Mono<Boolean> delete(String id);
}
