package com.app.forum.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Post
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String comment;
    private Timestamp timestamp;

    private int userID;

//    @ManyToOne()
//    @JoinTable(name = "userPost", joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = @JoinColumn(name = "user"))
//    private User user;

    public Post()
    {

    }

    public Post(int id, int userID, String comment, Timestamp timestamp)
    {
        this.id = id;
        this.userID = userID;
        this.comment = comment;
        this.timestamp = timestamp;
    }

    public int getId()
    {
        return id;
    }

    public int getUserID()
    {
        return userID;
    }

    public String getComment()
    {
        return comment;
    }

    public Timestamp getTimestamp()
    {
        return timestamp;
    }
}
