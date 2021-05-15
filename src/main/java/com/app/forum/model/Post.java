package com.app.forum.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "Post")
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String comment;
    private Timestamp timestamp;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userid")
    private User userid;

    public Post() {

    }

    public Post(String comment, Timestamp timestamp) {
        this.comment = comment;
        this.timestamp = timestamp;
    }

    public Post(Long id, String comment, Timestamp timestamp, User userid) {
        this.id = id;
        this.comment = comment;
        this.timestamp = timestamp;
        this.userid = userid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", timestamp=" + timestamp +
                ", userid=" + userid +
                '}';
    }
}
