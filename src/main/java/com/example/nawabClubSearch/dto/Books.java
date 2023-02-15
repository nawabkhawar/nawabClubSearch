package com.example.nawabClubSearch.dto;

import java.util.List;

public class Books {

    private long id;
    private List<Highlight> highlightList;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Highlight> getHighlightList() {
        return highlightList;
    }

    public void setHighlightList(List<Highlight> highlightList) {
        this.highlightList = highlightList;
    }
}
