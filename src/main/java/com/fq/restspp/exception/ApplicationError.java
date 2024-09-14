package com.fq.restspp.exception;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class ApplicationError{

    private String status;
    private String errorMessage;
    private LocalDateTime timestamp;

    ApplicationError(String status, String errorMessage) {
        this.status =status;
        this.errorMessage = errorMessage;
        this.timestamp = LocalDateTime.now();
    }
}
