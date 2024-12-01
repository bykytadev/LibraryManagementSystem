package com.sqc.academy.library.dtos.request;

import java.math.BigDecimal;

import com.sqc.academy.library.entities.enums.FineStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FineRequest {

    @NotNull(message = "Borrowing ID is mandatory")
    Long borrowingId;

    @NotNull(message = "Amount is mandatory")
    @Min(value = 0, message = "Amount must be at least 0")
    BigDecimal amount;

    @NotNull(message = "Paid amount is mandatory")
    @Min(value = 0, message = "Paid amount must be at least 0")
    BigDecimal paidAmount;

    @NotNull(message = "Status is mandatory")
    FineStatus status;
}