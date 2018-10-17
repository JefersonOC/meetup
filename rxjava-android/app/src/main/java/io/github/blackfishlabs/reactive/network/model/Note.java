package io.github.blackfishlabs.reactive.network.model;

public class Note extends BaseResponse {

    int id;
    String note;
    String timestamp;

    public Note(String note) {
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
