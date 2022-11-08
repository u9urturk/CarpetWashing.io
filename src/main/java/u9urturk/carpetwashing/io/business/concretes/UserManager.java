package u9urturk.carpetwashing.io.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import u9urturk.carpetwashing.io.business.abstracts.UserService;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.core.utilities.results.SuccessDataResult;
import u9urturk.carpetwashing.io.core.utilities.results.SuccessResult;
import u9urturk.carpetwashing.io.dataAccess.abstracts.UserDao;
import u9urturk.carpetwashing.io.entities.concretes.User;

@Service
public class UserManager implements UserService{
	
	private UserDao dao;
	
	@Autowired
	public UserManager(UserDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public Result add(User user) {
		this.dao.save(user);
		return new 	SuccessResult("Veri eklendi.");
	}

	@Override
	public SuccessDataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.dao.findAll(), "Veri getirildi.");
	}

	@Override
	public Result delete(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
