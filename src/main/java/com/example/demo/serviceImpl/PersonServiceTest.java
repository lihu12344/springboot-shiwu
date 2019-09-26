package com.example.demo.serviceImpl;

import com.example.demo.dao.PersonMapper;
import com.example.demo.pojo.Person;
import com.example.demo.service.CustomPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceTest {

    @Autowired
    private CustomPersonService personService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertList(List<Person> personList){
        for(Person person:personList){
            personService.insert(person);
        }
    }
}
