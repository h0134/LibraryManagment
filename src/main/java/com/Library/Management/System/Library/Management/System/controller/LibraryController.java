package com.Library.Management.System.Library.Management.System.controller;

import com.Library.Management.System.Library.Management.System.dto.*;
import com.Library.Management.System.Library.Management.System.response.BookResponse;
import com.Library.Management.System.Library.Management.System.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {

    private final BookService bookService;

    @Autowired
    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping("/books/issue")
    public ResponseEntity<ResponseDTO> issueBook(@RequestBody IssueRequest request) {
        try {
            bookService.issueBook(request);
            return ResponseEntity.ok(new ResponseDTO("success", "Book issued successfully.", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO("error", "Failed to issue book.", null));
        }
    }

    @PostMapping("/books/return")
    public ResponseEntity<ResponseDTO> returnBook(@RequestBody ReturnRequest request) {
        try {
            bookService.returnBook(request);
            return ResponseEntity.ok(new ResponseDTO("success", "Book returned successfully.", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO("error", "Failed to return book.", null));
        }
    }

    @GetMapping("/books")
    public ResponseEntity<ResponseDTO> getAllBooks() {
        try {
            List<BookResponse> books = bookService.getAllBooks();
            return ResponseEntity.ok(new ResponseDTO("success", "Books fetched successfully.", books));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO("error", "Failed to fetch books.", null));
        }
    }

    @GetMapping("/books/search")
    public ResponseEntity<ResponseDTO> searchBooks(@RequestParam String title) {
        try {
            List<BookResponse> books = bookService.searchBooks(title);
            return ResponseEntity.ok(new ResponseDTO("success", "Books found successfully.", books));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO("error", "Failed to search books.", null));
        }
    }

    @PostMapping("/books")
    public ResponseEntity<ResponseDTO> addBook(@RequestBody BookRequest bookRequest) {
        try {
            BookResponse bookResponse = bookService.addBook(bookRequest);
            return ResponseEntity.ok(new ResponseDTO("success", "Book added successfully.", bookResponse));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO("error", "Failed to add book.", null));
        }
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseDTO> addUser(@RequestBody UserRequest userRequest) {
        try {
            bookService.addUser(userRequest);
            return ResponseEntity.ok(new ResponseDTO("success", "User added successfully.", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO("error", "Failed to add user.", null));
        }
    }
}

