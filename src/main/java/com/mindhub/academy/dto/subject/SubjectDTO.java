package com.mindhub.academy.dto.subject;

import com.mindhub.academy.models.Subject;

import java.util.Set;
import java.util.stream.Collectors;

public class SubjectDTO {

    private Long id;

    private String name;

    private Set<String> studentsName;

    private Set<String> teachersName;

    public SubjectDTO(Subject subject){
        id = subject.getId();
        name = subject.getName();
        studentsName = subject.getStudents().stream().map(student -> student.getFirstName() + " " + student.getLastName()).collect(Collectors.toSet());
        teachersName = subject.getWorkshops().stream().map(workshop -> workshop.getTeacher().getFirstName() + " " + workshop.getTeacher().getLastName()).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getStudentsName() {
        return studentsName;
    }

    public Set<String> getTeachersName() {
        return teachersName;
    }
}
