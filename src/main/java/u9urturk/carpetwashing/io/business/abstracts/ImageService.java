package u9urturk.carpetwashing.io.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import u9urturk.carpetwashing.io.core.utilities.results.DataResult;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.entities.concretes.image;
import u9urturk.carpetwashing.io.entities.concretes.dtos.ImageWithUserDto;

public interface ImageService {
	
	Result add(MultipartFile myFile , int userId , int commentId) throws Exception;
	Result delete(image image);
	
	
	
	DataResult<List<image>> getAll();
	DataResult<List<ImageWithUserDto>> getAllImageDetails();
	Result update(MultipartFile file, int id) throws Exception;
	

}
