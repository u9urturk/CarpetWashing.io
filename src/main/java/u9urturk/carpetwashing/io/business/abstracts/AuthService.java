package u9urturk.carpetwashing.io.business.abstracts;

import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.core.utilities.results.TokenResult;
import u9urturk.carpetwashing.io.entities.concretes.dtos.LoginWithUserDto;

public interface AuthService {
	
	Result Register();
	
	TokenResult Login(LoginWithUserDto loginWithUserDto);

}
