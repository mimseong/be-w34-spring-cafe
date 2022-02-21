package com.kakao.cafe.controller;

import com.kakao.cafe.domain.SessionUser;
import com.kakao.cafe.domain.User;
import com.kakao.cafe.request.UserSignupRequest;
import com.kakao.cafe.response.ProfileResponse;
import com.kakao.cafe.response.UserListResponse;
import com.kakao.cafe.service.UserService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private static final String SESSION = "sessionUser";
    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String userList(Model model) {
        logger.info("[GET] 회원 목록 조회");

        List<UserListResponse> userList = userService.getUserList();
        model.addAttribute("userList", userList);

        return "user/list";
    }

    @GetMapping("/{id}")
    public String userProfile(@PathVariable int id, Model model) {
        logger.info("[GET] /{id} 프로필 조회");

        ProfileResponse profile = userService.getProfile(id);
        model.addAttribute("profile", profile);

        return "user/profile";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserSignupRequest userDto, HttpSession session) {
        logger.info("[POST] /login 로그인");
        logger.info("user DTO: " + userDto);

        String accessToken = userDto.getAccessToken();
        User user = userDto.toEntity();

        if (userService.findByUserId(user.getUserId()) == null) {
            userService.register(user);
        }
        session.setAttribute(SESSION, SessionUser.from(user, accessToken));
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        logger.info("[GET] /logout 로그아웃");
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/unlink")
    public String unlink(HttpSession session) {
        logger.info("[GET] /unlink 로그아웃");
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/test")
    public String test(HttpSession session) {
        logger.info("[GET] /test 받았습니다");
        return "redirect:/";
    }
}
