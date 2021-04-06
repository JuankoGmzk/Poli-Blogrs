package co.edu.poli.blogrs.models;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthenticationRequest {
	
	
	private String instcode;	//1810010387
	
	private String password;	//test123

	public AuthenticationRequest() { 
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
