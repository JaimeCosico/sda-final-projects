package com.example.agilestore12;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class ApplicationTests {

	public static void main(String[] args){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "chenbebeko*1";
		String encodedPassword = encoder.encode(rawPassword);

		System.out.println(encodedPassword);
	}

}
