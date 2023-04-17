package com.monocept.service;

import java.util.List;

import com.monocept.entity.Transaction;

public interface ITransactionService {

	List<Transaction> saveAll(List<Transaction> transactions);

	List<Transaction> findAll();

	Transaction save(Transaction transaction);

	void deleteById(int transactionid);

}
