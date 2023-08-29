package com.mindhub.academy.dto.teacher;

import com.mindhub.academy.models.Workshop;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class WorkshopDTO {

    private Long id;
    private LocalDateTime time;
    private String subject;
    private Set<String> students;

    public WorkshopDTO(Workshop workshop){
        id = workshop.getId();
        time = workshop.getTime();
        subject = workshop.getSubject().getName();
        students = workshop.getSubject().getStudents().stream().map(student -> student.getFirstName() + " " + student.getLastName()).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getSubject() {
        return subject;
    }

    public Set<String> getStudents() {
        return students;
    }
}
