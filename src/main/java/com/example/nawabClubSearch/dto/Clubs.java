package com.example.nawabClubSearch.dto;

import java.util.ArrayList;
import java.util.List;

public class Clubs {

    private List<Club> clubList;

    public List<Club> getClubList() {
        if(clubList ==null){
            new ArrayList<Club>();
        }
        return clubList;
    }

    public void setClubList(List<Club> clubList) {
        this.clubList = clubList;
    }
}
