package com.blogapp.techviz.base.ExceptionHandling;

/*
Create an Error response POJO object, main fields can be status, message, and time stamp
we can also add any more fields if required.
 */
public class UserErrorResponse {

    private int status; //status should be int
    private String message;

    private long timestamp;

    public UserErrorResponse() {
    }

    public UserErrorResponse(int status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
