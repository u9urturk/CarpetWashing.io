package u9urturk.carpetwashing.io.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import u9urturk.carpetwashing.io.entities.concretes.image;
import u9urturk.carpetwashing.io.entities.concretes.dtos.ImageWithUserDto;

public interface ImageDao extends JpaRepository<image, Integer> {
	
	
	@Query(
			"Select new u9urturk.carpetwashing.io.entities.concretes.dtos.ImageWithUserDto"
			+ "(i.id,u.id,u.name,u.surname,i.url,i.addDate)"
			+"From User u Inner Join image i on u.id = i.userId"
			)
	List<ImageWithUserDto> getAllImageDetails();
	
	image findByUserId(int userId);
	
	image findById(int id);
	
	
}
