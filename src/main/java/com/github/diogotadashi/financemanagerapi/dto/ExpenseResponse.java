package com.github.diogotadashi.financemanagerapi.dto;

import com.github.diogotadashi.financemanagerapi.entity.Expense;
import com.github.diogotadashi.financemanagerapi.enums.Category;
import com.github.diogotadashi.financemanagerapi.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ExpenseResponse(
        Long id,
        String description,
        BigDecimal amount,
        LocalDateTime date,
        Category category,
        TransactionType type
) {
    public static ExpenseResponse from(Expense expense) {
        return new ExpenseResponse(
                expense.getId(),
                expense.getDescription(),
                expense.getAmount(),
                expense.getDate(),
                expense.getCategory(),
                expense.getType()
        );
    }
}
