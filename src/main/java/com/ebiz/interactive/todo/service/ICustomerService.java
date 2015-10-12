package com.ebiz.interactive.todo.service;

import com.ebiz.interactive.todo.redis.Customer;

public interface ICustomerService{
	public Customer getCustomerById(long CustomerId);
}