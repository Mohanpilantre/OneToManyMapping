package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Bank;
import com.demo.repository.BankRepository;
import com.demo.service.BankService;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankRepository bankRepository;

	@Override
	public Bank saveBank(Bank bank) {
		Bank bank1 = bankRepository.save(bank);
		return bank1;
	}

	@Override
	public List<Bank> getAllData(Bank bank) {
		List<Bank> list = bankRepository.findAll();
		return list;
	}

	@Override
	public Bank getBankAndCustomerById(Integer id) {
		Bank bank = bankRepository.findBankAndCustomerById(id);
		return bank;
	}

}
