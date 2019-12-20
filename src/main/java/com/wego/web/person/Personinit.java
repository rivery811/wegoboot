package com.wego.web.person;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import org.springframework.stereotype.Component;

@Component

public class Personinit implements ApplicationRunner {
	
	private PersonRepository personRepository;
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public Personinit(PersonRepository personRepository) {
		this.personRepository= personRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		long count = personRepository.count();
		if(count==0) {
			Person person= null;

			String[][] mtx = {{"hong","1","홍길동","1980-08-08"},
					{"kim","1","김유신","1986-09-09"},
					{"park","1","박지성","1982-01-09"},
					{"you","1","유관순","1985-02-09"}};
			for(String arr[]:mtx) {
				person = new Person();
					 person.setUserid(arr[0]); 
					 person.setPasswd(arr[1]);
					 person.setName(arr[2]); 
					 person.setBirthday(df.parse(arr[3]));	
				 personRepository.save(person);
			}
			/*
			 * for(int i = 0; i<arr.length;i++) { person = new Person();
			 * person.setUserid(arr[i][0]); person.setPasswd(arr[i][1]);
			 * person.setName(arr[i][2]); person.setBirthday(df.parse(arr[i][3]));
			 * personRepository.save(person);  }
			 */
			
	
		}

		
	}

}
