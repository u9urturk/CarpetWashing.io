package u9urturk.carpetwashing.io.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import u9urturk.carpetwashing.io.business.abstracts.CustomerService;
import u9urturk.carpetwashing.io.core.utilities.results.DataResult;
import u9urturk.carpetwashing.io.core.utilities.results.Result;
import u9urturk.carpetwashing.io.core.utilities.results.SuccessDataResult;
import u9urturk.carpetwashing.io.core.utilities.results.SuccessResult;
import u9urturk.carpetwashing.io.dataAccess.abstracts.CustomerDao;
import u9urturk.carpetwashing.io.entities.concretes.Customer;
import u9urturk.carpetwashing.io.entities.concretes.dtos.CustomerWithUserDto;
@Service
public class CustomerManager implements CustomerService{
	
	private CustomerDao customerDao;
	
	@Autowired
	public CustomerManager(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	@Override
	public Result add(Customer customer) {
	 this.customerDao.save(customer);
	 return new SuccessResult("Veri eklendi.");
		
	}

	@Override
	public Result delete(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Customer>> getAll() {
		return new SuccessDataResult<List<Customer>>(this.customerDao.findAll(), "Veri getirildi.");
	}
	
	@Override
	public DataResult<List<CustomerWithUserDto>> getCustomerDetails(){
		return new SuccessDataResult<List<CustomerWithUserDto>>(this.customerDao.getCustomersDetails(), "Müşteri detay bilgi getirildi.");
	}

}
