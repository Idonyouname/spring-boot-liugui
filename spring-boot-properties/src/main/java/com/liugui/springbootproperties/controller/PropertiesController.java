package com.liugui.springbootproperties.controller;

import com.liugui.springbootproperties.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: PropertiesController
 * @Author: liugui
 * @Date: 2019-12-09 10:14
 **/
@RestController
public class PropertiesController {

    @Value("${liugui.name}")
    String name;

    @Autowired
    Student student;

    @RequestMapping("/showName")
    public String showName(){
        return "name: " + name;
    }

    @RequestMapping("/showNameAndAge")
    public String showNameAndAge(){
        return "name:" + student.getName() + "! age:" + student.getAge();
    }

}
