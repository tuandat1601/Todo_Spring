package com.in48hours.springboot.startlearnapp.security;


import java.util.function.Function;

import org.springframework.aot.generate.InMemoryGeneratedFiles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		UserDetails userDetails1 = createNewUser("dummy", "in48hours");
		UserDetails userDetails2 = createNewUser("gui", "mo");
		return new InMemoryUserDetailsManager(userDetails1,userDetails2);
	}
	private UserDetails createNewUser(String password, String username) {
		Function<String, String> passwordEncoder
		= input ->passwordEncoder().encode(input);
		UserDetails userDetails=User.builder().passwordEncoder(passwordEncoder)
				.username(username)
				.password(password)
				.roles("USER","ADMIN")
				.build();
		return userDetails;
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.authorizeHttpRequests(auth ->auth.anyRequest().authenticated());
	   
	      http.formLogin(withDefaults());
	      http.csrf().disable();
	      http.headers().frameOptions().disable();
	    return http.build();
	}

}
