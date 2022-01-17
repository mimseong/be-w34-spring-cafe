package com.kakao.cafe.domain;

import java.util.Objects;

public class User {

    private static final String INITIAL_ID = "INITIAL_ID";
    private String uuid;
    private final String userId;
    private final String password;
    private final String name;
    private final String email;

    public User(String uuid, String userId, String password, String name, String email) {
        this.uuid = uuid == null ? INITIAL_ID : uuid;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public String getUuid() {
        return uuid;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User that = (User) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
