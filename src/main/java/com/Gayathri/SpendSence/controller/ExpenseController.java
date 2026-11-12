package com.Gayathri.SpendSence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gayathri.SpendSence.model.Expense;
import com.Gayathri.SpendSence.service.ExpenseService;

//http://localhost:3333/expense/crExp
@CrossOrigin(origins = "http://localhost:5173")
@RestController // for mapping
@RequestMapping("/expense")
public class ExpenseController {
	@Autowired
	ExpenseService expenseService;

	@PostMapping("/crExp")
	ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(expenseService.createExpense(expense));
			
	}

	@GetMapping("getExpenses")
	List<Expense> getAllExpenses() {
		return expenseService.getAllExpenses();
	}
	
	@GetMapping("/getExpId/{id}")
	Expense getExpenseById(@PathVariable Long id) {
	return expenseService.getExpenseById(id);
	}
	
	@DeleteMapping("/delExpId/{id}")
	String deleteExpense(@PathVariable Long id) {
		expenseService.deleteExpense(id);
		return "Deleted Expense successfully with the id of:"+id;
		
	}
	
	@PutMapping("/updExById/{id}")
	Expense updateExpenseById(@RequestBody Expense expense,@PathVariable Long id) {
		return expenseService.updateExpenseById(expense, id);
		
	}
	@GetMapping("/getExByCat/{category}")
	List<Expense> getExpensesByCategory(@PathVariable String category){
		return expenseService.getExpensesByCategory(category);
	}

}
