package com.example.demo.service;

import com.example.demo.pojo.Person;

import java.util.List;

public interface CustomPersonService {

    void update(Person person);

    void insert(Person person);

    void insertList(List<Person> personList);
}
