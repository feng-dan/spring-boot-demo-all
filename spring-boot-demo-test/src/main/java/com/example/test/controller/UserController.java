package com.example.test.controller;

import com.example.test.controller.vo.UserVO;
import com.example.test.convert.UserConvert;
import com.example.test.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @author fengdan
 */
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 获得指定用户编号的用户
     *
     * @param userId 用户编号
     * @return UserVO
     */
    @GetMapping("/get")
    public UserVO getUser(@RequestParam(value = "id") @NotNull(message = "id不能为空") Long userId) {
        return UserConvert.INSTANCE.toUserVo(userService.getByIdUser(userId));
    }
}
