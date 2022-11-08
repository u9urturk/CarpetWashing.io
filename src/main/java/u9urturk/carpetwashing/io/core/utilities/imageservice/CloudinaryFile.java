package u9urturk.carpetwashing.io.core.utilities.imageservice;


import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
@Service
public class CloudinaryFile implements UploadImageService {
	
		
	
	
	Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
			
			"cloud_name", "dubzmvbcl",
			"api_key", "819172686917126",
			"api_secret", "ks95qme0p_ufCZmzTzw7wcuPB8s",
			"secure", true
			
			));
	
	
	@Override
	public String uploadImage(MultipartFile file) throws Exception {
		File myFile  = new File(file.getOriginalFilename());
		myFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(myFile);
		fos.write(file.getBytes());
		fos.close();
		Map uploadResult = cloudinary.uploader().upload(myFile, ObjectUtils.emptyMap());
		//System.out.println(uploadResult.get("url"));
		return uploadResult.get("url").toString();
	}

}
