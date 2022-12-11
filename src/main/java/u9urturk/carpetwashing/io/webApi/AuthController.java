package u9urturk.carpetwashing.io.webApi;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;
import u9urturk.carpetwashing.io.core.utilities.auth.config.JwtUtils;
import u9urturk.carpetwashing.io.entities.concretes.dtos.LoginWithUserDto;



@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthenticationManager authenticationManager;
	private final UserDetailsService userDetailsService;
	private final JwtUtils jwtUtils;
	
	
	
	
	@PostMapping("/authenticate")
	public ResponseEntity<String> authenticate(@RequestBody LoginWithUserDto request){
		
		authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		
		final UserDetails user  = userDetailsService.loadUserByUsername(request.getEmail());
		
		if(user != null) {
			return ResponseEntity.ok( jwtUtils.generateToken(user));
		}
		
		return ResponseEntity.status(400).body("Bazı hatalar oluştu");
	}
}
