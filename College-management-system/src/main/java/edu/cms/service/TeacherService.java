package edu.cms.service;

import java.util.List;

import edu.cms.entity.Teacher;
import edu.cms.model.TeacherDTO;

public interface TeacherService {

	String createTeacher(Teacher teacher);
	TeacherDTO getTeacherById(int id);
	List<TeacherDTO>  getAllTeacherDetails();
	TeacherDTO updateTeacherDetails(int id, Teacher teacher);
	String deleteTeacherById(int id);
	void deleteAllTeacherDetails();
	TeacherDTO findTeacherByEmail(String email);
	List<TeacherDTO> findByFirstName(String name);
}
