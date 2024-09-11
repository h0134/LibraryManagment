package com.Library.Management.repo;


import com.Library.Management.entity.IssuedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IssuedBookRepository extends JpaRepository<IssuedBook, Long> {
    @Query(value = "SELECT * FROM issued_book WHERE user_id = :userId AND book_id = :bookId", nativeQuery = true)
    Optional<IssuedBook> findByUserIdAndBookId(Long userId, Long bookId);
}