package com.blogapp.techviz.base.ExceptionHandling;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {

    private String message;
    private int status;

    private long timeStamp;

    public ErrorResponse(String message, int status, long timeStamp) {
        this.message = message;
        this.status = status;
        this.timeStamp = timeStamp;
    }
}
