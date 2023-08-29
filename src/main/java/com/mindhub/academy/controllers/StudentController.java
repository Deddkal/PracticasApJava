package com.mindhub.academy.controllers;

import com.mindhub.academy.dto.student.StudentDTO;
import com.mindhub.academy.models.Person;
import com.mindhub.academy.models.Subject;
import com.mindhub.academy.repositories.PersonRepository;
import com.mindhub.academy.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    //Tomar el estudiante autenticado y asignar la materia JAVA

    @PostMapping("/student/current/subject")
    public ResponseEntity<Object> addSubject(Authentication authentication, @RequestParam Long id){

        Person student = personRepository.findByEmail(authentication.getName());

        Subject subject = subjectRepository.findById(id).orElse(null);

        if (subject != null){
            student.addSubject(subject);
            personRepository.save(student);
            subjectRepository.save(subject);
            return new ResponseEntity<>(new StudentDTO(student),HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("Subject dont exist",HttpStatus.I_AM_A_TEAPOT);
        }

    }

}
