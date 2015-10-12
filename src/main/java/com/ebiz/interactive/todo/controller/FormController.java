package com.ebiz.interactive.todo.controller;
import com.ebiz.interactive.todo.redis.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yishang on 2015/10/7.
 */
@Controller
@RequestMapping(value="form")
public class FormController {
    @RequestMapping(value="input",method=RequestMethod.GET)
    public String input(Model model){
        Customer customer = new Customer(1,2);
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(customer);
        model.addAttribute("customers",customers);
        model.addAttribute("customer",customer);
        return "form/input";
    }

    @RequestMapping(value = "save")
    public String save(@ModelAttribute Customer customer){
        return "home";
    }

    @RequestMapping(value = "edit/{id}")
    public String edit(Model model,@PathVariable int id){
        model.addAttribute("name",id+"");
        return "home";
    }
}
