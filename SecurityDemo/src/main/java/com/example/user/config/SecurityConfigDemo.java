package com.example.user.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfigDemo {
	
	@Autowired
	JwtFilter jwtFilter;
	
	@Bean
	public UserDetailsService createUser() { //Authentication
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
	permitAll().requestMatchers("/home").hasRole("EMP")).authenticationProvider(authenticationProv())
		.sessionManagement((sr)->sr.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	return h.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProv() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(createUser());
		provider.setPasswordEncoder(pass());
		return provider;
	}
}








