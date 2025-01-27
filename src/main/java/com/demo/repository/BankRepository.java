package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {

	public Bank findBankAndCustomerById(Integer id);
}

