package u9urturk.carpetwashing.io.entities.concretes.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginWithUserDto implements Dto {
	
	private String email;
	
	private String password;
}
