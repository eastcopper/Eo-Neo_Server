package com.example.eo_neo.domain.auth.presentation.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SignUpRequest {
    @NotNull
    private String accountId;

    private String nickName;

    @NotNull
    private String password;
}
