package u9urturk.carpetwashing.io.business.abstracts;

import java.util.List;

import u9urturk.carpetwashing.io.core.utilities.results.DataResult;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.entities.concretes.User;

public interface UserService {
	
	Result add(User user);
	Result delete(User user);
	Result update(User user);
	
	DataResult<List<User>> getAll();
	
	DataResult<User>findByEmail(String email);
}
