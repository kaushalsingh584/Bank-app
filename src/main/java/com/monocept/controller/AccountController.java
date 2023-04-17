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
import com.monocept.service.IAccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private IAccountService Accountservice;
	
	@PostMapping
	public List<Account> saveAll(@RequestBody List<Account> Accounts)
	{
		return Accountservice.saveAll(Accounts);
	}
	
	@GetMapping
	public List<Account> findAll()
	{
		return Accountservice.findAll();
	}
	
	@DeleteMapping("/{Accountid}")
	public void deleteById(@PathVariable int Accountid)
	{
		 Accountservice.deleteById(Accountid);
	}
	@PutMapping
	public Account update(@RequestBody Account account)
	{
		return Accountservice.save(account);
	}
	
	
	
	
	
}
