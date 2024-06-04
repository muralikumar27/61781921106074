package org.question1.question1calculator.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthResult {
    private String token_type;
    private String access_token;

    private long expires_in;
}
