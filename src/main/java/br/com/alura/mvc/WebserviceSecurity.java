package br.com.alura.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebserviceSecurity extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		   .anyRequest().authenticated()
		.and()
		   .formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/home")
				   .permitAll());
				   
	}
	
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		
		UserDetails userDetails = User.withDefaultPasswordEncoder()
				.username("joao")
				.password("joao")
				.roles("ADM")
				.build();
		
		return new InMemoryUserDetailsManager(userDetails);
	}

}
