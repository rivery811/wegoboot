package com.wego.web.person;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.wego.web.article.Article;
import com.wego.web.proxy.Proxy;

import lombok.AccessLevel;
import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Entity
@NoArgsConstructor(access= AccessLevel.PUBLIC)
@Getter
@Setter( AccessLevel.PROTECTED)
@ToString
@Table(name="PERSON",
uniqueConstraints = {@UniqueConstraint(columnNames={"USERID"})}
)


public class Person extends Proxy implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //이제 전략패턴 쓸거야 
	@NotNull@Column(name="PERSONID")private Long personid;
	@NotNull@Column(name="USERID")private String userid;
	@NotNull@Column(name="PASSWD")private String passwd;
	@NotNull@Column(name="NAME")private String name;
	@NotNull@Temporal(TemporalType.DATE)
	@NotNull@Column(name="BIRTHDAY")private Date birthday;
	@NotNull@Column(name="MALE")private boolean male;
	@NotNull@Column(name="HAK")private int hak;
	@NotNull@Column(name="BAN")private int ban;
	@NotNull@Column(name="SCORE")private int score;
	@NotNull@Column(name="ROLE")private String role;
	enum Level{HIGH,MID ,LOW}
	
	@OneToMany(mappedBy = "personid",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Article> articles = new ArrayList<>();
	
	@Builder
	private Person( String userid,  String passwd,  String name,
			  Date birthday,  boolean male,  int hak,  int ban,
			 int score,  String role) {
		Assert.hasText(userid, "bankName must not be empty");
		Assert.hasText(passwd, "bankName must not be empty");
		Assert.hasText(name, "bankName must not be empty");
		Assert.hasText(string(male), "bankName must not be empty");
		Assert.hasText(string(hak), "bankName must not be empty");
		Assert.hasText(string(ban), "bankName must not be empty");
		Assert.hasText(string(score), "bankName must not be empty");
		Assert.hasText(role, "bankName must not be empty");

	
		this.userid = userid;
		this.passwd = passwd;
		this.name = name;
		this.birthday = birthday;
		this.male = male;
		this.hak = hak;
		this.ban = ban;
		this.score = score;
		this.role = role;
	}
	
}
