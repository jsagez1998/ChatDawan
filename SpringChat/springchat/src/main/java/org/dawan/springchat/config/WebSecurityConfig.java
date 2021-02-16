package org.dawan.springchat.config;

import javax.sql.DataSource;

import org.dawan.springchat.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;

	@Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
            .dataSource(dataSource)
            .usersByUsernameQuery("select username, password, enabled from users where username=?")
            .authoritiesByUsernameQuery("select username, role from users where username=?")
        ;
    }

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll()
            .and()
            .logout().permitAll();     
    }









}	
//	
//	
//	//enable jdbc authentification
//	@Autowired
//	public void configAuthentification(AuthenticationManagerBuilder auth) throws Exception{
//		auth.jdbcAuthentication().dataSource(dataSource);
//	}
//	
//	
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/home").hasAnyRole("USER", "MODO")
//		.antMatchers("/users/all").hasAnyRole("USER", "MODO").antMatchers("/users/addUser")
//		.hasAnyRole("MODO").anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
//		.and().logout().permitAll();
//
//http.csrf().disable();
//		//		http
////			.authorizeRequests()
////					.antMatchers("/","/home").permitAll()
////					.anyRequest().authenticated()
////					.and()
////			.formLogin()
////					.loginPage("/login")
////					.permitAll()
////					.and()
////			.logout()
////					.permitAll();
//	}
//	
//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		@SuppressWarnings("deprecation")
//		UserDetails user = User.withDefaultPasswordEncoder()
//											.username("user")
//											.password("password")
//											.roles("USER")
//											.build();
//		return new InMemoryUserDetailsManager(user);
//	}

