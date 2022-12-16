package u9urturk.carpetwashing.io.core.utilities.rules.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.core.utilities.results.SuccessResult;
import u9urturk.carpetwashing.io.core.utilities.rules.abstracts.LoginRules;
import u9urturk.carpetwashing.io.dataAccess.abstracts.UserDao;

@Service
@RequiredArgsConstructor
public class LoginRulesManager implements LoginRules {
	
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public Result EmailNotFound(String email) {
		if(this.userDao.findByEmail(email) == null) {
			return new SuccessResult("Böyle bir kullanıcı bulunamadı");
			
			
		}
		
		return null;
	}


	@Override
	public Result PasswordError(String email,String password) {
		if(this.userDao.findByEmail(email)!=null &&this.userDao.findByEmail(email).getPassword() != password) {
			return new SuccessResult("Parola hatalı");
		}
		
		return null;
	}


	
	
	

}
