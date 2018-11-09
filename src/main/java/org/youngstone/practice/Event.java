package org.youngstone.practice;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class Event {

    public String name;

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date eventDate;

    public Event(String party, Date date) {

        this.name = party;
        this.eventDate = date;
    }
}
