package u9urturk.carpetwashing.io.entities.concretes.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ImageWithUserDto implements Dto{
	
	private int id;
	private int userId;
	private String name;
	private String surname;
	private String url;
	private Date addDate;
	
}
