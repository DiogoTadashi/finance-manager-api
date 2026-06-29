package com.github.diogotadashi.financemanagerapi.controller;

import com.github.diogotadashi.financemanagerapi.dto.ExpenseRequest;
import com.github.diogotadashi.financemanagerapi.dto.ExpenseResponse;
import com.github.diogotadashi.financemanagerapi.entity.Expense;
import com.github.diogotadashi.financemanagerapi.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("")
    public ResponseEntity<ExpenseResponse> createExpense(@RequestBody @Valid ExpenseRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(expenseService.save(request));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ExpenseResponse>> findAll() {
        List<ExpenseResponse> expenseList = expenseService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(expenseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponse> findById(@PathVariable Long id) {
        ExpenseResponse response = expenseService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseResponse> updateExpense(@PathVariable Long id, @RequestBody @Valid ExpenseRequest request) {
        ExpenseResponse response = expenseService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        expenseService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
