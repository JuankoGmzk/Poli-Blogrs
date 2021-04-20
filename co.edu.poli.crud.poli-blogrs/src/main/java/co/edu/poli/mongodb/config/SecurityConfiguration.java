package co.edu.poli.mongodb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
		auth.userDetailsService(userDetailsService);
		auth.inMemoryAuthentication() 
	 		.withUser("wilson") 
	 		.password("123456") //using method noPasswordEncoder
	 		.roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable() //Cross-Site Request Forgery (falsificación de petición en sitios cruzados)
			.authorizeRequests()
			.antMatchers("/PB/**").hasAnyRole("USER" , "ADMIN")
			.anyRequest().authenticated() //For any other request, you do not need a specific role but still need to be authenticated.
			.and()
			.formLogin() //authentication method
			.and()
			.httpBasic()
			.and()
			.logout(); //http://localhost:8080/login?logout
	}

	@Bean
	public PasswordEncoder noPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	

}
