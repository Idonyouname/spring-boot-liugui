package com.liugui.springbootproperties.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName: Student
 * @Author: liugui
 * @Date: 2019-12-09 10:17
 **/
@Data
@Component
@ConfigurationProperties(prefix = "liugui")
@PropertySource("classpath:application.properties")
public class Student {
    private String name;
    private Integer age;
}
