package com.Library.Management.System.Library.Management.System.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDTO {
    private String status;
    private String message;
    private Object data;
}
