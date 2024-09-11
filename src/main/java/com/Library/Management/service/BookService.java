package com.Library.Management.service;
import com.Library.Management.dto.BookRequest;
import com.Library.Management.dto.IssueRequest;
import com.Library.Management.dto.ReturnRequest;
import com.Library.Management.dto.UserRequest;
import com.Library.Management.entity.IssuedBook;
import com.Library.Management.entity.Book;

import com.Library.Management.entity.User;
import com.Library.Management.enumm.BookStatus;
import com.Library.Management.repo.BookRepository;
import com.Library.Management.repo.IssuedBookRepository;
import com.Library.Management.repo.UserRepository;
import com.Library.Management.response.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private IssuedBookRepository issuedBookRepository;

    @Autowired
    private UserRepository userRepository;


    public void issueBook(IssueRequest request) {
     Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + request.getBookId()));

     User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + request.getUserId()));

        if (book.getStatus() != BookStatus.AVAILABLE) {
            throw new RuntimeException("Book is already issued.");
        }

        book.setStatus(BookStatus.ISSUED);
        bookRepository.save(book);

        IssuedBook issuedBook = new IssuedBook();
        issuedBook.setUserId(request.getUserId());
        issuedBook.setBook(book);
        issuedBook.setIssueDate(new Date());
        issuedBook.setReturnDate(null);
        issuedBookRepository.save(issuedBook);
    }


        public void returnBook(ReturnRequest request) {
            IssuedBook issuedBook = issuedBookRepository.findByUserIdAndBookId(request.getUserId(), request.getBookId())
                    .orElseThrow(() -> new RuntimeException("Issue record not found with user ID: " + request.getUserId() + " and book ID: " + request.getBookId()));

            issuedBook.setReturnDate(new Date());
            issuedBookRepository.save(issuedBook);

            Book book = bookRepository.findById(request.getBookId())
                    .orElseThrow(() -> new RuntimeException("Book not found with ID: " + request.getBookId()));

            book.setStatus(BookStatus.AVAILABLE);
            bookRepository.save(book);
        }



    public List<BookResponse> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(this::convertToBookResponse).collect(Collectors.toList());
    }

    public List<BookResponse> searchBooks(String title) {
        List<Book> books = bookRepository.findByTitleContainingIgnoreCase(title);
        return books.stream().map(this::convertToBookResponse).collect(Collectors.toList());
    }

    public BookResponse addBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setStatus(BookStatus.AVAILABLE);

        Book savedBook = bookRepository.save(book);

        return convertToBookResponse(savedBook);
    }

    public void addUser(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        userRepository.save(user);
    }

    public BookResponse convertToBookResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getStatus()
        );
    }

}
