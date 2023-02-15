package com.example.nawabClubSearch.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="highlightuser")
public class HighlightUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("contact")
    private String contact;

    @JsonProperty("contactemail")
    private String contactemail;

    @JsonIgnore
    @JsonProperty("createdon")
    private Date createdon;

    @JsonIgnore
    @JsonProperty("besttime")
    private Date besttime;

    @JsonIgnore
    @JsonProperty("count")
    private int count;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", referencedColumnName = "id")
    List < Book > books = new ArrayList< >();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactemail() {
        return contactemail;
    }

    public void setContactemail(String contactemail) {
        this.contactemail = contactemail;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    public Date getBesttime() {
        return besttime;
    }

    public void setBesttime(Date besttime) {
        this.besttime = besttime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
