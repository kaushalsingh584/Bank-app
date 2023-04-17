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

import com.monocept.entity.Transaction;
import com.monocept.service.ITransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private ITransactionService Transactionservice;
	
	@PostMapping
	public Transaction save(@RequestBody Transaction transactions)
	{
		return Transactionservice.save(transactions);
	}
	
	@GetMapping
	public List<Transaction> findAll()
	{
		return Transactionservice.findAll();
	}
	
	@DeleteMapping("/{Transactionid}")
	public void deleteById(@PathVariable int transactionid)
	{
		 Transactionservice.deleteById(transactionid);
	}
	
	
	
	@PutMapping
	public Transaction update(@RequestBody Transaction transaction)
	{
		return Transactionservice.save(transaction);
	}
}
