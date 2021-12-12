package com.example.JazProject.objects;

import javax.persistence.*;

@Entity
@Table(name = "twett")
public class Tweets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String data;
    private String text;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Tweets() {
    }

    public Tweets(int id, String data, String text, User user) {
        this.id = id;
        this.data = data;
        this.text = text;
        this.user = user;
    }

    public int getTweet_id() {
        return id;
    }

    public void setTweet_id(int tweet_id) {
        this.id = tweet_id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
