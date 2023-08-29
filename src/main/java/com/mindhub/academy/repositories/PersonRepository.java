package com.mindhub.academy.repositories;

import com.mindhub.academy.models.Person;
import com.mindhub.academy.models.RolType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByEmail(String email);
}
