package com.ebiz.interactive.todo.controller;

import com.ebiz.interactive.todo.redis.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
//import com.ebiz.interactive.todo.model.Customer;
//import com.ebiz.interactive.todo.model.CustomerExample;
//import com.ebiz.interactive.todo.model.CustomerExample.Criteria;
import com.ebiz.interactive.todo.redis.Customer;
import com.ebiz.interactive.todo.service.ICustomerService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ebiz.interactive.todo.message.Sender;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/test")
public class HomeController {

    @Resource
    private ICustomerService customerService;

    @Autowired
    private Sender sender;

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/mybatis")
    public String mybatis(Model m) {
        long customerId = 2;
        Customer customer = this.customerService.getCustomerById(customerId);
      /*CustomerExample customerExample = new CustomerExample();
	  Criteria criteria = customerExample.createCriteria();
	  criteria.andIdEqualTo(UserID);
	  List<Customer> listCustomers = customerMapper.selectByExample(customerExample);
	  for(Customer c:listCustomers){
		  System.out.println("sex:" + c.getSex());
	  }*/
        return "home";
    }

    @RequestMapping("/jms")
    public String jms(Model m) {
        sender.sendInfo();
        return "home";
    }

    @RequestMapping(value = "/redis", method = RequestMethod.GET)
    public String redis() throws Exception {
        System.out.println("redis start");
        Customer customer = new Customer(2);
        String key = "my:user:zhaozhiming";
        customerRepository.set(key, customer);
        Customer myCustomer = customerRepository.get(key);
        System.out.println(myCustomer.getSex());
        System.out.println("redis end");
        return "home";
    }
}