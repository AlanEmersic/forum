package com.app.forum.command;


import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

public class PostCommand {

    @NotBlank(message = "comment must not be empty")
    private String comment;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy. HH:mm:ss")
    private Timestamp timestamp;

    public String getComment() {
        return comment;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
