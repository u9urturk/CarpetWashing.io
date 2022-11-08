package u9urturk.carpetwashing.io.core.utilities.imageservice;



import org.springframework.web.multipart.MultipartFile;

public interface UploadImageService {
	
	String uploadImage(MultipartFile file) throws Exception;
	
}
