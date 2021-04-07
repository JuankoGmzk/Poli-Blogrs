package co.edu.poli_blogrs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.edu.poli_blogrs.models.UserModel;
import co.edu.poli_blogrs.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String instcode) throws UsernameNotFoundException {
		UserModel foundedUser = userRepository.findByUsername(instcode);
		if(foundedUser == null)
			return null;
		String icd = foundedUser.getInstCode();
		String pwd = foundedUser.getPassword();
		return new User(icd, pwd, null);
	}
	
	

}
