package u9urturk.carpetwashing.io.core.utilities.rules.abstracts;

import u9urturk.carpetwashing.io.core.utilities.results.Result;

public interface LoginRules {
	
	 Result EmailNotFound(String email);
	 
	 Result PasswordError(String email,String password);
}
