package u9urturk.carpetwashing.io.business.concretes;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import u9urturk.carpetwashing.io.business.abstracts.RoleService;
import u9urturk.carpetwashing.io.core.utilities.results.DataResult;
import u9urturk.carpetwashing.io.core.utilities.results.ErrorResult;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.core.utilities.results.SuccessDataResult;
import u9urturk.carpetwashing.io.core.utilities.results.SuccessResult;
import u9urturk.carpetwashing.io.dataAccess.abstracts.RoleDao;
import u9urturk.carpetwashing.io.entities.concretes.Role;

@Service
public class RoleManager implements RoleService {
	
	private RoleDao roleDao;
	
	@Autowired
	public RoleManager(RoleDao roleDao) {
		super();
		this.roleDao = roleDao;
	}

	

	@Override
	public Result add(Role role) {
		this.roleDao.save(role);
		if(role.getRole() != null) {
			return new SuccessResult("Başarılı ! ");
		}
		
		return new ErrorResult("Başarısız ! ");
		
		
	}



	@Override
	public DataResult<List<Role>> getAll() {
		return new SuccessDataResult<List<Role>>(this.roleDao.findAll());
	}

}
