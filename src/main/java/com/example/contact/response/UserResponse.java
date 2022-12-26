package com.example.contact.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserResponse {

    private String message;
    private LocalDateTime date;

}
