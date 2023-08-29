package com.mindhub.academy.dto.student;

import com.mindhub.academy.models.Subject;

import java.util.Set;
import java.util.stream.Collectors;

public class SubjectDTO {

    private Long id;

    private String name;

    private Set<WorkshopDTO> workshops;

    public SubjectDTO(Subject subject){
        id = subject.getId();
        name = subject.getName();
        workshops = subject.getWorkshops().stream().map(workshop -> new WorkshopDTO(workshop)).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<WorkshopDTO> getWorkshops() {
        return workshops;
    }
}
