package com.example.contact.response;

import lombok.Data;

@Data
public class ErrorResponse {

    private Integer status;
    private String message;
    private String date_time;
}
