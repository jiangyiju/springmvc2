package com.ebiz.interactive.todo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * Created by yishang on 2015/10/6.
 */
@Repository
public class CustomerRepository {

    @Autowired
    private RedisTemplate<String,Customer> template;
    private ValueOperations<String,Customer> operations;

    @PostConstruct
    public void init(){
        //JacksonJsonRedisSerializer<Customer> json = new JacksonJsonRedisSerializer<Customer>(Customer.class);
        //template.setValueSerializer(json);
        operations = template.opsForValue();
    }

    public void set(String key, Customer value) {
        operations.set(key, value);
        System.out.print("Last Value:" + operations.get(key).getSex());
    }

    public Customer get(String key) {
        return operations.get(key);
    }

}