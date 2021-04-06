package co.edu.poli.blogrs.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "collPoliblogrs")
public class UserModel {

	@Id
	private String id;
	
	private String username; //Miguel Angel
	
	private String email;	//miguel@poligran.edu.co

	private String password; 	//test123
	
	private String instcode;	//1810010387

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public UserModel() {

	}
	
}
