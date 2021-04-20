package co.edu.poli.mongodb.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.poli.mongodb.model.User;
import co.edu.poli.mongodb.repository.UserRepository;

@RestController // Defines that this class is a spring bean
@RequestMapping("/PB/Users")
public class UserController {

	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/User")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/User/{id}")
	public User getUserByID(@PathVariable ObjectId id) {
		return userRepository.findById(id.toString()).get();
	}
	
	@PostMapping("/Create")
	public User saveUser(@RequestBody User user){
		return userRepository.save(user);
	}
	

	@PutMapping("/Edit/{id}")
	public User updateUser(@PathVariable ObjectId id, @RequestBody User user) {
		
		User _User = userRepository.findById(id.toString()).get();
		_User.setEmail(user.getEmail());
		_User.setInstitutionalCode(user.getInstitutionalCode());
		_User.setLastName(user.getLastName());
		_User.setName(user.getName());
		_User.setPassword(user.getPassword());
		_User.setUserName(user.getUserName());
		userRepository.save(_User);
		
		return _User;
	}
	
	@DeleteMapping("/Delete/{id}")
	public User deleteUserById(@PathVariable ObjectId id) {
		User _user = userRepository.findById(id.toString()).get();
		userRepository.deleteById(id.toString());
		return _user;
	}
	
}