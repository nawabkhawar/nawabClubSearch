package com.example.nawabClubSearch.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="highlightbook")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @JsonProperty("userid")
    private long userid;

    @JsonProperty("amazonid")
    private String amazonid;

    @JsonProperty("remarks")
    private String remarks;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    List < Highlight > highlights = new ArrayList< >();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getAmazonid() {
        return amazonid;
    }

    public void setAmazonid(String amazonid) {
        this.amazonid = amazonid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List getHighlights() {
        return highlights;
    }

    public void setHighlights(List highlights) {
        this.highlights = highlights;
    }
}
