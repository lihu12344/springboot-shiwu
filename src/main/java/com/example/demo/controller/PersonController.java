package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.pojo.Person;
import com.example.demo.service.CustomPersonService;
import com.example.demo.service.PersonService;
import com.example.demo.serviceImpl.PersonServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lihu
 * @since 2019-09-26
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private CustomPersonService customPersonService;

    @Autowired
    private PersonServiceTest personServiceTest;

    @RequestMapping("/save")
    public String save(){
        List<Person> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            Person person=new Person();
            person.setName("瓜田李下"+i);
            person.setAge(i);

            list.add(person);
        }

        customPersonService.insertList(list);

        return "success";
    }

    @RequestMapping("/update")
    public String update(){
        Person person=personService.getById(2);
        person.setName("海贼王");
        customPersonService.update(person);

        return "update success";
    }
}
