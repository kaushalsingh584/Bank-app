package com.monocept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Account;
import com.monocept.repository.AccountRepository;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private AccountRepository AccountRepository;
	
	@Override
	public List<Account> saveAll(List<Account> Accounts) {
		
		return AccountRepository.saveAll(Accounts);
		
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return AccountRepository.findAll();
	}

	@Override
	public void deleteById(int Accountid) {
		AccountRepository.deleteById(Accountid);
		
	}

	@Override
	public Account save(Account account) {
		
		return AccountRepository.save(account);
	}

}
