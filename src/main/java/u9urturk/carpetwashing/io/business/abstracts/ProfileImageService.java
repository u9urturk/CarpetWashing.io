package u9urturk.carpetwashing.io.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import u9urturk.carpetwashing.io.core.utilities.results.DataResult;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.entities.concretes.ProfileImage;

public interface ProfileImageService {
	
	Result add(MultipartFile file , int userId) throws Exception;
	Result delete(ProfileImage profileImage);
	Result update(ProfileImage profileImage);
	
	DataResult<List<ProfileImage>> getAll();
	DataResult<ProfileImage> getByUserId(int userId);

	
}
