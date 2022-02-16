package com.kakao.cafe.service;

import com.kakao.cafe.domain.SessionUser;
import com.kakao.cafe.domain.User;
import com.kakao.cafe.repository.UserRepository;
import com.kakao.cafe.response.ProfileResponse;
import com.kakao.cafe.response.UserListResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public SessionUser register(User user) {
        userRepository.save(user);
        return SessionUser.from(user);
    }

    public List<UserListResponse> getUserList() {
        return userRepository.findAll()
                .stream()
                .map(UserListResponse::of)
                .collect(Collectors.toList());
    }

    public ProfileResponse getProfile(int id) {
        User user = userRepository.findById(id);
        return ProfileResponse.of(user);
    }

    public User findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }
}
