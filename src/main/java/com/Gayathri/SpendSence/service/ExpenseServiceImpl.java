package com.Gayathri.SpendSence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gayathri.SpendSence.exception.ExpenseNotFoundException;
import com.Gayathri.SpendSence.model.Expense;
import com.Gayathri.SpendSence.repo.ExpenseRepo;

//how to do
//perform business logic
@Service
public class ExpenseServiceImpl implements ExpenseService {
	@Autowired
	ExpenseRepo expenseRepo;

	@Override
	public Expense createExpense(Expense expense) {
		return expenseRepo.save(expense);//insert
	}

	@Override
	public List<Expense> getAllExpenses() {
		return expenseRepo.findAll();//select * from 
	}

	@Override
	public Expense getExpenseById(Long id) {
		return expenseRepo.findById(id)
				.orElseThrow(()-> new ExpenseNotFoundException("Expense Not Found With ID:"+id));
	}

	@Override
	public Expense updateExpenseById(Expense expense,Long id) {
		Expense expenseFromDb = getExpenseById(id);
		
		expenseFromDb.setAmount(expense.getAmount());
		expenseFromDb.setCategory(expense.getCategory());
		expenseFromDb.setExpenseDate(expense.getExpenseDate());
		expenseFromDb.setPaymentMode(expense.getPaymentMode());
		expenseFromDb.setTitle(expense.getTitle());

		return expenseRepo.save(expenseFromDb);
	}

	@Override
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}

	@Override
	public List<Expense> getExpensesByCategory(String category) {
		
		return expenseRepo.findByCategory(category);
	}

}
