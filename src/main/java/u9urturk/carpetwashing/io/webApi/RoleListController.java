package u9urturk.carpetwashing.io.webApi;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import u9urturk.carpetwashing.io.business.abstracts.RoleListService;
import u9urturk.carpetwashing.io.core.utilities.results.DataResult;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.entities.concretes.RoleList;
import u9urturk.carpetwashing.io.entities.concretes.dtos.RoleListWithUserAndRoleDto;

@RestController
@RequestMapping("/api/rolelist")
@RequiredArgsConstructor
public class RoleListController {
	@Autowired
	private RoleListService roleListService;
	
	
	@PostMapping("/add")
	public Result add(@RequestBody RoleList roleList) {
		
		return this.roleListService.add(roleList);
	}
	
	@GetMapping("getall")
	public DataResult<List<RoleList>> getAll(){
		return this.roleListService.getAll();
	}
	
	@RolesAllowed("ADMIN")
	@GetMapping("getalldetails")
	public DataResult<List<RoleListWithUserAndRoleDto>>getDetails(){
		return this.roleListService.getAllDetails();
	}
	
	
	@GetMapping("getdetailbyemail")
	public DataResult<RoleListWithUserAndRoleDto>getDetailByEmail(@RequestParam String email){
		return this.roleListService.getDetailByEmail(email);
	}
	
}
