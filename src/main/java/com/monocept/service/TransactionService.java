package com.monocept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Account;
import com.monocept.entity.Customer;
import com.monocept.entity.Transaction;
import com.monocept.exception.NotSufficentBalanceException;
import com.monocept.repository.AccountRepository;
import com.monocept.repository.CustomerRepository;
import com.monocept.repository.TransactionRepository;

@Service
public class TransactionService implements ITransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<Transaction> saveAll(List<Transaction> transactions) {

		return transactionRepository.saveAll(transactions);

	}

	@Override
	public List<Transaction> findAll() {
		// TODO Auto-generated method stub
		return transactionRepository.findAll();
	}

	@Override
	public void deleteById(int transactionid) {
		transactionRepository.deleteById(transactionid);

	}

	@Override
	public Transaction save(Transaction transaction) {
		// TODO Auto-generated method stub

		Integer senderAccNo = transaction.getSenderAccNo();
		Integer receiverAccNo = transaction.getReceiverAccNo();

		if (senderAccNo == null && receiverAccNo == null)
			throw new NotSufficentBalanceException("Not valid values");
		else if (senderAccNo == null) {
			Account receiver = accountRepository.findById(receiverAccNo).orElseThrow();

			receiver.setBalance(receiver.getBalance() + transaction.getAmount());
			transaction.setTransactionType("deposit");
			accountRepository.save(receiver);
			return transactionRepository.save(transaction);

		} else if (receiverAccNo == null) {

			Account sender = accountRepository.findById(senderAccNo).orElseThrow();
			if (sender.getBalance() >= transaction.getAmount()) {
				sender.setBalance(sender.getBalance() - transaction.getAmount());
				accountRepository.save(sender);
				transaction.setTransactionType("withdraw");
				return transactionRepository.save(transaction);
			}
		} else {
			
			Account sender = accountRepository.findById(senderAccNo).orElseThrow();
			Account receiver = accountRepository.findById(receiverAccNo).orElseThrow();
			
			if (sender.getBalance() >= transaction.getAmount()) {
				sender.setBalance(sender.getBalance() - transaction.getAmount());
				receiver.setBalance(receiver.getBalance() + transaction.getAmount());
				accountRepository.save(sender);
				accountRepository.save(receiver);
				transaction.setTransactionType("transfer");
				return transactionRepository.save(transaction);
			}

		}

		throw new NotSufficentBalanceException("Account No- " + senderAccNo + " does not enough balance");
	}
}
