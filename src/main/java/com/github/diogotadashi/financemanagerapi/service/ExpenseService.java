package com.github.diogotadashi.financemanagerapi.service;

import com.github.diogotadashi.financemanagerapi.dto.ExpenseRequest;
import com.github.diogotadashi.financemanagerapi.dto.ExpenseResponse;
import com.github.diogotadashi.financemanagerapi.entity.Expense;
import com.github.diogotadashi.financemanagerapi.exception.ExpenseNotFoundException;
import com.github.diogotadashi.financemanagerapi.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {this.repository = repository;}

    public ExpenseResponse save(ExpenseRequest request) {
        Expense expense = Expense.builder()
                .description(request.description())
                .amount(request.amount())
                .category(request.category())
                .type(request.type())
                .build();

        Expense savedExpense = repository.save(expense);
        return ExpenseResponse.from(savedExpense);
    }

    public ExpenseResponse update(long id,ExpenseRequest request) {
        Expense expense = findExpenseById(id);

        expense.setDescription(request.description());
        expense.setAmount(request.amount());
        expense.setCategory(request.category());

        Expense savedExpense = repository.save(expense);
        return ExpenseResponse.from(savedExpense);
    }

    public List<ExpenseResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(ExpenseResponse::from)
                .toList();
    }

    public Expense findExpenseById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ExpenseNotFoundException("Expense with id: " + id + " not found"));
    }

    public ExpenseResponse findById(Long id) {
        return ExpenseResponse.from(findExpenseById(id));
    }

    public void delete(Long id) {
        findExpenseById(id);
        repository.deleteById(id);
    }
}
