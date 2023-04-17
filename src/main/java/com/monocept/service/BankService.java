package com.monocept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.monocept.entity.Bank;
import com.monocept.repository.BankRepository;

import org.springframework.stereotype.Service;

@Service
public class BankService implements IBankService {

	@Autowired
	private BankRepository bankRepository;
	
	@Override
	public List<Bank> saveAll(List<Bank> banks) {
		
		return bankRepository.saveAll(banks);
		
	}

	@Override
	public List<Bank> findAll() {
		// TODO Auto-generated method stub
		return bankRepository.findAll();
	}

	@Override
	public void deleteById(int bankid) {
		bankRepository.deleteById(bankid);
		
	}

	@Override
	public Bank save(Bank bank) {
		// TODO Auto-generated method stub
		return bankRepository.save(bank);
	}

}
