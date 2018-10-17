package io.github.blackfishlabs.reactive.network;

import java.util.List;

import io.github.blackfishlabs.reactive.network.model.Note;
import io.github.blackfishlabs.reactive.network.model.User;
import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {

    @POST("notes/user/register/{id}")
    Single<User> register(@Path("id") String deviceId);

    @POST("notes/new")
    Single<Note> createNote(@Body Note note);

    @GET("notes/all")
    Single<List<Note>> fetchAllNotes();

    @PUT("notes/edit")
    Completable updateNote(@Body Note note);

    @DELETE("notes/{id}")
    Completable deleteNote(@Path("id") int noteId);
}
