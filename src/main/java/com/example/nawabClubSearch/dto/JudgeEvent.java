package com.example.nawabClubSearch.dto;

import java.util.List;

public class JudgeEvent {

    private Judge judge;
    private Event event;
    private ChiefJudge chiefJudge;
    private List<Judge> judges;



    public Judge getJudge() {
        return judge;
    }

    public void setJudge(Judge judge) {
        this.judge = judge;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event events) {
        this.event = events;
    }

    public ChiefJudge getChiefJudge() {
        return chiefJudge;
    }

    public void setChiefJudge(ChiefJudge chiefJudge) {
        this.chiefJudge = chiefJudge;
    }

    public List<Judge> getJudges() {
        return judges;
    }

    public void setJudges(List<Judge> judges) {
        this.judges = judges;
    }
}
