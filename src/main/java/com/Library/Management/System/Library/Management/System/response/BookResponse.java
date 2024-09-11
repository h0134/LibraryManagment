package com.Library.Management.System.Library.Management.System.response;

import com.Library.Management.System.Library.Management.System.enumm.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
 @AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private BookStatus status;


}

























