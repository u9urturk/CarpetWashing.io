package u9urturk.carpetwashing.io.webApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import u9urturk.carpetwashing.io.business.abstracts.RoleService;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.entities.concretes.Role;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RolesController {
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/add")
	public Result add(@RequestBody Role role) {
		return this.roleService.add(role);
		
	}
	
	
	@PostMapping("/getall")
	public Result getAll() {
		return this.roleService.getAll();
		
	}
}
