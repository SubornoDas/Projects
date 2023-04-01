package edu.cms.servicetest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import edu.cms.entity.Teacher;
import edu.cms.model.TeacherDTO;
import edu.cms.repository.TeacherRepository;
import edu.cms.service.TeacherService;
import edu.cms.util.TeacherConverter;

@SpringBootTest
public class TeacherServiceTest {
	@Autowired
private TeacherService teacherService;
@MockBean
	private TeacherRepository teacherRepository;
@Autowired
private TeacherConverter converter;
@Test
void testCreateTeacher() {
	Teacher teacher=Teacher.builder().firstName("Suborno").lastName("Das").email("suborno@gmail.com").contact("6200639596").build();

	Mockito.when(teacherRepository.save(teacher)).thenReturn(teacher);
	assertThat(teacherService.createTeacher(teacher)).isEqualTo("Teacher details saved successfully!");
}
@Test
void testGetTeacherById() {
	Teacher teacher=Teacher.builder().firstName("Suborno").lastName("Das").email("suborno@gmail.com").contact("6200639596").build();
	
	Optional<Teacher> opTeach=Optional.of(teacher);
Mockito.when(teacherRepository.findById(teacher.getId())).thenReturn(opTeach);
TeacherDTO dto=converter.convertTeacherEntityToDTO(teacher);
assertEquals("Suborno", dto.getFirstName());
assertEquals("Suborno", teacherService.getTeacherById(teacher.getId()).getFirstName());
assertEquals(dto.getFirstName(), teacherService.getTeacherById(teacher.getId()).getFirstName());


}
@Test
void testUpdateTeacher() {
	Teacher teacher=Teacher.builder().firstName("Suborno").lastName("Das").email("suborno@gmail.com").contact("6200639596").build();
	Optional<Teacher> opTeach=Optional.of(teacher);
	Teacher teacher1=opTeach.get();
	
	Mockito.when(teacherRepository.findById(teacher.getId())).thenReturn(opTeach);
	teacher1.setFirstName("Shawin");
	
	Mockito.when(teacherRepository.save(teacher1)).thenReturn(teacher1);
	TeacherDTO dto1=converter.convertTeacherEntityToDTO(teacher1);
	assertThat(teacherService.updateTeacherDetails(teacher1.getId(), teacher1).getFirstName()).isEqualTo("Shawin");
}
@Test
void testGetAllTeacherDetails() {
	Teacher teacher=Teacher.builder().firstName("Suborno").lastName("Das").email("suborno@gmail.com").contact("6200639596").build();
	
	Teacher teacher1=Teacher.builder().firstName("Amrita").lastName("Kumari").email("amrita@gmail.com").contact("7676767676").build();
	List<Teacher> teacherList=new ArrayList<>();
	teacherList.add(teacher);
	teacherList.add(teacher1);
	Mockito.when(teacherRepository.findAll()).thenReturn(teacherList);
	List<TeacherDTO> dto=teacherService.getAllTeacherDetails();
	List<Teacher> teach=new ArrayList<>();
	for(TeacherDTO t: dto) {
		teach.add(converter.convertDTOToTeacherEntity(t));
		
	}
assertThat(teach).isEqualTo(teacherList);
}
}
