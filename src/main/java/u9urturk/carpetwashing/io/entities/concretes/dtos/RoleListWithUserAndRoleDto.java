package u9urturk.carpetwashing.io.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleListWithUserAndRoleDto implements Dto {	
	
	private int userId;
	
	private int roleId;
	
	private String email;
	
	private String role;
}
