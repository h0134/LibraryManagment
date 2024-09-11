package com.Library.Management.System.Library.Management.System.entity;

import com.Library.Management.System.Library.Management.System.enumm.BookStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    @Enumerated(EnumType.STRING)
    private BookStatus status;
}
