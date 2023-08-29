package com.mindhub.academy.configurations;

import com.mindhub.academy.models.Person;
import com.mindhub.academy.models.RolType;
import com.mindhub.academy.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    private PersonRepository personRepository;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(inputName->{
            Person person = personRepository.findByEmail(inputName);
            if(person != null){
                if (person.getRolType().equals(RolType.ADMIN)){
                    return new User(person.getEmail(), person.getPassword(),
                            AuthorityUtils.createAuthorityList("ADMIN"));
                } else if (person.getRolType().equals(RolType.TEACHER)) {
                    return new User(person.getEmail(), person.getPassword(),
                            AuthorityUtils.createAuthorityList("TEACHER"));
                }else {
                    return new User(person.getEmail(), person.getPassword(),
                            AuthorityUtils.createAuthorityList("STUDENT"));
                }
            }else {
              throw new UsernameNotFoundException("Email not found: " + inputName);
            }
        });
    }
}
