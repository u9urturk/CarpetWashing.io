package u9urturk.carpetwashing.io.business.abstracts;

import java.util.List;

import u9urturk.carpetwashing.io.core.utilities.results.DataResult;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.entities.concretes.Role;

public interface RoleService {
	
	DataResult<List<Role>> getAll();
	
	Result add(Role role);
}
