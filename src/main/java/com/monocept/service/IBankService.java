package com.monocept.service;

import java.util.List;

import com.monocept.entity.Bank;

public interface IBankService {

	List<Bank> saveAll(List<Bank> banks);

	List<Bank> findAll();

	void deleteById(int bankid);

	Bank save(Bank bank);

}
