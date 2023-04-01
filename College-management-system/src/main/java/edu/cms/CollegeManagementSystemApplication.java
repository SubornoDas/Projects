package edu.cms;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import edu.cms.config.JwtFilter;

@SpringBootApplication
public class CollegeManagementSystemApplication {
	
	@SuppressWarnings({"rawtypes","unchecked"})
	@Bean
public FilterRegistrationBean jwtFilter() {
	
	final FilterRegistrationBean registrationBean=new FilterRegistrationBean();
	registrationBean.setFilter(new JwtFilter());
	registrationBean.addUrlPatterns("/teacher/*","/course/*");;
	return registrationBean;
}
	public static void main(String[] args) {
		SpringApplication.run(CollegeManagementSystemApplication.class, args);
		System.out.println("College management system is running!");
	}

}
