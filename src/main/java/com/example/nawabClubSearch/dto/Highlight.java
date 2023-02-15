package com.example.nawabClubSearch.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="highlight_highlights")
public class Highlight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @JsonProperty("bookid")
    private long bookid;

    @JsonProperty("text")
    private String text;

    @JsonProperty("liked")
    private boolean liked;

    @JsonProperty("likedon")
    private Date likedon;

    @JsonProperty("rating")
    private int rating;

    @JsonProperty("createdon")
    private Date createdon;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getLikedon() {
        return likedon;
    }

    public void setLikedon(Date likedon) {
        this.likedon = likedon;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }
}
