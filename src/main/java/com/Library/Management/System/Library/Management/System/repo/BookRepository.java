package com.Library.Management.System.Library.Management.System.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.Library.Management.System.Library.Management.System.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT * FROM book WHERE LOWER(title) LIKE LOWER(CONCAT('%', :title, '%'))", nativeQuery = true)
    List<Book> findByTitleContainingIgnoreCase(String title);

}


