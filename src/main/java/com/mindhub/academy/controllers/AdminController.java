package com.mindhub.academy.controllers;

import com.mindhub.academy.dto.subject.SubjectDTO;
import com.mindhub.academy.dto.teacher.TeacherDTO;
import com.mindhub.academy.models.Person;
import com.mindhub.academy.models.RolType;
import com.mindhub.academy.repositories.PersonRepository;
import com.mindhub.academy.repositories.SubjectRepository;
import com.mindhub.academy.repositories.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private WorkshopRepository workshopRepository;


    @GetMapping("/admin/teachers")
    public List<TeacherDTO> getAllTeachers(){
        return personRepository.findAll().stream().filter(person -> person.getRolType().equals(RolType.TEACHER)).map(teacher -> new TeacherDTO(teacher)).collect(Collectors.toList());
    }

    @GetMapping("/admin/subjects")
    public List<SubjectDTO> getAllSubjects(){
        return subjectRepository.findAll().stream().map(subject -> new SubjectDTO(subject)).collect(Collectors.toList());
    }

    @PatchMapping("/admin/teacher/{id}")
    public ResponseEntity<Object> addNewTeacher(@PathVariable Long id){
        Person teacher = personRepository.findById(id).orElse(null);
        if (teacher!=null){
            teacher.setRolType(RolType.TEACHER);
            personRepository.save(teacher);
            return new ResponseEntity<>(new TeacherDTO(teacher), HttpStatus.ACCEPTED);
        }else{
         return new ResponseEntity<>("Person not found", HttpStatus.FORBIDDEN);
        }
    }
}
