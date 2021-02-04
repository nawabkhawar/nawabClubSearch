package com.example.nawabClubSearch.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="judge")
public class Judge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="judgeid")
    private long judgeid;

    @JsonProperty("name")
    private String name;

    @JsonProperty("emailid")
    private String emailid;

    @JsonProperty("jsecret")
    private String jsecret;

    @JsonProperty("eventid")
    private long eventid;

    @JsonProperty("chiefjudgeid")
    private long chiefjudgeid;

    @JsonProperty("one")
    private String one;

    @JsonProperty("two")
    private String two;

    @JsonProperty("three")
    private String three;

    @JsonProperty("four")
    private String four;

    @JsonProperty("five")
    private String five;

    @JsonProperty("six")
    private String six;

    @JsonProperty("seven")
    private String seven;

    @JsonProperty("eight")
    private String eight;

    @JsonProperty("nine")
    private String nine;

    @JsonProperty("ten")
    private String ten;

    @JsonProperty("tiebreaker")
    private String tiebreaker;

    /*@OneToOne(fetch = FetchType.LAZY)
    @MapsId*/
    /*@JsonIgnore
    private Event event;
*/
    public long getJudgeid() {
        return judgeid;
    }

    public void setJudgeid(long judgeid) {
        this.judgeid = judgeid;
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

    public String getJsecret() {
        return jsecret;
    }

    public void setJsecret(String jsecret) {
        this.jsecret = jsecret;
    }

    public long getEventid() {
        return eventid;
    }

    public void setEventid(long eventid) {
        this.eventid = eventid;
    }

    public long getChiefjudgeid() {
        return chiefjudgeid;
    }

    public void setChiefjudgeid(long chiefjudgeid) {
        this.chiefjudgeid = chiefjudgeid;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three;
    }

    public String getFour() {
        return four;
    }

    public void setFour(String four) {
        this.four = four;
    }

    public String getFive() {
        return five;
    }

    public void setFive(String five) {
        this.five = five;
    }

    public String getSix() {
        return six;
    }

    public void setSix(String six) {
        this.six = six;
    }

    public String getSeven() {
        return seven;
    }

    public void setSeven(String seven) {
        this.seven = seven;
    }

    public String getEight() {
        return eight;
    }

    public void setEight(String eight) {
        this.eight = eight;
    }

    public String getNine() {
        return nine;
    }

    public void setNine(String nine) {
        this.nine = nine;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTiebreaker() {
        return tiebreaker;
    }

    public void setTiebreaker(String tiebreaker) {
        this.tiebreaker = tiebreaker;
    }

    /*public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }*/
}
