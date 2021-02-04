package com.example.nawabClubSearch.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="chiefjudge")
public class ChiefJudge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="chiefjudgeid")
    private long chiefjudgeid;

    @JsonProperty("name")
    private String name;

    @JsonProperty("emailid")
    private String emailid;

    @JsonProperty("cjsecret")
    private String cjsecret;

    @JsonProperty("eventid")
    private long eventid;

    public long getChiefjudgeid() {
        return chiefjudgeid;
    }

    public void setChiefjudgeid(long chiefjudgeid) {
        this.chiefjudgeid = chiefjudgeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getCjsecret() {
        return cjsecret;
    }

    public void setCjsecret(String cjsecret) {
        this.cjsecret = cjsecret;
    }

    public long getEventid() {
        return eventid;
    }

    public void setEventid(long eventid) {
        this.eventid = eventid;
    }
}
