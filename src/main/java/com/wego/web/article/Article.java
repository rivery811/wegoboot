package com.wego.web.article;

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
@Table(name = "ARTICLE")
@Component
public class Article {
	@Id
	@GeneratedValue
	@Column(name = "ARTSEQ",nullable=false)private Long artseq;
	@Column(name = "IMG",length=1000)private String img;
	@Column(name = "UID",length=64)private String uid;
	@Column(name = "COMMEMTS",length=1000)private String comments;
	@Column(name = "MSG",length=64)private String msg;
	@Column(name = "RATING",length=64)private String rating;
	@Column(name = "BORDTYPE",length=64)private String bordtype;
	@Column(name = "TITLE",length=1000)private String title;
	@Column(name = "CONTENT",length=2000)private String content;
	@Temporal(TemporalType.DATE)
	@Column(name = "REGDATE",length=500)private Date regdate;
}
