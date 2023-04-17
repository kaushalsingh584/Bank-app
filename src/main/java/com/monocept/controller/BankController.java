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
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.Account;
import com.monocept.entity.Bank;
import com.monocept.service.IBankService;

import jakarta.persistence.Entity;
import lombok.Data;

@RestController
@RequestMapping("/bank")
public class BankController {
	
	@Autowired
	private IBankService bankservice;
	
	@PostMapping
	public List<Bank> saveAll(@RequestBody List<Bank> banks)
	{
		return bankservice.saveAll(banks);
	}
	
	@GetMapping
	public List<Bank> findAll()
	{
		return bankservice.findAll();
	}
	
	@DeleteMapping("/{bankid}")
	public void deleteById(@PathVariable int bankid)
	{
		 bankservice.deleteById(bankid);
	}
	
	
	
	@PutMapping
	public Bank saveAll(@RequestBody Bank bank)
	{
		return bankservice.save(bank);
	}
	
	
	

}
