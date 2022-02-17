package com.kakao.cafe.domain;

import java.util.Objects;

public class User {

    private final int id;
    private final String userId;
    private final String name;
    private final String email;
    private final String scope;

    public User(int id, String userId, String name, String email, String scope) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.scope = scope;
    }

    public int getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getScope() {
        return scope;
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
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User id: " + id +
                ", userId: " + userId +
                ", name: " + name +
                ", email: " + email;
    }
}
