package edu.cms.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.pattern.Converter;
import edu.cms.entity.Course;
import edu.cms.entity.Teacher;
import edu.cms.exception.ResourceNotFoundException;
import edu.cms.model.CourseDTO;
import edu.cms.repository.CourseRepository;
import edu.cms.repository.TeacherRepository;
import edu.cms.service.CourseService;
import edu.cms.util.CourseConverter;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class CourseServiceImpl implements CourseService {
	// create a logger with class name Course
	private static final Logger Log=LoggerFactory.getLogger(Course.class);
@Autowired
	private CourseRepository courseRepository;
@Autowired
private TeacherRepository teacherRepository;
	@Autowired
private CourseConverter courseConverter;
	//method to create course
@Override
	public String createCourse(Course course) {

		String msg=null;
		courseRepository.save(course);
		// call info method
		log.info("Course "+course.toString()+" added at"+new Date());
		if(course!=null) {
			msg="Course details saved successfully !!!";
			
		}
		return msg;

}
//method to fetch/get course details using id
@Override
public CourseDTO getCourseById(int id) {
	Course course = courseRepository.findById(id).orElseThrow(()->
	new ResourceNotFoundException("Course", "Id", id));
	log.info("Course details get with id "+id+" at"+new Date());
	return courseConverter.convertCourseEntityToDTO(course);
	
}
//method to fetch/get all course details
@Override
public List<CourseDTO> getAllCourseDetails() {
	List<Course> course=courseRepository.findAll();
	List<CourseDTO> cDTO=new ArrayList<>();
	log.info("All courses details found at"+new Date());
	for(Course c:course)
	{
		cDTO.add(courseConverter.convertCourseEntityToDTO(c));
		
	}
	return cDTO;
}
//method to update course using id
@Override
public CourseDTO updateCourseById(int id, Course course) {
	Course c=courseRepository.findById(id).orElseThrow(
			()->new ResourceNotFoundException("Course", "id", id));
		//To get data and and setting it in existing course
		c.setSubId(course.getSubId());
		c.setSubName(course.getSubName());
		c.setPrice(course.getPrice());
		courseRepository.save(c);
		log.info("Course details updated with id "+id+" at "+new Date());
	return courseConverter.convertCourseEntityToDTO(c);
}
//method to delete a course by id
@Override
public String deleteCourseById(int id) {
	String msg=null;
	Optional<Course> course=courseRepository.findById(id);
	if(course.isPresent()) {
		courseRepository.deleteById(id);
		log.info("Course details deleted with id "+id+"  at "+new Date());
		msg="Course with id "+id+" has been deleted successfully !!!";
	}
	else
		throw new ResourceNotFoundException("Course", "Id", id);
	
	return msg;
}
//method to delete all course details
@Override
public void deleteAllCourseDetails() {
	courseRepository.deleteAll();
	log.info("All courses deleted at "+new Date());
	
}
@Override
public CourseDTO assignTeacherToCourse(int teacherId, int courseId) {
	Teacher teach=teacherRepository.findById(teacherId).get();
	Course course=courseRepository.findById(courseId).get();
	
	course.setTeacher(teach);
	log.info("Teacher id assigned to course at "+new Date());
	Course course1=courseRepository.save(course);
	return courseConverter.convertCourseEntityToDTO(course1);
	
	
}


}

