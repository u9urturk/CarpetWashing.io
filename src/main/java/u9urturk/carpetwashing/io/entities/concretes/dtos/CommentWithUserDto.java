package u9urturk.carpetwashing.io.entities.concretes.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentWithUserDto implements Dto {
	
	
	private int userId;
	private String name;
	private String surname;
	private Date addDate;
	private String comment;
	
}
