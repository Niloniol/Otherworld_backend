package ru.other_world.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "EVENTS")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "name")
    private TypeOfEvent typeOfEvent;

    @Column(name = "comments")
    private String comments;

    @Column(name = "timeFrom")
    private LocalDateTime timeFrom;

    @Column(name = "timeTo")
    private LocalDateTime timeTo;

    public Event(){
    }

    public Event(TypeOfEvent typeOfEvent, String comments,
                 LocalDateTime timeFrom, LocalDateTime timeTo) {
        this.typeOfEvent = typeOfEvent;
        this.comments = comments;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    public Event(Event event){
        id = event.id;
        typeOfEvent = event.typeOfEvent;
        comments = event.comments;
        timeFrom = event.timeFrom;
        timeTo = event.timeTo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeOfEvent getTypeOfEvent() {
        return typeOfEvent;
    }

    public void setTypeOfEvent(TypeOfEvent typeOfEvent) {
        this.typeOfEvent = typeOfEvent;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDateTime getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(LocalDateTime timeFrom) {
        this.timeFrom = timeFrom;
    }

    public LocalDateTime getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(LocalDateTime timeTo) {
        this.timeTo = timeTo;
    }
}
