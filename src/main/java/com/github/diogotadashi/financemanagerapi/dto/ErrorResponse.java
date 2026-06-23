package com.github.diogotadashi.financemanagerapi.dto;

import java.time.LocalDateTime;

public record ErrorResponse(int status,
                           String message,
                           LocalDateTime dateError) {
}
