package com.example.nawabClubSearch.dto;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name="CLUB")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

  /*  @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email",nullable = false, length = 200)
    private String email;*/

    @JsonProperty("District")
    private String district;
    @JsonProperty("Division")
    private String division;
    @JsonProperty("Area")
    private String area;

    @Column(unique = true)
    @JsonProperty("Club")
    private String club;
    @JsonProperty("Clubname")
    private String clubname;
    @JsonProperty("Clubest")
    private String clubest;
    @JsonProperty("Clubstatus")
    private String clubstatus;
    @JsonProperty("Clubaddr1")
    private String clubaddr1;
    @JsonProperty("Clubaddr2")
    private String clubaddr2;
    @JsonProperty("Clubcity")
    private String clubcity;
    @JsonProperty("Clubstate")
    private String clubstate;
    @JsonProperty("Clubzip")
    private String clubzip;
    @JsonProperty("Clubcountry")
    private String clubcountry;
    @JsonProperty("Clubphone")
    private String clubphone;
    @JsonProperty("Clubday_o")
    private String clubday_o;
    @JsonProperty("Clubtime_o")
    private String clubtime_o;
    @JsonProperty("Clubday")
    private String clubday;
    @JsonProperty("Clubtime")
    private String clubtime;
    @JsonProperty("Clublen")
    private String clublen;
    @JsonProperty("Clubfreq")
    private String clubfreq;
    @JsonProperty("Clubopen")
    private String clubopen;
    @JsonProperty("Cluburl1")
    private String cluburl1;
    @JsonProperty("Cluburl2")
    private String cluburl2;
    @JsonProperty("Clubwebstat1")
    private String clubwebstat1;
    @JsonProperty("Clubwebstat2")
    private String clubwebstat2;
    @JsonProperty("Clubemail")
    private String clubemail;
    @JsonProperty("Clubadvanced")
    private String clubadvanced;
    @JsonProperty("updatedon")
    private Date updatedon;

    /*@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty("District")
    public String getDistrict() {
        return district;
    }

    @JsonProperty("District")
    public void setDistrict(String district) {
        this.district = district;
    }

    @JsonProperty("Division")
    public String getDivision() {
        return division;
    }

    @JsonProperty("Division")
    public void setDivision(String division) {
        this.division = division;
    }

    @JsonProperty("Area")
    public String getArea() {
        return area;
    }

    @JsonProperty("Area")
    public void setArea(String area) {
        this.area = area;
    }

    @JsonProperty("Club")
    public String getClub() {
        return club;
    }

    @JsonProperty("Club")
    public void setClub(String club) {
        this.club = club;
    }

    @JsonProperty("Clubname")
    public String getClubname() {
        return clubname;
    }

    @JsonProperty("Clubname")
    public void setClubname(String clubname) {
        this.clubname = clubname;
    }

    @JsonProperty("Clubest")
    public String getClubest() {
        return clubest;
    }

    @JsonProperty("Clubest")
    public void setClubest(String clubest) {
        this.clubest = clubest;
    }

    @JsonProperty("Clubstatus")
    public String getClubstatus() {
        return clubstatus;
    }

    @JsonProperty("Clubstatus")
    public void setClubstatus(String clubstatus) {
        this.clubstatus = clubstatus;
    }

    @JsonProperty("Clubaddr1")
    public String getClubaddr1() {
        return clubaddr1;
    }

    @JsonProperty("Clubaddr1")
    public void setClubaddr1(String clubaddr1) {
        this.clubaddr1 = clubaddr1;
    }

    @JsonProperty("Clubaddr2")
    public String getClubaddr2() {
        return clubaddr2;
    }

    @JsonProperty("Clubaddr2")
    public void setClubaddr2(String clubaddr2) {
        this.clubaddr2 = clubaddr2;
    }

    @JsonProperty("Clubcity")
    public String getClubcity() {
        return clubcity;
    }

    @JsonProperty("Clubcity")
    public void setClubcity(String clubcity) {
        this.clubcity = clubcity;
    }

    @JsonProperty("Clubstate")
    public String getClubstate() {
        return clubstate;
    }

    @JsonProperty("Clubstate")
    public void setClubstate(String clubstate) {
        this.clubstate = clubstate;
    }

    @JsonProperty("Clubzip")
    public String getClubzip() {
        return clubzip;
    }

    @JsonProperty("Clubzip")
    public void setClubzip(String clubzip) {
        this.clubzip = clubzip;
    }

    @JsonProperty("Clubcountry")
    public String getClubcountry() {
        return clubcountry;
    }

    @JsonProperty("Clubcountry")
    public void setClubcountry(String clubcountry) {
        this.clubcountry = clubcountry;
    }

    @JsonProperty("Clubphone")
    public String getClubphone() {
        return clubphone;
    }

    @JsonProperty("Clubphone")
    public void setClubphone(String clubphone) {
        this.clubphone = clubphone;
    }

    @JsonProperty("Clubday_o")
    public String getClubdayO() {
        return clubday_o;
    }

    @JsonProperty("Clubday_o")
    public void setClubdayO(String clubdayO) {
        this.clubday_o = clubdayO;
    }

    @JsonProperty("Clubtime_o")
    public String getClubtimeO() {
        return clubtime_o;
    }

    @JsonProperty("Clubtime_o")
    public void setClubtimeO(String clubtimeO) {
        this.clubtime_o = clubtimeO;
    }

    @JsonProperty("Clubday")
    public String getClubday() {
        return clubday;
    }

    @JsonProperty("Clubday")
    public void setClubday(String clubday) {
        this.clubday = clubday;
    }

    @JsonProperty("Clubtime")
    public String getClubtime() {
        return clubtime;
    }

    @JsonProperty("Clubtime")
    public void setClubtime(String clubtime) {
        this.clubtime = clubtime;
    }

    @JsonProperty("Clublen")
    public String getClublen() {
        return clublen;
    }

    @JsonProperty("Clublen")
    public void setClublen(String clublen) {
        this.clublen = clublen;
    }

    @JsonProperty("Clubfreq")
    public String getClubfreq() {
        return clubfreq;
    }

    @JsonProperty("Clubfreq")
    public void setClubfreq(String clubfreq) {
        this.clubfreq = clubfreq;
    }

    @JsonProperty("Clubopen")
    public String getClubopen() {
        return clubopen;
    }

    @JsonProperty("Clubopen")
    public void setClubopen(String clubopen) {
        this.clubopen = clubopen;
    }

    @JsonProperty("Cluburl1")
    public String getCluburl1() {
        return cluburl1;
    }

    @JsonProperty("Cluburl1")
    public void setCluburl1(String cluburl1) {
        this.cluburl1 = cluburl1;
    }

    @JsonProperty("Cluburl2")
    public String getCluburl2() {
        return cluburl2;
    }

    @JsonProperty("Cluburl2")
    public void setCluburl2(String cluburl2) {
        this.cluburl2 = cluburl2;
    }

    @JsonProperty("Clubwebstat1")
    public String getClubwebstat1() {
        return clubwebstat1;
    }

    @JsonProperty("Clubwebstat1")
    public void setClubwebstat1(String clubwebstat1) {
        this.clubwebstat1 = clubwebstat1;
    }

    @JsonProperty("Clubwebstat2")
    public String getClubwebstat2() {
        return clubwebstat2;
    }

    @JsonProperty("Clubwebstat2")
    public void setClubwebstat2(String clubwebstat2) {
        this.clubwebstat2 = clubwebstat2;
    }

    @JsonProperty("Clubemail")
    public String getClubemail() {
        return clubemail;
    }

    @JsonProperty("Clubemail")
    public void setClubemail(String clubemail) {
        this.clubemail = clubemail;
    }

    @JsonProperty("Clubadvanced")
    public String getClubadvanced() {
        return clubadvanced;
    }

    @JsonProperty("Clubadvanced")
    public void setClubadvanced(String clubadvanced) {
        this.clubadvanced = clubadvanced;
    }

    /*@JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }*/

    /*@JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }*/


}
