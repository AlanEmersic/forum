package com.app.forum.DTO;

import java.sql.Timestamp;

public class PostDTO {

    private String comment;
    private Timestamp timestamp;

    public PostDTO(String comment, Timestamp timestamp) {
        this.comment = comment;
        this.timestamp = timestamp;
    }

    public String getComment() {
        return comment;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
