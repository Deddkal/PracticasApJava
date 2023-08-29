package com.mindhub.academy.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime time;
    @ManyToOne(fetch = FetchType.EAGER)
    private Person teacher;

    @ManyToOne(fetch = FetchType.EAGER)
    private Subject subject;

    public Workshop() {
    }

    public Workshop(LocalDateTime time) {
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
