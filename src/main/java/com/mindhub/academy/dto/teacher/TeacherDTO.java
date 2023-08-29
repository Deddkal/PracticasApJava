package com.mindhub.academy.dto.teacher;

import com.mindhub.academy.models.Person;
import com.mindhub.academy.models.RolType;

import java.util.Set;
import java.util.stream.Collectors;

public class TeacherDTO {
    private Long id;
    private String firstName, lastName;
    private String email;
    private RolType rolType;
    private Set<WorkshopDTO> workshops;

    public TeacherDTO(Person person){
       id = person.getId();
       firstName = person.getFirstName();
       lastName = person.getLastName();
       email = person.getEmail();
       rolType = person.getRolType();
       workshops = person.getWorkshops().stream().map(workshop -> new WorkshopDTO(workshop)).collect(Collectors.toSet());
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

    public Set<WorkshopDTO> getWorkshops() {
        return workshops;
    }
}
