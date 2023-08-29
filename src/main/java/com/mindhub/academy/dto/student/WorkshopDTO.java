package com.mindhub.academy.dto.student;

import com.mindhub.academy.models.Workshop;

import java.time.LocalDateTime;

public class WorkshopDTO {

    private Long id;

    private LocalDateTime time;

    private String teacherName;

    public WorkshopDTO(Workshop workshop){
        id = workshop.getId();
        time = workshop.getTime();
        teacherName = workshop.getTeacher().getFirstName() + " " + workshop.getTeacher().getLastName();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getTeacherName() {
        return teacherName;
    }
}
