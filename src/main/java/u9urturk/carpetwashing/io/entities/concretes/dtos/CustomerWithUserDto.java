package u9urturk.carpetwashing.io.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerWithUserDto implements Dto {
	
	private int userId;
	private int customerId;
	private String name;
	private String surname;
	
}
