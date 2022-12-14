package u9urturk.carpetwashing.io.business.concretes;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import u9urturk.carpetwashing.io.business.abstracts.CommentService;
import u9urturk.carpetwashing.io.core.utilities.results.DataResult;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.core.utilities.results.SuccessDataResult;
import u9urturk.carpetwashing.io.core.utilities.results.SuccessResult;
import u9urturk.carpetwashing.io.dataAccess.abstracts.CommentDao;
import u9urturk.carpetwashing.io.entities.concretes.Comment;
import u9urturk.carpetwashing.io.entities.concretes.dtos.CommentWithUserDto;

@Service
public class CommentManager implements CommentService {
	
	private CommentDao commentDao;
	
	@Autowired
	public CommentManager(CommentDao commentDao) {
		super();
		this.commentDao = commentDao;
	}
	
	@RolesAllowed({"ADMIN","USER"})
	@Override
	public Result add(Comment comment) {
		this.commentDao.save(comment);
		return new SuccessResult("veri eklendi");
	}
	
	@RolesAllowed({"ADMIN","USER"})
	@Override
	public Result delete(Comment comment) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RolesAllowed({"ADMIN","USER"})
	@Override
	public Result update(Comment comment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Comment>> getAll() {
			return new SuccessDataResult<List<Comment>>(this.commentDao.findAll(), "Veri getirildi.");
	}
	
	@Override
	public DataResult<List<CommentWithUserDto>> getAllCommentDetails(){
		return new SuccessDataResult<List<CommentWithUserDto>>(this.commentDao.getAllCommentsDetails(), "Detay bilgi getirildi.");
	}

}
