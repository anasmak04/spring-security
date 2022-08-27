package com.Log.LogJ.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {
		
		private final PasswordEncoder passwordEncoder;
		@Autowired
	public AppConfig(PasswordEncoder passwordEncoder) {
			super();
			this.passwordEncoder = passwordEncoder;
		}

	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/","index","/css/*","/js/*").permitAll()
		.antMatchers("/api/**").hasRole(ApplicationuserRole.ADMIN.name())
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}
	
	@Bean
	protected UserDetailsService UserDetailsService() {
			UserDetails anasbilaluser = User.builder()
			.username("anasbilal")
			.password(passwordEncoder.encode("password"))
			.roles(ApplicationuserRole.STUDENT.name())
			.build();
			
			UserDetails anasAdmin = User.builder()
			.username("anas")
			.password(passwordEncoder.encode("anas5313NN"))
			.roles(ApplicationuserRole.ADMIN.name())
			.build();
			
			return new InMemoryUserDetailsManager(
					anasbilaluser,anasAdmin
					);
	}

}
