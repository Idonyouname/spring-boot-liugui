package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Description
 * @Auther liugui
 * @Create 2019/8/31 16:28
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false, unique = true)
	private String userName;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private int age;
}
