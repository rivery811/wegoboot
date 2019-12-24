package com.wego.web.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Entity
@Table(name="PERSON")
@Component
public class Person {
	@Id
	@GeneratedValue
	@Column(name="ID",nullable=false)private Long id;
	@Column(name="UID",length=64,nullable=false)private String userid;
	@Column(name="PASSWD",length=64,nullable=false)private String passwd;
	@Column(name="NAME",length=64,nullable=false)private String name;
	@Temporal(TemporalType.DATE)
	@Column(name="BIRTHDAY",nullable=true)private Date birthday;
	@Column(name="GENDER",nullable=true)private String gender;
	@Column(name="HAK",nullable=true)private int hak;
	@Column(name="BAN",nullable=true)private int ban;
	@Column(name="SCORE",nullable=true)private int score;
}
