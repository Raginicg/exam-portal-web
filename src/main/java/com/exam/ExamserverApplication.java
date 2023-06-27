package com.exam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.service.UserService;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Staring code...");
		
		User user=new User();
		user.setFirstname("Ragini");
		user.setLastname("Gupta");
		user.setUsername("Ragigupt");
		user.setPassword("abc");
		user.setEmail("ragini123@gmail.com");
		user.setProfile_pic("Capture.PNG");
		user.setPhone("9482711122");
		
		Role role1=new Role();
		role1.setRoleId(11L);
		role1.setRoleName("Admin");
		
		Set<UserRole> userRoleSet=new HashSet<>();
		UserRole userRole=new UserRole();
	
		userRole.setRole(role1);
		userRole.setUser(user);
		
		userRoleSet.add(userRole);
		User u1=this.userService.createUser(user, userRoleSet);
		System.out.println(u1.getUsername());
		
		
		
	}
	

}
