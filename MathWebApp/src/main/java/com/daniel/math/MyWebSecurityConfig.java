package com.daniel.math;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.assertj.core.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.firewall.FirewalledRequest;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;

@Configuration
//@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
    	web.ignoring().antMatchers("/resources/**", "/public/op1")
    		.and().ignoring().antMatchers("/public/op2").and()/*.debug(true)*/.httpFirewall(new HttpFirewall() {

				@Override
				public FirewalledRequest getFirewalledRequest(HttpServletRequest request) throws RequestRejectedException {
					return new FirewalledRequest(request) {
						@Override
						public void reset() {
						}				
					};
				}
				
				@Override
				public HttpServletResponse getFirewalledResponse(HttpServletResponse response) {
					return response;
				}
			});
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.authorizeRequests().antMatchers("/user/**").hasRole("USER").and().formLogin();
		http.authorizeRequests().antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
           			.antMatchers("/admin/**").hasRole("ADMIN").and()
           			.formLogin();
	}

	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		try {
			auth.inMemoryAuthentication().withUser("user").password("{noop}abc").roles("USER")
                 .and().withUser("admin").password("{noop}ABC").roles("USER", "ADMIN")
                 .and().withUser("so").password("{noop}123").roles("SO");
		}
        catch (Exception e) {
		}
   }*/
	
	// or
	
	@Bean
	public UserDetailsService userDetailsService() {
		return (username) -> {
			if("admin".equals(username)) {
				List<GrantedAuthority> list = new ArrayList<>();
				list.add(() -> "ROLE_ADMIN");
				return new User("admin", "{noop}ABC", list) ;
			}

			throw new UsernameNotFoundException("n/a");
		};
	};	
}