package u9urturk.carpetwashing.io.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import u9urturk.carpetwashing.io.entities.concretes.Comment;
import u9urturk.carpetwashing.io.entities.concretes.dtos.CommentWithUserDto;

public interface CommentDao extends JpaRepository<Comment, Integer> {
	
	
	
	@Query(
			"Select new u9urturk.carpetwashing.io.entities.concretes.dtos.CommentWithUserDto"
			+"(u.id,u.name,u.surname,c.addDate,c.comment)"
			+"From User u Inner Join Comment c On u.id = c.userId"		
			)
	List<CommentWithUserDto> getAllCommentsDetails();
}
