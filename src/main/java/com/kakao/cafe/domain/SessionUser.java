package com.kakao.cafe.domain;

public class SessionUser {
    private final int id;
    private final String userName;
    private final String accessToken;

    public SessionUser(int id, String userName, String accessToken) {
        this.id = id;
        this.userName = userName;
        this.accessToken = accessToken;
    }

    public int getId() {
        return id;
    }

    public static SessionUser from(User user, String accessToken) {
        return new SessionUser(user.getId(), user.getUserName(), accessToken);
    }
}
