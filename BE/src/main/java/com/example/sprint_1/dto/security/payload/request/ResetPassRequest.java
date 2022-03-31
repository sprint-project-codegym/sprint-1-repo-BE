package com.example.sprint_1.dto.security.payload.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResetPassRequest {
    private String password;
    private String code;
}
