package com.example.sprint_1.dto.security.payload.request;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    private String username;
    private String password;
}
