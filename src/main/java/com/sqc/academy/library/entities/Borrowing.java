package com.sqc.academy.library.entities;

import java.time.LocalDate;

import com.sqc.academy.library.entities.enums.BorrowingStatus;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "borrowings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Borrowing extends EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowing_id")
    Long borrowingId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    Book book;

    @Column(name = "borrow_date", nullable = false)
    LocalDate borrowDate;

    @Column(name = "due_date", nullable = false)
    LocalDate dueDate; // thời gian dự kiến trả sách

    @Column(name = "return_date", nullable = true)
    LocalDate returnDate; // thời gian thực tế trả sách

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, columnDefinition = "VARCHAR(20) DEFAULT 'BORROWED'")
    BorrowingStatus status;
}