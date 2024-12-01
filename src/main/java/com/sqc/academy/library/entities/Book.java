package com.sqc.academy.library.entities;

import com.sqc.academy.library.entities.enums.BookStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    Long bookId;

    @Column(name = "title", nullable = false, length = 200)
    String title;

    @Column(name = "author", nullable = false, length = 100)
    String author;

    @Column(name = "general", length = 50)
    String general;

    @Column(name = "quantity", nullable = false)
    int quantity;

    @Column(name = "available_quantity", nullable = false)
    int availableQuantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, columnDefinition = "VARCHAR(20) DEFAULT 'AVAILABLE'")
    BookStatus status;

    public boolean isBorrowed() {
        return availableQuantity < quantity;
    }
}