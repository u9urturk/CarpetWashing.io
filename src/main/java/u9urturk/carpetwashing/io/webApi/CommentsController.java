package u9urturk.carpetwashing.io.webApi;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import u9urturk.carpetwashing.io.business.abstracts.CommentService;
import u9urturk.carpetwashing.io.core.utilities.results.DataResult;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.entities.concretes.Comment;
import u9urturk.carpetwashing.io.entities.concretes.dtos.CommentWithUserDto;
@RestController
@RequestMapping("api/comments")
public class CommentsController {
	
	
	private CommentService commentService;
	
	@Autowired
	public CommentsController(CommentService commentService) {
		super();
		this.commentService = commentService;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<Comment>> getAll(){
		return this.commentService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody Comment comment) {
		Comment comment_ = new Comment();
		comment_ = comment;
		comment_.setAddDate(new Date());
		return this.commentService.add(comment_);
	}
	
	@GetMapping("/getalldetails")
	public DataResult<List<CommentWithUserDto>> getAllCommentDetails(){
		return this.commentService.getAllCommentDetails();
	}
	
	
}
