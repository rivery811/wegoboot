package com.wego.web.person;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long>{
	public Person findByUseridAndPasswd(String userid, String passwd);
	public Person findByUserid(String userid);
	@Query(value="SELECT MAX(p.SCORE),p.* FROM PERSON p GROUP BY HAK HAVING ROLE ='student' ", nativeQuery=true)
	public List<Person> findGroupByHak();
	public List<Person> findByRole(String param);

}
