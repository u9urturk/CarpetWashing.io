package u9urturk.carpetwashing.io.core.utilities.imageservice;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public class LocalFile implements UploadImageService {
	
	@Value("${file.upload-dir}")
	String FILE_DIRECTORY;
	@Override
	public String uploadImage(MultipartFile file) throws Exception {
		
			
			File myFile = new File(FILE_DIRECTORY + file.getOriginalFilename());
			myFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(myFile);
			fos.write(file.getBytes());
			fos.close();
			
			return null;  
	
		
		
		
	}

}
