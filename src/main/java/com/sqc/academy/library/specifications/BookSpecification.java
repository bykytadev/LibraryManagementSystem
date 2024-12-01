package com.sqc.academy.library.specifications;

import com.sqc.academy.library.entities.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {

    public static Specification<Book> hasBookId(Long bookId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("bookId"), bookId);
    }

    public static Specification<Book> hasTitle(String title) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), "%" + title + "%");
    }

    public static Specification<Book> hasAuthor(String author) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("author"), "%" + author + "%");
    }

    public static Specification<Book> hasGeneral(String general) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("general"), "%" + general + "%");
    }

    public static Specification<Book> hasQuantityFrom(Integer quantityFrom) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("quantity"),
                quantityFrom);
    }

    public static Specification<Book> hasQuantityTo(Integer quantityTo) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("quantity"), quantityTo);
    }

    public static Specification<Book> hasAvailableQuantityFrom(Integer availableQuantityFrom) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("availableQuantity"),
                availableQuantityFrom);
    }

    public static Specification<Book> hasAvailableQuantityTo(Integer availableQuantityTo) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("availableQuantity"),
                availableQuantityTo);
    }
}