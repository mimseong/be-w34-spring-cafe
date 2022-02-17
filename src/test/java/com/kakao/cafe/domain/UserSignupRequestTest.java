package com.kakao.cafe.domain;

import com.kakao.cafe.request.UserSignupRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserSignupRequestTest {

    private final int INITIAL_ID = 0;
    private final String userId = "userId";
    private final String name = "name";
    private final String email = "email";
    private final String accessToken = "accessToken";
    private final String scope = "scope";

    @Test
    @DisplayName("[성공] UserSignupRequest 객체를 생성한다")
    void UserSignupRequest() {
        new UserSignupRequest(userId, name, email, accessToken, scope);
    }

    @Test
    @DisplayName("[성공] Entitty로 올바르게 변환한다")
    void toEntity() {
        UserSignupRequest userSignupRequest = new UserSignupRequest(userId, name, email, accessToken, scope);
        User user_Answer = new User(INITIAL_ID, userId, name, email, scope);

        User user = userSignupRequest.toEntity();

        Assertions.assertEquals(user, user_Answer);
    }
}
