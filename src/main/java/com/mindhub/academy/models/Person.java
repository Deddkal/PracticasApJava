package com.mindhub.academy.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName, lastName, password;
    @Column(unique = true)
    private String email;

    private RolType rolType;

    @ManyToMany(mappedBy = "students", fetch = FetchType.EAGER)
    private Set<Subject> subjects = new HashSet<>();

    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
    private Set<Workshop> workshops = new HashSet<>();

    public Person() {
    }

    public Person(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.rolType = RolType.STUDENT;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RolType getRolType() {
        return rolType;
    }

    public void setRolType(RolType rolType) {
        this.rolType = rolType;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public Set<Workshop> getWorkshops() {
        return workshops;
    }

    public void addWorkshop(Workshop workshop){
        if(this.rolType.equals(RolType.TEACHER)){
            workshop.setTeacher(this);
            workshops.add(workshop);
        }
    }

    public void addSubject(Subject subject){
        if (this.rolType.equals(RolType.STUDENT)){
            subject.getStudents().add(this);
            subjects.add(subject);
        }
    }
}
