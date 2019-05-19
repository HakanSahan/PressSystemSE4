package be.springPressOrder.services;

import be.springPressOrder.dao.PersonsRepository;
import be.springPressOrder.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Primary  // if there would be any confusion with InMemory implementation, this one should be chosen
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PersonsRepository personsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Person user = personsRepository.findByUsername(username);
        if (user != null) return user;
        throw new UsernameNotFoundException("Person "+username+" not found!");
    }
}