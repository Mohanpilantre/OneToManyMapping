package com.demo.service;

import java.util.List;

import com.demo.model.Bank;

public interface BankService {

	public Bank saveBank(Bank bank);

	public List<Bank> getAllData(Bank bank);

	public Bank getBankAndCustomerById(Integer id);

}
