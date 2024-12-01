package com.sqc.academy.library.dtos.response;

import java.math.BigDecimal;

import com.sqc.academy.library.entities.enums.FineStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FineResponse {
    Long fineId;
    Long borrowingId;
    BigDecimal amount;
    BigDecimal paidAmount;
    FineStatus status;
}