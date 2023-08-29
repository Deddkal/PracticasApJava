package com.mindhub.academy.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Person> students = new HashSet<>();

    @OneToMany(mappedBy = "subject", fetch = FetchType.EAGER)
    private Set<Workshop> workshops = new HashSet<>();

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Person> getStudents() {
        return students;
    }

    public void setStudents(Set<Person> students) {
        this.students = students;
    }

    public Set<Workshop> getWorkshops() {
        return workshops;
    }

    public void addWorkshop(Workshop workshop){
        workshop.setSubject(this);
        workshops.add(workshop);
    }
}
