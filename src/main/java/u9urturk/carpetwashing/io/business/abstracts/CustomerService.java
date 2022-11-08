package u9urturk.carpetwashing.io.business.abstracts;

import java.util.List;

import u9urturk.carpetwashing.io.core.utilities.results.DataResult;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.entities.concretes.Customer;
import u9urturk.carpetwashing.io.entities.concretes.dtos.CustomerWithUserDto;

public interface CustomerService {
	
	Result add(Customer customer);
	Result delete(Customer customer);
	Result update(Customer customer);
	
	DataResult<List<Customer>> getAll();
	DataResult<List<CustomerWithUserDto>> getCustomerDetails();
}
