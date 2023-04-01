package edu.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.cms.entity.Teacher;


public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

//	@Query("from Teacher t where t.email=:e")
//	Teacher findTeacherByEmail(@Param("e") String email);
	
	Teacher findByEmail(String email);
	
	List<Teacher> findByFirstName(String name);
}
