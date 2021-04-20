package co.edu.poli.mongodb.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "Users")
public class User {
 
	@Id 
	ObjectId databaseId;
	
	private String email;
	
	private String institutionalCode;
	
	private String name;
	
	private String lastName;
	
	private String userName;
	
	private String password;
	
	private String roles;
	
	private boolean active;
	

	public User() {
		
	}
	

	public User(String email, String institutionalCode, String name, String lastName,
			String userName, String password, String roles, boolean active) {
	
		this.email = email;
		this.institutionalCode = institutionalCode;
		this.name = name;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.roles = roles;
		this.active = active;
	}


	public String getDatabaseId() {
		return databaseId.toString();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInstitutionalCode() {
		return institutionalCode;
	}

	public void setInstitutionalCode(String institutionalCode) {
		this.institutionalCode = institutionalCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRoles() {
		return roles;
	}


	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


}