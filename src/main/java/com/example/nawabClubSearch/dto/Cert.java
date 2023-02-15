package com.example.nawabClubSearch.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="certgen")
public class Cert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @JsonProperty("createdtime")
    private Date createdtime;

    @JsonProperty("clubname")
    private String clubname;

    @JsonProperty("meetingnumber")
    private String meetingnumber;

    @JsonProperty("clubnumber")
    private String clubnumber;

    @JsonProperty("area")
    private String area;

    @JsonProperty("division")
    private String division;

    @JsonProperty("district")
    private String district;

    @JsonProperty("date")
    private String date;

    @JsonProperty("clubemail")
    private String clubemail;

    @JsonProperty("award1")
    private String award1;

    @JsonProperty("rec1")
    private String rec1;

    @JsonProperty("award2")
    private String award2;

    @JsonProperty("rec2")
    private String rec2;

    @JsonProperty("award3")
    private String award3;

    @JsonProperty("rec3")
    private String rec3;

    @JsonProperty("award4")
    private String award4;

    @JsonProperty("rec4")
    private String rec4;

    @JsonProperty("award5")
    private String award5;

    @JsonProperty("rec5")
    private String rec5;

    @JsonProperty("award6")
    private String award6;

    @JsonProperty("rec6")
    private String rec6;

    @JsonProperty("emailtext")
    private String emailtext;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public String getClubname() {
        return clubname;
    }

    public void setClubname(String clubname) {
        this.clubname = clubname;
    }

    public String getMeetingnumber() {
        return meetingnumber;
    }

    public void setMeetingnumber(String meetingnumber) {
        this.meetingnumber = meetingnumber;
    }

    public String getClubnumber() {
        return clubnumber;
    }

    public void setClubnumber(String clubnumber) {
        this.clubnumber = clubnumber;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClubemail() {
        return clubemail;
    }

    public void setClubemail(String clubemail) {
        this.clubemail = clubemail;
    }

    public String getAward1() {
        return award1;
    }

    public void setAward1(String award1) {
        this.award1 = award1;
    }

    public String getRec1() {
        return rec1;
    }

    public void setRec1(String rec1) {
        this.rec1 = rec1;
    }

    public String getAward2() {
        return award2;
    }

    public void setAward2(String award2) {
        this.award2 = award2;
    }

    public String getRec2() {
        return rec2;
    }

    public void setRec2(String rec2) {
        this.rec2 = rec2;
    }

    public String getAward3() {
        return award3;
    }

    public void setAward3(String award3) {
        this.award3 = award3;
    }

    public String getRec3() {
        return rec3;
    }

    public void setRec3(String rec3) {
        this.rec3 = rec3;
    }

    public String getAward4() {
        return award4;
    }

    public void setAward4(String award4) {
        this.award4 = award4;
    }

    public String getRec4() {
        return rec4;
    }

    public void setRec4(String rec4) {
        this.rec4 = rec4;
    }

    public String getAward5() {
        return award5;
    }

    public void setAward5(String award5) {
        this.award5 = award5;
    }

    public String getRec5() {
        return rec5;
    }

    public void setRec5(String rec5) {
        this.rec5 = rec5;
    }

    public String getAward6() {
        return award6;
    }

    public void setAward6(String award6) {
        this.award6 = award6;
    }

    public String getRec6() {
        return rec6;
    }

    public void setRec6(String rec6) {
        this.rec6 = rec6;
    }

    public String getEmailtext() {
        return emailtext;
    }

    public void setEmailtext(String emailtext) {
        this.emailtext = emailtext;
    }
}
