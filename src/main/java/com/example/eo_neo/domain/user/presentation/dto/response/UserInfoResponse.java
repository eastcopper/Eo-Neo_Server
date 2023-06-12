package com.example.eo_neo.domain.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserInfoResponse {

    private final String accountId;

    private final String nickName;

    private final int CorrectBasic;

    private final int CorrectLanguage;

    private final int CorrectConversation;

    private final int CorrectWord;
}
