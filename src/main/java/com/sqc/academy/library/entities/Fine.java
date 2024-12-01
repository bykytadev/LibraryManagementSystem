package com.sqc.academy.library.entities;

import java.math.BigDecimal;

import com.sqc.academy.library.entities.enums.FineStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "fines")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Fine extends EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fine_id")
    Long fineId;

    @ManyToOne
    @JoinColumn(name = "borrowing_id", nullable = false)
    Borrowing borrowing;

    @Column(name = "amount", nullable = false, columnDefinition = "DECIMAL(10,2)")
    BigDecimal amount;

    @Column(name = "paid_amount", nullable = false, columnDefinition = "DECIMAL(10,2) DEFAULT 0")
    BigDecimal paidAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, columnDefinition = "VARCHAR(20) DEFAULT 'UNPAID'")
    FineStatus status;
}