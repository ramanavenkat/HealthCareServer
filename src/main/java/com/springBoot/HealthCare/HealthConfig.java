package com.springBoot.HealthCare;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class HealthConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	JwtAuthenticatonFilter jwtAuthenticationFilter;
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.cors().and()
		.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/save").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/doctorSave").hasRole("ADMIN")
			.antMatchers("/getDoctor").hasRole("USER")
			.antMatchers("/getAppointment").hasRole("USER")
			.antMatchers("/saveToDAppointment").hasRole("USER")
			.antMatchers("/getRequests").hasRole("DOCTOR")
			.antMatchers("/saveToAppoint").hasRole("DOCTOR")
			.antMatchers("/saveToDAppoint").hasRole("DOCTOR")
			.antMatchers("/delete").hasRole("DOCTOR")
			.antMatchers("/count").hasRole("ADMIN")
			.antMatchers("/getADoctors").hasRole("ADMIN")
			.antMatchers("/getAPatient").hasRole("ADMIN")
			.antMatchers("/deleteDoctor").hasRole("ADMIN")
			.antMatchers("/getDBA").hasRole("DOCTOR")
			.antMatchers("/getCorona").hasRole("USER")
			.antMatchers("/fever").hasRole("USER")
			.anyRequest().authenticated()
			.and()
			.logout().invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/").permitAll()
			.and().sessionManagement()
		 	.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.csrf().disable();
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	
	

}
