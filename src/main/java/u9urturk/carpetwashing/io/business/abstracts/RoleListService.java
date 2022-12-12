package u9urturk.carpetwashing.io.business.abstracts;

import java.util.List;

import u9urturk.carpetwashing.io.core.utilities.results.DataResult;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.entities.concretes.RoleList;
import u9urturk.carpetwashing.io.entities.concretes.dtos.RoleListWithUserAndRoleDto;

public interface RoleListService {
	
	Result add(RoleList roleList);
	Result delete(RoleList roleList);
	Result update(RoleList roleList);
	
	
	DataResult<List<RoleList>> getAll();
	
	DataResult<List<RoleListWithUserAndRoleDto>> getAllDetails();
}
