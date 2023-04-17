package com.monocept.service;

import java.util.List;

import com.monocept.entity.Account;

public interface IAccountService {

	List<Account> saveAll(List<Account> accounts);

	List<Account> findAll();

	void deleteById(int accountid);

	Account save(Account account);

}
