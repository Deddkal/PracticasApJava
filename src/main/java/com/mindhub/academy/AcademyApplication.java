package com.mindhub.academy;

import com.mindhub.academy.models.Person;
import com.mindhub.academy.models.RolType;
import com.mindhub.academy.models.Subject;
import com.mindhub.academy.models.Workshop;
import com.mindhub.academy.repositories.PersonRepository;
import com.mindhub.academy.repositories.SubjectRepository;
import com.mindhub.academy.repositories.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.time.LocalDateTime;

@SpringBootApplication
public class AcademyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademyApplication.class, args);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner initData(PersonRepository personRepository, SubjectRepository subjectRepository, WorkshopRepository workshopRepository){
		return args -> {

			Person admin = new Person("Admin", "Admin", passwordEncoder.encode("123456"), "admin@mindhub.com" );
			admin.setRolType(RolType.ADMIN);
			personRepository.save(admin);

			Subject subject = new Subject("JAVA");
			subjectRepository.save(subject);

			Person student = new Person("Juan","Garcia", passwordEncoder.encode("123456"), "juan@mindhub.com" );
			personRepository.save(student);

			Person teacher = new Person("Elias", "Medina", passwordEncoder.encode("123456"), "elias@mindhub.com" );
			teacher.setRolType(RolType.TEACHER);
			personRepository.save(teacher);

			Workshop workshop = new Workshop(LocalDateTime.of(2023,8,28,14,20));
			teacher.addWorkshop(workshop);
			subject.addWorkshop(workshop);
			workshopRepository.save(workshop);

			student.addSubject(subject);
			subjectRepository.save(subject);
		};
	}
}
