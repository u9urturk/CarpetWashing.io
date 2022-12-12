package u9urturk.carpetwashing.io.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	
	@GetMapping("getalldetails")
	public DataResult<List<RoleListWithUserAndRoleDto>>getDetails(){
		return this.roleListService.getAllDetails();
	}
	
}
