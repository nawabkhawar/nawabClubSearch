package com.example.nawabClubSearch.dto;

import java.util.List;

public class HighlightUsers {

    private long userId;
    private String username;
    //private List<Books> bookList;
    private String useremail;
    private String sendToEmail;
    private List<Highlight> highlightList;

    /*public List<Books> getBookList() {
        return bookList;
    }

    public void setBookList(List<Books> bookList) {
        this.bookList = bookList;
    }*/

    public List<Highlight> getHighlightList() {
        return this.highlightList;
    }

    public void setHighlightList(List<Highlight> highlightList) {
        this.highlightList = highlightList;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getSendToEmail() {
        return sendToEmail;
    }

    public void setSendToEmail(String sendToEmail) {
        this.sendToEmail = sendToEmail;
    }
}
