package com.example.user.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfigDemo {
	
	@Bean
	public UserDetailsService createUser(BCryptPasswordEncoder pswd) { //Authentication
//		UserDetails u1=User.withUsername("Darshan").password(pswd.encode("1234")).roles("USER").build();
//		UserDetails u2=User.withUsername("Dhanush").password(pswd.encode("1234")).roles("USER").build();
//		UserDetails u3=User.withUsername("Rahul").password(pswd.encode("1234")).roles("ADMIN").build();
		return new AssignUserFromDatabase();
	}


	@Bean
	public BCryptPasswordEncoder pass() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain autho(HttpSecurity h) throws Exception  {
	h.csrf((csrf)->csrf.disable()).
		authorizeHttpRequests((authorizeHttpRequests)->authorizeHttpRequests.requestMatchers("/index","/add","/autho").
				permitAll().requestMatchers("/home").hasRole("EMP")).formLogin();
	return h.build();
	}
}








