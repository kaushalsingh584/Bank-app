package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.Account;
import com.monocept.entity.Customer;
import com.monocept.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerContoller {

	@Autowired
	private ICustomerService customerservice;
	
	@PostMapping
	public List<Customer> saveAll(@RequestBody List<Customer> Customers)
	{
		return customerservice.saveAll(Customers);
	}
	
	@GetMapping
	public List<Customer> findAll()
	{
		return customerservice.findAll();
	}
	
	@DeleteMapping("/{customerid}")
	public void deleteById(@PathVariable int customerid)
	{
		 customerservice.deleteById(customerid);
	}
	
//	@PutMapping
//	public Customer update(@RequestBody Customer Customers)
//	{
//		return customerservice.save(Customers);
//	}
	@PutMapping
	public Customer updateAccounts(
			@RequestParam Integer customerId,
			@RequestParam Integer accountId)
	{
		return customerservice.updateAccounts(customerId,accountId);
	}
	
	@GetMapping("/totalBalance/{customerid}")
	public double getTotalBalance(@PathVariable int customerid)
	{
		return customerservice.getTotalBalance(customerid);
	}  
}
