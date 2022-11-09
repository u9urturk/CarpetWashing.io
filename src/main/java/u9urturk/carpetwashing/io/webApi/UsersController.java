package u9urturk.carpetwashing.io.webApi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import u9urturk.carpetwashing.io.business.abstracts.UserService;
import u9urturk.carpetwashing.io.core.utilities.results.DataResult;
import u9urturk.carpetwashing.io.core.utilities.results.ErrorDataResult;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	
	private UserService service;
	
	@Autowired
	public UsersController(UserService service) {
		super();
		this.service = service;
	}
	
	
	
	@GetMapping("/getall")
	public DataResult<List<User>> getAll(){
		
		return this.service.getAll();
	}
	
	@GetMapping("/findbyemail")
	public DataResult<User>findByEmail(String email){
		return this.service.findByEmail(email);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody User user) {
		return ResponseEntity.ok(this.service.add(user));
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException
	(MethodArgumentNotValidException exception){
		Map<String, String> validationErrors = new HashMap<String,String>();
		for(FieldError fieldError :  exception.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		return errors;
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody User user) {
		return this.service.update(user);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody User user) {
		return this.service.delete(user);
	}
	
	
}
