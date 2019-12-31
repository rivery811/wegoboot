package com.wego.web.person;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wego.web.util.Printer;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class PersonController {
	@Autowired
	private PersonRepository personRepository;
	@Autowired 
	private Printer printer;
	@Autowired
	private Person person;
	@Autowired
	ModelMapper modelMapper;
	@Autowired 
	PersonService personService;
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@RequestMapping("/")
	public String index() {
		Iterable<Person> all = personRepository.findAll();
		StringBuilder sb= new StringBuilder();
		all.forEach(p->sb.append(p.getName()+" "));
		return sb.toString();
	}
	@PostMapping("/login")
	public HashMap<String, Object> login(@RequestBody Person param) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		printer.accept("로그인진입");
		printer.accept(String.format("id :%s", param.getUserid()));
		printer.accept(String.format("pw :%s", param.getPasswd()));
		
		person = personRepository.findByUseridAndPasswd(param.getUserid(), param.getPasswd());
				
		if(person != null) {
			printer.accept("로그인성공");
			map.put("result","success");
			map.put("person",person);
		}else {
			printer.accept("로그인fail");
			map.put("result","fail");
			map.put("person",person);
		}
		return map;
	}
	@PostMapping("/join")
	public HashMap<String, String> join(@RequestBody Person param) {
		printer.accept("조인진입");	
		HashMap<String, String> map = new HashMap<String, String>();
		/*
		 * person = new Person(); person.setUserid(param.getUserid());
		 * person.setPasswd(param.getPasswd()); person.setName(param.getName());
		 * person.setBirthday(param.getBirthday());
		 */
		personRepository.save(param);
		if(param != null) {		
			map.put("result","success");
			
		}else {
			
			map.put("result","fail");
			
		}
		return map;
	}
	@DeleteMapping("/withdrawal/{userid}")
	public void withdrawal(@PathVariable String userid ) {
		System.out.println(userid);
		personRepository
		.delete(personRepository.findByUserid(userid));
	}
	@PutMapping("/update/{userid}")
	public void update(@PathVariable String userid, @RequestBody Person param) {
		printer.accept("업데이트");
		personRepository.save(param);
		
	}
	@GetMapping("/students")
	public Stream<Person> list(){
		printer.accept("리스트");
		Iterable<Person> entites = personRepository.findAll();	
		//Iterable<Person> entites=personRepository.findByRole("student");
		List<Person> list = new ArrayList<Person>();
		for(Person p:entites) {
			Person dto = modelMapper.map(p,Person.class);
			list.add(dto);
		}
		return list.stream().filter(role-> role.getRole().equals("student"));
	}
	@GetMapping("/students/{searchword}")
	public Object findSome(@PathVariable String searchword, @RequestParam String option){
		
		switch (searchword) {
		case "namesOfStudents":return personService.namesOfStudents();	
		case "streamToArray": return personService.streamToArray();
		case "streamToMap":return personService.streamToMap();
		case "theNumberOfStudents":return personService.theNumberOfStudents();
		case "totalScore":return personService.totalScore();
		case "topStudent":return personService.topStudent();
		case "getStat":return personService.getStat();
		case "nameList":return personService.nameList();
		
		  case "partioningBy":
			  String word = (option =="남")?"true":"false";
			  return personRepository.findByRole("student").stream()
		               .collect(
			                      Collectors
			                          .partitioningBy(Person::isMale))
			               .get(word);
		  case "partioningCountPerGender":return personService.partioningCountPerGender(true); 
		  case "partioningTopPerGender":return personService.partioningTopPerGender(true);
		  case "partioningRejectPerGender":return personService.partioningRejectPerGender(true);
		 
		case "groupingByBan":return personService.findByBan();
		case "groupingByGrade":return personService.findByHak();
		case "groupingByCountByLevel":return personService.personCountByLevel();
		case "groupingByHakAndBan":return personService.multiGrouping();
		case "groupingTopByHakAndBan":return personService.multiGroupingMax();
		case "groupingByStat":return personService.multiGroupingGrade();
			

		default:
			break;
		}
		
		return null;
	}

}
