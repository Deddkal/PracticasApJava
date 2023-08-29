package com.mindhub.academy.dto.student;


import com.mindhub.academy.models.Person;
import com.mindhub.academy.models.RolType;

import java.util.Set;
import java.util.stream.Collectors;

public class StudentDTO {

    private Long id;
    private String firstName, lastName;
    private String email;
    private RolType rolType;
    private Set<SubjectDTO> subjects;

    public StudentDTO(Person person){
        id = person.getId();
        firstName = person.getFirstName();
        lastName = person.getLastName();
        email = person.getEmail();
        rolType = person.getRolType();
        subjects = person.getSubjects().stream().map(subject -> new SubjectDTO(subject)).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public RolType getRolType() {
        return rolType;
    }

    public Set<SubjectDTO> getSubjects() {
        return subjects;
    }
}
