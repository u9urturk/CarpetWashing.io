package u9urturk.carpetwashing.io.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import u9urturk.carpetwashing.io.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	User findByEmail(String email);
}
