package com.wego.web.article;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.wego.web.person.Person;
import com.wego.web.proxy.Proxy;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC )
@Getter
@Setter(AccessLevel.PROTECTED)
@ToString
@Table(name = "ARTICLE")

public class Article extends Proxy implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull@Column(name = "ARTSEQ")private Long artseq;
	@Column(name = "IMG")private String img;
	@NotNull@Column(name = "USERID")private String userid;
	@Column(name = "COMMEMTS")private String comments;
	@Column(name = "MSG")private String msg;
	@Column(name = "RATING")private String rating;
	@Column(name = "BORDTYPE")private String bordtype;
	@NotNull@Column(name = "TITLE")private String title;
	@NotNull@Column(name = "CONTENT")private String content;
	@Temporal(TemporalType.DATE)
	@Column(name = "REGDATE")private Date regdate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "personid")private Person personid;
	
	@Builder
	private Article( String img,  String comments, String msg, String rating,
			String bordtype, @NotNull String title, @NotNull String content, Date regdate, @NotNull String userid) {
		
		
		
		this.img = img;
		this.userid = userid;
		this.comments = comments;
		this.msg = msg;
		this.rating = rating;
		this.bordtype = bordtype;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}

}
