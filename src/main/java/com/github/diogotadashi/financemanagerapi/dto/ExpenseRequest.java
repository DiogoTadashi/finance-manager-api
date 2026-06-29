package com.github.diogotadashi.financemanagerapi.dto;

import com.github.diogotadashi.financemanagerapi.enums.Category;
import com.github.diogotadashi.financemanagerapi.enums.TransactionType;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseRequest(

        String description,

        @NotNull
        BigDecimal amount,

        @NotNull
        Category category,

        @NotNull
        TransactionType type
        ){
}
