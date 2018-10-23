package io.github.blackfishlabs.demo.web.controller;

import io.github.blackfishlabs.demo.dao.entity.Note;
import io.github.blackfishlabs.demo.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/all")
    public Flux<Note> findAll() {
        log.debug("findAll Notes");
        return noteService.findAll();
    }

    @DeleteMapping("/{id}")
    public Mono<Boolean> delete(@PathVariable String id) {
        log.debug("delete Note with id : {}", id);
        return noteService.delete(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Note> create(@RequestBody Note note) {
        log.debug("create Note with note : {}", note);
        return noteService.createNote(note);
    }

    @PutMapping("/edit/{id}")
    public Mono<Note> update(@RequestBody Note note, @PathVariable String id) {
        log.debug("update Note with id : {} and note : {}", id, note);
        return noteService.updateNote(note, id);
    }
}
