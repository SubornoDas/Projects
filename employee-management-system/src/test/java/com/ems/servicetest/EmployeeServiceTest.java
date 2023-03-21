package com.ems.servicetest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.ems.config.HibernateUtil;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.EmployeeDTO;
import com.ems.service.EmployeeService;
import com.ems.serviceimpl.EmployeeServiceImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceTest {
EmployeeService empService=new EmployeeServiceImpl();
	private static org.hibernate.SessionFactory sessionFactory;
	private Session session;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sessionFactory=HibernateUtil.getSessionFactory();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		if(sessionFactory!=null)
			sessionFactory.close();
		System.out.println("Session Factory Closed");
	}

	@BeforeEach
	void setUp() throws Exception {
		session=sessionFactory.openSession();
	}

	@AfterEach
	void tearDown() throws Exception {
		if(session!=null)
			session.close();
		System.out.println("Session Closed");
	}

//	@Test
//	@DisplayName("Testing save employee")
//	@Order(1)
//	void testSaveEmployee() {
//		Transaction tx=session.beginTransaction();
//		Employee emp=new Employee();
//		emp.setEmpName("Arindam Das");
//		emp.setEmpAddress("Midnapore");
//		emp.setContact("9898765432");
//		emp.setDesignation("Java Developer");
//		emp.setEmail("arind@gmail.com");	
//		emp.setDOJ(LocalDate.parse("2023-04-06"));
//		emp.setPassword("arin123");
//		emp.setUserName("arindm");
//		emp.setRole("employee");
//		empService.saveEmployee(emp);
//		tx.commit();
//		assertEquals("Arindam Das", emp.getEmpName());
//	}

	@Test
	@DisplayName("Testing getting employee using id")
	@Order(2)
	void testGetEmpByid() {
		EmployeeDTO eDTO=empService.getEmployeeUsingId(5);
		assertThat(eDTO.getEmpName()).isEqualTo("Arindam Das");
		}
	 
//	@Test
//	@Order(3)
//	void testUpdateEmployee() {
//		Employee emp=new Employee();
//		emp.setEmpName("Arindam Das");
//		emp.setEmpAddress("Midnapore");
//		emp.setContact("9898765432");
//		emp.setDesignation("Java Developer");
//		emp.setSalary(35000);
//		emp.setEmail("arind@gmail.com");	
//		emp.setDOJ(LocalDate.parse("2023-04-06"));
//		emp.setPassword("arin123");
//		emp.setUserName("arindm");
//		emp.setRole("employee");
//	
//		EmployeeDTO eDTO=empService.updateEmployee(5, emp);
//		assertEquals("Arindam Das", eDTO.getEmpName());
//	}
	@Test
	@Order(4)
	void testDeleteEmployee() {
		empService.deleteEmployeeById(5);
		assertThrows(GlobalException.class,()-> empService.getEmployeeUsingId(5));
	}
//}
}
//
