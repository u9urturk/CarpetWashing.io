package u9urturk.carpetwashing.io.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import u9urturk.carpetwashing.io.business.abstracts.AuthService;
import u9urturk.carpetwashing.io.core.utilities.auth.config.JwtUtils;
import u9urturk.carpetwashing.io.core.utilities.results.DataResult;
import u9urturk.carpetwashing.io.core.utilities.results.ErrorDataResult;
import u9urturk.carpetwashing.io.core.utilities.results.ErrorTokenResult;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.core.utilities.results.SuccessDataResult;
import u9urturk.carpetwashing.io.core.utilities.results.SuccessTokenResult;
import u9urturk.carpetwashing.io.core.utilities.results.TokenResult;
import u9urturk.carpetwashing.io.core.utilities.rules.abstracts.LoginRules;
import u9urturk.carpetwashing.io.entities.concretes.dtos.LoginWithUserDto;

@Service
@RequiredArgsConstructor
public class AuthManager implements AuthService {
	
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private JwtUtils jwtUtils;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private LoginRules loginRules;
	
	@Override
	public Result Register() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TokenResult Login(LoginWithUserDto loginWithUserDto) {
		
		authenticationManager.authenticate(
				
				new UsernamePasswordAuthenticationToken(loginWithUserDto.getEmail(), loginWithUserDto.getPassword()));
				final UserDetails userDetails = userDetailsService.loadUserByUsername(loginWithUserDto.getEmail());
				if(userDetails !=null) {
					
					return new SuccessTokenResult(jwtUtils.generateToken(userDetails), "Giriş başarılı");
				}
				
			return	(TokenResult) loginRules.EmailNotFound(loginWithUserDto.getEmail());
			//return	(TokenResult) loginRules.PasswordError(loginWithUserDto.getEmail(), loginWithUserDto.getPassword());
				
				

	}

}
