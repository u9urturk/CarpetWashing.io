package u9urturk.carpetwashing.io.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import u9urturk.carpetwashing.io.entities.concretes.ProfileImage;

public interface ProfileImageDao extends JpaRepository<ProfileImage, Integer> {
	
	ProfileImage findByUserId(int userId);
}
