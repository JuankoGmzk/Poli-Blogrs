package co.edu.poli_blogrs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import co.edu.poli_blogrs.models.AuthenticationRequest;
import co.edu.poli_blogrs.models.AuthenticationResponse;
import co.edu.poli_blogrs.models.UserModel;
import co.edu.poli_blogrs.repository.UserRepository;

@RestController
public class AuthController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationmanager;

	@PostMapping("/register")
	private ResponseEntity<?> registerClient(@RequestBody AuthenticationRequest autheticationRequest){
		
		String username = autheticationRequest.getUsername();
		String email = autheticationRequest.getEmail();
		String instcode = autheticationRequest.getInstCode();
		String password = autheticationRequest.getPassword();
		UserModel userModel = new UserModel();
		userModel.setUsername(username);
		userModel.setEmail(email);
		userModel.setInstCode(instcode);
		userModel.setPassword(password);
		try {
			userRepository.save(userModel);
		} catch (Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("Error, revise la información y vuelva a intentarlo"));
		}
		
		return ResponseEntity.ok(new AuthenticationResponse("Se ha resgistrado correctamente con el codigo institucional: " + instcode));
	}
	
	
	@PostMapping("/login")
	private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest autheticationRequest){
		
		String icd = autheticationRequest.getInstCode();
		String psw = autheticationRequest.getPassword();
		try {
			authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(icd,psw));
		} catch (Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("Error, revise la información y vuelva a intentarlo"));
		}			
		return ResponseEntity.ok(new AuthenticationResponse("Se ha logueado correctamente con el codigo institucional: " + icd));
	}
}
