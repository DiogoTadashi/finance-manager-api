package com.github.diogotadashi.financemanagerapi.service;

import com.github.diogotadashi.financemanagerapi.dto.ExpenseRequest;
import com.github.diogotadashi.financemanagerapi.dto.ExpenseResponse;
import com.github.diogotadashi.financemanagerapi.entity.Expense;
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
}
