package u9urturk.carpetwashing.io.core.utilities.rules.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import u9urturk.carpetwashing.io.core.utilities.results.ErrorResult;
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
		
		return new ErrorResult();
	}  


	@Override
	public Result PasswordError(String email,String password) {
		boolean isEquels = false;
		String getPassword = this.userDao.findByEmail(email).getPassword();
		if(getPassword.equals(password) ) {
			isEquels = true;
			System.out.println(isEquels);
		}
		
		if(this.userDao.findByEmail(email)!=null && isEquels == false ) {
			return new SuccessResult("Parola hatalı");
		}
		return new ErrorResult();
	}


	
	
	

}
