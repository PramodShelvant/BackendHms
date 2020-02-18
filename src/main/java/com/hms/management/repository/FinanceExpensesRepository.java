package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.FinanceExpenses;

public interface FinanceExpensesRepository extends JpaRepository<FinanceExpenses, Integer>{

}
