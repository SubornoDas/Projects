package edu.cms.service;

import java.util.List;

import edu.cms.entity.Course;
import edu.cms.model.CourseDTO;

public interface CourseService {
String createCourse(Course course);		//method used to create/save new course
CourseDTO getCourseById(int id);		//method used to fetch/get course using id
List<CourseDTO> getAllCourseDetails();  //method used to fetch/get all course details
CourseDTO updateCourseById(int id,Course course); // method used to update course details using id
String deleteCourseById(int id);		//method to delete a course by using id
void deleteAllCourseDetails();			//method to delete all course details 
CourseDTO assignTeacherToCourse(int teacherId,int courseId); //method to assign a teacher to a course
}
