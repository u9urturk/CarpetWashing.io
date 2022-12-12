package u9urturk.carpetwashing.io.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import u9urturk.carpetwashing.io.business.abstracts.CustomerService;
import u9urturk.carpetwashing.io.core.utilities.results.DataResult;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.entities.concretes.Customer;
import u9urturk.carpetwashing.io.entities.concretes.dtos.CustomerWithUserDto;
@RestController
@RequestMapping("/api/customers")
public class CustomersController {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomersController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody Customer customer) {
		System.out.println(customer);
		return null;
		//return this.customerService.add(customer);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Customer>> getAll(){
		return this.customerService.getAll(); 
	}
	
	@GetMapping("/getalldetails")
	public DataResult<List<CustomerWithUserDto>> getCustomerDetails(){
		return this.customerService.getCustomerDetails();
	}
}
