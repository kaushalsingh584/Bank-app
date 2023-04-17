package com.monocept.service;

import java.util.List;

import com.monocept.entity.Account;
import com.monocept.entity.Customer;

public interface ICustomerService {

	void deleteById(int customerid);

	List<Customer> findAll();

	List<Customer> saveAll(List<Customer> customers);

	Customer save(Customer customers);

	Customer updateAccounts(Integer customerId, Integer accountId);

	double getTotalBalance(int customerid);

}
