package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Bank;
import com.demo.model.Customer;
import com.demo.service.BankService;
import com.demo.service.CustomerService;

@RestController
public class BankCustomerController {

	@Autowired
	private BankService bankService;

	@Autowired
	private CustomerService customerService;

	@PostMapping("/saveBankDetails")
	public Bank saveBankDetails(@RequestBody Bank bank) {
		Bank bank1 = bankService.saveBank(bank);
		List<Customer> list = bank.getCustomerList();
		for (Customer customer : list) {
			customer.setBankId(bank.getId());
			customerService.saveCustomer(customer);
		}
		return bank1;
	}

	@GetMapping("/getAllData")
	public List<Bank> getAllData(Bank bank) {
		List<Bank> list = bankService.getAllData(bank);
		return list;
	}

	@GetMapping("/getBankAndCustomerById/{id}")
	public Bank getBankAndCustomerById(@PathVariable("id") Integer id) {
		Bank bank = bankService.getBankAndCustomerById(id);
		return bank;
	}
}
