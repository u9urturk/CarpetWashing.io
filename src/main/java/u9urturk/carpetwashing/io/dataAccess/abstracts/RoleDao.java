package u9urturk.carpetwashing.io.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import u9urturk.carpetwashing.io.entities.concretes.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {
	
	
	
}
