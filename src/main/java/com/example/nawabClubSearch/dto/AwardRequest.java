package com.example.nawabClubSearch.dto;

import java.util.List;

public class AwardRequest {
        String clubName;
        String clubNumber;
        String area;
        String division;
        String district;
        List<Award> awards;
        String clubEmail;
        String meetingNumber;

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubNumber() {
        return clubNumber;
    }

    public void setClubNumber(String clubNumber) {
        this.clubNumber = clubNumber;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public List<Award> getAwards() {
        return awards;
    }

    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }

    public String getClubEmail() {
        return clubEmail;
    }

    public void setClubEmail(String clubEmail) {
        this.clubEmail = clubEmail;
    }

    public String getMeetingNumber() {
        return meetingNumber;
    }

    public void setMeetingNumber(String meetingNumber) {
        this.meetingNumber = meetingNumber;
    }
}

