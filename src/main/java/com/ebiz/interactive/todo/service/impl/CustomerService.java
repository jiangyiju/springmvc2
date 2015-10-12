package com.ebiz.interactive.todo.service.impl;
import javax.annotation.Resource;  
import org.springframework.stereotype.Service;
import com.ebiz.interactive.todo.mapping.CustomerMapper;
import com.ebiz.interactive.todo.redis.Customer;
import com.ebiz.interactive.todo.service.ICustomerService;


@Service
public class CustomerService implements ICustomerService{
	@Resource
	private CustomerMapper customerMapper; 
	@Override
	public Customer getCustomerById(long customerId){
		Customer customer = this.customerMapper.selectByPrimaryKey(customerId);
    	return customer;
	}
}