package u9urturk.carpetwashing.io.business.concretes;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import u9urturk.carpetwashing.io.business.abstracts.ProfileImageService;
import u9urturk.carpetwashing.io.core.utilities.imageservice.UploadImageService;
import u9urturk.carpetwashing.io.core.utilities.results.DataResult;
import u9urturk.carpetwashing.io.core.utilities.results.ErrorResult;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.core.utilities.results.SuccessDataResult;
import u9urturk.carpetwashing.io.core.utilities.results.SuccessResult;
import u9urturk.carpetwashing.io.dataAccess.abstracts.ProfileImageDao;
import u9urturk.carpetwashing.io.entities.concretes.ProfileImage;

@Service
@RequiredArgsConstructor
@RolesAllowed({"ADMIN,USER"})
public class ProfileImageManager implements ProfileImageService {
	
	@Autowired
	private ProfileImageDao profileImageDao;
	
	@Autowired
	private UploadImageService uploadImageService;
	
	@Override
	public Result add(MultipartFile file , int userId) throws Exception {
		
		if(getByUserId(userId).getData() == null) {
			String url = this.uploadImageService.uploadImage(file);
			if(!url.isEmpty()) {
				ProfileImage profileImage = new ProfileImage();
				profileImage.setUserId(userId);
				profileImage.setImageUrl(url);
				this.profileImageDao.save(profileImage);
				return new SuccessResult("Görsel eklendi.");
			}
			return new ErrorResult("Yüklemek istenen görsel uygun değildir.");
		}else if(getByUserId(userId).getData()!= null) {
			
			return new ErrorResult("Sadece bir profil fotoğrafınız olabilir.");
		
		}
		
		return new ErrorResult("Beklenmedik hata ! ");
		

	
	
	}

	@Override
	public Result delete(ProfileImage profileImage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(ProfileImage profileImage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<ProfileImage>> getAll() {
		return new SuccessDataResult<>(this.profileImageDao.findAll());
	}

	@Override
	public DataResult<ProfileImage> getByUserId(int userId) {
		return new SuccessDataResult<ProfileImage>(this.profileImageDao.findByUserId(userId), "OK");
	}

}
