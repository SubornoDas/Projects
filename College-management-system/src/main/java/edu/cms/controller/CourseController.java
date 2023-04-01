package edu.cms.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cms.entity.Course;
import edu.cms.model.CourseDTO;
import edu.cms.service.CourseService;
import edu.cms.util.CourseConverter;

@RestController
@RequestMapping("/course") // mapping course path to CourseController

public class CourseController {
	
	
	@Autowired 	// CourseService injected
	private CourseService courseService;

	
	@Autowired	// CourseConverter injected 
	private CourseConverter converter;
	
	//mapping to create course
	@PostMapping("/createCourse")
	public String createCourse(@Valid @RequestBody Course course)
	{
		return courseService.createCourse(course);
	}
	
	// mapping to get/fetch a course details using id
	@GetMapping("/getCourseById/{id}")
public CourseDTO getCourseById(@PathVariable("id")int id)
{
	return courseService.getCourseById(id);
}
	
//mapping to get all course details
@GetMapping("/getAllCourseDetails")
public List<CourseDTO> getAllCourseDetails(){
	return courseService.getAllCourseDetails();
	
}

// mapping to update course using id
@PutMapping("/updateCourseById/{id}")
public CourseDTO updateCourseDetails(@Valid @PathVariable("id") int id,
		@RequestBody CourseDTO courseDTO)
{
	Course course= converter.convertDTOToCourseEntity(courseDTO);
	return courseService.updateCourseById(id, course);
}
// mapping to delete a course using id
@DeleteMapping("/deleteCourseById/{id}")
public String deleteCourseById(@PathVariable("id") int id)
{
	return courseService.deleteCourseById(id);
}
// mapping to delete all courses details
@DeleteMapping("/deleteAllCourseDetails")
public ResponseEntity<String> deleteAllCourseDetails() {
	
	courseService.deleteAllCourseDetails();
	return new ResponseEntity<String>("All course details have been deleted successfully !!!",HttpStatus.OK);
	
	}

//mapping to assign a teacher to a course
@PostMapping("/assignTeacherToCourse/{teacherId}/{CourseId}")
public CourseDTO assignTeacherToCourse(@PathVariable ("teachId")int teacherId,
		@PathVariable ("courseId")int courseId) {
	return courseService.assignTeacherToCourse(teacherId, courseId);
}

}

	
