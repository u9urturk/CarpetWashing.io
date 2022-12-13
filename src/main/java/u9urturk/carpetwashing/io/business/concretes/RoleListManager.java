package u9urturk.carpetwashing.io.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import u9urturk.carpetwashing.io.business.abstracts.RoleListService;
import u9urturk.carpetwashing.io.core.utilities.results.DataResult;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.core.utilities.results.SuccessDataResult;
import u9urturk.carpetwashing.io.core.utilities.results.SuccessResult;
import u9urturk.carpetwashing.io.dataAccess.abstracts.RoleListDao;
import u9urturk.carpetwashing.io.entities.concretes.RoleList;
import u9urturk.carpetwashing.io.entities.concretes.dtos.RoleListWithUserAndRoleDto;


@RequiredArgsConstructor
@Service
public class RoleListManager implements RoleListService {
	
	@Autowired
	private RoleListDao roleListDao;
	
	@Override
	public Result add(RoleList roleList) {
		this.roleListDao.save(roleList);
		return new SuccessResult("Başarılı");
	}

	@Override
	public Result delete(RoleList roleList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(RoleList roleList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<RoleList>> getAll() {
		return new SuccessDataResult<List<RoleList>>(this.roleListDao.findAll());
	}

	@Override
	public DataResult<List<RoleListWithUserAndRoleDto>> getAllDetails() {
		return new SuccessDataResult<List<RoleListWithUserAndRoleDto>>(this.roleListDao.getAllDetails(), "Detay bilgisi");
	}
	
	@Override
	public DataResult<RoleListWithUserAndRoleDto> getDetailByEmail(String email) {
		return new SuccessDataResult<RoleListWithUserAndRoleDto>(this.roleListDao.getDetailsByEmail(email), "Detay bilgisi");
	}

}
