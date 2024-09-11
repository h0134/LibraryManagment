package com.Library.Management.System.Library.Management.System.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReturnRequest {
    private Long userId;
    private Long bookId;
}

