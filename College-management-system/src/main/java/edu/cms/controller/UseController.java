package edu.cms.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cms.entity.User;
import edu.cms.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.servlet.ServletException;

@RestController
@RequestMapping("/user")
public class UseController {
	@Autowired
UserService userService;
public String validate(@RequestBody User user) throws ServletException{
String jwtToken="";
if(user.getUserName()==null || user.getPassword()==null) {
	throw new ServletException("Please fill the userName and Password !!");
	
}
	String username=user.getUserName();
	String password=user.getPassword();
	user=userService.login(username,password);
	if(user==null) {
		throw new ServletException("User details not found !!");
	}
	jwtToken=Jwts.builder().setSubject(username).claim("role", "user").
			setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact();
	return jwtToken;
	
	

	
}
}
