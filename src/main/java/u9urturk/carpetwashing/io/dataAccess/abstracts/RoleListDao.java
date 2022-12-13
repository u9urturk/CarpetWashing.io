package u9urturk.carpetwashing.io.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import u9urturk.carpetwashing.io.entities.concretes.RoleList;
import u9urturk.carpetwashing.io.entities.concretes.dtos.RoleListWithUserAndRoleDto;

public interface RoleListDao extends JpaRepository<RoleList, Integer> {
	
	@Query(
			"Select new u9urturk.carpetwashing.io.entities.concretes.dtos.RoleListWithUserAndRoleDto"
			+ "(u.id,r.id,u.email,r.role)"
			+"From RoleList rl  Join User u On rl.userId = u.id Join Role r On rl.roleId = r.id"
			)
	public List<RoleListWithUserAndRoleDto> getAllDetails();
	
	
	
	@Query(
			"Select new u9urturk.carpetwashing.io.entities.concretes.dtos.RoleListWithUserAndRoleDto"
			+ "(u.id,r.id,u.email,r.role)"
			+"From RoleList rl  Join User u On rl.userId = u.id Join Role r On rl.roleId = r.id Where u.email =:email"
			)
	public RoleListWithUserAndRoleDto getDetailsByEmail(String email);
}
