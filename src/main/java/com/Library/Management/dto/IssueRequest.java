package com.Library.Management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class IssueRequest {
    private Long userId;
    private Long bookId;
    private Number numberOfDays;
}
