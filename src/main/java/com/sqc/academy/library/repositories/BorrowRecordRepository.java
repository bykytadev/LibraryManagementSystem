package com.sqc.academy.library.repositories;

import java.time.LocalDate;
import java.util.List;

import com.sqc.academy.library.entities.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Integer> {

    @Query("SELECT br FROM BorrowRecord br WHERE " +
            "(:userId IS NULL OR br.user.id = :userId) AND " +
            "(:bookId IS NULL OR br.book.id = :bookId) AND " +
            "(:isReturned IS NULL OR (:isReturned = true AND br.returnDate IS NOT NULL) OR (:isReturned = false AND br.returnDate IS NULL)) AND "
            +
            "(:startDate IS NULL OR br.borrowDate >= :startDate) AND " +
            "(:endDate IS NULL OR br.borrowDate <= :endDate)")
    List<BorrowRecord> search(
            @Param("userId") String userId,
            @Param("bookId") Integer bookId,
            @Param("isReturned") Boolean isReturned,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
}