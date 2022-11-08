package u9urturk.carpetwashing.io.webApi;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import u9urturk.carpetwashing.io.business.abstracts.ImageService;
import u9urturk.carpetwashing.io.core.utilities.results.DataResult;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.entities.concretes.image;
import u9urturk.carpetwashing.io.entities.concretes.dtos.ImageWithUserDto;

@RestController
@RequestMapping("/api/images")
public class ImagesController  {
	
	private ImageService imageService;
	
	@Autowired
	public ImagesController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	
	
	
	@PostMapping("/add")
	public Result add (@RequestParam("File") MultipartFile file) throws Exception {
		
		return this.imageService.add(file);
		
	}
	
	@GetMapping("/getalldetails")
	public DataResult<List<ImageWithUserDto>> getAllDetails(){
		return this.imageService.getAllImageDetails();
	}
	
	@GetMapping("/getall")
	public DataResult<List<image>> getAll(){
		return this.imageService.getAll();
	}
	
	
	
}
