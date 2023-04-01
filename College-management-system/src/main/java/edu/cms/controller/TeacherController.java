package edu.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.cms.entity.Teacher;
import edu.cms.model.TeacherDTO;
import edu.cms.service.TeacherService;
import edu.cms.util.TeacherConverter;
import javax.validation.Valid;

@RestController
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private TeacherConverter converter;
	
	
	@PostMapping("/createTeacher")
	public String createTeacher(@Valid @RequestBody TeacherDTO teacherDTO)
	{
		final Teacher teacher = converter.convertDTOToTeacherEntity(teacherDTO);
		return teacherService.createTeacher(teacher);
	}
	
	@GetMapping("/getTeacherById/{id}")
	public TeacherDTO getTeacherById(@PathVariable("id") int id)
	{
		return teacherService.getTeacherById(id);
	} 
	
	@GetMapping("/getAllTeachers")
	public List<TeacherDTO> getAllTeacherDetails()
	{
		return teacherService.getAllTeacherDetails();
	}
	
	@PutMapping("/updateTeacher/{id}")
	public TeacherDTO updateTeacherDetails(@Valid @PathVariable("id") int id,
			@RequestBody TeacherDTO teacherDTO)
	{
		Teacher teacher = converter.convertDTOToTeacherEntity(teacherDTO);
		return teacherService.updateTeacherDetails(id, teacher);
	}
	
	@DeleteMapping("/deleteTeacherById/{id}")
	public String deleteTeacherById(@PathVariable("id") int id)
	{
		return teacherService.deleteTeacherById(id);
	}
	
	@DeleteMapping("/deleteAllTeachers")
	public ResponseEntity<String> deleteAllTeachers()
	{
		teacherService.deleteAllTeacherDetails();
		return new ResponseEntity<String>("All teacher details have been deleted successfully!", HttpStatus.OK);
	}
	
	@GetMapping("/getTeacherByEmail/{email}")
	public TeacherDTO getTeacherByEmail(@PathVariable("email") String email)
	{
		return teacherService.findTeacherByEmail(email);
	}
	
	@GetMapping("/getTeacherByFirstName/{name}")
	public List<TeacherDTO> getTeacherByFirstName(@PathVariable("name") String name)
	{
		return teacherService.findByFirstName(name);
	}
}
