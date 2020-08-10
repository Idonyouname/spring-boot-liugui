package com.liugui.rediscacheliugui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName: Person
 * @Author: liugui
 * @Date: 2020-08-10 19:12
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Person implements Serializable {

    public static final long serialVersionUID = -1;

    private long userId;
    private String userName;
    private String password;
}
