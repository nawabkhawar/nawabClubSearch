package com.example.nawabClubSearch.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="eventid")
    private long eventid;

    @JsonProperty("eventname")
    private String eventname;

    @JsonProperty("participant1")
    private String participant1;

    @JsonProperty("participant2")
    private String participant2;

    @JsonProperty("participant3")
    private String participant3;

    @JsonProperty("participant4")
    private String participant4;

    @JsonProperty("participant5")
    private String participant5;

    @JsonProperty("participant6")
    private String participant6;

    @JsonProperty("participant7")
    private String participant7;

    @JsonProperty("participant8")
    private String participant8;

    @JsonProperty("participant9")
    private String participant9;

    @JsonProperty("participant10")
    private String participant10;

    @JsonProperty("eventtype")
    private String eventtype;

    public long getEventid() {
        return eventid;
    }

    public void setEventid(long eventid) {
        this.eventid = eventid;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getParticipant1() {
        return participant1;
    }

    public void setParticipant1(String participant1) {
        this.participant1 = participant1;
    }

    public String getParticipant2() {
        return participant2;
    }

    public void setParticipant2(String participant2) {
        this.participant2 = participant2;
    }

    public String getParticipant3() {
        return participant3;
    }

    public void setParticipant3(String participant3) {
        this.participant3 = participant3;
    }

    public String getParticipant4() {
        return participant4;
    }

    public void setParticipant4(String participant4) {
        this.participant4 = participant4;
    }

    public String getParticipant5() {
        return participant5;
    }

    public void setParticipant5(String participant5) {
        this.participant5 = participant5;
    }

    public String getParticipant6() {
        return participant6;
    }

    public void setParticipant6(String participant6) {
        this.participant6 = participant6;
    }

    public String getParticipant7() {
        return participant7;
    }

    public void setParticipant7(String participant7) {
        this.participant7 = participant7;
    }

    public String getParticipant8() {
        return participant8;
    }

    public void setParticipant8(String participant8) {
        this.participant8 = participant8;
    }

    public String getParticipant9() {
        return participant9;
    }

    public void setParticipant9(String participant9) {
        this.participant9 = participant9;
    }

    public String getParticipant10() {
        return participant10;
    }

    public void setParticipant10(String participant10) {
        this.participant10 = participant10;
    }

    public String getEventtype() {
        return eventtype;
    }

    public void setEventtype(String eventtype) {
        this.eventtype = eventtype;
    }
}
