package co.edu.poli.blogrs.controller;

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

import co.edu.poli.blogrs.models.AuthenticationRequest;
import co.edu.poli.blogrs.models.AuthenticationResponse;
import co.edu.poli.blogrs.models.UserModel;
import co.edu.poli.blogrs.repository.UserRepository;

@RestController
public class AuthController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationmanager;

	@PostMapping("/register")
	private ResponseEntity<?> registerClient(@RequestBody AuthenticationRequest autheticationRequest){
		
		String instcode = autheticationRequest.getInstCode();
		String password = autheticationRequest.getPassword();
		UserModel userModel = new UserModel();
		userModel.setInstCode(instcode);
		userModel.setPassword(password);
		try {
			userRepository.save(userModel);
		} catch (Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("Ha ocurrido un error relacionado a este codigo: " + instcode));
		}
		
		return ResponseEntity.ok(new AuthenticationResponse("Se ha resgistrado correctamente con el codigo institucional: " + instcode));
		
	}
	
	
	@PostMapping("/login")
	private ResponseEntity<?> logedClient(@RequestBody AuthenticationRequest autheticationRequest){
		
		String instcode = autheticationRequest.getInstCode();
		String password = autheticationRequest.getPassword();
		try {
			authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(instcode, password));
		} catch (BadCredentialsException e) {
			return ResponseEntity.ok(new AuthenticationResponse("No se a podido completar el logueo con este codigo: " + instcode));
		}			
		return ResponseEntity.ok(new AuthenticationResponse("Se ha logueado correctamente con el codigo institucional: " + instcode));
	}
}
