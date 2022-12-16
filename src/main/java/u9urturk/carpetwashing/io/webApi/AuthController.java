package u9urturk.carpetwashing.io.webApi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;
import u9urturk.carpetwashing.io.business.concretes.AuthManager;
import u9urturk.carpetwashing.io.core.utilities.results.DataResult;
import u9urturk.carpetwashing.io.core.utilities.results.TokenResult;
import u9urturk.carpetwashing.io.entities.concretes.dtos.LoginWithUserDto;



@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	
	@Autowired
	private AuthManager authManager;

	
	
	
	@PostMapping("/authenticate")
	public TokenResult authenticate(@RequestBody LoginWithUserDto loginWithUserDto){
		
		
		return this.authManager.Login(loginWithUserDto);
	}
}
