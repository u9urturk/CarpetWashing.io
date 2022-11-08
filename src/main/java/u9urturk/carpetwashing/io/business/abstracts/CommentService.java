package u9urturk.carpetwashing.io.business.abstracts;

import java.util.List;

import u9urturk.carpetwashing.io.core.utilities.results.DataResult;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.entities.concretes.Comment;
import u9urturk.carpetwashing.io.entities.concretes.dtos.CommentWithUserDto;

public interface CommentService {
	
	Result add(Comment comment);
	Result delete(Comment comment);
	Result update(Comment comment);
	
	DataResult<List<Comment>> getAll();
	DataResult<List<CommentWithUserDto>> getAllCommentDetails();
}
