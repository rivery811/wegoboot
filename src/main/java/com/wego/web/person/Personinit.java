package com.wego.web.person;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import org.springframework.stereotype.Component;

import com.wego.web.proxy.Proxy;

@Component

public class Personinit extends Proxy implements ApplicationRunner {
	
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

			String[][] mtx = {{"hong","1","홍길동","1980-08-08","true","0","0","0","taecher"},
					{"kim","1","김유신","1986-09-09","true","0","0","0","manager"},
					{"park","1","박지성","1982-01-09","true","0","0","0","manager"},
					{"you","1","유관순","1985-02-09","false","4","1","100","student"},
					{"shin","1","신숙주","1885-02-09","true","4","2","98","student"},
					{"lee","1","이성계","1985-08-09","true","2","3","60","student"},
					{"heo","1","허난설헌","1985-01-09","false","1","1","99","student"},
					{"jang","1","장해경","1985-03-09","false","3","3","70","student"},
					{"choi","1","최광진","1982-11-09","true","4","4","50","student"},
					{"ej","1","이은지","1988-01-13","false","3","1","97","student"},
					{"hm","1","양현미","1987-02-22","false","2","3","20","student"},
					{"mk","1","김민국","1985-03-25","true","1","1","99","student"},
					{"yj","1","이예지","1986-02-13","false","4","2","40","student"},
					{"hj","1","박형진","1982-05-16","false","3","4","50","student"},
					{"yh","1","여요한","1981-07-20","true","2","2","98","student"},
					{"eb","1","이은비","1989-11-09","false","1","1","70","student"},
					{"hr","1","권혜령","1984-12-01","false","4","3","99","student"},
					{"sh","1","김세호","1984-02-05","true","3","1","90","student"},
					{"do","1","나도욱","1985-05-09","true","2","4","98","student"},
					{"kh","1","박근호","1985-02-17","true","1","3","80","student"},
					{"ns","1","나성","1983-02-09","false","4","1","70","student"},

					};
			
			/*
			 * for(String arr[]:mtx) { person = new Person(); person.setUserid(arr[0]);
			 * person.setPasswd(arr[1]); person.setName(arr[2]);
			 * person.setBirthday(df.parse(arr[3]));
			 * person.setMale(Boolean.parseBoolean(arr[4])); person.setHak(integer(arr[5]));
			 * person.setBan(integer(arr[6])); person.setScore(integer(arr[7]));
			 * person.setRole(arr[8]); personRepository.save(person); }
			 */
			 
			/*
			 * for(int i = 0; i<arr.length;i++) { person = new Person();
			 * person.setUserid(arr[i][0]); person.setPasswd(arr[i][1]);
			 * person.setName(arr[i][2]); person.setBirthday(df.parse(arr[i][3]));
			 * personRepository.save(person);  }
			 */
			
	
		}

		
	}

}
