package com.controller.security;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	 @Autowired
	 private MyUserDetailsService myUserDetailsService;
	 
//	 public SecurityConfig() {
//	        super();
//	    }
//	 	
//	 	@Autowired
//	    public SecurityConfig(MyUserDetailsService myUserDetailsService) {
//	        this.myUserDetailsService = myUserDetailsService;
//	    }
//	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http
        .cors() // Abilita il supporto CORS con la configurazione predefinita
        .and()
        .authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            //.antMatchers("/user/**").hasRole("USER")
            .antMatchers("/user/**", "/getEmployees").hasAnyRole("USER", "ADMIN")
            .antMatchers("/getEmployee").permitAll()
            .anyRequest().authenticated()
        .and()
        .formLogin()
        .and()
        .logout()
            .logoutSuccessUrl("/login?logout")
            .permitAll();
    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder(); 
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.addAllowedOrigin("*");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("*");

	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", config);
	    return source;
	}

	




}
