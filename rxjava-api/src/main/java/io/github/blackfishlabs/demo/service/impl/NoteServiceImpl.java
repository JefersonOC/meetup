package io.github.blackfishlabs.demo.service.impl;

import io.github.blackfishlabs.demo.dao.NoteRepository;
import io.github.blackfishlabs.demo.dao.entity.Note;
import io.github.blackfishlabs.demo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Mono<Note> createNote(Note note) {
        return noteRepository.insert(note);
    }

    @Override
    public Mono<Note> updateNote(Note note, String id) {
        return findOne(id).doOnSuccess(findBlog -> {
            findBlog.setNote(note.getNote());
            findBlog.setTimestamp(note.getTimestamp());
            noteRepository.save(findBlog).subscribe();
        });
    }

    @Override
    public Flux<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Mono<Note> findOne(String id) {
        return noteRepository.findById(id).switchIfEmpty(Mono.error(new Exception("No Note found with Id: " + id)));
    }

    @Override
    public Mono<Boolean> delete(String id) {
        return findOne(id).doOnSuccess(note -> {
            note.setDelete(true);
            noteRepository.save(note).subscribe();
        }).flatMap(blog -> Mono.just(Boolean.TRUE));
    }
}
