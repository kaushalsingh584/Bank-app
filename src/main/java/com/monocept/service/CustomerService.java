package com.monocept.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Account;
import com.monocept.entity.Customer;
import com.monocept.repository.AccountRepository;
import com.monocept.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountRepository accountRepository;

	private Customer customer;
	
	@Override
	public List<Customer> saveAll(List<Customer> Customers) {
		
		return customerRepository.saveAll(Customers);
		
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public void deleteById(int Customerid) {
		customerRepository.deleteById(Customerid);
		
	}

	@Override
	public Customer save(Customer customers) {
		// TODO Auto-generated method stub
		return customerRepository.save(customers);
	}

	@Override
	public Customer updateAccounts(Integer customerId, Integer accountId) {
		
		Customer customer = customerRepository.findById(customerId).orElseThrow();
		Account account = accountRepository.findById(accountId).orElseThrow();
		
		customer.getAccounts().add(account);
		
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public double getTotalBalance(int customerId) {
		
		customer = customerRepository.findById(customerId).orElseThrow();
		List<Account> accounts = customer.getAccounts();
		double total = 0;
		for(Account acc : accounts)
		{
			total += acc.getBalance();
		}
		customer.setTotalBalance(total);
		customerRepository.save(customer);
		return total;
	}

	

}
