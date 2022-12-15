package u9urturk.carpetwashing.io.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import u9urturk.carpetwashing.io.business.abstracts.ProfileImageService;
import u9urturk.carpetwashing.io.core.utilities.results.DataResult;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.entities.concretes.ProfileImage;

@RestController
@RequestMapping("api/profileimages")
@RequiredArgsConstructor
public class ProfileImagesController {
	
	@Autowired
	private ProfileImageService profileImageService;
	
	@PostMapping("/add")
	public Result add (@RequestParam("File") MultipartFile file,int userId) throws Exception {
		
		return this.profileImageService.add(file,userId);
		
	}
	
	
	@GetMapping("getall")
	public DataResult<List<ProfileImage>> getAll(){
		return this.profileImageService.getAll();
	}
}
