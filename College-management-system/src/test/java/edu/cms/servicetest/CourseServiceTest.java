package edu.cms.servicetest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import edu.cms.entity.Course;
import edu.cms.model.CourseDTO;
import edu.cms.repository.CourseRepository;
import edu.cms.service.CourseService;
import edu.cms.util.CourseConverter;

@SpringBootTest
public class CourseServiceTest {

	@Autowired	// CourseService injected
	private CourseService courseService;
	
	@Autowired  // CourseRepository injected
	@MockBean	//Used to mock course repository and does not make any effect on original data during testing
	private CourseRepository courseRepository;
	
	@Autowired	// Course Converter injected
	private CourseConverter courseConverter;
	
	//Testing method used to create a new course
	@Test
	void testCreateCOurse() {
		Course course=Course.builder().subId(101).subName("Java").price(5999.99).build();
		Mockito.when(courseRepository.save(course)).thenReturn(course);
		assertThat(courseService.createCourse(course)).isEqualTo("Cours details saved successfully !!!");
	}
	
	// Testing method used to get course details using id
	@Test
	void testGetCourseById() {
		Course course=Course.builder().subId(101).subName("Java").price(5999.99).build();
		Optional<Course>oPcourse=Optional.of(course);
		Mockito.when(courseRepository.findById(course.getSubId())).thenReturn(oPcourse);
		CourseDTO cDTO=courseConverter.convertCourseEntityToDTO(course);
		assertThat(course).isEqualTo(courseService.getCourseById(101));
	}
	
	// Testing method used to update course details
	@Test 
	void testUpdateCourse() {
		 Course course=Course.builder().subId(101).subName("Java").price(5999.99).build();
		 Optional<Course>oPcourse=Optional.of(course);
		 Course course1= oPcourse.get();
		Mockito.when(courseRepository.findById(course.getSubId())).thenReturn(oPcourse);
	course1.setSubName("Python");
	 
	 Mockito.when(courseRepository.save(course1)).thenReturn(course1);
	 
	 CourseDTO cdto=courseConverter.convertCourseEntityToDTO(course1);
	assertThat(courseService.updateCourseById(course1.getSubId(), course1).getSubName());
	}
}
	
	

