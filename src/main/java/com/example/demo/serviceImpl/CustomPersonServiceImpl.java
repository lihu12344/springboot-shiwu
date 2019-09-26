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
public class CustomPersonServiceImpl implements CustomPersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Person person) {
        personMapper.updateById(person);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void insert(Person person) {
        personMapper.insert(person);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertList(List<Person> personList) {
        for(Person person:personList){
            insert(person);
        }
    }
}
