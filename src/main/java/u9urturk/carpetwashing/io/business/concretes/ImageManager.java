package u9urturk.carpetwashing.io.business.concretes;


import java.util.Date;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import u9urturk.carpetwashing.io.business.abstracts.ImageService;
import u9urturk.carpetwashing.io.core.utilities.imageservice.UploadImageService;
import u9urturk.carpetwashing.io.core.utilities.results.DataResult;
import u9urturk.carpetwashing.io.core.utilities.results.ErrorResult;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.core.utilities.results.SuccessDataResult;
import u9urturk.carpetwashing.io.core.utilities.results.SuccessResult;
import u9urturk.carpetwashing.io.dataAccess.abstracts.ImageDao;
import u9urturk.carpetwashing.io.entities.concretes.image;
import u9urturk.carpetwashing.io.entities.concretes.dtos.ImageWithUserDto;

@Service
public class ImageManager implements ImageService {
	
	private ImageDao dao;
	private UploadImageService imageService;
	
	@Autowired
	public ImageManager(ImageDao imageDao ,UploadImageService imageService) {
		super();
		this.dao = imageDao;
		this.imageService = imageService;
	}
	
	@RolesAllowed({"ADMIN","USER"})
	@Override
	public Result add(MultipartFile file , int userId , int commentId) throws Exception {
		 
		
			String url = this.imageService.uploadImage(file);
			if(!url.isEmpty()) {
				image image = new image();
				image.setUserId(userId);
				image.setCommentId(commentId);
				image.setUrl(url);
				image.setAddDate(new Date());
				this.dao.save(image);
				return new SuccessResult("Görsel eklendi.");
			}
		
		
		
		return new ErrorResult("Yüklemek istenen görsel uygun değildir.");
	}
	
	@RolesAllowed({"ADMIN","USER"})
	@Override
	public Result update(MultipartFile file , int id ) throws Exception {
		
		String url = this.imageService.uploadImage(file);
		if(!url.isEmpty()) {
			image image = this.dao.findById(id);
			image.setUrl(url);
			this.dao.save(image);
			return new SuccessResult("Görsel eklendi.");
		}
	
	
	
	return new ErrorResult("Yüklemek istenen görsel uygun değildir.");
	}
	

	@RolesAllowed({"ADMIN","USER"})
	@Override
	public Result delete(image image) {
		this.dao.delete(image);
		return new SuccessResult("Başarıyla silindi");
	}

	

	@Override
	public DataResult<List<image>> getAll() {
		return new SuccessDataResult<List<image>>(this.dao.findAll(), "Veri getirildi.");
	}
	
	@Override
	public DataResult<List<ImageWithUserDto>> getAllImageDetails(){
		return new SuccessDataResult<List<ImageWithUserDto>>(this.dao.getAllImageDetails(), "Detay bilgi getirildi.");
	}


}
