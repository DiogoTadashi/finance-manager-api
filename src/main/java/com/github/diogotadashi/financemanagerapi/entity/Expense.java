package com.github.diogotadashi.financemanagerapi.entity;

import com.github.diogotadashi.financemanagerapi.enums.Category;
import com.github.diogotadashi.financemanagerapi.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @NotNull(message = "Quantity cannot be null")
    @Positive(message = "Quantity must be greater than zero")
    private BigDecimal amount;

    @CreationTimestamp
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private TransactionType type;
}
