package com.Gayathri.SpendSence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Gayathri.SpendSence.model.Expense;
@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Long>{
	public abstract List<Expense>findByCategory(String category);

	

}
