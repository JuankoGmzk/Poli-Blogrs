package co.edu.poli_blogrs.models;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthenticationRequest {
	
	private String username;
		
	private String email;
	
	private String instcode;	//1810010387
	
	private String password;	//test123

	public AuthenticationRequest() { 
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInstCode() {
		return instcode;
	}

	public void setInstCode(String instCode) {
		this.instcode = instCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	
	}

}
