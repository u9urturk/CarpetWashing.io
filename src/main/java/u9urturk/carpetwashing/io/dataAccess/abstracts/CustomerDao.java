package u9urturk.carpetwashing.io.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import u9urturk.carpetwashing.io.entities.concretes.Customer;
import u9urturk.carpetwashing.io.entities.concretes.dtos.CustomerWithUserDto;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
	

	
	@Query("Select new u9urturk.carpetwashing.io.entities.concretes.dtos.CustomerWithUserDto"
			+ "(u.id,c.id,u.name,u.surname)"
			+ "From User u Inner Join Customer c On u.id = c.userId")	
	List<CustomerWithUserDto> getCustomersDetails();
}
